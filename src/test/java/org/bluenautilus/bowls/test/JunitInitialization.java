package org.bluenautilus.bowls.test;

import org.bluenautilus.util.ConfigUtil;
import org.bluenautilus.util.HibernateUtil;
import org.bluenautilus.util.LoggerUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: bluenautilus2
 * Date: 2/23/14
 * Time: 1:34 PM
 */
public class JunitInitialization {

    static Logger logger = Logger.getLogger(JunitInitialization.class.getName());
    private static HibernateUtil hibernateUtil;


    public static void init() {
        try {

            LoggerUtil loggerUtil = new LoggerUtil();
            loggerUtil.initialize();

            hibernateUtil = new HibernateUtil();
            hibernateUtil.init();

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }


    public static void shutdown() {
        logger.info("Shutting down server");
        try{
            hibernateUtil.shutDownSessionFactory();
        }catch(Exception e){
            //well, we're shutting down anyways i guess
            logger.log(Level.SEVERE,"barfing on shutdown", e);
        }
    }
}
