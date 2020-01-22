package com.crowdFunding.common.api;

import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("database-provider")
public interface DatabaseRemoteOperationService {

    @RequestMapping("/get/count/by/account")
    ResultEntity<Integer> getCountByAccount(@RequestParam("account") String account);

    @RequestMapping("/create/user")
    ResultEntity<String> createUser(@RequestBody UserRegistrationInfoDTO userRegistrationInfoDTO);
}
