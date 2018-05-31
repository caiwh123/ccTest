package com.bluemobi.util.imgUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.bluemobi.util.imgUtil.FileUtil;

import javax.imageio.stream.FileImageOutputStream;

public class ImageUploadUtil {
	/**
	 * 
	 * @param files 要上传的文件
	 * @param appendUrl  相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名   例如 /imageTest/
	 * @return     List<Map<String,Object>> imageMaps  文件属性的集合   returnMap=imageMaps.get(index)
	 * 			returnMap.uploadFolder 文件上传的文件夹路径
	 * 			returnMap.fileName 文件的名称
	 * 			returnMap.visitUrl 文件的访问路径
	 * 			returnMap.flag 是否上传成功
	 */
	public static List<Map<String,Object>> uploadImages(MultipartFile[] files, String appendUrl) {
//		if(StringUtils.isNotEmpty(appendUrl)){
//			appendUrl="";
//		}
        List<Map<String,Object>>  imageMaps=new  ArrayList<Map<String,Object>>();
        for (int i = 0; i < files.length; i++) {
        	
            if (!files[i].isEmpty()) {
            	Map<String,Object> map = new HashMap<String,Object>();
                try {
                    // 检验文件夹是否存在，不存在 就创建
                    FileUtil.makeDir(ImagePropUtil.getValue("upload_prefix") + appendUrl);
                    // 文件后缀名
                    String suffix = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf(".") + 1, files[i].getOriginalFilename().length());
                    // 拿到输出流，同时重命名上传的文件
                    String imageName = UUID.randomUUID().toString() + "." + suffix;
                    FileOutputStream os = new FileOutputStream(ImagePropUtil.getValue("upload_prefix") + appendUrl + imageName);

                    // 拿到上传文件的输入流
                    InputStream in = files[i].getInputStream();
                    // 以写字节的方式写文件
                    int len = 0;
                    byte[] bb = new byte[4096];
                    while ((len = in.read(bb)) != -1) {
                        os.write(bb, 0, len);
                    }
                    os.flush();
                    os.close();
                    in.close();
                    map.put("hashcode", imageName.substring(0, imageName.indexOf(".")));
                    map.put("visitUrl", ImagePropUtil.getValue("access_prefix")+appendUrl + imageName);
                    map.put("flag", true);
                    map.put("uploadFolder", ImagePropUtil.getValue("upload_prefix") + appendUrl);
                    map.put("fileName",imageName);
                } catch (Exception e) {
                	System.out.println("上传异常信息"+e);
                    map.put("flag", false);
                }
                
                imageMaps.add(map);
            }
        }
        return imageMaps;
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

    /**
     * 将接收的字符串转换成图片保存
     * @param imgStr 二进制流转换的字符串
     * @param imgPath 图片的保存路径
     * @param imgName 图片的名称
     * @return
     *      1：保存正常
     *      0：保存失败
     */
    public static int saveToImgByStr(String imgStr,String imgPath,String imgName){
        try {
            System.out.println("===imgStr.length()====>" + imgStr.length()
                    + "=====imgStr=====>" + imgStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int stateInt = 1;
        if(imgStr != null && imgStr.length() > 0){
            try {

                // 将字符串转换成二进制，用于显示图片
                // 将上面生成的图片格式字符串 imgStr，还原成图片显示
                byte[] imgByte = hex2byte( imgStr );

                InputStream in = new ByteArrayInputStream(imgByte);
                File file=new File(FileUtil.makeDir(imgPath),imgName);//可以是任何图片格式.jpg,.png等
                FileOutputStream fos=new FileOutputStream(file);

                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = in.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
                in.close();

            } catch (Exception e) {
                stateInt = 0;
                e.printStackTrace();
            } finally {
            }
        }
        return stateInt;
    }


    /**
     * 字符串转二进制
     * @param str 要转换的字符串
     * @return  转换后的二进制数组
     */
    public static byte[] hex2byte(String str) { // 字符串转二进制
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;
        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer
                        .decode("0X" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }
    //byte数组到图片
    public static void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }
    //byte数组到16进制字符串
    public String byte2string(byte[] data){
        if(data==null||data.length<=1) return "0x";
        if(data.length>200000) return "0x";
        StringBuffer sb = new StringBuffer();
        int buf[] = new int[data.length];
        //byte数组转化成十进制
        for(int k=0;k<data.length;k++){
            buf[k] = data[k]<0?(data[k]+256):(data[k]);
        }
        //十进制转化成十六进制
        for(int k=0;k<buf.length;k++){
            if(buf[k]<16) sb.append("0"+Integer.toHexString(buf[k]));
            else sb.append(Integer.toHexString(buf[k]));
        }
        return "0x"+sb.toString().toUpperCase();
    }
}