package advisorfx;

import advising.AuditFacade;
import advising.Student;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXML;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdvisingNotesController {
    @FXML
    private Hyperlink HomeLabelAdvise;

    @FXML
    private Hyperlink TranscriptLabelAdvise;

    @FXML
    private Hyperlink SemesterPlanLabelAdvise;

    @FXML 
    private Hyperlink AdvisingNotesLabelAdvise;


    @FXML
    private Pane StudentPaneAdvise;

    @FXML
    private ImageView logo;

    @FXML
    private Pane AdvisingBackground;

    @FXML
    private TableView<String> noteTextBox;

    private List<String> advisingNotes;

    @FXML
    private void initialize() {
        HomeLabelAdvise.setOnMouseClicked(event -> highlightHyperlink(HomeLabelAdvise));
        TranscriptLabelAdvise.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelAdvise));
        SemesterPlanLabelAdvise.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelAdvise));
        AdvisingNotesLabelAdvise.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelAdvise));
        ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
        // Load the image
        Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        
        // Set the image to the ImageView
        logo.setImage(image);
    }
    
    private void highlightHyperlink(Hyperlink Hyperlink) {
        HomeLabelAdvise.getStyleClass().remove("highlighted");
        TranscriptLabelAdvise.getStyleClass().remove("highlighted");
        SemesterPlanLabelAdvise.getStyleClass().remove("highlighted");
        AdvisingNotesLabelAdvise.getStyleClass().remove("highlighted");
    

        Hyperlink.getStyleClass().add("highlighted");
        
    }

    private void setAdvisingNotes() {
      //AuditFacade facade = AuditFacade.getInstance();
      String notes = getAdvisingNotes();

      String[] noteLines = notes.split("\n");

      noteTextBox.setItems(FXCollections.observableArrayList(noteLines));
    }


    private String getAdvisingNotes() {
      StringBuilder notesStringBuilder = new StringBuilder();
      for (String note : advisingNotes) {
          notesStringBuilder.append(note).append("\n");
      }
      return notesStringBuilder.toString();
    }

    @FXML
    void viewAdvisingNotes() throws IOException {
      setAdvisingNotes();
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
