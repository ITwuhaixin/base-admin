package cn.whx.baseadmin.sys.sysuser.repository;

import cn.whx.baseadmin.sys.sysuser.pojo.SysUser;
import cn.whx.baseadmin.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends CommonRepository<SysUser, String> {
    SysUser findByLoginName(String username);
}
