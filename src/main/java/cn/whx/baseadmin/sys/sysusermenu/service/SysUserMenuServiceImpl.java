package cn.whx.baseadmin.sys.sysusermenu.service;

import cn.whx.baseadmin.sys.sysmenu.vo.SysMenuVo;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonServiceImpl;
import cn.whx.baseadmin.sys.sysusermenu.pojo.SysUserMenu;
import cn.whx.baseadmin.sys.sysusermenu.repository.SysUserMenuRepository;
import cn.whx.baseadmin.sys.sysusermenu.vo.SysUserMenuVo;
import cn.whx.baseadmin.util.CopyUtil;
import cn.whx.baseadmin.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysUserMenuServiceImpl extends CommonServiceImpl<SysUserMenuVo, SysUserMenu, String> implements SysUserMenuService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysUserMenuRepository sysUserMenuRepository;

    @Override
    public Result<List<SysMenuVo>> findByUserId(String userId) {
        List<SysMenuVo> menuVoList = new ArrayList<>();
        List<SysUserMenuVo> sysUserMenuVoList = CopyUtil.copyList(sysUserMenuRepository.findByUserId(userId), SysUserMenuVo.class);
        sysUserMenuVoList.forEach((sysUserMenuVo) -> {
            menuVoList.add(sysUserMenuVo.getSysMenu());
        });
        return Result.of(MenuUtil.getChildBySysMenuVo("",menuVoList));

    }

    @Override
    public Result<Boolean> saveAllByUserId(String userId, String menuIdList) {
        //先删除旧的
        SysUserMenuVo sysUserMenuVo = new SysUserMenuVo();
        sysUserMenuVo.setUserId(userId);
        list(sysUserMenuVo).getData().forEach((userMenuVo)->{
            delete(userMenuVo.getUserMenuId());
        });

        //再保存新的
        for (String menuId : menuIdList.split(",")) {
            sysUserMenuVo.setMenuId(menuId);
            save(sysUserMenuVo);
        }
        return Result.of(true);
    }

}
