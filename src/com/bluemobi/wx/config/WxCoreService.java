/**    
 * @Title: WxService.java  
 * @Package: com.bluemobi.wx.util  
 * @Description: 微信核心服务实例类
 * @Author: huh
 * @Date: 2016年3月2日 下午2:53:56  
 * @Version V1.0    
 */

package com.bluemobi.wx.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

/**
 * @ClassName: WxService
 * @Description: 微信核心服务实例
 * @author huh
 * @date 2016年3月2日 下午2:53:56
 * 
 */
public class WxCoreService {

	/**
	 * 微信主服务
	 */
	private volatile static WxMpService wxMpService = null;

	private WxCoreService() {
	}

	public static WxMpService getInstalce() {
		if (wxMpService == null) {
			synchronized (WxCoreService.class) {
				if (wxMpService == null) {
					wxMpService = new WxMpServiceImpl();
					wxMpService.setWxMpConfigStorage(WxConfig.getInstalce());
				}
			}
		}
		return wxMpService;
	}

}
