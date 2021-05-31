package cn.whx.baseadmin.sys.sysshortcutmenu.service;

import cn.whx.baseadmin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import cn.whx.baseadmin.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonService;

import java.util.List;

public interface SysShortcutMenuService extends CommonService<SysShortcutMenuVo, SysShortcutMenu, String> {
    Result<List<SysShortcutMenuVo>> findByUserId(String userId);
}
