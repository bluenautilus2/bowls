package org.bluenautilus.bowls.org.bluenautilus.bowls.db;

import org.bluenautilus.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: bluenautilus2
 * Date: 5/12/13
 * Time: 8:23 PM
 */
public class NotQuantity {

    private Integer id;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void insertNew() throws SQLException {
        Connection conn = DBUtil.getTheOneConnection();
        Statement statement = conn.createStatement();
        String query = "INSERT INTO NOT_QUANTITIES (name) VALUES(\'" + this.name +"\') ";
        statement.executeUpdate(query);
    }

    public static List<NotQuantity> selectLike(String columnToMatch, String phrase) throws SQLException {
        Connection conn = DBUtil.getTheOneConnection();
        Statement statement = conn.createStatement();
        String query = "Select * from NOT_QUANTITIES where "+columnToMatch+ " like \'" + phrase+"%\'";
        ResultSet res =statement.executeQuery(query);
        List<NotQuantity> quantities = new ArrayList<NotQuantity>();
        while(res.next()){
            quantities.add(new NotQuantity(res));
        }
        return quantities;
    }

    public static List<NotQuantity> selectLike(String phrase) throws SQLException {
        return selectLike("name",phrase);
    }



    public NotQuantity(ResultSet resultSet) throws SQLException {
        this.name = resultSet.getString("name");
        this.id = resultSet.getInt("id");
    }

    public NotQuantity(String name) {
        this.name = name;
    }
}
