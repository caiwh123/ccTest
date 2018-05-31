package com.bluemobi.serviceimpl.trend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.trend.TrendPropertyDao;
import com.bluemobi.dao.trend.TrendPropertyValueDao;
import com.bluemobi.po.trend.TrendProperty;
import com.bluemobi.po.trend.TrendPropertyValue;
import com.bluemobi.service.trend.TrendPropertyService;
import com.bluemobi.to.trend.TrendPropertyTo;

/**
 * 【属性资源表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2015-07-30 10:42:29
 * 
 */
@Service(value = "trendPropertyService")
public class TrendPropertyServiceImpl extends MybatisBaseServiceImpl implements TrendPropertyService {

    @Autowired
    private TrendPropertyDao trendPropertyDao;
    @Autowired
    private TrendPropertyValueDao trendPropertyValueDao;
    
    @Override
    public MyBatisBaseDao getDao() {
        return trendPropertyDao;
    }

    public void saveTrendProperty(TrendPropertyTo trendPropertyTo) {
        TrendProperty trendProperty = new TrendProperty();

        trendProperty.setIsSpec((byte) trendPropertyTo.getIsSpec());
        trendProperty.setNote(trendPropertyTo.getNote());
        trendProperty.setLabelName(trendPropertyTo.getLabelName());
        trendProperty.setSortOrder(trendPropertyTo.getSortOrder());
        trendProperty.setStatus((byte) trendPropertyTo.getStatus());

        String[] pvals = trendPropertyTo.getpVal();
        Integer isdefault = trendPropertyTo.getpIsDefault();
        Integer[] sortOrders = trendPropertyTo.getpSortOrder();
        String[] imageUrls = trendPropertyTo.getImageUrl();

        trendPropertyDao.insert(trendProperty);

        List<TrendPropertyValue> propertyValueList = new ArrayList<TrendPropertyValue>();
        TrendPropertyValue trendPropertyValue = null;
        if (pvals != null) {
            for (int i = 0; i < pvals.length; i++) {
                trendPropertyValue = new TrendPropertyValue();
                trendPropertyValue.setPropertyValue(pvals[i]);
                if (isdefault != null && isdefault == i) {
                    trendPropertyValue.setIsDefault((byte) 1);
                } else {
                    trendPropertyValue.setIsDefault((byte) 0);
                }
                if (sortOrders != null) {
                    trendPropertyValue.setSortOrder(sortOrders[i]);
                }
                if (imageUrls != null) {
                    trendPropertyValue.setPropertyImage(imageUrls[i]);
                }
                trendPropertyValue.setStatus((byte) 1);
                trendPropertyValue.setPropertyId(trendProperty.getPropertyId());

                propertyValueList.add(trendPropertyValue);
            }
        }
        trendPropertyValueDao.insertTrendPropertyValues(propertyValueList);
    }

    public void updateTrendProperty(TrendPropertyTo trendPropertyTo) {
        TrendProperty trendProperty = new TrendProperty();

        trendProperty.setIsSpec((byte) trendPropertyTo.getIsSpec());
        trendProperty.setNote(trendPropertyTo.getNote());
        trendProperty.setLabelName(trendPropertyTo.getLabelName());
        trendProperty.setSortOrder(trendPropertyTo.getSortOrder());
        trendProperty.setStatus((byte) trendPropertyTo.getStatus());
        trendProperty.setPropertyId(trendPropertyTo.getPropertyId());

        trendPropertyDao.update(trendProperty);

        String[] pvals = trendPropertyTo.getpVal();
        Integer isdefault = trendPropertyTo.getpIsDefault();
        Integer[] propertyValueId = trendPropertyTo.getpPropertyValueId();
        Integer[] sortOrders = trendPropertyTo.getpSortOrder();
        String[] imageUrls = trendPropertyTo.getImageUrl();

        List<TrendPropertyValue> propertyValueList = new ArrayList<TrendPropertyValue>();
        TrendPropertyValue trendPropertyValue = null;
        if (pvals != null) {
            for (int i = 0; i < pvals.length; i++) {
                trendPropertyValue = new TrendPropertyValue();
                trendPropertyValue.setPropertyValue(pvals[i]);
                if (isdefault != null && isdefault == i) {
                    trendPropertyValue.setIsDefault((byte) 1);
                } else {
                    trendPropertyValue.setIsDefault((byte) 0);
                }
                if (sortOrders != null) {
                    trendPropertyValue.setSortOrder(sortOrders[i]);
                }
                if (propertyValueId != null) {
                    trendPropertyValue.setPropertyValueId(propertyValueId[i]);
                }
                if (imageUrls != null && !"".equals(imageUrls[i])) {
                    trendPropertyValue.setPropertyImage(imageUrls[i]);
                }
                trendPropertyValue.setPropertyId(trendPropertyTo.getPropertyId());
                propertyValueList.add(trendPropertyValue);
            }
        }
        trendPropertyValueDao.updateTrendPropertyValues(propertyValueList);

    }

    public void deleteTrendPropertyAndValues(String propertyids) {
        String[] strs = propertyids.split(",");
        for (int i = 0; i < strs.length; i++) {
            trendPropertyValueDao.delete(Integer.parseInt(strs[i]));

            // 非主键删除多条数据
            Map<String, Object> pValueMap = new HashMap<String, Object>();
            pValueMap.put("propertyId", Integer.parseInt(strs[i]));
            List<TrendPropertyValue> delValues = trendPropertyValueDao.selectObjectList(pValueMap);
            for (TrendPropertyValue data : delValues) {
                trendPropertyValueDao.delete(data.getPropertyValueId());
            }
        }
    }

    public Map<String, Object> selectMapPropertyAndValue(Map<String,Object> parameter) {
        return trendPropertyDao.selectMapPropertyAndValue(parameter);
    }

}
