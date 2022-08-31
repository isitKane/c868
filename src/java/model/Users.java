/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kane
 */
public class Users {

    private int userID;
    private String username;
    private String password;

    /**
     * Instantiates a new user
     *
     * @param userID the userID
     * @param username the username
     * @param password the password
     */
    public Users(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    /**
     * gets user id
     *
     * @return the user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * sets user id
     *
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * gets username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets username
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * gets password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets password
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
