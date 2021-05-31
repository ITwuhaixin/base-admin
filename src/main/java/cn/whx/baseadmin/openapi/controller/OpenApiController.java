package cn.whx.baseadmin.openapi.controller;

import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.openapi.service.OpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openApi/")
public class OpenApiController {

    @Autowired
    private OpenApiService openApiService;

    @GetMapping("test")
    public Result<String> test() {
        return openApiService.test();
    }
}
