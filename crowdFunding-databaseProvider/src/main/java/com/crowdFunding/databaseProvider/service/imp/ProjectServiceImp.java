package com.crowdFunding.databaseProvider.service.imp;

import com.crowdFunding.common.dto.addProject.ProjectDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.databaseProvider.mapper.*;
import com.crowdFunding.databaseProvider.model.Tag;
import com.crowdFunding.databaseProvider.model.TagExample;
import com.crowdFunding.databaseProvider.model.Type;
import com.crowdFunding.databaseProvider.model.TypeExample;
import com.crowdFunding.databaseProvider.service.api.ProjectService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ProjectMapperExt projectMapperExt;
    @Autowired
    private TypeProjectMapper typeProjectMapper;
    @Autowired
    private TagProjectMapper tagProjectMapper;
    @Autowired
    private MemberMapper memberMapper;
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
        /**
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
         */
        //6. 最终所有表插入成功，返回成功的信息
        return ResultEntity.successWithoutData();
    }

    /**
     * 查询Type表的所有数据
     *
     * @return
     */
    @Override
    public ResultEntity<List<com.crowdFunding.common.dto.addProject.Type>> getTypeList() {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria().andNameLike("%%");    //查询所有记录
        List<Type> typeList;
        try {
            typeList = typeMapper.selectByExample(typeExample);
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
        List<com.crowdFunding.common.dto.addProject.Type> typeList1 = new ArrayList<>();
        for (Type type : typeList) {
            com.crowdFunding.common.dto.addProject.Type type1 = new com.crowdFunding.common.dto.addProject.Type();
            BeanUtils.copyProperties(type, type1);
            typeList1.add(type1);
        }
        return ResultEntity.successWithData(typeList1);
    }

    /**
     * 查询Tag表的所有数据
     *
     * @return
     */
    @Override
    public ResultEntity<List<com.crowdFunding.common.dto.addProject.Tag>> getTagList() {
        TagExample tagExample = new TagExample();
        tagExample.createCriteria().andNameLike("%%");
        List<Tag> tagList;
        try {
            tagList = tagMapper.selectByExample(tagExample);
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
        List<com.crowdFunding.common.dto.addProject.Tag> tagList1 = new ArrayList<>();
        for (Tag tag : tagList) {
            com.crowdFunding.common.dto.addProject.Tag tag1 = new com.crowdFunding.common.dto.addProject.Tag();
            BeanUtils.copyProperties(tag, tag1);
            tagList1.add(tag1);
        }
        return ResultEntity.successWithData(tagList1);
    }
}
