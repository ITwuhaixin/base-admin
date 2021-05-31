package cn.whx.baseadmin.sys.syssetting.repository;

import cn.whx.baseadmin.sys.syssetting.pojo.SysSetting;
import cn.whx.baseadmin.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysSettingRepository extends CommonRepository<SysSetting, String> {
}
