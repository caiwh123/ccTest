package com.bluemobi.serviceimpl.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.dictionary.DictionaryDetailDao;
import com.bluemobi.service.dictionary.DictionaryDetailService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:42
 * 
 */
@Service(value = "dictionaryDetailService")
public class DictionaryDetailServiceImpl extends MybatisBaseServiceImpl implements DictionaryDetailService {

    @Autowired
    private DictionaryDetailDao dictionaryDetailDao;

    @Override
    public MyBatisBaseDao getDao() {
        return dictionaryDetailDao;
    }

}
