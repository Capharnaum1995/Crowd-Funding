package com.crowdFunding.databaseProvider.controller;

import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.UserInfoDTO;
import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.utils.CommonUtils;
import com.crowdFunding.databaseProvider.model.User;
import com.crowdFunding.databaseProvider.service.api.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 数据库操作，通过account获取用户的数量
     *
     * @param account
     * @return
     */
    @RequestMapping("/get/count/by/account")
    // @HystrixCommand(fallbackMethod = "getCountByAccountHystrix")
    public ResultEntity<Integer> getCountByAccount(@RequestParam("account") String account) {
        if (!CommonUtils.strCheckEffective(account)) {
            return ResultEntity.failed(Constant.INVALID_ACCOUNT);
        }
        try {
            Integer count = userService.getCountByAccount(account);
            return ResultEntity.successWithData(count);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 数据库操作，通过传来的用户信息向数据库添加用户
     *
     * @param userRegistrationInfoDTO
     * @return
     */
    @RequestMapping("/create/user")
    //@HystrixCommand(fallbackMethod = "createUserHystrix")
    public ResultEntity<String> createUser(@RequestBody UserRegistrationInfoDTO userRegistrationInfoDTO) {
        if (!CommonUtils.strCheckEffective(userRegistrationInfoDTO.getAccount())) {
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
        try {
            Integer integer = userService.createUser(userRegistrationInfoDTO);
            if (integer == 1) {
                return ResultEntity.successWithoutData();
            }
            return ResultEntity.failed(Constant.USER_INFO_FAILED_TO_WRITE_INTO_DATABASE);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 根据用户登陆时输入的账号，查询对应的用户信息并返回
     *
     * @param account
     * @return
     */
    @RequestMapping("/retrieve/user/by/account")
    ResultEntity<UserInfoDTO> retrieveUserByAccount(@RequestParam("account") String account) {
        //1.校验账号的格式是否正确
        if (!CommonUtils.strCheckEffective(account)) {
            return ResultEntity.failed(Constant.INVALID_ACCOUNT);
        }
        //2.从数据库中取出用户信息
        try {
            User user = userService.retrieveUserByAccount(account);
            //3.检查该用户是否存在
            if (user == null) {
                return ResultEntity.failed(Constant.ACCOUNT_DOES_NOT_EXISTS);
            }
            //4.若用户存在,返回用户信息
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            BeanUtils.copyProperties(user, userInfoDTO);
            return ResultEntity.successWithData(userInfoDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
/**
 public ResultEntity<String> createUserHystrix(@RequestBody UserRegistrationInfoDTO userRegistrationInfoDTO) {
 return ResultEntity.failed(Constant.INSERT_DATABASE_FAILED_FUSE);
 }

 public ResultEntity<Integer> getCountByAccountHystrix(@RequestParam("account") String account) {
 return ResultEntity.failed(Constant.QUERY_DATABASE_FAILED_FUSE);
 }
 */
}
