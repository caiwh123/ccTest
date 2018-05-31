package com.bluemobi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class MyUtil {
	//过滤字传中的表情               // 过滤特殊字符  
    public   static   String StringFilter(String   str)   throws   PatternSyntaxException   {     
                // 只允许字母和数字       
                // String   regEx  =  "[^a-zA-Z0-9]";                     
                   // 清除掉所有特殊字符  
//          String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
//          Pattern   p   =   Pattern.compile(regEx);     
//          Matcher   m   =   p.matcher(str); 
//    	    m.replaceAll("").trim(); 
    	
          return  str.replaceAll("[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]|[\\u2600-\\u27ff]", "");     
          }  
	
	public static String getCreateTime(){
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	public static String changTime(Date date){
		if(null==date){
			return "";
		}
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String changTime2(Date date){
		if(null==date){
			return "";
		}
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM");
		return sdf.format(date);
	}
	public static Date changDate(String date) throws ParseException{
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(date);
	}
	/*
	 * 获取上传图片地址并拼接成完整地址
	 */
	public static String getBasePath(HttpServletRequest request,String str){
		if(null==str || "".equals(str)){
			return "";
		}
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()+"/img"
				;
		return basePath+str;
	}
	/*
	 * 获取上传图片地址前半段
	 */
	public static String getImgPath(HttpServletRequest request){
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()+"/img"
				;
		return basePath;
	}
	public static String getBasePath2(HttpServletRequest request){
		
		return request.getContextPath()+"/"+"images/pro1.png";
	}
	public static String formatDuring(String dateStr) throws ParseException {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(dateStr);
		long old = date.getTime();
		long curred = System.currentTimeMillis();
		long result = curred - old;
		long days = result / (1000 * 60 * 60 * 24);
		long hours = (result % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (result % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (result % (1000 * 60)) / 1000;
		
		if(days>30){
			return dateStr.substring(0, 10);
		}
		if(days>0){
			return days + " 天前";
		}
		if(hours>0){
			return hours + " 小时前";
		}
		if(minutes>0){
			return minutes + " 分钟前";
		}
		if(seconds>10){
			return seconds + " 秒前";
		}
		
		return "刚刚";
	}
	public static String date2String(Date date) throws ParseException {
		if(null==date){
			return "";
		}
		long old = date.getTime();
		long curred = System.currentTimeMillis();
		long result = old-curred;
		if(result<0){
			return "剩余 0 天";
		}
		long days = result / (1000 * 60 * 60 * 24);
		long hours = (result % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (result % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (result % (1000 * 60)) / 1000;
		if(days>0){
			return "剩余  "+ days + " 天";
		}
		if(hours>0){
			return "剩余  "+ hours + " 小时";
		}
		if(minutes>0){
			return "剩余  "+ minutes + " 分钟";
		}
		if(seconds>10){
			return "剩余  "+ seconds + " 秒";
		}
		return "";
	}
	
	
	public static Map<String,String> uploadFile(HttpServletRequest request ,MultipartFile files) throws IOException{
		String filrName = null;
		String suffix = null;
		String prefix = null;
		Map<String,String> map = new HashMap<String, String>();
        String uploadDir = request.getSession().getServletContext()  
                .getRealPath("/") ;
        String path = request.getContextPath()+"/";
			if(!files.isEmpty()){
					// 文件后缀名
					suffix = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf(".") + 1, files.getOriginalFilename().length());
					prefix = files.getOriginalFilename().substring(0,files.getOriginalFilename().lastIndexOf(".") );
					// 拿到输出流，同时重命名上传的文件
					String systemFileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
					filrName = uploadDir+"uploadFile/" + systemFileName;
					File file = new File(filrName);
		  
//				File file = new File("D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\cherub\\" + systemFileName);
					FileOutputStream os = new FileOutputStream(file);
					 InputStream in = files.getInputStream();
					// 以写字节的方式写文件
					 int len = 0;
					 byte[] bb = new byte[4096];
					 while ((len = in.read(bb)) != -1) {
					     os.write(bb, 0, len);
					 }
					 os.flush();
					 os.close();
					 in.close();
					 filrName ="uploadFile/" + systemFileName;
			}
			map.put("filrName", filrName);
			map.put("prefix", prefix);
		
		return map;
	}

	public static Date changDate2(String dateTime) throws ParseException {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM");
		return sdf.parse(dateTime);
	}
	
	public static String formatDuringTime(String dateStr) throws ParseException {
		Date date = new Date();
		long old = date.getTime();
		long curred = System.currentTimeMillis();
		long result = curred - old;
		long days = result / (1000 * 60 * 60 * 24);
		long hours = (result % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (result % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (result % (1000 * 60)) / 1000;
		
		if(days>3){
			return dateStr;
		}
		if(days>0){
			return days + " 天前";
		}
		if(hours>0){
			return hours + " 小时前";
		}
		if(minutes>0){
			return minutes + " 分钟前";
		}
		if(seconds>10){
			return seconds + " 秒前";
		}
		
		return "刚刚";
	}
}


