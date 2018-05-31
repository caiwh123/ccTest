package com.bluemobi.to.trend;

import com.appcore.model.AbstractObject;

public class PropertyTo extends AbstractObject{
    
    private static final long serialVersionUID = 1L;
    
    private int property_id;
    private String label_name;
    private String note;
    private int sort_order;
    private int is_spec;
    private int status;
    private String[] p_val;
    private int[] p_sort_order;
    private int[] p_is_default;
    private int[] p_property_value_id;
    public int getProperty_id() {
        return property_id;
    }
    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }
    public String getLabel_name() {
        return label_name;
    }
    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public int getSort_order() {
        return sort_order;
    }
    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }
    public int getIs_spec() {
        return is_spec;
    }
    public void setIs_spec(int is_spec) {
        this.is_spec = is_spec;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String[] getP_val() {
        return p_val;
    }
    public void setP_val(String[] p_val) {
        this.p_val = p_val;
    }
    public int[] getP_sort_order() {
        return p_sort_order;
    }
    public void setP_sort_order(int[] p_sort_order) {
        this.p_sort_order = p_sort_order;
    }
    public int[] getP_is_default() {
        return p_is_default;
    }
    public void setP_is_default(int[] p_is_default) {
        this.p_is_default = p_is_default;
    }
    public int[] getP_property_value_id() {
        return p_property_value_id;
    }
    public void setP_property_value_id(int[] p_property_value_id) {
        this.p_property_value_id = p_property_value_id;
    }

    
    
    
}
