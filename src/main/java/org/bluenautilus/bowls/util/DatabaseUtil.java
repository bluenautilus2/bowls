package org.bluenautilus.bowls.util;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * User: bluenautilus2
 * Date: 5/6/13
 * Time: 2:07 PM
 */
public class DatabaseUtil {

   // ConnectionPool pool = new ConnectionPool();

    public void DatabaseUtil(){

    }

    private String getConnectString() throws Exception {
        ConfigUtil config = new ConfigUtil();
        PropertiesConfiguration propConf = config.getDBConfig();

        StringBuffer buff = new StringBuffer();
        buff.append("jdbc:mysql://localhost/");
        buff.append(propConf.getString(ConfigUtil.DB_NAME) + "?");
        buff.append("user=" + propConf.getString(ConfigUtil.DB_USER));
        buff.append("&password=" + propConf.getString(ConfigUtil.DB_PASS));
        return buff.toString();

    }
}
