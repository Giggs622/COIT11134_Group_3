package assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene sceneMain;
    private static Scene sceneEnter;
    private static Scene sceneCancel;
    private static Scene sceneView;

    private static Stage stage;
    private static DataHandler data;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Instantiate the DataHandler object
        data = new DataHandler("passenger.txt");

        // Create scenes
        try {
            Parent rootMain = FXMLLoader.load(getClass().getResource("passengerBooking.fxml"));
            Parent rootEnter = FXMLLoader.load(getClass().getResource("enterBooking.fxml"));
            Parent rootView = FXMLLoader.load(getClass().getResource("viewBooking.fxml"));
            Parent rootCancel = FXMLLoader.load(getClass().getResource("cancelBooking.fxml"));

            sceneMain = new Scene(rootMain);
            sceneEnter = new Scene(rootEnter);
            sceneView = new Scene(rootView);
            sceneCancel = new Scene(rootCancel);
        } catch (IOException e) {
            // Handle any potential FXML loading exceptions here
            e.printStackTrace();
        }

        stage = primaryStage;
        // Set the current scene to the main scene
        stage.setScene(sceneMain);
        stage.show();
    }

    // Method for passing a reference to the data object
    public static DataHandler getDataHandler() {
        return data;
    }

    // Method for switching scenes
    public static void changeScene(int sc) {
        switch (sc) {
            case 0:
                stage.setScene(sceneMain);
                break;
            case 1:
                stage.setScene(sceneEnter);
                break;
            case 2:
                stage.setScene(sceneView);
                break;
            case 3:
                stage.setScene(sceneCancel);
                break;
            default:
                break;
        }
    }

    // Method for exiting the application
    public static void exit() {
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
