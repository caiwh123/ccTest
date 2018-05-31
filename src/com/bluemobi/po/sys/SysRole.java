package com.bluemobi.po.sys;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_ROLE
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:01
 * 
 */
public class SysRole extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String id;
    // 归属机构
    private String officeId;
    // 角色名称
    private String name;
    // 英文名称
    private String enname;
    // 角色类型
    private String roleType;
    // 数据范围
    private Short dataScope;
    // 是否系统数据
    private String isSys;
    // 是否可用
    private String useable;
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
    // 
    private Short delFlag;

    /** 获取  属性 */
    public String getId() {
        return id;
    }

    /** 设置  属性 */
    public void setId(String id) {
        this.id = id;
    }

    /** 获取 归属机构 属性 */
    public String getOfficeId() {
        return officeId;
    }

    /** 设置 归属机构 属性 */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /** 获取 角色名称 属性 */
    public String getName() {
        return name;
    }

    /** 设置 角色名称 属性 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 英文名称 属性 */
    public String getEnname() {
        return enname;
    }

    /** 设置 英文名称 属性 */
    public void setEnname(String enname) {
        this.enname = enname;
    }

    /** 获取 角色类型 属性 */
    public String getRoleType() {
        return roleType;
    }

    /** 设置 角色类型 属性 */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /** 获取 数据范围 属性 */
    public Short getDataScope() {
        return dataScope;
    }

    /** 设置 数据范围 属性 */
    public void setDataScope(Short dataScope) {
        this.dataScope = dataScope;
    }

    /** 获取 是否系统数据 属性 */
    public String getIsSys() {
        return isSys;
    }

    /** 设置 是否系统数据 属性 */
    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    /** 获取 是否可用 属性 */
    public String getUseable() {
        return useable;
    }

    /** 设置 是否可用 属性 */
    public void setUseable(String useable) {
        this.useable = useable;
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

    /** 获取  属性 */
    public Short getDelFlag() {
        return delFlag;
    }

    /** 设置  属性 */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SysRole");
        sb.append("{id=").append(id);
        sb.append(", officeId=").append(officeId);
        sb.append(", name=").append(name);
        sb.append(", enname=").append(enname);
        sb.append(", roleType=").append(roleType);
        sb.append(", dataScope=").append(dataScope);
        sb.append(", isSys=").append(isSys);
        sb.append(", useable=").append(useable);
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
        if (obj instanceof SysRole) {
            SysRole sysRole = (SysRole) obj;
            if (this.getId().equals(sysRole.getId())) {
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