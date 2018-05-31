package com.ffcs.sms;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.bluemobi.util.CommonUtils;
import com.ffcs.util.HttpInvoker;
import com.ffcs.util.RandomUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 模板短信DEMO
 *
 */
public class TemplateSms {

	private static String fileName = "sms.properties";

	/* 短信配置 */
	private static Properties properties = CommonUtils.getProperties(fileName);

	public static String APP_ID = properties.getProperty("APP_ID");;// 应用ID------登录平台在应用设置可以找到
	public static String APP_SECRET = properties.getProperty("APP_SECRET");;// 应用secret-----登录平台在应用设置可以找到
	public static String TEMPLATE_ID = properties.getProperty("TEMPLATE_ID");;// 模板ID
	public static String ACCESS_TOKEN_URL = properties.getProperty("ACCESS_TOKEN_URL");// 访问令牌AT-------CC模式，AC模式都可，推荐CC模式获取令牌
	public static String GRANT_TYPE = properties.getProperty("GRANT_TYPE");
	public static String ACCESS_TOKEN = "123";
	public static long VALID_TIME = 0;// 令牌有效时间

	public static String sendSms(String tel, String randomCode) throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timestamp = dateFormat.format(date);
		System.err.println(timestamp);

		Gson gson = new Gson();
		// 获取访问令牌 还有10秒就到期时  重新获取访问令牌
		if (System.currentTimeMillis() >= VALID_TIME - 10 * 1000) {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("grant_type", GRANT_TYPE);
			paramMap.put("app_id", APP_ID);
			paramMap.put("app_secret", APP_SECRET);
			String returnJson = HttpInvoker.doHttpsPost(ACCESS_TOKEN_URL, paramMap, "utf-8");
			System.out.println(returnJson);
			Map<String, String> map3 = null;
			map3 = gson.fromJson(returnJson, new TypeToken<Map<String, String>>() {
			}.getType());
			ACCESS_TOKEN = map3.get("access_token");
			VALID_TIME = System.currentTimeMillis() + Integer.parseInt(map3.get("expires_in")) * 1000;
		}

		Map<String, String> map = new HashMap<String, String>();
		// 这里存放模板参数，如果模板没有参数直接用template_param={}
		map.put("username", "文顽派");
		map.put("code", randomCode);
		map.put("verifytime", "5");

		String template_param = gson.toJson(map);
		System.out.println(template_param);
		String postUrl = "http://api.189.cn/v2/emp/templateSms/sendSms";

		String postEntity = "app_id=" + APP_ID + "&access_token=" + ACCESS_TOKEN + "&acceptor_tel=" + tel
				+ "&template_id=" + TEMPLATE_ID + "&template_param=" + template_param + "&timestamp="
				+ URLEncoder.encode(timestamp, "utf-8");
		System.out.println(postUrl);
		System.out.println(postEntity);
		String resJson = "";
		String idertifier = null;
		Map<String, String> map2 = null;
		try {
			resJson = HttpInvoker.httpPost1(postUrl, null, postEntity);
			map2 = gson.fromJson(resJson, new TypeToken<Map<String, String>>() {
			}.getType());
			idertifier = map2.get("idertifier").toString();
		} catch (IOException e) {
			System.err.println(resJson);
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(resJson);
			e.printStackTrace();
		}
		System.err.println(resJson);
		return idertifier;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = "";
		try {
			result = sendSms("18610036332", "123456");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
