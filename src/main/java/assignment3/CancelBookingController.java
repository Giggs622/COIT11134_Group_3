package assignment3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CancelBookingController implements Initializable {

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
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your controller here if needed
    }

    @FXML
    private void handleCancelButton() {
        
    }

    @FXML
    private void handleSearchButton() {
        
    }
    
    @FXML
    private void handleComfirmation() {
        
    }
    
    @FXML
    private void handleBackButton() {
        System.out.println("Exit to Main Menu ");
        // Switch to the Main Menu scene
        App.changeScene(0);
    }
}
