package com.crowdFunding.databaseProvider.service.imp;

import com.crowdFunding.common.dto.addProject.InitiatorInfoDTO;
import com.crowdFunding.common.dto.addProject.ProjectDTO;
import com.crowdFunding.common.dto.addProject.MemberInfoDTO;
import com.crowdFunding.common.dto.addProject.RewardDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.databaseProvider.mapper.*;
import com.crowdFunding.databaseProvider.model.*;
import com.crowdFunding.databaseProvider.service.api.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectMapperExt projectMapperExt;
    @Autowired
    private TypeProjectMapper typeProjectMapper;
    @Autowired
    private TagProjectMapper tagProjectMapper;
    @Autowired
    private PromoterMapper promoterMapper;
    @Autowired
    private RewardMapper rewardMapper;
    @Autowired
    private InitiatorInfoMapper initiatorInfoMapper;

    /**
     * 创建项目，完成表的数据插入
     *
     * @param projectDTO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public ResultEntity<String> createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);
        Integer projectPrimaryKey;
        //1. 插入project表，返回主键
        try {
            projectMapperExt.insertSelectivelyAndGetPrimaryKey(project);
            projectPrimaryKey = project.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
        //2. 成功得到主键,插入type_list表
        List<Integer> typeList = projectDTO.getTypeList();
        TypeProject typeProject = new TypeProject();
        typeProject.setProjectId(projectPrimaryKey);
        for (Integer typeId : typeList) {
            typeProject.setTypeId(typeId);
            try {
                typeProjectMapper.insertSelective(typeProject);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
        //3. 插入表tag_project
        List<Integer> tagList = projectDTO.getTagList();
        TagProject tagProject = new TagProject();
        tagProject.setProjectId(projectPrimaryKey);
        for (Integer tagId : tagList) {
            tagProject.setTagId(tagId);
            try {
                tagProjectMapper.insertSelective(tagProject);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
        //3. 插入表Promoter
        List<MemberInfoDTO> promoterInfoDTOList = projectDTO.getPromoterInfoDTOList();
        Promoter promoter = new Promoter();
        promoter.setProjectId(projectPrimaryKey);
        for (MemberInfoDTO promoterInfoDTO : promoterInfoDTOList) {
            BeanUtils.copyProperties(promoterInfoDTO, promoter);
            try {
                promoterMapper.insertSelective(promoter);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
        //4. 插入表reward
        List<RewardDTO> rewardDTOList = projectDTO.getRewardDTOList();
        Reward reward = new Reward();
        reward.setProjectId(projectPrimaryKey);
        for (RewardDTO rewardDTO : rewardDTOList) {
            BeanUtils.copyProperties(rewardDTO, reward);
            try {
                rewardMapper.insertSelective(reward);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
        //5. 插入initiator_info表
        InitiatorInfoDTO initiatorInfoDTO = projectDTO.getInitiatorInfoDTO();
        InitiatorInfo initiatorInfo = new InitiatorInfo();
        BeanUtils.copyProperties(initiatorInfoDTO, initiatorInfo);
        try {
            initiatorInfoMapper.insertSelective(initiatorInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
        //6. 最终所有表插入成功，返回成功的信息
        return ResultEntity.successWithoutData();
    }
}
