package com.bluemobi.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bluemobi.util.redisUtil.RedisUtil;

/**
 * 用于生成特定数字
 * @author zhangx05
 * @date 下午3:05:36
 */
public class NumUtil {
	/**
	 * 生成6位的字符串
	 * @return
	 */
	/*public synchronized static String num4String(int i) {
		i++;
		String s = "00000"+i; 
		return s.substring(s.length()-6);
	}
	public static String numToString(int i) {
		String s = "00000"+i; 
		return s.substring(s.length()-6);
	}*/
	public synchronized static String getUserNumber(String currentNum){
		//获取当前字符位数
		int length = currentNum.length();
		//根据用户的编号长度判断在前方放置几个零
		String userNumber ="S";
		switch (length) {
		case 1: userNumber = userNumber+"00000"+currentNum; break;
		case 2: userNumber = userNumber+"0000"+currentNum; break;
		case 3: userNumber = userNumber+"000"+currentNum; break;
		case 4: userNumber = userNumber+"00"+currentNum; break;
		case 5: userNumber = userNumber+"0"+currentNum; break;
		case 6: userNumber = userNumber+currentNum; break;
		default: break;
		}
		return userNumber;
	}
}


