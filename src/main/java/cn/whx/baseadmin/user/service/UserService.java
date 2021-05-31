package cn.whx.baseadmin.user.service;

import cn.whx.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.whx.baseadmin.common.pojo.Result;

public interface UserService {
    Result<SysUserVo> updatePassword(String oldPassword, String newPassword);

    Result<SysUserVo> updateUser(SysUserVo sysUserVo);
}
