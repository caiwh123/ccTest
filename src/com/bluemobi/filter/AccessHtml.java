package com.bluemobi.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appcore.context.AppContext;
import com.appcore.security.AccessToken;
import com.appcore.service.TokenService;
import com.appcore.util.AjaxUtil;
import com.appcore.util.CookieUtil;
import com.appcore.util.SessionUtil;
import com.bluemobi.constant.BaseConstant;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;


/**
 * AccessFilter过滤
 * @author heweiwen
 * 2015-6-18 下午4:04:23
 */
public class AccessHtml implements Filter {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessHtml.class);
   
    public void destroy() {
    }
 
    
    /**pa
     * 过滤器
     */
    public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
    	//设置所有访问都授权（跨域访问用）
    	HttpServletResponse httpResp = (HttpServletResponse) resp;
    	httpResp.setHeader("Access-Control-Allow-Origin", "*");
    	chain.doFilter(req, resp);
    }


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

   
}
