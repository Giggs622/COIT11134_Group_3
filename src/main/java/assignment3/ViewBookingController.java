package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ViewBookingController implements Initializable {

    private DataHandler datahandler;
    private ArrayList<Passenger> passengerList;
    
    @FXML
    private TextArea textArea;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* Read the "passenger.txt" file and display its content in the TextArea
        try (BufferedReader reader = new BufferedReader(new FileReader("passenger.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException ex) {
            System.err.println("Error reading the file: " + ex.getMessage());
        }*/
        // Create object reference to datahandler in main class
        datahandler = App.getDataHandler();
        passengerList = data.getArrayList();
        
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
    private void handleBackButton(ActionEvent event) {
        System.out.println("Exit to Main Menu");
        // Switch to the Main Menu scene
        App.changeScene(0);
        
        //textArea.clear();
    }
}
