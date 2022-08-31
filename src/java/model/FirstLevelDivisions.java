/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kane
 */
public class FirstLevelDivisions {

    private int divisionID;
    private String division;
    private int countryID;

    /**
     * Instantiates a new first level division
     *
     * @param divisionID the divisionID
     * @param division the division
     * @param countryID the countryID
     */
    public FirstLevelDivisions(int divisionID, String division, int countryID) {
        this.divisionID = divisionID;
        this.division = division;
        this.countryID = countryID;
    }

    /**
     * get division id
     *
     * @return division id
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * set the division id
     *
     * @param divisionID the divisionID
     */
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    /**
     * get the division name
     *
     * @return the division name
     */
    public String getDivision() {
        return division;
    }

    /**
     * set the division name
     *
     * @param division the division
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * get the country id
     *
     * @return the country id
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * set the country id
     *
     * @param countryID the countryID
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    /**
     * override and changes the name of the division in the combo box.
     *
     * @return
     */
    @Override
    public String toString() {
        return (division);
    }

}
