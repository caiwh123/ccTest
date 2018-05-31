package com.bluemobi.serviceimpl.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.page.Page;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.dictionary.DictionaryDetailDao;
import com.bluemobi.po.dictionary.DictionaryDetail;
import com.bluemobi.service.dict.DictService;
import com.bluemobi.util.redisUtil.RedisUtil;



@Service(value = "dictService")
public class DictServiceImpl extends MybatisBaseServiceImpl implements DictService{

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DictServiceImpl.class);
	
	@Autowired
	private DictionaryDetailDao dictionaryDetailDao;
	
	@Override
	public MyBatisBaseDao getDao() {
		return dictionaryDetailDao;
	}
	
	public void pushDictToCache(){
    	try{
    		//查询所有字典项
    		List<DictionaryDetail> dictionaryDetailList = this.selectObjectList(new HashMap<String,Object>());
    		//存放字典类型的map
        	Map<String, List<DictionaryDetail>> dictMap = new HashMap<String, List<DictionaryDetail>>();
        	//循环字典项
        	for(int i=0;i<dictionaryDetailList.size();i++){
        		//当前字典项
        		DictionaryDetail dictionaryDetail = dictionaryDetailList.get(i);
        		
        		//查询当前字典类型是否已存在
        		List<DictionaryDetail> list = dictMap.get(""+dictionaryDetail.getDictionaryid());
        		if(list == null){
        			//新字典类型则初始化
        			list = new ArrayList<DictionaryDetail>();
        			dictMap.put(""+dictionaryDetail.getDictionaryid(), list);
        		}
        		list.add(dictionaryDetail);
        	}
        	
    		// 循环VOMap，将各字典类型放入缓存
    		for (Map.Entry<String, List<DictionaryDetail>> entry : dictMap.entrySet()) {
    			//将当前字典类型存入缓存
    			RedisUtil.addHash("DICT", entry.getKey(), entry.getValue());
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		LOGGER.error("加载数据字典到缓存时发生异常"+e.getMessage());
    	}
    }

	
}
