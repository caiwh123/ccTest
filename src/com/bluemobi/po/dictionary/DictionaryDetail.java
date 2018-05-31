package com.bluemobi.po.dictionary;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：DICTIONARY_DETAIL
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:00:56
 * 
 */
public class DictionaryDetail extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String treatyid;
    // 码表类型ID
    private String dictionaryid;
    // 码表项ID
    private String dictionaryitemid;
    // 码表项名称
    private String dictionaryitemname;
    // 
    private String createtime;
    // 
    private String modifiertime;

    /** 获取  属性 */
    public String getTreatyid() {
        return treatyid;
    }

    /** 设置  属性 */
    public void setTreatyid(String treatyid) {
        this.treatyid = treatyid;
    }

    /** 获取 码表类型ID 属性 */
    public String getDictionaryid() {
        return dictionaryid;
    }

    /** 设置 码表类型ID 属性 */
    public void setDictionaryid(String dictionaryid) {
        this.dictionaryid = dictionaryid;
    }

    /** 获取 码表项ID 属性 */
    public String getDictionaryitemid() {
        return dictionaryitemid;
    }

    /** 设置 码表项ID 属性 */
    public void setDictionaryitemid(String dictionaryitemid) {
        this.dictionaryitemid = dictionaryitemid;
    }

    /** 获取 码表项名称 属性 */
    public String getDictionaryitemname() {
        return dictionaryitemname;
    }

    /** 设置 码表项名称 属性 */
    public void setDictionaryitemname(String dictionaryitemname) {
        this.dictionaryitemname = dictionaryitemname;
    }

    /** 获取  属性 */
    public String getCreatetime() {
        return createtime;
    }

    /** 设置  属性 */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /** 获取  属性 */
    public String getModifiertime() {
        return modifiertime;
    }

    /** 设置  属性 */
    public void setModifiertime(String modifiertime) {
        this.modifiertime = modifiertime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DictionaryDetail");
        sb.append("{treatyid=").append(treatyid);
        sb.append(", dictionaryid=").append(dictionaryid);
        sb.append(", dictionaryitemid=").append(dictionaryitemid);
        sb.append(", dictionaryitemname=").append(dictionaryitemname);
        sb.append(", createtime=").append(createtime);
        sb.append(", modifiertime=").append(modifiertime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DictionaryDetail) {
            DictionaryDetail dictionaryDetail = (DictionaryDetail) obj;
            if (this.getTreatyid().equals(dictionaryDetail.getTreatyid())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getTreatyid();
        return pkStr.hashCode();
    }

}