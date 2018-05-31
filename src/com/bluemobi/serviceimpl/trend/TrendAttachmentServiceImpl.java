package com.bluemobi.serviceimpl.trend;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.trend.TrendAttachmentDao;
import com.bluemobi.po.trend.TrendAttachment;
import com.bluemobi.service.trend.TrendAttachmentService;

/**
 * 【】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:49
 * 
 */
@Service(value = "trendAttachmentService")
public class TrendAttachmentServiceImpl extends MybatisBaseServiceImpl implements TrendAttachmentService {

    @Autowired
    private TrendAttachmentDao trendAttachmentDao;

    @Override
    public MyBatisBaseDao getDao() {
        return trendAttachmentDao;
    }

	/* (non-Javadoc)
	 * @see com.bluemobi.service.trend.TrendAttachmentService#insertUploadFile(java.util.Map, com.bluemobi.po.trend.TrendAttachment)
	 */
	@Override
	public int insertUploadFile(Map<String, Object> uploadResultMap,
			TrendAttachment trendAttachment) {
		// TODO Auto-generated method stub
		return 0;
	}

}
