package advising;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentPortfolio {

  private String portfolioUUID;
  private double gpa;
  private int failCount;
  private int semesterCreditCount;
  private ArrayList<Course> requiredCourses;
  private HashMap<String, ArrayList<Course>> eightSemesterPlan;
  private ArrayList<Course> nextSemesterCourses;
  private ArrayList<Course> currentCourses;
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
  private StudentElectives studentElectives;

  /**
   * Constructor for the StudentPortfolio class with default values
   */
  public StudentPortfolio(String username) {
    this.portfolioUUID = username;
    this.requiredCourses = new ArrayList<Course>();
    this.currentCourses = new ArrayList<Course>();
    this.nextSemesterCourses = new ArrayList<Course>();
    this.completedCourses = new HashMap<Course, Double>();
    this.failedCourses = new HashMap<Course, Integer>();
    this.scholarship = "";
    this.scholarshipCreditHoursLeft = 0;
    this.gpa = 0.0;
    this.failCount = 0;
    this.semesterCreditCount = 0;
    this.yearCreditCount = 0;
    this.totalCreditHours = 0;
    this.totalCreditHoursFoundDocu = 0;
    this.totalCreditHoursCC = 0;
    this.totalCreditHoursIntegrativeCourse = 0;
    this.totalCreditHoursProgramRequirements = 0;
    this.totalCreditHoursMajorRequirements = 0;
    this.studentElectives = new StudentElectives(username);
  }

  public StudentPortfolio(
    String portfolioUUID,
    ArrayList<Course> requiredCourses,
    HashMap<String, ArrayList<Course>> eightSemesterPlan,
    ArrayList<Course> currentCourses,
    ArrayList<Course> nextSemesterCourses,
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
    StudentElectives electiveCluster
  ) {
    this.semesterCreditCount = semesterCreditCount;
    this.failCount = failCount;
    this.gpa = gpa;
    this.portfolioUUID = portfolioUUID;
    this.requiredCourses = requiredCourses;
    this.eightSemesterPlan = eightSemesterPlan;
    this.currentCourses = currentCourses;
    this.nextSemesterCourses = nextSemesterCourses;
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
    this.studentElectives = electiveCluster;
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

  public StudentElectives getStudentElectives() {
    return studentElectives;
  }

  public void addCurrentCourse(Course course) {
    currentCourses.add(course);
  }

  /**
   * Adds a course to the student's next semester courses
   * @param course The course to be added to the next semester
   */
  public void addNextSemesterCourse(Course course) {
    nextSemesterCourses.add(course);
  }

  /**
   * Returns the student's eight semester plan
   * @return student's eight semester plan
   */
  public HashMap<String, ArrayList<Course>> getEightSemesterPlan() {
    return eightSemesterPlan;
  }

  /**
   * Returns the student's next semester courses
   * @return student's next semester courses
   */
  public ArrayList<Course> getNextSemesterCourses() {
    return nextSemesterCourses;
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

  public String getSemester() {
    int totalCreditHours = getTotalCreditHours();

    // Calculate semester based on total credit hours
    int semesterNumber = (totalCreditHours / 15) + 1;

    // Convert the semester number to a String representation
    String semester = String.valueOf(semesterNumber);

    return semester;
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

  //public void LookupCourse(String courseName, String courseNumber) {}

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
    if (grade < 60 && grade > 100) {
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
    if (gpa > 3.0 && YearCreditCount >= 30 && gpa < 4.0) {
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
    if(totalCreditHours >= completedCreditHours){
      return (totalCreditHours - completedCreditHours);
    }else{
      return 0;
    }
  }

  public double calculateGPA(HashMap<Course, Integer> completedCourses) {
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
    String result =
      (
        "StudentPortfolio: " +
        "\nportfolioUUID='" +
        portfolioUUID +
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
        "\n studentElectives=" +
        studentElectives +
        '\n'
      );
    return result;
  }

  /**
   * Prints the values from student portfolio to the terminal
   */
  public static void printAllStudentPortfolios() {
    ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
    if (studentPortfolios != null) {
      for (StudentPortfolio portfolio : studentPortfolios) {
        //System.out.println("Portfolio UUID: " + portfolio.getPortfolioUUID());
        //System.out.println("Required Courses: " + portfolio.getRequiredCourses());
        System.out.println("\nEight Semester Plan:");
        portfolio
          .getEightSemesterPlan()
          .forEach((semester, courses) -> {
            System.out.print("\nSemester " + semester + ": ");
            courses.forEach(course -> System.out.print(course + ", "));
            System.out.println();
          });
        System.out.println("Completed Courses: ");
        portfolio
          .getCompletedCourses()
          .forEach((course, grade) -> {
            System.out.println(course + "-Grade: " + grade);
          });
        System.out.println(
          "\nCurrent Courses: " + portfolio.getCurrentCourses()
        );
        System.out.println("\nFailed Courses: " + portfolio.getFailedCourses());
        //System.out.println("Scholarship: " + portfolio.getScholarship());
        //System.out.println("Yearly Scholarship Credit Hours Left: " + portfolio.getYearlyScholarshipCreditHoursLeft());
        //System.out.println("\nGPA: " + portfolio.getGpa());
        //System.out.println("Fail Count: " + portfolio.getFailCount());
        System.out.println(
          "Semester Credit Count: " + portfolio.getSemesterCreditCount()
        );
        //System.out.println("Year Credit Hours: " + portfolio.getYearCreditHours());
        System.out.println(
          "Total Credit Hours: " + portfolio.getTotalCreditHours()
        );
        //System.out.println("Total Credit Hours Found Docu: " + portfolio.getTotalCreditHoursFoundDocu());
        //System.out.println("Total Credit Hours CC: " + portfolio.getTotalCreditHoursCC());
        //System.out.println("Total Credit Hours Integrative Course: " + portfolio.getTotalCreditHoursIntegrativeCourse());
        //System.out.println("Total Credit Hours Program Requirements: " + portfolio.getTotalCreditHoursProgramRequirements());
        //System.out.println("Total Credit Hours Major Requirements: " + portfolio.getTotalCreditHoursMajorRequirements());
        //System.out.println("Student Electives: " + portfolio.getStudentElectives());
        System.out.println(
          "-----------------------------------------------------------"
        );
      }
    } else {
      System.out.println("No student portfolios found.");
    }
  }

  ///////////////////////////////////////////////////////

  /**
   * Generates an 8-semester plan
   */
  public void generateEightSemesterPlan() {
    // Major required courses
    Student currentStudent = UserList
      .getInstance()
      .getStudentByUsername(portfolioUUID);
    Major studentMajor = MajorList
      .getInstance()
      .getMajor(currentStudent.getMajor());
    ArrayList<Course> majorRequiredCourses = studentMajor.getRequiredCourses();

    HashMap<String, ArrayList<Course>> eightSemesterPlanTemp = new HashMap<String, ArrayList<Course>>();
    HashMap<Course, Double> completedCourses = getCompletedCourses();
    ArrayList<Course> currentCourses = getCurrentCourses();
    Double currentSemesterDouble = 0.0;
    String currentSemester = "1";

    if(currentStudent.getMajor().equals("Computer_Science")) {
      //if student has completed courses / is not a freshman
      if (completedCourses != null) {
        // for (Course course : completedCourses.keySet()) {
        //   currentSemesterDouble += course.getCreditHours();
        // }
        // currentSemester = (int) ((currentSemesterDouble / 15)+1.5);

        String studentYear = currentStudent.getStudentClass();
        if (studentYear.equals("FRESHMAN")) {
          currentSemester = "1";
        } else if (studentYear.equals("SOPHOMORE")) {
          currentSemester = "3";
        } else if (studentYear.equals("JUNIOR")) {
          currentSemester = "5";
        } else if (studentYear.equals("SENIOR")) {
          currentSemester = "7";
        }

        int semHours = 0;
        //Current Courses
        // System.out.println("\n\nTEST" + currentSemester + "\n\n currentSemester" + currentSemester);



        // eightSemesterPlanTemp.put(currentSemester, currentCourses);




        // adding completed courses to the plan
        int currentSemesterIntA = Integer.parseInt(currentSemester);
        for (int i = 1; i < currentSemesterIntA; i++) {
          if (i == currentSemesterIntA){
            eightSemesterPlanTemp.put(currentSemester, currentCourses);
            i++;
          }
          ArrayList<Course> semCourses = new ArrayList<Course>();
          Course chem111 = CourseList.getInstance().getCourseByID("CHEM111");
          Course chem111L = CourseList.getInstance().getCourseByID("CHEM111L");
          Course chem112 = CourseList.getInstance().getCourseByID("CHEM112");
          Course chem112L = CourseList.getInstance().getCourseByID("CHEM112L");
          Course chem112REC = CourseList.getInstance().getCourseByID("CHEM112REC");

          if(completedCourses.keySet().contains(chem111) && !eightSemesterPlanTemp.containsValue(chem111) && i == 1){
            semHours = 4;
            semCourses.add(chem111);
            semCourses.add(chem111L);    
          }
          for (Course course : completedCourses.keySet()) {
            
            if(course == chem111 || course == chem111L || course == chem112 || course == chem112L || course == chem112REC) {
              continue;
            }
            
            if (isCourseInPlan(course, eightSemesterPlanTemp)) {
              continue;
            }
            if (semHours + 3 > 15) {
              ArrayList<Course> copyOfSemCourses = new ArrayList<Course>(
                semCourses
              );
              eightSemesterPlanTemp.put(Integer.toString(i), copyOfSemCourses);
              semHours = 0;
              semCourses.clear();
              i++;

              //TODO FIND SOMEWHERE TO PUT THIS TO UPDATE CURRENT SEMESTER
              if (i == currentSemesterIntA){
                eightSemesterPlanTemp.put(currentSemester, currentCourses);
                i++;
              }


              if(completedCourses.keySet().contains(chem112) && !eightSemesterPlanTemp.containsValue(chem112) && i == 2){
                semHours = 7;
                semCourses.add(chem112);
                semCourses.add(chem112L); 
                semCourses.add(chem112REC);     
              }
            }

            // IF COURSE HAS PREREQS
            if (course.getPrerequisiteCourses() != null) {
              for (Course prereq : course.getPrerequisiteCourses()) {
                if (
                  isCourseInPlan(prereq, eightSemesterPlanTemp) == false &&
                  !semCourses.contains(prereq) &&
                  completedCourses.containsKey(prereq)
                ) {
                  semHours += prereq.getCreditHours();
                  semCourses.add(prereq);
                }
              }
            }

            // IF COURSE HAS COREQS
            if (course.getCorequisiteCourses() != null) {
              for (Course coreq : course.getCorequisiteCourses()) {
                if (
                  isCourseInPlan(coreq, eightSemesterPlanTemp) == false &&
                  !semCourses.contains(coreq) &&
                  completedCourses.containsKey(coreq)
                ) {
                  semHours += coreq.getCreditHours();
                  semCourses.add(coreq);
                }
              }
            }

            if (
              !eightSemesterPlanTemp.containsValue(course) &&
              !semCourses.contains(course)
            ) {
              semHours += course.getCreditHours();
              semCourses.add(course);
            }
          }
          String iString = Integer.toString(i);
          eightSemesterPlanTemp.put(iString, semCourses);
        }






        //Remaining Required Courses
        ArrayList<Course> remainingRequiredCourses = new ArrayList<Course>();
        for (Course course : majorRequiredCourses) {
          if (isCourseInPlan(course, eightSemesterPlanTemp) == false) {
            remainingRequiredCourses.add(course);
          }
        }
        // System.out.println("REMAINING REQUIRED COURSES" + remainingRequiredCourses);
        //ADDING MAJOR REQUIRED COURSES
        boolean lastRequiredCourse = false;
        int currentSemesterInt = Integer.parseInt(currentSemester);
        for (int i = currentSemesterInt + 1; i < 8; i++) {
          if (lastRequiredCourse) {
            break;
          }
          semHours = 0;
          ArrayList<Course> semCourses = new ArrayList<Course>();
          for (Course course : remainingRequiredCourses) {
            System.out.println("semhours" + semHours);
            if (semHours + 3 > 15) {
              ArrayList<Course> copyOfSemCourses = new ArrayList<Course>(
                semCourses
              );
              eightSemesterPlanTemp.put(Integer.toString(i), copyOfSemCourses);
              semHours = 0;
              semCourses.clear();
              i++;
              if(i>8){
                break;
              }
            }
            if (
              completedCourses.containsKey(course) ||
              currentCourses.contains(course)
            ) {
              continue;
            }
            // System.out.println("LAST REQUIRED COURSE" + majorRequiredCourses.get(majorRequiredCourses.size() - 1).getCourseID());
            if (
              course.equals(
                remainingRequiredCourses.get(remainingRequiredCourses.size() - 1)
              )
            ) {
              semCourses.add(course);
              String iString = Integer.toString(i);
              eightSemesterPlanTemp.put(iString, semCourses);
              lastRequiredCourse = true;
              break;
            }
            if (
              isCourseInPlan(course, eightSemesterPlanTemp) == false &&
              !semCourses.contains(course)
            ) {
              semHours += course.getCreditHours();
              semCourses.add(course);
            }
          }
          if(i<=8){
            String iString = Integer.toString(i);
          eightSemesterPlanTemp.put(iString, semCourses);
          }
        }
      }






      //if student is a freshman
      else {
        currentSemester = "1";
        ArrayList<Course> remainingRequiredCourses = new ArrayList<Course>();
        for (Course course : majorRequiredCourses) {
          if (isCourseInPlan(course, eightSemesterPlanTemp) == false) {
            remainingRequiredCourses.add(course);
          }
        }
        ArrayList<Course> semester1Courses = new ArrayList<>();
        Course chem111 = CourseList.getInstance().getCourseByID("CHEM111");
        Course chem111L = CourseList.getInstance().getCourseByID("CHEM111L");
        semester1Courses.add(chem111);
        semester1Courses.add(chem111L);
        eightSemesterPlanTemp.put("1", semester1Courses);

        ArrayList<Course> semester2Courses = new ArrayList<>();
        Course chem112 = CourseList.getInstance().getCourseByID("CHEM112");
        Course chem112L = CourseList.getInstance().getCourseByID("CHEM112L");
        Course chem112REC = CourseList.getInstance().getCourseByID("CHEM112REC");
        semester2Courses.add(chem112);
        semester2Courses.add(chem112L);
        semester2Courses.add(chem112REC);
        eightSemesterPlanTemp.put("2", semester2Courses);

        boolean lastRequiredCourse = false;
        int currentSemesterInt = Integer.parseInt(currentSemester);
        for (int i = currentSemesterInt + 1; i < 8; i++) {
          if (lastRequiredCourse) {
            break;
          }
          int semHours = 0;
          ArrayList<Course> semCourses = new ArrayList<Course>();
          for (Course course : remainingRequiredCourses) {
            System.out.println("semhours" + semHours);
            if (semHours + 3 > 15) {
              ArrayList<Course> copyOfSemCourses = new ArrayList<Course>(
                semCourses
              );
              eightSemesterPlanTemp.put(Integer.toString(i), copyOfSemCourses);
              semHours = 0;
              semCourses.clear();
              i++;
              if(i>8){
                break;
              }
            }
            if (
              completedCourses.containsKey(course) ||
              currentCourses.contains(course)
            ) {
              continue;
            }
            // System.out.println("LAST REQUIRED COURSE" + majorRequiredCourses.get(majorRequiredCourses.size() - 1).getCourseID());
            if (
              course.equals(
                remainingRequiredCourses.get(remainingRequiredCourses.size() - 1)
              )
            ) {
              semCourses.add(course);
              String iString = Integer.toString(i);
              eightSemesterPlanTemp.put(iString, semCourses);
              lastRequiredCourse = true;
              break;
            }
            if (
              isCourseInPlan(course, eightSemesterPlanTemp) == false &&
              !semCourses.contains(course)
            ) {
              semHours += course.getCreditHours();
              semCourses.add(course);
            }
          }
          if(i<=8){
            String iString = Integer.toString(i);
          eightSemesterPlanTemp.put(iString, semCourses);
          }
        }
        
      }






      System.out.println(eightSemesterPlanTemp.keySet() + "POOP");
      for (String semester : eightSemesterPlanTemp.keySet()) {
        System.out.println("Semester " + semester + ":");
        ArrayList<Course> courses = eightSemesterPlanTemp.get(semester);
        for (Course course : courses) {
          System.out.println(course.getCourseID());
        }
      }
    }

    if(currentStudent.getMajor().equals("Computer_Information_Systems")) {
      //if student has completed courses / is not a freshman
      if (completedCourses != null) {

        String studentYear = currentStudent.getStudentClass();
        if (studentYear.equals("FRESHMAN")) {
          currentSemester = "1";
        } else if (studentYear.equals("SOPHOMORE")) {
          currentSemester = "3";
        } else if (studentYear.equals("JUNIOR")) {
          currentSemester = "5";
        } else if (studentYear.equals("SENIOR")) {
          currentSemester = "7";
        }

        int semHours = 0;
        //Current Courses

        // adding completed courses to the plan
        int currentSemesterIntA = Integer.parseInt(currentSemester);
        for (int i = 1; i < currentSemesterIntA; i++) {
          if (i == currentSemesterIntA){
            eightSemesterPlanTemp.put(currentSemester, currentCourses);
            i++;
          }
          ArrayList<Course> semCourses = new ArrayList<Course>();
          for (Course course : completedCourses.keySet()) {
            
            if (isCourseInPlan(course, eightSemesterPlanTemp)) {
              continue;
            }
            if (semHours + 3 > 15) {
              ArrayList<Course> copyOfSemCourses = new ArrayList<Course>(
                semCourses
              );
              eightSemesterPlanTemp.put(Integer.toString(i), copyOfSemCourses);
              semHours = 0;
              semCourses.clear();
              i++;

              //TODO FIND SOMEWHERE TO PUT THIS TO UPDATE CURRENT SEMESTER
              if (i == currentSemesterIntA){
                eightSemesterPlanTemp.put(currentSemester, currentCourses);
                i++;
              }
            }

            // IF COURSE HAS PREREQS
            if (course.getPrerequisiteCourses() != null) {
              for (Course prereq : course.getPrerequisiteCourses()) {
                if (
                  isCourseInPlan(prereq, eightSemesterPlanTemp) == false &&
                  !semCourses.contains(prereq) &&
                  completedCourses.containsKey(prereq)
                ) {
                  semHours += prereq.getCreditHours();
                  semCourses.add(prereq);
                }
              }
            }

            // IF COURSE HAS COREQS
            if (course.getCorequisiteCourses() != null) {
              for (Course coreq : course.getCorequisiteCourses()) {
                if (
                  isCourseInPlan(coreq, eightSemesterPlanTemp) == false &&
                  !semCourses.contains(coreq) &&
                  completedCourses.containsKey(coreq)
                ) {
                  semHours += coreq.getCreditHours();
                  semCourses.add(coreq);
                }
              }
            }

            if (
              !eightSemesterPlanTemp.containsValue(course) &&
              !semCourses.contains(course)
            ) {
              semHours += course.getCreditHours();
              semCourses.add(course);
            }
          }
          String iString = Integer.toString(i);
          eightSemesterPlanTemp.put(iString, semCourses);
        }

        //Remaining Required Courses
        ArrayList<Course> remainingRequiredCourses = new ArrayList<Course>();
        for (Course course : majorRequiredCourses) {
          if (isCourseInPlan(course, eightSemesterPlanTemp) == false) {
            remainingRequiredCourses.add(course);
          }
        }
        // System.out.println("REMAINING REQUIRED COURSES" + remainingRequiredCourses);
        //ADDING MAJOR REQUIRED COURSES
        boolean lastRequiredCourse = false;
        int currentSemesterInt = Integer.parseInt(currentSemester);
        for (int i = currentSemesterInt + 1; i < 8; i++) {
          if (lastRequiredCourse) {
            break;
          }
          semHours = 0;
          ArrayList<Course> semCourses = new ArrayList<Course>();
          for (Course course : remainingRequiredCourses) {
            System.out.println("semhours" + semHours);
            if (semHours + 3 > 15) {
              ArrayList<Course> copyOfSemCourses = new ArrayList<Course>(
                semCourses
              );
              eightSemesterPlanTemp.put(Integer.toString(i), copyOfSemCourses);
              semHours = 0;
              semCourses.clear();
              i++;
              if(i>8){
                break;
              }
            }
            if (
              completedCourses.containsKey(course) ||
              currentCourses.contains(course)
            ) {
              continue;
            }
            // System.out.println("LAST REQUIRED COURSE" + majorRequiredCourses.get(majorRequiredCourses.size() - 1).getCourseID());
            if (
              course.equals(
                remainingRequiredCourses.get(remainingRequiredCourses.size() - 1)
              )
            ) {
              semCourses.add(course);
              String iString = Integer.toString(i);
              eightSemesterPlanTemp.put(iString, semCourses);
              lastRequiredCourse = true;
              break;
            }
            if (
              isCourseInPlan(course, eightSemesterPlanTemp) == false &&
              !semCourses.contains(course)
            ) {
              semHours += course.getCreditHours();
              semCourses.add(course);
            }
          }
          if(i<=8){
            String iString = Integer.toString(i);
          eightSemesterPlanTemp.put(iString, semCourses);
          }
        }
      }






      //if student is a freshman
      else {
        currentSemester = "1";
        ArrayList<Course> remainingRequiredCourses = new ArrayList<Course>();
        for (Course course : majorRequiredCourses) {
          if (isCourseInPlan(course, eightSemesterPlanTemp) == false) {
            remainingRequiredCourses.add(course);
          }
        }
        ArrayList<Course> semester1Courses = new ArrayList<>();
        Course chem111 = CourseList.getInstance().getCourseByID("CHEM111");
        Course chem111L = CourseList.getInstance().getCourseByID("CHEM111L");
        semester1Courses.add(chem111);
        semester1Courses.add(chem111L);
        eightSemesterPlanTemp.put("1", semester1Courses);

        ArrayList<Course> semester2Courses = new ArrayList<>();
        Course chem112 = CourseList.getInstance().getCourseByID("CHEM112");
        Course chem112L = CourseList.getInstance().getCourseByID("CHEM112L");
        Course chem112REC = CourseList.getInstance().getCourseByID("CHEM112REC");
        semester2Courses.add(chem112);
        semester2Courses.add(chem112L);
        semester2Courses.add(chem112REC);
        eightSemesterPlanTemp.put("2", semester2Courses);

        boolean lastRequiredCourse = false;
        int currentSemesterInt = Integer.parseInt(currentSemester);
        for (int i = currentSemesterInt + 1; i < 8; i++) {
          if (lastRequiredCourse) {
            break;
          }
          int semHours = 0;
          ArrayList<Course> semCourses = new ArrayList<Course>();
          for (Course course : remainingRequiredCourses) {
            System.out.println("semhours" + semHours);
            if (semHours + 3 > 15) {
              ArrayList<Course> copyOfSemCourses = new ArrayList<Course>(
                semCourses
              );
              eightSemesterPlanTemp.put(Integer.toString(i), copyOfSemCourses);
              semHours = 0;
              semCourses.clear();
              i++;
              if(i>8){
                break;
              }
            }
            if (
              completedCourses.containsKey(course) ||
              currentCourses.contains(course)
            ) {
              continue;
            }
            // System.out.println("LAST REQUIRED COURSE" + majorRequiredCourses.get(majorRequiredCourses.size() - 1).getCourseID());
            if (
              course.equals(
                remainingRequiredCourses.get(remainingRequiredCourses.size() - 1)
              )
            ) {
              semCourses.add(course);
              String iString = Integer.toString(i);
              eightSemesterPlanTemp.put(iString, semCourses);
              lastRequiredCourse = true;
              break;
            }
            if (
              isCourseInPlan(course, eightSemesterPlanTemp) == false &&
              !semCourses.contains(course)
            ) {
              semHours += course.getCreditHours();
              semCourses.add(course);
            }
          }
          if(i<=8){
            String iString = Integer.toString(i);
          eightSemesterPlanTemp.put(iString, semCourses);
          }
        }
        
      }






      System.out.println(eightSemesterPlanTemp.keySet() + "POOP");
      for (String semester : eightSemesterPlanTemp.keySet()) {
        System.out.println("Semester " + semester + ":");
        ArrayList<Course> courses = eightSemesterPlanTemp.get(semester);
        for (Course course : courses) {
          System.out.println(course.getCourseID());
        }
      }
    }
    
  }

  ///////////////////////////////////////////////////////

  public boolean isCourseInPlan(
    Course course,
    HashMap<String, ArrayList<Course>> eightSemesterPlan
  ) {
    for (ArrayList<Course> courses : eightSemesterPlan.values()) {
      if (courses.contains(course)) {
        return true;
      }
    }
    return false;
  }

  public static void printStudentPortfolioByUsername(String username) {
    ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
    if (studentPortfolios != null) {
      // Filter the list based on the username
      List<StudentPortfolio> filteredPortfolios = studentPortfolios
        .stream()
        .filter(portfolio -> portfolio.getUUID().equals(username))
        .collect(Collectors.toList());

      if (!filteredPortfolios.isEmpty()) {
        for (StudentPortfolio portfolio : filteredPortfolios) {
          //System.out.println("Portfolio UUID: " + portfolio.getPortfolioUUID());
          //System.out.println("Required Courses: " + portfolio.getRequiredCourses());
          System.out.println("Completed Courses: \n");
          portfolio
            .getCompletedCourses()
            .forEach((course, grade) -> {
              System.out.println(course + "Grade: " + grade + "\n");
            });
          System.out.println(
            "\nCurrent Courses: " + portfolio.getCurrentCourses()
          );
          System.out.println(
            "\nFailed Courses: " + portfolio.getFailedCourses()
          );
          //System.out.println("Scholarship: " + portfolio.getScholarship());
          //System.out.println("Yearly Scholarship Credit Hours Left: " + portfolio.getYearlyScholarshipCreditHoursLeft());
          //System.out.println("\nGPA: " + portfolio.getGpa());
          //System.out.println("Fail Count: " + portfolio.getFailCount());
          System.out.println(
            "Semester Credit Count: " + portfolio.getSemesterCreditCount()
          );
          //System.out.println("Year Credit Hours: " + portfolio.getYearCreditHours());
          System.out.println(
            "Total Credit Hours: " + portfolio.getTotalCreditHours()
          );
          //System.out.println("Total Credit Hours Found Docu: " + portfolio.getTotalCreditHoursFoundDocu());
          //System.out.println("Total Credit Hours CC: " + portfolio.getTotalCreditHoursCC());
          //System.out.println("Total Credit Hours Integrative Course: " + portfolio.getTotalCreditHoursIntegrativeCourse());
          //System.out.println("Total Credit Hours Program Requirements: " + portfolio.getTotalCreditHoursProgramRequirements());
          //System.out.println("Total Credit Hours Major Requirements: " + portfolio.getTotalCreditHoursMajorRequirements());
          //System.out.println("Student Electives: " + portfolio.getStudentElectives());
          System.out.println(
            "-----------------------------------------------------------"
          );
        }
      } else {
        System.out.println(
          "No student portfolio found for username: " + username
        );
      }
    } else {
      System.out.println("No student portfolios found.");
    }
  }

  /**
   * Generates an 8-semester plan for the student and prints it to a text file.
   * Includes completed courses with grades and clearly highlights the upcoming semester.
   *
   * @param fileName The name of the text file to write the plan to.
   */
  public static void printAllStudentPortfoliosToFile(String filePath) {
    ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
    if (studentPortfolios != null) {
      try (
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))
      ) {
        for (StudentPortfolio portfolio : studentPortfolios) {
          writer.write("Portfolio UUID: " + portfolio.getPortfolioUUID());
          writer.newLine();

          writer.write("\nEight Semester Plan:");
          writer.newLine();
          portfolio
            .getEightSemesterPlan()
            .forEach((semester, courses) -> {
              try {
                String currentSemester = portfolio.getSemester();
                if (currentSemester.equals(semester)) {
                  writer.write("\nCurrent Semester!!!");
                }
                writer.write("\nSemester " + semester + ": \n");
                courses.forEach(course -> {
                  try {
                    writer.write(course + "\n");
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                });
                writer.newLine();
              } catch (IOException e) {
                e.printStackTrace();
              }
            });

          writer.write("\nCompleted Courses:");
          writer.newLine();
          portfolio
            .getCompletedCourses()
            .forEach((course, grade) -> {
              try {
                writer.write("\n" + course + "Grade: " + grade);
                writer.newLine();
              } catch (IOException e) {
                e.printStackTrace();
              }
            });

          writer.write("\nCurrent Courses: " + portfolio.getCurrentCourses());
          writer.newLine();

          writer.write("\nFailed Courses: " + portfolio.getFailedCourses());
          writer.newLine();

          writer.write("\nGPA: " + portfolio.getGpa());
          writer.newLine();

          writer.write(
            "Semester Credit Count: " + portfolio.getSemesterCreditCount()
          );
          writer.newLine();

          writer.write(
            "Total Credit Hours: " + portfolio.getTotalCreditHours()
          );
          writer.newLine();

          writer.write(
            "-----------------------------------------------------------"
          );
          writer.newLine();
        }
        System.out.println("Student portfolios written to file: " + filePath);
      } catch (IOException e) {
        System.err.println(
          "Error writing student portfolios to file: " + filePath
        );
        e.printStackTrace();
      }
    } else {
      System.out.println("No student portfolios found.");
    }
  }

  public static void printAStudentPortfolioToFile(
    String filePath,
    String portfolioUUID
  ) {
    ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
    StudentPortfolio finalStudentPortfolio = null;

    // Find the student portfolio with the specified UUID
    if (studentPortfolios != null) {
      for (StudentPortfolio portfolio : studentPortfolios) {
        if (portfolio.getPortfolioUUID().equals(portfolioUUID)) {
          finalStudentPortfolio = portfolio;
          break;
        }
      }
    }

    final StudentPortfolio studentPortfolio = finalStudentPortfolio;

    // If the student portfolio is found, print it to the file
    if (studentPortfolio != null) {
      try (
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))
      ) {
        writer.write("Portfolio UUID: " + studentPortfolio.getPortfolioUUID());
        writer.newLine();

        writer.write("\nEight Semester Plan:");
        writer.newLine();
        studentPortfolio
          .getEightSemesterPlan()
          .forEach((semester, courses) -> {
            try {
              String currentSemester = studentPortfolio.getSemester();
              if (currentSemester.equals(semester)) {
                writer.write("\nCurrent Semester!!!");
              }
              writer.write("\nSemester " + semester + ": \n");
              courses.forEach(course -> {
                try {
                  writer.write(course + "\n");
                } catch (IOException e) {
                  e.printStackTrace();
                }
              });
              writer.newLine();
            } catch (IOException e) {
              e.printStackTrace();
            }
          });

        writer.write("\nCompleted Courses:");
        writer.newLine();
        studentPortfolio
          .getCompletedCourses()
          .forEach((course, grade) -> {
            try {
              writer.write("\n" + course + "Grade: " + grade);
              writer.newLine();
            } catch (IOException e) {
              e.printStackTrace();
            }
          });

        writer.write(
          "\nCurrent Courses: " + studentPortfolio.getCurrentCourses()
        );
        writer.newLine();

        writer.write(
          "\nFailed Courses: " + studentPortfolio.getFailedCourses()
        );
        writer.newLine();

        writer.write("\nGPA: " + studentPortfolio.getGpa());
        writer.newLine();

        writer.write(
          "Semester Credit Count: " + studentPortfolio.getSemesterCreditCount()
        );
        writer.newLine();

        writer.write(
          "Total Credit Hours: " + studentPortfolio.getTotalCreditHours()
        );
        writer.newLine();

        writer.write(
          "-----------------------------------------------------------"
        );
        writer.newLine();

        System.out.println(
          "Student portfolio for UUID " +
          portfolioUUID +
          " written to file: " +
          filePath
        );
      } catch (IOException e) {
        System.err.println(
          "Error writing student portfolio to file: " + filePath
        );
        e.printStackTrace();
      }
    } else {
      System.out.println(
        "Student portfolio with UUID " + portfolioUUID + " not found."
      );
    }
  }
}
