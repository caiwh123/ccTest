package com.bluemobi.serviceimpl.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.dictionary.DictionaryDao;
import com.bluemobi.service.dictionary.DictionaryService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:42
 * 
 */
@Service(value = "dictionaryService")
public class DictionaryServiceImpl extends MybatisBaseServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryDao dictionaryDao;

    @Override
    public MyBatisBaseDao getDao() {
        return dictionaryDao;
    }

}
