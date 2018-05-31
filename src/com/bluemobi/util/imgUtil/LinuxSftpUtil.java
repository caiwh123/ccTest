package com.bluemobi.util.imgUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * 
 * @author liwz 用于向linux 上边上传静态资源的工具类，主要用于图片，文件等静态资源的传输和下载
 */
public class LinuxSftpUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(LinuxSftpUtil.class);
	


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

	/**
	 * 
	 * @author liwz 一个静态的内部类，主要用于封装文件上传下载等方法
	 */
	private static class Sftp {
		private static final Logger LOGGER = LoggerFactory.getLogger(Sftp.class);

		private Session session = null;
		private Channel channel = null;
		private ChannelSftp sftp = null;

		public Sftp() {
			// TODO Auto-generated constructor stub
		}

		public Sftp(String str) {
			// TODO Auto-generated constructor stub
		}

		private void getConnect(String host, int port, String username, String password) throws Exception {
			LOGGER.debug("开始创建sftp连接...");
			JSch jsch = new JSch();
			this.session = jsch.getSession(username, host, port);
			this.session.setPassword(password);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			this.session.setConfig(config);

			this.session.connect();

			this.channel = this.session.openChannel("sftp");

			this.channel.connect();

			this.sftp = ((ChannelSftp) this.channel);

			LOGGER.debug("创建sftp连接结束...");
		}

		private void upload(InputStream inputStream, String remoteDirectory, String remoteFileName) throws Exception {
			this.sftp.cd("/");
			try {
				if ((!remoteDirectory.equals("")) && (remoteDirectory.trim() != "")) {
					String[] dd = remoteDirectory.split("/");
					for (String directory : dd)
						if ((directory != null) && (!"".equals(directory.trim()))) {
							try {
								this.sftp.cd(directory);
							} catch (SftpException sException) {
								if (2 == sException.id) {
									LOGGER.info("创建目录【{}】", new Object[] { directory });
									this.sftp.mkdir(directory);
									this.sftp.cd(directory);
								}
							}
						}
				}
				this.sftp.put(inputStream, remoteFileName);
			} catch (Exception e) {
				throw new Exception(e.getMessage(), e);
			}
		}

		private void download(String remoteDirectory, String remoteFileName, String localDirectorys,
				String localFileName) throws Exception {
			try {
				this.sftp.cd(remoteDirectory);
				File file = new File(localDirectorys);
				if (!file.exists()) {
					file.mkdirs();
				}
				this.sftp.get(remoteFileName, new FileOutputStream(new File(localDirectorys, localFileName)));
			} catch (Exception e) {
				throw new Exception(e.getMessage(), e);
			} finally {
				disconnect();
			}
		}

		private void delete(String directory, String deleteFile) throws Exception {
			try {
				this.sftp.cd(directory);
				this.sftp.rm(deleteFile);
			} catch (Exception e) {
				throw new Exception(e.getMessage(), e);
			} finally {
				disconnect();
			}
		}

		private void disconnect() throws Exception {
			if (this.sftp != null) {
				this.sftp.disconnect();
				this.sftp.exit();
				this.sftp = null;
			}
			if (this.channel != null) {
				this.channel.disconnect();
				this.channel = null;
			}
			if (this.session != null) {
				this.session.disconnect();
				this.session = null;
			}
		}
	}

}
