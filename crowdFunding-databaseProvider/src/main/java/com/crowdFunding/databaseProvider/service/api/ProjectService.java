package com.crowdFunding.databaseProvider.service.api;

import com.crowdFunding.common.dto.addProject.ProjectDTO;
import com.crowdFunding.common.dto.addProject.Tag;
import com.crowdFunding.common.dto.addProject.Type;
import com.crowdFunding.common.entity.ResultEntity;

import java.util.List;

public interface ProjectService {

    /**
     * 创建项目，完成表的数据插入
     *
     * @param projectDTO
     * @return
     */
    ResultEntity<String> createProject(ProjectDTO projectDTO);

    /**
     * 查询Type表的所有数据
     *
     * @return
     */
    ResultEntity<List<Type>> getTypeList();

    /**
     * 查询Tag表的所有数据
     *
     * @return
     */
    ResultEntity<List<Tag>> getTagList();
}
