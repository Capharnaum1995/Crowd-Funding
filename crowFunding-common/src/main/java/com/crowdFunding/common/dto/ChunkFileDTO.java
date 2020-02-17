package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * client上传到ui工程，ui工程生成的分片文件传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChunkFileDTO {

    private String fileId;       //文件的唯一标识,也是分片的唯一标识

    private byte[] fileBlob;     //文件分片的字节数组

    private Integer chunkIndex;   //文件分片的索引

    private Integer chunkCount; //分片的总数

    private String fileName;      //文件的名称

    private Boolean complete = false;    //默认不需要合并

}
