package assignment3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.application.Platform;

public class PassengerBookingController implements Initializable {

    @FXML
    private Button enterBookingButton;

    @FXML
    private Button viewBookingButton;

    @FXML
    private Button cancelBookingButton;
    
    @FXML
    private Button exitButton;
    
    private DataHandler data;
    //private ViewBookingController view;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ViewBooking controller
        data = App.getDataHandler();
        //view = new ViewBookingController();
    }

    @FXML
    private void handleEnterBooking(ActionEvent event) {
        System.out.println("Enter Booking");
        // Switch to the Enter Booking scene
        App.changeScene(1); 
    }

    @FXML
    private void handleViewBooking(ActionEvent event) {
        System.out.println("View Bookings");
        // Get passenger recorders and print to text area
        ViewBookingController.printRecords(data.getArrayList());
        // Switch to the View Booking scene
        App.changeScene(2);
    }

    @FXML
    private void handleCancelBooking(ActionEvent event) {
        System.out.println("Cancel Booking");
        // Switch to the Cancel Booking scene
        App.changeScene(3);
    }
    
    @FXML
    private void exitButton(ActionEvent event) {
        System.out.println("Exit Program");
        // Switch to the Cancel Booking scene
        Platform.exit();
    }
}
