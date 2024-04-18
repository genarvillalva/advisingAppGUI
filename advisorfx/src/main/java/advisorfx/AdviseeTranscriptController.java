package advisorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

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
    void signOutStudent(ActionEvent event) {

    }

    @FXML
    void viewAdvisingNotesasAdvisor(ActionEvent event) {

    }

    @FXML
    void viewSemesterPlanAsAdvisor(ActionEvent event) {

    }

    @FXML
    void viewStudentHome(ActionEvent event) {

    }

    @FXML
    void viewTranscriptasAdvisor(ActionEvent event) {

    }

}
