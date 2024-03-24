package advising;

import java.util.ArrayList;

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
    this.listOfAdvisedStudents = new ArrayList<Student>();
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

  /**
   * 
   * @param studentUsername
   */
  public void addToAdviseeListByUsername(String studentUsername) {
      UserList userList = advising.UserList.getInstance();
      Student student = userList.getStudentByUsername(studentUsername);
      System.out.println(
          "Adding student to "+getUsername() +  " list: " +
          student.getFirstName() +
          " " +
          student.getLastName()
      );
      this.listOfAdvisedStudents.add(student);
  }

  public void addAdvisingNotes(String note, String username) {
    if (this.advisingNotes == null) {
      this.advisingNotes = "Note: " + note; // Since there are no existing notes a new note will be intialized.
    } else {
      this.advisingNotes +="\n" + " Note: " + note; // Append new note to existing notes
    }
    ArrayList<Student> students = DataLoader.getAllStudents();
    for (Student student : students) {
        if (student.getUsername().equals(username)) {
            student.addAdvisingNotes(this.advisingNotes); // Update advising notes for the specific student
            DataWriter.saveStudents(students);
            return;
        }
    }
    System.out.println("Student not found in advisor's list.");
    
  }

  //public void suggestCourses(ArrayList<Course> courses) {}

  public Student lookUpStudent(String username) {
    // Directly fetch the Student object from a central repository (e.g., UserList)
    // where all students are stored, without limiting the search to the advisor's advised students.
    Student student = UserList.getInstance().getStudentByUsername(username);
    if (student != null) {
      ArrayList<StudentPortfolio> portfolios = DataLoader.getAllStudentPortfolios();
      for (StudentPortfolio portfolio : portfolios) {
        if (portfolio.getPortfolioUUID().equals(username)) {
            System.out.println(portfolio.getCompletedCourses());
            break;
        }
    }
      System.out.println("Application Area: " + student.getApplicationArea());
      // If a student with the provided username is found, return the student.
      return student;
    } else {
      // If no matching student is found in the central list, print a message and return null.
      System.out.println("No student found with username: " + username);
      return null;
    }
  }

  public void addToAdviseeList(Student student) {
    System.out.println(
      "Adding student to "+getUsername() +  " list: " +
      student.getFirstName() +
      " " +
      student.getLastName()
    );
    this.listOfAdvisedStudents.add(student);
  }

  public void addAdvisorToAdvisee(String username) {
    ArrayList<Student> students = DataLoader.getAllStudents(); // Load all students
    for (Student stu : students) {
        if (username.equals(stu.getUsername())) {
            // Update the specific student in the list
            stu.setAdvisor(this);
            break;
        }
    }
    DataWriter.saveStudents(students);
  }

  public void addStudentToAdvisor(String username, ArrayList<Student> listOfAdvisedStudents)
   {
    Student student = UserList.getInstance().getStudentByUsername(username);

    if (student != null) {
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
      addAdvisorToAdvisee(username);

    } else {
      System.out.println("Student " + username + " not found.");
    }
  }

  public void removeStudentFromProgram(String username, String major) {
    UserList.getInstance().removeStudentFromProgram(username, major);
  }

  // public String addStudentApplicationArea(Student applicationArea) {
  //   return " ";
  // }

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

  // public void generateEightSemesterPlan() {}

  public void logout() {
    super.logout(); // Call the logout() method from the superclass
  }

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
