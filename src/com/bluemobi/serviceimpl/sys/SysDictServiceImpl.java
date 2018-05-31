package com.bluemobi.serviceimpl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.sys.SysDictDao;
import com.bluemobi.service.sys.SysDictService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:47
 * 
 */
@Service(value = "sysDictService")
public class SysDictServiceImpl extends MybatisBaseServiceImpl implements SysDictService {

    @Autowired
    private SysDictDao sysDictDao;

    @Override
    public MyBatisBaseDao getDao() {
        return sysDictDao;
    }

}
