package advising;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentPortfolio {
  private String portfolioUUID;
  private double gpa;
  private int failCount;
  private int semesterCreditCount;
  private ArrayList<Course> requiredCourses;
  private HashMap<String, ArrayList<Course>> eightSemesterPlan;
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
    String portfolioUUID,
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
    this.semesterCreditCount = semesterCreditCount;
    this.failCount = failCount;
    this.gpa = gpa;
    this.portfolioUUID = portfolioUUID;
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
  /**
   * Returns the student's portfolio UUID
   * @return student's UUID 
   */
  public String getPortfolioUUID() {
    return portfolioUUID;
}
/**
 * Returns the student's required courses
 * @return student's required courses
 */
public ArrayList<Course> getRequiredCourses() {
    return requiredCourses;
}
/**
 * Returns the student's eight semester plan
 * @return student's eight semester plan
 */
public HashMap<String, ArrayList<Course>> getEightSemesterPlan() {
    return eightSemesterPlan;
}
/**
 * Returns the the UUID of student's portfolio
 * @return the UUID of student's portfolio
 */
public String getUUID() {
    return portfolioUUID;
}
/**
 * Returns the student's current courses
 * @return student's current courses
 */
public ArrayList<Course> getCurrentCourses() {
    return currentCourses;
}
/**
 * Returns the student's completed courses
 * @return student's completed courses
 */
public HashMap<Course, Double> getCompletedCourses() {
    return completedCourses;
}
/**
 * Returns the student's failed courses
 * @return student's failed courses
 */
public HashMap<Course, Integer> getFailedCourses() {
    return failedCourses;
}
/**
 * Returns the student's scholarship
 * @return student's scholarship
 */
public String getScholarship() {
    return scholarship;
}
/**
 * Returns the student's scholarship credit hours left
 * @return student's scholarship credit hours left
 */
public int getScholarshipCreditHoursLeft() {
    return scholarshipCreditHoursLeft;
}
/**
 * Returns the student's GPA
 * @return student's GPA
 */
public double getGpa() {
    return gpa;
}
/**
 * Returns the student's fail count
 * @return student's fail count
 */
public int getFailCount() {
    return failCount;
}
/**
 * Returns the student's semester credit count
 * @return student's semester credit count
 */
public int getSemesterCreditCount() {
    return semesterCreditCount;
}
/**
 * Returns the student's year credit count
 * @return student's year credit count
 */
public int getYearCreditCount() {
    return yearCreditCount;
}
/**
 * Returns the student's total credit hours
 * @return student's total credit hours
 */
public int getTotalCreditHours() {
    return totalCreditHours;
}
/**
 * Returns the student's total credit hours for FoundDocuments
 * @return student's total credit hours for FoundDocuments
 */
public int getTotalCreditHoursFoundDocu() {
    return totalCreditHoursFoundDocu;
}
/**
 * Returns the student's total credit hours CC
 * @return student's total credit hours CC
 */
public int getTotalCreditHoursCC() {
    return totalCreditHoursCC;
}
/**
 * Returns the student's total credit hours for IntegrativeCourse
 * @return student's total credit hours for IntegrativeCourse
 */
public int getTotalCreditHoursIntegrativeCourse() {
    return totalCreditHoursIntegrativeCourse;
}
/**
 * Returns the student's total credit hours for ProgramRequirements
 * @return student's total credit hours for ProgramRequirements
 */
public int getTotalCreditHoursProgramRequirements() {
    return totalCreditHoursProgramRequirements;
}
/**
 * Returns the student's total credit hours for MajorRequirements
 * @return student's total credit hours for MajorRequirements
 */
public int getTotalCreditHoursMajorRequirements() {
    return totalCreditHoursMajorRequirements;
}
/**
 * Returns the student's elective cluster array
 * @return student's elective cluster array
 */
public ArrayList<ElectiveCluster> getElectiveClusterArray() {
    return electiveClusterArray;
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

  /**
   * Adds a course to the student's portfolio.
   * 
   * @param course The course to be added to the portfolio.
   */
  public void addCourse(Course course) {
    requiredCourses.add(course);
  }

  /**
  * Checks to make sure the students grade in the class is not failing
  * @return true if student is failing and false if student is passing
  */
  public boolean checkClassFailure(int grade) {
    if (grade < 60) {
      return true;
    } else {
      return false;
    }
  }

  /**
  * Checks to make sure the student has done all scholarship requirements
  * @return true if requirements are met and false if not
  */
  public boolean checkScholarship(double gpa, int YearCreditCount) {
    if (gpa > 3.0 && YearCreditCount >= 30) {
      return true;
    } else {
      return false;
    }
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

  public double calculateGPA( HashMap<Course, Integer> completedCourses) {
    double totalQualityPoints = 0.0;
    int totalCredits = 0;

    // Iterate through each completed course
    for (Map.Entry<Course, Integer> entry : completedCourses.entrySet()) {
        Course course = entry.getKey();
        int grade = entry.getValue();

        // Convert letter grade to GPA
        int gpa = ConvertLetterGradeToGpa(grade);

        // Get credits for the course
        int credits = course.getCreditHours();

        // Calculate quality points for the course
        double qualityPoints = gpa * credits;

        // Add quality points to total
        totalQualityPoints += qualityPoints;

        // Add credits to total
        totalCredits += credits;
    }

    // Calculate GPA
    if (totalCredits > 0) {
        return totalQualityPoints / totalCredits;
    } else {
        return 0.0; // Prevent division by zero
    }
  }

  public String toString() {
    String result =  (
      "StudentPortfolio: " +
      "\nportfolioUUID='" +
      portfolioUUID +
      "\nrequiredCourses=" +
      requiredCourses +
      "\neightSemesterPlan=" +
      
      "\ncurrentCourses=" +
      currentCourses +
      "\ncompletedCourses=" +
      completedCourses +
      "\nfailedCourses=" +
      failedCourses +
      "\nscholarship='" +
      scholarship +
      '\'' +
      "\n, gpa=" +
      gpa +
      ", failCount=" +
      failCount +
      ", semesterCreditCount=" +
      semesterCreditCount +
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
      electiveClusterArray + '\n'
    );
    return result;
  }
}
