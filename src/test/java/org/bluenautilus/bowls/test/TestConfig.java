package org.bluenautilus.bowls.test;


import org.apache.commons.configuration.PropertiesConfiguration;
import org.bluenautilus.util.ConfigUtil;
import org.junit.Test;
import org.junit.Assert;

/**
 * User: bluenautilus2
 * Date: 5/6/13
 * Time: 10:11 AM
 */
public class TestConfig {

    @Test
    public void test1() throws Exception{
        ConfigUtil util = new ConfigUtil();
        PropertiesConfiguration dbconfig = util.getDBConfig();
        String s = dbconfig.getString(ConfigUtil.DB_NAME);
        Assert.assertNotNull(s);

    }

}
