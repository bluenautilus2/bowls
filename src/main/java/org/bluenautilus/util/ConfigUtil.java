package org.bluenautilus.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import javax.servlet.ServletContext;
import java.io.InputStream;

/**
 * User: bluenautilus2
 * Date: 5/3/13
 * Time: 11:20 PM
 */
public class ConfigUtil {

    private static PropertiesConfiguration dbConfig = null;
    private static PropertiesConfiguration webConfig = null;

    private static final String DB_FILENAME = "db.properties";
    private static final String WEB_FILENAME = "web.properties";

    public static final String DB_USER = "user";
    public static final String DB_NAME = "db";
    public static final String DB_PASS = "password";
    public static final String HOME_DIR = "working_directory";
    public static final String LOG_DIR = "log_directory";

    public static final String ATTRIBUTE_NAME = ConfigUtil.class.getName();

    public ConfigUtil() throws ConfigurationException{
        this.getDBConfig();
    }

    public static ConfigUtil getFromContext(ServletContext context){
         return (ConfigUtil)context.getAttribute(ATTRIBUTE_NAME);
    }

    public PropertiesConfiguration getDBConfig() throws ConfigurationException {
        if (ConfigUtil.dbConfig == null) {

            InputStream input = getClass().getClassLoader().getResourceAsStream(DB_FILENAME);

            dbConfig = new PropertiesConfiguration();

            dbConfig.load(input);
        }
        return dbConfig;
    }


    public PropertiesConfiguration getWebConfig() throws ConfigurationException {
        if (ConfigUtil.webConfig == null) {

            InputStream input = getClass().getClassLoader().getResourceAsStream(WEB_FILENAME);

            webConfig = new PropertiesConfiguration();

            webConfig.load(input);
        }
        return webConfig;
    }



}


