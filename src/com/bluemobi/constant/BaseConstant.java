package com.bluemobi.constant;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.bluemobi.conf.Config;

/**
 * 基础的常量
 * 
 * @Description
 * @author haojian 309444359@qq.com
 * @date 2015-9-21 下午5:19:28
 * 
 */
public class BaseConstant {
	
	/** 返回状态--成功 */
    public static final int ACTION_STATUS_SUCCESS = 1;	// 成功
    public static final int ACTION_STATUS_FAILURE = 2;	// 失败
    public static final int ACTION_STATUS_EXISTS = 3;	// 已存在
    public static final int ACTION_STATUS_OBJECT_NULL = 4;	// 无对象
    public static final int ACTION_STATUS_VALUE_NULL = 5;	// 空
    public static final int ACTION_STATUS_INSERT_SUCCESS = 6;	// 添加成功
    public static final int ACTION_STATUS_UPDATE_SUCCESS = 7;	// 更新成功
    public static final int ACTION_STATUS_DELETE_SUCCESS = 8;	// 删除成功
    public static final int ACTION_STATUS_SELECT_SUCCESS = 9;	// 查询成功
    public static final int ACTION_STATUS_INSERT_FAILURE = 10;	// 添加失败
    public static final int ACTION_STATUS_UPDATE_FAILURE = 11;	// 更新失败
    public static final int ACTION_STATUS_DELETE_FAILURE = 12;	// 删除失败
    public static final int ACTION_STATUS_SELECT_FAILURE = 13;	// 查询失败
    public static final int ACTION_STATUS_LOGIN_SUCCESS = 14;	// 登录成功
    public static final int ACTION_STATUS_LOGIN_FAILURE = 15;	// 登录失败
    public static final int ACTION_STATUS_FORMAT_ERROR = 16;	// 格式错误
    public static final int ACTION_STATUS_NOT_EQUALS = 17;	// 不相等
    public static final int ACTION_STATUS_EQUALS = 18;	// 相等
	/*
	 * 以下为数据字典常亮
	 */
	public static final String DICT = "DICT";
	/**
	 * 区域管理 类型
	 */
	public static final String AREA_TYPE_ONE = "2";
	public static final String AREA_TYPE_TWO = "3";
	public static final String AREA_TYPE_FOUR = "4";
	
	public static final String IS_YES = "1";
	
	
	
	/*
	 * 以下为系统自带常量
	 */
    /** 通用状态 -- 启用 */
    public static final int STATUS_ENABLED = 1;
    /** 通用状态 -- 禁用 */
    public static final int STATUS_DISABELD = 0;

    /** 返回状态--成功 */
    public static final int STATUS_SUCCESS = 0;

    /** 返回状态--失败 */
    public static final int STATUS_FAILURE = 1;
    
    public static final int STATUS_SHOW_FAILURE = 3;

    /** 返回状态--token过期 */
    public static final int STATUS_TOKEN_INVALID = 2;

    /** 图片上传根路径 */
    public static final String BASE_IMAGE_ADDRESS = new File(BaseConstant.class
            .getResource("/").getPath()) + "/../../../img/";
    /** 图片路径--商铺营业执照 */
    public static final String STORE_BUSINESSLICENCE_IMAGE = "/store/businessLicence/";
    /** 图片路径--商铺LOGO */
    public static final String STORE_LOGO_IMAGE = "/store/logo/";
    /** 图片路径--商品品牌LOGO */
    public static final String BRAND_LOGO_IMAGE = "/goods/brand/";
    /** 未登录等操作时，重定向地址 */
    public static final String SEND_REDIRECT = Config.BASE_URL
            + "/admin/sign/in?urlContinue=";
    /** 用户冻结等操作时，重定向地址 */
    public static final String SEND_REDIRECT_FREEZE = Config.BASE_URL
            + "/app/mine/freezeInfo";
    

    /** 图片路径--商品属性 */
    public static final String GOODS_PROPERTY_IMAGE = "/goods/property/";
    /** 图片路径--友情链接 */
    public static final String ADVERT_LINK_IMAGE = "/advert/link/";
    /** 文件路径--广告 */
    public static final String ADVERT_CONTENT_FILE = "/advert/content/";
    /** 图片路径--会员头像 */
    public static final String USER_AVATAR_IMAGE = "/user/avatar/";
    /** 图片路径--商品图片 */
    public static final String GOODS_CONTENT_IMAGE = "/goods/content/";

    /** 存放到自定义 session中的user的key */
    public static final String KEY_USER = "adminuser";

    // ============================= 留言反馈模块 ================================
    /** 处理状态--未处理 */
    public static final byte WAIT_PROCESS = 0;
    /** 处理状态--已处理 */
    public static final byte HAS_PROCESSED = 1;

    // ============================= 优惠券模块 ================================
    /** 优惠券状态--未启用 */
    public static final byte UNUSED_STATUS = 0;
    /** 优惠券状态--启用 */
    public static final byte USED_STATUS = 1;
    /** 优惠券状态--锁定 */
    public static final byte LOCKED_STATUS = 2;

