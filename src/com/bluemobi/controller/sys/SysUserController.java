package com.bluemobi.controller.sys;
import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import com.appcore.page.Page;
import com.bluemobi.controller.AbstractWebController;
import com.bluemobi.po.sys.SysUser;
import com.bluemobi.service.sys.SysUserService;
import com.bluemobi.to.ResultTO;



/**
 * 【】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:01
 * 
 */
@Controller
@RequestMapping("a/sysUser")
public class SysUserController extends AbstractWebController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);
    
    @Autowired
    private SysUserService sysUserService;
    

    
    /**
     * 进入【】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/sys/user.index";
    }
    
    /**
     * 分页查询【】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String id, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        Page<Map<String, Object>> page = sysUserService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model,HttpServletRequest req, String id) {
        // 加载公共数据
        intiIndex(model, req);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("sysUser", sysUserService.selectObject(map));
        return "/view/admin/sys/user.detail";
    }
    
    /**
     * 进入新增【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/sys/user.edit";
    }
    
    /**
     * 新增【】数据
     * @param sysUser
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addSysUser(@ModelAttribute SysUser sysUser, BindingResult result) {
        try {
            sysUserService.insert(sysUser);
            LOGGER.info("用户【{}】添加数据【{}】成功", new Object[] { this.getUserid(), sysUser } );
        } catch (Exception e) {
            LOGGER.error("添加数据失败",e);
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model,HttpServletRequest req, String id) {
        // 加载公共数据
        intiIndex(model, req);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("sysUser", sysUserService.selectObject(map));
        return "/view/admin/sys/user.edit";
    }
    
    /**
     * 修改【】数据
     * @param sysUser
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editSysUser(@ModelAttribute SysUser sysUser, BindingResult result) {
        try {
            sysUserService.update(sysUser);
            LOGGER.info("用户【{}】修改数据【{}】成功", new Object[] { this.getUserid(), sysUser } );
        } catch (Exception e) {
            LOGGER.error("修改数据失败", e);
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-17 18:01:01
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteSysUser(String id) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            map.put("id", id); 
            sysUserService.delete(map);
            LOGGER.info("用户【{}】删除数据【{}】成功", new Object[] { this.getUserid(), id });
        } catch (Exception e) {
            LOGGER.error("删除数据失败", e);
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
