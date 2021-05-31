package cn.whx.baseadmin.sys.sysuserauthority.repository;

import cn.whx.baseadmin.sys.sysuserauthority.pojo.SysUserAuthority;
import cn.whx.baseadmin.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserAuthorityRepository extends CommonRepository<SysUserAuthority, String> {
    List<SysUserAuthority> findByUserId(String userId);
}
