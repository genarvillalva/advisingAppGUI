package advisorfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;




public class CreateAdvisingNotesController {

    @FXML
    private Pane AdvisingMenuPaneAdviseeNotes;


    @FXML
    private Hyperlink AdvisingNotesLabelAdviseAdviseeNotes;

    @FXML
    private Hyperlink HomeLabelAdviseAdviseeNotes;

    @FXML
    private Text SENDAdviseeNotes;

    @FXML
    private Hyperlink TranscriptLabelAdviseeNotes;

    @FXML
    private TextArea WRITEAdviseeNotes;


    @FXML
    private Hyperlink SemesterPlanLabelAdviseeNotes;





  
    @FXML
    private void initialize() {
        HomeLabelAdviseAdviseeNotes.setOnMouseClicked(event -> highlightHyperlink(HomeLabelAdviseAdviseeNotes));
        TranscriptLabelAdviseeNotes.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelAdviseeNotes));
        AdvisingNotesLabelAdviseAdviseeNotes.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelAdviseAdviseeNotes));
        SemesterPlanLabelAdviseeNotes.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelAdviseeNotes));
        
  
    }
    
    private void highlightHyperlink(Hyperlink Hyperlink) {
        HomeLabelAdviseAdviseeNotes.getStyleClass().remove("highlighted");
        TranscriptLabelAdviseeNotes.getStyleClass().remove("highlighted");
        AdvisingMenuPaneAdviseeNotes.getStyleClass().remove("highlighted");
        SemesterPlanLabelAdviseeNotes.getStyleClass().remove("highlighted");

    

        Hyperlink.getStyleClass().add("highlighted");
        
    }


    @FXML
    void viewTranscriptasAdvisor() throws IOException {
      App.setRoot("ViewAdviseeTranscript");

    }

    @FXML
    void viewSemesterPlanAsAdvisor() throws IOException {
      App.setRoot("ViewAdviseeSemesterPlan");

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        App.setRoot("LoginPage");
    }

    @FXML
    void viewAdvisingNotesAsAdvisor() throws IOException {
      App.setRoot("CreateAdvisingNotes");
    }
  
    @FXML
    void viewStudentHomeAsAdvisor() throws IOException {
      App.setRoot("AdviseeScreen");
    }

    @FXML
    void sendAdvisingNote() {
     
  
   
}

  





}