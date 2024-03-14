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
  
    private UserList() {
      this.userAccounts = new ArrayList<>();
      this.students = new ArrayList<>();

      advisors = DataLoader.getAllAdvisors();
      students = DataLoader.getAllStudents();
    
}

    // Static method to get the instance of the UserList
    public static UserList getInstance() {
      if (instance == null) {
          instance = new UserList();
      }
      return instance;
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


    public void createAccount(String userName, String password, String userType, String firstName, String lastName, String major, StudentYear studentYear) {
      User newUser = null; // Initialize a new user object
  
      // Determine the type of user based on the userType parameter
      switch (userType.toLowerCase()) {
          case "student":
              System.out.println("Creating new student..."); // Debug statement
              // Create a new Student object
              newUser = new Student(firstName, lastName, userName, password, userType, major, null, studentYear, null, null, null);
              break;
          case "advisor":
              System.out.println("Creating new advisor..."); // Debug statement
              // Create a new Advisor object
              newUser = new Advisor(firstName, lastName, userName, password, userType, null);
              break;
          case "admin":
              System.out.println("Creating new admin..."); // Debug statement
              // Create a new Admin object
              newUser = new Admin(firstName, lastName, userName, password, userType);
              break;
      }
  
      if (newUser != null) { // Check if a new user was created successfully
          System.out.println("User created: " + newUser); // Debug statement
          userAccounts.add(newUser); // Add the new user to the list of users
          System.out.println("User added to users list."); // Debug statement
          
          // Save the list of students to JSON if the new user is an instance of Student
          if (newUser instanceof Student) {
              System.out.println("Adding student to list..."); // Debug statement
              students.add((Student) newUser); // Add the student to the students list
              System.out.println("Students after adding: " + students); // Debug statement
              System.out.println("Starting saveStudents. Number of new students to save: " + students.size() + ". Number of existing students: " + students.size()); // Debug statement
              try {
                System.out.println("Saving students list with size: " + students.size());
                    for (Student s : students) {
                        System.out.println(s); // Assuming Student.toString() gives meaningful output.
                    }
                  DataWriter.saveStudents(students); // Save the students to JSON
                  System.out.println("Students saved successfully."); // Debug statement
              } catch (Exception e) {
                  System.err.println("Error saving students to JSON: " + e.getMessage()); // Debug statement
                  e.printStackTrace(); // Print the stack trace if an error occurs
              }
          }
      }
  }
  
  
  

public void printUsers() { //debugging
  System.out.println("Displaying all users:");

  // Iterate over userAccounts list and print username and user type
  for (User user : userAccounts) {
      System.out.println("Username: " + user.getUsername() + ", Type: " + user.getUserType());
  }
}

//Methods isUsernameValid and isPasswordValid provide basic 
//validation for usernames and passwords, checking for non-null values and a minimum length requirement.

  public boolean isUsernameValid(String username) {
    return username != null && username.length() >5;
   
  }

  public boolean isPasswordValid(String password) {
    return password != null && password.length() >5;
  }

//The userExists method checks if a 
//user already exists in the system based on a provided username, iterating over the userAccounts list.
  public boolean userExists(String username) {
      for (User user : userAccounts) {
        if (user.getUsername().equals(username)) {
          return true; // User with the given username exists
        }
      }
      return false; // No user with the given username exists
    }



//Separate methods for verifying login credentials (verifyLoginStudent, verifyLoginAdmin, verifyLoginAdvisor) 
//are provided for different user roles, each iterating through its respective list and checking
//  if the provided username and password match an existing account.



    public boolean verifyLoginStudent(String username, String password) {
      // Iterate through each student in the students list
      for (Student student : students) { 
          // Check if the current student's username and password match the input parameters
          if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
              return true; // Login successful
              // If a match is found, it means the login credentials are correct.
              // Therefore, the method immediately returns true
          }
      }
      // If the for-loop completes without finding a match, it means no student account matches
      // the provided username and password combination.
      return false; // Login failed
    
  }



    // Method to verify login for an admin
    public boolean verifyLoginAdmin(String username, String password) {
      for (Admin admin : admins) {
          if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
              return true;
          }
      }
      return false;
  }

  // Method to verify login for an advisor

  public boolean verifyLoginAdvisor(String username, String password) {
    for (Advisor advisor : advisors) {
        if (advisor.getUsername().equals(username) && advisor.getPassword().equals(password)) {
            return true; // Login successful
        }
    }
    return false; // Login failed
  }

  //Need a method to allow advisor to remove a student from the list if they fail out.
  public void removeStudentFromProgram(String username, String major) {

    for (Student student : students) {
        if (student.getUsername().equals(username) && student.getMajor().equals(major)) {
            students.remove(student);
            System.out.println("Student " + username + " removed from " + major + " program.");
            return;
        }
    }
    System.out.println("Student " + username + " not found in " + major + " program.");
  }



}