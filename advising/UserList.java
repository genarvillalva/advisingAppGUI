package advising;

import java.util.ArrayList;
import java.util.Scanner;


public class UserList {

  private UserList userList;
  private ArrayList<User> userAccounts;
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

  public UserList getInstance() {
    if (userList == null) {
      userList = new UserList();
    }
    return userList;
  }


  public void createAccount(User newUser) {
      userAccounts.add(newUser);
  }

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


  public boolean verifyLoginStudent(String username, String password) {
    for (Student student : students) {
        if (student.getUserName().equals(username) && student.getPassword().equals(password)) {
            return true; // Login successful
        }
    }
    return false; // Login failed
}

    // Method to verify login for an admin
    public boolean verifyLoginAdmin(String username, String password) {
      for (User user : userAccounts) {
          if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
              return true; // Login successful
          }
      }
      return false; // Login failed
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