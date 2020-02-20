package com.crowdFunding.databaseProvider.service.api;

import com.crowdFunding.common.dto.addProject.ProjectDTO;
import com.crowdFunding.common.entity.ResultEntity;

public interface ProjectService {

    ResultEntity<String> createProject(ProjectDTO projectDTO);
}
