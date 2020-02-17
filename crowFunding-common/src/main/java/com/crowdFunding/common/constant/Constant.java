package com.crowdFunding.common.constant;

public interface Constant {
    String VERIFICATION_PREFIX = "RANDOM_CODE_",
            SIGNED_USER_TOKEN_PREFIX = "SIGNED_USER_TOKEN_",
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
            REDIS_REMOVE_FAILED_FUSE = "Redis删除操作失败，熔断",
            REDIS_ADD_ELEMENT_TO_LIST_FAILED = "redis list添加操作失败",
            REDIS_CALL_FAILED = "redis访问操作失败",
            ACCOUNT_DOES_NOT_EXISTS = "账号或密错误，请仔细核对",
            PASSWORD_MISS_MATCH = "账号或密错误，请仔细核对",
            INVALID_TOKEN = "无效的token",
            PLEASE_LOG_IN = "用户登录可能已经过期，请先登陆",
            REDIS_PROJECT_TEMP_PREFIX = "PROJECT_TEMP_TOKEN_",
            INVALID_PROJECT_TEMP_TOKEN = "无效的project temp token",
            INVALID_PICTURE_PATH = "无效的图片路径",
            PROJECT_INVALID = "暂时查询不到该项目，请重新尝试",
            INVALID_PAY_NUMBER = "支付宝账号不合法",
            INVALID_ID_NUMBER = "身份证账号不合法",
            PROJECT_CACHE_REMOVE_FAILED = "项目创建成功，缓存删除失败，请重试删除缓存";

    Integer TOKEN_VALID_TIME = 30,    //缓存token过期时间
            VERIFICATION_CODE_VALID_TIME = 1,    //手机验证码过期时间
            VERIFICATION_CODE_LENGTH = 4;        //手机验证码生成的长度

    String ATTR_NAME_LOGIN_USER = "LOGIN_USER",
            ATTR_NAME_MESSAGE = "attr name message";

    //文件普通上传
    String INVALID_FILE_FORMAT = "文件格式错误",
            FILE_UP_LOAD_FAILED = "文件上传失败";

    //分片上传
    String RESUMABLE_INIT_FAILDE = "分片上传初始化失败",
            EGT_MULTIPAT_UPLOAD_PARAM_FAILED = "分片上传参数获取失败",
            CHUNK_UPLOAD_FAILD = "分片上传失败",
            GET_FILE_URL_FAILED = "get file url failed";

    //Redission
    String REDISSION_LOCK_FAILED = "Redission客户端尝试加锁失败",
            REDISSION_LOCK_INTERRUPTED_EXCEPTION = "Redission客户端尝试加锁被异常中断",
            INVALID_LOCK_NAME = "lock name 不合法";
}
