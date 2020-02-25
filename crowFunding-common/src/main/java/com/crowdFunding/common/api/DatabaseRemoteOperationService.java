package com.crowdFunding.common.api;

import com.crowdFunding.common.dto.addProject.ProjectDTO;
import com.crowdFunding.common.dto.UserInfoDTO;
import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.common.dto.addProject.Tag;
import com.crowdFunding.common.dto.addProject.Type;
import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("database-provider")
public interface DatabaseRemoteOperationService {

    @RequestMapping("/get/count/by/account")
    ResultEntity<Integer> getCountByAccount(@RequestParam("account") String account);

    @RequestMapping("/create/user")
    ResultEntity<String> createUser(@RequestBody UserRegistrationInfoDTO userRegistrationInfoDTO);

    @RequestMapping("/retrieve/user/by/account")
    ResultEntity<UserInfoDTO> retrieveUserByAccount(@RequestParam("account") String account);

    @RequestMapping("/create/project")
    ResultEntity<String> createProject(@RequestBody ProjectDTO projectDTO);

    @GetMapping("/get/project/type/list")
    ResultEntity<List<Type>> getTypeList();

    @GetMapping("/get/project/tag/list")
    ResultEntity<List<Tag>> getTagList();

}
