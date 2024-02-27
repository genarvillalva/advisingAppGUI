package advising;

import java.util.ArrayList;
import java.util.Scanner;


public class UserList {
  private static UserList instance = null;
  private UserList userList;
  private ArrayList<User> userAccounts = new ArrayList<User>();
  private ArrayList<Faculty> facultys;
  private ArrayList<Advisor> advisors;
  private ArrayList<Student> students;
  private Scanner scanner = new Scanner(System.in);



    private UserList() {
      userAccounts = new ArrayList<>();
      facultys = new ArrayList<>();
      advisors = new ArrayList<>();
      students = new ArrayList<>();
    
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

    public ArrayList<Faculty> getFacultys() {
      return new ArrayList<>(facultys); 
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



//Methods isUsernameValid and isPasswordValid provide basic 
//validation for usernames and passwords, checking for non-null values and a minimum length requirement.

  public boolean isUsernameValid(String username) {
    return username != null && username.length() >5;
   
  }

  public boolean isPasswordValid(String password) {
    return password != null && password.length() >5;
  }

   /**
     * Prompts the user to enter a username.
     * @return The username entered by the user.
     */
    public String enterUsername() {
      System.out.print("Enter username: ");
      return scanner.nextLine();
  }

      /**
     * Prompts the user to enter a password.
     * @return The password entered by the user.
     */
    public String enterPassword() {
      System.out.print("Enter password: ");
      return scanner.nextLine();
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
      for (Student student : students) { // this is not right because I am havig trouble creating a
          // Check if the current student's username and password match the input parameters
          if (student.getUserName().equals(username) && student.getPassword().equals(password)) {
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
      for (User user : userAccounts) {
          if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
              return true;
          }
      }
      return false;
  }


  public boolean verifyLoginAdvisor(String username, String password) {
    for (Advisor advisor : advisors) {
        if (advisor.getUsername().equals(username) && advisor.getPassword().equals(password)) {
            return true; // Login successful
        }
    }
    return false; // Login failed
}


}