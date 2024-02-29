package advising;

import java.util.ArrayList;

public class AuditFacade {
    private User user;
    private UserList userList;
    // private RequiredCourses requiredCourses;

    
    public void signUp(String userName, String password, String userType) {
      if (userName == null || password == null || userName.length() < 5 || password.length() < 5) {
          System.out.println("Invalid username or password. Both must be at least 5 characters.");
          return;
      }
  
      // Check for existing user
      if (UserList.getInstance().userExists(userName)) {
          System.out.println("A user with this username already exists.");
          return;
      }
  
      User newUser = null;
  
      // Create a new user based on userType
      switch (userType) {
          case "student":
              //need help on this
              break;
          case "advisor":
              // need help on this
              break;
          case "faculty":
              //  need help on this 
              break;
          default:
              System.out.println("Invalid user type.");
              return;
      }
  
      if (newUser != null) {
          System.out.println("User created successfully: " + newUser);
      } else {
          System.out.println("User creation failed.");
      }
  }

    public void loginAdvisor(String username, String password) {
        User.loginAdvisor(username, password);
    }

    public void loginAdmin(String username, String password) {
        User.loginAdmin(username, password);
    }

    public void loginStudent(String username, String password) {
        User.loginStudent(username, password);
    }

    public void getAllUsers() {

    }

    public void findCourse() {

    }

    public void getMyRequiredCourses(String Major) {

    }

    public void createCourse() {

    }

    public void addCoursesToStudentPortfolio(String major) {

    }

    
    /**
    * Get the amount of credit hours not completed returned
    * @return int of credit hours left to be taken
    */
    public int calculateCourseCreditLeft(int completedCreditHours, int totalCreditHours) {
        return StudentPortfolio.calculateCourseCreditLeft(completedCreditHours, totalCreditHours);
    }

    public int calculateGPA(ArrayList<completedCourses>, int grade) {

    }

    public void displayMajorMap(ArrayList<Major>) {

    }

    public void adviseStudent(String notes, String Username) {

    }

    public void switchMajor(Student student, String major) {

    }

    public void displayCourseDetails() {

    }

    public void getStudentPortfolio() {

    }

    public void sendFailureNotification(Student student) {

    }

    public void sendScholarshipNotification() {

    }

    public void getAdvisees() {

    }

    public boolean viewAdviseeProfile(String userName) {

    }

    public String generateEightSemesterPlan(String userName) {

    }
    */
}

