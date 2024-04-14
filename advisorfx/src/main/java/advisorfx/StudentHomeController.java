package advisorfx;

import advising.AuditFacade;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
  private Label HomeLabel;
  @FXML
  private Label TranscriptLabel;
  @FXML
  private Label SemesterPlanLabel;
  @FXML
  private Label AdvisingNotesLabel;
  @FXML
  private ChoiceBox LogOutBox;
  @FXML
  private Pane StudentMenuPane;
  @FXML
  private Pane ProfilePane;
  @FXML
  private Pane GpaPane;

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
    ClassificationLabel.setText("Classification: "+auditFacade.getStudent().getStudentClass());
    MajorLabel.setText("Student Username: " + auditFacade.getStudent().getMajor());
    GpaLabel.setText("Overall Gpa: \n" + auditFacade.getStudent().getPortfolio().getGpa());



  }

  @FXML
  private void initialize() {
      // Add event handlers to each label
      setUp();
      HomeLabel.setOnMouseClicked(event -> highlightLabel(HomeLabel));
      TranscriptLabel.setOnMouseClicked(event -> highlightLabel(TranscriptLabel));
      SemesterPlanLabel.setOnMouseClicked(event -> highlightLabel(SemesterPlanLabel));
      AdvisingNotesLabel.setOnMouseClicked(event -> highlightLabel(AdvisingNotesLabel));
      ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
      LogOutBox.setItems(options);
  }
  
  private void highlightLabel(Label label) {
      // Remove highlighting from all labels
      HomeLabel.getStyleClass().remove("highlighted");
      TranscriptLabel.getStyleClass().remove("highlighted");
      SemesterPlanLabel.getStyleClass().remove("highlighted");
      AdvisingNotesLabel.getStyleClass().remove("highlighted");
  
      // Add highlighting to the clicked label
      label.getStyleClass().add("highlighted");
      
  }
  @FXML
  void signOutStudent(ActionEvent event) throws IOException {
    logout();
  }

  @FXML
  private void logout() throws IOException {
    App.setRoot("LoginPage");
  }
}
