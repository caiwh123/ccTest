package com.bluemobi.tag.dictTag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluemobi.constant.BaseConstant;
import com.bluemobi.util.redisUtil.RedisUtil;
import com.bluemobi.po.dictionary.DictionaryDetail;

public class InputByDictTag extends TagSupport {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InputByDictTag.class);
	//字典类型
	private String dictType;
	//字典项ID
	private String dictItemId;
	
	
	
	@Override
    public int doStartTag() throws JspException {

        try {
        	
        	//初始化输出流
        	JspWriter out = this.pageContext.getOut();
        	//根据字典类型从缓存获取字典列表
        	List<DictionaryDetail> dictionaryDetailList = (List<DictionaryDetail>) RedisUtil.getHash(BaseConstant.DICT, dictType);
        	
        	
        	if(dictionaryDetailList == null){
        		LOGGER.error("根据数据字典类型dictType="+dictType+"在缓存中没有找到相应的字典数据");
        		return SKIP_BODY;
        	}
        	
        	//数据字典中文
        	String dictName = "";
        	for(int i=0;i<dictionaryDetailList.size();i++){
        		if(dictItemId.equals(dictionaryDetailList.get(i).getDictionaryitemid())){
        			dictName = dictionaryDetailList.get(i).getDictionaryitemname();
        		}
        	}
        	
            
            
            //输出前台标签
            out.println(dictName);
 
            
        } catch(Exception e) {
            throw new JspException(e.getMessage());
        }

        return SKIP_BODY;

    }

   

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

 

    @Override
    public void release() {
        super.release();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItemId() {
		return dictItemId;
	}

	public void setDictItemId(String dictItemId) {
		this.dictItemId = dictItemId;
	}
    
}
