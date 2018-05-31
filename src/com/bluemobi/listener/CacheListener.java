package com.bluemobi.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import com.bluemobi.service.dict.DictService;
/**
 * web应用监听器
 * @author haojian
 * @date 2015-4-14 下午3:26:25 
 *
 */


@Service
public class CacheListener implements ApplicationListener<ContextRefreshedEvent>{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheListener.class);

    
    
    
    
	@Override
	public void onApplicationEvent(ContextRefreshedEvent ev) {
		//防止重复调用
		if(ev.getApplicationContext().getParent() == null){  
			LOGGER.info("加载数据字典开始");
			//dictService.pushDictToCache();
			LOGGER.info("加载数据字典结束");
		} 
	}
    
   
    
    
    
    
    
}
