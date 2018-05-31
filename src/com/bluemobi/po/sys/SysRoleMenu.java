package com.bluemobi.po.sys;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_ROLE_MENU
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:01
 * 
 */
public class SysRoleMenu extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String roleId;
    // 
    private String menuId;

    /** 获取  属性 */
    public String getRoleId() {
        return roleId;
    }

    /** 设置  属性 */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /** 获取  属性 */
    public String getMenuId() {
        return menuId;
    }

    /** 设置  属性 */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SysRoleMenu");
        sb.append("{roleId=").append(roleId);
        sb.append(", menuId=").append(menuId);
        sb.append('}');
        return sb.toString();
    }

}