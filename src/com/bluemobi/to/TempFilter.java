package com.bluemobi.to;

import java.util.List;

public class TempFilter {

	//过滤的一级id
	private String optionId;
	//过滤的一级名称
	private String optionName;
	//过滤的二级列表
    private List<TempFilter> filterList;
	public String getOptionId() {
		return optionId;
	}
	public String getOptionName() {
		return optionName;
	}
	public List<TempFilter> getFilterList() {
		return filterList;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public void setFilterList(List<TempFilter> filterList) {
		this.filterList = filterList;
	}
    
    
}
