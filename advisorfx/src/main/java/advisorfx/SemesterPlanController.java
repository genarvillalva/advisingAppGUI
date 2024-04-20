package advisorfx;

import advising.AuditFacade;
import advising.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    private Label SemOneLabel;

    @FXML
    private Label SemTwoLabel;

    @FXML
    private Label SemThreeLabel;

    @FXML
    private Label SemFourLabel;

    @FXML
    private Label SemFiveLabel;

    @FXML
    private Label SemSixLabel;

    @FXML
    private Label SemSevenLabel;

    @FXML
    private Label SemEightLabel;

    @FXML
    private ListView SemOneList;

    @FXML
    private ListView SemTwoList;

    @FXML
    private ListView SemThreeList;

    @FXML
    private ListView SemFourList;

    @FXML
    private ListView SemFiveList;

    @FXML
    private ListView SemSixList;

    @FXML
    private ListView SemSevenList;

    @FXML
    private ListView SemEightList;

    @FXML
    private ListView SemOneCH;

    @FXML
    private ListView SemTwoCH;

    @FXML
    private ListView SemThreeCH;

    @FXML
    private ListView SemFourCH;

    @FXML
    private ListView SemFiveCH;

    @FXML
    private ListView SemSixCH;

    @FXML
    private ListView SemSevenCH;

    @FXML
    private ListView SemEightCH;

    @FXML
    private void initialize() {
        initializeHyperlinks();
        initializeLogOutBox();
        populateSemesterPlan();
    }

    private void initializeHyperlinks() {
        HomeLabelSem.setOnMouseClicked(event -> highlightHyperlink(HomeLabelSem));
        TranscriptLabelSem.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelSem));
        SemesterPlanLabelSem.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelSem));
        AdvisingNotesLabelSem.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelSem));
    }

    private void initializeLogOutBox() {
        ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
        LogOutBoxSem.setItems(options);
    }

    private void populateSemesterPlan() {
        HashMap<String, ArrayList<Course>> eightSemesterPlan = AuditFacade.getInstance().getStudent().getPortfolio().getEightSemesterPlan();

        for (Map.Entry<String, ArrayList<Course>> entry : eightSemesterPlan.entrySet()) {
            String semester = entry.getKey();
            ArrayList<Course> courses = entry.getValue();
            populateSemesterList(semester, courses);
            populateCreditHoursList(semester, courses);
        }
    }

    private void populateSemesterList(String semester, ArrayList<Course> courses) {
        ListView<String> semesterList = getSemesterListView(semester);
        ObservableList<String> courseNames = FXCollections.observableArrayList();
        courses.forEach(course -> courseNames.add(course.getCourseTitle()));
        semesterList.setItems(courseNames);
    }

    private void populateCreditHoursList(String semester, ArrayList<Course> courses) {
        ListView<String> creditHourList = getCreditHourListView(semester);
        ObservableList<String> creditHours = FXCollections.observableArrayList();
        courses.forEach(course -> creditHours.add(String.valueOf(course.getCreditHours())));
        creditHourList.setItems(creditHours);
    }

    private ListView<String> getSemesterListView(String semester) {
        switch (semester) {
            case "1":
                return SemOneList;
            case "2":
                return SemTwoList;
            case "3":
                return SemThreeList;
            case "4":
                return SemFourList;
            case "5":
                return SemFiveList;
            case "6":
                return SemSixList;
            case "7":
                return SemSevenList;
            case "8":
                return SemEightList;
            default:
                return null;
        }
    }

    private ListView<String> getCreditHourListView(String semester) {
        switch (semester) {
            case "1":
                return SemOneCH;
            case "2":
                return SemTwoCH;
            case "3":
                return SemThreeCH;
            case "4":
                return SemFourCH;
            case "5":
                return SemFiveCH;
            case "6":
                return SemSixCH;
            case "7":
                return SemSevenCH;
            case "8":
                return SemEightCH;
            default:
                return null;
        }
    }

    private void highlightHyperlink(Hyperlink hyperlink) {
        HomeLabelSem.getStyleClass().remove("highlighted");
        TranscriptLabelSem.getStyleClass().remove("highlighted");
        SemesterPlanLabelSem.getStyleClass().remove("highlighted");
        AdvisingNotesLabelSem.getStyleClass().remove("highlighted");
        hyperlink.getStyleClass().add("highlighted");
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

