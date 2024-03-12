package advising;

import java.util.ArrayList;
import java.util.Scanner;


public class UserList {
  private static UserList instance = null;
  private UserList userList;
  private ArrayList<User> userAccounts = new ArrayList<User>();
  private ArrayList<Admin> admins; //added Admin ArrayList
  private ArrayList<Advisor> advisors;
  private ArrayList<Student> students;



    private UserList() {
      userAccounts = new ArrayList<>();
      admins = new ArrayList<Admin>();
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

    public ArrayList<Admin> getFacultys() {
      return new ArrayList<>(admins); 
}

    public ArrayList<Advisor> getAdvisors() {
      return new ArrayList<>(advisors); 
}

    public ArrayList<Student> getStudents() {
      return new ArrayList<>(students); 
}




  //The createAccount method adds new users to the general userAccounts list
  public void createAccount(User newUser) {
      userAccounts.add(newUser);
  }

  public void addStudent(Student student) {
    this.students.add(student);
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

  }



}