package com.bluemobi.util.imgUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 
 * @author liwz
 *
 */
public class ImageCompresseUtil {
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
	public static void compresseImagebyPx(Map<String, Object> image, Integer width, Integer height) {
		if ((Boolean) image.get("flag")) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			String uploadFolder = image.get("uploadFolder").toString();
			String fileName = image.get("fileName").toString();
			String uploadUrl = uploadFolder + fileName;
			String visitUrl=image.get("fileName").toString();      
			String compresseUrl = uploadFolder + fileName.substring(0, fileName.lastIndexOf("."))
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
			String uploadUrl = uploadFolder + fileName;
			String visitUrl=image.get("fileName").toString();
			String compresseUrl = uploadFolder + fileName.substring(0, fileName.lastIndexOf("."))
					+ ImagePropUtil.getValue("thumbnail_suffix_proportion");
			try {
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
			String uploadUrl = uploadFolder + fileName;
			String visitUrl=image.get("fileName").toString();
			String compresseUrl = uploadFolder + fileName.substring(0, fileName.lastIndexOf("."))
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
}
