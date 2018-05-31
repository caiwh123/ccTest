package com.bluemobi.po.sys;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：SYS_LOG
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:01:00
 * 
 */
public class SysLog extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String id;
    // 日志类型
    private Short type;
    // 日志标题
    private String title;
    // 
    private String createBy;
    // 
    private String createDate;
    // 操作IP地址
    private String remoteAddr;
    // 用户代理
    private String userAgent;
    // 请求URI
    private String requestUri;
    // 操作方式
    private String method;
    // 操作提交的数据
    private String params;
    // 异常信息
    private String exception;

    /** 获取  属性 */
    public String getId() {
        return id;
    }

    /** 设置  属性 */
    public void setId(String id) {
        this.id = id;
    }

    /** 获取 日志类型 属性 */
    public Short getType() {
        return type;
    }

    /** 设置 日志类型 属性 */
    public void setType(Short type) {
        this.type = type;
    }

    /** 获取 日志标题 属性 */
    public String getTitle() {
        return title;
    }

    /** 设置 日志标题 属性 */
    public void setTitle(String title) {
        this.title = title;
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

    /** 获取 操作IP地址 属性 */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /** 设置 操作IP地址 属性 */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    /** 获取 用户代理 属性 */
    public String getUserAgent() {
        return userAgent;
    }

    /** 设置 用户代理 属性 */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /** 获取 请求URI 属性 */
    public String getRequestUri() {
        return requestUri;
    }

    /** 设置 请求URI 属性 */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /** 获取 操作方式 属性 */
    public String getMethod() {
        return method;
    }

    /** 设置 操作方式 属性 */
    public void setMethod(String method) {
        this.method = method;
    }

    /** 获取 操作提交的数据 属性 */
    public String getParams() {
        return params;
    }

    /** 设置 操作提交的数据 属性 */
    public void setParams(String params) {
        this.params = params;
    }

    /** 获取 异常信息 属性 */
    public String getException() {
        return exception;
    }

    /** 设置 异常信息 属性 */
    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SysLog");
        sb.append("{id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", remoteAddr=").append(remoteAddr);
        sb.append(", userAgent=").append(userAgent);
        sb.append(", requestUri=").append(requestUri);
        sb.append(", method=").append(method);
        sb.append(", params=").append(params);
        sb.append(", exception=").append(exception);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SysLog) {
            SysLog sysLog = (SysLog) obj;
            if (this.getId().equals(sysLog.getId())) {
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