package cn.whx.baseadmin.sys.sysuser.service;

import cn.whx.baseadmin.sys.sysuser.pojo.SysUser;
import cn.whx.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonService;

public interface SysUserService extends CommonService<SysUserVo, SysUser, String> {
    Result<SysUserVo> findByLoginName(String username);
    Result<SysUserVo> resetPassword(String userId);
}
