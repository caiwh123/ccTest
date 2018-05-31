package com.bluemobi.util.imgUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * 该公共图片文件上传工具，主要是提供多图片进行本地上传、本地上传后到windows系统、本地上传后到linux系统
 * @author jixw
 *
 */
public class ImageCommonUtil {
	/**
	 * 本地上传单张或多张图片(可以附带压缩图片一并执行完毕)
	 * @param files 要上传的文件
	 * @param appendUrl  相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名   例如 /imageTest/
	 * @param compressType 压缩方式 0:不压缩  1:比例压缩  2:大小质量 3:质量压缩
	 * @param scale 上传压缩的比例 尺寸压缩传Map<String,Object>0.不压缩传一个空的map 1.尺寸压缩 传key为width、height  2.大小质量压缩 传key为Double型的property(0-1)
	 *              3.图片质量进行压缩 传key为Double型的quality(0-1)
	 * @return     List<Map<String,Object>> imageMaps  文件属性的集合   returnMap=imageMaps.get(index)
	 * 			returnMap.uploadFolder 文件上传的文件夹路径
	 * 			returnMap.fileName 文件的名称
	 * 			returnMap.visitUrl 文件的访问路径
	 * 			returnMap.flag 是否上传成功
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String,Object>> uploadImages(MultipartFile[] files, String appendUrl, String compressType, Object scale) {
        List<Map<String,Object>>  imageMaps=new  ArrayList<Map<String,Object>>();
        for (int i = 0; i < files.length; i++) {
        	
            if (!files[i].isEmpty()) {
            	Map<String,Object> map = new HashMap<String,Object>();
            	Map<String,Object> imageftpMap = new HashMap<String,Object>();
            	Map<String,Object> imageCompressftpMap = new HashMap<String,Object>();
            	Map<String,Object> resultMap = new HashMap<String,Object>();
            	String ftpType = "";
                try {
                    // 检验文件夹是否存在，不存在 就创建
                    FileUtil.makeDir(ImagePropUtil.getValue("upload_prefix") + appendUrl);
                    // 截取文件后缀名
                    String suffix = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf(".") + 1, files[i].getOriginalFilename().length());
                    // 拿到输出流，同时重命名上传的文件
                    String imageName = UUID.randomUUID().toString() + "." + suffix; 
                    //利用multipartfile自带的transferto方法上传
                    MultipartFile mulf = files[i];                  
                    mulf.transferTo(FileUtil.makeDir(ImagePropUtil.getValue("upload_prefix") +"/"+appendUrl +"/"+imageName));                    
                    //设置上传成功后返回的参数值
                    map.put("hashcode", imageName.substring(0, imageName.indexOf(".")));
                    map.put("visitUrl", ImagePropUtil.getValue("access_prefix")+"/"+appendUrl +"/"+imageName);
                    map.put("flag", true);
                    map.put("uploadFolder", ImagePropUtil.getValue("upload_prefix") + "/"+appendUrl);
                    map.put("fileName",imageName);
                    map.put("imageUrl","/"+appendUrl +"/"+imageName);
                    //上传成功后，判断是否需要压缩图片 0不传 1-3为三种压缩方式
                    //String ifCompress =  ImagePropUtil.getValue("if_compress");
                    Map<String,Object> compressImage = null;
                    if(!"0".equals(compressType)){
                    	Map<String,Object> compressMap = (Map<String, Object>) scale;  
                    	if("1".equals(compressType)){
                    		compressImage = compresseImagebyPx(map, (Integer)compressMap.get("width"), (Integer)compressMap.get("height"));
                        }else if("2".equals(compressType)){                       	                  	
                        	compressImage = compresseImagebyProportion(map, (Double)compressMap.get("property"));
                        }else if("3".equals(compressType)){                   	
                        	compressImage = compresseImagebyProportion(map, (Double)compressMap.get("quality"));
                        }
                    }                   
                    //判断是否需要传到对应的图片服务上
                    ftpType =  ImagePropUtil.getValue("ftp_type");                   
                    if("2".equals(ftpType)){//传到windows
                    	imageftpMap = WinSftpUtil.upload(map,imageName,appendUrl);
                    	//imageftpMap = windowsupload(map,imageName,appendUrl);
                    	if(!"0".equals(compressType)){
                    		String compressName = (String) compressImage.get("fileName");
                    		imageCompressftpMap = WinSftpUtil.upload(compressImage,compressName,appendUrl);
                    		//windowsupload(compressImage,compressName,appendUrl);
                    	}
                    }else if("3".equals(ftpType)){//传到linux
                    	//imageftpMap = linuxupload(map,imageName,appendUrl);
                    	imageftpMap = LinuxSftpUtil.upload(map,imageName,appendUrl);
                    	if(!"0".equals(compressType)){
                    		String compressName = (String) compressImage.get("fileName");
                    		//linuxupload(compressImage,compressName,appendUrl);
                    		imageCompressftpMap = LinuxSftpUtil.upload(compressImage,compressName,appendUrl);
                    	}
                    }
                    
                    if("1".equals(ftpType)){
                   	 if(!"0".equals(compressType)){
                   		 resultMap.put("imageCompressUrl", "/"+appendUrl +"/"+compressImage.get("fileName"));
                        }else{
                       	 resultMap.put("imageCompressUrl", "");
                        }
                   	resultMap.put("imageUrl", map.get("imageUrl"));
                	resultMap.put("uploadFolder", map.get("uploadFolder"));
                	resultMap.put("fileName", imageName);
                   	imageMaps.add(resultMap);
                    }else{
                   	 if(!"0".equals(compressType)){
                   		 resultMap.put("imageCompressUrl", imageCompressftpMap.get("ftp_dbName"));
                        }else{
                       	 resultMap.put("imageCompressUrl", "");
                        }
                   	resultMap.put("imageUrl", imageftpMap.get("ftp_dbName"));
                   	resultMap.put("uploadFolder", map.get("uploadFolder"));
                	resultMap.put("fileName", imageName);
                   	imageMaps.add(resultMap);
                    }
                } catch (Exception e) {
                	System.out.println("上传异常信息"+e);
                    map.put("flag", false);
                }
            }
        }
        return imageMaps;
    }
	
	/**
	 * 优化版的本地上传单张或多张图片(可以附带压缩图片一并执行完毕)
	 * @param files 要上传的文件
	 * @param appendUrl  相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名   例如 /imageTest/
	 * @param compressType 压缩方式 0:不压缩  1:比例压缩  2:大小质量 3:质量压缩
	 * @param scale 上传压缩的比例 尺寸压缩传Map<String,Object>0.不压缩传一个空的map 1.尺寸压缩 传key为width、height  2.大小质量压缩 传key为Double型的property(0-1)
	 *              3.图片质量进行压缩 传key为Double型的quality(0-1)
	 * @return     List<Map<String,Object>> imageMaps  文件属性的集合   returnMap=imageMaps.get(index)
	 * 			returnMap.uploadFolder 文件上传的文件夹路径
	 * 			returnMap.fileName 文件的名称
	 * 			returnMap.visitUrl 文件的访问路径
	 * 			returnMap.flag 是否上传成功
	 */
	public static List<Map<String,Object>> asyUploadImages(MultipartFile[] files, final String appendUrl, final String compressType, final Object scale) {
        final List<Map<String,Object>>  imageMaps=new  ArrayList<Map<String,Object>>();
        Vector<Thread> threads = new Vector<Thread>();
		for(final MultipartFile file : files){
			 Thread iThread = new Thread(new Runnable() {
			        public void run() {

			        Map<String,Object> map = singleUploadImages(file,appendUrl,compressType,scale);
			        imageMaps.add(map);
					// 模拟子线程任务
			        System.out.println("图片上传子进程" + Thread.currentThread() + "执行完毕");

			        }
			      });

			      threads.add(iThread);
			      iThread.start();
		}
		
		for (Thread iThread : threads) {
		      try {
		        // 等待所有线程执行完毕
		        iThread.join();
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
        return imageMaps;
    }
	
	/**
	 * 单个的本地上传单张或多张图片(可以附带压缩图片一并执行完毕)
	 * @param files 要上传的文件
	 * @param appendUrl  相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名   例如 /imageTest/
	 * @param compressType 压缩方式 0:不压缩  1:比例压缩  2:大小质量 3:质量压缩
	 * @param scale 上传压缩的比例 尺寸压缩传Map<String,Object>0.不压缩传一个空的map 1.尺寸压缩 传key为width、height  2.大小质量压缩 传key为Double型的property(0-1)
	 *              3.图片质量进行压缩 传key为Double型的quality(0-1)
	 * @return     List<Map<String,Object>> imageMaps  文件属性的集合   returnMap=imageMaps.get(index)
	 * 			returnMap.uploadFolder 文件上传的文件夹路径
	 * 			returnMap.fileName 文件的名称
	 * 			returnMap.visitUrl 文件的访问路径
	 * 			returnMap.flag 是否上传成功
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> singleUploadImages(MultipartFile file, String appendUrl, String compressType, Object scale) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
        if (!file.isEmpty()) {
        	Map<String,Object> map = new HashMap<String,Object>();
        	Map<String,Object> imageftpMap = new HashMap<String,Object>();
        	
        	String ftpType = "";
            try {
                // 检验文件夹是否存在，不存在 就创建
                FileUtil.makeDir(ImagePropUtil.getValue("upload_prefix") + appendUrl);
                // 截取文件后缀名
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
                // 拿到输出流，同时重命名上传的文件
                String imageName = UUID.randomUUID().toString() + "." + suffix;         
                //利用multipartfile自带的transferto方法上传                
                file.transferTo(FileUtil.makeDir(ImagePropUtil.getValue("upload_prefix") +"/"+appendUrl +"/"+imageName));                    
                //设置上传成功后返回的参数值
                map.put("hashcode", imageName.substring(0, imageName.indexOf(".")));
                map.put("visitUrl", ImagePropUtil.getValue("access_prefix")+"/"+appendUrl +"/"+imageName);
                map.put("flag", true);
                map.put("uploadFolder", ImagePropUtil.getValue("upload_prefix") + "/"+appendUrl);
                map.put("fileName",imageName);
                map.put("imageUrl","/"+appendUrl +"/"+imageName);
                //上传成功后，判断是否需要压缩图片 0不传 1-3为三种压缩方式
                //String ifCompress =  ImagePropUtil.getValue("if_compress");
                Map<String,Object> compressImage = null;
                if(!"0".equals(compressType)){
                	Map<String,Object> compressMap = (Map<String, Object>) scale;  
                	if("1".equals(compressType)){
                		compressImage = compresseImagebyPx(map, (Integer)compressMap.get("width"), (Integer)compressMap.get("height"));
                    }else if("2".equals(compressType)){                       	                  	
                    	compressImage = compresseImagebyProportion(map, (Double)compressMap.get("property"));
                    }else if("3".equals(compressType)){                   	
                    	compressImage = compresseImagebyProportion(map, (Double)compressMap.get("quality"));
                    }
                }                   
                //判断是否需要传到对应的图片服务上
                ftpType =  ImagePropUtil.getValue("ftp_type");                   
                if("2".equals(ftpType)){//传到windows
                	imageftpMap = WinSftpUtil.upload(map,imageName,appendUrl);
                	if(!"0".equals(compressType)){
                		String compressName = (String) compressImage.get("fileName");
                		WinSftpUtil.upload(compressImage,compressName,appendUrl);
                	}
                }else if("3".equals(ftpType)){//传到linux
                	imageftpMap = LinuxSftpUtil.upload(map,imageName,appendUrl);
                	if(!"0".equals(compressType)){
                		String compressName = (String) compressImage.get("fileName");
                		LinuxSftpUtil.upload(compressImage,compressName,appendUrl);
                	}
                }
            } catch (Exception e) {
            	System.out.println("上传异常信息"+e);
                map.put("flag", false);
            }
            if("1".equals(ftpType)){
            	resultMap.put("imageUrl", map.get("imageUrl"));
            	resultMap.put("uploadFolder", map.get("uploadFolder"));
            	resultMap.put("visitUrl", map.get("visitUrl"));
            }else{
            	resultMap.put("imageUrl", imageftpMap.get("ftp_dbName"));
            	resultMap.put("uploadFolder", map.get("uploadFolder"));
            	resultMap.put("visitUrl", map.get("visitUrl"));
            }
            
        }
        return resultMap;
    }
	
	
	/**
	 *  按尺寸压缩
	 * 
	 * @param image  上传时文件 的具体信息
	 *            上传文件后的文件参数 fileMap.uploadFolder 上传文件的物理地址，即文件的实际商场的文件夹
	 *            fileMap.fileName 上传的文件名 
	 *            fileMap.flag是否上传成功
	 * @param width  宽
	 * @param height 高
	 * return  	Map<String, Object>  returnMap
	 * 			returnMap.uploadFolder 压缩文件的文件夹路径
	 * 			returnMap.fileName 压缩文件的文件的名称
	 * 			returnMap.visitUrl 压缩文件的访问路径
	 * 			returnMap.flag 是否压缩成功
	 * 按尺寸压缩
	 */
	public static Map<String, Object> compresseImagebyPx(Map<String, Object> image, Integer width, Integer height) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if ((Boolean) image.get("flag")) {
			String uploadFolder = image.get("uploadFolder").toString();
			String fileName = image.get("fileName").toString();
			String uploadUrl = uploadFolder +"/"+ fileName;
			String visitUrl=image.get("fileName").toString();      
			String compresseUrl = uploadFolder +"/"+ fileName.substring(0, fileName.lastIndexOf("."))
					+ ImagePropUtil.getValue("thumbnail_suffix_px");
			try {
				Thumbnails.of(uploadUrl).forceSize(400, 300).toFile(compresseUrl);
				returnMap.put("uploadFolder", uploadFolder);
				returnMap.put("flag", true);
				returnMap.put("fileName", fileName.substring(0, fileName.lastIndexOf("."))
						+ImagePropUtil.getValue("thumbnail_suffix_px")
						+fileName.substring(fileName.lastIndexOf(".")));
				returnMap.put("visitUrl", visitUrl.substring(0,visitUrl.lastIndexOf("/")+1)
								+fileName.substring(0, fileName.lastIndexOf("."))
								+ImagePropUtil.getValue("thumbnail_suffix_px")
							    +fileName.substring(fileName.lastIndexOf(".")));
				
				
			} catch (IOException e) {
				returnMap.put("flag", false);
				e.printStackTrace();
			}
		}
		return returnMap;
	}

	/**
	 * 大小，质量按比例同时压缩
	 * 
	 * @param image  上传时文件 的具体信息
	 *            上传文件后的文件参数 fileMap.uploadFolder 上传文件的物理地址，即文件的实际商场的文件夹
	 *            fileMap.fileName 上传的文件名 
	 *            fileMap.flag是否上传成功
	 * @param proportion  比例
	 * return  	Map<String, Object>  returnMap
	 * 			returnMap.uploadFolder 压缩文件的文件夹路径
	 * 			returnMap.fileName 压缩文件的文件的名称
	 * 			returnMap.visitUrl 压缩文件的访问路径
	 * 			returnMap.flag 是否压缩成功
	 * 大小，质量按比例同时压缩
	 */
	public static Map<String, Object> compresseImagebyProportion(Map<String, Object> image, Double proportion) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if ((Boolean) image.get("flag")) {
			//Map<String, Object> returnMap = new HashMap<String, Object>();
			String uploadFolder = image.get("uploadFolder").toString();
			String fileName = image.get("fileName").toString();
			String uploadUrl = uploadFolder +"/"+ fileName;
			String visitUrl=image.get("fileName").toString();
			String compresseUrl = uploadFolder +"/"+ fileName.substring(0, fileName.lastIndexOf("."))
					+ ImagePropUtil.getValue("thumbnail_suffix_proportion");
			try {
				//这个地方会速度慢
				Thumbnails.of(uploadUrl).scale(proportion).toFile(compresseUrl);
				returnMap.put("uploadFolder", uploadFolder);
				returnMap.put("flag", true);
				String lastIndex = fileName.substring(fileName.lastIndexOf("."));
				if(".jpg".equals(lastIndex)||".JPG".equals(lastIndex)||".JPEG".equals(lastIndex)){
					returnMap.put("fileName", fileName.substring(0, fileName.lastIndexOf("."))
							+ImagePropUtil.getValue("thumbnail_suffix_proportion")
							+".JPEG");
					returnMap.put("visitUrl", visitUrl.substring(0,visitUrl.lastIndexOf("/")+1)
							+fileName.substring(0, fileName.lastIndexOf("."))
							+ImagePropUtil.getValue("thumbnail_suffix_proportion")
						    +".JPEG");
				}else{
					returnMap.put("fileName", fileName.substring(0, fileName.lastIndexOf("."))
							+ImagePropUtil.getValue("thumbnail_suffix_proportion")
							+fileName.substring(fileName.lastIndexOf(".")));
					returnMap.put("visitUrl", visitUrl.substring(0,visitUrl.lastIndexOf("/")+1)
							+fileName.substring(0, fileName.lastIndexOf("."))
							+ImagePropUtil.getValue("thumbnail_suffix_proportion")
						    +fileName.substring(fileName.lastIndexOf(".")));
				}
			} catch (IOException e) {
				returnMap.put("flag", false);
				e.printStackTrace();
			}
		}
		return returnMap;
	}

