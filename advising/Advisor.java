package advising;

import java.util.ArrayList;
import java.util.Scanner;

public class Advisor extends User {

  private ArrayList<Student> listOfAdvisedStudents;
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
  public Advisor(
    String firstName,
    String lastName,
    String username,
    String password,
    String userType,
    ArrayList<Student> listOfAdvisedStudents
  ) {
    super(firstName, lastName, username, password, userType);
    this.listOfAdvisedStudents = listOfAdvisedStudents;
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
  public ArrayList<Student> getListOfAdvisedStudents() {
    return listOfAdvisedStudents;
  }

  /**
   * Get the advising notes
   * @return The advising notes
   */
  public String getAdvisingNotes() {
    return advisingNotes;
  }

  public void addToAdviseeList(Student student) {
    System.out.println(
      "Adding student to advisor's list: " +
      student.getFirstName() +
      " " +
      student.getLastName()
    );
    this.listOfAdvisedStudents.add(student);
  }

  public void addToAdviseeList(String studentUsername) {
    UserList userList = advising.UserList.getInstance();
    Student student = userList.getStudentByUsername(studentUsername);
    System.out.println(
      "Adding student to advisor's list: " +
      student.getFirstName() +
      " " +
      student.getLastName()
    );
    this.listOfAdvisedStudents.add(student);
  }

  public void adviseStudent(String username, String note) {
    for (Student student : this.listOfAdvisedStudents) {
      System.out.println(student.getUsername());
      if (student.getUsername().equals(username)) {
        System.out.println("Adding note to: " + student.getUsername());
        student.addAdvisingNotes(note);
        return;
      }
    }
    System.out.println("Student not found in advisor's list.");
  }

  public void suggestCourses(ArrayList<Course> courses) {}

  public Student lookUpStudent(String username) {
    // Directly fetch the Student object from a central repository (e.g., UserList)
    // where all students are stored, without limiting the search to the advisor's advised students.
    Student student = UserList.getInstance().getStudentByUsername(username);

    if (student != null) {
      // If a student with the provided username is found, return the student.
      return student;
    } else {
      // If no matching student is found in the central list, print a message and return null.
      System.out.println("No student found with username: " + username);
      return null;
    }
  }

  public void addStudentToAdvisor(
    String username,
    ArrayList<Student> listOfAdvisedStudents
  ) {
    // Find the student with the given username
    Student student = UserList.getInstance().getStudentByUsername(username);

    if (student != null) {
      // Update the advisor's list of advised students with the student's username
      this.listOfAdvisedStudents.add(student);

      // Save the updated advisor information
      DataWriter.saveAdvisors(UserList.getInstance().getAdvisors());

      System.out.println(
        "Student " +
        username +
        " added to " +
        firstName +
        "'s list of advised students."
      );
    } else {
      System.out.println("Student " + username + " not found.");
    }
  }

  public void removeStudentFromProgram(String username, String major) {
    UserList.getInstance().removeStudentFromProgram(username, major);
  }

  public String AddStudentApplicationArea(Student applicationArea) {
    return " ";
  }

  /**
   * Notify the student that they are at risk of failing a course
   * @param username
   */
  public void sendFailureNotification(String username) {
    for (Student student : this.listOfAdvisedStudents) {
      System.out.println(student.getUsername());
      if (student.getUsername().equals(username)) {
        System.out.println("Adding note to: " + student.getUsername());
        student.addAdvisingNotes("You are at risk of failing your course");
        return;
      }
    }
    System.out.println("Student not found in advisor's list.");
  }

  /**
   * Notify the student that they are at risk of losing a scholarship
   * @param username
   */
  public void sendScholarshipNotification(String username) {
    for (Student student : this.listOfAdvisedStudents) {
      System.out.println(student.getUsername());
      if (student.getUsername().equals(username)) {
        System.out.println("Adding note to: " + student.getUsername());
        student.addAdvisingNotes("You are at risk of losing your scholarships");
        return;
      }
    }
    System.out.println("Student not found in advisor's list.");
  }

  public void generateEightSemesterPlan() {}

  public String toString() {
    return (
      "Advisor:\n" +
      "First Name: " +
      firstName +
      "\n" +
      "Last Name: " +
      lastName +
      "\n" +
      "Username: " +
      username +
      "\n" +
      "Password: " +
      password +
      "\n" +
      "User Type: " +
      userType +
      "\n" +
      "List of Advised Students: " +
      listOfAdvisedStudents +
      "\n"
    );
  }

  public void courseLookup(String course) {
    courseList.findCourse(course);
  }
}
