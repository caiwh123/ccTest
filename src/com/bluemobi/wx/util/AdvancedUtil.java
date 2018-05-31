package com.bluemobi.wx.util;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.bluemobi.servlet.InitWxServlet;

public class AdvancedUtil {
	private static final Logger log = Logger.getLogger(InitWxServlet.class);
	static String oauth2Url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=AppId&secret=AppSecret&code=CODE&grant_type=authorization_code";
	
	public static WeiXinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
        WeiXinOauth2Token wat = new WeiXinOauth2Token();
        String requestUrl = oauth2Url.replace("APPID", appId).replace("AppSecret", appSecret).replace("CODE", code);
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
                try {
                        wat = new WeiXinOauth2Token();
                        wat.setAccessToken(jsonObject.getString("access_token"));
                        wat.setExpiresIn(jsonObject.getInt("expires_in"));
                        wat.setRefeshToken(jsonObject.getString("refresh_token"));
                        wat.setOpenId(jsonObject.getString("openid"));
                        wat.setScope(jsonObject.getString("scope"));
                } catch (Exception e) {
                        wat = null;
                        String errorCode = jsonObject.getString("errcode");
                        String errorMsg = jsonObject.getString("errmsg");
                        log.error("获取网页授权凭证失败 errcode{"+errorCode+"},errMsg"+errorMsg+"");
                }

        }
        return wat;
	}
}
