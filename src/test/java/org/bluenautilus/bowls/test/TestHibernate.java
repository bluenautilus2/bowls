package org.bluenautilus.bowls.test;
import org.bluenautilus.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;


/**
 * User: bluenautilus2
 * Date: 2/17/14
 * Time: 6:59 PM
 */
public class TestHibernate {

    static Logger logger = Logger.getLogger(HibernateUtil.class.getName());

    @Before
    public void init(){
         JunitInitialization.init();
    }


    @Test
    public void test1(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        if(session.isConnected()){
            logger.info("session is connected");

        }   else{
            logger.info("awwww");
        }


    }

    @After
    public void shutdown(){
        JunitInitialization.shutdown();
    }

}
