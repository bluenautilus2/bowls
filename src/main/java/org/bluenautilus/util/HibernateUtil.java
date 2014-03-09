package org.bluenautilus.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.util.logging.Logger;



/**
 * User: bluenautilus2
 * Date: 2/15/14
 * Time: 6:54 PM
 */
public class HibernateUtil {


    static Logger logger = Logger.getLogger(HibernateUtil.class.getName());

    private ServiceRegistry serviceRegistry;

    ///@todo this is bad.. can we get this from somewhere else?
    private static SessionFactory sessionFactory;

    public HibernateUtil() throws ConfigurationException {

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


