package com.ffcs.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
/**
 * HTTP请求类
 * 
 * @author LiHong
 */
public class HttpInvoker {

	/**
	 * GET请求
	 * 
	 * @param getUrl
	 * @throws IOException
	 * @return 提取HTTP响应报文包体，以字符串形式返回
	 */
	public static String httpGet(String getUrl, Map<String, String> getHeaders) throws IOException {
		URL getURL = new URL(getUrl);
		HttpURLConnection connection = (HttpURLConnection) getURL.openConnection();

		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		if (getHeaders != null) {
			for (String pKey : getHeaders.keySet()) {
				connection.setRequestProperty(pKey, getHeaders.get(pKey));
			}
		}
		connection.connect();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder sbStr = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sbStr.append(line);
		}
		bufferedReader.close();
		connection.disconnect();
		return new String(sbStr.toString().getBytes(), "utf-8");
	}

	/**
	 * POST请求
	 * 
	 * @param postUrl
	 * @param postHeaders
	 * @param postEntity
	 * @throws IOException
	 * @return 提取HTTP响应报文包体，以字符串形式返回
	 */
	public static String httpPost(String postUrl, Map<String, String> postHeaders, String postEntity)
			throws IOException {

		URL postURL = new URL(postUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) postURL.openConnection();
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setInstanceFollowRedirects(true);
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		if (postHeaders != null) {
			for (String pKey : postHeaders.keySet()) {
				httpURLConnection.setRequestProperty(pKey, postHeaders.get(pKey));
			}
		}
		if (postEntity != null) {
			DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
			out.writeBytes(postEntity);
			out.flush();
			out.close(); // flush and close
		}
		// connection.connect();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		StringBuilder sbStr = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sbStr.append(line);
		}
		bufferedReader.close();
		httpURLConnection.disconnect();
		return new String(sbStr.toString().getBytes(), "utf-8");
	}

	/**
	 * POST请求 ,解决中文乱码问题
	 * 
	 * @param postUrl
	 * @param postHeaders
	 * @param postEntity
	 * @throws IOException
	 * @return 提取HTTP响应报文包体，以字符串形式返回
	 */
	public static String httpPost1(String postUrl, Map<String, String> postHeaders, String postEntity)
			throws IOException {

		URL postURL = new URL(postUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) postURL.openConnection();
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setInstanceFollowRedirects(true);
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		StringBuilder sbStr = new StringBuilder();
		if (postHeaders != null) {
			for (String pKey : postHeaders.keySet()) {
				httpURLConnection.setRequestProperty(pKey, postHeaders.get(pKey));
			}
		}
		httpURLConnection.connect();
		if (postEntity != null) {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8"));
			out.println(postEntity);
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				sbStr.append(inputLine);
			}
			in.close();
		}
		httpURLConnection.disconnect();
		return new String(sbStr.toString().getBytes(), "utf-8");
	}

	public static String doHttpsPost(String url, Map<String, String> map, String charset) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// 设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
