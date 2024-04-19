package advisorfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import advising.AuditFacade;
import advising.Course;
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
    private ListView AdviseeFreshmanCourses;

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
    private ListView AdviseeJuniorCourses;

    @FXML
    private Label AdviseeJuniorLabel;

    @FXML
    private ListView AdviseeSeniorCourses;

    @FXML
    private Label AdviseeSeniorLabel;

   
   
   
    @FXML
    private ListView AdviseeSophomoreCourses;

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
    private ListView AdviseeSeniorCreditHours;
    @FXML
    private ListView AdviseeJuniorCreditHours;
    @FXML
    private ListView AdviseeSophomoreCreditHours;
    @FXML
    private ListView AdviseeFreshmanCreditHours;


    @FXML
    private ListView FreshmanGrade;
    @FXML
    private ListView SophomoreGrade;
    @FXML
    private ListView JuniorGrade;
    @FXML
    private ListView Senior;


 

    @FXML
    private void initialize() {
        AdviseeHomeLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdviseeHomeLabelTrans));
        AdviseeTranscriptLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdviseeTranscriptLabelTrans));
        SemesterPlanLabelTransAdvisee.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelTransAdvisee));
        AdvisingNotesLabelTransAdvisee.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelTransAdvisee));
        ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
/* 
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

      AdviseeFreshmanCourses.setItems(courseNamesFreshman);
      AdviseeSophomoreCourses.setItems(courseNamesSophomore);
      AdviseeJuniorCourses.setItems(courseNamesJunior);
      AdviseeSeniorCourses.setItems(courseNamesSenior);

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
      
      AdviseeFreshmanCreditHours.setItems(creditHoursFreshman);
      AdviseeSophomoreCreditHours.setItems(creditHoursSophomore);
      AdviseeJuniorCreditHours.setItems(creditHoursJunior);
      AdviseeSeniorCreditHours.setItems(creditHoursSenior);

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
      


    
      */



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
    System.out.println("viewTranscriptasAdvisor() method called.");
    System.out.println("Before setRoot - current root: " + App.getCurrentRoot()); // Get the current root

      App.setRoot("CreateAdvisingNotes");


      System.out.println("After setRoot - new root: " + App.getCurrentRoot()); // Get the new root after setting
      System.out.println("exited setroot");
  }
  

  @FXML
  void viewStudentHomeasAdvisor() throws IOException {
    App.setRoot("AdviseeScreen");
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



