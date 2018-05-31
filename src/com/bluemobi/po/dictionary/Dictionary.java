package com.bluemobi.po.dictionary;


import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：DICTIONARY
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-17 18:00:55
 * 
 */
public class Dictionary extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private String treatyid;
    // 
    private String dictionaryid;
    // 
    private String dictionaryname;
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

    /** 获取  属性 */
    public String getDictionaryid() {
        return dictionaryid;
    }

    /** 设置  属性 */
    public void setDictionaryid(String dictionaryid) {
        this.dictionaryid = dictionaryid;
    }

    /** 获取  属性 */
    public String getDictionaryname() {
        return dictionaryname;
    }

    /** 设置  属性 */
    public void setDictionaryname(String dictionaryname) {
        this.dictionaryname = dictionaryname;
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
        sb.append("Dictionary");
        sb.append("{treatyid=").append(treatyid);
        sb.append(", dictionaryid=").append(dictionaryid);
        sb.append(", dictionaryname=").append(dictionaryname);
        sb.append(", createtime=").append(createtime);
        sb.append(", modifiertime=").append(modifiertime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Dictionary) {
            Dictionary dictionary = (Dictionary) obj;
            if (this.getTreatyid().equals(dictionary.getTreatyid())) {
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