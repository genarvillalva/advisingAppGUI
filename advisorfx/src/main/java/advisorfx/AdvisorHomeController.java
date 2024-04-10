package advisorfx;

import advising.AuditFacade;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdvisorHomeController{

  @FXML
  private Label AdvisorGreetingsText;

  @FXML
  private void setUp() {
    AuditFacade auditFacade = AuditFacade.getInstance();
    AdvisorGreetingsText.setText(
      "Hello, " +
      auditFacade.getAdvisor().getFirstName() +
      " " +
      auditFacade.getAdvisor().getLastName() + "!"
    );
  }

  @FXML
  private void initialize(){
    setUp();
  }

  

  @FXML
  private void logout() throws IOException {
    App.setRoot("LoginPage");
  }
}
