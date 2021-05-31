package cn.whx.baseadmin.sys.sysuserauthority.controller;

import cn.whx.baseadmin.sys.sysauthority.service.SysAuthorityService;
import cn.whx.baseadmin.sys.sysauthority.vo.SysAuthorityVo;
import cn.whx.baseadmin.sys.sysuserauthority.pojo.SysUserAuthority;
import cn.whx.baseadmin.sys.sysuserauthority.service.SysUserAuthorityService;
import cn.whx.baseadmin.annotation.Decrypt;
import cn.whx.baseadmin.annotation.Encrypt;
import cn.whx.baseadmin.common.controller.CommonController;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.sys.sysuserauthority.vo.SysUserAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/sysUserAuthority/")
public class SysUserAuthorityController extends CommonController<SysUserAuthorityVo, SysUserAuthority, String> {
    @Autowired
    private SysUserAuthorityService sysUserAuthorityService;

    @Autowired
    private SysAuthorityService sysAuthorityService;

    @PostMapping("findUserAuthorityAndAllSysAuthorityByUserId")
    @Decrypt
    @Encrypt
    public Result<Map<String, Object>> findUserAuthorityAndAllSysAuthorityByUserId(SysUserAuthorityVo sysUserAuthorityVo) {
        HashMap<String, Object> map = new HashMap<>();
        List<SysUserAuthorityVo> sysUserAuthorityVoList = sysUserAuthorityService.findByUserId(sysUserAuthorityVo.getUserId()).getData();
        map.put("sysUserAuthorityVoList", sysUserAuthorityVoList);
        List<SysAuthorityVo> sysAuthorityVoList = sysAuthorityService.list(new SysAuthorityVo()).getData();
        map.put("sysAuthorityVoList", sysAuthorityVoList);
        return Result.of(map);
    }

    @PostMapping("saveAllByUserId")
    @Decrypt
    @Encrypt
    public Result<Boolean> saveAllByUserId(SysUserAuthorityVo sysUserAuthorityVo) {
        return sysUserAuthorityService.saveAllByUserId(sysUserAuthorityVo.getUserId(), sysUserAuthorityVo.getAuthorityIdList());
    }
}
