package cn.whx.baseadmin.sys.sysusermenu.repository;

import cn.whx.baseadmin.common.repository.CommonRepository;
import cn.whx.baseadmin.sys.sysusermenu.pojo.SysUserMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMenuRepository extends CommonRepository<SysUserMenu, String> {
    List<SysUserMenu> findByUserId(String userId);
}
