package com.bluemobi.service.cas.register;

import javax.servlet.http.HttpServletRequest;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.to.ResultTO;

/**
 * 登录
 * @author hapday
 *
 */
public interface RegisterService extends MybatisBaseService {
	/**
	 * 发送短信验证码
	 * 前置条件：验证当前手机号是否已存
	 * @param mobile
	 * @return
	 * 2016年3月25日 下午2:31:31
	 */
	ResultTO sendSMSCaptcha(String mobile);
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param realname 
	 * @param request 
	 * @return
	 * 2016年3月25日 下午2:41:55
	 */
	ResultTO register(String username, String password, String realname, HttpServletRequest request);
	ResultTO register(String inviteUserId,String username, String password, String validate, HttpServletRequest request);
	ResultTO webSendSMSCaptcha(String account, String type);
	ResultTO sendAnySMS(String account);
	ResultTO bandRegister(String account, String password, String validate,String thirdId, String loginType, HttpServletRequest request);
}
