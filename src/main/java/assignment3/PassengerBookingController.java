// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: PassengerBookingController.java
// Date: 7 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.application.Platform;

public class PassengerBookingController implements Initializable
{
    // Declare the instance variables
    private DataHandler data;
    private App app;
    
    @FXML
    private Button enterBookingButton;

    @FXML
    private Button viewBookingButton;

    @FXML
    private Button cancelBookingButton;

    @FXML
    private Button exitButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // Initialize ViewBooking controller
        // Create main class object to access methods
        app = new App();
        // Create object reference to datahandler in main class
        data = App.getDataHandler();
    }

    @FXML
    private void handleEnterBooking(ActionEvent event) throws IOException
    {
        System.out.println("Enter Booking");
        // Switch to the Enter Booking scene
        app.changeScene(1);
    }

    @FXML
    private void handleViewBooking(ActionEvent event) throws IOException
    {
        System.out.println("View Bookings");
        // Switch to the View Booking scene
        app.changeScene(2);
    }

    @FXML
    private void handleCancelBooking(ActionEvent event) throws IOException
    {
        System.out.println("Cancel Booking");
        // Switch to the Cancel Booking scene
        app.changeScene(3);
    }

    @FXML
    private void exitButton(ActionEvent event)
    {
        System.out.println("Exit Program");
        // Exit program
        Platform.exit();
    }
}
