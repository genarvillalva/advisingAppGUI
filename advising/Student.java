package advising;

public class Student {
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String major;
  private Advisor advisor;
  private StudentYear studentClass;
  private StudentPortfolio studentPortfolio;
  private String applicationArea;

  public Student(String firstName, String lastName, String username, String password, String major, Advisor advisor, StudentYear studentYear, StudentPortfolio portfolio, String applicationArea) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.major = major;
    this.advisor = advisor;
    this.studentClass = studentYear;
    this.studentPortfolio = portfolio;
    this.applicationArea = applicationArea;
  }

  public void addCoursesToStudentPortfolio(String major) {}

  public void displayMajorMap(Major major) {}

  public void displayStudentPortfolio() {}
}
