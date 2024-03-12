package advising;

import java.util.Scanner;


public abstract class User {

  protected String firstName;
  protected String lastName;
  protected String username;
  protected String password;
  protected String userType;
  protected UserList UserList;
  protected boolean isLoggedIn;

  public User(String firstName, String lastName, String username, String password, String userType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.userType = userType;
    this.isLoggedIn = false;
  }

  public String getFirstName() {
    return this.firstName;
  }
  public String getLastName() {
    return this.lastName;
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
        isLoggedIn = true;
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
        isLoggedIn = true;
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
        isLoggedIn = true;
        System.out.println("Login Successful");
        break;
      }
      else {
        System.out.println("Login Failed");
      }
    }
  }

  public void logout() {
    isLoggedIn = false; 
    System.out.println("Logged out successfully.");
}
  public String toString() {
    return "First Name: " + firstName + "\nLast Name: " + lastName + "\nUsername: " + username + "\nPassword: " + password + "\nUser Type: " + userType;
  }
}

