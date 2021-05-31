package cn.whx.baseadmin.openapi.service;

import cn.whx.baseadmin.common.pojo.Result;

public interface OpenApiService {
    /**
     * open api test测试
     * @return 测试数据
     */
    Result<String> test();
}
