package com.crowdFunding.databaseProvider.controller;

import com.crowdFunding.common.dto.ProjectDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.databaseProvider.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 创建项目
     *
     * @param projectDTO
     * @return
     */
    @RequestMapping("/create/project")
    ResultEntity<String> createProject(@RequestBody ProjectDTO projectDTO) {
        // 各种数据库的操作
        ResultEntity<String> resultEntity = projectService.createProject(projectDTO);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(resultEntity.getMessage());
        }
        return ResultEntity.successWithoutData();
    }
}
