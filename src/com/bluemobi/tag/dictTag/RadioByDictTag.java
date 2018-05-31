package com.bluemobi.tag.dictTag;

import java.util.List;
import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bluemobi.constant.BaseConstant;
import com.bluemobi.util.redisUtil.RedisUtil;
import com.bluemobi.po.dictionary.DictionaryDetail;

public class RadioByDictTag extends TagSupport {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RadioByDictTag.class);
	//id
	private String id;
	//标签name
	private String name;
	//标签value
	private String value;
	//字典类型
	private String dictType;
	//点击事件
	private String onclick;
	
	
	
	
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
        	
        	
        	//校验传入参数
        	if(id == null || "".equals(id)){
        		id = UUID.randomUUID().toString();
        	}
        	//处理onchange事件
        	String onclickStr = (onclick!=null)?(" onclick='"+onclick+"'"):("");
            
            
            //输出前台标签
        	for(int i=0;i<dictionaryDetailList.size();i++){
            	DictionaryDetail dictionaryDetail = dictionaryDetailList.get(i);
            	if(value != null && value.equals(dictionaryDetail.getDictionaryitemid())){
            		//如果当前字典值等于传入value则默认选中
            		out.println("<label class='btn btn-default'>");
            		out.println("<input type='radio'  id='"+id+i+"' "+onclickStr+" name='"+name+"' value='"+dictionaryDetail.getDictionaryitemid()+"' checked>"+dictionaryDetail.getDictionaryitemname()+"</input>");
            		out.println("</label>");
            	}else{
            		out.println("<label class='btn btn-default'>");
            		out.println("<input type='radio' id='"+id+i+"' "+onclickStr+" name='"+name+"' value='"+dictionaryDetail.getDictionaryitemid()+"'>"+dictionaryDetail.getDictionaryitemname()+"</input>");
            		out.println("</label>");
            	}
            }
 
            
        } catch(Exception e) {
            throw new JspException(e.getMessage());
        }

        return SKIP_BODY;

    }

   

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getDictType() {
		return dictType;
	}



	public void setDictType(String dictType) {
		this.dictType = dictType;
	}



	public static Logger getLogger() {
		return LOGGER;
	}



	public String getOnclick() {
		return onclick;
	}



	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

 

   
    
}
