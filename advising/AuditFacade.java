package advising;

import java.util.ArrayList;

public class AuditFacade {
    private User user;
    private UserList userList;
    private Admin admin;
    private Student student;
    private StudentPortfolio studentPortfolio;
    // private RequiredCourses requiredCourses;

    public AuditFacade() {
        this.userList = UserList.getInstance(); // This line ensures userList is initialized
    }

    
    public void signUp(String userName, String password, String userType, String firstName, String lastName, String major) {
        User newUser = null;
        switch (userType.toLowerCase()) {
            case "student":
                newUser = new Student(firstName, lastName, userName, password, userType, major, null, null, studentPortfolio, null, ""); // Assuming an empty string for application area and advising notes
                break;
            case "advisor":
                newUser = new Advisor(firstName, lastName, userName, password, userType, null); 
                break;
            case "admin":
                newUser = new Admin(firstName, lastName, userName, password, userType); 
        }

        if (newUser != null) {
            System.out.println("Successfully created and added user: " + userName);
            System.out.println("New User Details: " + newUser.toString());
            // Add the new user to your user storage
            userList.createAccount(newUser);
        }
    }

    
/**
 * @param username The username of the user attempting to log in.
 * @param password The password of the user attempting to log in.
 * @param userType The type of user attempting to log in (student, admin, or advisor).
 * @return True if the login is successful, false otherwise.
 */
public boolean login(String username, String password, String userType) {
    switch (userType.toLowerCase()) {
        case "student":
            // Verify login for student user
            return UserList.getInstance().verifyLoginStudent(username, password);
        case "admin":
            // Verify login for admin user
            return UserList.getInstance().verifyLoginAdmin(username, password);
        case "advisor":
            // Verify login for advisor user
            return UserList.getInstance().verifyLoginAdvisor(username, password);
        default:
            // Invalid user type
            System.out.println("Invalid user type for login.");
            return false;
    }
}



  
    public void loginAdvisor(String username, String password) {
        user.loginAdvisor(username, password);
    }

    public void loginAdmin(String username, String password) {
        user.loginAdmin(username, password);
    }

    public void loginStudent(String username, String password) {
        user.loginStudent(username, password);
    }

    public void getAllUsers() {

    }

    public void findCourse() {

    }

    public void getMyRequiredCourses(String Major) {

    }

    public void createCourse(Course course) {
        admin.createCourse(course);
    }

    public void addCoursesToStudentPortfolio(Course course) {
        student.addCoursesToStudentPortfolio(course);
    }

    
    /**
    * Get the amount of credit hours not completed returned
    * @return int of credit hours left to be taken
    */
    public int calculateCourseCreditLeft(int completedCreditHours, int totalCreditHours) {
        return studentPortfolio.calculateCourseCreditLeft(completedCreditHours, totalCreditHours);
    }

    //public int calculateGPA(ArrayList<completedCourses>, int grade) {

    //}

    //public void displayMajorMap(ArrayList<Major>) {

    //}

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

    //public boolean viewAdviseeProfile(String userName) {

    //}

    //public String generateEightSemesterPlan(String userName) {

    //}
    
}

