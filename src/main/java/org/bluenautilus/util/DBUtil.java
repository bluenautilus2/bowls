package org.bluenautilus.util;

import org.apache.commons.configuration.ConfigurationException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.sql.DriverManager;


/**
 * User: bluenautilus2
 * Date: 2/15/14
 * Time: 6:54 PM
 */
public class DBUtil {

    private static String DB_NAME = "bowls";
    private static String DB_HOST = "localhost";
    private static String DB_USER = "bluenautilus2";
    private static String DB_PASSWORD = "redstar3";

    private static Logger logger = Logger.getLogger(DBUtil.class.getName());
    private static Connection theOneConnection;

    public DBUtil() throws ConfigurationException {

    }

    public static void init() throws Exception {

        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException classNotFoundEx) {
            // handle the error
        }

        theOneConnection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DB_NAME + "?" +
                "user=" + DB_USER + "&password=" + DB_PASSWORD);
    }

    public static Connection getTheOneConnection(){
        return theOneConnection;
    }

    public static void shutdown() {
        try {
            theOneConnection.close();
        } catch (SQLException sex) {

        }

    }

}


