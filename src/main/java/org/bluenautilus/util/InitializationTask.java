package org.bluenautilus.util;

import org.apache.commons.configuration.ConfigurationException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: bluenautilus2
 * Date: 5/27/13
 * Time: 5:02 PM
 */
public class InitializationTask implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
           ServletContext context = servletContextEvent.getServletContext();
            ConfigUtil config = new ConfigUtil();
            context.setAttribute(ConfigUtil.ATTRIBUTE_NAME, config);

            LoggerUtil loggerUtil = new LoggerUtil(context);
            loggerUtil.initialize();

            DatabaseUtil dbUtil = new DatabaseUtil(context);
            context.setAttribute(DatabaseUtil.ATTRIBUTE_NAME, dbUtil);


        } catch (Exception ex) {
              System.out.print(ex.getMessage());
              throw new RuntimeException(ex);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //do something. someday.
    }

}
