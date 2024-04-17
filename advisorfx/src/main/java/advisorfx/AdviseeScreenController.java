package advisorfx;

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
    private Hyperlink AdvisingNotesLabela;

    @FXML
    private Label ClassificationLabela;

    @FXML
    private Label DegreeLabela;

    @FXML
    private Hyperlink HomeLabela;

    @FXML
    private Label LevelLabela;

    @FXML
    private ChoiceBox<?> LogOutBoxa;

    @FXML
    private Label MajorLabela;

    @FXML
    private Label NameLabela;

    @FXML
    private Pane ProfileBoarder;

    @FXML
    private Pane ProfilePanea;

    @FXML
    private Label Profilea;

    @FXML
    private Pane AdvisorMenuPane;

    @FXML
    private Hyperlink TranscriptLabela;

    @FXML
    private Label UsernameLabela;

    @FXML
    void signOutStudent(ActionEvent event) {

    }

    @FXML
    void viewAdvisingNotes(ActionEvent event) {

    }

    @FXML
    void viewStudentHome(ActionEvent event) {

    }

    @FXML
    void viewTranscript(ActionEvent event) {

    }
    
    private Student advisee;




public void loadAdviseeData(String username) {
    // get the Student object using the username provided.
    System.out.println("Loading data for username: " + username);
    this.advisee = AuditFacade.getInstance().getStudentByUsername(username);

    if (this.advisee != null) {
       
        
         Profilea.setText(
           "Profile of   " +
           this.advisee.getFirstName() +
           " " +
           this.advisee.getLastName());

        NameLabela.setText(String.format("%s %s", advisee.getFirstName(), advisee.getLastName()));
        UsernameLabela.setText(advisee.getUsername());
        DegreeLabela.setText("Degree: Bachelor of Science"); 
        LevelLabela.setText("Level: Undergraduate"); 
        ClassificationLabela.setText("Classification: " + advisee.getStudentClass());
        MajorLabela.setText("Major: " + advisee.getMajor());
    } else {
        System.err.println("No student found with username: " + username);
    }
}
}