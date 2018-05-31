package com.bluemobi.service.trend;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.to.trend.PropertyGroupTo;

/**
 * 【属性资源分组表】 服务类 接口
 * 
 * @author zhangzheng
 * @date 2015-10-12
 * 
 */
public interface TrendPropertyGroupService extends MybatisBaseService {

    /**
     * 新增属性分组
     * 
     * @auther zhangzheng
     * @date 2015-10-12 下午3:50:13
     * @param property
     */
    void saveTrendPropertyGroup(PropertyGroupTo property);

    /**
     * 修改属性分组
     * 
     * @auther zhangzheng
     * @date 2015-10-12 下午3:50:47
     * @param property
     */
    void updateTrendPropertyGroup(PropertyGroupTo property);

    /**
     * 批量删除属性分组
     * 
     * @auther zhangzheng
     * @date 2015-10-12 下午3:50:52
     * @param propertyGroupId
     */
    void deleteTrendPropertyGroup(String propertyGroupId);

}
