package com.bluemobi.serviceimpl.cas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.cas.CasUserDao;
import com.bluemobi.service.cas.CasUserService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:41
 * 
 */
@Service(value = "casUserService")
public class CasUserServiceImpl extends MybatisBaseServiceImpl implements CasUserService {

    @Autowired
    private CasUserDao casUserDao;

    @Override
    public MyBatisBaseDao getDao() {
        return casUserDao;
    }

}
