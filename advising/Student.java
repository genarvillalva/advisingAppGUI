package advising;

import java.util.ArrayList;

public class Student extends User {
  private String major;
  private Advisor advisor;
  private StudentYear studentYear;
  private StudentPortfolio studentPortfolio;
  private String applicationArea;
  private CourseList courseList;
  private String advisingNotes;

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
    String applicationArea
  ) {
    super(firstName, lastName, username, password, userType);
    this.major = major;
    this.advisor = advisor;
    this.studentYear = studentYear;
    this.studentPortfolio = portfolio;
    this.applicationArea = applicationArea;
  }

  /**
   * Get the first name of the student
   * @return The first name of the student
   */
  public String getFirstName() {
    return firstName;
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

  /**
   * Get the student year of the student
   * @return The student year of the student
   */
  public String getStudentClass() {
    return studentYear+"";
  }

  /**
   * Get the student portfolio of the student
   * @return The student portfolio of the student
   */
  public StudentPortfolio getPortfolio() {
    return studentPortfolio;
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
/**
 * String representation of a student
 */
  public String toString() {
    return "Student:\n" +
      "First Name: " + firstName + "\n" +
      "Last Name: " + lastName + "\n" +
      "Username: " + username + "\n" +
      "Password: " + password + "\n" +
      "User Type: " + userType + "\n" +
      "Major: " + major + "\n" +
      "Advisor: " + advisor.getUsername() + "\n" +
      "Student Year: " + studentYear + "\n" +
      "Student Portfolio: " + studentPortfolio + "\n" +
      "Application Area: " + applicationArea + "\n";
  }

  public void courseLookup(String course) {
    courseList.findCourse(course);
  }

  public void addAdvisingNotes(String note) {
    if (this.advisingNotes == null) {
        this.advisingNotes = note;
    } else {
        this.advisingNotes += note; // Append new note to existing ones
    }
  }

}
