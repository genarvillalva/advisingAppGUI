package advisorfx;

import java.io.IOException;

import advising.AuditFacade;
import advising.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class AdviseeScreenController {

    @FXML
    private Hyperlink AdvisingNotesLabelAdvisee;

    @FXML
    private Label ClassificationLabelAdvisee;

    @FXML
    private Label DegreeLabelAdvisee;

    @FXML
    private Hyperlink HomeLabelAdvisee;

    @FXML
    private Label LevelLabelAdvisee;

    @FXML
    private ChoiceBox<?> LogOutBoxAdvisee;

    @FXML
    private Label MajorLabelAdvisee;

    @FXML
    private Label NameLabelAdvisee;

    @FXML
    private Pane ProfileBoarderAdvisee;

    @FXML
    private Pane ProfilePaneAdvisee;

    @FXML
    private Label ProfileAdvisee;

    @FXML
    private Pane AdviseeMenuPane;

    @FXML
    private Hyperlink TranscriptLabelAdvisee;
    
    @FXML
    private Hyperlink SemesterPlanLabelAdvisee;


    @FXML
    private Label UsernameLabelAdvisee;

    @FXML
    void signOutStudent(ActionEvent event) {

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
    void viewSemesterPlanAsAdvisor() throws IOException {
    }

    @FXML
    void viewTranscriptasAdvisor(ActionEvent event) {

    }
    
    private Student advisee;




public void loadAdviseeData(String username) {
    // get the Student object using the username provided.
    System.out.println("Loading data for username: " + username);
    this.advisee = AuditFacade.getInstance().getStudentByUsername(username);

    if (this.advisee != null) {
       
        
         ProfileAdvisee.setText(
           "Profile of   " +
           this.advisee.getFirstName() +
           " " +
           this.advisee.getLastName());

        NameLabelAdvisee.setText(String.format("%s %s", advisee.getFirstName(), advisee.getLastName()));
        UsernameLabelAdvisee.setText(advisee.getUsername());
        DegreeLabelAdvisee.setText("Degree: Bachelor of Science"); 
        LevelLabelAdvisee.setText("Level: Undergraduate"); 
        ClassificationLabelAdvisee.setText("Classification: " + advisee.getStudentClass());
        MajorLabelAdvisee.setText("Major: " + advisee.getMajor());
    } else {
        System.err.println("No student found with username: " + username);
    }
}

 @FXML
    private void initialize() {
        HomeLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(HomeLabelAdvisee));
        TranscriptLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelAdvisee));
        AdvisingNotesLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelAdvisee));
        SemesterPlanLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelAdvisee));

    }
    
    private void highlightHyperlink(Hyperlink Hyperlink) {
        HomeLabelAdvisee.getStyleClass().remove("highlighted");
        TranscriptLabelAdvisee.getStyleClass().remove("highlighted");
        AdvisingNotesLabelAdvisee.getStyleClass().remove("highlighted");
    

        Hyperlink.getStyleClass().add("highlighted");
        
    }


    




}