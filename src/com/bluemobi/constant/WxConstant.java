/**    
 * @Title: WxConstant.java  
 * @Package: cn.bluemobi.admin.constant  
 * @Description: 微信相关常量类
 * @Author: huh
 * @Date: 2016年2月23日 下午3:17:16  
 * @Version V1.0    
 */

package com.bluemobi.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluemobi.conf.Config;

/**
 * @ClassName: WxConstant
 * @Description: 微信相关常量
 * @author huh
 * @date 2016年2月23日 下午3:17:16
 * 
 */
public class WxConstant {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WxConstant.class);

	private static String fileName = "wx.properties";

	private static Properties p = getProperties(fileName);
	
	
	
	/**
	 * 微信公众号AppId
	 */
	public static String WX_APPID = p.getProperty("WX_APPID");// 

	/**
	 * 微信公众号AppSecret
	 */
	public static String WX_APPSECRET = p.getProperty("WX_APP_SECRET");// 

	/**
	 * 微信公众号TOKEN
	 */
	public static String WX_TOKEN = p.getProperty("WX_TOKEN");// 

	/**
	 * ENCODING_AES_KEY
	 */
	public static String WX_ENCODING_AES_KEY = p.getProperty("WX_ENCODING_AES_KEY");// WX_ENCODING_AES_KEY

	/**
	 * 获取用户信息-语言
	 */
	public static String LANG = "zh_CN";
	
	/**
	 * 微信域
	 */
	public static String WX_ymPath = p.getProperty("WX_ymPath");// WX_ymPath

	/**
	 * 默认头像
	 */
	public static String DEFAULT_HEAD_PORTRAIT = "../../wechat/resourceByWechat/images/Icon-personal-deep.png";
	
	
	/**
	 * 读取配置文件， 初始化支付参数
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static Properties getProperties(String fileName) {

		LOGGER.info("开始读取文件【{}】...", new Object[] { fileName });

		InputStream is = Config.class.getClassLoader().getResourceAsStream(fileName);
		Properties properties = new Properties();
		try {
			properties.load(is);
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			LOGGER.error("Exception:【{}】" + e);
		}

		LOGGER.info("读取文件【{}】结束...", new Object[] { fileName });

		return properties;
	}
}
