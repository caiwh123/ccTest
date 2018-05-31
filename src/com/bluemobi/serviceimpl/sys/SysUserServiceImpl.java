package com.bluemobi.serviceimpl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.sys.SysUserDao;
import com.bluemobi.service.sys.SysUserService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:48
 * 
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl extends MybatisBaseServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public MyBatisBaseDao getDao() {
        return sysUserDao;
    }

}
