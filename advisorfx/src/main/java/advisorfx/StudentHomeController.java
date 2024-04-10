package advisorfx;

import advising.AuditFacade;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentHomeController {

  @FXML
  private Label StudentGreetingsText;

  @FXML
  private void setUp() {
    AuditFacade auditFacade = AuditFacade.getInstance();
    StudentGreetingsText.setText(
      "Hello, " +
      auditFacade.getStudent().getFirstName() +
      " " +
      auditFacade.getStudent().getLastName() +
      "!"
    );
  }

  @FXML
  private void initialize() {
    setUp();
  }

  @FXML
  private void logout() throws IOException {
    App.setRoot("LoginPage");
  }
}
