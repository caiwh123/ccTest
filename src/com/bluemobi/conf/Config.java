package com.bluemobi.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appcore.model.AbstractObject;

/**
 *  配置加载
 * @author haojian
 * Apr 27, 2012 3:21:26 PM
 */
public class Config extends AbstractObject{
    
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    private static String fileName = "config.properties";
    
    private static Properties p = getProperties(fileName);
    
    
    /**项目名*/
    public static final String SITE_NAME = p.getProperty("SITE_NAME");
    /**项目访问url*/
    public static final String BASE_URL = p.getProperty("BASE_URL");
    /**项目访问url,无权限*/
    public static final String BASE_URL_F = p.getProperty("BASE_URL_F");
    /**项目访问url,无权限*/
    public static final String BASE_URL_P = p.getProperty("BASE_URL_P");
    /**静态资源服务器地址，存放js库,css,网站原生图片 等*/
    public static final String STATIC_URL = p.getProperty("STATIC_URL");
    /**H5样式 CSS JS等*/
    public static final String H5_URL = p.getProperty("H5_URL");
    /**图片服务器地址，存放用户上传的图片、视频等*/
    public static final String IMG_URL = p.getProperty("IMG_URL");
    
    
    /**项目名*/
    public static final String PROJECT_NAME = p.getProperty("PROJECT_NAME");
    /**
     * 读取propertity文件的方法
     * @author haojian
     * Apr 27, 2012 3:00:56 PM
     * @param fileName
     * @return
     */
    public static Properties getProperties(String fileName){
        
        LOGGER.info("开始读取文件【{}】...", new Object[]{fileName} );
        
        InputStream is = Config.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties=new Properties();
        try {
            properties.load(is);
            if(is!=null){
                is.close();
            }
        } catch (IOException e) {
            LOGGER.error("Exception:【{}】"+e);
        }
        
        LOGGER.info("读取文件【{}】结束...", new Object[]{fileName} );
        
        return properties;
    }
    
    
    
    
}
