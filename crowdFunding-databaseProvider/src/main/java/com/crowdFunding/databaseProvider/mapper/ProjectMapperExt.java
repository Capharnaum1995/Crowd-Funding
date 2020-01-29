package com.crowdFunding.databaseProvider.mapper;

import com.crowdFunding.databaseProvider.model.Project;

public interface ProjectMapperExt {

    /**
     * 插入一条记录并返回主键
     *
     * @param record
     * @return
     */
    Integer insertSelectivelyAndGetPrimaryKey(Project record);
}
