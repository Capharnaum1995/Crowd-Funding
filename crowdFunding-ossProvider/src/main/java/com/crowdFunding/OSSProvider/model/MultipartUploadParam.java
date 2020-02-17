package com.crowdFunding.OSSProvider.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipartUploadParam {

    private String objectName;

    private String uploadId;   //文件分片上传的唯一标识

}
