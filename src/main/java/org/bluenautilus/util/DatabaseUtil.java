package org.bluenautilus.util;



import org.apache.commons.configuration.PropertiesConfiguration;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * User: bluenautilus2
 * Date: 5/6/13
 * Time: 2:07 PM
 */
public class DatabaseUtil {

    static Logger logger = Logger.getLogger(DatabaseUtil.class.getName());

    public static final String ATTRIBUTE_NAME = DatabaseUtil.class.getName();
    private PropertiesConfiguration config = null;
    private static String urlString = null;



    /**
     * ASSUMES THAT CONFIGURATION IS ALREADY SET IN THE CONTEXT
     * AND THE LOGGER IS SETUP
     */
    /*package*/ DatabaseUtil(ServletContext context) throws Exception {

        ConfigUtil util = ConfigUtil.getFromContext(context);
        config = util.getDBConfig();
        urlString = getConnectString();

    }

    private String getConnectString() throws Exception {

        StringBuilder builder = new StringBuilder();
        builder.append("jdbc:mysql://localhost/");
        builder.append(config.getString(ConfigUtil.DB_NAME) + "?");
        builder.append("user=" + config.getString(ConfigUtil.DB_USER));
        builder.append("&password=" + config.getString(ConfigUtil.DB_PASS));
        logger.info("DB Configuration returning URL: " + builder.toString());
        return builder.toString();

    }

    private void createConnectionPool() throws NamingException, SQLException {
        InitialContext ctx = new InitialContext();

        DataSource ds =
                (DataSource)ctx.lookup("java:comp/env/jdbc/MySQLDB");
        Connection conn = ds.getConnection();


    }



    public static DatabaseUtil getFromContext(ServletContext context) {
        return (DatabaseUtil) context.getAttribute(ATTRIBUTE_NAME);
    }

    public static String getUrlString() {
        return urlString;
    }

    public static void setUrlString(String urlString) {
        DatabaseUtil.urlString = urlString;
    }


}
