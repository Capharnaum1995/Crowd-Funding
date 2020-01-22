package com.crowdFunding.common.exception;

public enum CustomizedError implements ICustomizedError {
    INVALID_VALUE(2001, "xxxxxx！");

    @Override
    public Integer getErrorCode() {
        return null;
    }

    @Override
    public String getErrorInfo() {
        return null;
    }

    private Integer errorCode;
    private String errorInfo;

    CustomizedError(Integer errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }
}
