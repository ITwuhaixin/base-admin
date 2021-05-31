package cn.whx.baseadmin.sys.sysshortcutmenu.controller;

import cn.whx.baseadmin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import cn.whx.baseadmin.sys.sysshortcutmenu.service.SysShortcutMenuService;
import cn.whx.baseadmin.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import cn.whx.baseadmin.common.controller.CommonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/sysShortcutMenu/")
public class SysShortcutMenuController extends CommonController<SysShortcutMenuVo, SysShortcutMenu, String> {
    @Autowired
    private SysShortcutMenuService sysShortcutMenuService;
}
