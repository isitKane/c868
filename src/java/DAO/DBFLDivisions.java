/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

import model.FirstLevelDivisions;


/**
 *
 * @author LabUser
 */
public class DBFLDivisions {
    /**
     * gets all divisions 
     * @return all divisions 
     */
    public static ObservableList<FirstLevelDivisions> getAllDivisions() {

        ObservableList<FirstLevelDivisions> flDivisionList = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * from first_level_divisions";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisionID = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryID = rs.getInt("Country_ID");
                FirstLevelDivisions flDivisions = new FirstLevelDivisions(divisionID, division, countryID);
                flDivisionList.add(flDivisions);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flDivisionList;
    }
    
    /**
     * gets divisions by country id
     * @param countryID the country id
     * @return divisions by country id
     * @throws SQLException the SQL Exception
     */
    public static ObservableList<FirstLevelDivisions> getDivisionsByCountryID(int countryID) throws SQLException {

        ObservableList<FirstLevelDivisions> flDivisionList = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * from first_level_divisions WHERE Country_ID  = ?";

            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, countryID);
  
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisionID = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                rs.getInt("Country_ID");
                FirstLevelDivisions flDivisions = new FirstLevelDivisions(divisionID, division, countryID);
                flDivisionList.add(flDivisions);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flDivisionList;
    }
 
}
