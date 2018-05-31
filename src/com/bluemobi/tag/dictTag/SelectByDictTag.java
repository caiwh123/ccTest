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

public class SelectByDictTag extends TagSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(SelectByDictTag.class);
	// id
	private String id;
	// 标签name
	private String name;
	// 标签value
	private String value;
	// 字典类型
	private String dictType;
	// 点击事件
	private String onclick;
	// 选择事件事件
	private String onchange;
	// 样式
	private String selectClass;
	// 为空时内容
	private String nullName;
	// 不显示的值
	private String noShowValue;
	//是否不能编辑
	private String onmousedown;

	@Override
	public int doStartTag() throws JspException {

		try {
			// 初始化输出流
			JspWriter out = this.pageContext.getOut();
			// 根据字典类型从缓存获取字典列表
			List<DictionaryDetail> dictionaryDetailList = (List<DictionaryDetail>) RedisUtil.getHash(BaseConstant.DICT,
					dictType);

			if (dictionaryDetailList == null) {
				LOGGER.error("根据数据字典类型dictType=" + dictType + "在缓存中没有找到相应的字典数据");
				return SKIP_BODY;
			}

			// 校验传入参数
			if (id == null || "".equals(id)) {
				id = UUID.randomUUID().toString();
			}
			// 处理onchange事件
			String onchangeStr = (onchange != null) ? (" onchange='" + onchange + "'") : ("");

			// 处理不显示的值
			String[] noShowValues = {};
			if (noShowValue != null && !noShowValue.equals("")) {
				noShowValues = noShowValue.split(",");
			}
			
			//处理不可编辑值
			String onmousedownStr = "";
			if(onmousedown != null && !onmousedown.equals("")){
				onmousedownStr = "onmousedown='"+onmousedown+"'";
			}

			// 输出前台标签

			out.println(
					"<select  id='" + id + "' class='" + selectClass + "' name='" + name + "' " + onchangeStr +" "+onmousedownStr+">");
			out.println("<option value=''>" + (nullName == null ? "请选择" : nullName) + "</option>");
			for (int i = 0; i < dictionaryDetailList.size(); i++) {
				DictionaryDetail dictionaryDetail = dictionaryDetailList.get(i);
				if (noShowValues.length > 0) {
					boolean flag = true;
					for (int j = 0; j < noShowValues.length; j++) {
						if (noShowValues[j].equals(dictionaryDetail.getDictionaryid())) {
							// 如果当前码表值与不显示的值不相等则拼接标签
							flag = false;
						}
					}
					if(flag){
						if (value != null && value.equals(dictionaryDetail.getDictionaryid())) {
							// 如果当前字典值等于传入value则默认选中
							out.println("<option value='" + dictionaryDetail.getDictionaryid() + "' selected>"
									+ dictionaryDetail.getDictionaryitemname() + "</option>");
						} else {
							out.println("<option value='" + dictionaryDetail.getDictionaryid() + "'>"
									+ dictionaryDetail.getDictionaryitemname() + "</option>");
						}
					}
				} else {
					if (value != null && value.equals(dictionaryDetail.getDictionaryid())) {
						// 如果当前字典值等于传入value则默认选中
						out.println("<option value='" + dictionaryDetail.getDictionaryid() + "' selected>"
								+ dictionaryDetail.getDictionaryitemname() + "</option>");
					} else {
						out.println("<option value='" + dictionaryDetail.getDictionaryid() + "'>"
								+ dictionaryDetail.getDictionaryitemname() + "</option>");
					}
				}

			}
			out.println("</select>");
		} catch (Exception e) {
			LOGGER.error("tag error", e);
			throw new JspException(e.getMessage());
		}

		return SKIP_BODY;

	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public String getNoShowValue() {
		return noShowValue;
	}

	public void setNoShowValue(String noShowValue) {
		this.noShowValue = noShowValue;
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

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(String selectClass) {
		this.selectClass = selectClass;
	}

	public String getNullName() {
		return nullName;
	}

	public void setNullName(String nullName) {
		this.nullName = nullName;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	
	
}
