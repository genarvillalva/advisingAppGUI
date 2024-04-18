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
    private TextField firstNameTextBox1;

    @FXML
    private TextField lastNameTextBox1;

    @FXML
    private TextField yearTextBox;

    @FXML
    private TextField majorTextBox;

    @FXML
    private TextField usernameTextBox;

    @FXML
    private TextField passwordTextBox;

    @FXML
    private TextField usernameTextBox1;

    @FXML
    private TextField passwordTextBox1;

    @FXML
    private ImageView logo;

    public void initialize() {
        // Load the image
        Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        
        // Set the image to the ImageView
        logo.setImage(image);
    }

    @FXML
    void studentSignUp(ActionEvent event) throws IOException {
        String firstName = firstNameTextBox.getText();
        String lastName = lastNameTextBox.getText();
        String year = yearTextBox.getText();
        String major = majorTextBox.getText();
        String userName = usernameTextBox.getText();
        String password = passwordTextBox.getText();
        StudentYear studentYear = StudentYear.valueOf(year);
        AuditFacade facade = AuditFacade.getInstance();

        facade.signUp(userName, password, "student", firstName, lastName, major, studentYear);
        System.out.println("Student Created!");
        App.setRoot("LoginPage");
    }

    
    @FXML
    void advisorSignUp(ActionEvent event) throws IOException {
      String userName = usernameTextBox1.getText();
      String password = passwordTextBox1.getText();
      String firstName = firstNameTextBox1.getText();
      String lastName = lastNameTextBox1.getText();
      StudentYear studentYear = StudentYear.valueOf("FRESHMAN");
      AuditFacade facade = AuditFacade.getInstance();

      facade.signUp(userName, password, "advisor", firstName, lastName, "", studentYear);


      System.out.println("Advisor Created!");
      App.setRoot("LoginPage");
    }
}
