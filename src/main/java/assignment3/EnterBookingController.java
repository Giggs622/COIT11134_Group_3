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

public class EnterBookingController implements Initializable
{

    int bookingID = 1;
    String passengerName;
    String flightDate;
    String passengerEmail;
    String passengerNumber;
    String passengerDestination;
    String passengerClass;

    private DataHandler datahandler;
    private Passenger p;
    
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
        // Create object reference to datahandler in main class
        datahandler = App.getDataHandler();
    }

    @FXML
    private void handleBackButton()
    {
        System.out.println("Exit to Main Menu ");
        // Switch to the Main Menu scene
        App.changeScene(0);
    }

    @FXML
    private void handleSubmitButton()
    {
        saveData(); // Call the saveData method to save passenger data
    }
    
    // Method to save the data entered into the booking page by the user
    private void saveData()
    {
        bookingID = bookingID + 1;
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
        else
        {
            showAlert("Booking Confirmed", String.format("Your booking has been saved, %s%nYour booking number is: %d", passengerName, bookingID));
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

    private void showAlert(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
