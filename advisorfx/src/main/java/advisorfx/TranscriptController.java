package advisorfx;

import advising.AuditFacade;
import advising.Course;
import advising.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        initializeHyperlinks();
        initializeLogOutBox();
        initializeTranscript();
    }
    
    private void initializeHyperlinks() {
        HomeLabelTrans.setOnMouseClicked(event -> highlightHyperlink(HomeLabelTrans));
        TranscriptLabelTrans.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelTrans));
        SemesterPlanLabelTrans.setOnMouseClicked(event -> highlightHyperlink(SemesterPlanLabelTrans));
        AdvisingNotesLabelTrans.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelTrans));
    }
    
    private void initializeLogOutBox() {
        ObservableList<String> options = FXCollections.observableArrayList("Settings", "Log Out");
        LogOutBoxTrans.setItems(options);
    }
    
    private void initializeTranscript() {
        populateTranscript();

        FreshmanCourses.setOnMouseClicked(event -> handleListViewItemClick(FreshmanCourses));
        SophomoreCourses.setOnMouseClicked(event -> handleListViewItemClick(SophomoreCourses));
        JuniorCourses.setOnMouseClicked(event -> handleListViewItemClick(JuniorCourses));
        SeniorCourses.setOnMouseClicked(event -> handleListViewItemClick(SeniorCourses));
    }

    private void handleListViewItemClick(ListView<String> listView) {
      String selectedCourseTitle = (String) listView.getSelectionModel().getSelectedItem();
  
      Course selectedCourse = findCourseByTitle(selectedCourseTitle);
      
      if (selectedCourse != null) {
          try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("CourseDetails.fxml"));
              Parent root = loader.load();
              CourseDetailsController controller = loader.getController();
              controller.initData(selectedCourse);
              Stage stage = new Stage();
              stage.setScene(new Scene(root));
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    }
    private Course findCourseByTitle(String courseTitle) {
      HashMap<String, ArrayList<Course>> eightSemesterPlan = AuditFacade.getInstance().getStudent().getPortfolio().getEightSemesterPlan();
      for (Map.Entry<String, ArrayList<Course>> entry : eightSemesterPlan.entrySet()) {
          ArrayList<Course> courses = entry.getValue();
          for (Course course : courses) {
              if (course.getCourseTitle().equals(courseTitle)) {
                  return course;
              }
          }
      }
      return null;
  }
    
    private void populateTranscript() {
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

      FreshmanCourses.setItems(courseNamesFreshman);
      SophomoreCourses.setItems(courseNamesSophomore);
      JuniorCourses.setItems(courseNamesJunior);
      SeniorCourses.setItems(courseNamesSenior);

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
    
    private void highlightHyperlink(Hyperlink hyperlink) {
        // Remove highlighting from all labels
        HomeLabelTrans.getStyleClass().remove("highlighted");
        TranscriptLabelTrans.getStyleClass().remove("highlighted");
        SemesterPlanLabelTrans.getStyleClass().remove("highlighted");
        AdvisingNotesLabelTrans.getStyleClass().remove("highlighted");
    
        // Add highlighting to the clicked label
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