package com.bluemobi.util.imgUtil;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import com.bluemobi.conf.Config;
import com.bluemobi.constant.BaseConstant;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.util.calendar.CalendarUtils;
import sun.util.locale.provider.CalendarDataUtility;

/**
 * 图片相关操作工具类
 * 
 * @author zhangzheng
 * @date 2015-11-30
 * 
 */
public class UpImageUtils {
	static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	static BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	/**
	 * 
	* @Title: modifyAvatar 
	* @Description:上传图片
	* @author wangy07
	* @param @param iconDate 文件
	* @param @param request
	* @param @param table 目录，上传到服务器下img中的文件夹名，（如没有相应文件夹，会自动创建）
	* @param @return    返回 相对于服务器下img夹的相对地址
	* @return String    返回类型 
	* @throws
	 */
	public static String modifyAvatar(MultipartFile iconDate,HttpServletRequest request,String table) {

		//图片服务器地址，存放用户上传的图片、视频等
	    String realPath = BaseConstant.BASE_IMAGE_ADDRESS; //Config.IMG_URL; 
	    
		 String originFileName = iconDate.getOriginalFilename();
		// 获取图片的扩展名
        String extensionName = originFileName.substring(originFileName.lastIndexOf(".") + 1);
    	//获取uuid作为图片前缀
    	String pre = UUID.randomUUID().toString(); 
    	Calendar cal = Calendar.getInstance();
    	 int year=cal.get(Calendar.YEAR);//得到年
    	  int month=cal.get(Calendar.MONTH)+1;//得到月，因为从0开始的，所以要加1
    	  int day=cal.get(Calendar.DAY_OF_MONTH);//得到天
    	//拼接文件名
    	String fullName = "/"+table+"/"+year+"/"+month+"/"+day+"/"+ pre + "." + extensionName;
    	
		try {
			FileUtils.copyInputStreamToFile(iconDate.getInputStream(),new File(realPath, fullName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//转移到图片服务器
		//FtpUploadServer.uploadServer(Config.IMG_URL, fullName);
		return fullName;
	}
	
	/**
	 * 
	 * @param iconDate源文件
	 * @param pre  后缀
	 * @param extensionName   扩展名
	 * @param table  图片类别
	 * @return  
	 */
	public static String uploadImg(MultipartFile iconDate,String pre,String extensionName,String table) {
		//图片服务器地址，存放用户上传的图片、视频等
	    String realPath = Config.IMG_URL; //Config.IMG_URL; 
	      String originalFilename = iconDate.getOriginalFilename();
    	  Calendar cal = Calendar.getInstance();
    	  int year=cal.get(Calendar.YEAR);//得到年
    	  int month=cal.get(Calendar.MONTH)+1;//得到月，因为从0开始的，所以要加1
    	  int day=cal.get(Calendar.DAY_OF_MONTH);//得到天
    	//拼接文件名
    	//String fullName = "/"+table+"/"+year+"/"+month+"/"+day+"/"+ pre+"."+extensionName;
    	String fullName = "/"+table+"/"+year+"/"+month+"/"+day+"/"+ pre;
    	String originalName = "/"+table+"/"+year+"/"+month+"/"+day+"/"+ originalFilename;
    	
		try {
			FileUtils.copyInputStreamToFile(iconDate.getInputStream(),new File(realPath, fullName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//转移到图片服务器
		//FtpUploadServer.uploadServer(Config.IMG_URL, fullName);
		return originalName;
	}
	/**
	 * 二进制转字符串
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) // 二进制转字符串
	{
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}

		}
		return sb.toString();
	}

}
