package com.bluemobi.to;

import java.util.List;

public class TempBigMapType {
	// 景点主键id
    private Integer viewAreaId;
    // 景点名称
    private String areaName;
    // 景点图片
    private String image;
    // 景点地址
    private String areaPosition;
    // 景点经度
    private String positionX;
    // 景点纬度
    private String positionY;
    // 景点简介
    private String shortContent;
    // 该景点的多个信息组合
    private List<TempOption> optionList;
    
    
	public List<TempOption> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<TempOption> optionList) {
		this.optionList = optionList;
	}
	public Integer getViewAreaId() {
		return viewAreaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public String getImage() {
		return image;
	}
	public String getAreaPosition() {
		return areaPosition;
	}
	public String getPositionX() {
		return positionX;
	}
	public String getPositionY() {
		return positionY;
	}
	public String getShortContent() {
		return shortContent;
	}
	public void setViewAreaId(Integer viewAreaId) {
		this.viewAreaId = viewAreaId;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setAreaPosition(String areaPosition) {
		this.areaPosition = areaPosition;
	}
	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
    
    
}
