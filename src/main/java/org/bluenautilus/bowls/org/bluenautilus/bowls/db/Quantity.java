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
public class Quantity {

    private Integer id;
    private String name;
    private String pluralName;

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

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public void insertNew() throws SQLException {
        Connection conn = DBUtil.getTheOneConnection();
        Statement statement = conn.createStatement();
        String query = "INSERT INTO QUANTITIES (name,plural_name) VALUES(\"" + this.name + "\",\"" + this.pluralName + "\") ";
        statement.executeUpdate(query);
    }

    public static List<Quantity> selectLike(String columnToMatch, String phrase) throws SQLException {
        Connection conn = DBUtil.getTheOneConnection();
        Statement statement = conn.createStatement();
        String query = "Select * from QUANTITIES where "+columnToMatch+ " like \'" + phrase+"%\'";
        ResultSet res =statement.executeQuery(query);
        List<Quantity> quantities = new ArrayList<Quantity>();
        while(res.next()){
            quantities.add(new Quantity(res));
        }
        return quantities;
    }

    public static List<Quantity> selectLikeSingular(String phrase) throws SQLException {
        return selectLike("name",phrase);
    }

    public static List<Quantity> selectLikePlural(String phrase) throws SQLException {
        return selectLike("plural_name",phrase);
    }


    public Quantity(ResultSet resultSet) throws SQLException {
        this.name = resultSet.getString("name");
        this.pluralName = resultSet.getString("plural_name");
        this.id = resultSet.getInt("id");
    }

    public Quantity(String name, String pluralName) {
        this.name = name;
        this.pluralName = pluralName;
    }
}
