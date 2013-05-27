package org.bluenautilus.bowls.test;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.bluenautilus.bowls.util.ConfigUtil;
import org.junit.Test;

import java.sql.*;

public class TestDatabase {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB

            connect = DriverManager
                    .getConnection(this.getConnectString());
            System.out.println(this.getConnectString());

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from BOWLS");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("INSERT INTO  BOWLS (ingred_id,quantity,quant_id,original_string) VALUES(?,?,?,?)");

            // Parameters start with 1

            preparedStatement.setString(1, "iid");
            preparedStatement.setString(2, "quan");
            preparedStatement.setString(3, "qid");
            preparedStatement.setString(4, "the original string");

            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT * from BOWLS");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            preparedStatement = connect
                    .prepareStatement("delete from BOWLS where ingred_id=? ; ");
            preparedStatement.setString(1, "iid");
            preparedStatement.executeUpdate();

            resultSet = statement
                    .executeQuery("select * from BOWLS");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //   Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("ingred_id"));
            System.out.println(resultSet.getString("quantity"));
            System.out.println(resultSet.getString("quant_id"));
            System.out.println(resultSet.getString("original_string"));

        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    @Test
    public void test1() throws Exception {
        TestDatabase dao = new TestDatabase();
        dao.readDataBase();
    }

    private String getConnectString() throws Exception {
        ConfigUtil config = new ConfigUtil();
        PropertiesConfiguration propConf = config.getDBConfig();

        StringBuffer buff = new StringBuffer();
        buff.append("jdbc:mysql://localhost/");
        buff.append(propConf.getString(ConfigUtil.DB_NAME) + "?");
        buff.append("user=" + propConf.getString(ConfigUtil.DB_USER));
        buff.append("&password=" + propConf.getString(ConfigUtil.DB_PASS));
        return buff.toString();

    }

}
