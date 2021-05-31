package cn.whx.baseadmin.sys.sysmenu.service;

import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonService;
import cn.whx.baseadmin.sys.sysmenu.pojo.SysMenu;
import cn.whx.baseadmin.sys.sysmenu.vo.SysMenuVo;

import java.util.List;

public interface SysMenuService extends CommonService<SysMenuVo, SysMenu, String> {
    Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo);
}
