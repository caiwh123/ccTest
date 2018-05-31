package com.bluemobi.controller.sys;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
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
import com.bluemobi.po.sys.SysArea;
import com.bluemobi.service.sys.SysAreaService;
import com.bluemobi.to.ResultTO;



/**
 * 【】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:00
 * 
 */
@Controller
@RequestMapping("a/sysArea")
public class SysAreaController extends AbstractWebController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SysAreaController.class);
    
    @Autowired
    private SysAreaService sysAreaService;
    

    
    /**
     * 进入【】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/sys/area.index";
    }
    
    /**
     * 分页查询【】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(BigDecimal id, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        Page<Map<String, Object>> page = sysAreaService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model,HttpServletRequest req, BigDecimal id) {
        // 加载公共数据
        intiIndex(model, req);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("sysArea", sysAreaService.selectObject(map));
        return "/view/admin/sys/area.detail";
    }
    
  
    /**
     * 进入新增【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/sys/area.edit";
    }
    
    /**
     * 新增【】数据
     * @param sysArea
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addSysArea(@ModelAttribute SysArea sysArea, BindingResult result) {
        try {
            sysAreaService.insert(sysArea);
            LOGGER.info("用户【{}】添加数据【{}】成功", new Object[] { this.getUserid(), sysArea } );
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
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model,HttpServletRequest req, BigDecimal id) {
        // 加载公共数据
        intiIndex(model, req);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("sysArea", sysAreaService.selectObject(map));
        return "/view/admin/sys/area.edit";
    }
    
    @RequestMapping(value = "selectAllArea", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO selectAllArea(Model model,HttpServletRequest req, String type,String parentId) {
    	ResultTO resultTO = new ResultTO();
        // 加载公共数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type",type); 
        map.put("parentId", parentId);
        map.put("delFlag", 0);
        List<SysArea> areaList = this.sysAreaService.selectObjectList(map);
        resultTO.setData(areaList);
        resultTO.setMsg("查询成功!");
        resultTO.setStatus(0);
        return resultTO;
    }
    
    
    /**
     * 修改【】数据
     * @param sysArea
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editSysArea(@ModelAttribute SysArea sysArea, BindingResult result) {
        try {
            sysAreaService.update(sysArea);
            LOGGER.info("用户【{}】修改数据【{}】成功", new Object[] { this.getUserid(), sysArea } );
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
     * @date 2017-10-17 18:01:00
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteSysArea(BigDecimal id) {
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        try {
            map.put("id", id); 
            sysAreaService.delete(map);
            LOGGER.info("用户【{}】删除数据【{}】成功", new Object[] { this.getUserid(), id });
        } catch (Exception e) {
            LOGGER.error("删除数据失败", e);
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
