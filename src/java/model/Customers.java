/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kane
 */
public class Customers {

    private int customerID;
    private String customerName;
    private String address;
    private String division;
    private String postalCode;
    private String country;
    private String phoneNumber;
    private String email;
    private int divisionID;

    /**
     * Instantiates a new customer
     *
     * @param customerID the customerID
     * @param customerName the customerName
     * @param address the address
     * @param division the division
     * @param postalCode the postalCode
     * @param country the country
     * @param phoneNumber the phoneNumber
     * @param divisionID the divisionID
     */
    public Customers(int customerID, String customerName, String address, String division, String postalCode, String country, String phoneNumber, String email, int divisionID) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.division = division;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.divisionID = divisionID;
    }

    /**
     * Gets customer id
     *
     * @return customer id
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * sets customer id
     *
     * @param customerID the customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Gets customer name
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * set customer name
     *
     * @param customerName the customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * get address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * set address
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get division
     *
     * @return division
     */
    public String getDivision() {
        return division;
    }

    /**
     * sets division
     *
     * @param division the division
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * gets postal code
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * sets postal code
     *
     * @param postalCode the postalCodes
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
     *set country
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * get phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * set phone number
     * @param phoneNumber  the phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get email
     * @return email  email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set email
     * @param email  the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get division id
     * @return division id
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * set division id
     * @param divisionID  the divisionID
     */
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

}