	/**
	 * 按照图片质量进行压缩，尺寸不变
	 * 
	 * @param image  上传时文件 的具体信息
	 *            上传文件后的文件参数 fileMap.uploadFolder 上传文件的物理地址，即文件的实际商场的文件夹
	 *            fileMap.fileName 上传的文件名 
	 *            fileMap.flag是否上传成功
	 * @param quality
	 * return  	Map<String, Object>  returnMap
	 * 			returnMap.uploadFolder 压缩文件的文件夹路径
	 * 			returnMap.fileName 压缩文件的文件的名称
	 * 			returnMap.visitUrl 压缩文件的访问路径
	 * 			returnMap.flag 是否压缩成功
	 * 质量数值 eg:0.1 原图质量的十分之一的图片存储大小
	 */
	public static Map<String, Object> compresseImagebyQuality(Map<String, Object> image, Double quality) {
		// 只压缩质量，不压缩尺寸
		if ((Boolean) image.get("flag")) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			String uploadFolder = image.get("uploadFolder").toString();
			String fileName = image.get("fileName").toString();
			String uploadUrl = uploadFolder +"/"+ fileName;
			String visitUrl=image.get("fileName").toString();
			String compresseUrl = uploadFolder +"/"+ fileName.substring(0, fileName.lastIndexOf("."))
					+ ImagePropUtil.getValue("thumbnail_suffix_quality");
			try {
				Thumbnails.of(uploadUrl).scale(1f).outputQuality(quality).toFile(compresseUrl);
				returnMap.put("uploadFolder", uploadFolder);
				returnMap.put("flag", true);
				returnMap.put("fileName", fileName.substring(0, fileName.lastIndexOf("."))
						+ImagePropUtil.getValue("thumbnail_suffix_quality")
						+fileName.substring(fileName.lastIndexOf(".")));
				returnMap.put("visitUrl", visitUrl.substring(0,visitUrl.lastIndexOf("/")+1)
						+fileName.substring(0, fileName.lastIndexOf("."))
						+ImagePropUtil.getValue("thumbnail_suffix_quality")
					    +fileName.substring(fileName.lastIndexOf(".")));
			} catch (IOException e) {
				returnMap.put("flag", false);
				e.printStackTrace();
			}
			return returnMap;
		}
		return null;

	}
	
	/**
	 * 
	 * @param fileMap
	 *            上传文件后的文件参数 fileMap.uploadFolder 上传文件的物理地址，即文件的实际商场的文件夹
	 *            fileMap.fileName 上传的文件名 fileMap.flag是否上传成功
	 * @param remoteFileName
	 *            上传后的文件名
	 * @return Map<String,Object> returnMap 
	 * 		   returnMap.ftp_visitUrl ftp文件的访问路径
	 *         returnMap.ftp_uploadFolder ftp文件的实际的文件夹 
	 *         returnMap.ftp_fileName
	 *         ftp文件的文件名
	 * @throws Exception
	 */
	public static Map<String, Object> upload(Map<String, Object> fileMap, String remoteFileName) throws Exception {
		//判断服务器类型
		if(ImagePropUtil.getValue("ftp_type").endsWith("1")){
			return WinSftpUtil.upload(fileMap,remoteFileName);
		}else{
			return LinuxSftpUtil.upload(fileMap,remoteFileName);
		}
		
	}
	
	/**
	 * 
	 * @param fileMap
	 *            上传文件后的文件参数 fileMap.uploadFolder 上传文件的物理地址，即文件的实际商场的文件夹
	 *            fileMap.fileName 上传的文件名
	 *            fileMap.flag是都=否上传成功
	 * @param remoteFileName
	 *            上传后的文件名
	 * @param appendFolders
	 *            相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名   例如  /testImage/
	 *            如 /testUpload/test1     
	 * @return Map<String,Object> returnMap 
	 * 		   returnMap.ftp_visitUrl ftp文件的访问路径
	 *         returnMap.ftp_uploadFolder ftp文件的实际的文件夹
	 *         returnMap.ftp_fileName ftp文件的文件名
	 *         
	 * @throws Exception
	 */
	public static Map<String, Object> upload(Map<String, Object> fileMap, String remoteFileName, String appendFolders)
			throws Exception {
		//判断服务器类型
		if(ImagePropUtil.getValue("ftp_type").endsWith("1")){
			return WinSftpUtil.upload(fileMap,remoteFileName,appendFolders);
		}else{
			return LinuxSftpUtil.upload(fileMap,remoteFileName,appendFolders);
		}
		
	}
	
	
	
	/**
	 * 
	 * @param fileMap
	 *            上传文件后的文件参数 fileMap.uploadFolder 上传文件的物理地址，即文件的实际商场的文件夹
	 *            fileMap.fileName 上传的文件名
	 *            fileMap.flag是都=否上传成功
	 * @param remoteFileName
	 *            上传后的文件名
	 * @param appendFolders
	 *            相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名  例如  /testImage/
	 *            如 /testUpload/test1     
	 * @return Map<String,Object> returnMap 
	 * 		   returnMap.ftp_visitUrl ftp文件的访问路径
	 *         returnMap.ftp_uploadFolder ftp文件的实际的文件夹
	 *         returnMap.ftp_fileName ftp文件的文件名
	 *         
	 * @throws Exception
	 */
	public static Map<String, Object> windowsupload(Map<String, Object> fileMap, String remoteFileName, String appendFolders)
			throws Exception {
		if ((Boolean) fileMap.get("flag")) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			String uploadFolder = fileMap.get("uploadFolder").toString();
			String fileName = fileMap.get("fileName").toString();
			String uploadUrl = uploadFolder + fileName;
			String remoteDirectory = ImagePropUtil.getValue("ftp_file_path") +"/"+ appendFolders;
			Sftp sftp = new Sftp(null);
			File file = new File(uploadUrl);
			//sftp.upload(new FileInputStream(file), remoteDirectory, remoteFileName);
			sftp.getConnect(ImagePropUtil.getValue("ftp_host"), Integer.parseInt(ImagePropUtil.getValue("ftp_port")),
					ImagePropUtil.getValue("ftp_username"), ImagePropUtil.getValue("ftp_password"));
			sftp.upload(new FileInputStream(file), remoteDirectory, remoteFileName);
			returnMap.put("ftp_visitUrl",
					ImagePropUtil.getValue("ftp_visit_path") + remoteDirectory + "/" + remoteFileName);
			returnMap.put("ftp_uploadFolder", remoteDirectory);
			returnMap.put("ftp_fileName", remoteFileName);
			returnMap.put("ftp_dbName", "/"+appendFolders+"/"+remoteFileName);
			sftp.disconnect();
			return returnMap;
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param fileMap
	 *            上传文件后的文件参数 fileMap.uploadFolder 上传文件的物理地址，即文件的实际商场的文件夹
	 *            fileMap.fileName 上传的文件名
	 *            fileMap.flag是都=否上传成功
	 * @param remoteFileName
	 *            上传后的文件名
	 * @param appendFolders
	 *            相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名   例如  /testImage/
	 *            如 /testUpload/test1     
	 * @return Map<String,Object> returnMap 
	 * 		   returnMap.ftp_visitUrl ftp文件的访问路径
	 *         returnMap.ftp_uploadFolder ftp文件的实际的文件夹
	 *         returnMap.ftp_fileName ftp文件的文件名
	 *         
	 * @throws Exception
	 */
	public static Map<String, Object> linuxupload(Map<String, Object> fileMap, String remoteFileName, String appendFolders)
			throws Exception {
		if ((Boolean) fileMap.get("flag")) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			String uploadFolder = fileMap.get("uploadFolder").toString();
			String fileName = fileMap.get("fileName").toString();
			String uploadUrl = uploadFolder+"/"+ fileName;
			String remoteDirectory = ImagePropUtil.getValue("ftp_file_path") +"/"+ appendFolders;
			Sftp sftp = new Sftp(null);
			File file = new File(uploadUrl);
			//sftp.upload(new FileInputStream(file), remoteDirectory, remoteFileName);
			sftp.getConnect(ImagePropUtil.getValue("ftp_host"), Integer.parseInt(ImagePropUtil.getValue("ftp_port")),
					ImagePropUtil.getValue("ftp_username"), ImagePropUtil.getValue("ftp_password"));
			sftp.upload(new FileInputStream(file), remoteDirectory, remoteFileName);
			returnMap.put("ftp_visitUrl",
					ImagePropUtil.getValue("ftp_visit_path") + remoteDirectory + "/" + remoteFileName);
			returnMap.put("ftp_uploadFolder", remoteDirectory);
			returnMap.put("ftp_fileName", remoteFileName);
			returnMap.put("ftp_dbName", "/"+appendFolders+"/"+remoteFileName);
			sftp.disconnect();
			return returnMap;
		}
		return null;
	}
	
	
	private static class Sftp {
		private static final Logger LOGGER = LoggerFactory.getLogger(Sftp.class);
		private  FTPClient ftpClient=null;
	
		public Sftp() {
			// TODO Auto-generated constructor stub
		}

		public Sftp(String str) {
			// TODO Auto-generated constructor stub
		}
		private void getConnect(String host, int port, String username, String password) throws Exception {
			LOGGER.debug("开始创建sftp连接...");
			 this.ftpClient = new FTPClient();
		     ftpClient.connect(host,port);
			 ftpClient.login(username, password);
			LOGGER.debug("创建sftp连接结束...");
		}
		
		private void disconnect() throws Exception {
			if (this.ftpClient!= null) {
				ftpClient.disconnect();
			}
		}
		
		
		private void upload(InputStream inputStream, String remoteDirectory, String remoteFileName) throws Exception {
			this.ftpClient.changeWorkingDirectory("/");// 切换到根目录
			try {
				if ((!remoteDirectory.equals("")) && (remoteDirectory.trim() != "")) {
					String[] dd = remoteDirectory.split("/");
					for (String directory : dd)
						  if (directory != null && !"".equals(directory.trim())) {
							  if (!ftpClient.changeWorkingDirectory(directory)) {
			                        ftpClient.makeDirectory(directory);
			                        ftpClient.changeWorkingDirectory(directory);
			                    }
		                    }                		                   
				}
				this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				this.ftpClient.storeFile(remoteFileName, inputStream);
			} catch (Exception e) {
				disconnect();
				throw new Exception(e.getMessage(), e);
			}
		}
		
		
		private void download(String remoteDirectory, String remoteFileName, String localDirectorys,
				String localFileName) throws Exception {
			this.ftpClient.changeWorkingDirectory(remoteDirectory);
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(new File(localDirectorys, localFileName));
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				ftpClient.retrieveFile(remoteFileName, fos);
			} catch (Exception e) {
				disconnect();
				throw new Exception(e.getMessage(), e);
			}
			
		}

		private void delete(String directory, String deleteFile) throws Exception {
			this.ftpClient.changeWorkingDirectory(directory);
			try {
				ftpClient.deleteFile(deleteFile);
			} catch (Exception e) {
				throw new Exception(e.getMessage(), e);
			} finally {
				disconnect();
				
			}
		}
	}
}
