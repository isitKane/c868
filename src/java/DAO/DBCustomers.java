/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;
import java.sql.*;

/**
 *
 * @author LabUser
 */
public class DBCustomers {

    /**
     * gets all customers
     *
     * @return all customers
     * @throws SQLException the sql exception
     */
    public static ObservableList<Customers> getAllCustomers() throws SQLException {

        ObservableList<Customers> customerList = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM customers AS c INNER JOIN first_level_divisions AS fld ON c.Division_ID = fld.Division_ID INNER JOIN countries AS co ON co.Country_ID = fld.Country_ID";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int customerID = rs.getInt("Customer_ID");
                String customerName = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String division = rs.getString("Division");
                String postalCode = rs.getString("Postal_Code");
                String country = rs.getString("Country");
                String phoneNumber = rs.getString("Phone");
                String email = rs.getString("email");
                int divisionID = rs.getInt("Division_ID");

                Customers cust = new Customers(customerID, customerName, address, division, postalCode, country, phoneNumber, email, divisionID);
                customerList.add(cust);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    /**
     * adds customer for the add customer form
     *
     * @param customerName the customerName
     * @param address the address
     * @param postalCode the postalCode
     * @param phone the phone
     * @param email the email
     * @param divisionID the divisionID
     */
    public static void addCustomer(String customerName, String address, String postalCode, String phone, String email, Integer divisionID) {

        try {
            String sql = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Email, Division_ID) VALUES (? , ?, ?, ?, ?, ?)";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setString(2, address);
            ps.setString(3, postalCode);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setInt(6, divisionID);

            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * updates customers for the modify customer form
     *
     * @param customerName the customerName
     * @param address the address
     * @param postalCode the postalCode
     * @param phone the phone
     * @param email the email
     * @param divisionID the divisionID
     * @param customerID the customerID
     */
    public static void updateCustomer(String customerName, String address, String postalCode, String phone, String email, Integer divisionID, Integer customerID) {

        try {
            String sql = "UPDATE customers SET Customer_name = ? , Address = ?, Postal_Code = ?, Phone = ?, Email = ?, Division_ID = ? WHERE Customer_ID = ?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setString(2, address);
            ps.setString(3, postalCode);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setInt(6, divisionID);
            ps.setInt(7, customerID);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * deletes customers
     *
     * @param customerID
     * @return
     * @throws SQLException
     */
    public static boolean deleteCustomer(int customerID) throws SQLException {
        try {
            String sql = "DELETE from customers WHERE Customer_ID=?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ps.setInt(1, customerID);

            ps.executeUpdate();
            if (ps.getUpdateCount() > 0) {
                System.out.println(ps.getUpdateCount() + " rows affected.");
            } else {
                System.out.println("No change occurred.");
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
