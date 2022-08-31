/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kane
 */
public class Countries {

    private int countryID;
    private String country;

    /**
     * Instantiates a new country
     *
     * @param countryID the countryID
     * @param country the country
     */
    public Countries(int countryID, String country) {
        this.countryID = countryID;
        this.country = country;
    }

    /**
     * get country id
     *
     * @return country id
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * set country id
     *
     * @param countryID the countryID
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    /**
     * get country
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * set country
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * overrides and changes the name of the division combo box
     *
     * @return
     */
    @Override
    public String toString() {
        return (country);
    }

}
