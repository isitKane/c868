/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import DAO.DBAppointments;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kane
 */
public class ReportsScreenController implements Initializable {

    @FXML
    private RadioButton Report1RB;

    @FXML
    private RadioButton Report2RB;

    @FXML
    private RadioButton Report3RB;

    @FXML
    private ToggleGroup viewReportTG;

    @FXML
    private Button GenerateButton;

    @FXML
    private Button ResetButton;

    @FXML
    private Button CancelButton;

    @FXML
    private TextArea ReportTextArea;
    
    /**
     * on action generate report 
     * @param event the event
     */
    @FXML
    void OnActionGenerateReport(ActionEvent event) {
        if (Report1RB.isSelected()) {
            ReportTextArea.setText(DBAppointments.reportAppointmentTypeMonth());
        }
        if (Report2RB.isSelected()) {
            ReportTextArea.setText(DBAppointments.reportAppointmentContact());
        }
        if (Report3RB.isSelected()) {
            ReportTextArea.setText(DBAppointments.reportAppointmentTypeLocation());
        }
    }


    @FXML
    void onActionViewReport1(ActionEvent event) {

    }

    @FXML
    void onActionViewReport2(ActionEvent event) {

    }

    @FXML
    void onActionViewReport3(ActionEvent event) {

    }

    /**
     * on action reset text field
     * @param event the event
     */
    @FXML
    void OnActionResetTextField(ActionEvent event) {
        ReportTextArea.clear();
    }

    /**
     * on action back to main screen
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.setTitle("Main");
        stage.show();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
