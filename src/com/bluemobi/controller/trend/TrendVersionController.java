package com.bluemobi.controller.trend;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import cn.jiguang.common.utils.StringUtils;
import com.bluemobi.util.CommonUtils;
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
import com.bluemobi.po.trend.TrendVersion;
import com.bluemobi.service.trend.TrendVersionService;
import com.bluemobi.to.ResultTO;



/**
 * 【】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2018-01-10 16:14:07
 * 
 */
@Controller
@RequestMapping("a/trendVersion")
public class TrendVersionController extends AbstractWebController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TrendVersionController.class);
    
    @Autowired
    private TrendVersionService trendVersionService;
    

    
    /**
     * 进入【】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/trend/version.index";
    }
    
    /**
     * 分页查询【】
     * @param
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String platform, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotEmpty(platform)){
            map.put("platform", platform);
        }
        Page<Map<String, Object>> page = trendVersionService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model,HttpServletRequest req, String id) {
        // 加载公共数据
        intiIndex(model, req);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("version", trendVersionService.selectObject(map));
        return "/view/admin/trend/version.detail";
    }
    
    /**
     * 进入新增【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model,HttpServletRequest req) {
        // 加载公共数据
        intiIndex(model, req);
        return "/view/admin/trend/version.edit";
    }
    
    /**
     * 新增【】数据
     * @param trendVersion
     * @return ResultTO
     * @author AutoCode
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addTrendVersion(@ModelAttribute TrendVersion trendVersion, BindingResult result) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trendVersion.setCtime(sdf.format(new Date()));
            trendVersion.setId(CommonUtils.UUIDGenerator());
            trendVersionService.insert(trendVersion);
            LOGGER.info("用户【{}】添加数据【{}】成功", new Object[] { this.getUserid(), trendVersion } );
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
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model,HttpServletRequest req, String id) {
        // 加载公共数据
        intiIndex(model, req);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("version", trendVersionService.selectObject(map));
        return "/view/admin/trend/version.edit";
    }
    
    /**
     * 修改【】数据
     * @param trendVersion
     * @return ResultTO
     * @author AutoCode
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editTrendVersion(@ModelAttribute TrendVersion trendVersion, BindingResult result) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            trendVersion.setMtime(sdf.format(new Date()));
            trendVersionService.update(trendVersion);
            LOGGER.info("用户【{}】修改数据【{}】成功", new Object[] { this.getUserid(), trendVersion } );
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
     * @date 2018-01-10 16:14:07
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteTrendVersion(Long id) {
        Map<String, Long> map = new HashMap<String, Long>();
        try {
            map.put("id", id); 
            trendVersionService.delete(map);
            LOGGER.info("用户【{}】删除数据【{}】成功", new Object[] { this.getUserid(), id });
        } catch (Exception e) {
            LOGGER.error("删除数据失败", e);
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
