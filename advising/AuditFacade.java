package advising;

public class AuditFacade {
    private User user;
    private UserList userList;
    private RequiredCourses requiredCourses;

    public AuditFacade() {

    }

    public void signUp(String userName, String password) {

    }

    public void loginAdvisor(String username, String password) {
        while(true) {
          if(UserList.getInstance().verifyLoginAdvisor(username, password)) {
            System.out.println("Login Successful");
            break;
          }else {
            System.out.println("Login Failed");
            loginInput(username, password);
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
            loginInput(username, password);
          }
        }
    }

    public void loginStudent(String username, String password) {
        while(true) {
          if(UserList.getInstance().verifyLoginStudent(username, password)) {
            System.out.println("Login Successful");
            break;
          }
          else {
            System.out.println("Login Failed");
            loginInput(username, password);
          }
        }
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
        return (totalCreditHours - completedCreditHours);
    }

    public int calculateGPA(ArrayList<completedCourses>, int grade) {
        for(int i = 0; i < completedCourses.length; i++){
            if (grade >= 90.0) {
                return 4.0;
            } else if (grade >= 80.0) {
                return 3.0;
            } else if (grade >= 70.0) {
                return 2.0;
            } else if (grade >= 60.0) {
                return 1.0;
            } else {
                return 0.0;
            }
        }

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
}
