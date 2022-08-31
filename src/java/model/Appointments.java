/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Kane
 */
public class Appointments {

    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private int contactID;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private int customerID;
    private int userID;

    /**
     * Instantiates a new appointment
     *
     * @param appointmentID the appointmentID
     * @param title the title
     * @param description the description
     * @param location the location
     * @param contactID the contactID
     * @param type the type
     * @param start the start
     * @param end the end
     * @param customerID the customerID
     * @param userID the userID
     */
    public Appointments(int appointmentID, String title, String description, String location, int contactID, String type, LocalDateTime start, LocalDateTime end, int customerID, int userID) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contactID = contactID;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerID = customerID;
        this.userID = userID;
    }

    /**
     * get appointment id
     *
     * @return the appointment id
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     * sets the appointment id
     *
     * @param appointmentID the appointmentID
     */
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    /**
     * gets the title
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * gets the description
     *
     * @return 
     * @returns the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gets the location
     *
     * @return 
     * @returns the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * sets the location
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * gets the contact id
     *
     * @return 
     * @returns the contact id
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * sets the contact id
     *
     * @param contactID
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    /**
     * get type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * set type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * gets start time and date
     *
     * @return start time and date
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * sets start time and date
     *
     * @param start the start
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * gets end time and date
     *
     * @return end time and date
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * sets end time and date
     *
     * @param end the end
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * get customer id
     *
     * @return customer id
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * set customer id
     *
     * @param customerID the customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * get user id
     *
     * @return user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * set user id
     *
     * @param userID the userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }



}
