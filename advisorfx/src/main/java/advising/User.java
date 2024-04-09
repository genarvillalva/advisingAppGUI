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

  /**
   * Gets the first name of user
   * @return The first name of user
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets the last name of user
   * @return The last name of user
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Gets the username of user
   * @return The username of user
   */
  public String getUsername() {
    return this.username;
}

  /**
   * Gets the password of user
   * @return The password of user
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * Gets the type of user
   * @return The type of user
   */
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
        isLoggedIn = false;
        System.out.println("Login Failed");
        return;
      }
    }
  }

  public boolean isLoggedIn() {
    return isLoggedIn;
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
        isLoggedIn = false;
        return;
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
        isLoggedIn = false;
        return;
      }
    }
  }

  public void logout() {
    isLoggedIn = false; 
    System.out.println("Logged out successfully.");
  }

  /**
   * String representation of a user
   */
  public String toString() {
    return "First Name: " + firstName + "\nLast Name: " + lastName + "\nUsername: " + username + "\nPassword: " + password + "\nUser Type: " + userType;
  }
}

