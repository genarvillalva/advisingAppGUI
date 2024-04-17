package advisorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import java.io.IOException;
import advising.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SignUpController {
    
    @FXML
    private TextField firstNameTextBox;

    @FXML
    private TextField lastNameTextBox;

    @FXML
    private MenuItem userTypeDropDown;

    @FXML
    private TextField yearTextBox;

    @FXML
    private TextField majorTextBox;

    @FXML
    private TextField userNameTextBox;

    @FXML
    private TextField passwordTextBox;

    @FXML
    private ImageView logo;

    public void initialize() {
        // Load the image
        Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        
        // Set the image to the ImageView
        logo.setImage(image);
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        String firstName = firstNameTextBox.getText();
        String lastName = lastNameTextBox.getText();
        String year = yearTextBox.getText();
        String major = majorTextBox.getText();
        String userName = userNameTextBox.getText();
        String password = passwordTextBox.getText();
        String userType = userTypeDropDown.getText();

        AuditFacade facade = AuditFacade.getInstance();

        StudentYear studentYear = StudentYear.valueOf(year);

        facade.signUp(userName, password, userType, firstName, lastName, major, studentYear);
        System.out.println("User Created!");
        App.setRoot("LoginPage");
    }

    @FXML
    void nextPage(ActionEvent event) throws IOException {
      App.setRoot("Sign up 2 FX");
    }

}
