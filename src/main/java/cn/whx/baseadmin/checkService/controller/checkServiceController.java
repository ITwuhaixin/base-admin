package cn.whx.baseadmin.checkService.controller;

import cn.whx.baseadmin.annotation.Decrypt;
import cn.whx.baseadmin.annotation.Encrypt;
import cn.whx.baseadmin.checkService.pojo.Service101Vo;
import cn.whx.baseadmin.checkService.service.CheckServiceService;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.util.SecurityUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author haixin_wu
 * @description ${DESCRIPTION}
 * @create 2021-05-30
 */
@RestController
@RequestMapping("/service")
public class checkServiceController {

    @Autowired
    private CheckServiceService checkServiceService;

    @GetMapping("/service101")
    public ModelAndView get101(){
        return new ModelAndView("service/service101");
    }

    @PostMapping("/service101/check")
    @Decrypt
    @Encrypt
    public Result check(Service101Vo vo){
        String[] split = vo.getImeis().split("\\r\\n|\\n|\\r");
        if( !StringUtils.isEmpty(split) ){
            for (String s : split) {
                System.out.println(s);
            }
        }

        return Result.of(vo.getImeis());
    }
}
