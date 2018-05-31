package com.bluemobi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluemobi.service.quartz.QuartzService;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;

public class TimingJob1 {
	private static final Logger log = LoggerFactory.getLogger(TimingJob1.class);
	QuartzService quartzService ;
		public QuartzService getQuartzService(){
			if(quartzService == null){
				quartzService =	SpringContextHolder.getBean(QuartzService.class);
			}
			return quartzService;
		}
	
	public void work() {
		//每分钟执行一次
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		log.error("定时任务跑批开始(更新订单状态-实时)time="+sf.format(new Date()));
		try{
			getQuartzService().timePush();
		}catch(Exception e){
			log.error("执行定时任务（更新订单状态-实时）时发生异常：", e);
		}
		log.error("定时任务跑批结束(更新订单状态-实时)time="+sf.format(new Date()));
	}
}
