package advisorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Parent root; // Define root as a class-level variable

    private static Scene scene;
    @Override

    
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("LoginPage"), 1300, 900);
        String css = this.getClass().getResource("advising.css").toExternalForm();
        scene.getStylesheets().add(css); // Add the stylesheet to the scene
        stage.setScene(scene);
        stage.show();
    }
    
    // @Override
    // public void start(Stage stage) throws IOException {
    //     scene = new Scene(loadFXML("primary"), 640, 480);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    static void setRoot(String fxml) {
        //System.out.println("Entered setRoot");
        try {
            Parent newRoot = loadFXML(fxml);
            if (newRoot != null) {
                //System.out.println("Before setRoot - current root: " + scene.getRoot());
                scene.setRoot(newRoot);
                //System.out.println("After setRoot - new root: " + newRoot);
            } else {
                //System.out.println("Failed to load FXML: " + fxml);
            }
        } catch (IOException e) {
            System.out.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    private static Parent loadFXML(String fxml) throws IOException {
        System.out.println(fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


        // Method to get the current root
        public static Parent getCurrentRoot() {
            return root;
        }

        static void setRoot(Parent root) {
            scene.setRoot(root);
        }
        

    public static void main(String[] args) {
        launch();
    }

}