/**    
 * @Title: WxConfig.java  
 * @Package: com.bluemobi.wx.config  
 * @Description: 微信配置类
 * @Author: huh
 * @Date: 2016年3月2日 下午3:40:27  
 * @Version V1.0    
 */

package com.bluemobi.wx.config;

import com.bluemobi.constant.WxConstant;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

/**
 * @ClassName: WxConfig
 * @Description: 微信配置
 * @author huh
 * @date 2016年3月2日 下午3:40:27
 * 
 */
public class WxConfig {
	/**
	 * 微信主服务
	 */
	private volatile static WxMpInMemoryConfigStorage wxMpConfigStorage = null;

	private WxConfig() {
	}

	public static WxMpInMemoryConfigStorage getInstalce() {
		if (wxMpConfigStorage == null) {
			synchronized (WxConfig.class) {
				if (wxMpConfigStorage == null) {
					wxMpConfigStorage = new WxMpInMemoryConfigStorage();
					wxMpConfigStorage.setAppId(WxConstant.WX_APPID);
					wxMpConfigStorage.setSecret(WxConstant.WX_APPSECRET);
					wxMpConfigStorage.setToken(WxConstant.WX_TOKEN);
					wxMpConfigStorage.setAesKey(WxConstant.WX_ENCODING_AES_KEY);
				}
			}
		}
		return wxMpConfigStorage;
	}
}
