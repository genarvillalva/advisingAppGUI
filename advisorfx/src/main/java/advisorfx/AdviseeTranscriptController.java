package advisorfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import advising.AuditFacade;
import advising.Course;
import advising.Student;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ListView AdviseeFreshmanGrade;
    @FXML
    private ListView AdviseeSophomoreGrade;
    @FXML
    private ListView AdviseeJuniorGrade;
    @FXML
    private ListView AdviseeSeniorGrade;

    @FXML

    private Student advisee;

    @FXML
    private AdviseeScreenController adviseeScreenController;

    @FXML 
    private ImageView logo;

    public void setAdviseeScreenController(AdviseeScreenController adviseeScreenController) {
        this.adviseeScreenController = adviseeScreenController;
    }

    private void loadAdviseeData(String username) {
        adviseeScreenController.loadAdviseeData(username);
    }




    @FXML
    private void initialize() {
      // Load the image
      Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        
      // Set the image to the ImageView
      logo.setImage(image);
      AdviseeHomeLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdviseeHomeLabelTrans));
      AdviseeTranscriptLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdviseeTranscriptLabelTrans));
      SemesterPlanLabelTransAdvisee.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelTransAdvisee));
      AdvisingNotesLabelTransAdvisee.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelTransAdvisee));
      ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");


      HashMap<String, ArrayList<Course>> eightSemesterPlan = AuditFacade.getInstance().getStudent().getPortfolio().getEightSemesterPlan();
      ObservableList<String> courseNamesFreshman = FXCollections.observableArrayList();
      ObservableList<String> courseNamesSophomore = FXCollections.observableArrayList();
      ObservableList<String> courseNamesJunior = FXCollections.observableArrayList();
      ObservableList<String> courseNamesSenior = FXCollections.observableArrayList();
      
      String studentClass = AuditFacade.getInstance().getStudent().getStudentClass();
      
      for (Map.Entry<String, ArrayList<Course>> entry : eightSemesterPlan.entrySet()) {
        String semester = entry.getKey();
        ArrayList<Course> courses = entry.getValue();
        
        switch (semester) {
          case "1":
            if (studentClass.equals("FRESHMAN")|| studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
              courseNamesFreshman.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
              }
          case "2":
            if (studentClass.equals("FRESHMAN")|| studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
              courseNamesFreshman.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
            }
          case "3":
            if (studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
              courseNamesSophomore.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
            }
          case "4":
            if (studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
              courseNamesSophomore.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
            }
          case "5":
            if (studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
              courseNamesJunior.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
            }
          case "6":
            if (studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
              courseNamesJunior.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
            }
          case "7":
            if (studentClass.equals("SENIOR") ) {
              courseNamesSenior.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
            }
          case "8":
            if (studentClass.equals("SENIOR") ) {
              courseNamesSenior.addAll(courses.stream().map(Course::getCourseTitle).collect(Collectors.toList()));
              break;
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

      for (Map.Entry<String, ArrayList<Course>> entry : eightSemesterPlan.entrySet()) {
        String semester = entry.getKey();
        ArrayList<Course> courses = entry.getValue();
        for (Course course : courses) {
          int courseCreditHours = course.getCreditHours(); 

          switch (semester) {
            case "1":
              if (studentClass.equals("FRESHMAN")|| studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                creditHoursFreshman.add(String.valueOf(courseCreditHours));
                break;
                }
            case "2":
              if (studentClass.equals("FRESHMAN")|| studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                creditHoursFreshman.add(String.valueOf(courseCreditHours));
                break;
              }
            case "3":
              if (studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                creditHoursSophomore.add(String.valueOf(courseCreditHours));
                break;
              }
            case "4":
              if (studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                creditHoursSophomore.add(String.valueOf(courseCreditHours));
                break;
              }
            case "5":
              if (studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                creditHoursJunior.add(String.valueOf(courseCreditHours));
                break;
              }
            case "6":
              if (studentClass.equals("JUNIOR") || studentClass.equals("SENIOR") ) {
                creditHoursJunior.add(String.valueOf(courseCreditHours));
                break;
              }
            case "7":
              if (studentClass.equals("SENIOR") ) {
                creditHoursSenior.add(String.valueOf(courseCreditHours));
                break;
              }
            case "8":
              if (studentClass.equals("SENIOR") ) {
                creditHoursSenior.add(String.valueOf(courseCreditHours));
                break;
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
      
      
      for (Map.Entry<String, ArrayList<Course>> entry : eightSemesterPlan.entrySet()) {
        String semester = entry.getKey();
        ArrayList<Course> courses = entry.getValue();
    
        for (Course course : courses) {
            String courseName = course.getCourseTitle();
            if (completedCourses.containsKey(course)) {
                countGPA++;
                int semesterInt = Integer.parseInt(semester); 
                if (studentClass.equals("FRESHMAN") || studentClass.equals("SOPHOMORE") || studentClass.equals("JUNIOR") || studentClass.equals("SENIOR")) {
                    if (semesterInt == 1 || semesterInt == 2) {
                        Double courseGPA = completedCourses.get(course);
                        gpaFreshman.add(String.valueOf(courseGPA)); 
                    } else if (semesterInt == 3 || semesterInt == 4) {
                        Double courseGPA = completedCourses.get(course);
                        gpaSophomore.add(String.valueOf(courseGPA)); 
                    } else if (semesterInt == 5 || semesterInt == 6) {
                        Double courseGPA = completedCourses.get(course);
                        gpaJunior.add(String.valueOf(courseGPA)); 
                    } else if (semesterInt == 7 || semesterInt == 8) {
                        Double courseGPA = completedCourses.get(course);
                        gpaSenior.add(String.valueOf(courseGPA)); 
                    }
                }
            }
        }
      }

      AdviseeFreshmanGrade.setItems(gpaFreshman);
      AdviseeSophomoreGrade.setItems(gpaSophomore);
      AdviseeJuniorGrade.setItems(gpaJunior);
      AdviseeSeniorGrade.setItems(gpaSenior);
        
  
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

  @FXML
    void logout(ActionEvent event) throws IOException {
        App.setRoot("LoginPage");
    }

 


}



