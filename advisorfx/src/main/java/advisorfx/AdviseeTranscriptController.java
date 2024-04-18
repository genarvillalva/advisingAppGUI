package advisorfx;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdviseeTranscriptController {

    @FXML
    private Label AdviseeCreditHourLabelF;

    @FXML
    private Label AdviseeCreditHourLabelJ;

    @FXML
    private Label AdviseeCreditHourLabelS;

    @FXML
    private Label AdviseeCreditHourLabelSO;

    @FXML
    private ListView<?> AdviseeFreshmanCourses;

    @FXML
    private Label AdviseeFreshmanLabel;

    @FXML
    private Pane AdviseeGpaPane;

    @FXML
    private Label AdviseeGradeLabelF;

    @FXML
    private Label AdviseeGradeLabelJ;

    @FXML
    private Label AdviseeGradeLabelS;

    @FXML
    private Label AdviseeGradeLabelSO;

    @FXML
    private Hyperlink AdviseeHomeLabelTrans;

    @FXML
    private ListView<?> AdviseeJuniorCourses;

    @FXML
    private Label AdviseeJuniorLabel;

    @FXML
    private ListView<?> AdviseeSeniorCourses;

    @FXML
    private Label AdviseeSeniorLabel;

    @FXML
    private ListView<?> AdviseeSophomoreCourses;

    @FXML
    private Label AdviseeSophomoreLabel;

    @FXML
    private Label AdviseeTranscriptHeader;

    @FXML
    private Hyperlink AdviseeTranscriptLabelTrans;

    @FXML
    private Hyperlink AdvisingNotesLabelTransAdvisee;

    @FXML
    private ChoiceBox<?> LogOutBoxTransAdvisee;

    @FXML
    private Hyperlink SemesterPlanLabelTransAdvisee;

    @FXML
    private Pane StudentMenuPaneTransAdvisee;


    @FXML
    void viewAdvisingNotesasAdvisor(ActionEvent event) {

    }

    @FXML
    void viewSemesterPlanAsAdvisor(ActionEvent event) {

    }

    @FXML
    void viewStudentHomeAsAdvisor(ActionEvent event) {

    }

 @FXML
    void viewTranscriptAsAdvisor(ActionEvent event) {
        
    }




    @FXML
    private void initialize() {
        AdviseeHomeLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdviseeHomeLabelTrans));
        AdviseeTranscriptLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdviseeTranscriptLabelTrans));
        SemesterPlanLabelTransAdvisee.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelTransAdvisee));
        AdvisingNotesLabelTransAdvisee.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelTransAdvisee));
        ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
    }
  
  private void highlightHyperlink(Hyperlink Hyperlink) {
      // Remove highlighting from all labels
      AdviseeHomeLabelTrans.getStyleClass().remove("highlighted");
      AdviseeTranscriptLabelTrans.getStyleClass().remove("highlighted");
      SemesterPlanLabelTransAdvisee.getStyleClass().remove("highlighted");
      AdvisingNotesLabelTransAdvisee.getStyleClass().remove("highlighted");
  
      // Add highlighting to the clicked label
      Hyperlink.getStyleClass().add("highlighted");
      
  }

  @FXML
  void viewAdvisingNotesasAdvisor() throws IOException {
    App.setRoot("CreateAdvisingNotes");
  }

  @FXML
  void viewStudentHomeasAdvisor() throws IOException {
    App.setRoot("AdviseeHome");
  }

  @FXML
  void viewTranscriptasAdvisor() throws IOException {
    App.setRoot("ViewAdviseeTranscript");
  }

  @FXML
  void viewSemesterPlanAsAdvisor() throws IOException {
    App.setRoot("ViewAdviseeSemesterPlan");
  }

 


}



