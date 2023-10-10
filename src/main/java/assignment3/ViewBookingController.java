// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: ViewBookingController.java
// Date: 7 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ViewBookingController implements Initializable
{
    // Delcare the instance variables
    private DataHandler datahandler;
    private ArrayList<Passenger> passengerList;
    private App app;

    @FXML
    private TextArea textArea;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // Create object reference to datahandler in main class
        app = new App();
        // Create object reference to datahandler in main class
        datahandler = App.getDataHandler();
        // Get ArrayList from DataHandler
        passengerList = datahandler.getArrayList();

        // Print the bookings to the text area
        StringBuilder content = new StringBuilder("");
        for (Passenger p : passengerList)
        {
            content.append(p.toString()).append("\n");
        }
        System.out.println(content.toString());
        textArea.setText(content.toString());
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException
    {
        System.out.println("Exit to Main Menu");
        // Switch to the Main Menu scene
        app.changeScene(0);
    }
}
