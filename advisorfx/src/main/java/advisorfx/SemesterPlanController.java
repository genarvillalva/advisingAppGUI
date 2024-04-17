package advisorfx;

import advising.AuditFacade;
import advising.Student;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class SemesterPlanController {
    @FXML
    private Hyperlink HomeLabelSem;

    @FXML
    private Hyperlink TranscriptLabelSem;

    @FXML
    private Hyperlink SemesterPlanLabelSem;

    @FXML 
    private Hyperlink AdvisingNotesLabelSem;

    @FXML
    private ChoiceBox LogOutBoxSem;

    @FXML
  private void initialize() {
      HomeLabelSem.setOnMouseClicked(event -> highlightHyperlink(HomeLabelSem));
      TranscriptLabelSem.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelSem));
      SemesterPlanLabelSem.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelSem));
      AdvisingNotesLabelSem.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelSem));
      ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
      LogOutBoxSem.setItems(options);
  }
  
  private void highlightHyperlink(Hyperlink Hyperlink) {
      // Remove highlighting from all labels
      HomeLabelSem.getStyleClass().remove("highlighted");
      TranscriptLabelSem.getStyleClass().remove("highlighted");
      SemesterPlanLabelSem.getStyleClass().remove("highlighted");
      AdvisingNotesLabelSem.getStyleClass().remove("highlighted");
  
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

