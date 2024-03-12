package advising;

import java.util.ArrayList;

public class Student extends User {
  private String major;
  private Advisor advisor;
  private StudentYear studentClass;
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
    this.studentClass = studentYear;
    this.studentPortfolio = portfolio;
    this.applicationArea = applicationArea;
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
    return studentClass+"";
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

  public String toString() {
    return "Student: " + firstName + " " + lastName + "\n" + "username: " + username + "\n" + 
           "Major: " + major + " Student Year: " + studentClass;
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
