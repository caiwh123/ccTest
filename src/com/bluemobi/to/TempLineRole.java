package com.bluemobi.to;

import java.util.List;

public class TempLineRole {
	
	private String lineId;
	private String lineName;
	private List<TempRole> roleList;
	public String getLineId() {
		return lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public List<TempRole> getRoleList() {
		return roleList;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public void setRoleList(List<TempRole> roleList) {
		this.roleList = roleList;
	}

	
}
