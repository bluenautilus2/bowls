package org.bluenautilus.util;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * User: bluenautilus2
 * Date: 5/27/13
 * Time: 5:02 PM
 */
public class InitializationTask implements ServletContextListener {
    static Logger logger = Logger.getLogger(InitializationTask.class.getName());
    private DBUtil hibernateUtil;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext context = servletContextEvent.getServletContext();
            ConfigUtil config = new ConfigUtil();
            context.setAttribute(ConfigUtil.ATTRIBUTE_NAME, config);

            LoggerUtil loggerUtil = new LoggerUtil();
            loggerUtil.initialize();

            hibernateUtil = new DBUtil();
            hibernateUtil.init();

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
       logger.info("Shutting down server");
        try{
            DBUtil.shutdown();
        }catch(Exception e){
            //well, we're shutting down anyways i guess
            logger.log(Level.SEVERE,"barfing on shutdown", e);
        }
    }

}
