package cn.whx.baseadmin.sys.syssetting.service;

import cn.whx.baseadmin.sys.syssetting.pojo.SysSetting;
import cn.whx.baseadmin.sys.syssetting.vo.SysSettingVo;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonServiceImpl;
import cn.whx.baseadmin.sys.syssetting.repository.SysSettingRepository;
import cn.whx.baseadmin.util.SysSettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class SysSettingServiceImpl extends CommonServiceImpl<SysSettingVo, SysSetting, String> implements SysSettingService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysSettingRepository sysSettingRepository;

    @Override
    public Result<SysSettingVo> save(SysSettingVo entityVo) {
        //调用父类
        Result<SysSettingVo> result = super.save(entityVo);

        //更新系统设置时同步更新公用静态集合sysSettingMap
        SysSettingUtil.setSysSettingMap(result.getData());

        return result;
    }
}
