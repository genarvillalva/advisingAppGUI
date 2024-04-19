package advisorfx;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AdviseeSemesterPlanController {

    @FXML
    private Hyperlink AdvisingNotesLabelSemAdvisee;

    @FXML
    private Label CreditHourEightAdvisee;

    @FXML
    private Label CreditHoursFiveAdvisee;

    @FXML
    private Label CreditHoursFourAdvisee;

    @FXML
    private Label CreditHoursOneAdvisee;

    @FXML
    private ImageView logo;

    @FXML
    private Label CreditHoursSevenAdvisee;

    @FXML
    private Label CreditHoursSixAdvisee;

    @FXML
    private Label CreditHoursThreeAdvisee;

    @FXML
    private Label CreditHoursTwoAdvisee;

    @FXML
    private ListView<?> FreshmanCourses1Advisee;

    @FXML
    private ListView<?> FreshmanCoursesAdvisee;

    @FXML
    private Pane GpaPaneAdvisee;

    @FXML
    private Hyperlink HomeLabelSemAdvisee;

    @FXML
    private ListView<?> JuniorCourses1Advisee;

    @FXML
    private ListView<?> JuniorCoursesAdvisee;

    @FXML
    private ChoiceBox<?> LogOutBoxSemAdvisee;

    @FXML
    private Label SemEightLabelAdvisee;

    @FXML
    private Label SemFiveLabelAdvisee;

    @FXML
    private Label SemFourLabelAdvisee;

    @FXML
    private Label SemOneLabelAdvisee;

    @FXML
    private Label SemSevenLabelAdvisee;

    @FXML
    private Label SemSixLabelAdvisee;

    @FXML
    private Label SemThreeLabelAdvisee;

    @FXML
    private Label SemTwoLabeladvisee;

    @FXML
    private Hyperlink SemesterPlanLabelSemAdvisee;

    @FXML
    private ListView<?> SeniorCourses1Advisee;

    @FXML
    private ListView<?> SeniorCoursesAdvisee;

    @FXML
    private ListView<?> SophomoreCourses1Advisee;

    @FXML
    private ListView<?> SophomoreCoursesAdvisee;

    @FXML
    private Pane StudentMenuPaneSemAdvisee;

    @FXML
    private Label TranscriptHeaderAdvisee;

    @FXML
    private Hyperlink TranscriptLabelSemAdvisee;


        @FXML
    private void initialize() {
      HomeLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(HomeLabelSemAdvisee));
      TranscriptLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelSemAdvisee));
      SemesterPlanLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelSemAdvisee));
      AdvisingNotesLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelSemAdvisee));
      ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
      // Load the image
      Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        
      // Set the image to the ImageView
      logo.setImage(image);
  }
  
  private void highlightHyperlink(Hyperlink Hyperlink) {
      // Remove highlighting from all labels
      HomeLabelSemAdvisee.getStyleClass().remove("highlighted");
      TranscriptLabelSemAdvisee.getStyleClass().remove("highlighted");
      SemesterPlanLabelSemAdvisee.getStyleClass().remove("highlighted");
      AdvisingNotesLabelSemAdvisee.getStyleClass().remove("highlighted");
  
      // Add highlighting to the clicked label
      Hyperlink.getStyleClass().add("highlighted");
      
  }



    @FXML
    void viewAdvisingNotesasAdvisor() throws IOException {
        App.setRoot("CreateAdvisingNotes");
    }

    @FXML
    void viewSemesterPlanasAdvisor() throws IOException {
        App.setRoot("ViewAdviseeSemterPlan");
    }

    @FXML
    void viewStudentHomeasAdvisor() throws IOException {
        App.setRoot("AdviseeScreen");
    }

    @FXML
    void viewTranscriptasAdvisor() throws IOException {
        App.setRoot("ViewAdviseeTranscript");
    }




}
