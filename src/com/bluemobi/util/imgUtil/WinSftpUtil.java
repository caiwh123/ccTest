package com.bluemobi.util.imgUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author liwz  用于向windows 上边上传静态资源的工具类，主要用于图片，文件等静态资源的传输和下载
 *
 */

public class WinSftpUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(LinuxSftpUtil.class);
	
	public static void main(String[] args) throws Exception {
		test();
	}

	private static void test() throws Exception {
		long b = System.currentTimeMillis();
//
//		String host = "172.51.97.72";
//		short port = 22;
		String host = "10.58.150.132";
		short port = 22;
		String username = "ftp";
		String password = "ftp";

		String localFilePathName = "E://testFtp/ftpImage.png";

//		String remoteDirectory = "/usr/local/tomcat/tomcat8086/webapps/img/testFtp";
		String remoteDirectory = "/testFtp1";
		String remoteFileName = "ftpImage.png";
		String localDirectorys = "E://testFtp";
		String localFileName = "ftpImage1.png";

	/*	upload(host, port, username, password, localFilePathName, remoteDirectory, remoteFileName);*/

		download(host, port, username, password, remoteDirectory, remoteFileName, localDirectorys, localFileName);

		long e = System.currentTimeMillis();

		System.err.println("总耗时：" + (e - b / 1000.0D) + "秒");
	}

	/**
	 * 
	 * @param host
	 *            目标服务器的ip地址
	 * @param port
	 *            目标服务器的端口号
	 * @param username
	 *            ftp的登陆账号
	 * @param password
	 *            ftp的登陆密码
	 * @param inputStream
	 *            本地文件的输入流，用于读取本地文件
	 * @param remoteDirectory
	 *            目标服务器的文件目录（从根目录开始写例如：/usr/local/tomcat/tomcat8086/webapps/img/
	 *            testFtp）
	 * @param remoteFileName
	 *            上传后文件的文件名
	 * @throws Exception
	 *             异常
	 */
	public static void upload(String host, int port, String username, String password, InputStream inputStream,
			String remoteDirectory, String remoteFileName) throws Exception {
		Sftp sftp = new Sftp(null);
		sftp.getConnect(host, port, username, password);
		sftp.upload(inputStream, remoteDirectory, remoteFileName);
		sftp.disconnect();
	}

	/**
	 * 
	 * @param host
	 *            目标服务器的ip地址
	 * @param port
	 *            目标服务器的端口号
	 * @param username
	 *            ftp的登陆账号
	 * @param password
	 *            ftp的登陆密码
	 * @param localFilePathName
	 *            本地文件的存储地址（含文件名）
	 * @param remoteDirectory
	 *            目标服务器的文件目录（从根目录开始写例如：/usr/local/tomcat/tomcat8086/webapps/img/
	 *            testFtp）
	 * @param remoteFileName
	 *            上传后文件的文件名
	 * @throws Exception
	 *             异常
	 */
	public static void upload(String host, int port, String username, String password, String localFilePathName,
			String remoteDirectory, String remoteFileName) throws Exception {
		Sftp sftp = new Sftp(null);
		sftp.getConnect(host, port, username, password);
		File file = new File(localFilePathName);
		sftp.upload(new FileInputStream(file), remoteDirectory, remoteFileName);
		sftp.disconnect();
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
		if ((Boolean) fileMap.get("flag")) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			String uploadFolder = fileMap.get("uploadFolder").toString();
			String fileName = fileMap.get("fileName").toString();
			String uploadUrl = uploadFolder + fileName;
			String remoteDirectory = ImagePropUtil.getValue("ftp_file_path");
			Sftp sftp = new Sftp(null);
			File file = new File(uploadUrl);
			sftp.upload(new FileInputStream(file), remoteDirectory, remoteFileName);
			sftp.getConnect(ImagePropUtil.getValue("ftp_host"), Integer.parseInt(ImagePropUtil.getValue("ftp_port")),
					ImagePropUtil.getValue("ftp_username"), ImagePropUtil.getValue("ftp_password"));
			returnMap.put("ftp_visitUrl", ImagePropUtil.getValue("ftp_visi_path") + "/" + remoteFileName);
			returnMap.put("ftp_uploadFolder", remoteDirectory);
			returnMap.put("ftp_fileName", remoteFileName);
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
	 *            相对于配置文件（image.properties）中ftp_file_path的相对路径不含文件名  例如  /testImage/
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
		if ((Boolean) fileMap.get("flag")) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			String uploadFolder = fileMap.get("uploadFolder").toString();
			String fileName = fileMap.get("fileName").toString();
			String uploadUrl = uploadFolder +"/"+ fileName;
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
	 * @param host  下载的地址 ip
	 * @param port  下载的端口号
	 * @param username  下载的用户名
	 * @param password  下载的密码
	 * @param remoteDirectory 服务器文件所在的文件夹
	 * @param remoteFileName  服务器文件的名称
	 * @param localDirectorys  下载到本地的文件夹
	 * @param localFileName  本地的文件名
	 * @throws Exception
	 */
	public static void download(String host, int port, String username, String password, String remoteDirectory,
			String remoteFileName, String localDirectorys, String localFileName) throws Exception {
		Sftp sftp = new Sftp(null);
		sftp.getConnect(host, port, username, password);
		sftp.download(remoteDirectory, remoteFileName, localDirectorys, localFileName);
		sftp.disconnect();
	}
	/**
	 * 这个方法和相应的上传方法对应
	 * @param remoteDirectory 服务器文件所在的文件夹
	 * @param remoteFileName  服务器文件的名称
	 * @param localDirectorys  下载到本地的文件夹
	 * @param localFileName  本地的文件名
	 * @throws Exception
	 */
	public static void download( String remoteDirectory,
			String remoteFileName, String localDirectorys, String localFileName) throws Exception {
		Sftp sftp = new Sftp(null);
		sftp.getConnect(ImagePropUtil.getValue("ftp_host"), Integer.parseInt(ImagePropUtil.getValue("ftp_port")),
				ImagePropUtil.getValue("ftp_username"), ImagePropUtil.getValue("ftp_password"));
		sftp.download(remoteDirectory, remoteFileName, localDirectorys, localFileName);
		sftp.disconnect();
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
