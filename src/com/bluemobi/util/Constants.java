package com.bluemobi.util;

public class Constants {
	// 是否
	public static final int yes = 1;// 是
	public static final int no = 0;// 否
	// 优惠券使用情况
	public static final String COUPON_USE = "2";// 使用
	public static final String COUPON_NOT_USE = "1";// 商品
	// 关注类型
	public static final int WATCH_TYPE_SHOP = 0;// 关注商铺
	public static final int WATCH_TYPE_PERSON = 1;// 关注个人
	// 商品类型
	public static final String goods_type_sp = "1";// 商品
	public static final String goods_type_kc = "2";// 课程
	// 地址类型
	public static final String address_type_yh = "1";// 用户地址
	public static final String address_type_sp = "2";// 商铺地址
	// 点赞类型
	public static final String CLICKLIKE_TYPE_GOODS = "1";// 商品点赞
	public static final String CLICKLIKE_TYPE_SHOW = "2";// 秀宝点赞
	// 收藏类型
	public static final String COLLECT_TYPE_STORE = "0";// 商铺
	public static final String COLLECT_TYPE_GOODS = "1";// 商品
	public static final String COLLECT_TYPE_SHOW = "2";// 秀宝
	
	//视频上传的目录
	public final static String VIDEO_PATH = "videoPath";
	//视频预览图上传的目录
	public final static String VIDEO_LOGO_PATH = "videoLogoPath";
	// 内容管理类型
	public static final String CONTENT_TYPE_YHXY = "1";// 用户协议
	public static final String CONTENT_TYPE_ZFXY = "2";// 支付协议
	public static final String CONTENT_TYPE_FVSM = "3";// 法律声明
	public static final String CONTENT_TYPE_JYXZ = "4";// 交易须知
	public static final String CONTENT_TYPE_GYWM = "5";// 关于我们
	public static final String CONTENT_TYPE_WYRZ = "6";// 我要认证
	// 内容管理类型
	public static final String DRAWCASH_TYPE_UNDO = "0";// 未处理
	public static final String DRAWCASH_TYPE_TURN = "1";// 已驳回
	public static final String DRAWCASH_TYPE_DO = "2";// 已打款
	// 排行榜类型
	public static final String RANK_LIST_TYPE_CF = "1";// 财富榜
	public static final String RANK_LIST_TYPE_JL = "2";// 捡漏榜
	public static final String RANK_LIST_TYPE_RQ = "3";// 人气榜
	public static final String RANK_LIST_TYPE_SW = "4";// 声望榜
	// 店铺种类
	public static final String STORE_TYPE_PERSON = "1";// 个人商铺
	public static final String STORE_TYPE_COMMON = "0";// 普通商铺
	public static final String STORE_TYPE_NOTHING = "2";// 没开店
	// 店铺是否开放
	public static final String STORE_TYPE_OPEN = "1";// 店铺开
	public static final String STORE_TYPE_CLOSE = "2";// 店铺关
	public static final String STORE_TYPE_NULL = "3";// 无店铺
	// 审核状态
	public static final String APPROVE_STATUS_WAIT = "1";// 待审核
	public static final String APPROVE_STATUS_SUCC = "2";// 审核通过
	public static final String APPROVE_STATUS_FAIL = "3";// 审核不通过
	// 合作状态
	public static final String COOPERATION_STATUS_YES = "1";// 合作
	public static final String COOPERATION_STATUS_NO = "2";// 未合作
	// 活动类型
	public static final String ACTIVITY_TYPE_ZK = "1";// 折扣类
	public static final String ACTIVITY_TYPE_SP = "2";// 商铺推荐类
	public static final String ACTIVITY_TYPE_XB = "3";// 秀宝推荐类
	// 活动类型
	public static final String ACTIVITY_APPROVE_STATUS_DSH = "1";// 未审核
	public static final String ACTIVITY_APPROVE_STATUS_WTG = "2";// 未通过
	public static final String ACTIVITY_APPROVE_STATUS_TG = "3";// 通过
	// 订单状态
	public static final String ORDER_STATUS_DZF = "1";// 待支付
	public static final String ORDER_STATUS_DFH = "2";// 待发货
	public static final String ORDER_STATUS_DSH = "3";// 待收货
	public static final String ORDER_STATUS_YWC = "4";// 已完成
	public static final String ORDER_STATUS_YQX = "5";// 已取消
	public static final String ORDER_STATUS_YSX = "6";// 已失效
	public static final String ORDER_STATUS_YCF = "7";// 已拆分
	public static final String ORDER_STATUS_JYWC = "8";// 交易完成
	public static final String ORDER_STATUS_TKZ = "9";// 退款中
	public static final String ORDER_STATUS_JXZ = "10";// 进行中
	// 订单类型
	public static final String ORDER_TYPE_SP = "1";// 商品订单
	public static final String ORDER_TYPE_KC = "2";// 课程订单
	// 下单方式
	public static final String ADD_ORDER_TYPE_WG = "1";// 网购
	public static final String ADD_ORDER_TYPE_WGXX = "2";// 网购线下提货
	public static final String ADD_ORDER_TYPE_WGYY = "3";// 网购预约
	
