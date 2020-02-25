package com.crowdFunding.ui.handler;

import com.alibaba.fastjson.JSON;
import com.crowdFunding.common.api.DatabaseRemoteOperationService;
import com.crowdFunding.common.api.RedisRemoteOperationService;
import com.crowdFunding.common.dto.addProject.*;
import com.crowdFunding.common.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class AddProjectHandler {

    @Autowired
    private RedisRemoteOperationService redisRemoteOperationService;

    @Autowired
    private DatabaseRemoteOperationService databaseRemoteOperationService;

    @GetMapping("/addProject")
    public String goToAddProjectPage(Model model) {
        TypeDTO typeDTO;
        TagDTO tagDTO;
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.retrieveValueByKey(Type.TYPE_KEY);
        if (ResultEntity.getDataFromRedisSucceed(resultEntity1)) {
            typeDTO = JSON.parseObject(resultEntity1.getData(), TypeDTO.class);
        } else {
            typeDTO = new TypeDTO();
            ResultEntity<List<Type>> resultEntity = databaseRemoteOperationService.getTypeList();
            if (!ResultEntity.FAILED.equals(resultEntity.getStatus())) {
                typeDTO.setTypeList(resultEntity.getData());
                try {
                    redisRemoteOperationService.setIfNotExistWithValidTime(
                            UUID.randomUUID().toString(),
                            Type.TYPE_KEY,
                            JSON.toJSONString(typeDTO),
                            Type.TYPE_VALID_TIME
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ResultEntity<String> resultEntity2 = redisRemoteOperationService.retrieveValueByKey(Tag.TAG_KEY);
        if (ResultEntity.getDataFromRedisSucceed(resultEntity2)) {
            tagDTO = JSON.parseObject(resultEntity2.getData(), TagDTO.class);
        } else {
            tagDTO = new TagDTO();
            ResultEntity<List<Tag>> resultEntity = databaseRemoteOperationService.getTagList();
            if (!ResultEntity.FAILED.equals(resultEntity.getStatus())) {
                tagDTO.setTagList(resultEntity.getData());
                try {
                    redisRemoteOperationService.setIfNotExistWithValidTime(
                            UUID.randomUUID().toString(),
                            Tag.TAG_KEY,
                            JSON.toJSONString(tagDTO),
                            Tag.TAG_VALID_TIME
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (typeDTO.getTypeList() == null) {
            List<Type> typeList = new ArrayList<>();
            typeDTO.setTypeList(typeList);
        }
        if (tagDTO.getTagList() == null) {
            List<Tag> tagList = new ArrayList<>();
            tagDTO.setTagList(tagList);
        }
        model.addAttribute("typeDTO", typeDTO);
        model.addAttribute("tagDTO", tagDTO);
        return "addProject";
    }

    /**
     * 获取项目的品类
     *
     * @return
     */
    @GetMapping("/get/project/type/list")
    public ResultEntity<TypeDTO> getTypeList() {
        //1. 先从缓存中去取
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(Type.TYPE_KEY);
        if (ResultEntity.getDataFromRedisSucceed(resultEntity)) {
            return ResultEntity.successWithData(JSON.parseObject(resultEntity.getData(), TypeDTO.class));
        }
        //2. 缓存中没有拿到，在数据库中去取,并且存入缓存中
        ResultEntity<List<Type>> resultEntity1 = databaseRemoteOperationService.getTypeList();
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setTypeList(resultEntity1.getData());
        try {
            redisRemoteOperationService.setIfNotExistWithValidTime(
                    UUID.randomUUID().toString(),
                    Type.TYPE_KEY,
                    JSON.toJSONString(typeDTO),
                    Type.TYPE_VALID_TIME
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.successWithData(typeDTO);
    }

    /**
     * 获取项目的Tag
     *
     * @return
     */
    @GetMapping("/get/project/tag/list")
    public ResultEntity<TagDTO> getTagList() {
        //1. 先从缓存中去取
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(Tag.TAG_KEY);
        if (ResultEntity.getDataFromRedisSucceed(resultEntity)) {
            return ResultEntity.successWithData(JSON.parseObject(resultEntity.getData(), TagDTO.class));
        }
        //2. 缓存中没有拿到，在数据库中去取,并且存入缓存中
        ResultEntity<List<Tag>> resultEntity1 = databaseRemoteOperationService.getTagList();
        TagDTO tagDTO = new TagDTO();
        tagDTO.setTagList(resultEntity1.getData());
        try {
            redisRemoteOperationService.setIfNotExistWithValidTime(
                    UUID.randomUUID().toString(),
                    Tag.TAG_KEY,
                    JSON.toJSONString(tagDTO),
                    Tag.TAG_VALID_TIME
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.successWithData(tagDTO);
    }

    /**
     * 保存项目的基本信息
     *
     * @param basicInfoDTO
     * @return
     */
    @ResponseBody
    @PostMapping("/save/project/basic/info")
    public ResultEntity<String> saveProjectBasicInfo(@RequestBody BasicInfoDTO basicInfoDTO) {
        System.out.println(basicInfoDTO.toString());
        //to do something here...
        return ResultEntity.successWithoutData();
    }

    /**
     * 保存项目的挡位
     *
     * @param rewardDTO
     * @return
     */
    @ResponseBody
    @PostMapping("/save/reward")
    public ResultEntity<String> saveReward(@RequestBody RewardDTO rewardDTO) {
        System.out.println(rewardDTO.toString());
        //to do something here...
        return ResultEntity.successWithoutData();
    }

    /**
     * 保存项目的推广资料
     *
     * @param promotionalMaterialDTO
     * @return
     */
    @ResponseBody
    @PostMapping("/save/promotional/material")
    public ResultEntity<String> savePromotionalMaterial(@RequestBody PromotionalMaterialDTO promotionalMaterialDTO) {
        System.out.println(promotionalMaterialDTO.toString());
        //to do something here...
        return ResultEntity.successWithoutData();
    }

    /**
     * 保存项目的资质信息
     *
     * @param qualificationInfoDTO
     * @return
     */
    @ResponseBody
    @PostMapping("/save/qualification/info")
    public ResultEntity<String> saveQualificationInfo(@RequestBody QualificationInfoDTO qualificationInfoDTO) {
        System.out.println(qualificationInfoDTO.toString());
        //to do something here...
        return ResultEntity.successWithoutData();
    }

}
