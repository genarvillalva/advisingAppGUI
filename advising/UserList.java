package advising;

import java.util.ArrayList;
import java.util.Scanner;

public class UserList {

  private static UserList instance;
  private ArrayList<User> userAccounts = new ArrayList<User>();
  private ArrayList<Admin> admins = new ArrayList<Admin>(); //added Admin ArrayList
  private ArrayList<Advisor> advisors;
  private ArrayList<Student> students = new ArrayList<Student>();
  private StudentPortfolio studentPortfolio;
  private Student currentStudent;
  private Advisor currentAdvisor;

  private UserList() {
    this.userAccounts = new ArrayList<>();
    this.students = new ArrayList<>();
    this.currentStudent = null;
    this.currentAdvisor = null;
    this.advisors = DataLoader.getAllAdvisors();
    this.students = DataLoader.getAllStudents();
    //admins = DataLoader.getAllAdmins();

  }

  // Static method to get the instance of the UserList
  public static UserList getInstance() {
    if (instance == null) {
      instance = new UserList();
    }
    return instance;
  }

  public Advisor getAdvisorByUsername(String username) {
    for (Advisor advisor : advisors) {
      if (advisor.getUsername().equals(username)) {
        return advisor;
      }
    }
    return null;
  }

  public Admin getAdminByUsername(String username) {
    for (Admin admin : admins) {
      if (admin.getUsername().equals(username)) {
        return admin;
      }
    }
    return null;
  }

  // Getters for user accounts
  public ArrayList<User> getUserAccounts() {
    return new ArrayList<>(userAccounts);
  }

  public ArrayList<Admin> getAdmins() {
    return new ArrayList<>(admins);
  }

  public ArrayList<Advisor> getAdvisors() {
    return new ArrayList<>(advisors);
  }

  public ArrayList<Student> getStudents() {
    return new ArrayList<>(students);
  }

  // Method to get an advisor by username
  public Advisor getAdvisor(String username) {
    for (Advisor advisor : advisors) {
      if (advisor.getUsername().equals(username)) {
        return advisor;
      }
    }
    return null; // Return null if advisor with given username is not found
  }

  public void createAccount(
    String userName,
    String password,
    String userType,
    String firstName,
    String lastName,
    String major,
    StudentYear studentYear
  ) {
    User newUser = null; // Initialize a new user object

    // Determine the type of user based on the userType parameter
    switch (userType.toLowerCase()) {
      case "student":
        // Create a new Student object
        StudentPortfolio portfolio = new StudentPortfolio(userName);
        newUser =
          new Student(
            firstName,
            lastName,
            userName,
            password,
            userType,
            major,
            null,
            studentYear,
            portfolio,
            null,
            null
          );
        break;
      case "advisor":
        // Create a new Advisor object
        newUser =
          new Advisor(firstName, lastName, userName, password, userType, null);
        break;
      case "admin":
        // Create a new Admin object
        newUser = new Admin(firstName, lastName, userName, password, userType);
        break;
    }

    if (newUser != null) { // Check if a new user was created successfully
      userAccounts.add(newUser); // Add the new user to the list of users

      // Save the list of students to JSON if the new user is an instance of Student
      if (newUser instanceof Student) {
        students.add((Student) newUser);
        DataWriter.saveStudents(students); // Save the students to JSON
      }
    }

    if (newUser instanceof Advisor) {
      System.out.println("Creating Advisor: " + newUser.toString());
      advisors.add((Advisor) newUser);
      System.out.println("Advisors list size: " + advisors.size());
      for (Advisor advisor : advisors) {
        System.out.println("Advisor in list: " + advisor.getUsername());
      }
      DataWriter.saveAdvisors(advisors); // Save the advisors to JSON
    }
    if (newUser instanceof Admin) {
      System.out.println("Creating Admin: " + newUser.toString());
      admins.add((Admin) newUser);
      System.out.println("Admin list size: " + admins.size());
      for (Admin admin : admins) {
        System.out.println("Advisor in list: " + admin.getUsername());
      }
      //DataWriter.saveAdmin(admins); // Save the admin to JSON
    }
  }

  public boolean isUsernameValid(String username) {
    return username != null && username.length() > 5;
  } ///WE DID NOT USE THIS

  public boolean isPasswordValid(String password) {
    return password != null && password.length() > 5;
  } ///WE DID NOT USE THIS

  //The userExists method checks if a
  //user already exists in the system based on a provided username, iterating over the userAccounts list.
  public boolean userExists(String username) {
    for (User user : userAccounts) {
      if (user.getUsername().equals(username)) {
        return true; // User with the given username exists
      }
    }
    return false; // No user with the given username exists
  } ///WE DID NOT USE THIS

  /**
   *  Retrieves a Student object based on a given username.
   *  This method iterates through a list of Student objects
   * */

  public Student getStudentByUsername(String username) {
    System.out.println("Before saving, students size: " + students.size());
    for (Student student : this.students) {
      // Print each student's username for debugging purposes
      System.out.println("Student Username: " + student.getUsername());

      if (student.getUsername().equals(username)) {
        System.out.println("Found matching student for username: " + username);
        return student;
      }
    }

    System.out.println("No student found with username: " + username);
    return null; // No matching student found
  }

  //Separate methods for verifying login credentials (verifyLoginStudent, verifyLoginAdmin, verifyLoginAdvisor)
  //are provided for different user roles, each iterating through its respective list and checking
  //  if the provided username and password match an existing account.

  public boolean verifyLoginStudent(String username, String password) {
    for (Student student : students) {
      if (
        student.getUsername().equals(username) &&
        student.getPassword().equals(password)
      ) {
        this.currentStudent = student;
        return true; // Login successful
      }
    }
    return false; // Login failed
  }

  // Method to verify login for an admin
  public boolean verifyLoginAdmin(String username, String password) {
    for (Admin admin : admins) {
      if (
        admin.getUsername().equals(username) &&
        admin.getPassword().equals(password)
      ) {
        return true;
      }
    }
    return false;
  }

  // Method to verify login for an advisor

  public boolean verifyLoginAdvisor(String username, String password) {
    for (Advisor advisor : advisors) {
      if (
        advisor.getUsername().equals(username) &&
        advisor.getPassword().equals(password)
      ) {
        this.currentAdvisor = advisor;
        return true; // Login successful
      }
    }
    return false; // Login failed
  }

  /*
   * Gets current student 
   * @return currentStudent
   */
  public Student getCurrentStudent() {
    return this.currentStudent;
  }

  /*
   * Gets current advisor 
   * @return currentAdvisor
   */
  public Advisor getCurrentAdvisor() {
    return this.currentAdvisor;
  }

  //Need a method to allow advisor to remove a student from the list if they fail out.
  public void removeStudentFromProgram(String username, String major) {
    for (Student student : students) {
      if (
        student.getUsername().equals(username) &&
        student.getMajor().equals(major)
      ) {
        students.remove(student);
        System.out.println(
          "Student " + username + " removed from " + major + " program."
        );
        return;
      }
    }
    System.out.println(
      "Student " + username + " not found in " + major + " program."
    );
  }
}
