package com.bluemobi.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class WeatherUtil {
	
	/**
	 * 
	 * 获取实时天气1<br>
	 * 方 法 名： getTodayWeather <br>
	 * 
	 * @param Cityid
	 *            城市编码
	 */
	public static Map<String, Object> getTodayWeather1(String Cityid)
			throws IOException, NullPointerException {
		// 连接中央气象台的API
		URL url = new URL("http://www.weather.com.cn/data/sk/" + Cityid
				+ ".html");
		URLConnection connectionData = url.openConnection();
		connectionData.setConnectTimeout(1000);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					connectionData.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
			String datas = sb.toString();
			System.out.println(datas);

		} catch (SocketTimeoutException e) {
			System.out.println("连接超时");
		} catch (FileNotFoundException e) {
			System.out.println("加载文件出错");
		}

		return map;

	}
	
	/**
	 * 
	 * 获取实时天气2<br>
	 * 方 法 名： getTodayWeather <br>
	 * 
	 * @param Cityid
	 *            城市编码
	 */
	public static Map<String, Object> getTodayWeather2(String Cityid)
			throws IOException, NullPointerException {
		// 连接中央气象台的API
		URL url = new URL("http://www.weather.com.cn/data/cityinfo/" + Cityid
				+ ".html");
		URLConnection connectionData = url.openConnection();
		connectionData.setConnectTimeout(1000);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					connectionData.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
			String datas = sb.toString();
			System.out.println(datas);

		} catch (SocketTimeoutException e) {
			System.out.println("连接超时");
		} catch (FileNotFoundException e) {
			System.out.println("加载文件出错");
		}

		return map;

	}
	
	/**
	 * 
	 * 获取实时天气整合<br>
	 * 方 法 名： getTodayWeather <br>
	 * 
	 * @param Cityid
	 *            城市编码
	 */
	public static Map<String, Object> getTotalWeather(String Cityid)
			throws IOException, NullPointerException {
		// 连接中央气象台的API
		URL url = new URL("http://www.weather.com.cn/data/cityinfo/" + Cityid
				+ ".html");
		// 连接中央气象台的API
		URL url1 = new URL("http://www.weather.com.cn/data/sk/" + Cityid
				+ ".html");
		URLConnection connectionData = url.openConnection();
		connectionData.setConnectTimeout(1000);
		URLConnection connectionData1 = url1.openConnection();
		connectionData1.setConnectTimeout(1000);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					connectionData.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
			String datas = sb.toString();
			System.out.println(datas);
			
			
			BufferedReader br1 = new BufferedReader(new InputStreamReader(
					connectionData1.getInputStream(), "UTF-8"));
			StringBuilder sb1 = new StringBuilder();
			String line1 = null;
			while ((line1 = br1.readLine()) != null)
				sb1.append(line1);
			String datas1 = sb1.toString();
			System.out.println(datas1);

			Gson jsonData = new Gson();
			JsonObject returnData1 = new JsonParser().parse(datas1).getAsJsonObject();
			JsonObject je1 = (JsonObject) returnData1.get("weatherinfo");
			map.put("city", je1.get("city").getAsString());// 城市
			map.put("WD", je1.get("WD").getAsString());// 风
			map.put("WS", je1.get("WS").getAsString());// 风级
			map.put("SD", je1.get("city").getAsString());// 湿度
			
			
			JsonObject returnData = new JsonParser().parse(datas).getAsJsonObject();
			JsonObject je = (JsonObject) returnData.get("weatherinfo");
			map.put("topTemp", je.get("temp2").getAsString());// 最高温度
			map.put("lowTemp", je.get("temp1").getAsString());// 最低温度
			map.put("weather", je.get("weather").getAsString());//天气
			map.put("ptime", je.get("ptime").getAsString());// 发布时间
			map.put("img", "http://m.weather.com.cn/img/"+je.get("img2").getAsString());//天气图片2
			
			jsonData.toJson(map);
			System.out.println(jsonData.toJson(map));
		} catch (SocketTimeoutException e) {
			System.out.println("连接超时");
		} catch (FileNotFoundException e) {
			System.out.println("加载文件出错");
		}

		return map;

	}
	
	/**
	 * 
	 * 获取天气信息-和风<br>
	 * 方 法 名： getWeatherInfo <br>
	 * 
	 * @param Cityid
	 *            城市编码
	 */
	public static Map<String, Object> getWeatherInfo(String positionX,String positionY)
			throws IOException, NullPointerException {
		String key = "51c5ddc2250b42f2a84d619bad151ffd";
		// 连接中央气象台的API
		String position = positionX+","+positionY;
		URL url = new URL("https://free-api.heweather.com/v5/weather?city="+position+"&key="+key);
		
		URLConnection connectionData = url.openConnection();
		connectionData.setConnectTimeout(1000);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					connectionData.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
			String datas = sb.toString();								

			Gson jsonData = new Gson();
			JsonObject returnData1 = new JsonParser().parse(datas).getAsJsonObject();
			//获取天气的最高和最低温
			JsonArray HeWeather5 = (JsonArray) returnData1.get("HeWeather5");
			JsonObject heweatherObject = (JsonObject) HeWeather5.get(0).getAsJsonObject();
			JsonArray daily_forecast = (JsonArray)heweatherObject.get("daily_forecast");
			JsonObject daily_Object = (JsonObject)daily_forecast.get(0).getAsJsonObject();
			JsonObject tmp = (JsonObject) daily_Object.get("tmp");
			String max =  tmp.get("max").getAsString();//气温最大值
			String min =  tmp.get("min").getAsString();//气温最小值
			//获取天气的情况和图像
			JsonArray hourly_forecast = (JsonArray) heweatherObject.get("hourly_forecast");
			JsonObject forecast_Object = (JsonObject)hourly_forecast.get(0).getAsJsonObject();
			JsonObject cond = (JsonObject) forecast_Object.get("cond");
			String code = "https://cdn.heweather.com/cond_icon/"+cond.get("code").getAsString()+".png";//图像
			String txt =  cond.get("txt").getAsString();//情况
			
			map.put("max", max+"℃");//气温最大值
			map.put("min", min+"℃");//气温最小值
			map.put("code", code);//图像
			map.put("txt", txt);//情况
			
			System.out.println(jsonData.toJson(map));
		} catch (SocketTimeoutException e) {
			System.out.println("连接超时");
		} catch (FileNotFoundException e) {
			System.out.println("加载文件出错");
		}

		return map;

	}
	
	public static void main(String[] args) {
		try {
			getWeatherInfo("120.343","36.088");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
