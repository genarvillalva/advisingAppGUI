package advising;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    HashMap<String, ArrayList<Course>> eightSemesterPlan1 = new HashMap<String, ArrayList<Course>>();
    eightSemesterPlan1.put("1", createCoursesForSemester1());
    eightSemesterPlan1.put("2", createCoursesForSemester2());
    eightSemesterPlan1.put("3", createCoursesForSemester3());
    eightSemesterPlan1.put("4", createCoursesForSemester4());
    eightSemesterPlan1.put("5", createCoursesForSemester5());
    eightSemesterPlan1.put("6", createCoursesForSemester6());
    eightSemesterPlan1.put("7", createCoursesForSemester7());
    eightSemesterPlan1.put("8", createCoursesForSemester8());
    System.out.println(
      "\n\n\n\n\n\n\n Eight Semester Plan" +
      eightSemesterPlan1 +
      "\n\n\n\n\n\n\n"
    );
    this.eightSemesterPlan = eightSemesterPlan1;
  }

  private static ArrayList<Course> createCoursesForSemester1() {
    ArrayList<Course> courses = new ArrayList<>();
    CourseList courseList = CourseList.getInstance();
    ArrayList<Course> existingCourses = courseList.getCourses();
    courses.add(CourseList.getCourseByID("CSCE190"));
    courses.add(CourseList.getCourseByID("ARTE260"));
    courses.add(CourseList.getCourseByID("UNIV101"));
    return courses;
  }

  private static ArrayList<Course> createCoursesForSemester2() {
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(CourseList.getCourseByID("CSCE146"));
    courses.add(CourseList.getCourseByID("CHEM111"));
    courses.add(CourseList.getCourseByID("CHEM111L"));
    courses.add(CourseList.getCourseByID("CSCE215"));
    courses.add(CourseList.getCourseByID("HIST111"));
    courses.add(CourseList.getCourseByID("MATH241"));
    return courses;
  }

  private ArrayList<Course> createCoursesForSemester3() {
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(CourseList.getCourseByID("CSCE240"));
    courses.add(CourseList.getCourseByID("CSCE211"));
    courses.add(CourseList.getCourseByID("MATH374"));
    courses.add(CourseList.getCourseByID("CHEM112"));
    courses.add(CourseList.getCourseByID("CHEM112L"));
    courses.add(CourseList.getCourseByID("CHEM112REC"));
    courses.add(CourseList.getCourseByID("SPCH140"));
    return courses;
  }

  private ArrayList<Course> createCoursesForSemester4() {
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(CourseList.getCourseByID("ENGL463"));
    courses.add(CourseList.getCourseByID("CSCE350"));
    courses.add(CourseList.getCourseByID("CSCE212"));
    courses.add(CourseList.getCourseByID("CSCE247"));
    courses.add(CourseList.getCourseByID("STAT509"));
    return courses;
  }

  private ArrayList<Course> createCoursesForSemester5() {
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(CourseList.getCourseByID("CSCE311"));
    courses.add(CourseList.getCourseByID("CSCE330"));
    courses.add(CourseList.getCourseByID("CSCE390"));
    return courses;
  }

  private ArrayList<Course> createCoursesForSemester6() {
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(CourseList.getCourseByID("CSCE416"));
    courses.add(CourseList.getCourseByID("PHIL102"));
    return courses;
  }

  private ArrayList<Course> createCoursesForSemester7() {
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(CourseList.getCourseByID("CSCE490"));
    courses.add(CourseList.getCourseByID("MATH344"));
    return courses;
  }

  private ArrayList<Course> createCoursesForSemester8() {
    ArrayList<Course> courses = new ArrayList<>();
    courses.add(CourseList.getCourseByID("CSCE492"));
    return courses;
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
