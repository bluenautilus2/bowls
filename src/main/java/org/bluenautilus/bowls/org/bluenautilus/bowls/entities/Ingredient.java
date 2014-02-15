package org.bluenautilus.bowls.org.bluenautilus.bowls.entities;

import java.util.List;

/**
 * User: bluenautilus2
 * Date: 2/9/14
 * Time: 5:39 PM
 */
public class Ingredient {

    private Integer id;
    private String name;
    private List<Quantity> usedQuantities;
    private String usedQuantitiesString;

    public Ingredient(Integer id, String name, String usedQuantitiesString) {
        this.id = id;
        this.name = name;
        this.usedQuantitiesString = usedQuantitiesString;
    }

    public Ingredient(Integer id, String name, List<Quantity> usedQuantities) {
        this.id = id;
        this.name = name;
        this.usedQuantities = usedQuantities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quantity> getUsedQuantities() {
        return usedQuantities;
    }

    public void setUsedQuantities(List<Quantity> usedQuantities) {
        this.usedQuantities = usedQuantities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsedQuantitiesString() {
        return usedQuantitiesString;
    }

    public void setUsedQuantitiesString(String usedQuantitiesString) {
        this.usedQuantitiesString = usedQuantitiesString;
    }
}
