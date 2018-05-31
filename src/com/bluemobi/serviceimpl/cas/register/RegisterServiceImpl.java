package com.bluemobi.serviceimpl.cas.register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.page.Page;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.constant.BaseConstant;
import com.bluemobi.dao.cas.CasUserDao;
import com.bluemobi.po.cas.CasUser;
import com.bluemobi.service.cas.register.RegisterService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.util.CommonUtils;
import com.bluemobi.util.SMSUtils;
import com.bluemobi.util.StringUtil;
import com.bluemobi.util.UUIDService;
import com.bluemobi.util.redisUtil.RedisUtil;

@Service(value = "toRegisterService")
public class RegisterServiceImpl extends MybatisBaseServiceImpl implements RegisterService {
	private static final Logger logger = Logger.getLogger(RegisterServiceImpl.class);

    @Autowired
    private CasUserDao casUserDao;
   
   
    
    @Override
    public MyBatisBaseDao getDao() {
        return casUserDao;
    }

	@Override
	public <P> int delete(P arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <P> int insert(P arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> Page<T> page(Map<String, Object> arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Page<T> page(String arg0, String arg1, Map<String, Object> arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V, P> Map<String, V> selectMap(P arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V, P> List<Map<String, V>> selectMapList(P arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> T selectObject(P arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, P> List<T> selectObjectList(P arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <P> int update(P arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultTO sendSMSCaptcha(String mobile) {
		logger.info("mobile = " + mobile);
		
		ResultTO resultTO = new ResultTO();
    	
    	if(CommonUtils.isEmpty(mobile)){
    		resultTO.setMsg("【手机号】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(mobile)){
    		resultTO.setMsg("【手机号】格式不正确！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}
    	
    	byte count = 0;
		try {
			count = this.casUserDao.selectCasUserCountByAccount(mobile);
		} catch (Exception e) {
			resultTO.setMsg("据【用户名】查询【前台用户】的数量 - 失败！异常：");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			logger.error("据【用户名】查询【前台用户】的数量 - 失败！异常：", e);
			
			return resultTO;
		}
    	
    	if(0 < count){
    		resultTO.setStatus(2);
    		resultTO.setMsg("手机号已存在！");
    		
    		return resultTO;
    	}
    	
    	String randomCode = RandomStringUtils.random(6, false, true);
		logger.info("randomCode = " + randomCode);
		
		try {
			SMSUtils.sendSMS(mobile, randomCode);
			//将验证码存入缓存以便校验
			RedisUtil.setEx("SMSRegister_"+mobile, 60, randomCode);
			resultTO.setData(randomCode);
			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
			resultTO.setMsg("发送短信验证码 - 成功。");
		} catch (Exception e) {
			resultTO.setMsg("发送短信验证码 - 失败！");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			resultTO.setData(randomCode);
		}
    	
    	return resultTO;
	}

	@Override
	public ResultTO register(String username, String password,String validate,HttpServletRequest request) {
		
		ResultTO resultTO = new ResultTO();
    	
		// 1. 校验参数
    	if(CommonUtils.isEmpty(username)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【手机号】不可为空！");
    		
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(username)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【手机号】格式不正确！");
    		
    		return resultTO;
    	} else if(CommonUtils.isEmpty(password)){
    		resultTO.setMsg("【密码】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}else if(CommonUtils.isEmpty(validate)){
    		resultTO.setMsg("【验证码】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}
    	//验证码输入是否正确
    	/*String prmvalidate = RedisUtil.getString("SMSRegister_"+username);
    	if(!validate.equals(prmvalidate)){
    		resultTO.setStatus(3);
    		resultTO.setMsg("验证码错误存在！");
    		
    		return resultTO;
    	}*/
    	//验证用户是否存在
    	byte count = 0;
		try {
			count = this.casUserDao.selectCasUserCountByAccount(username);
		} catch (Exception e) {
			resultTO.setMsg("据【手机号】查询【前台用户】的数量 - 失败！异常：");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			logger.error("据【手机号】查询【前台用户】的数量 - 失败！异常：", e);
			
			return resultTO;
		}
    	
    	if(0 < count){
    		resultTO.setStatus(2);
    		resultTO.setMsg("手机号已存在！");
    		
    		return resultTO;
    	}
    	
    	// 混淆码（加盐）
        String salt = UUIDService.getUUID().subSequence(0, 6).toString();
        //密码进行MD5加密
        String passwordMd5Md5 = StringUtil.md5(StringUtil.md5(password) + salt);
    	
    	// 2.保存【前台用户】
    	CasUser casUser = new CasUser();
    	casUser.setAccount(username);
    	casUser.setPassword(passwordMd5Md5);
    	casUser.setSalt(salt);
    	casUser.setStatus((short)1);
    	casUser.setDeviceNo("0,0,0");
		try {
			this.casUserDao.insertCasUser(casUser);
			//更新用户昵称
			casUser.setNickname("用户"+casUser.getUserId());
			this.casUserDao.update(casUser);
			resultTO.setData(casUser);
			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
	        resultTO.setMsg("注册成功");
		} catch (Exception e) {
			resultTO.setMsg("注册【用户】 - 失败！");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			logger.error("注册【用户】 - 失败！", e);
		}

        return resultTO;
	}
	
	@Override
	public ResultTO bandRegister(String username, String password,String validate,String thirdId,String loginType,HttpServletRequest request) {
		
		ResultTO resultTO = new ResultTO();
    	
		// 1. 校验参数
    	if(CommonUtils.isEmpty(username)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【手机号】不可为空！");
    		
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(username)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【手机号】格式不正确！");
    		
    		return resultTO;
    	} else if(CommonUtils.isEmpty(password)){
    		resultTO.setMsg("【密码】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}else if(CommonUtils.isEmpty(validate)){
    		resultTO.setMsg("【验证码】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}else if(CommonUtils.isEmpty(thirdId)){
    		resultTO.setMsg("【第三方id】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}else if(CommonUtils.isEmpty(loginType)){
    		resultTO.setMsg("【登录类型】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}
    	//验证码输入是否正确
    	/*String prmvalidate = (String) RedisUtil.getString("SMSRegister_"+username);
    	if(!validate.equals(prmvalidate)){
    		resultTO.setStatus(3);
    		resultTO.setMsg("验证码错误存在！");
    		
    		return resultTO;
    	}*/
    	//验证用户是否存在
    	byte count = 0;
		try {
			count = this.casUserDao.selectCasUserCountByAccount(username);
		} catch (Exception e) {
			resultTO.setMsg("据【手机号】查询【前台用户】的数量 - 失败！异常：");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			logger.error("据【手机号】查询【前台用户】的数量 - 失败！异常：", e);
			
			return resultTO;
		}
    	
    	if(0 < count){
    		CasUser casUser = new CasUser();
    		Map<String, Object> paraMap = new HashMap<String, Object>();
        	paraMap.put("username", username);
        	try {
				casUser = this.casUserDao.selectCasUserByUsernameForMap(paraMap);
				// 3. 比较密码
		        String passwordMd5 = StringUtil.md5(StringUtil.md5(password) + casUser.getSalt());
		        if (!passwordMd5.equals(casUser.getPassword())) {
		        	resultTO.setMsg("密码错误！");
		        	resultTO.setStatus(BaseConstant.STATUS_FAILURE);
		        	return resultTO;
		        }
		        if(casUser.getIsthere()!=null && casUser.getIsthere() ==1){
		        	resultTO.setMsg("此手机号已经被绑定！");
		        	resultTO.setStatus(BaseConstant.STATUS_FAILURE);
		        	return resultTO;
		        }
				casUser.setThirdid(thirdId);
				casUser.setIsthere(Long.valueOf(1));
				casUser.setIsHaveStore((short)1);
				casUserDao.update(casUser);
				resultTO.setData(casUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
    		resultTO.setMsg("绑定成功！");
    		return resultTO;
    	}else{
    		// 混淆码（加盐）
    		String salt = UUIDService.getUUID().subSequence(0, 6).toString();
    		//密码进行MD5加密
    		String passwordMd5Md5 = StringUtil.md5(StringUtil.md5(password) + salt);
    		
    		// 2.保存【前台用户】
    		CasUser casUser = new CasUser();
    		casUser.setAccount(username);
    		casUser.setPassword(passwordMd5Md5);
    		casUser.setSalt(salt);
    		casUser.setThirdid(thirdId);
    		casUser.setDeviceNo("0,0,0");
    		casUser.setIsHaveStore((short)0);
    		//casUser.setThirdLoginType(loginType);
    		//casUser.setHeadportraitpath(headPath);
    		casUser.setStatus((short)1);
    		try {
    			this.casUserDao.insertCasUser(casUser);
    			//更新用户昵称
    			casUser.setNickname("用户"+casUser.getUserId());
    			this.casUserDao.update(casUser);
    			
    			resultTO.setData(casUser);
    			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
    			resultTO.setMsg("绑定成功");
    		} catch (Exception e) {
    			resultTO.setMsg("绑定【用户】 - 失败！");
    			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    			logger.error("绑定【用户】 - 失败！", e);
    		}
    	}
    	

        return resultTO;
	}

	/*
	 *type 0经销商  1维修站
	 * 
	 */
	@Override
	public ResultTO webSendSMSCaptcha(String mobile,String type) {
        logger.info("mobile = " + mobile);
		
		ResultTO resultTO = new ResultTO();
    	
    	if(CommonUtils.isEmpty(mobile)){
    		resultTO.setMsg("【手机号】不可为空！");
    		
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(mobile)){
    		resultTO.setMsg("【手机号】格式不正确！");
    		
    		return resultTO;
    	}
    	
    	byte count = 0;
		try {
			if("0".equals(type)){
				count = this.casUserDao.selectDealerUserCountByAccount(mobile);
			}else{
				count = this.casUserDao.selectRepairUserCountByAccount(mobile);
			}
		} catch (Exception e) {
			resultTO.setMsg("据【用户名】查询【前台用户】的数量 - 失败！异常：");
			
			logger.error("据【用户名】查询【前台用户】的数量 - 失败！异常：", e);
			
			return resultTO;
		}
    	
    	if(0 < count){
    		resultTO.setStatus(0);
    		resultTO.setMsg("【手机号】已存在！");
    		
    		return resultTO;
    	}
    	
    	String randomCode = RandomStringUtils.random(4, false, true);
		logger.info("randomCode = " + randomCode);
		
		try {
			SMSUtils.sendSMS(mobile, randomCode);

			resultTO.setData(randomCode);
			resultTO.setStatus(1);
			resultTO.setMsg("发送短信验证码 - 成功。");
		} catch (Exception e) {
			resultTO.setMsg("发送短信验证码 - 失败！");
		}
    	
    	return resultTO;
	}
	
	@Override
	public ResultTO sendAnySMS(String mobile) {
        logger.info("mobile = " + mobile);
		
		ResultTO resultTO = new ResultTO();
    	
    	if(CommonUtils.isEmpty(mobile)){
    		resultTO.setMsg("【手机号】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(mobile)){
    		resultTO.setMsg("【手机号】格式不正确！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}
    	
    	String randomCode = RandomStringUtils.random(6, false, true);
		logger.info("randomCode = " + randomCode);
		
		try {
			SMSUtils.sendSMS(mobile, randomCode);
			//将验证码存入缓存以便校验
			RedisUtil.setEx("SMSAny_"+mobile, 60, randomCode);
			resultTO.setData(randomCode);
			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
			resultTO.setMsg("发送短信验证码 - 成功。");
		} catch (Exception e) {
			resultTO.setMsg("发送短信验证码 - 失败！");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
		}
    	
    	return resultTO;
	}

	/* (non-Javadoc)
	 * @see com.bluemobi.service.cas.register.RegisterService#register(java.lang.String, java.lang.String, java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ResultTO register(String inviteUserId, String username,
			String password, String validate, HttpServletRequest request) {
			ResultTO resultTO = new ResultTO();
    	
		// 1. 校验参数
    	if(CommonUtils.isEmpty(username)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【手机号】不可为空！ ");
    		
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(username)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【手机号】格式不正确！");
    		
    		return resultTO;
    	} else if(CommonUtils.isEmpty(password)){
    		resultTO.setMsg("【密码】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}else if(CommonUtils.isEmpty(validate)){
    		resultTO.setMsg("【验证码】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}else if(CommonUtils.isEmpty(inviteUserId)){
    		resultTO.setMsg("【邀请人ID】不可为空！");
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		return resultTO;
    	}
    	
    	//验证码输入是否正确
    	/*String prmvalidate = RedisUtil.getString("SMSRegister_"+username);
    	if(!validate.equals(prmvalidate)){
    		resultTO.setStatus(3);
    		resultTO.setMsg("验证码错误存在！");
    		
    		return resultTO;
    	}*/
    	//验证用户是否存在
    	byte count = 0;
		try {
			count = this.casUserDao.selectCasUserCountByAccount(username);
		} catch (Exception e) {
			resultTO.setMsg("据【手机号】查询【前台用户】的数量 - 失败！异常：");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			logger.error("据【手机号】查询【前台用户】的数量 - 失败！异常：", e);
			return resultTO;
		}
    	
    	if(0 < count){
    		resultTO.setStatus(2);
    		resultTO.setMsg("您已经注册过了，请前往App登陆！");
    		return resultTO;
    	}
    	
    	// 混淆码（加盐）
        String salt = UUIDService.getUUID().subSequence(0, 6).toString();
        //密码进行MD5加密
        String passwordMd5Md5 = StringUtil.md5(StringUtil.md5(password) + salt);
    	
    	// 2.保存【前台用户】
    	CasUser casUser = new CasUser();
    	casUser.setAccount(username);
    	casUser.setPassword(passwordMd5Md5);
    	casUser.setSalt(salt);
    	casUser.setStatus((short)1);
    	casUser.setDeviceNo("0,0,0");
    	casUser.setStoreId(Long.valueOf(inviteUserId));
		try {
			this.casUserDao.insertCasUser(casUser);
			//更新用户昵称
			casUser.setNickname("用户"+casUser.getUserId());
			this.casUserDao.update(casUser);
			resultTO.setData(casUser);
			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
	        resultTO.setMsg("注册成功");
		} catch (Exception e) {
			resultTO.setMsg("注册【用户】 - 失败！");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			logger.error("注册【用户】 - 失败！", e);
		}

        return resultTO;
	}
}
