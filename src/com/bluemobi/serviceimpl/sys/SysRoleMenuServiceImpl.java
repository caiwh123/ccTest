package com.bluemobi.serviceimpl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.sys.SysRoleMenuDao;
import com.bluemobi.service.sys.SysRoleMenuService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:48
 * 
 */
@Service(value = "sysRoleMenuService")
public class SysRoleMenuServiceImpl extends MybatisBaseServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public MyBatisBaseDao getDao() {
        return sysRoleMenuDao;
    }

}
