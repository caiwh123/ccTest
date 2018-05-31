/**    
 * @Title: InitWxConstServlet.java  
 * @Package: cn.bluemobi.admin.servlet  
 * @Description: 初始化微信常量类
 * @Author: huh
 * @Date: 2016年2月23日 下午3:20:20  
 * @Version V1.0    
 */

package com.bluemobi.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.bluemobi.constant.WxConstant;

/**
 * @ClassName: InitWxConstServlet
 * @Description: 初始化微信常量
 * @author huh
 * @date 2016年2月23日 下午3:20:20
 * 
 */
public class InitWxServlet extends HttpServlet {

	private static final long serialVersionUID = -5102409401919051614L;

	private static Resource resource = new ClassPathResource("conf/wx.properties");

	private static final Logger log = Logger.getLogger(InitWxServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {

			log.debug("初始化微信端配置文件!-->开始");
			System.out.println("初始化微信端配置文件!-->开始");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			WxConstant.WX_APPID = props.getProperty("WX_APPID");// 微信公众号AppId
			WxConstant.WX_APPSECRET = props.getProperty("WX_APP_SECRET");// 微信公众号AppSecret
			WxConstant.WX_TOKEN = props.getProperty("WX_TOKEN");// 微信公众号AppSecret
			WxConstant.WX_ENCODING_AES_KEY = props.getProperty("WX_ENCODING_AES_KEY");// 微信公众号AppSecret
			WxConstant.WX_ymPath = props.getProperty("WX_ymPath");
			log.debug("初始化微信端配置文件!-->结束");
			System.out.println("初始化微信端配置文件!-->结束");

			log.debug("WxConstant.WX_APPID-->" + WxConstant.WX_APPID);
			log.debug("WxConstant.WX_APPSECRET-->" + WxConstant.WX_APPSECRET);
			log.debug("WxConstant.WX_ENCODING_AES_KEY-->" + WxConstant.WX_ENCODING_AES_KEY);
			log.debug("WxConstant.WX_TOKEN-->" + WxConstant.WX_TOKEN);
			log.debug("WxConstant.WX_ymPath-->" + WxConstant.WX_ymPath);

			 
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("配置文件加载失败！");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
