package advising;

import java.util.Scanner;


public abstract class User {

  private String name;
  private String username;
  private String password;
  private String userType;
  private UserList UserList;

  public User(String name, String username, String password, String userType) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.userType = userType;
    this.UserList = UserList;
  }

  public String getName() {
    return this.name;
  }

  public String getUsername() {
    return this.username;
}

  public String getPassword() {
    return this.password;
  }

  public String getUserType() {
    return this.userType;
  }

  public abstract boolean courseLookup(String course);

  public void loginStudent(String username, String password) {
    while(true) {
      if(UserList.getInstance().verifyLoginStudent(username, password)) {
        System.out.println("Login Successful");
        break;
      }
      else {
        System.out.println("Login Failed");
      }
    }
  }

  public void loginAdmin() {
    while(true) {
      if(UserList.getInstance().verifyLoginAdmin(username, password)) {
        System.out.println("Login Successful");
        break;
      }
      else {
        System.out.println("Login Failed");
      }
    }
  }

  public void loginAdvisor() {
    while(true) {
      if(UserList.getInstance().verifyLoginAdvisor(username, password)) {
        System.out.println("Login Successful");
        break;
      }
      else {
        System.out.println("Login Failed");
      }
    }
  }
}
