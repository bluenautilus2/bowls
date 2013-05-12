package org.bluenautilus.bowls.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.InputStream;

/**
 * User: bluenautilus2
 * Date: 5/3/13
 * Time: 11:20 PM
 */
public class ConfigUtil {
    private static PropertiesConfiguration config = null;

    private static final String CONFIG_FOLDER = "";
    private static final String DB_FILENAME = "db.properties";

    public static final String DB_USER = "user";
    public static final String DB_NAME = "db";
    public static final String DB_PASS = "password";


    public PropertiesConfiguration getDBConfig() throws ConfigurationException {
        if (ConfigUtil.config == null) {

            InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties");

            config = new PropertiesConfiguration();

            config.load(input);
        }
        return config;
    }


}


