package com.bluemobi.po.trend;

import java.math.BigDecimal;

import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：TREND_ATTACHMENT
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:49
 * 
 */
public class TrendAttachment extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private BigDecimal attachmentid;
    // 
    private Long userid;
    // 
    private String title;
    // 
    private String description;
    // 
    private String label;
    // 
    private String mediatype;
    // 
    private String mimetype;
    // 
    private String suffix;
    // 
    private Short imageable;
    // 
    private Long imageWidth;
    // 
    private Long imageHeight;
    // 
    private String ctime;
    // 
    private String mtime;
    // 
    private String filepath;
    // 
    private Long filesize;
    // 
    private String hashcode;
    // 
    private Short status;
    // 
    private Long rev;

    /** 获取  属性 */
    public BigDecimal getAttachmentid() {
        return attachmentid;
    }

    /** 设置  属性 */
    public void setAttachmentid(BigDecimal attachmentid) {
        this.attachmentid = attachmentid;
    }

    /** 获取  属性 */
    public Long getUserid() {
        return userid;
    }

    /** 设置  属性 */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /** 获取  属性 */
    public String getTitle() {
        return title;
    }

    /** 设置  属性 */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 获取  属性 */
    public String getDescription() {
        return description;
    }

    /** 设置  属性 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取  属性 */
    public String getLabel() {
        return label;
    }

    /** 设置  属性 */
    public void setLabel(String label) {
        this.label = label;
    }

    /** 获取  属性 */
    public String getMediatype() {
        return mediatype;
    }

    /** 设置  属性 */
    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    /** 获取  属性 */
    public String getMimetype() {
        return mimetype;
    }

    /** 设置  属性 */
    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    /** 获取  属性 */
    public String getSuffix() {
        return suffix;
    }

    /** 设置  属性 */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /** 获取  属性 */
    public Short getImageable() {
        return imageable;
    }

    /** 设置  属性 */
    public void setImageable(Short imageable) {
        this.imageable = imageable;
    }

    /** 获取  属性 */
    public Long getImageWidth() {
        return imageWidth;
    }

    /** 设置  属性 */
    public void setImageWidth(Long imageWidth) {
        this.imageWidth = imageWidth;
    }

    /** 获取  属性 */
    public Long getImageHeight() {
        return imageHeight;
    }

    /** 设置  属性 */
    public void setImageHeight(Long imageHeight) {
        this.imageHeight = imageHeight;
    }

    /** 获取  属性 */
    public String getCtime() {
        return ctime;
    }

    /** 设置  属性 */
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    /** 获取  属性 */
    public String getMtime() {
        return mtime;
    }

    /** 设置  属性 */
    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    /** 获取  属性 */
    public String getFilepath() {
        return filepath;
    }

    /** 设置  属性 */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /** 获取  属性 */
    public Long getFilesize() {
        return filesize;
    }

    /** 设置  属性 */
    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    /** 获取  属性 */
    public String getHashcode() {
        return hashcode;
    }

    /** 设置  属性 */
    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    /** 获取  属性 */
    public Short getStatus() {
        return status;
    }

    /** 设置  属性 */
    public void setStatus(Short status) {
        this.status = status;
    }

    /** 获取  属性 */
    public Long getRev() {
        return rev;
    }

    /** 设置  属性 */
    public void setRev(Long rev) {
        this.rev = rev;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TrendAttachment");
        sb.append("{attachmentid=").append(attachmentid);
        sb.append(", userid=").append(userid);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", label=").append(label);
        sb.append(", mediatype=").append(mediatype);
        sb.append(", mimetype=").append(mimetype);
        sb.append(", suffix=").append(suffix);
        sb.append(", imageable=").append(imageable);
        sb.append(", imageWidth=").append(imageWidth);
        sb.append(", imageHeight=").append(imageHeight);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append(", filepath=").append(filepath);
        sb.append(", filesize=").append(filesize);
        sb.append(", hashcode=").append(hashcode);
        sb.append(", status=").append(status);
        sb.append(", rev=").append(rev);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TrendAttachment) {
            TrendAttachment trendAttachment = (TrendAttachment) obj;
            if (this.getAttachmentid().equals(trendAttachment.getAttachmentid())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getAttachmentid();
        return pkStr.hashCode();
    }

}