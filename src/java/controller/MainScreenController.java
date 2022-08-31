/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import DAO.DBAppointments;

import static DAO.DBAppointments.deleteAppointments;

import DAO.DBCustomers;

import static DAO.DBCustomers.deleteCustomer;
import static controller.Alerts.appointmentAlertsEN;
import static controller.Alerts.customerDeletionEN;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;
import model.Customers;

/**
 * FXML Controller class
 *
 * @author Kane
 */
public class MainScreenController implements Initializable {

    @FXML
    private Label TimeZoneLabel;

    @FXML
    private Button AddApptButton;

    @FXML
    private Button ModifyApptButton;

    @FXML
    private Button DeleteApptButton;

    @FXML
    private RadioButton ViewAllRB;

    @FXML
    private RadioButton ViewWeeklyRB;

    @FXML
    private RadioButton ViewMonthlyRB;

    @FXML
    private ToggleGroup viewAppointmentTG;

    @FXML
    private DatePicker ViewDate;

    @FXML
    private TextField AppointmentSearchBar;

    @FXML
    private TextField CustomerSearchBar;

    @FXML
    private TableView<Appointments> AppointmentTableView;

    @FXML
    private TableColumn<Appointments, Integer> ApptIDColumn;

    @FXML
    private TableColumn<Appointments, String> TitleColumn;

    @FXML
    private TableColumn<Appointments, String> DescColumn;

    @FXML
    private TableColumn<Appointments, String> LocationColumn;

    @FXML
    private TableColumn<Appointments, Integer> ContactColumn;

    @FXML
    private TableColumn<Appointments, String> TypeColumn;

    @FXML
    private TableColumn<Appointments, LocalDateTime> StartColumn;

    @FXML
    private TableColumn<Appointments, LocalDateTime> EndColumn;

    @FXML
    private TableColumn<Appointments, Integer> CustomerID1Column;

    @FXML
    private TableColumn<Appointments, Integer> UserIDColumn;

    @FXML
    private Button ReportsButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button AddCustomerButton;

    @FXML
    private Button ModifyCustomerButton;

    @FXML
    private Button DeleteCustomerButton;

    @FXML
    private TableView<Customers> CustomerTableView;

    @FXML
    private TableColumn<Customers, Integer> CustomerID2Column;

    @FXML
    private TableColumn<Customers, String> NameColumn;

    @FXML
    private TableColumn<Customers, String> Address1Column;

    @FXML
    private TableColumn<Customers, String> FLDivisionColumn;

    @FXML
    private TableColumn<Customers, String> PostalCodeColumn;

    @FXML
    private TableColumn<Customers, String> CountryColumn;

    @FXML
    private TableColumn<Customers, String> PhoneNumberColumn;

    @FXML
    private TableColumn<Customers, String> EmailColumn;


