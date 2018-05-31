package com.bluemobi.service.trend;

import java.util.Map;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.to.trend.TrendPropertyTo;

/**
 * 【属性资源表】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2015-07-30 10:42:29
 * 
 */
public interface TrendPropertyService extends MybatisBaseService {

    /**
     * 新增属性
     * 
     * @auther zhangzheng
     * @date 2015-10-26 上午11:52:26
     * @param trendPropertyTo
     */
    void saveTrendProperty(TrendPropertyTo trendPropertyTo);

    /**
     * 修改属性
     * 
     * @auther zhangzheng
     * @date 2015-10-26 上午11:53:25
     * @param trendPropertyTo
     */
    void updateTrendProperty(TrendPropertyTo trendPropertyTo);

    /**
     * 删除属性和属性值
     * 
     * @auther zhangzheng
     * @date 2015-10-26 上午11:53:30
     * @param propertyids
     */
    void deleteTrendPropertyAndValues(String propertyids);

    /**
     * 
     * @auther zhangzheng
     * @date 2015-10-26 上午11:53:41
     * @param paramMap
     * @return
     */
    Map<String, Object> selectMapPropertyAndValue(Map<String, Object> paramMap);

}
