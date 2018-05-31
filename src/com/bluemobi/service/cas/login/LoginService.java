package com.bluemobi.service.cas.login;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.po.cas.CasUser;
import com.bluemobi.to.ResultTO;

/**
 * 登录
 * @author hapday
 *
 */
public interface LoginService extends MybatisBaseService {
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
	 * @return
	 * 2016年3月25日 下午2:41:55
	 */
	ResultTO login(String username, String password);
	/**
	 * 更新【前台用户】的密码
	 * @param username 用户名
	 * @param oldPassword 旧密码
	 * @param password 新密码
	 * @param repassword 重复新密码
	 * @return
	 * 2016年3月29日 下午2:29:11
	 */
	ResultTO updateCasUser4passwordByUsername(String username, String oldPassword, String newPassword);
	/**
	 *  更新【前台用户】的密码4Account
	 * @param account
	 * @param password
	 * @param validate 
	 * @return
	 */
	ResultTO updateCasUser4passwordByAccount(String account, String password, String validate);
	/**
	 * 根据第三方id和类型查询casUser
	 * @param casUser
	 * @return
	 */
	CasUser selectThirdByThirdIdAndThirdLoginType(CasUser casUser);
	/**
	 * 
	 * 插入第三方用户
	 * @param casUser
	 * @throws Exception 
	 */
	void insertCasUser(CasUser casUser) throws Exception;
	ResultTO thirdLogin(String thirdId);
	ResultTO fastLogin(String account, String validate);
	ResultTO setHeadPath(String headPath, String nickName, String gendar, String gendar2);
}
