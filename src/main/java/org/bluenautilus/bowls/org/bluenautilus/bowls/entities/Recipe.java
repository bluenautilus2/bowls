package org.bluenautilus.bowls.org.bluenautilus.bowls.entities;

import java.util.List;

/**
 * User: bluenautilus2
 * Date: 2/9/14
 * Time: 5:53 PM
 */
public class Recipe {
    private Integer id;
    private String name;
    private List<Bowl> bowls;
    private String instructions; //this is a text sql object
    private String notes; //this is a text sql object


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bowl> getBowls() {
        return bowls;
    }

    public void setBowls(List<Bowl> bowls) {
        this.bowls = bowls;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
