package org.bluenautilus.bowls.org.bluenautilus.bowls.db;

import org.bluenautilus.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: bluenautilus2
 * Date: 2/9/14
 * Time: 5:49 PM
 */
public class BowlIngredient {
    private Integer id;
    private Integer bowl_id;
    private Integer numerator;
    private Integer denominator;
    private Integer quantity_id;
    private String descriptor;

    public Integer getId() {
        return id;
    }

    public BowlIngredient(ResultSet resultSet) throws SQLException {
        this.bowl_id = resultSet.getInt("bowl_id");
        this.numerator = resultSet.getInt("numerator");
        this.denominator = resultSet.getInt("denominator");
        this.id = resultSet.getInt("id");
        this.descriptor = resultSet.getString("descriptor");
        this.quantity_id = resultSet.getInt("quantity_id");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBowl_id() {
        return bowl_id;
    }

    public void setBowl_id(Integer bowl_id) {
        this.bowl_id = bowl_id;
    }

    public Integer getQuantity_id() {
        return quantity_id;
    }

    public void setQuantity_id(Integer quantity_id) {
        this.quantity_id = quantity_id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    public void insertNew() throws SQLException {
        Connection conn = DBUtil.getTheOneConnection();
        Statement statement = conn.createStatement();
        String query = "INSERT INTO BOWL_INGREDIENTS (id,bowl_id,numerator,denominator,descriptor,quantity_id)"
                + " VALUES(\'" + this.id + "," + this.bowl_id + "," + this.numerator + "," + this.descriptor + "," + this.quantity_id + "\') ";
        statement.executeUpdate(query);
    }

    public BowlIngredient getById(Integer id) throws SQLException {
        Connection conn = DBUtil.getTheOneConnection();
        Statement statement = conn.createStatement();
        String query = "Select * from BOWL_INGREDIENTS where id=\'+id+" +
                "\'";
        ResultSet res = statement.executeQuery(query);
        return new BowlIngredient(res);

    }
}
