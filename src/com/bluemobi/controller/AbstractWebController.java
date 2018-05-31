package com.bluemobi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 抽象的web控制器
 * @Description
 * @author haojian 309444359@qq.com
 * @date 2015-10-26 下午5:14:41 
 *
 */
public abstract class AbstractWebController extends AbstractController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractWebController.class);
    
    /**
     * 获取userId
     * @author haojian
     * @date 2015-10-15 上午10:09:30 
     * @return
     * @return int
     */
    public String getUserid() {

      // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
/*
       // 1、校验客户端cookie里面的token是否为空
       String tokenId = CookieUtil.getCookieValue(request, SessionUtil.bm_token);
       
       if(tokenId==null||"".equals(tokenId)){
           LOGGER.error("来自【{}】的请求中没有tokenId", request.getRemoteAddr());
            return 0;
       }

       // 2、校验服务端自定义session里面的accessToken对象是否为空
       TokenService tokenService = (TokenService) AppContext.getBean("tokenService");
       AccessToken accessToken = tokenService.checkToken(tokenId);*/
       
      // int userid = Integer.valueOf(accessToken.getUserId());
       String userid = UserUtils.getPrincipal().getId();

       return userid;
    //return 0;
    }
    
    public void initIndex(Model model) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	intiIndex(model, request);
    }

    /**
     * 初始化界面调用
     * 
     * @author HeWeiwen 2015-7-17
     * @param model
     * @param req
     */
    public void intiIndex(Model model, HttpServletRequest req) {

//        if (AjaxUtil.checkIsAjax(req)) {
//            LOGGER.debug("ajax请求，不查询导航栏！");
//            return;
//        }
//
//        AdminUser user = (AdminUser) SessionUtil.getAttribute(req, BaseConstant.KEY_USER);
//
//        List<Integer> allowNavs = systemNavigationService.getAllowNavigations(user);
//
//        model.addAttribute("loggedInUser", user);
//
//        model.addAttribute("allow_navs", allowNavs.toString());
//
//        List<SystemNavigation> sysTop = new ArrayList<SystemNavigation>();
//        List<SystemNavigation> sysTwo = new ArrayList<SystemNavigation>();
//        List<SystemNavigation> sysThree = new ArrayList<SystemNavigation>();
//        // 1:表示显示，0：表示不现实
//        Map<String, Byte> map = new HashMap<String, Byte>();
//        map.put("status", (byte) 1);
//        List<SystemNavigation> systemnavigation = systemNavigationService.selectObjectList(map);    
//        //重组数据
//        for (SystemNavigation sys : systemnavigation) {
//            if (sys.getHid().length() == 6) {
//                sysTop.add(sys);
//            } else if (sys.getHid().length() == 11) {
//                sysTwo.add(sys);
//            } else if (sys.getHid().length() == 16) {
//                sysThree.add(sys);
//            }
//        }
//        //给超级用户放开全部菜单
//        if (user.getUserid() == 1) {
//            model.addAttribute("nav_top", sysTop);
//            model.addAttribute("nav_two", sysTwo);
//            model.addAttribute("nav_three", sysThree);
//            return;
//        }
//        // 通过获得用户的NavigationId，来获得左侧菜单显示对象
//        List<SystemNavigation> sysTwoPermission = new ArrayList<SystemNavigation>();
//        List<SystemNavigation> sysThreePermission = new ArrayList<SystemNavigation>();
//        for (int i = 0; i < sysTwo.size(); i++) {
//            if (allowNavs.contains(sysTwo.get(i).getNavigationId())) {
//                sysTwoPermission.add(sysTwo.get(i));
//            }
//        }
//        for (int i = 0; i < sysThree.size(); i++) {
//            if (allowNavs.contains(sysThree.get(i).getNavigationId())) {
//                sysThreePermission.add(sysThree.get(i));
//            }
//        }
//        model.addAttribute("nav_top", sysTop);
//        model.addAttribute("nav_two", sysTwoPermission);
//        model.addAttribute("nav_three", sysThreePermission);
    }

   
}
