package advisorfx;

import advising.AuditFacade;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class StudentHomeController {

  @FXML
  private Button signOutButton; 

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
  private Hyperlink HomeLabel;
  @FXML
  private Hyperlink TranscriptLabel;
  @FXML
  private Hyperlink SemesterPlanLabel;
  @FXML
  private Hyperlink AdvisingNotesLabel;
  
  @FXML
  private Pane StudentMenuPane;
  @FXML
  private Pane ProfilePane;
  @FXML
  private Pane GpaPane;

  @FXML
  private ImageView logo;

  

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
    GpaLabel.setText("Overall Gpa: " + auditFacade.getStudent().getPortfolio().getGpa());



  }

  @FXML
  private void initialize() {
      setUp();
      HomeLabel.setOnMouseClicked(event -> highlightHyperlink(HomeLabel));
      TranscriptLabel.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabel));
      SemesterPlanLabel.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabel));
      AdvisingNotesLabel.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabel));
      ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
      // Load the image
      Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
      
      // Set the image to the ImageView
      logo.setImage(image);
  
  }
  
  private void highlightHyperlink(Hyperlink Hyperlink) {
      // Remove highlighting from all labels
      HomeLabel.getStyleClass().remove("highlighted");
      TranscriptLabel.getStyleClass().remove("highlighted");
      SemesterPlanLabel.getStyleClass().remove("highlighted");
      AdvisingNotesLabel.getStyleClass().remove("highlighted");
  
      // Add highlighting to the clicked label
      Hyperlink.getStyleClass().add("highlighted");
      
  }

  @FXML
  void viewAdvisingNotes() throws IOException {
    App.setRoot("ViewAdvisingNotes");
  }

  @FXML
  void viewStudentHome() throws IOException {
    App.setRoot("StudentHome");
  }

  @FXML
  void viewTranscript() throws IOException {
    App.setRoot("ViewTranscript");
  }

  @FXML
  void viewSemesterPlan() throws IOException {
    App.setRoot("ViewSemesterPlan");
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