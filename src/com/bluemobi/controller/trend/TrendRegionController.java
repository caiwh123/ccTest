package com.bluemobi.controller.trend;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.controller.AbstractWebController;
import com.bluemobi.po.trend.TrendRegion;
import com.bluemobi.service.trend.TrendRegionService;
import com.bluemobi.to.ResultTO;



/**
 * 【】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:49
 * 
 */
@Controller
@RequestMapping("a/trendRegion")
public class TrendRegionController extends AbstractWebController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TrendRegionController.class);
    @Autowired
    private  TrendRegionService trendRegionService;
    /**
     * 查询所有省级
     */
    @RequestMapping(value = "selectProvinceList", method = RequestMethod.POST)
    @ResponseBody
    public   ResultTO selectProvinceList() {
    	ResultTO resultTO = new ResultTO();
        try {
        	Map<String,Object>  map = new HashMap<String, Object>();
        	map.put("grade", 2);
        	List<TrendRegion> regionList = this.trendRegionService.selectObjectList(map);
        	resultTO.setData(regionList);
        	resultTO.setStatus(0);
        	resultTO.setMsg("查询省级成功！");
            LOGGER.info("查询省级成功！");
        } catch (Exception e) {
        	resultTO.setStatus(1);
        	resultTO.setMsg("查询省级失败！");
            LOGGER.error("查询省级失败",e);
            return resultTO;
        }
        return resultTO;
    }
    /**
     * 根据省来查询市级
     * @return
     */
    
    @RequestMapping(value = "selectCityList", method = RequestMethod.POST)
    @ResponseBody
    public  ResultTO selectCityList(String provinceId) {
    	ResultTO resultTO = new ResultTO();
        try {
        	Map<String,Object>  map = new HashMap<String, Object>();
        	map.put("pid", provinceId);
        	map.put("grade", 3);
        	List<TrendRegion> regionList = this.trendRegionService.selectObjectList(map);
        	resultTO.setData(regionList);
        	resultTO.setStatus(0);
        	resultTO.setMsg("查询市级成功！");
            LOGGER.info("查询市级成功！");
        } catch (Exception e) {
        	resultTO.setStatus(1);
        	resultTO.setMsg("查询市级失败！");
            LOGGER.error("查询市级失败",e);
            return resultTO;
        }
        return resultTO;
    }
    /**
     * 根据市来查询区
     * @return
     */
    
    @RequestMapping(value = "selectAreaList", method = RequestMethod.POST)
    @ResponseBody
    public  ResultTO selectAreaList(String cityId) {
    	ResultTO resultTO = new ResultTO();
        try {
        	Map<String,Object>  map = new HashMap<String, Object>();
        	map.put("pid", cityId);
        	map.put("grade", 4);
        	List<TrendRegion> regionList = this.trendRegionService.selectObjectList(map);
        	resultTO.setData(regionList);
        	resultTO.setStatus(0);
        	resultTO.setMsg("查询区成功！");
            LOGGER.info("查询市级成功！");
        } catch (Exception e) {
        	resultTO.setStatus(1);
        	resultTO.setMsg("查询市级失败！");
            LOGGER.error("查询市级失败",e);
            return resultTO;
        }
        return resultTO;
    }

   
    
}
