package org.bluenautilus.util;

import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.PooledDataSource;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;



/**
 * User: bluenautilus2
 * Date: 2/15/14
 * Time: 6:54 PM
 */
public class HibernateUtil {

    private PropertiesConfiguration config = null;
    static Logger logger = Logger.getLogger(HibernateUtil.class.getName());
    private static ServletContext myContext;

    private ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public HibernateUtil(ServletContext context) throws ConfigurationException {
        ConfigUtil util = ConfigUtil.getFromContext(context);
        myContext = context;
        config = util.getDBConfig();
    }

    public void init() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutDownSessionFactory() throws Exception {

        if(sessionFactory instanceof SessionFactoryImpl) {
            SessionFactoryImpl sf = (SessionFactoryImpl)sessionFactory;
            ConnectionProvider conn = sf.getConnectionProvider();

            Connection connection = conn.getConnection();
            connection.close();

            if(conn instanceof DriverManagerConnectionProviderImpl){
                DriverManagerConnectionProviderImpl provider = (DriverManagerConnectionProviderImpl)conn;
                provider.stop();
            }
            sessionFactory.close();
        }
    }


}


