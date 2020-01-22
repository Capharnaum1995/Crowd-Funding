package com.crowdFunding.common.constant;

public interface Constant {
    String VERIFICATION_PREFIX = "RANDOM_CODE_",
            REDIS_EMPTY_RESULT = "查询结果为空(Redis)",
            VERIFICATION_CODE_MISS_MATCH = "短信验证码不匹配",
            ACCOUNT_IS_OCCUPIED = "账号已被占用",
            USER_INFO_FAILED_TO_WRITE_INTO_DATABASE = "用户信息写入数据库失败",
            INVALID_PHONE_NUMBER = "电话号码格式无效",
            INVALID_ACCOUNT = "账号格式无效",
            INVALID_PASSWORD = "密码格式无效",
            INVALID_VERIFICATION_CODE = "验证码格式无效",
            INVALID_KEY = "键值无效(Redis)",
            INVALID_VALUE = "value无效(Redis)",
            INVALID_VALID_TIME = "过期时间无效(Redis)",
            REDIS_DELETE_FAILED = "Redis删除操作失败",
            QUERY_DATABASE_FAILED_FUSE = "数据库查询操作超时，熔断",
            INSERT_DATABASE_FAILED_FUSE = "数据库插入操作超时，熔断",
            REDIS_SAVE_FAILED_FUSE = "Redis存储操作失败，熔断",
            REDIS_RETRIEVE_FAILED_FUSE = "Redis查询操作失败，熔断",
            REDIS_REMOVE_FAILED_FUSE = "Redis删除操作失败，熔断";
}
