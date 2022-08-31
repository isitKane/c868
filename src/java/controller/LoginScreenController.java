/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import DAO.DBAppointments;
import DAO.DBUsers;
import static controller.Alerts.alert15minsEN;
import static controller.Alerts.alert15minsFR;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static controller.Alerts.loginScreenErrorsEN;
import static controller.Alerts.loginScreenErrorsFR;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Appointments;

/**
 * FXML Controller class
 *
 * @author Kane
 */
public class LoginScreenController implements Initializable {

    @FXML
    private Label TitleLabel;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Label TimeZoneLabel;

    @FXML
    private TextField UsernameFieldTxt;

    @FXML
    private PasswordField PasswordFieldTxt;

    @FXML
    private TextField TimeZoneTxt;

    @FXML
    private Button LoginButton;

    @FXML
    private Button ClearButton;

    @FXML
    private Button ExitButton;

    /**
     * *
     * on action login form
     *
     * @param event the event
     * @throws SQLException the sql exception
     * @throws IOException  the io exception
     */
    @FXML
    void onActionLogin(ActionEvent event) throws SQLException, IOException {
        if (UsernameFieldTxt.getText().isEmpty()) {
            if (Locale.getDefault().toString().equals("en_US")) {
                loginScreenErrorsEN(1);
            }
            if (Locale.getDefault().toString().equals("fr_FR")) {
                loginScreenErrorsFR(1);
            }
        }
        if (PasswordFieldTxt.getText().isEmpty()) {
            if (Locale.getDefault().toString().equals("en_US")) {
                loginScreenErrorsEN(2);
            }
            if (Locale.getDefault().toString().equals("fr_FR")) {
                loginScreenErrorsFR(2);
            }
        }
        String user = UsernameFieldTxt.getText();
        String password = PasswordFieldTxt.getText();

        boolean loginSuccess = DBUsers.getUserLogin(user, password);

        if (loginSuccess) {
            appointmentIn15mins();
            loginFileSucess(user);
            try {

                Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                Parent scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
                stage.setScene(new Scene(scene));
                stage.setTitle("Main");
                stage.show();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        } else {
            loginFileFail(user);
            if (Locale.getDefault().toString().equals("en_US")) {
                loginScreenErrorsEN(3);
            }
            if (Locale.getDefault().toString().equals("fr_FR")) {
                loginScreenErrorsFR(3);
            }
        }

    }

    /**
     * on action clear text fields
     *
     * @param event the event
     */
    @FXML
    void onActionClear(ActionEvent event) {
        UsernameFieldTxt.clear();
        PasswordFieldTxt.clear();
    }

    /**
     * *
     * on action exit application
     *
     * @param event the event
     */
    @FXML
    void onActionExit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * this is to check for whether you have an appointment in 15 minutes. It
     * will display an alert for both situations.
     *
     * @throws SQLException the sql exception
     */
    public void appointmentIn15mins() throws SQLException {
        ObservableList<Appointments> appointments = DBAppointments.getAllAppointments();
        ObservableList<Appointments> upcomingAppointments = FXCollections.observableArrayList();

        if (appointments != null) {
            for (Appointments apptIn15 : appointments) {
                LocalDateTime ldtNow = LocalDateTime.now();
                LocalDateTime ldtIn15 = ldtNow.plusMinutes(15);

                if (apptIn15.getStart().isAfter(ldtNow) && apptIn15.getStart().isBefore(ldtIn15)) {
                    upcomingAppointments.add(apptIn15);
                    if (Locale.getDefault().toString().equals("en_US")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("WARNING");
                        alert.setHeaderText("Upcoming Appointment");
                        alert.setContentText("Upcoming appointment in 15 minutes. Appointment ID: " + apptIn15.getAppointmentID() + ". Date and Time: " + apptIn15.getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + ".");
                        alert.showAndWait();
                        return;
                    }
                    if (Locale.getDefault().toString().equals("fr_FR")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("AVERTISSEMENT");
                        alert.setHeaderText("Rendez-vous à venir");
                        alert.setContentText("Prochain rendez-vous dans 15 minutes. ID de rendez-vous: " + apptIn15.getAppointmentID() + ". Date et l'heure: " + apptIn15.getStart() + ".");
                        alert.showAndWait();
                        return;
                    }
                }

            }
            if (upcomingAppointments.size() < 1) {
                if (Locale.getDefault().toString().equals("en_US")) {
                    alert15minsEN(2);
                }
                if (Locale.getDefault().toString().equals("fr_FR")) {
                    alert15minsFR(2);
                }
            }
        }
    }

    /**
     * This is for login_activity text file. This is for logging in
     * successfully.
     *
     * @param user the user
     * @throws IOException the io exception
     */
    public static void loginFileSucess(String user) throws IOException {
        FileWriter fw = new FileWriter("login_activity.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String loginTime = dtf.format(now);

        pw.println(user + " sucessfully logged in at " + loginTime);
        pw.close();
    }

    /**
     * This is for login_activity text file. This is for logging in
     * unsuccessfully.
     *
     * @param user the user
     * @throws IOException the io exception
     */
    public static void loginFileFail(String user) throws IOException {
        FileWriter fw = new FileWriter("login_activity.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String loginTime = dtf.format(now);

        pw.println(user + " unsucessfully logged in at " + loginTime);
        pw.close();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ResourceBundle resourceb = ResourceBundle.getBundle("main/Lang", Locale.getDefault());

        if (Locale.getDefault().getLanguage().equals("fr") || Locale.getDefault().getLanguage().equals("en")) {
            ZoneId z = ZoneId.systemDefault();
            TitleLabel.setText(resourceb.getString("TitleLabel"));
            UsernameLabel.setText(resourceb.getString("UsernameLabel"));
            PasswordLabel.setText(resourceb.getString("PasswordLabel"));
            TimeZoneLabel.setText(resourceb.getString("TimeZoneLabel"));
            TimeZoneTxt.setText(z.toString());
            LoginButton.setText(resourceb.getString("LoginButton"));
            ClearButton.setText(resourceb.getString("ClearButton"));
            ExitButton.setText(resourceb.getString("ExitButton"));
        }
    }

}
