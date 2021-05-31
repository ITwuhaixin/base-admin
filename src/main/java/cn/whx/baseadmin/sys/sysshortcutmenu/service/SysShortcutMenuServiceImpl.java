package cn.whx.baseadmin.sys.sysshortcutmenu.service;

import cn.whx.baseadmin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import cn.whx.baseadmin.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import cn.whx.baseadmin.common.pojo.Result;
import cn.whx.baseadmin.common.service.CommonServiceImpl;
import cn.whx.baseadmin.sys.sysshortcutmenu.repository.SysShortcutMenuRepository;
import cn.whx.baseadmin.util.CopyUtil;
import cn.whx.baseadmin.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SysShortcutMenuServiceImpl extends CommonServiceImpl<SysShortcutMenuVo, SysShortcutMenu, String> implements SysShortcutMenuService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysShortcutMenuRepository sysShortcutMenuRepository;

    @Override
    public Result<String> delete(String id) {
        //先删除子节点
        SysShortcutMenuVo sysShortcutMenuVo = new SysShortcutMenuVo();
        sysShortcutMenuVo.setShortcutMenuParentId(id);
        super.list(sysShortcutMenuVo).getData().forEach((menuVo)->{
            super.delete(menuVo.getShortcutMenuId());
        });
        //再删除自己
        return super.delete(id);
    }

    @Override
    public Result<List<SysShortcutMenuVo>> findByUserId(String userId) {
        List<SysShortcutMenuVo> sysShortcutMenuVoList = CopyUtil.copyList(sysShortcutMenuRepository.findByUserId(userId), SysShortcutMenuVo.class);
        return Result.of(MenuUtil.getChildBySysShortcutMenuVo("",sysShortcutMenuVoList));
    }
}
