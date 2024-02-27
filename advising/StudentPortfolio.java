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

  public void requiredCourses(String courseName, String courseNumber) {
    requiredCourses = new ArrayList<>();
    eightSemesterPlan = new HashMap();
    currentCourses = new ArrayList<>();
    completedCourses = new HashMap();
    failedCourses = new HashMap();
    electiveClusterArray = new ArrayList();

  }

  /**
  * Converts the grade into a GPA int
  * @return the int value 0-4 for a singular grade
  */
  public int ConvertLetterGradeToGpa(int grade) {
    if (grade > 100 || grade < 0){
      return 0;
    } else if (grade >= 90) {
      return 4;
    } else if (grade >= 80) {
      return 3;
    } else if (grade >= 70) {
      return 2;
    } else if (grade >= 60) {
      return 1;
    } else {
      return 0;
    }
  }

  public void LookupCourse(String courseName, String courseNumber) {

  }

  public boolean checkClassFailure() {

    return true;
  }

  public String checkScholarship(double gpa, int YearCreditCount) {

    return " ";
  }

  /**
  * Calculates the amount of course credit left for a student to graduate
  * @return the int of total minus completed
  */
  public int calculateCourseCreditLeft(int completedCreditHours, int totalCreditHours) {
    return (totalCreditHours - completedCreditHours);
  }

  public int calculateGPA(HashMap<Course, Integer> completedCourses, int grade) {

    return 0;
  }






	


}
