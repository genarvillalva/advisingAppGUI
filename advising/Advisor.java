package advising;

import java.util.ArrayList;

public class Advisor extends User{

  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private ArrayList<Student> listofAdvisedStudents;
  private String advisingNotes;
  private CourseList courseList;

  /**
   * Constructor for the Advisor class
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param listOfAdvisedStudents
   */
  public Advisor(String firstName, String lastName, String username,
                 String password, String userType, ArrayList<Student> listOfAdvisedStudents
   ) {
    super(firstName, lastName, username, password, userType);
    this.listofAdvisedStudents = listOfAdvisedStudents;
    this.courseList = courseList;
  }

  /**
   * Get the first name of the advisor
   * @return The first name of the advisor
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the last name of the advisor
   * @return The last name of the advisor
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the username of the advisor
   * @return The username of the advisor
   */
  public String getUsername() {
    return username;
  }

  /**
   * Get the password of the advisor
   * @return The password of the advisor
   */
  public String getPassword() {
    return password;
  }

  /**
   * Get the list of advised students
   * @return The list of advised students
   */
  public ArrayList<Student> getListofAdvisedStudents() {
    return listofAdvisedStudents;
  }

  /**
   * Get the advising notes
   * @return The advising notes
   */
  public String getAdvisingNotes() {
    return advisingNotes;
  }

  public void adviseStudent(String notes, String username) {}

  public void suggestCourses(ArrayList<Course> courses) {}

  public void addStudentToAdvisor(String username, ArrayList<Student> listOfAdvisedStudents) {
    for (Student student : UserList.getInstance().getStudents()) {
      if(student.getUsername().equals(username)) {
        listOfAdvisedStudents.add(student);
        System.out.println("Student " + username + " added to advisor's list of advised students.");
        return;
      }
    }
    System.out.println("Student " + username + " not found.");
  }

  public void removeStudentFromProgram(String username, String major) {
    UserList.getInstance().removeStudentFromProgram(username, major);
  }

  public String AddStudentApplicationArea(Student applicationArea) {
    return " ";
  }

  public void sendFailureNotification(Student student) {}

  public void sendScholarshipNotification() {}

  public void generateEightSemesterPlan() {}
  public String toString() {
    return "Advisor:\n" +
            "First Name: " + firstName + "\n" +
            "Last Name: " + lastName + "\n" +
            "Username: " + username + "\n" +
            "Password: " + password + "\n" +
            "List of Advised Students: " + listofAdvisedStudents + "\n" +
            "Advising Notes: " + advisingNotes;
}

  public void courseLookup(String course) {
    courseList.findCourse(course);
  }
}
