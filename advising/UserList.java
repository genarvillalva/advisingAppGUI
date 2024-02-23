package advising;

import java.util.ArrayList;

public class UserList {

  private UserList userList;
  private ArrayList<User> userAccounts;

  private UserList() {}

  /**
   * Gets an instance of the UserList singleton if it exists, otherwise creates a new instance.
   */
  public UserList getInstance() {
    if (userList == null) {
      userList = new UserList();
    }
    return userList;
  }

  public void createAccount(String username, String password) {}

  public boolean isUsernameValid(String username) {
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

  public boolean verifyLoginStudent(String username, String Password) {
    return true;
  }

  public boolean verifyLoginAdmin(String username, String Password) {
    return true;
  }

  public boolean verifyLoginAdvisor(String username, String Password) {
    return true;
  }
}
