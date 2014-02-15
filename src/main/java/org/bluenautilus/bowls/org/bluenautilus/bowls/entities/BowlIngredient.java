package org.bluenautilus.bowls.org.bluenautilus.bowls.entities;

/**
 * User: bluenautilus2
 * Date: 2/9/14
 * Time: 5:49 PM
 */
public class BowlIngredient {
      private Integer id;
    private Integer bowl_id;
    private Ingredient ingredient;
    private Integer quantity;
    private Quantity quantityType;
    private String originalString;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Quantity getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(Quantity quantityType) {
        this.quantityType = quantityType;
    }

    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public Integer getId() {
        return id;
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
}
