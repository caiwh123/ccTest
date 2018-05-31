package com.bluemobi.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 广告模块基础常量
 * 
 * @author zhangzheng
 * @date 2015-11-25
 * 
 */
public class AdvertConstant {
    /** 绑定属性类型1：商品详情*/
    public static final Integer BIND_TYPE_GOODS = 1;
    /** 绑定属性类型2：专题详情 */
    public static final Integer BIND_TYPE_SUBJECT = 2;
    
    /** 绑定属性类型3：活动详情 */
    public static final Integer BIND_TYPE_ACTIVITY = 3;
    /** 绑定属性类型4：秀宝详情 */
    public static final Integer BIND_TYPE_SHOW = 4;

    /** 绑定属性类型5：速报详情 */
    public static final Integer BIND_TYPE_FISTREPORT = 5;
    /** 绑定属性类型6：外部链接 */
    public static final Integer BIND_TYPE_LINK_ADDRESS = 6;

    /** 文件路径--广告 */
    public static final String ADVERT_CONTENT_FILE = "/advert/content/";

    public static Map<Integer, Object> bindTypeMap;

    static {
        bindTypeMap = new LinkedHashMap<Integer, Object>();
        bindTypeMap.put(BIND_TYPE_LINK_ADDRESS, "链接地址");
        /*bindTypeMap.put(BIND_TYPE_GOODS, "推广详情");*/
        bindTypeMap.put(BIND_TYPE_SUBJECT, "活动详情");
        bindTypeMap.put(BIND_TYPE_ACTIVITY, "图文详情");
        /*bindTypeMap.put(BIND_TYPE_CUSTOM, "自定义");*/
    }

}
