package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 普通文件的文件传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUpLoadDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;

    private String fileName;

    private byte[] content;

}
