package advisorfx;

import advising.AuditFacade;
import advising.Course;
import advising.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private Label CreditHoursOne;

    @FXML
    private Label CreditHoursTwo;

    @FXML
    private Label CreditHoursThree;

    @FXML
    private Label CreditHoursFour;

    @FXML
    private Label CreditHoursFive;

    @FXML
    private Label CreditHoursSix;

    @FXML
    private Label CreditHoursSeven;

    @FXML
    private Label CreditHoursEight;

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
    HomeLabelSem.setOnMouseClicked(event -> highlightHyperlink(HomeLabelSem));
    TranscriptLabelSem.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelSem));
    SemesterPlanLabelSem.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelSem));
    AdvisingNotesLabelSem.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelSem));
    ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
    LogOutBoxSem.setItems(options);

    HashMap<String, ArrayList<Course>> eightSemesterPlan = AuditFacade.getInstance().getStudent().getPortfolio().getEightSemesterPlan();
    ObservableList<String> courseNamesSemOne = FXCollections.observableArrayList();
    ObservableList<String> courseNamesSemTwo = FXCollections.observableArrayList();
    ObservableList<String> courseNamesSemThree = FXCollections.observableArrayList();
    ObservableList<String> courseNamesSemFour = FXCollections.observableArrayList();
    ObservableList<String> courseNamesSemFive = FXCollections.observableArrayList();
    ObservableList<String> courseNamesSemSix = FXCollections.observableArrayList();
    ObservableList<String> courseNamesSemSeven = FXCollections.observableArrayList();
    ObservableList<String> courseNamesSemEight = FXCollections.observableArrayList();
    
    for (Map.Entry<String, ArrayList<Course>> entry : eightSemesterPlan.entrySet()) {
      String semester = entry.getKey();
      ArrayList<Course> courses = entry.getValue();
      
      switch (semester) {
        case "1":
          courseNamesSemOne.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        case "2":
          courseNamesSemTwo.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        case "3":
          courseNamesSemThree.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        case "4":
          courseNamesSemFour.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        case "5":
          courseNamesSemFive.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        case "6":
          courseNamesSemSix.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        case "7":
          courseNamesSemSeven.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        case "8":
          courseNamesSemEight.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
          break;
        default:

          break;
      }
    }

    SemOneList.setItems(courseNamesSemOne);
    SemTwoList.setItems(courseNamesSemTwo);
    SemThreeList.setItems(courseNamesSemThree);
    SemFourList.setItems(courseNamesSemFour);
    SemFiveList.setItems(courseNamesSemFive);
    SemSixList.setItems(courseNamesSemSix);
    SemSevenList.setItems(courseNamesSemSeven);
    SemEightList.setItems(courseNamesSemEight);


    ObservableList<String> creditHourSemOne = FXCollections.observableArrayList();
    ObservableList<String> creditHourSemTwo = FXCollections.observableArrayList();
    ObservableList<String> creditHourSemThree = FXCollections.observableArrayList();
    ObservableList<String> creditHourSemFour = FXCollections.observableArrayList();
    ObservableList<String> creditHourSemFive = FXCollections.observableArrayList();
    ObservableList<String> creditHourSemSix = FXCollections.observableArrayList();
    ObservableList<String> creditHourSemSeven = FXCollections.observableArrayList();
    ObservableList<String> creditHourSemEight = FXCollections.observableArrayList();

    for (Map.Entry<String, ArrayList<Course>> entry : eightSemesterPlan.entrySet()) {
      String semester = entry.getKey();
      ArrayList<Course> courses = entry.getValue();
      
      switch (semester) {
        case "1":
          creditHourSemOne.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        case "2":
          creditHourSemTwo.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        case "3":
          creditHourSemThree.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        case "4":
          creditHourSemFour.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        case "5":
          creditHourSemFive.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        case "6":
          creditHourSemSix.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        case "7":
          creditHourSemSeven.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        case "8":
          creditHourSemEight.addAll(courses.stream().map(course -> String.valueOf(course.getCreditHours())).collect(Collectors.toList()));
          break;
        default:

          break;
      }
    }

    SemOneCH.setItems(creditHourSemOne);
    SemTwoCH.setItems(creditHourSemTwo);
    SemThreeCH.setItems(creditHourSemThree);
    SemFourCH.setItems(creditHourSemFour);
    SemFiveCH.setItems(creditHourSemFive);
    SemSixCH.setItems(creditHourSemSix);
    SemSevenCH.setItems(creditHourSemSeven);
    SemEightCH.setItems(creditHourSemEight);

  }
  


  private void highlightHyperlink(Hyperlink Hyperlink) {
      HomeLabelSem.getStyleClass().remove("highlighted");
      TranscriptLabelSem.getStyleClass().remove("highlighted");
      SemesterPlanLabelSem.getStyleClass().remove("highlighted");
      AdvisingNotesLabelSem.getStyleClass().remove("highlighted");
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

