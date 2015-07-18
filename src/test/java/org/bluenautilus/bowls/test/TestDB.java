package org.bluenautilus.bowls.test;
import org.bluenautilus.bowls.org.bluenautilus.bowls.db.NotQuantity;
import org.bluenautilus.bowls.org.bluenautilus.bowls.db.Quantity;
import org.bluenautilus.util.DBUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Not;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;


/**
 * User: bluenautilus2
 * Date: 2/17/14
 * Time: 6:59 PM
 */
public class TestDB {

    static Logger logger = Logger.getLogger(DBUtil.class.getName());

    @Before
    public void init(){
         JunitInitialization.init();
    }


    @Test
    public void test1() throws SQLException{

        Connection conn = DBUtil.getTheOneConnection();

            Statement statement = conn.createStatement();
            String query = "SELECT * FROM QUANTITIES";
          ResultSet res = statement.executeQuery(query);
           assertNotNull(res);

    }

    @Test
    public void testQuantity() throws SQLException{
        Quantity q = new Quantity("cup","cups");
        q.insertNew();

        NotQuantity nq = new NotQuantity("chopped");
        nq.insertNew();

    }

    @Test
    public void testQuery() throws SQLException{
        List<Quantity> list = Quantity.selectLikeSingular("cu");
        assertNotNull(list);
        assertFalse(list.isEmpty());
        Quantity q = list.get(0);
        System.out.println("%id: " + q.getId());


        List<Quantity> list2 = Quantity.selectLikePlural("cu");
        assertNotNull(list2);
        assertFalse(list2.isEmpty());
        Quantity q2 = list2.get(0);
        System.out.println("%id: " + q2.getId());

        List<NotQuantity> nqList = NotQuantity.selectLike("cho");
        assertNotNull(nqList);
        assertFalse(nqList.isEmpty());
        NotQuantity nq = nqList.get(0);
        System.out.println("%nq id:" + nq.getId());

    }

    @After
    public void shutDown(){
        JunitInitialization.shutdown();
    }

}
