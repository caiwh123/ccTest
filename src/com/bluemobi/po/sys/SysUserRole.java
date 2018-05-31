package com.bluemobi.po.sys;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_USER_ROLE
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:01
 * 
 */
public class SysUserRole extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String userId;
    // 
    private String roleId;

    /** 获取  属性 */
    public String getUserId() {
        return userId;
    }

    /** 设置  属性 */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** 获取  属性 */
    public String getRoleId() {
        return roleId;
    }

    /** 设置  属性 */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SysUserRole");
        sb.append("{userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SysUserRole) {
            SysUserRole sysUserRole = (SysUserRole) obj;
            if (this.getUserId().equals(sysUserRole.getUserId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getUserId();
        return pkStr.hashCode();
    }

}