package advising;

import java.util.Scanner;


public abstract class User {

  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String userType;
  private UserList UserList;

  public User(String firstName, String lastName, String username, String password, String userType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.userType = userType;
    this.UserList = UserList;
  }

  public String getFirstName() {
    return this.firstName;
  }
  public String getLastName() {
    return this.firstName;
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

  public abstract void courseLookup(String course);

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

  public void loginAdmin(String username, String password) {
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

  public void loginAdvisor(String username, String password) {
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

