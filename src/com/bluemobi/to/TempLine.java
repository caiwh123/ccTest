package com.bluemobi.to;

public class TempLine {
	// 路线任务主键id
    private Integer lineTaskId;
    // 路线id
    private Integer leadLineId;
    // 路线任务名称
    private String taskName;
    // 任务的经度
    private String positionX;
    // 任务的纬度
    private String positionY;
	public Integer getLineTaskId() {
		return lineTaskId;
	}
	public Integer getLeadLineId() {
		return leadLineId;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getPositionX() {
		return positionX;
	}
	public String getPositionY() {
		return positionY;
	}

	public void setLineTaskId(Integer lineTaskId) {
		this.lineTaskId = lineTaskId;
	}
	public void setLeadLineId(Integer leadLineId) {
		this.leadLineId = leadLineId;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

    
    
}
