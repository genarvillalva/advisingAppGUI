package advisorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import advising.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;

public class LoginController {
    
    @FXML
    private Label label_invalidLogin;

    @FXML
    private TextField txt_username;

    @FXML
    private ImageView logo;

    @FXML 
    private PasswordField password_field;

    public void initialize() {
        // Load the image
        Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        
        // Set the image to the ImageView
        logo.setImage(image);
    }

    @FXML
    void signInStudent(ActionEvent event) throws IOException {
      String userName = txt_username.getText();
      String password = password_field.getText();

      AuditFacade facade = AuditFacade.getInstance();

      if(facade.login(userName, password, "student")){
        System.out.println("YAY");
        App.setRoot("StudentHome");
      }
      else {
        System.out.println("NAY!");
        label_invalidLogin.setVisible(true);
     }
    }
    @FXML 
    void signInAdvisor(ActionEvent event) throws IOException {
      String userName = txt_username.getText();
      String password = password_field.getText();

      AuditFacade facade = AuditFacade.getInstance();

      if(facade.login(userName, password, "advisor")){
        System.out.println("yes");
        App.setRoot("AdvisorHome");
        
      }
      else {
        System.out.println("no!");
        label_invalidLogin.setVisible(true);
     }
    }
    @FXML
    void signUpStudent(ActionEvent event) throws IOException {
      System.out.println("Student Sign Up");
      App.setRoot("Sign up 1 FX");
    }

    @FXML
    void signUpAdvisor(ActionEvent event) throws IOException {
      System.out.println("Advisor Sign Up");
      App.setRoot("Sign up 2 FX");
    }

}
