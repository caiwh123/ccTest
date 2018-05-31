package com.bluemobi.dao.trend;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.trend.TrendVersion;

import java.util.Map;

/**
 * 【版本管理】 数据访问对象 接口
 * @author AutoCode 309444359@qq.com
 * @date 2015-07-17 11:22:43
 *
 */
public interface TrendVersionDao extends MyBatisBaseDao{


    TrendVersion selectNewestObject(Map<String, Object> map);
}


