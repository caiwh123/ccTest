package com.thinkgem.jeesite.common.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Service
public class SystemLogoutFilter extends LogoutFilter {
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		
		if(subject != null && subject.getPrincipal() != null){
			String userLoginType = ((Principal) subject.getPrincipal()).getUserLoginType();
			if (StringUtils.equals(userLoginType, UserUtils.USER_LOGIN_TYPE_SHANGHU)) {
				setRedirectUrl("/a/shanghuLogin");
			}else{
				setRedirectUrl("/a");
			}
		}else{
			setRedirectUrl("/a");
		}


		String redirectUrl = getRedirectUrl(request, response, subject);

		try {

			subject.logout();

		} catch (SessionException ise) {

			ise.printStackTrace();

		}

		issueRedirect(request, response, redirectUrl);

		return false;

	}
}