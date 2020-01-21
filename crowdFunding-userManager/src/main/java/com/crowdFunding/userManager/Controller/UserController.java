package com.crowdFunding.userManager.Controller;

import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.api.RedisRemoteOperationService;
import com.crowdFunding.common.utils.SMS;
import com.crowdFunding.common.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private RedisRemoteOperationService redisRemoteOperationService;
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

    @RequestMapping("/send/message")
    ResultEntity<String> sendMessage(@RequestParam("phoneNumber") String phoneNumber) {
        if (!SMSUtils.strCheckEffective(phoneNumber)) {
            return ResultEntity.failed("手机号有误");
        }
        //1.生成验证码
        Integer integer = 4;
        String param = SMSUtils.generateRandomVerificationCode(integer);
        //2.将验证码保存到redis中
        Integer validTime = 1;
        String key = "RANDOM_CODE_" + phoneNumber;
        ResultEntity<String> resultEntity = redisRemoteOperationService.saveKeyValue(key, param, validTime);
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
}
