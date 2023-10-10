// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: CancelBookingController.java
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CancelBookingController implements Initializable
{
    // Declare the instance variables
    private DataHandler datahandler;
    private ArrayList<Passenger> passengerList;
    private App app;

    private int index = -1;

    @FXML
    private TextArea bookingTextArea;

    @FXML
    private Button backButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField bookingNumberField;

    @FXML
    private Button searchButton;

    @FXML
    private CheckBox confirmCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // Initialize the controller
        // Create main class object to access methods
        app = new App();
    }

    @FXML
    private void handleCancelButton()
    {
        // Check that the confirmation checkbox is ticked
        if (confirmCheckBox.isSelected() && this.index >= 0)
        {
            datahandler.deleteBooking(this.index);
            confirmMessage("Booking successfully deleted");
            // Clear the text fields
            resetFields();
        }
        else
        {
            // Reset check box
            confirmCheckBox.setSelected(false);
        }
    }

    @FXML
    private void handleSearchButton()
    {
        // Declare variable to hold search number
        int searchNumber;

        // Parse text field string into an integer and display error if it is not
        try
        {
            searchNumber = Integer.parseInt(bookingNumberField.getText());
        }
        catch (NumberFormatException ex) // Display an error message and exit method
        {
            errorMessage("Booking Number ID entered must be a number");
            return;
        }

        // Create object reference to data handler
        datahandler = App.getDataHandler();
        // Get memberList ArrayList from data handler
        passengerList = datahandler.getArrayList();

        // Get DataHandler to search for booking number and store returned index
        this.index = datahandler.findBookingID(searchNumber);

        // If booking found print to text area
        if (index > -1)
        {
            // Get the member details from the memberList
            Passenger p = passengerList.get(index);
            // Display passenger details in text area
            bookingTextArea.setText(p.toString());
        }
        else
        // Display "Member not found" message
        {
            errorMessage("Booking ID number not found");
            resetFields();
        }
    }

    @FXML
    private void handleComfirmation()
    {

    }

    @FXML
    private void handleBackButton() throws IOException
    {
        System.out.println("Exit to Main Menu ");
        // Switch to the Main Menu scene
        app.changeScene(0);
        // Clear the text field and text area and uncheck confirm box
        resetFields();
    }

    // Method to show an error message with details read in
    private void errorMessage(String content)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Method to show a confirmation with details read in
    private void confirmMessage(String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Method to reset all fields on the page
    private void resetFields()
    {
        // Clear the text fields and reset the radio buttons
        bookingNumberField.clear();
        bookingTextArea.clear();
        confirmCheckBox.setSelected(false);
    }
}
