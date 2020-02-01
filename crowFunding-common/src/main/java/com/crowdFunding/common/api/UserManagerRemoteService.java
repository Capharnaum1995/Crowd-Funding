package com.crowdFunding.common.api;

import com.crowdFunding.common.dto.LoginInByAPInfoDTO;
import com.crowdFunding.common.dto.UserLogInSuccessDTO;
import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-manager")
public interface UserManagerRemoteService {

    /**
     * 获取验证码：将验证码发送给用户，并同时存入redis
     *
     * @param phoneNumber
     * @return
     */
    @RequestMapping("/send/message")
    ResultEntity<String> sendMessage(@RequestParam("phoneNumber") String phoneNumber);

    /**
     * 用户注册
     *
     * @param userRegistrationInfoDTO
     * @return
     */
    @RequestMapping("/user/register")
    ResultEntity<String> register(@RequestBody() UserRegistrationInfoDTO userRegistrationInfoDTO);

    /**
     * 用户登陆(账号-密码登陆)
     *
     * @param loginInByAPInfoDTO
     * @return
     */
    @RequestMapping("/log/in/by/account/and/password")
    ResultEntity<UserLogInSuccessDTO> logInByAP(@RequestBody() LoginInByAPInfoDTO loginInByAPInfoDTO);

    @RequestMapping("/log/out")
    ResultEntity<String> logOut(@RequestParam("token") String token);

}
