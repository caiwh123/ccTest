package com.bluemobi.controller.trend;
import java.math.BigDecimal;
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

import com.appcore.page.Page;
import com.bluemobi.controller.AbstractWebController;
import com.bluemobi.po.trend.TrendAttachment;
import com.bluemobi.service.trend.TrendAttachmentService;
import com.bluemobi.to.ResultTO;



/**
 * 【】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:49
 * 
 */
@Controller
@RequestMapping("back/trendAttachment")
public class TrendAttachmentController extends AbstractWebController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TrendAttachmentController.class);
    
    @Autowired
    private TrendAttachmentService trendAttachmentService;
    

    
    /**
     * 进入【】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "back/trend/attachment.index";
    }
    
    /**
     * 分页查询【】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String, Object>> page = trendAttachmentService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, BigDecimal attachmentid) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("attachmentid", attachmentid); 
        model.addAttribute("trendAttachment", trendAttachmentService.selectObject(map));
        return "back/trend/attachment.detail";
    }
    
    /**
     * 进入新增【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "back/trend/attachment.edit";
    }
    
    /**
     * 新增【】数据
     * @param trendAttachment
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addTrendAttachment(@ModelAttribute TrendAttachment trendAttachment, BindingResult result) {
        try {
            trendAttachmentService.insert(trendAttachment);
            LOGGER.info("用户【{}】添加数据【{}】成功", new Object[] { this.getUserid(), trendAttachment } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加数据【{}】失败 Exception:【{}】", new Object[] { this.getUserid(), trendAttachment, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, BigDecimal attachmentid) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("attachmentid", attachmentid); 
        model.addAttribute("trendAttachment", trendAttachmentService.selectObject(map));
        return "back/trend/attachment.edit";
    }
    
    /**
     * 修改【】数据
     * @param trendAttachment
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editTrendAttachment(@ModelAttribute TrendAttachment trendAttachment, BindingResult result) {
        try {
            trendAttachmentService.update(trendAttachment);
            LOGGER.info("用户【{}】修改数据【{}】成功", new Object[] { this.getUserid(), trendAttachment } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改数据【{}】失败 Exception:【{}】", new Object[] { this.getUserid(), trendAttachment, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【】数据
     * @param attachmentid
     * @return ResultTO
     * @author AutoCode
     * @date 2017-10-16 14:54:49
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteTrendAttachment(BigDecimal attachmentid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("attachmentid", attachmentid); 
            trendAttachmentService.delete(map);
            LOGGER.info("用户【{}】删除数据【{}】成功", new Object[] { this.getUserid(), attachmentid });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除数据【{}】失败 Exception:【{}】", new Object[] { this.getUserid(), attachmentid, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