    /**
     * On action search appointment.
     *
     * @param event the event
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionSearchAppointment(ActionEvent event) throws SQLException {
        ObservableList<Appointments> appointmentsSearchReturn = DBAppointments.getAllAppointments();


        FilteredList<Appointments> filteredList = new FilteredList<>(appointmentsSearchReturn, b -> true);

        AppointmentSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(Appointments -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String search = newValue.toLowerCase();


                if (Appointments.getTitle().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Appointments.getDescription().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Appointments.getLocation().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Appointments.getType().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Appointments.getStart().toString().indexOf(search) != -1) {
                    return true;
                } else if (Appointments.getEnd().toString().indexOf(search) != -1) {
                    return true;
                } else return false;
            });
        });

        SortedList<Appointments> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(AppointmentTableView.comparatorProperty());
        AppointmentTableView.setItems(sortedList);

    }

    /**
     * On action search customer.
     *
     * @param event the event
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionSearchCustomer(ActionEvent event) throws SQLException {
        ObservableList<Customers> customerSearchReturn = DBCustomers.getAllCustomers();


        FilteredList<Customers> filteredList = new FilteredList<>(customerSearchReturn, b -> true);

        CustomerSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(Customers -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String search = newValue.toLowerCase();


                if (Customers.getCustomerName().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Customers.getAddress().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Customers.getDivision().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Customers.getPostalCode().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Customers.getCountry().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Customers.getPhoneNumber().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else if (Customers.getEmail().toLowerCase().indexOf(search) != -1) {
                    return true;
                } else return false;
            });
        });

        SortedList<Customers> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(CustomerTableView.comparatorProperty());
        CustomerTableView.setItems(sortedList);
    }


    /**
     * on action view all radio button
     *
     * @param event the event
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionViewAll(ActionEvent event) throws SQLException {
        if (ViewAllRB.isSelected()) {
            try {
                ObservableList<Appointments> appointments = DBAppointments.getAllAppointments();
                AppointmentTableView.setItems(appointments);
                AppointmentTableView.refresh();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * on action view weekly radio button
     *
     * @param event the event
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionViewWeekly(ActionEvent event) throws SQLException {
        if (ViewWeeklyRB.isSelected()) {
            try {
                ObservableList<Appointments> appointments = DBAppointments.getAppointmentsByWeek();
                AppointmentTableView.setItems(appointments);
                AppointmentTableView.refresh();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * on action view monthly radio button
     *
     * @param event the event
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionViewMonthly(ActionEvent event) throws SQLException {
        if (ViewMonthlyRB.isSelected()) {
            try {
                ObservableList<Appointments> appointments = DBAppointments.getAppointmentsByMonth();

                AppointmentTableView.setItems(appointments);
                AppointmentTableView.refresh();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @FXML
    void onActionViewDate(ActionEvent event) {

    }

    /**
     * on action add appointment form
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void onActionAddAppointment(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(getClass().getResource("/view/AddAppointmentForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.setTitle("Add Appointment");
        stage.show();
    }

    /**
     * on action modify appointment form
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void onActionModifyAppointment(ActionEvent event) throws IOException {
        Appointments selectedAppointments = AppointmentTableView.getSelectionModel().getSelectedItem();

        if (selectedAppointments == null) {
            appointmentAlertsEN(1);
            return;
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/ModifyAppointmentForm.fxml"));
            loader.load();
            ModifyAppointmentFormController controller = loader.getController();
            controller.getAppointment(selectedAppointments);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.setTitle("Modify Appointment");
            stage.show();
        }
    }

    /**
     * on action delete appointment form
     *
     * @param event the event
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionDeleteAppointment(ActionEvent event) throws SQLException {
        Appointments selectedAppointments = AppointmentTableView.getSelectionModel().getSelectedItem();
        ObservableList<Appointments> appointments = DBAppointments.getAllAppointments();
        if (selectedAppointments == null) {
            appointmentAlertsEN(1);
            return;
        }
        try {
            int apptID = selectedAppointments.getAppointmentID();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("Confirmation: Appointment Deletion");
            alert.setContentText("Appointment ID: " + apptID + "." + "\n" + "Appointment Type: " + selectedAppointments.getType() + "." + "\n" + "Do you want to proceeed with deletion?");
            Optional<ButtonType> deleteConfirm = alert.showAndWait();

            if (deleteConfirm.isPresent() && deleteConfirm.get() == ButtonType.OK) {
                deleteAppointments(apptID);
                AppointmentTableView.setItems(appointments);
                AppointmentTableView.refresh();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * on action view reports form
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void onActionViewReports(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(getClass().getResource("/view/ReportsScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.setTitle("Reports");
        stage.show();
    }

    /**
     * on action logout the application
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void onActionLogout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.setTitle("Login");
        stage.show();
    }

    /**
     * on action add customer form
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void onActionAddCustomer(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(getClass().getResource("/view/AddCustomerForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.setTitle("Add Customer");
        stage.show();
    }

    /**
     * on action modify customer form
     *
     * @param event the event
     * @throws IOException  the io exception
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionModifyCustomer(ActionEvent event) throws IOException, SQLException {
        Customers selectedCustomer = CustomerTableView.getSelectionModel().getSelectedItem();
        if (selectedCustomer == null) {
            customerDeletionEN(1);
            return;
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/ModifyCustomerForm.fxml"));
            loader.load();
            ModifyCustomerFormController controller = loader.getController();
            controller.getCustomer(selectedCustomer);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.setTitle("Modify Customer");
            stage.show();
        }
    }

    /**
     * on action delete customer form
     *
     * @param event the event
     * @throws SQLException the sql exception
     */
    @FXML
    void onActionDeleteCustomer(ActionEvent event) throws SQLException {
        Customers selectedCustomer = CustomerTableView.getSelectionModel().getSelectedItem();
        ObservableList<Appointments> appointments = DBAppointments.getAllAppointments();
        ObservableList<Customers> customers = DBCustomers.getAllCustomers();
        if (selectedCustomer == null) {
            customerDeletionEN(1);
            return;
        }
        try {
            int custID = selectedCustomer.getCustomerID();
            for (Appointments customerAppointments : appointments) {
                if (customerAppointments.getCustomerID() == selectedCustomer.getCustomerID()) {
                    customerDeletionEN(2);
                }
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("Confirmation: Customer Deletion");
            alert.setContentText("You are about to proceed with the deletion of a customer.");
            Optional<ButtonType> deleteConfirm = alert.showAndWait();

            if (deleteConfirm.isPresent() && deleteConfirm.get() == ButtonType.OK) {
                deleteCustomer(custID);

                CustomerTableView.setItems(customers);
                CustomerTableView.refresh();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * Lambda 1 is at line 430.Lambda 1 for setting the time format for the column.Lambda 2 is in the ModifyCustomerFormController.java at line 140. Initializes the controller class.
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
            TimeZoneLabel.setText(z.toString());
        }
        try {
            ObservableList<Appointments> appointments = DBAppointments.getAllAppointments();

            AppointmentTableView.setItems(appointments);
            ApptIDColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
            TitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            DescColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            LocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
            ContactColumn.setCellValueFactory(new PropertyValueFactory<>("contactID"));
            TypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            StartColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
            EndColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
            CustomerID1Column.setCellValueFactory(new PropertyValueFactory<>("customerID"));
            UserIDColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));

            //lambda one for setting the time format for the column. Other lambda is in the ModifyCustomerFormController.java at line 133.
            StartColumn.setCellFactory(column -> {
                TableCell<Appointments, LocalDateTime> col = new TableCell<Appointments, LocalDateTime>() {
                    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    @Override
                    protected void updateItem(LocalDateTime item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(dtf.format(item));
                        }
                    }
                };
                return col;
            });

            EndColumn.setCellFactory(column -> {
                TableCell<Appointments, LocalDateTime> col = new TableCell<Appointments, LocalDateTime>() {
                    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    @Override
                    protected void updateItem(LocalDateTime item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(dtf.format(item));
                        }
                    }
                };
                return col;
            });

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            ObservableList<Customers> customers = DBCustomers.getAllCustomers();

            CustomerTableView.setItems(customers);
            CustomerID2Column.setCellValueFactory(new PropertyValueFactory<>("customerID"));
            NameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            Address1Column.setCellValueFactory(new PropertyValueFactory<>("address"));
            FLDivisionColumn.setCellValueFactory(new PropertyValueFactory<>("division"));
            PostalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            CountryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
            PhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        ViewDate.setValue(LocalDate.now());
    }
}
