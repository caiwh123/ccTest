package com.bluemobi.po.sys;

import java.math.BigDecimal;

import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_AREA
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:00
 * 
 */
public class SysArea extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 编号
    private String id;
    // 父级编号
    private String parentId;
    // 所有父级编号
    private String parentIds;
    // 名称
    private String name;
    // 排序
    private Integer sort;
    // 区域编码
    private String code;
    // 区域类型
    private String type;
    // 创建者
    private String createBy;
    // 创建时间
    private String createDate;
    // 更新者
    private String updateBy;
    // 更新时间
    private String updateDate;
    // 备注信息
    private String remarks;
    // 删除标记
    private String delFlag;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

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

    /** 获取 区域编码 属性 */
    public String getCode() {
        return code;
    }

    /** 设置 区域编码 属性 */
    public void setCode(String code) {
        this.code = code;
    }

    /** 获取 创建者 属性 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置 创建者 属性 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 获取 创建时间 属性 */
    public String getCreateDate() {
        return createDate;
    }

    /** 设置 创建时间 属性 */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /** 获取 更新者 属性 */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 设置 更新者 属性 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 获取 更新时间 属性 */
    public String getUpdateDate() {
        return updateDate;
    }

    /** 设置 更新时间 属性 */
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SysArea");
        sb.append("{id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIds=").append(parentIds);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
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
        if (obj instanceof SysArea) {
            SysArea sysArea = (SysArea) obj;
            if (this.getId().equals(sysArea.getId())) {
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