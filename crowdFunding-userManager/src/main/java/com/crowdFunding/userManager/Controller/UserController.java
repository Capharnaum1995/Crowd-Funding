package com.crowdFunding.userManager.Controller;

import com.crowdFunding.common.api.DatabaseRemoteOperationService;
import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.LoginInByAPInfoDTO;
import com.crowdFunding.common.dto.UserInfoDTO;
import com.crowdFunding.common.dto.UserLogInSuccessDTO;
import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.api.RedisRemoteOperationService;
import com.crowdFunding.common.utils.CommonUtils;
import com.crowdFunding.common.utils.SMS;
import com.crowdFunding.common.utils.SMSUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private RedisRemoteOperationService redisRemoteOperationService;

    @Autowired
    private DatabaseRemoteOperationService databaseRemoteOperationService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${sms.host}")
    private String host;

    @Value("${sms.path}")
    private String path;

    @Value("${sms.skin}")
    private String skin;

    @Value("${sms.sign}")
    private String sign;

    @Value("${sms.appCode}")
    private String appCode;

    /**
     * 获取验证码：将验证码发送给用户，并同时存入redis
     *
     * @param phoneNumber
     * @return
     */
    @RequestMapping("/send/message")
    public ResultEntity<String> sendMessage(@RequestParam("phoneNumber") String phoneNumber) {
        if (!CommonUtils.strCheckEffective(phoneNumber)) {
            return ResultEntity.failed(Constant.INVALID_PHONE_NUMBER);
        }
        //1.生成验证码
        String param = SMSUtils.generateRandomVerificationCode(Constant.VERIFICATION_CODE_LENGTH);
        //2.将验证码保存到redis中
        String key = Constant.VERIFICATION_PREFIX + phoneNumber;
        ResultEntity<String> resultEntity = redisRemoteOperationService.saveKeyValue(key, param, Constant.VERIFICATION_CODE_VALID_TIME);
        //3.1如果保存失败，返回
        //这里比较绕。ResultEntity.FAILED="FAILED",resultEntity.getStatus()=SUCCESS/FAILED。参照着ResultEntity这个类来参照着看，理解
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return resultEntity;
        } else {//3.2保存成功，则发送
            try {
                SMS sms = new SMS(host, path, sign, skin, param, phoneNumber, appCode);
                SMSUtils.sendMessage(sms);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
            return ResultEntity.successWithoutData();
        }
    }

    /**
     * 用户注册
     *
     * @param userRegistrationInfoDTO
     * @return
     */
    @RequestMapping("/user/register")
    public ResultEntity<String> register(@RequestBody() UserRegistrationInfoDTO userRegistrationInfoDTO) {
        //1.1 对提交上来的信息做有效性验证
        if (!CommonUtils.strCheckEffective(userRegistrationInfoDTO.getAccount())
        ) {
            return ResultEntity.failed(Constant.INVALID_ACCOUNT);
        }
        if (!CommonUtils.strCheckEffective(userRegistrationInfoDTO.getPassword())
        ) {
            return ResultEntity.failed(Constant.INVALID_PASSWORD);
        }
        if (!CommonUtils.strCheckEffective(userRegistrationInfoDTO.getPhoneNumber())
        ) {
            return ResultEntity.failed(Constant.INVALID_PHONE_NUMBER);
        }
        if (!CommonUtils.strCheckEffective(userRegistrationInfoDTO.getVerificationCode())
        ) {
            return ResultEntity.failed(Constant.INVALID_VERIFICATION_CODE);
        }
        //1.2 拼接好随机验证码的key
        String key = Constant.VERIFICATION_PREFIX + userRegistrationInfoDTO.getPhoneNumber();
        //1.3 根据key去取verificationCode,然后判断是否能取得到
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(key);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return resultEntity;
        }
        //1.4 若能取得到，拿来与用户注册表单发来的作对比
        if (!Objects.equals(resultEntity.getData(), userRegistrationInfoDTO.getVerificationCode())) {
            return ResultEntity.failed(Constant.VERIFICATION_CODE_MISS_MATCH);
        }
        //1.5 若验证码相匹配，则删除redis中的数据
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.removeByKey(key);
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return resultEntity1;
        }
        //1.6 若成功删除了redis中的缓存验证信息，到这一步已经算是验证成功了，下面将进行数据库的操作
        //----------------------------------------------------------------------------------------
        //2.1 查询数据库，获取该账户在数据库中的个数（检查该账号是否已经被注册）
        ResultEntity<Integer> resultEntity2 = databaseRemoteOperationService.getCountByAccount(userRegistrationInfoDTO.getAccount());
        if (ResultEntity.FAILED.equals(resultEntity2.getStatus())) {
            return ResultEntity.failed(resultEntity2.getMessage());
        }
        //2.2 查询操作成功执行，检查该账户是否已经被占用
        if (resultEntity2.getData() > 0) {
            return ResultEntity.failed(Constant.ACCOUNT_IS_OCCUPIED);
        }
        //2.3 若账号未被占用，则执行表的插入
        userRegistrationInfoDTO.setPassword(bCryptPasswordEncoder.encode(userRegistrationInfoDTO.getPassword()));
        ResultEntity<String> resultEntity3 = databaseRemoteOperationService.createUser(userRegistrationInfoDTO);
        if (ResultEntity.FAILED.equals(resultEntity3.getStatus())) {
            return resultEntity3;
        }
        //2.4 表插入成功
        return ResultEntity.successWithoutData();
    }

    /**
     * 用户登陆(账号-密码登陆)
     *
     * @param loginInByAPInfoDTO
     * @return
     */
    @RequestMapping("/log/in/by/account/and/password")
    public ResultEntity<UserLogInSuccessDTO> logInByAP(@RequestBody() LoginInByAPInfoDTO loginInByAPInfoDTO) {
        //1.1 校验账号和密码的格式是否正确
        if (!CommonUtils.strCheckEffective(loginInByAPInfoDTO.getAccount())) {
            return ResultEntity.failed(Constant.INVALID_ACCOUNT);
        }
        if (!CommonUtils.strCheckEffective(loginInByAPInfoDTO.getPassword())) {
            return ResultEntity.failed(Constant.INVALID_PASSWORD);
        }
        //1.2 若账号密码格式校验成功，则在数据库中查询对应的用户信息，封装后返回
        ResultEntity<UserInfoDTO> resultEntity = databaseRemoteOperationService.retrieveUserByAccount(loginInByAPInfoDTO.getAccount());
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(resultEntity.getMessage());
        }
        //1.3 返回成功的信息,即数据库中存在该用户，再进行密码校验
        if (!bCryptPasswordEncoder.matches(loginInByAPInfoDTO.getPassword(), resultEntity.getData().getPassword())) {
            return ResultEntity.failed(Constant.PASSWORD_MISS_MATCH);
        }
        //1.4 账号，密码都匹配下面进行令牌的生成
        //-----------------------------------------------------------------------
        //2.1 生成token-id的键值对存入Redis中
        String key = CommonUtils.generateToken();
        String value = resultEntity.getData().getId() + "";
        ResultEntity resultEntity1 = redisRemoteOperationService.saveKeyValue(key, value, Constant.TOKEN_VALID_TIME);
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return resultEntity1;
        }
        //2.1 token缓存成功，返回对象到前端
        UserLogInSuccessDTO userLogInSuccessDTO = new UserLogInSuccessDTO();
        BeanUtils.copyProperties(resultEntity.getData(), userLogInSuccessDTO);
        userLogInSuccessDTO.setToken(key);
        return ResultEntity.successWithData(userLogInSuccessDTO);
    }

    @RequestMapping("/log/out")
    public ResultEntity<String> logOut(@RequestParam("token") String token) {
        if (!CommonUtils.strCheckEffective(token)) {
            return ResultEntity.failed(Constant.VALID_TOKEN);
        }
        return redisRemoteOperationService.removeByKey(token);
    }
}
