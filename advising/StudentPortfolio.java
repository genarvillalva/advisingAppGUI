package advising;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentPortfolio {

  private ArrayList<Course> requiredCourses;
  private HashMap eightSemesterPlan;
  private ArrayList<Course> currentCourses;
  //Completed Course method?
  private HashMap<Course, Double> completedCourses;
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

  public StudentPortfolio(
    String portolioUUID,
    ArrayList<Course> requiredCourses,
    HashMap<String, ArrayList<Course>> eightSemesterPlan,
    ArrayList<Course> currentCourses,
    HashMap<Course, Double> completedCourses,
    HashMap<Course, Integer> failedCourses,
    String scholarship,
    int scholarshipCreditHoursLeft,
    double gpa,
    int failCount,
    int semesterCreditCount,
    int yearCreditCount,
    int totalCreditHours,
    int totalCreditHoursFoundDocu,
    int totalCreditHoursCC,
    int totalCreditHoursIntegrativeCourse,
    int totalCreditHoursProgramRequirements,
    int totalCreditHoursMajorRequirements,
    ArrayList<ElectiveCluster> electiveClusterArray
  ) {
    this.requiredCourses = requiredCourses;
    this.eightSemesterPlan = eightSemesterPlan;
    this.currentCourses = currentCourses;
    this.completedCourses = completedCourses;
    this.failedCourses = failedCourses;
    this.scholarship = scholarship;
    this.scholarshipCreditHoursLeft = scholarshipCreditHoursLeft;
    this.yearCreditCount = yearCreditCount;
    this.totalCreditHours = totalCreditHours;
    this.totalCreditHoursFoundDocu = totalCreditHoursFoundDocu;
    this.totalCreditHoursCC = totalCreditHoursCC;
    this.totalCreditHoursIntegrativeCourse = totalCreditHoursIntegrativeCourse;
    this.totalCreditHoursProgramRequirements =
      totalCreditHoursProgramRequirements;
    this.totalCreditHoursMajorRequirements = totalCreditHoursMajorRequirements;
    this.electiveClusterArray = electiveClusterArray;
  }

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
    if (grade > 100 || grade < 0) {
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

  public void LookupCourse(String courseName, String courseNumber) {}

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
  public int calculateCourseCreditLeft(
    int completedCreditHours,
    int totalCreditHours
  ) {
    return (totalCreditHours - completedCreditHours);
  }

  public int calculateGPA(
    HashMap<Course, Integer> completedCourses,
    int grade
  ) {
    return 0;
  }

  public String toString() {
    return (
      "StudentPortfolio: " +
      "\nrequiredCourses=" +
      requiredCourses +
      "\neightSemesterPlan=" +
      eightSemesterPlan +
      "\ncurrentCourses=" +
      currentCourses +
      "\ncompletedCourses=" +
      completedCourses +
      "\nfailedCourses=" +
      failedCourses +
      "\nscholarship='" +
      scholarship +
      '\'' +
      ", scholarshipCreditHoursLeft=" +
      scholarshipCreditHoursLeft +
      "\n yearCreditCount=" +
      yearCreditCount +
      ", totalCreditHours=" +
      totalCreditHours +
      ", totalCreditHoursFoundDocu=" +
      totalCreditHoursFoundDocu +
      ", totalCreditHoursCC=" +
      totalCreditHoursCC +
      ", totalCreditHoursIntegrativeCourse=" +
      totalCreditHoursIntegrativeCourse +
      ", totalCreditHoursProgramRequirements=" +
      totalCreditHoursProgramRequirements +
      ", totalCreditHoursMajorRequirements=" +
      totalCreditHoursMajorRequirements +
      "\n electiveClusterArray=" +
      electiveClusterArray 
    );
  }
}