    /** 优惠券类型--全场 */
    public static final byte ALL_SKU_TYPE = 0;
    /** 优惠券类型--满减 */
    public static final byte FULL_MINUS_TYPE = 1;

    /** 优惠券审核状态--未审核 */
    public static final byte WAIT_VERIFY_STATUS = 0;
    /** 优惠券审核状态--审核通过 */
    public static final byte VERIFIED_ACCEPT_STATUS = 1;
    /** 优惠券审核状态--审核拒绝 */
    public static final byte VERIFIED_DENIED_STATUS = -1;

    /** 优惠券失效状态--未失效 */
    public static final byte ENABLED_STATUS = 0;
    /** 优惠券失效状态--失效 */
    public static final byte DISABLED_STATUS = 1;

    /** 优惠券是否允许积分兑换--不允许 */
    public static final byte UNALLOWD_EXCHANGE = 0;
    /** 优惠券是否允许积分兑换--允许 */
    public static final byte ALLOWED_EXCHANGE = 1;

    /** 优惠券是否标记删除--未删除 */
    public static final byte UNDELETE_MARK = 0;
    /** 优惠券是否标记删除--已删除 */
    public static final byte HAS_DELETED_MARK = 1;

    /** 优惠券满减类型--全场满减 */
    public static final byte ALL_SKU_FULL_MINUS_TYPE = 0;
    /** 优惠券满减类型--商品分类满减 */
    public static final byte SPEC_CATEGORY_FULL_MINUS_TYPE = 1;
    /** 优惠券满减类型--商户满减 */
    public static final byte SPEC_STORE_FULL_MINUS_TYPE = 2;

    // ============================= 订单模块 ================================
    /** 订单类型--普通订单 */
    public static final byte COMMON_ORDER_TYPE = 0;
    /** 订单类型--团购订单 */
    public static final byte GROUPONBULK_ORDER_TYPE = 1;
    /** 订单类型--抢购订单 */
    public static final byte GROUPONGRAB_ORDER_TYPE = 2;
    
    /** 支付状态--未支付 */
    public static final byte PAY_WAITED_STATUS = 0;  
    /** 支付状态--已支付 */
    public static final byte PAY_FINISHED_STATUS = 1;

    /** 支付类型--在线支付 */
    public static final byte ONLINE_PAYMENT_TYPE = 1;
    /** 支付类型--线下付款 */
    public static final byte OFFLINE_PAYMENT_TYPE = 2;

    /** 支付方式--支付宝 */
    public static final byte ALIPAY_PAYMENT = 1;
    /** 支付方式--微信 */
    public static final byte WECHAT_PAYMENT = 2;
    /** 支付方式--银联 */
    public static final byte UNIONPAY_PAYMENT = 3;
    /** 支付方式--货到付款 */
    public static final byte COD_PAYMENT = 4;

    /** 支付方式-支付类型关系映射 */
    public static Map<Byte, Byte> paymentMap;

    {
        paymentMap = new HashMap<Byte, Byte>();
        paymentMap.put(ALIPAY_PAYMENT, ONLINE_PAYMENT_TYPE);
        paymentMap.put(WECHAT_PAYMENT, ONLINE_PAYMENT_TYPE);
        paymentMap.put(UNIONPAY_PAYMENT, ONLINE_PAYMENT_TYPE);
        paymentMap.put(COD_PAYMENT, OFFLINE_PAYMENT_TYPE);
    }
    /** 订单状态-待处理 */
    public static final byte WAIT_PROCESS_ORDER_STATUS = 0;
    /** 订单状态-已签收 */
    public static final byte SIGNED_ORDER_STATUS = 1;
    /** 订单状态-待付款 */
    public static final byte WAIT_PAY_ORDER_STATUS = 2;
    /** 订单状态-付款成功 */
    public static final byte PAYED_ORDER_STATUS = 3;
    /** 订单状态-待发货 */
    public static final byte WAIT_DELIVERY_ORDER_STATUS = 4;
    /** 订单状态-已发货 */
    public static final byte DELIVERIED_ORDER_STATUS = 5;
    
    /** 返回状态--是 */
    public static final String STATUS_YES = "1";

    /** 返回状态--否 */
    public static final String STATUS_NO = "0";
    //1审核中
    public static final String STATUS_SHENHE = "1";
    //2未开始 
    public static final String STATUS_WKS = "2";
    //3进行中
    public static final String STATUS_JX = "3";
    //4已结束
    public static final String STATUS_JS = "4";
    
    
    /**
     * 小地图类型
     */
    public static final String TYPE_DHFW = "1";//导航服务
    public static final String TYPE_CYZL = "2";//穿越之旅
    public static final String TYPE_YYYL = "3";//演艺娱乐
    public static final String TYPE_MSGW = "4";//美食购物
    public static final String TYPE_XSJ = "5";//洗手间
    public static final String TYPE_YKFW = "6";//游客服务
    private BaseConstant() {
    }

}
