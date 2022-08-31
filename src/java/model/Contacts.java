/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kane
 */
public class Contacts {

    private int contactID;
    private String contactName;
    private String contactEmail;

    /**
     * Instantiates a new contact.
     *
     * @param contactID the contact ID
     * @param contactName the contact Name
     * @param contactEmail the contact Email
     */
    public Contacts(int contactID, String contactName, String contactEmail) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    /**
     * gets contact id
     *
     * @return the contact id
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * set contact id
     *
     * @param contactID the contactID
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    /**
     * get contact name
     *
     * @return contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * set contact name
     *
     * @param contactName the contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * get contact email
     *
     * @return contact email
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * set contact email
     *
     * @param contactEmail the contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

}
