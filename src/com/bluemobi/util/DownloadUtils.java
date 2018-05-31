package com.bluemobi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadUtils {
	/*
	 * IO流读取图片 by:long
	 * 
	 * @return
	 */
	public static void IoReadImage(String imgName,HttpServletRequest request,HttpServletResponse response) throws IOException {  
        ServletOutputStream out = null;  
        FileInputStream ips = null;  
         
        	//17652314_1358923522083.jpg
            //获取图片存放路径  
            String imgPath = "C:\\Users\\caiwh\\Desktop" + imgName;  
            File filePic = new File(imgPath);
            if(filePic.exists()){
               FileInputStream is = new FileInputStream(filePic);
               int i = is.available(); // 得到文件大小  
               byte data[] = new byte[i];  
               is.read(data); // 读数据  
               is.close();  
               response.setContentType("image/*"); // 设置返回的文件类型  
               OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象  
               toClient.write(data); // 输出数据  
               toClient.close();  
       } 
    }
}
