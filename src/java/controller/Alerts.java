/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DBAppointments;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Appointments;

/**
 *
 * @author Kane
 */
public class Alerts {

    /**
     * login screen errors alert for english
     *
     * @param alertID the alert id
     */
    public static void loginScreenErrorsEN(int alertID) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        switch (alertID) {
            case 1 -> {
                alert.setHeaderText("Error: Username Field Is Blank");
                alert.setContentText("Please enter a username");
                alert.showAndWait();
                return;
            }
            case 2 -> {
                alert.setHeaderText("Error: Password Field Is Blank");
                alert.setContentText("Please enter a password");
                alert.showAndWait();
                return;
            }
            case 3 -> {
                alert.setHeaderText("Error: Incorrect Username And/Or Password");
                alert.setContentText("Please try again.");
                alert.showAndWait();
                return;
            }
        }
    }

    /**
     * login screen errors for french
     *
     * @param alertID the alert id
     */
    public static void loginScreenErrorsFR(int alertID) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERREUR");
        switch (alertID) {
            case 1 -> {
                alert.setHeaderText("Erreur : le champ du nom d'utilisateur est vide");
                alert.setContentText("Merci d'entrer un nom d'utilisateur");
                alert.showAndWait();
                return;
            }
            case 2 -> {
                alert.setHeaderText("Erreur : le champ du mot de passe est vide");
                alert.setContentText("Merci d'entrer un mot de passe");
                alert.showAndWait();
                return;
            }
            case 3 -> {
                alert.setHeaderText("Erreur : Nom d'utilisateur et/ou mot de passe incorrects");
                alert.setContentText("Veuillez essayer à nouveau.");
                alert.showAndWait();
                return;
            }
        }
    }

    /**
     * error check alerts for english
     *
     * @param alertID the alert id
     */
    public static void errorChecksEN(int alertID) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        switch (alertID) {
            case 1 -> {
                alert.setHeaderText("Warning: Time Chosen Is Outside Of Business Hours.");
                alert.setContentText("Please choose a time within the business hours of 8:00 AM to 10:00 AM EST.");
                alert.showAndWait();
                return;
            }
            case 2 -> {
                alert.setHeaderText("Warning: Appointment Time Chosen Cannot Overlap");
                alert.setContentText("Please choose a different time");
                alert.showAndWait();
                return;
            }

        }

    }

    /**
     * error check alerts for french
     *
     * @param alertID the alert id
     */
    public static void errorChecksFR(int alertID) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("AVERTISSEMENT");
        switch (alertID) {
            case 1 -> {
                alert.setHeaderText("Avertissement : L'heure choisie est en dehors des heures d'ouverture.");
                alert.setContentText("Veuillez choisir une heure dans les heures ouvrables de 8 h 00 à 22 h 00 HNE.");
                alert.showAndWait();
            }
            case 2 -> {
                alert.setHeaderText("Avertissement : L'heure de rendez-vous choisie ne peut pas se chevaucher");
                alert.setContentText("Veuillez choisir une autre heure.");
                alert.showAndWait();
            }

        }

    }

    /**
     * alerts for within 15 minutes of an appointment for english
     *
     * @param alertID the alert id
     * @throws SQLException the sql exception
     */
    public static void alert15minsEN(int alertID) throws SQLException {
        ObservableList<Appointments> appointments = DBAppointments.getAllAppointments();
        for (Appointments appointment : appointments) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            switch (alertID) {
                case 1 -> {
                    alert.setHeaderText("Upcoming Appointment");
                    alert.setContentText("Upcoming appointment in 15 minutes. Appointment ID: " + appointment.getAppointmentID() + ". Date and Time: " + appointment.getStart() + ".");
                    alert.showAndWait();
                    return;
                }
                case 2 -> {
                    alert.setHeaderText("No Upcoming Appointment");
                    alert.setContentText("No upcoming appointments at this time.");
                    alert.showAndWait();
                    return;
                }
            }
        }
    }

    /**
     * alerts for within 15 minutes of an appointment for french
     *
     * @param alertID the alert id
     * @throws SQLException  the sql exception
     */
    public static void alert15minsFR(int alertID) throws SQLException {
        ObservableList<Appointments> appointments = DBAppointments.getAllAppointments();
        for (Appointments appointment : appointments) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("AVERTISSEMENT");
            switch (alertID) {
                case 1 -> {
                    alert.setHeaderText("Rendez-vous à venir");
                    alert.setContentText("Prochain rendez-vous dans 15 minutes. ID de rendez-vous: " + appointment.getAppointmentID() + ". Date et l'heure: " + appointment.getStart() + ".");
                    alert.showAndWait();
                    return;
                }
                case 2 -> {
                    alert.setHeaderText("Aucun rendez-vous à venir");
                    alert.setContentText("Aucun rendez-vous à venir pour le moment.");
                    alert.showAndWait();
                    return;
                }
            }

        }
    }

    /**
     * customer deletion alert for english
     * @param alertID the alert id
     */
    public static void customerDeletionEN(int alertID) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        switch (alertID) {
            case 1 -> {
                alert.setHeaderText("Warning: No Customer Selected");
                alert.setContentText("Please choose choose a customer then try again.");
                alert.showAndWait();
                return;
            }
            case 2 -> {
                alert.setHeaderText("Warning: Customer Has Existing Appointment.");
                alert.setContentText("Procceding with deletion will also delete the existing appointment.");
                alert.showAndWait();
                return;
            }

        }
    }

    /**
     * appointment alert for english
     * @param alertID the alert id
     * @return 
     */
    public static boolean appointmentAlertsEN(int alertID) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        switch (alertID) {
            case 1 -> {
                alert.setHeaderText("Warning: No Appointment Selected");
                alert.setContentText("Please choose an appointment then try again.");
                alert.showAndWait();

            }
            case 2 -> {
                alert.setHeaderText("Warning: Overlapping Appointment");
                alert.setContentText("Chosen appointment is overlapping with another appointment. Please select again.");
                alert.showAndWait();

            }
            case 3 -> {
                alert.setHeaderText("Warning: Outside Business Hours");
                alert.setContentText("Please select a time within business hours.");
                alert.showAndWait();

            }
            case 4 -> {
                alert.setHeaderText("Warning: Blank Fields");
                alert.setContentText("One or more fields have been left blank. Please fill them and try again.");
                alert.showAndWait();
            }
            case 5 -> {
                alert.setHeaderText("Warning: Invalid Appointment Time Or Date");
                alert.setContentText("Appointment start time cannot be before the end time. Appointments must be start and end on the same day.");
                alert.showAndWait();
            }

        }
        return false;
    }
}
