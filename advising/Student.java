package advising;

public class Student {

  private String major;
  private Advisor advisor;
  private StudentYear studentClass;
  private StudentPortfolio studentPortfolio;
  private String applicationArea;

  public Student(String major, Advisor advisor, StudentYear studentClass, StudentPortfolio portfolio, String applicationArea) {
    this.major = major;
    this.advisor = advisor;
    this.studentClass = studentClass;
    this.studentPortfolio = portfolio;
    this.applicationArea = applicationArea;
  }

  public void addCoursesToStudentPortfolio(String major) {}

  public void displayMajorMap(Major major) {}

  public void displayStudentPortfolio() {}
}