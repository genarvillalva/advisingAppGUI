package advisorfx;

import java.io.IOException;

import advising.AuditFacade;
import advising.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private Hyperlink POOP;

    @FXML
    private Label UsernameLabelAdvisee;

    private Student advisee;


    @FXML
    public void loadAdviseeData(String username) {
        System.out.println("Loading data for username: " + username);
    
        // get the Student object using the username provided.
        this.advisee = AuditFacade.getInstance().getStudentByUsername(username); 
    
        if (this.advisee != null) {
            System.out.println("Student found with username: " + username);
            ProfileAdvisee.setText("Profile of   " + this.advisee.getFirstName() + " " + this.advisee.getLastName());
            NameLabelAdvisee.setText(String.format("%s %s", advisee.getFirstName(), advisee.getLastName()));
            UsernameLabelAdvisee.setText(advisee.getUsername());
            setup(); // Call the setup method after loading data
        } else {
            System.err.println("No student found with username: " + username);
        }
    }


    
    
    @FXML
    private void setup() {
        if (advisee != null) {
            DegreeLabelAdvisee.setText("Bachelor of Science");
            LevelLabelAdvisee.setText("Undergraduate");
            ClassificationLabelAdvisee.setText(advisee.getStudentClass());
            String major = advisee.getMajor();
            String major2 = major.replace("_", " ");
            MajorLabelAdvisee.setText(major2);
        } else {
            System.err.println("No advisee data available.");
        }
    }
    




    @FXML
    private void initialize() {
        HomeLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(HomeLabelAdvisee));
        TranscriptLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelAdvisee));
        AdvisingNotesLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelAdvisee));
        SemesterPlanLabelAdvisee.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelAdvisee));
        AuditFacade auditFacade = AuditFacade.getInstance();

          String username = auditFacade.getCurrentAdviseeUsername();
          loadAdviseeData(username);

    

}
    

    private void highlightHyperlink(Hyperlink hyperlink) {
        HomeLabelAdvisee.getStyleClass().remove("highlighted");
        TranscriptLabelAdvisee.getStyleClass().remove("highlighted");
        AdvisingNotesLabelAdvisee.getStyleClass().remove("highlighted");
        hyperlink.getStyleClass().add("highlighted");
    }

    @FXML
    void handleBackButton() throws IOException {
        System.out.println("Back button pressed");
        App.setRoot("AdvisorHome");
    }

    @FXML
    void viewTranscriptasAdvisor() throws IOException {
        System.out.println("viewTranscriptasAdvisor() method called.");
        System.out.println("Before setRoot - current root: " + App.getCurrentRoot()); // Get the current root
        App.setRoot("ViewAdviseeTranscript");
        System.out.println("After setRoot - new root: " + App.getCurrentRoot()); // Get the new root after setting
        System.out.println("exited setroot");
    }
    
    
    @FXML
    void viewAdvisingNotesAsAdvisor() throws IOException {
        System.out.println("viewAdvisingNotesAsAdvisor() method called.");
        App.setRoot("CreateAdvisingNotes");
    }

    @FXML
    void viewStudentHomeAsAdvisor() throws IOException {
        App.setRoot("AdviseeScreen");
    }

    @FXML
    void viewSemesterPlanAsAdvisor() throws IOException {
        App.setRoot("ViewAdviseeSemesterPlan");

    }
}