package advising;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentPortfolio {
      
  private ArrayList<Course> requiredCourses;
  private HashMap eightSemesterPlan;
  private ArrayList<Course> currentCourses;
  //Completed Course method?
  private HashMap<Course, Integer> completedCourses;
  private HashMap<Course, Integer> failedCourses;
  private String scholarship;
  private int scholarshipCreditHoursLeft;
  private int yearCreditCount;
  private int totalCreditHours;
  private int totalCreditHoursFoundDocu;
  private int totalCreditHoursCC;
  private int totalCreditHoursIntegrativeCourse;
  private int totalCreditHoursProgramRequirements;
  private int totalCreditHoursMajorRequirements;
  private ArrayList<ElectiveCluster> electiveClusterArray;

  //not sure about return type for requiredCourse and CompletedCourse as not specified on UML
  public void requiredCourses(String courseName, String courseNumber) {
    requiredCourses = new ArrayList<>();
    eightSemesterPlan = new HashMap();
    currentCourses = new ArrayList<>();
    completedCourses = new HashMap();
    failedCourses = new HashMap();

  }

  public void CompletedCourse(String courseName, String courseNumber, int creditHours, char Grade) {
    
  }

  public void AddCompletedCourse(CompletedCourse course) {
    
  }

  public boolean ConvertLetterGradeToGpa(int grade) {
    
    return true;
  }

  public void LookupCourse(String courseName, String courseNumber) {

  }

  public boolean checkClassFailure() {

    return true;
  }

  public String checkScholarship(double gpa, int YearCreditCount) {

    return " ";
  }

  public int calculateCourseCreditLeft(int completedCreditHours, int totalCreditHours) {

    return 0;
  }

  public int calculateGPA(ArrayList<completedCourses> completedCourses , int grade) {

    return 0;
  }






	


}
