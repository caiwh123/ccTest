package com.bluemobi.po.sys;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_USER
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:01
 * 
 */
public class SysUser extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String id;
    // 归属公司
    private String companyId;
    // 归属部门
    private String officeId;
    // 登录名
    private String loginName;
    // 密码
    private String password;
    // 工号
    private String no;
    // 姓名
    private String name;
    // 邮件
    private String email;
    // 电话
    private String phone;
    // 手机
    private String mobile;
    // 用户类型 1:总部 2:实验室
    private String userType;
    // 用户头像
    private String photo;
    // 最后登陆IP
    private String loginIp;
    // 最后登陆时间
    private String loginDate;
    // 是否可登录
    private String loginFlag;
    // 
    private String createBy;
    // 
    private String createDate;
    // 
    private String updateBy;
    // 
    private String updateDate;
    // 
    private String remarks;
    //
    private String labId;
    // 
    private Short delFlag;

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    /** 获取  属性 */
    public String getId() {
        return id;
    }

    /** 设置  属性 */
    public void setId(String id) {
        this.id = id;
    }

    /** 获取 归属公司 属性 */
    public String getCompanyId() {
        return companyId;
    }

    /** 设置 归属公司 属性 */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /** 获取 归属部门 属性 */
    public String getOfficeId() {
        return officeId;
    }

    /** 设置 归属部门 属性 */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /** 获取 登录名 属性 */
    public String getLoginName() {
        return loginName;
    }

    /** 设置 登录名 属性 */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /** 获取 密码 属性 */
    public String getPassword() {
        return password;
    }

    /** 设置 密码 属性 */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 获取 工号 属性 */
    public String getNo() {
        return no;
    }

    /** 设置 工号 属性 */
    public void setNo(String no) {
        this.no = no;
    }

    /** 获取 姓名 属性 */
    public String getName() {
        return name;
    }

    /** 设置 姓名 属性 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 邮件 属性 */
    public String getEmail() {
        return email;
    }

    /** 设置 邮件 属性 */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 获取 电话 属性 */
    public String getPhone() {
        return phone;
    }

    /** 设置 电话 属性 */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** 获取 手机 属性 */
    public String getMobile() {
        return mobile;
    }

    /** 设置 手机 属性 */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /** 获取 用户类型 属性 */
    public String getUserType() {
        return userType;
    }

    /** 设置 用户类型 属性 */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /** 获取 用户头像 属性 */
    public String getPhoto() {
        return photo;
    }

    /** 设置 用户头像 属性 */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /** 获取 最后登陆IP 属性 */
    public String getLoginIp() {
        return loginIp;
    }

    /** 设置 最后登陆IP 属性 */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /** 获取 最后登陆时间 属性 */
    public String getLoginDate() {
        return loginDate;
    }

    /** 设置 最后登陆时间 属性 */
    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    /** 获取 是否可登录 属性 */
    public String getLoginFlag() {
        return loginFlag;
    }

    /** 设置 是否可登录 属性 */
    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
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

    /** 获取  属性 */
    public String getRemarks() {
        return remarks;
    }

    /** 设置  属性 */
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
        sb.append("SysUser");
        sb.append("{id=").append(id);
        sb.append(", companyId=").append(companyId);
        sb.append(", officeId=").append(officeId);
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", no=").append(no);
        sb.append(", name=").append(name);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", mobile=").append(mobile);
        sb.append(", userType=").append(userType);
        sb.append(", photo=").append(photo);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", loginFlag=").append(loginFlag);
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
        if (obj instanceof SysUser) {
            SysUser sysUser = (SysUser) obj;
            if (this.getId().equals(sysUser.getId())) {
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