	// 订单等级类型
	public static final String ORDER_LEVEL_TYPE_HB = "1";// 合并订单
	public static final String ORDER_LEVEL_TYPE_ZD = "2";// 子订单
	public static final String ORDER_LEVEL_TYPE_PT = "3";// 普通订单
	// 商品图片类型
	public static final String GOODS_IMG_TYPE_PT = "1";// 普通图片
	public static final String GOODS_IMG_TYPE_360 = "2";// 360图片
	// 系统消息类型
	public static final String SYSTEM_MESSAGE_TYPE_GOODS = "1";// 商品详情
	public static final String SYSTEM_MESSAGE_TYPE_SUBJECT = "2";// 专题详情
	public static final String SYSTEM_MESSAGE_TYPE_ACTIVITY = "3";// 活动详情
	public static final String SYSTEM_MESSAGE_TYPE_SHOW = "4";// 秀宝详情
	public static final String SYSTEM_MESSAGE_TYPE_FAST = "5";// 文玩速报
	public static final String SYSTEM_MESSAGE_TYPE_OUTLINE = "6";// 外部链接
	// 退款类型
	public static final String ORDER_REFUND_STATUS_ZZTK = "1";// 正在退款
	public static final String ORDER_REFUND_STATUS_TKCG = "2";// 退款完成
	public static final String ORDER_REFUND_STATUS_JJTK = "3";// 拒绝退款
	public static final String ORDER_REFUND_STATUS_TYTK = "4";// 同意退款
	public static final String ORDER_REFUND_STATUS_DSH = "5";// 待审核
	public static final String ORDER_REFUND_STATUS_KFJR = "6";// 客服介入
	public static final String ORDER_REFUND_STATUS_YGB = "7";// 已关闭
	// 支付状态
	public static final String PAY_STATUS_DONE = "1";// 已支付
	public static final String PAY_STATUS_NO = "2";// 未支付
	// 系统消息类型
	public static final String SYSTEM_MESSAGE_TYPE_SP = "1";// 商品详情
	public static final String SYSTEM_MESSAGE_TYPE_ZT = "2";// 专题详情
	public static final String SYSTEM_MESSAGE_TYPE_HD = "3";// 活动详情
	public static final String SYSTEM_MESSAGE_TYPE_XB = "4";// 秀宝详情
	public static final String SYSTEM_MESSAGE_TYPE_SB = "5";// 文玩速报
	public static final String SYSTEM_MESSAGE_TYPE_OL = "6";// 外部链接

	// 启动页尺寸
	public static final String HOMEPAGE_SIZE_TYPE_1 = "1242*2208";
	public static final String HOMEPAGE_SIZE_TYPE_2 = "1080*1920";
	public static final String HOMEPAGE_SIZE_TYPE_3 = "750*1334";
	public static final String HOMEPAGE_SIZE_TYPE_4 = "720*1280";
	public static final String HOMEPAGE_SIZE_TYPE_5 = "640*1136";
	public static final String HOMEPAGE_SIZE_TYPE_6 = "640*960";

	// 支付方式
	public static final String PAY_TYPE_WX = "1";// 微信
	public static final String PAY_TYPE_ZFB = "2";// 支付宝
	public static final String PAY_TYPE_YL = "3";// 银联
	public static final String PAY_TYPE_IOS = "4";// IOS内部支付
	public static final String PAY_TYPE_JF = "5";// 积分
	public static final String PAY_TYPE_WX_QUERY = "9";// 微信查询 此状态在微信回调查询时使用

	// 活动状态
	public static final String ACTIVITY_STATUS_RUNNING = "1";// 审核中
	public static final String ACTIVITY_STATUS_FINISH = "2";// 审核完成
	
	
	//购物车类型
	public static final String CART_TYPE_SP = "1";// 商品类
	public static final String CART_TYPE_KC = "2";// 课程类
	

	// 以下为非码表，存储程序里的临时变量
	public static final String TEMP_STOREID_TYPE_GS = "-1";// 官方商城
	public static final String TEMP_STOREID_TYPE_JF = "-2";// 积分商城
	public static final String TEMP_STOREID_TYPE_HB = "-3";// 合并订单

	//红包领取状态
	public static final Integer RED_BAG_GET_STATUS_NO = 1;// 领取状态1未领取2已经领取
	public static final Integer RED_BAG_GET_STATUS_YES = 2;// 领取状态1未领取2已经领取
	
	//红包类型
	public static final Integer RED_BAG_TYPE_NORMAL = 1;//普通红包
	public static final Integer RED_BAG_TYPE_SUPER = 2;//超级红包
	
	//消息类型
	public static final Byte MESSAGE_TYPE_SYSTEM = 0;//系统消息
	public static final Byte MESSAGE_TYPE_PERSON = 1;//个人消息
	
	//系统消息类型
	public static final Byte MESSAGE_TYPE_SYSTEM_TYPE_SUPERRED = 0;//系统消息--超级红包消息
	
	//系统消息类型
	public static final Byte CUSTOMER_SUBSCRIBE_NO = 0;//用户关注状态 未关注
	public static final Byte CUSTOMER_SUBSCRIBE_YES = 1;//用户关注状态 已关注
	
	//系统消息类型
	public static final Byte SEX_NO = 0;//性别 未知
	public static final Byte SEX_MAN = 1;//性别 男
	public static final Byte SEX_WOMEN = 2;//性别 女
	//任务状态
	public static final String TASK_DXP = "1";//待下派
	public static final String TASK_DAP = "2";//待安排
	public static final String TASK_ZXZ = "3";//执行中
	public static final String TASK_DPJ = "4";//待评价
	public static final String TASK_YWC = "5";//已完成
	public static final String TASK_YC = "6";//异常
	public static final String TASK_ZXWTJ = "7";//执行中未提交
	public static final String TASK_ZXYTJ = "8";//执行中已提交
	
	//系统消息类型
	public static final Short NORMAL = 1;//通用表单
	public static final Short SPECIAL = 2;//专业表单
	public static final Short SIMPLE = 3;//抽样表单
}
