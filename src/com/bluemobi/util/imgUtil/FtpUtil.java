package com.bluemobi.util.imgUtil;

import java.util.Map;

/**
 * 
 * @author liwz
 *  ftp工具类，主要是对ftp上传文件
 */
public class FtpUtil {
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

}
