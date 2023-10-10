// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: EnterBookingController.java
// Date: 7 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class EnterBookingController implements Initializable
{
    // Declare the instance variables
    int bookingID;
    String passengerName;
    String flightDate;
    String passengerEmail;
    String passengerNumber;
    String passengerDestination;
    String passengerClass;

    private DataHandler datahandler;
    private ArrayList<Passenger> passengerList;
    private App app;

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

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // Create main class object to access methods
        app = new App();
        // Create object reference to datahandler in main class
        datahandler = App.getDataHandler();
    }

    @FXML
    private void handleBackButton() throws IOException
    {
        System.out.println("Exit to Main Menu ");
        // Switch to the Main Menu scene
        app.changeScene(0);
        // Clear the text fields and reset the radio buttons
        resetFields();
    }

    @FXML
    private void handleSubmitButton()
    {
        saveData(); // Call the saveData method to save passenger data
    }

    // Method to save the data entered into the booking page by the user
    private void saveData()
    {
        // Get user input from text fields
        flightDate = dateTextField.getText();
        passengerName = passengerNameTextField.getText();
        passengerEmail = emailAddressTextField.getText();
        passengerNumber = phoneNumberTextField.getText();

        // Check destination radio button
        if (sydneyRB.isSelected())
        {
            passengerDestination = "Sydney";
        }
        else
        {
            passengerDestination = "Perth";
        }

        // Check class radio button
        if (firstClassRB.isSelected())
        {
            passengerClass = "First Class";
        }
        else if (businessRB.isSelected())
        {
            passengerClass = "Business";
        }
        else
        {
            passengerClass = "Economy";
        }

        // Check that text field are not empty
        if (passengerNumber.equals("") || flightDate.equals("") || passengerName.equals("") || passengerEmail.equals(""))
        {
            showAlert("Invalid Input", "Please enter data into empty textfields and resubmit.");
            return;
        }

        // Get the last booking ID number stored and increment to the next number
        bookingID = datahandler.findLastBookingID() + 1;

        // Create a new passenger object with user input
        Passenger passenger = new Passenger(bookingID, flightDate, passengerName, passengerEmail, passengerNumber, passengerClass, passengerDestination);
        System.out.println(passenger);

        // Add the passenger to the ArrayList in the DataHandler
        datahandler.addPassenger(passenger);
        // Call the method in the DataHandler to save the ArrayList to file
        datahandler.saveDataPassenger();

        // Show confirmation that booking has been stored successfully
        showAlert("Booking Confirmed", String.format("Your booking has been saved, %s%nYour booking number is: %d", passengerName, bookingID));
        System.out.println("Your booking has been saved, " + passengerName);
        System.out.println("Your booking number is:" + bookingID);

        // Clear the text fields and reset the radio buttons for next booking
        resetFields();
    }

    // Method to display an alert with the title and content read in
    private void showAlert(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Method to reset all fields on the page
    private void resetFields()
    {
        // Clear the text fields and reset the radio buttons
        dateTextField.clear();
        passengerNameTextField.clear();
        emailAddressTextField.clear();
        phoneNumberTextField.clear();
        perthRB.setSelected(true);
        economyRB.setSelected(true);
    }
}
