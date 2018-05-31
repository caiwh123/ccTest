package com.bluemobi.util;

import org.apache.commons.lang3.StringUtils;

public class DistLengthUtil {
	private final static double PI = 3.14159265358979323; // 圆周率
	private final static double R = 6371229; // 地球的半径

	/**
	 * 
	 * @param longt1
	 *            本人的经度
	 * @param lat1
	 *            本人的纬度
	 * @param longt2
	 *            距离人的经度
	 * @param lat2
	 *            距离人的纬度
	 * @return 米
	 */
	public static int getDistance(String longt1, String lat1, String longt2, String lat2) {
		if(StringUtils.isBlank(longt1) || StringUtils.isBlank(lat1) ||StringUtils.isBlank(longt2) ||StringUtils.isBlank(lat2)){
			return 0;
		}
		double longt1Double = Double.parseDouble(longt1);
		double lat1Double = Double.parseDouble(lat1);
		double longt2Double = Double.parseDouble(longt2);
		double lat2Double = Double.parseDouble(lat2);
		
		double x, y, distance;
		x = (longt2Double - longt1Double) * PI * R * Math.cos(((lat1Double + lat2Double) / 2) * PI / 180) / 180;
		y = (lat2Double - lat1Double) * PI * R / 180;
		distance = Math.hypot(x, y);
		return (int) distance;
	}
}
