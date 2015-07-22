package org.bluenautilus.bowls.org.bluenautilus.bowls.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: bluenautilus2
 * Date: 2/9/14
 * Time: 5:41 PM
 */
public class Bowl {

    private Integer id;

    private String name;

    private String recipe_id;

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

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public Bowl(ResultSet resultSet) throws SQLException {
        this.name = resultSet.getString("name");
        this.recipe_id = resultSet.getString("recipe_id");
        this.id = resultSet.getInt("id");
    }

}
