package com.bluemobi.serviceimpl.cas.login;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.bluemobi.service.cas.login.LoginService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.util.CommonUtils;
import com.bluemobi.util.SMSUtils;
import com.bluemobi.util.StringUtil;
import com.bluemobi.util.UUIDService;
import com.bluemobi.util.redisUtil.RedisUtil;

@Service(value = "loginService")
public class LoginServiceImpl extends MybatisBaseServiceImpl implements LoginService {
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

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
    		
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(mobile)){
    		resultTO.setMsg("【手机号】格式不正确！");
    		
    		return resultTO;
    	}
    	
    	byte count = 0;
		try {
			count = this.casUserDao.selectCasUserCountByAccount(mobile);
		} catch (Exception e) {
			resultTO.setMsg("据【用户名】查询【前台用户】的数量 - 失败！异常：");
			
			logger.error("据【用户名】查询【前台用户】的数量 - 失败！异常：", e);
			
			return resultTO;
		}
    	
    	if(0 >= count){
    		resultTO.setMsg("【手机号】不存在！");
    		resultTO.setStatus(2);
    		return resultTO;
    	}
    	
    	String randomCode = RandomStringUtils.random(6, false, true);
		logger.info("randomCode = " + randomCode);
		
		try {
			SMSUtils.sendSMS(mobile, randomCode);
			//将验证码存入缓存以便校验
			RedisUtil.setEx("SMSForget_"+mobile, 60, randomCode);
			
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
	public ResultTO login(String username, String password) {
		
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
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【密码】不可为空！");
    		
    		return resultTO;
    	}
    	
    	// 2.查询【前台用户】
    	CasUser casUser = null;
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	paraMap.put("username", username);
    	//paraMap.put("imgPath", CommonUtils.getImgerverPath());
		try {
			casUser = this.casUserDao.selectCasUserByUsernameForMap(paraMap);
			resultTO.setMsg("根据【手机号】查询【前台用户】 - 成功。");
		} catch (Exception e) {
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			resultTO.setMsg("根据【手机号】查询【前台用户】 - 失败！");
			logger.error("根据【手机号】查询【前台用户】 - 失败！", e);
			return resultTO;
		}
		
		if (null == casUser) {
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
        	resultTO.setMsg("手机号或密码错误！");
            
        	return resultTO;
        }

		// 3. 比较密码
        String passwordMd5 = StringUtil.md5(StringUtil.md5(password) + casUser.getSalt());
        
        if (!passwordMd5.equals(casUser.getPassword())) {
        	resultTO.setMsg("手机号或密码错误！");
        	resultTO.setStatus(BaseConstant.STATUS_FAILURE);
        	return resultTO;
        }
		
		if(casUser.getStatus() != 1){
			resultTO.setMsg("用户已冻结,请联系管理员！");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			return resultTO;
		}
		try {
			if(casUser.getStoreId()!=null && casUser.getStoreId()!=0){
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		//重置图片的路径
		String headPath = casUser.getHeadportraitpath();
		if(headPath!=""&&headPath != null){
			if(!headPath.contains("http")){
				headPath = CommonUtils.getImgerverPath()+headPath;
				casUser.setHeadportraitpath(headPath);
			}
		}
        resultTO.setData(casUser);
        resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
        resultTO.setMsg("登录成功");

        return resultTO;
	}
	
	@SuppressWarnings("null")
	@Override
	public ResultTO fastLogin(String username, String validate) {
		
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
    	} /*else if(CommonUtils.isEmpty(validate)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【验证码】不可为空！");
    		
    		return resultTO;
    	}*/
    	
    	// 2.查询【前台用户】
    	CasUser casUser1 = new CasUser();
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	paraMap.put("username", username);
    	//paraMap.put("imgPath", CommonUtils.getImgerverPath());
		try {
			casUser1 = this.casUserDao.selectCasUserByUsernameForMap(paraMap);
			resultTO.setMsg("根据【手机号】查询【前台用户】 - 成功。");
		} catch (Exception e) {
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			resultTO.setMsg("根据【手机号】查询【前台用户】 - 失败！");
			logger.error("根据【手机号】查询【前台用户】 - 失败！", e);
			return resultTO;
		}
		
		//验证码输入是否正确
    	/*String prmvalidate = RedisUtil.getString("SMSRegister_"+username);
    	if(!validate.equals(prmvalidate)){
    		resultTO.setStatus(3);
    		resultTO.setMsg("验证码错误存在！");
    		
    		return resultTO;
    	}*/
		
		if(casUser1.getStatus() != 1){
			resultTO.setMsg("用户已冻结,请联系管理员！");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			return resultTO;
		}
		//重置图片的路径
		String headPath = casUser1.getHeadportraitpath();
		if(headPath!=""&&headPath != null){
			if(!headPath.contains("http")){
				headPath = CommonUtils.getImgerverPath()+headPath;
				casUser1.setHeadportraitpath(headPath);
			}
		}
        resultTO.setData(casUser1);
        resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
        resultTO.setMsg("登录成功");

        return resultTO;
	}
	
	@Override
	public ResultTO thirdLogin(String thirdId) {
        ResultTO resultTO = new ResultTO();
    	
		// 1. 校验参数
    	if(CommonUtils.isEmpty(thirdId)){
    		resultTO.setStatus(BaseConstant.STATUS_FAILURE);
    		resultTO.setMsg("【三方id】不可为空！");
    		
    		return resultTO;
    	} 
    	
    	// 2.查询【前台用户】
    	CasUser casUser = null;
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	paraMap.put("thirdId", thirdId);
		try {
			casUser = this.casUserDao.selectCasUserByThirdId(paraMap);
			resultTO.setMsg("根据【三方id】查询【前台用户】 - 成功。");
		} catch (Exception e) {
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			resultTO.setMsg("根据【三方id】查询【前台用户】 - 失败！");
			logger.error("根据【三方id】查询【前台用户】 - 失败！", e);
			return resultTO;
		}
		
		if (null == casUser) {
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
        	resultTO.setMsg("该用户不存在！");
            
        	return resultTO;
        }
		if(casUser.getStatus() != 1){
			resultTO.setMsg("用户已冻结,请联系管理员！");
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			return resultTO;
		}
		//重置图片的路径
		String headPath = casUser.getHeadportraitpath();
		if(headPath!=""&&headPath != null){
			if(!headPath.contains("http")){
				headPath = CommonUtils.getImgerverPath()+headPath;
				casUser.setHeadportraitpath(headPath);
			}
		}
		resultTO.setData(casUser);
        resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
        resultTO.setMsg("三方用户存在");

        return resultTO;
	}
	
	@Override
	public ResultTO updateCasUser4passwordByUsername(String username, String newPassword, String reNewPassword) {
		logger.info("username = " + username);
		
		ResultTO resultTO = new ResultTO();
    	
		// 1. 校验参数
    	if(CommonUtils.isEmpty(username)){
    		resultTO.setStatus(BaseConstant.ACTION_STATUS_VALUE_NULL);
    		resultTO.setMsg("【手机号】不可为空！");
    		
    		return resultTO;
    	} else if(!CommonUtils.isMobilePhoneCode(username)){
    		resultTO.setStatus(BaseConstant.ACTION_STATUS_FORMAT_ERROR);
    		resultTO.setMsg("【手机号】格式不正确！");
    		
    		return resultTO;
    	} else if(CommonUtils.isEmpty(newPassword)){
    		resultTO.setStatus(BaseConstant.ACTION_STATUS_VALUE_NULL);
    		resultTO.setMsg("【新密码】不可为空！");
    		
    		return resultTO;
    	} else if(!newPassword.equals(reNewPassword)){
    		resultTO.setStatus(BaseConstant.ACTION_STATUS_NOT_EQUALS);
    		resultTO.setMsg("【新密码】不一致！");
    		
    		return resultTO;
    	}
    	
    	// 2. 查询【前台用户】
    	CasUser casUser = null;
		try {
			casUser = this.casUserDao.selectCasUserByUsername(username);
			
			resultTO.setStatus(BaseConstant.ACTION_STATUS_SELECT_SUCCESS);
    		resultTO.setMsg("根据【用户名】查询【前台用户】 - 成功。");
		} catch (Exception e) {
			resultTO.setStatus(BaseConstant.ACTION_STATUS_SELECT_FAILURE);
			resultTO.setMsg("根据【用户名】查询【前台用户】 - 失败！");
			
			logger.error("根据【用户名】查询【前台用户】 - 失败！异常：", e);
			
			return resultTO;
		}
    	
    	if(null == casUser){
    		resultTO.setStatus(BaseConstant.ACTION_STATUS_NOT_EQUALS);
    		resultTO.setMsg("【手机号】不存在！");
    		
    		return resultTO;
    	}    	   	
    	
    	// 5. 更新为新密码
    	String newPasswordMD5 = StringUtil.md5(StringUtil.md5(newPassword) + casUser.getSalt());
    	
    	Map<String, String> requestMap = new HashMap<String, String>();
    	requestMap.put("username", username);
    	requestMap.put("newPasswordMD5", newPasswordMD5);
    	
    	try {
    		this.casUserDao.updateCasUser4passwordByUsername(requestMap);
			
			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
    		resultTO.setMsg("根据【用户名】更新【前台用户】的【密码】 - 成功。");
		} catch (Exception e) {
			resultTO.setStatus(BaseConstant.STATUS_FAILURE);
			resultTO.setMsg("根据【用户名】更新【前台用户】的【密码】 - 失败！");
			
			logger.error("根据【用户名】更新【前台用户】的【密码】 - 失败！异常：", e);
		}
    	
    	casUser.setPassword(newPasswordMD5);
    	resultTO.setData(casUser);
    	
    	return resultTO;
	}

	@Override
	public ResultTO updateCasUser4passwordByAccount(String account,
			String password,String validate) {
		ResultTO resultTO = new ResultTO();
		if(null==account || "".equals(account)){
			resultTO.setMsg("账户不能为空");
			return resultTO;
		}
		if(null==password || "".equals(password)){
			resultTO.setMsg("密码不能为空");
			return resultTO;
		}
		if(null==validate || "".equals(validate)){
			resultTO.setMsg("验证码不能为空");
			return resultTO;
		}
		//验证码输入是否正确
    	/*String prmvalidate = (String) RedisUtil.getString("SMSForget_"+account);
    	if(!validate.equals(prmvalidate)){
    		resultTO.setStatus(3);
    		resultTO.setMsg("验证码错误存在！");
    		
    		return resultTO;
    	}*/
		
		Map<String, String> requestMap = new HashMap<String, String>();
    	requestMap.put("account", account);
    	// 混淆码（加盐）
        String salt = UUIDService.getUUID().subSequence(0, 6).toString();
        //密码进行MD5加密
        String passwordMd5Md5 = StringUtil.md5(StringUtil.md5(password) + salt);
    	requestMap.put("password", passwordMd5Md5);
    	requestMap.put("salt", salt);
    	
    	try {
			this.casUserDao.updateCasUser4passwordByAccount(requestMap);
			resultTO.setMsg("修改密码成功");
			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultTO.setMsg("修改密码失败");
		}
		return resultTO;
	}

	@Override
	public CasUser selectThirdByThirdIdAndThirdLoginType(CasUser casUser) {
		casUser = this.casUserDao.selectThirdByThirdIdAndThirdLoginType(casUser);
		return casUser;
	}

	@Override
	public void insertCasUser(CasUser casUser) throws Exception {
		this.casUserDao.insertCasUser(casUser);
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtil.md5(StringUtil.md5("123456") + "d90fd2"));
	}
	
	@Override
	public ResultTO setHeadPath(String userId,String headPath, String nickName,String gendar) {
		ResultTO resultTO = new ResultTO();
		if(null==nickName || "".equals(nickName)){
			resultTO.setMsg("昵称不能为空");
			return resultTO;
		}
		
		CasUser casUser = new CasUser();
		casUser.setUserId(userId);
		if(headPath != null&&!"".equals(headPath)){
			casUser.setHeadportraitpath(headPath);
		}
		if(gendar != null&&!"".equals(gendar)){
			casUser.setGender(Short.valueOf(gendar));
		}
		casUser.setNickname(nickName);
    	try {
			this.casUserDao.update(casUser);
			resultTO.setMsg("资料补充成功");
			resultTO.setStatus(BaseConstant.STATUS_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultTO.setMsg("资料补充失败");
		}
		return resultTO;
	}
}
