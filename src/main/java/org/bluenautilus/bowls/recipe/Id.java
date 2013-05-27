package org.bluenautilus.bowls.recipe;

/**
 * User: bluenautilus2
 * Date: 5/12/13
 * Time: 8:35 PM
 */
public class Id {

    private int idNumber = 0;
    private String idString = "";


    public Id(String str) {
        this.idString = str;
    }

    public Id(int theInt) {
        this.idNumber = theInt;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }


}
