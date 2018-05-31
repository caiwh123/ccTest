package com.bluemobi.po.sys;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_MENU
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:01
 * 
 */
public class SysMenu extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String id;
    // 父级编号
    private String parentId;
    // 所有父级编号
    private String parentIds;
    // 名称
    private String name;
    // 排序
    private String sort;
    // 链接
    private String href;
    // 目标
    private String target;
    // 图标
    private String icon;
    // 是否在菜单中显示
    private Short isShow;
    // 权限标识
    private String permission;
    // 
    private String createBy;
    // 
    private String createDate;
    // 
    private String updateBy;
    // 
    private String updateDate;
    // 备注信息
    private String remarks;
    // 删除标记
    private Short delFlag;

    /** 获取  属性 */
    public String getId() {
        return id;
    }

    /** 设置  属性 */
    public void setId(String id) {
        this.id = id;
    }

    /** 获取 父级编号 属性 */
    public String getParentId() {
        return parentId;
    }

    /** 设置 父级编号 属性 */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /** 获取 所有父级编号 属性 */
    public String getParentIds() {
        return parentIds;
    }

    /** 设置 所有父级编号 属性 */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /** 获取 名称 属性 */
    public String getName() {
        return name;
    }

    /** 设置 名称 属性 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 排序 属性 */
    public String getSort() {
        return sort;
    }

    /** 设置 排序 属性 */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /** 获取 链接 属性 */
    public String getHref() {
        return href;
    }

    /** 设置 链接 属性 */
    public void setHref(String href) {
        this.href = href;
    }

    /** 获取 目标 属性 */
    public String getTarget() {
        return target;
    }

    /** 设置 目标 属性 */
    public void setTarget(String target) {
        this.target = target;
    }

    /** 获取 图标 属性 */
    public String getIcon() {
        return icon;
    }

    /** 设置 图标 属性 */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /** 获取 是否在菜单中显示 属性 */
    public Short getIsShow() {
        return isShow;
    }

    /** 设置 是否在菜单中显示 属性 */
    public void setIsShow(Short isShow) {
        this.isShow = isShow;
    }

    /** 获取 权限标识 属性 */
    public String getPermission() {
        return permission;
    }

    /** 设置 权限标识 属性 */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /** 获取  属性 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置  属性 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 获取  属性 */
    public String getCreateDate() {
        return createDate;
    }

    /** 设置  属性 */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /** 获取  属性 */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 设置  属性 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 获取  属性 */
    public String getUpdateDate() {
        return updateDate;
    }

    /** 设置  属性 */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /** 获取 备注信息 属性 */
    public String getRemarks() {
        return remarks;
    }

    /** 设置 备注信息 属性 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /** 获取 删除标记 属性 */
    public Short getDelFlag() {
        return delFlag;
    }

    /** 设置 删除标记 属性 */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SysMenu");
        sb.append("{id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIds=").append(parentIds);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", href=").append(href);
        sb.append(", target=").append(target);
        sb.append(", icon=").append(icon);
        sb.append(", isShow=").append(isShow);
        sb.append(", permission=").append(permission);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SysMenu) {
            SysMenu sysMenu = (SysMenu) obj;
            if (this.getId().equals(sysMenu.getId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getId();
        return pkStr.hashCode();
    }

}