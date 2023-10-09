package assignment3;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class EnterBookingController implements Initializable {
    
    int bookingID = 1;
    String passengerName;
    String flightDate;
    String passengerEmail;
    String passengerNumber;
    String passengerDestination;
    String passengerClass;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField dateTextField;

    @FXML
    private RadioButton perthRB;

    @FXML
    private RadioButton sydneyRB;

    @FXML
    private RadioButton economyRB;

    @FXML
    private RadioButton businessRB;

    @FXML
    private RadioButton firstClassRB;

    @FXML
    private TextField passengerNameTextField;

    @FXML
    private TextField emailAddressTextField;

    @FXML
    private TextField phoneNumberTextField;
    
    private DataHandler datahandler;
    private Passenger p;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the DataHandler with the file name
        try {
            datahandler = new DataHandler("passenger.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBackButton() {
        System.out.println("Exit to Main Menu ");
        // Switch to the Main Menu scene
        App.changeScene(0);
    }

    @FXML
    private void handleSubmitButton() {
        saveData(); // Call the saveData method to save passenger data
    }
    
    @FXML
    private void handlePerthRadioButton() {
        passengerDestination = "Perth";
    }

    @FXML
    private void handleSydneyRadioButton() {
        passengerDestination = "Sydney";
    }

    @FXML
    private void handleEconomyRadioButton() {
        passengerClass = "Economy";
    }

    @FXML
    private void handleBusinessRadioButton() {
        passengerClass = "Business";
    }

    @FXML
    private void handleFirstClassRadioButton() {
        passengerClass = "First Class";
    }


    private void saveData() {
        bookingID = bookingID + 1;
        flightDate = dateTextField.getText();
        passengerName = passengerNameTextField.getText();
        passengerEmail = emailAddressTextField.getText();
        passengerNumber = phoneNumberTextField.getText();

        if (passengerNumber.equals("") || flightDate.equals("") || passengerName.equals("") || passengerEmail.equals("")) {
            showAlert("Invalid Input", "Please enter data into empty textfields and resubmit.");
        } else {
            System.out.println("Your booking has been saved, " + passengerName);
            System.out.println("Your booking number is:" + bookingID);
        }

        Passenger passenger = new Passenger(bookingID, flightDate, passengerName, passengerEmail, passengerNumber, passengerClass, passengerDestination);
        System.out.println(passenger);

        datahandler.addPassenger(passenger);
        datahandler.saveDataPassenger();

        dateTextField.clear();
        passengerNameTextField.clear();
        emailAddressTextField.clear();
        phoneNumberTextField.clear();
    }

    private void findClass (){
        
    }
    
    private void findDesination (){
        
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
