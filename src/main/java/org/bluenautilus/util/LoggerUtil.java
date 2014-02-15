package org.bluenautilus.util;

// Import log4j classes.

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import javax.servlet.ServletContext;
import java.util.logging.Logger;

/**
 * User: bluenautilus2
 * Date: 6/16/13
 * Time: 6:37 PM
 */
public class LoggerUtil {

    private PropertiesConfiguration config = null;


    /**
     * ASSUMES THAT CONFIGURATION IS ALREADY SET IN THE CONTEXT
     */
    /*package*/ LoggerUtil(ServletContext context) throws ConfigurationException {

        ConfigUtil util = ConfigUtil.getFromContext(context);
        config = util.getWebConfig();
    }


    /*package*/ void initialize(){

        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.info("Logger configured.");

    }

}

