package cn.whx.baseadmin.sys.sysmenu.repository;

import cn.whx.baseadmin.common.repository.CommonRepository;
import cn.whx.baseadmin.sys.sysmenu.pojo.SysMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends CommonRepository<SysMenu, String> {
}
