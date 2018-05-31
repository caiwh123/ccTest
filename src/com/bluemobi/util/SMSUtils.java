package com.bluemobi.util;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloopen.rest.sdk.CCPRestSDK;

public class SMSUtils {
	private static final Logger logger = LoggerFactory.getLogger(SMSUtils.class);
	
	/* 短信配置文件名 */
	private static String fileName = "sms.properties";
    
	/* 短信配置 */
    private static Properties properties = CommonUtils.getProperties(fileName);
    
    /* 用户名 */
    public static final String URL = properties.getProperty("url");

    /* 密码 */
    public static final String PORT = properties.getProperty("port");

    /* 网关 */
    public static final String ACCOUNT_SID = properties.getProperty("accountSid");
    
    /* 模板ID  */
    public static final String ACCOUNT_TOKEN = properties.getProperty("accountToken");
    public static final String APP_ID = properties.getProperty("appId");	// APP ID
    public static final String TEMPLATE_ID = properties.getProperty("templateId");	// template sId

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Object> result = null;
		
		String randomNumber = RandomStringUtils.random(4, false, true);
		logger.info("randomNumber = " + randomNumber);
		
		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
//		restAPI.setAccount("accountSid", "accountToken");// 初始化主帐号和主帐号TOKEN
		restAPI.setAccount("8aaf070857418a58015741ca23340031", "fc423a46786f492b889944ee5f124b9a");// 初始化主帐号和主帐号TOKEN
//		restAPI.setAppId("AppId");// 初始化应用ID
		restAPI.setAppId("8aaf070857418a58015741ca24a80038");// 初始化应用ID
//		result = restAPI.sendTemplateSMS("号码1,号码2等","模板Id" ,new String[]{"模板内容1", "模板内容2"});
		result = restAPI.sendTemplateSMS("18810997530", "1", new String[]{randomNumber, "1"});

		System.out.println("SDKTestSendTemplateSMS result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			@SuppressWarnings("unchecked")
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
	}

	/**
	 * 发送短信验证码
	 * @param randomCode
	 * @throws Exception
	 * 2016年3月29日 下午1:41:31
	 */
	public static void sendSMS(String mobile, String randomCode) throws Exception {
		HashMap<String, Object> result = null;
		
		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init(URL, PORT);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
//		restAPI.setAccount("accountSid", "accountToken");// 初始化主帐号和主帐号TOKEN
		restAPI.setAccount(ACCOUNT_SID, ACCOUNT_TOKEN);// 初始化主帐号和主帐号TOKEN
//		restAPI.setAppId("AppId");// 初始化应用ID
		restAPI.setAppId(APP_ID);// 初始化应用ID
//		result = restAPI.sendTemplateSMS("号码1,号码2等","模板Id" ,new String[]{"模板内容1", "模板内容2"});
		result = restAPI.sendTemplateSMS(mobile, TEMPLATE_ID, new String[]{randomCode, "1"});
		
		logger.info("SDKTestSendTemplateSMS result = " + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			@SuppressWarnings("unchecked")
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				
				logger.info(key + " = " + object);
			}
		}else{
			//异常返回输出错误码和错误信息
			logger.info("错误码 = " + result.get("statusCode") +" 错误信息 = "+result.get("statusMsg"));
		}
	}

}
