package com.bluemobi.util.imgUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ImagePropUtil {
	private static Properties props = 
			new Properties();
		static{
			InputStream ips  = 
					ImagePropUtil.class.getClassLoader()
				.getResourceAsStream("/image.properties");
			try {
				props.load(ips);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(
						"读取db.properties文件失败");
			}
		}
		
		public static String getValue(String key){
			return props.getProperty(key);
		}
		
		public static void main(String[] args){
			System.out.println(getValue("driver"));
		}

}
