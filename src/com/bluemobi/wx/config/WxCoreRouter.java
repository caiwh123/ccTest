/**    
 * @Title: WxCoreRouter.java  
 * @Package: com.bluemobi.wx.util  
 * @Description: 微信消息路由实例类
 * @Author: huh
 * @Date: 2016年3月2日 下午3:35:04  
 * @Version V1.0    
 */

package com.bluemobi.wx.config;

import me.chanjar.weixin.mp.api.WxMpMessageRouter;

/**
 * @ClassName: WxCoreRouter
 * @Description: 微信消息路由实例
 * @author huh
 * @date 2016年3月2日 下午3:35:04
 * 
 */
public class WxCoreRouter {

	/**
	 * 微信主服务
	 */
	private volatile static WxMpMessageRouter wxMpMessageRouter = null;

	private WxCoreRouter() {
	}

	public static WxMpMessageRouter getInstalce() {
		if (wxMpMessageRouter == null) {
			synchronized (WxCoreRouter.class) {
				if (wxMpMessageRouter == null) {
					wxMpMessageRouter = new WxMpMessageRouter(WxCoreService.getInstalce());
				}
			}
		}
		return wxMpMessageRouter;
	}

}
