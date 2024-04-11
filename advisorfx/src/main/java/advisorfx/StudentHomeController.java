package advisorfx;

import advising.AuditFacade;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentHomeController {

  @FXML
  private Label StudentGreetingsText;
  @FXML
  private Label UsernameLabel;
  @FXML
  private Label NameLabel;
  @FXML
  private Label DegreeLabel;
  @FXML
  private Label LevelLabel;
  @FXML
  private Label ClassificationLabel;
  @FXML
  private Label MajorLabel;
  @FXML
  private Label GpaLabel;

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
    UsernameLabel.setText("Student Username: " + auditFacade.getStudent().getUsername());
    NameLabel.setText("Name: " + auditFacade.getStudent().getLastName() +", " + auditFacade.getStudent().getFirstName() );
    DegreeLabel.setText("Degree: Bachelor of Science");
    LevelLabel.setText("Level: Undergraduate");
    ClassificationLabel.setText(auditFacade.getStudent().getStudentClass());
    MajorLabel.setText("Student Username: " + auditFacade.getStudent().getMajor());




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
