package com.bluemobi.dao.trend;

import java.util.Map;

import com.appcore.dao.MyBatisBaseDao;

/**
 * 【属性资源表】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2015-07-30 10:42:29
 * 
 */
public interface TrendPropertyDao extends MyBatisBaseDao {

    
    Map<String, Object> selectMapPropertyAndValue(Map<String, Object> map);
    
}
