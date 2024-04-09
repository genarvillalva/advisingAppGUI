package advising;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class Student extends User {

  private String major;
  private Advisor advisor;
  private StudentYear studentYear;
  private StudentPortfolio studentPortfolio;
  private String applicationArea;
  private CourseList courseList;
  private ArrayList<String> advisingNotes;

  /**
   * Constructor for the Student class
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param major
   * @param advisor
   * @param studentYear
   * @param portfolio
   * @param applicationArea
   * @param courseList
   */
  public Student(
    String firstName,
    String lastName,
    String username,
    String password,
    String userType,
    String major,
    Advisor advisor,
    StudentYear studentYear,
    StudentPortfolio portfolio,
    String applicationArea,
    String advisingNotes
  ) {
    super(firstName, lastName, username, password, userType);
    this.major = major;
    this.advisor = advisor;
    this.studentYear = studentYear;
    this.studentPortfolio = portfolio;
    this.applicationArea = applicationArea;
    this.advisingNotes = new ArrayList();
  }

  /**
   * Get the first name of the student
   * @return The first name of the student
   */
  public String getFirstName() {
    return firstName;
  }

  public String getStudentPortfolioUUID() {
    return studentPortfolio.getUUID();
  }

  /**
   * Get the last name of the student
   * @return The last name of the student
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the username of the student
   * @return The username of the student
   */
  public String getUsername() {
    return username;
  }

  /**
   * Get the password of the student
   * @return The password of the student
   */
  public String getPassword() {
    return password;
  }

  /**
   * Get the major of the student
   * @return The major of the student
   */
  public String getMajor() {
    return major;
  }

  /**
   * Get the advisor of the student
   * @return The advisor of the student
   */
  public Advisor getAdvisor() {
    return advisor;
  }

  public void setAdvisor(Advisor advisor) {
    this.advisor = advisor;
  }

  /**
   * Get the advising notes of the student
   * @return The advising notes of the student
   */
  public String getAdvisingNotes() {
    StringBuilder notesStringBuilder = new StringBuilder();
    for (String note : advisingNotes) {
        notesStringBuilder.append(note).append("\n");
    }
    return notesStringBuilder.toString();
  }
  

  /**
   * Get the student year of the student
   * @return The student year of the student
   */
  public String getStudentClass() {
    return studentYear + "";
  }

  /**
   * Get the student portfolio of the student
   * @return The student portfolio of the student
   */
  public StudentPortfolio getPortfolio() {
    return studentPortfolio;
  }
/**
 * Show available Application Areas for the student
 */
  public void showApplicationAreas(){
    StudentPortfolio portfolio = getPortfolio();
    if (portfolio != null) {
        ArrayList<ElectiveCluster> electives = portfolio.getStudentElectives().getElectives();
        if (electives != null) {
            for (ElectiveCluster elective : electives) {
                String electiveName = elective.getElectiveName();
                if (electiveName != null && electiveName.startsWith("Application Area")) {
                    System.out.println(electiveName);
                }
            }
        }
    }
  }

  public void showRequiredCourses(Student currentStudent){
    HashSet<String> titlesToMatch = new HashSet<>();
    titlesToMatch.add("CMW");
    titlesToMatch.add("ARP");
    titlesToMatch.add("SCI");
    titlesToMatch.add("GFL");
    titlesToMatch.add("GHS");
    titlesToMatch.add("AIU");
    titlesToMatch.add("CMS");
    titlesToMatch.add("INF");
    titlesToMatch.add("VSR");
    titlesToMatch.add("PR");
    titlesToMatch.add("MR");
    titlesToMatch.add("IC");
    titlesToMatch.add("FD");
    StudentPortfolio portfolio = currentStudent.getPortfolio();
    if (portfolio != null) {
        ArrayList<ElectiveCluster> electives = portfolio.getStudentElectives().getElectives();
        if (electives != null) {
            boolean found = false;
            for (ElectiveCluster elective : electives) {
                String electiveName = elective.getElectiveName();
                if (electiveName != null && titlesToMatch.contains(electiveName)) {
                    System.out.println("Elective found: " + electiveName);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No matching electives found for the current student.");
            }
        } else {
            System.out.println("No electives found for the current student.");
        }
    } else {
        System.out.println("Portfolio not found for the current student.");
    }
  }
  /**
   * Get the application area of the student
   * @return The application area of the student
   */
  public String getApplicationArea() {
    return applicationArea;
  }

  public void addCoursesToStudentPortfolio(Course course) {
    // this.studentPortfolio.addCourse(course);
  }

  public void displayMajorMap(Major major) {
    for (Course course : major.getRequiredCourses()) {
      System.out.println(course.toString());
    }
  }

  public void displayStudentPortfolio() {
    this.studentPortfolio.toString();
  }

  public void logout() {
    super.logout(); // Call the logout() method from the superclass
  }
  
  /**
   * String representation of a student
   */
  public String toString() {
    // Check if an advisor is assigned to the student.
    // If an advisor is assigned, get the advisor's username.
    // Otherwise say "No advisor assigned" as the username.
    String advisorUsername = (advisor != null)
      ? advisor.getUsername()
      : "No advisor assigned";

    // Check if an application area is assigned.
    // If an application area is assigned, display it.
    // Otherwise, say "No application area assigned".
    String applicationAreaInfo = (applicationArea != null)
      ? applicationArea
      : "No application area assigned";

    return (
      "Student:\n" +
      "First Name: " +
      firstName +
      "\n" +
      "Last Name: " +
      lastName +
      "\n" +
      "Username: " +
      username 
      // +
      // "\n" +
      // "Password: " +
      // password +
      // "\n" +
      // "User Type: " +
      // userType +
      // "\n" +
      // "Major: " +
      // major +
      // "\n" +
      // "Advisor: " +
      // advisorUsername +
      // "\n" +
      // "Student Year: " +
      // studentYear +
      // "\n" +
      // "Student Portfolio: " +
      // studentPortfolio +
      // "\n" +
      // "Application Area: " +
      // applicationAreaInfo +
      // "\n" +
      // "Advising Notes: " +
      // advisingNotes +
      // "\n"
    );
  }

  /**
   * Finds the course from course list
   * @param course
   */
  public void courseLookup(String course) {
    courseList.findCourse(course);
  }

  // Adds a new advising note to the student's record.
  public void addAdvisingNotes(String note) {
    this.advisingNotes.add(note);
  }

  /**
   * Prints the values from student portfolio to the terminal
   */
  public static void printAllStudentPortfolios() {
    ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
    if (studentPortfolios != null) {
        for (StudentPortfolio portfolio : studentPortfolios) {
            System.out.println("Portfolio UUID: " + portfolio.getPortfolioUUID());
            //System.out.println("Required Courses: " + portfolio.getRequiredCourses());
            System.out.println("\nEight Semester Plan:");
            portfolio.getEightSemesterPlan().forEach((semester, courses) -> {
                System.out.print("\nSemester " + semester + ": \n");
                courses.forEach(course -> System.out.print(course + "\n"));
                System.out.println();
            });
            System.out.println("Completed Courses: ");
            portfolio.getCompletedCourses().forEach((course, grade) -> {
                System.out.println(course + "-Grade: " + grade);
            });
            System.out.println("\nCurrent Courses: " + portfolio.getCurrentCourses());
            System.out.println("\nFailed Courses: " + portfolio.getFailedCourses());
            //System.out.println("Scholarship: " + portfolio.getScholarship());
            //System.out.println("Yearly Scholarship Credit Hours Left: " + portfolio.getYearlyScholarshipCreditHoursLeft());
            System.out.println("\nGPA: " + portfolio.getGpa());
            //System.out.println("Fail Count: " + portfolio.getFailCount());
            System.out.println("Semester Credit Count: " + portfolio.getSemesterCreditCount());
            //System.out.println("Year Credit Hours: " + portfolio.getYearCreditHours());
            System.out.println("Total Credit Hours: " + portfolio.getTotalCreditHours());
            //System.out.println("Total Credit Hours Found Docu: " + portfolio.getTotalCreditHoursFoundDocu());
            //System.out.println("Total Credit Hours CC: " + portfolio.getTotalCreditHoursCC());
            //System.out.println("Total Credit Hours Integrative Course: " + portfolio.getTotalCreditHoursIntegrativeCourse());
            //System.out.println("Total Credit Hours Program Requirements: " + portfolio.getTotalCreditHoursProgramRequirements());
            //System.out.println("Total Credit Hours Major Requirements: " + portfolio.getTotalCreditHoursMajorRequirements());
            //System.out.println("Student Electives: " + portfolio.getStudentElectives());
            System.out.println("-----------------------------------------------------------");
        }
    } else {
        System.out.println("No student portfolios found.");
    }
}


// public static void printEightSemesterPlan() {
//   StudentPortfolio studentPortfolio = StudentPortfolio.printAllStudentPortfolios();
//   System.out.println("Portfolio UUID: " + studentPortfolio.getPortfolioUUID());
//   System.out.println("\nEight Semester Plan:");
//   studentPortfolio.getEightSemesterPlan().forEach((semester, courses) -> {
//     System.out.print("\nSemester " + semester + ": ");
//     courses.forEach(course -> System.out.print(course + ", "));
//     System.out.println();
//   });
// }


/* 
public static void printEightSemesterPlan() {
  StudentPortfolio studentPortfolios = studentPortfolio;
          System.out.println("Portfolio UUID: " + studentPortfolio.getPortfolioUUID());
          //System.out.println("Required Courses: " + portfolio.getRequiredCourses());
          System.out.println("\nEight Semester Plan:");
          studentPortfolio.getEightSemesterPlan().forEach((semester, courses) -> {
              System.out.print("\nSemester " + semester + ": ");
              courses.forEach(course -> System.out.print(course + ", "));
              System.out.println();
          });
        }
  */
}
