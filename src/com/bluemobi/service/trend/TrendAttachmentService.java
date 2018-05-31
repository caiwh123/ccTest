package com.bluemobi.service.trend;

import java.util.Map;

import com.bluemobi.po.trend.TrendAttachment;
import com.appcore.service.MybatisBaseService;

/**
 * 【attachment user mapping】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2015-10-14 10:33:23
 * 
 */
public interface TrendAttachmentService extends MybatisBaseService {

    abstract int insertUploadFile(Map<String, Object> uploadResultMap, TrendAttachment trendAttachment);

}
