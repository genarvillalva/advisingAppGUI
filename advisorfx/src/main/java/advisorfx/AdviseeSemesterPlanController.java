package advisorfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    private ListView FreshmanCourses1Advisee;

    @FXML
    private ListView FreshmanCoursesAdvisee;

    @FXML
    private Pane GpaPaneAdvisee;

    @FXML
    private Hyperlink HomeLabelSemAdvisee;

    @FXML
    private ListView JuniorCourses1Advisee;

    @FXML
    private ListView JuniorCoursesAdvisee;

    @FXML
    private ChoiceBox<?> LogOutBoxSemAdvisee;

    @FXML
    private ListView SemEightLabelAdvisee;

    @FXML
    private ListView SemFiveLabelAdvisee;

    @FXML
    private ListView SemFourLabelAdvisee;

    @FXML
    private ListView SemOneLabelAdvisee;

    @FXML
    private ListView SemSevenLabelAdvisee;

    @FXML
    private ListView SemSixLabelAdvisee;

    @FXML
    private ListView SemThreeLabelAdvisee;

    @FXML
    private ListView SemTwoLabelAdvisee;

    @FXML
    private Hyperlink SemesterPlanLabelSemAdvisee;

    @FXML
    private ListView SeniorCourses1Advisee;

    @FXML
    private ListView SeniorCoursesAdvisee;

    @FXML
    private ListView SophomoreCourses1Advisee;

    @FXML
    private ListView SophomoreCoursesAdvisee;

    @FXML
    private Pane StudentMenuPaneSemAdvisee;

    @FXML
    private Label TranscriptHeaderAdvisee;

    @FXML
    private Hyperlink TranscriptLabelSemAdvisee;

    @FXML
    private AdviseeScreenController adviseeScreenController;

    public void setAdviseeScreenController(AdviseeScreenController adviseeScreenController) {
        this.adviseeScreenController = adviseeScreenController;
    }

    private void loadAdviseeData(String username) {
        adviseeScreenController.loadAdviseeData(username);
    }


        @FXML
    private void initialize() {
      HomeLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(HomeLabelSemAdvisee));
      TranscriptLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelSemAdvisee));
      SemesterPlanLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelSemAdvisee));
      AdvisingNotesLabelSemAdvisee.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelSemAdvisee));
      ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");


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
  
      FreshmanCoursesAdvisee.setItems(courseNamesSemOne);
      FreshmanCourses1Advisee.setItems(courseNamesSemTwo);
      SophomoreCoursesAdvisee.setItems(courseNamesSemThree);
      SophomoreCourses1Advisee.setItems(courseNamesSemFour);
      JuniorCoursesAdvisee.setItems(courseNamesSemFive);
      JuniorCourses1Advisee.setItems(courseNamesSemSix);
      SeniorCoursesAdvisee.setItems(courseNamesSemSeven);
      SeniorCourses1Advisee.setItems(courseNamesSemEight);
  
  
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
  
      SemOneLabelAdvisee.setItems(creditHourSemOne);
      SemTwoLabelAdvisee.setItems(creditHourSemTwo);
      SemThreeLabelAdvisee.setItems(creditHourSemThree);
      SemFourLabelAdvisee.setItems(creditHourSemFour);
      SemFiveLabelAdvisee.setItems(creditHourSemFive);
      SemSixLabelAdvisee.setItems(creditHourSemSix);
      SemSevenLabelAdvisee.setItems(creditHourSemSeven);
      SemEightLabelAdvisee.setItems(creditHourSemEight);

      
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
    void logout(ActionEvent event) throws IOException {
        App.setRoot("LoginPage");
    }

    @FXML
    void viewTranscriptasAdvisor() throws IOException {
        App.setRoot("ViewAdviseeTranscript");
    }




}
