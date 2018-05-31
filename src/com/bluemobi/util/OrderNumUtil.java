package com.bluemobi.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderNumUtil {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 生成商品的订单号
	 * @return
	 */
	public static String getSPOrderNum(){
		Date date = new Date();
		Long currenttime = date.getTime();
	    int radomInt = new Random().nextInt(999999);
	    String orderNum = "SP"+String.valueOf(currenttime)+String.valueOf(radomInt);
		return orderNum;
	}
	
	
	
	
	/**
	 * 生成课程的订单号
	 * @return
	 */
	public static String getKCOrderNum(){
		Date date = new Date();
		Long currenttime = date.getTime();
	    int radomInt = new Random().nextInt(999999);
	    String orderNum = "KC"+String.valueOf(currenttime)+String.valueOf(radomInt);
		return orderNum;
	}
	
	
	
	
	
	/**
	 * 生成纠纷的订单号
	 * @return
	 */
	public static String getJfOrderNum(){
		Date date = new Date();
		Long currenttime = date.getTime();
	    int radomInt = new Random().nextInt(999999);
	    String orderNum = "JF"+String.valueOf(currenttime)+String.valueOf(radomInt);
		return orderNum;
	}
	/**
	 * 生成退单的订单号
	 * @return
	 */
	public static String getDrawOrderNum(){
		Date date = new Date();
		Long currenttime = date.getTime();
	    int radomInt = new Random().nextInt(999999);
	    String orderNum = "TK"+String.valueOf(currenttime)+String.valueOf(radomInt);
		return orderNum;
	}
	
	/**
	 * 生成提现的订单号
	 * @return
	 */
	public static String getTXOrderNum(){
		Date date = new Date();
	    int radomInt = new Random().nextInt(999999);
	    String orderNum = "TX"+sdf.format(date)+String.valueOf(radomInt);
		return orderNum;
	}
	
	/**
	 * 生成聊天会话号
	 * @return
	 */
	public static String getTalkNum(){
		Date date = new Date();
		Long currenttime = date.getTime();
	    int radomInt = new Random().nextInt(999999);
	    String orderNum = String.valueOf(currenttime)+String.valueOf(radomInt);
		return orderNum;
	}
	
	public static void main(String[] args) {
		String str1 = getTXOrderNum();
		System.out.println(str1);
	}
}
