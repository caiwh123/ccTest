package com.bluemobi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;


public class JpushUtil {
    protected static final Logger LOG = LoggerFactory.getLogger(JpushUtil.class);

    // demo App defined in resources/jpush-api.conf
    //private static final String appKey ="d7ca05d7f5cc53b335362922";  2d16dfb2c7c3816cd8b1f18d   fb53570ecca8c44357d311b6
    //private static final String masterSecret = "6309c79ec63366524742791f";  6bfc2b996e5ec63c90ec0422   38d4a1ccde30fa582052ac62

    private static final String appKey 		= "a08227348e43f53e3894d9fe";
    private static final String masterSecret	= "7367465360ecb8f4d7234aab";//每个应用都对应一个masterSecret
    private static JPushClient jpush 			= new JPushClient(masterSecret, appKey);
    /**
     * 发送通知给所有用户
     * @param alert 通知内容
     */
    public static void sendNotificationToAll(String alert) {
        try {
            jpush.sendNotificationAll(alert);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送通知给所有用户
     * @param msgContent 消息内容
     */
    public static void sendMsgToAll(String msgContent) {
        try {
            jpush.sendMessageAll(msgContent);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息给特定的用户-ID(根据设备类型不同推送)
     * @param title 标题(该参数主要在Ios上使用，Android的title在msg的json串中)
     * @param msgContent 内容
     * @param registrationID 推送id
     * @param phoneType 0:android  1:ios
     */
    public static void sendMsgToUser(String title, String msgContent, String registrationID ,int phoneType) {
        try {
            if(phoneType==0){
                jpush.sendMessageWithRegistrationID(title, msgContent, registrationID);
            }else{
                sendMsgToUserById_Ios(title,msgContent,registrationID);
            }
//			jpush.sendIosMessageWithAlias(title, msgContent, registrationID);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息给特定的用户-别名(根据类型不同推送)
     * @param title(该参数主要在Ios上使用，Android的title在msg的json串中)
     * @param msgContent
     * @param alias
     * @param phoneType 0:android 1:ios
     */
    public static void sendMsgToUserByAlisa(String title, String msgContent, String alias, int phoneType) {
        try {
            if(phoneType==0){
                jpush.sendAndroidMessageWithAlias(title, msgContent, alias);
            }else{
                sendMsgToUserByAlisa_Ios(title, msgContent, alias);
            }
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息给特定用户-ID-IOS(注意Option里面true为生产  false为测试)
     * @param msgContent 自定义消息(json格式)
     * @param alias      别名
     * @param title      通知的title
     * @return
     */
    public static void sendMsgToUserById_Ios(String title, String msgContent, String registrationID) {
        try {
            PushPayload payload =
                    PushPayload.newBuilder()
                            .setPlatform(Platform.ios())
                            .setAudience(Audience.newBuilder()
                                    .addAudienceTarget(AudienceTarget.registrationId(registrationID))
                                    .build())
                            .setNotification(Notification.newBuilder()
                                    .setAlert(title)
                                    .addPlatformNotification(IosNotification.newBuilder()
                                            .addExtra("json", msgContent)
                                            .build())
                                    .build())
                            .setOptions(Options.newBuilder()
                                    .setApnsProduction(true)
                                    .build())
                            .build();
            jpush.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }
    /**
     * 发送自定义消息给特定用户-别名-Android
     * @param msgContent 自定义消息(json格式)
     * @param alias      别名
     * @param
     * @return
     */
    public static void sendMsgToUserByAlisa_Android(String msgContent, String alias) {
        try {
            PushPayload payload =
                    PushPayload.newBuilder()
                            .setPlatform(Platform.android())
                            .setAudience(Audience.newBuilder()
                                    .addAudienceTarget(AudienceTarget.alias(alias))
                                    .build())
                            .setMessage(Message.newBuilder()
                                    .setMsgContent(msgContent)
                                    .addExtra("from", "JPush")
                                    .build())
                            .build();
            jpush.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息给特定用户-别名-IOS(注意Option里面true为生产  false为测试)
     * @param msgContent 自定义消息(json格式)
     * @param alias      别名
     * @param title      通知的title
     * @return
     */
    public static void sendMsgToUserByAlisa_Ios(String title, String msgContent, String alias) {
        try {
            PushPayload payload =
                    PushPayload.newBuilder()
                            .setPlatform(Platform.ios())
                            .setAudience(Audience.newBuilder()
                                    .addAudienceTarget(AudienceTarget.alias(alias))
                                    .build())
                            .setNotification(Notification.newBuilder()
                                    .setAlert(title)
                                    .addPlatformNotification(IosNotification.newBuilder()
                                            .addExtra("json", msgContent)
                                            .build())
                                    .build())
                            .setOptions(Options.newBuilder()
                                    .setApnsProduction(true)
                                    .build())
                            .build();
            jpush.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * IOS设备发送推送消息
     * @param title
     * @param alert
     * @param type
     * @param registrationID
     */
    public static void buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String title, String alert, String type, String registrationID) {
        try {
            PushPayload pl = PushPayload.newBuilder().setPlatform(Platform.ios())
                    .setAudience(Audience.registrationId(registrationID))
                    .setNotification(Notification.newBuilder().addPlatformNotification(
                            IosNotification.newBuilder()
                                    .setAlert(alert)
                                    .setBadge(+1)
                                    .setSound("Default")
                                    .addExtra("type", type)
                                    .build()
                    ).build())
                    // .setMessage(Message.content(MSG_CONTENT))
                    .setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
            jpush.sendPush(pl);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * IOS设备发送推送消息
     * @param title
     * @param alert
     * @param type
     * @param registrationID
     * @param params
     */
    public static void buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String title, String alert, String type, String registrationID, Map<String, String> params) {
        try {
            PushPayload pl = PushPayload.newBuilder().setPlatform(Platform.ios())
                    .setAudience(Audience.registrationId(registrationID))
                    .setNotification(Notification.newBuilder().addPlatformNotification(
                            IosNotification.newBuilder()
                                    .setAlert(alert)
                                    .setBadge(+1)
                                    .setSound("Default")
                                    .addExtra("type", type)
                                    .addExtras(params)
                                    .build()
                    ).build())
                    // .setMessage(Message.content(MSG_CONTENT))
                    .setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
            jpush.sendPush(pl);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }


    //给所有用户发送消息
    public static void pushAll(Map<String,String> msgmap) {

        PushPayload  pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                        .setAlert(msgmap.get("alert")) //弹出内容
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("extra_id", msgmap.get("id"))//消息id
                                .addExtra("extra_title", msgmap.get("title"))//消息标题
                                .addExtra("extra_type", msgmap.get("type"))//消息类型
                                .addExtra("extra_bindId", msgmap.get("bindId"))//绑定对象id
                                .addExtra("extra_bindName", msgmap.get("bindName"))//绑定对象名称
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .setSound("happy")
                                .addExtra("extra_id", msgmap.get("id"))//消息id
                                .addExtra("extra_title", msgmap.get("title"))//消息标题
                                .addExtra("extra_type", msgmap.get("type"))//消息类型
                                .addExtra("extra_bindId", msgmap.get("bindId"))//绑定对象id
                                .addExtra("extra_bindName", msgmap.get("bindName"))//绑定对象名称
                                .build())
                        .build())
                //.setMessage(Message.content(msg))
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
        try {
            jpush.sendPush(pushPayload);
        } catch (APIConnectionException | APIRequestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //给所有用户发送消息（根据参数不同发送，给所有平台）
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void pushAllToAllPlant(Map<String,Object> msgmap) {
        List<String> list =  (List)msgmap.get("pushList");
        System.out.println(list);
        PushPayload  pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(list))
                .setNotification(Notification.newBuilder()
                        .setAlert(msgmap.get("alert")) //弹出内容
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("extra_id", (String)msgmap.get("id"))//消息id
                                .addExtra("extra_title", (String)msgmap.get("title"))//消息标题
                                .addExtra("extra_type", (String)msgmap.get("type"))//消息类型
                                .addExtra("extra_bindId", (String)msgmap.get("bindId"))//绑定对象id
                                .addExtra("extra_bindName", (String)msgmap.get("bindName"))//绑定对象名称
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .setSound("happy")
                                .addExtra("extra_id", (String)msgmap.get("id"))//消息id
                                .addExtra("extra_title", (String)msgmap.get("title"))//消息标题
                                .addExtra("extra_type", (String)msgmap.get("type"))//消息类型
                                .addExtra("extra_bindId", (String)msgmap.get("bindId"))//绑定对象id
                                .addExtra("extra_bindName", (String)msgmap.get("bindName"))//绑定对象名称
                                .build())
                        .build())
                //.setMessage(Message.content(msg))
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
        try {
            PushResult result = jpush.sendPush(pushPayload);
            LOG.info("Got result - " + result);
            //jpush.sendPush(pushPayload);
            jpush.close();
        } catch (APIConnectionException | APIRequestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //
    public static void main(String[] args) {
////		sendNotificationToAll("您好, 我们的产品————mplus, 已经上线。期待您的光临!"); 15090651218,18301222708,18701558762
////		sendNotificationToAll("{\"type\":\"voucher\",\"title\":\"您收到一张优惠券\",\"msg\":\"观看功夫熊猫5元券！\"}");
//		//sendMsgToUser("测试ios", "{\"type\":\"voucher\",\"title\":\"您收到一张优惠券\",\"msg\":\"观看功夫熊猫5元券！\"}", "140fe1da9ea855cedbe",0);
//		//sendMsgToUserByAlisa("测试", "{\"type\":\"voucher\",\"title\":\"您收到一张优惠券\",\"msg\":\"观看功夫熊猫！\"}", "15110276815",1);
//		//sendMsgToUserByAlisa_Ios("测试", "{\"type\":\"voucher\",\"title\":\"您收到一张优惠券\",\"msg\":\"观看功夫熊猫5元券！\"}", "18301222708");
//		//SendPush(JPushMessageUtils.buildPushAndroid_iosByAlias("剧角影城", "{\"type\":\"voucher\",\"title\":\"您收到一张优惠券\",\"msg\":\"观看功夫熊猫5元券！\"}", "15090651218"));
//		//sendMsgToUserByAlisa_Ios();
//		//sendNotificationToAll("666");
//		Map<String,String> map =new HashMap<String,String>();
//		map.put("alert", "999");
//		map.put("id", "43");
//		map.put("title", "标题");
//		map.put("type", "1");
//		map.put("bandId", "1234");
//		pushAll(map);
		/*sendNotificationToAll("婷婷加油");*/
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("alert", "开始测试多条推送");
//        map.put("id", "11");
//        map.put("title", "标题");
//        map.put("type", "1");
//        map.put("bandId", "1234");
//        map.put("bindName", "bindName");
//        List<String> list = new ArrayList<String>();
//        list.add("5f26fabbd5ff47cd8190dc17ed0f70e6");
//        list.add("cee7113cf03a4e1eb321453d630e758b");
//        map.put("pushList", list);
//        pushAllToAllPlant(map);
        PushResult result = push("1613b83c793c466aa88944b5ed233aee","推送测试CC");
        if(result != null && result.isResultOK()){
            LOG.info("针对别名" +"5f26fabbd5ff47cd8190dc17ed0f70e6"+ "的信息推送成功！");
        }else{
            LOG.info("针对别名" +"5f26fabbd5ff47cd8190dc17ed0f70e6"+ "的信息推送失败！");
        }
    }
    public static PushResult push(String alias,String alert) {
        try {
                ClientConfig clientConfig = ClientConfig.getInstance();
                JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
                PushPayload payload = buildPushObject_android_ios_alias_alert(alias, alert);
                return jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            return null;
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            return null;

        }
    }
    public static PushPayload buildPushObject_android_ios_alias_alert(String alias,String alert){
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtra("type", "infomation")
                                .setAlert(alert)
                                .build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
                        .build())
                .build();
    }
}

