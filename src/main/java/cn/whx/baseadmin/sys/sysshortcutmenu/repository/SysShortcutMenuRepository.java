package cn.whx.baseadmin.sys.sysshortcutmenu.repository;

import cn.whx.baseadmin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import cn.whx.baseadmin.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysShortcutMenuRepository extends CommonRepository<SysShortcutMenu, String> {
    List<SysShortcutMenu> findByUserId(String userId);
}
