package advisorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import advising.*;

public class LoginController {
    @FXML
    private TextField txt_password;
    
    @FXML
    private Label label_invalidLogin;

    @FXML
    private TextField txt_username;

    @FXML
    void signIn(ActionEvent event) {
      String userName = txt_username.getText();
      String password = txt_password.getText();

      AuditFacade facade = AuditFacade.getInstance();

      if(facade.login(userName, password, "student")){
        System.out.println("YAY");
      }
      else {
        System.out.println("NAY!");
        label_invalidLogin.setVisible(true);
     }
    }

}