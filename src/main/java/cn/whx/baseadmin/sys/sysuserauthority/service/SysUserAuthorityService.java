package cn.whx.baseadmin.sys.sysuserauthority.service;

import cn.whx.baseadmin.sys.sysuserauthority.pojo.SysUserAuthority;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonService;
import cn.whx.baseadmin.sys.sysuserauthority.vo.SysUserAuthorityVo;

import java.util.List;

public interface SysUserAuthorityService extends CommonService<SysUserAuthorityVo, SysUserAuthority, String> {
    Result<List<SysUserAuthorityVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String authorityIdList);
}
