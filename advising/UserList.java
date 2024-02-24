package advising;

import java.util.ArrayList;

public class UserList {

  private UserList userList;
  private ArrayList<User> userAccounts;
  private ArrayList<Faculty> facultys;
  private ArrayList<Advisor> advisors;
  private ArrayList<Student> students;



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


  public void createAccount(String username, String password) {

  }



  public boolean isUsernameValid(String username) {
      //if username
    return true;
  }

  public boolean isPasswordValid(String password) {
    return true;
  }

  public String enterUsername() {
    return "";
  }

  public String enterPassword() {
    return "";
  }

  public boolean verifyLoginStudent(String username, String password) {
    // Iterate over the students list to find a matching username and password
    for (User user : userAccounts) {
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return true; // Login successful
        }
    }
    return false; // Login failed
}

    // Method to verify login for an admin
    public boolean verifyLoginAdmin(String username, String password) {
      // Iterate over the faculty list to find a matching username and password
      for (User user : userAccounts) {
          if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
              return true; // Login successful
          }
      }
      return false; // Login failed
  }


  public boolean verifyLoginAdvisor(String username, String password) {
    // Iterate over the advisors list to find a matching username and password
    for (User user : userAccounts) {
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return true; // Login successful
        }
    }
    return false; // Login failed
}

}
