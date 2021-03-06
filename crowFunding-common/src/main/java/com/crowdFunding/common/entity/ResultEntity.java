package com.crowdFunding.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {
    private String status;
    private String message;
    private T data;

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MESSAGE = "NO_MESSAGE";
    public static final String NO_DATA = "NO_DATA";

    public static <T> ResultEntity<T> successWithData(T data) {
        return new ResultEntity<>(SUCCESS, NO_MESSAGE, data);
    }

    public static ResultEntity<String> successWithoutData() {
        return new ResultEntity<>(SUCCESS, NO_MESSAGE, NO_DATA);
    }

    public static <T> ResultEntity<T> failed(String message) {
        return new ResultEntity<>(FAILED, message, null);
    }

    public static <T> ResultEntity<T> failed() {
        return new ResultEntity<>(FAILED, null, null);
    }

    //从Redis中是否获取到了数据
    public static boolean getDataFromRedisSucceed(ResultEntity<String> resultEntity) {
        return !ResultEntity.FAILED.equals(resultEntity.getStatus()) && !ResultEntity.NO_DATA.equals(resultEntity.getData());
    }

}
