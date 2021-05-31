package cn.whx.baseadmin.sys.sysusermenu.service;

import cn.whx.baseadmin.sys.sysmenu.vo.SysMenuVo;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonService;
import cn.whx.baseadmin.sys.sysusermenu.pojo.SysUserMenu;
import cn.whx.baseadmin.sys.sysusermenu.vo.SysUserMenuVo;

import java.util.List;

public interface SysUserMenuService extends CommonService<SysUserMenuVo, SysUserMenu, String> {
    Result<List<SysMenuVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String menuIdList);
}
