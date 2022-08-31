/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

/**
 *
 * @author LabUser
 */
public class DBUsers {

    /**
     * gets all users
     * @return all users
     * @throws SQLException the SQL Exception
     */
    public static ObservableList<Users> getAllUsers() throws SQLException {

        ObservableList<Users> userList = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * from users;";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("User_ID");
                String username = rs.getString("User_Name");
                String password = rs.getString("Password");

                Users users = new Users(userID, username, password);
                userList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    /**
     * gets user login information
     * @param username the username
     * @param password the password
     * @return user login information
     * @throws SQLException the SQL Exception
     */
    public static boolean getUserLogin(String username, String password) throws SQLException {
        try {
            String sql = "SELECT User_Name, Password from users WHERE User_Name = ? and Password = ?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
