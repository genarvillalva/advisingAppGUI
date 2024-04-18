package advisorfx;

import advising.AuditFacade;
import advising.Course;
import advising.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class TranscriptController {
    @FXML
    private Pane StudentMenuPaneTrans;
    @FXML
    private Hyperlink HomeLabelTrans;

    @FXML
    private Hyperlink TranscriptLabelTrans;

    @FXML
    private Hyperlink SemesterPlanLabelTrans;

    @FXML 
    private Hyperlink AdvisingNotesLabelTrans;

    @FXML
    private ChoiceBox LogOutBoxTrans;

    @FXML
    private Label TranscriptHeader;

    @FXML
    private Label FreshmanLabel;

    @FXML
    private Label SophomoreLabel;

    @FXML
    private Label JuniorLabel;

    @FXML
    private Label SeniorLabel;

    @FXML
    private Label CreditHourLabelF;

    @FXML
    private Label CreditHourLabelSO;

    @FXML
    private Label CreditHourLabelJ;

    @FXML
    private Label CreditHourLabelS;

    @FXML
    private Label GradeLabelF;

    @FXML
    private Label GradeLabelSO;

    @FXML
    private Label GradeLabelJ;

    @FXML
    private Label GradeLabelS;

    @FXML
    private ListView FreshmanCourses;

    @FXML
    private ListView FreshmanCreditHours;

    @FXML
    private ListView FreshmanGrade;

    @FXML
    private ListView SophomoreCourses;

    @FXML
    private ListView SophomoreCreditHours;

    @FXML
    private ListView SophomoreGrade;

    @FXML
    private ListView JuniorCourses;

    @FXML
    private ListView JuniorCreditHours;

    @FXML
    private ListView JuniorGrade;

    @FXML
    private ListView SeniorCourses;

    @FXML
    private ListView SeniorCreditHours;

    @FXML
    private ListView SeniorGrade;


    @FXML
    private void initialize() {
      HomeLabelTrans.setOnMouseClicked(event -> highlightHyperlink(HomeLabelTrans));
      TranscriptLabelTrans.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelTrans));
      SemesterPlanLabelTrans.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelTrans));
      AdvisingNotesLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelTrans));
      ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
      LogOutBoxTrans.setItems(options);
      

      HashMap<String, ArrayList<Course>> eightSemesterPlan = AuditFacade.getInstance().getStudent().getPortfolio().getEightSemesterPlan();
      ObservableList<String> courseNamesFreshman = FXCollections.observableArrayList();
      ObservableList<String> courseNamesSophomore = FXCollections.observableArrayList();
      ObservableList<String> courseNamesJunior = FXCollections.observableArrayList();
      ObservableList<String> courseNamesSenior = FXCollections.observableArrayList();
      
      String studentClass = AuditFacade.getInstance().getStudent().getStudentClass();
      
      int count = 0;
      for (ArrayList<Course> courses : eightSemesterPlan.values()) {
          for (Course course : courses) {
              String courseName = course.getCourseTitle(); 
              count++;
              if (studentClass.equals("FRESHMAN")|| studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                  if (count <= 10 ) {
                      courseNamesFreshman.add(courseName);
                  }
              } if (studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR")) {
                  if (count <= 20 && count > 10) {
                      courseNamesSophomore.add(courseName);
                  }
              } if (studentClass.equals("JUNIOR") || studentClass.equals("SENIOR")) {
                  if (count <= 30 && count > 20) {
                      courseNamesJunior.add(courseName);
                  }
              } if (studentClass.equals("SENIOR")) {
                  if (count <= 40 && count > 30) {
                      courseNamesSenior.add(courseName);
                  }
              }
          }
      }

      FreshmanCourses.setItems(courseNamesFreshman);
      SophomoreCourses.setItems(courseNamesSophomore);
      JuniorCourses.setItems(courseNamesJunior);
      SeniorCourses.setItems(courseNamesSenior);

      ObservableList<String> creditHoursFreshman = FXCollections.observableArrayList();
      ObservableList<String> creditHoursSophomore = FXCollections.observableArrayList();
      ObservableList<String> creditHoursJunior = FXCollections.observableArrayList();
      ObservableList<String> creditHoursSenior = FXCollections.observableArrayList();

      int countCredit = 0;
      for (ArrayList<Course> courses : eightSemesterPlan.values()) {
        for (Course course : courses) {
          int courseCreditHours = course.getCreditHours(); 
          countCredit++;
          if (studentClass.equals("FRESHMAN")|| studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
              if (countCredit <= 10 ) {
                creditHoursFreshman.add(String.valueOf(courseCreditHours));
              }
          } if (studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR")) {
              if (countCredit <= 20 && countCredit > 10) {
                creditHoursSophomore.add(String.valueOf(courseCreditHours));
              }
          } if (studentClass.equals("JUNIOR") || studentClass.equals("SENIOR")) {
              if (countCredit <= 30 && countCredit > 20) {
                creditHoursJunior.add(String.valueOf(courseCreditHours));
              }
          } if (studentClass.equals("SENIOR")) {
              if (countCredit <= 40 && countCredit > 30) {
                creditHoursSenior.add(String.valueOf(courseCreditHours));
              }
          }
        }
      }
      
      FreshmanCreditHours.setItems(creditHoursFreshman);
      SophomoreCreditHours.setItems(creditHoursSophomore);
      JuniorCreditHours.setItems(creditHoursJunior);
      SeniorCreditHours.setItems(creditHoursSenior);

      ObservableList<String> gpaFreshman = FXCollections.observableArrayList();
      ObservableList<String> gpaSophomore = FXCollections.observableArrayList();
      ObservableList<String> gpaJunior = FXCollections.observableArrayList();
      ObservableList<String> gpaSenior = FXCollections.observableArrayList();
      int countGPA = 0;
      HashMap<Course, Double> completedCourses = AuditFacade.getInstance().getStudent().getPortfolio().getCompletedCourses();
      
      
      for (ArrayList<Course> courses : eightSemesterPlan.values()) {
        for (Course course : courses) {
          String courseName = course.getCourseTitle();
          if (completedCourses.containsKey(course)) {
            countGPA++;
            if (studentClass.equals("FRESHMAN")|| studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                if (countGPA <= 10 ) {
                  Double courseGPA = completedCourses.get(course);
                  gpaFreshman.add(String.valueOf(courseGPA)); 
                }
            } if (studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR")) {
                if (countGPA <= 20 && countGPA > 10) {
                  Double courseGPA = completedCourses.get(course);
                  gpaSophomore.add(String.valueOf(courseGPA)); 
                }
            } if (studentClass.equals("JUNIOR") || studentClass.equals("SENIOR")) {
                if (countGPA <= 30 && countGPA > 20) {
                  Double courseGPA = completedCourses.get(course);
                  gpaJunior.add(String.valueOf(courseGPA)); 
                }
            } if (studentClass.equals("SENIOR")) {
                if (countGPA <= 40 && countGPA > 30) {
                  Double courseGPA = completedCourses.get(course);
                  gpaSenior.add(String.valueOf(courseGPA)); 
                }
              }

          } 
        }
      }

      FreshmanGrade.setItems(gpaFreshman);
      SophomoreGrade.setItems(gpaSophomore);
      JuniorGrade.setItems(gpaJunior);
      SeniorGrade.setItems(gpaSenior);
      

    }
  
  private void highlightHyperlink(Hyperlink Hyperlink) {
      // Remove highlighting from all labels
      HomeLabelTrans.getStyleClass().remove("highlighted");
      TranscriptLabelTrans.getStyleClass().remove("highlighted");
      SemesterPlanLabelTrans.getStyleClass().remove("highlighted");
      AdvisingNotesLabelTrans.getStyleClass().remove("highlighted");
  
      // Add highlighting to the clicked label
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