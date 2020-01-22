package com.crowdFunding.databaseProvider.controller;

import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.utils.SMSUtils;
import com.crowdFunding.databaseProvider.service.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
        if (!SMSUtils.strCheckEffective(account)) {
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
        if (!SMSUtils.strCheckEffective(userRegistrationInfoDTO.getAccount())) {
            return ResultEntity.failed(Constant.INVALID_ACCOUNT);
        }
        if (!SMSUtils.strCheckEffective(userRegistrationInfoDTO.getPassword())
        ) {
            return ResultEntity.failed(Constant.INVALID_PASSWORD);
        }
        if (!SMSUtils.strCheckEffective(userRegistrationInfoDTO.getPhoneNumber())
        ) {
            return ResultEntity.failed(Constant.INVALID_PHONE_NUMBER);
        }
        if (!SMSUtils.strCheckEffective(userRegistrationInfoDTO.getVerificationCode())
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
 public ResultEntity<String> createUserHystrix(@RequestBody UserRegistrationInfoDTO userRegistrationInfoDTO) {
 return ResultEntity.failed(Constant.INSERT_DATABASE_FAILED_FUSE);
 }

 public ResultEntity<Integer> getCountByAccountHystrix(@RequestParam("account") String account) {
 return ResultEntity.failed(Constant.QUERY_DATABASE_FAILED_FUSE);
 }
 */
}
