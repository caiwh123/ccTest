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
import com.bluemobi.po.sys.SysLogAction;
import com.bluemobi.service.sys.SysLogActionService;
import com.bluemobi.to.ResultTO;



/**
 * 【系统日志动作】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-01-10 14:38:25
 * 
 */
@Controller
@RequestMapping("a/sysLogAction")
public class SysLogActionController extends AbstractWebController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogActionController.class);
    
    @Autowired
    private SysLogActionService sysLogActionService;
    

    
    /**
     * 进入【系统日志动作】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/sys/logAction.index";
    }
    
    /**
     * 分页查询【系统日志动作】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(Long sysLogActionId, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sysLogActionId", sysLogActionId); 
        Page<Map<String, Object>> page = sysLogActionService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【系统日志动作】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model,HttpServletRequest req, Long sysLogActionId) {
        // 加载公共数据
        intiIndex(model, req);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("sysLogActionId", sysLogActionId); 
        model.addAttribute("sysLogAction", sysLogActionService.selectObject(map));
        return "/view/admin/sys/logAction.detail";
    }
    
    /**
     * 进入新增【系统日志动作】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/sys/logAction.edit";
    }
    
    /**
     * 新增【系统日志动作】数据
     * @param sysLogAction
     * @return ResultTO
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addSysLogAction(@ModelAttribute SysLogAction sysLogAction, BindingResult result) {
        try {
            sysLogActionService.insert(sysLogAction);
            LOGGER.info("用户【{}】添加系统日志动作数据【{}】成功", new Object[] { this.getUserid(), sysLogAction } );
        } catch (Exception e) {
            LOGGER.error("添加数据失败",e);
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【系统日志动作】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model,HttpServletRequest req, Long sysLogActionId) {
        // 加载公共数据
        intiIndex(model, req);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sysLogActionId", sysLogActionId); 
        model.addAttribute("sysLogAction", sysLogActionService.selectObject(map));
        return "/view/admin/sys/logAction.edit";
    }
    
    /**
     * 修改【系统日志动作】数据
     * @param sysLogAction
     * @return ResultTO
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editSysLogAction(@ModelAttribute SysLogAction sysLogAction, BindingResult result) {
        try {
            sysLogActionService.update(sysLogAction);
            LOGGER.info("用户【{}】修改系统日志动作数据【{}】成功", new Object[] { this.getUserid(), sysLogAction } );
        } catch (Exception e) {
            LOGGER.error("修改数据失败", e);
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【系统日志动作】数据
     * @param sysLogActionId
     * @return ResultTO
     * @author AutoCode
     * @date 2017-01-10 14:38:25
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteSysLogAction(Long sysLogActionId) {
        Map<String, Long> map = new HashMap<String, Long>();
        try {
            map.put("sysLogActionId", sysLogActionId); 
            sysLogActionService.delete(map);
            LOGGER.info("用户【{}】删除系统日志动作数据【{}】成功", new Object[] { this.getUserid(), sysLogActionId });
        } catch (Exception e) {
            LOGGER.error("删除数据失败", e);
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
