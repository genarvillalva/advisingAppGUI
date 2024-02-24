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
/**
 * Constructor for the Student class
 * @param firstName
 * @param lastName
 * @param username
 * @param password
 * @param major
 * @param advisor
 * @param studentYear
 * @param portfolio
 * @param applicationArea
 */
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
  /**
   * Get the first name of the student
   * @return The first name of the student
   */
  public String getFirstName() {
    return firstName;
  }
  /**
   * Get the last name of the student
   * @return The last name of the student
   */
  public String getLastName() {
    return lastName;
  }
  /**
   * Get the username of the student
   * @return The username of the student
   */
  public String getUserName() {
    return username;
  }
  /**
   * Get the password of the student
   * @return The password of the student
   */
  public String getPassword() {
    return password;
  }
  /**
   * Get the major of the student
   * @return The major of the student
   */
  public String getMajor() {
    return major;
  }
  /**
   * Get the advisor of the student
   * @return The advisor of the student
   */
  public Advisor getAdvisor() {
    return advisor;
  }
  /**
   * Get the student year of the student
   * @return The student year of the student
   */
  public StudentYear getStudentClass() {
    return studentClass;
  }
  /**
   * Get the student portfolio of the student
   * @return The student portfolio of the student
   */
  public StudentPortfolio getPortfolio() {
    return studentPortfolio;
  }
  /**
   * Get the application area of the student
   * @return The application area of the student
   */
  public String getApplicationArea() {
    return applicationArea;
  }

  public void addCoursesToStudentPortfolio(String major) {}

  public void displayMajorMap(Major major) {}

  public void displayStudentPortfolio() {}
}
