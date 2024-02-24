package advising;

public abstract class User {

  private String name;
  private String username;
  private String password;
  private String userType;

  public User(String name, String username, String password, String userType) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.userType = userType;
  }

  public String getUsername() {
    return this.username;
}

  public String getPassword() {
    return this.password;
  }

  public boolean courseLookup(String course) {
    return true;
  }

  public boolean loginInput(String username, String password) {
    return true;
  }

  public void loginStudent() {}

  public void loginAdmin() {}

  public void loginAdvisor() {}
}
