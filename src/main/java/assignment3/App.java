// Programmers: Lochlain Cathcart 12127289; Matt Jones S0201735; William Korger 12151970
// File: App.java
// Date: 7 Sept 2023
// Purpose: COIT11134 Assignment 3

package assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application
{

    private static Scene sceneMain;
    private static Scene sceneEnter;
    private static Scene sceneCancel;
    private static Scene sceneView;

    private static Stage stage;
    private static DataHandler data;

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        // Instantiate the DataHandler object
        data = new DataHandler();

        // Create scenes
        try
        {
            Parent rootMain = FXMLLoader.load(getClass().getResource("passengerBooking.fxml"));
            Parent rootEnter = FXMLLoader.load(getClass().getResource("enterBooking.fxml"));
            Parent rootCancel = FXMLLoader.load(getClass().getResource("cancelBooking.fxml"));

            sceneMain = new Scene(rootMain);
            sceneEnter = new Scene(rootEnter);
            sceneCancel = new Scene(rootCancel);
        }
        catch (IOException e)
        {
            // Handle any potential FXML loading exceptions here
            e.printStackTrace();
        }

        stage = primaryStage;
        // Set the current scene to the main scene
        stage.setScene(sceneMain);
        stage.show();
    }

    // Method for passing a reference to the data object
    public static DataHandler getDataHandler()
    {
        return data;
    }

    // Method for switching scenes
    public void changeScene(int sc) throws IOException
    {
        switch (sc)
        {
            case 0:
                stage.setScene(sceneMain);
                break;
            case 1:
                stage.setScene(sceneEnter);
                break;
            case 2:
                sceneView = new Scene(loadViewScene());
                stage.setScene(sceneView);
                break;
            case 3:
                stage.setScene(sceneCancel);
                break;
            default:
                break;
        }
    }

    // Method to load ViewBooking JavaFX scene
    private Parent loadViewScene() throws IOException
    {
        return FXMLLoader.load(getClass().getResource("viewBooking.fxml"));
    }

    // Method for exiting the application
    public static void exit()
    {
        stage.close();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
