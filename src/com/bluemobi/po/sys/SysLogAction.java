package com.bluemobi.po.sys;
import com.thinkgem.jeesite.common.utils.DateUtils;



import com.appcore.model.AbstractObject;

/**
 * 【系统日志动作】持久化对象 数据库表：t_sys_log_action
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-01-10 14:38:25
 * 
 */
public class SysLogAction extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键id
    private Long sysLogActionId;
    // 动作名称
    private String actionName;
    // 动作编号
    private String actionCode;

    /** 获取 主键id 属性 */
		public Long getSysLogActionId() {
			return sysLogActionId;
		}

    /** 设置 主键id 属性 */
    public void setSysLogActionId(Long sysLogActionId) {
        this.sysLogActionId = sysLogActionId;
    }

    /** 获取 动作名称 属性 */
		public String getActionName() {
			return actionName;
		}

    /** 设置 动作名称 属性 */
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    /** 获取 动作编号 属性 */
		public String getActionCode() {
			return actionCode;
		}

    /** 设置 动作编号 属性 */
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SysLogAction");
        sb.append("{sysLogActionId=").append(sysLogActionId);
        sb.append(", actionName=").append(actionName);
        sb.append(", actionCode=").append(actionCode);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SysLogAction) {
            SysLogAction sysLogAction = (SysLogAction) obj;
            if (this.getSysLogActionId().equals(sysLogAction.getSysLogActionId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getSysLogActionId();
        return pkStr.hashCode();
    }

}