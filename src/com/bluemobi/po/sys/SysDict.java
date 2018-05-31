package com.bluemobi.po.sys;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_DICT
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:00
 * 
 */
public class SysDict extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 编号
    private String id;
    // 数据值
    private String value;
    // 标签名
    private String label;
    // 类型
    private String type;
    // 描述
    private String description;
    // 排序（升序）
    private String sort;
    // 父级编号
    private String parentId;
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

    /** 获取 编号 属性 */
    public String getId() {
        return id;
    }

    /** 设置 编号 属性 */
    public void setId(String id) {
        this.id = id;
    }

    /** 获取 数据值 属性 */
    public String getValue() {
        return value;
    }

    /** 设置 数据值 属性 */
    public void setValue(String value) {
        this.value = value;
    }

    /** 获取 标签名 属性 */
    public String getLabel() {
        return label;
    }

    /** 设置 标签名 属性 */
    public void setLabel(String label) {
        this.label = label;
    }

    /** 获取 类型 属性 */
    public String getType() {
        return type;
    }

    /** 设置 类型 属性 */
    public void setType(String type) {
        this.type = type;
    }

    /** 获取 描述 属性 */
    public String getDescription() {
        return description;
    }

    /** 设置 描述 属性 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 排序（升序） 属性 */
    public String getSort() {
        return sort;
    }

    /** 设置 排序（升序） 属性 */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /** 获取 父级编号 属性 */
    public String getParentId() {
        return parentId;
    }

    /** 设置 父级编号 属性 */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
        sb.append("SysDict");
        sb.append("{id=").append(id);
        sb.append(", value=").append(value);
        sb.append(", label=").append(label);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append(", sort=").append(sort);
        sb.append(", parentId=").append(parentId);
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
        if (obj instanceof SysDict) {
            SysDict sysDict = (SysDict) obj;
            if (this.getId().equals(sysDict.getId())) {
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