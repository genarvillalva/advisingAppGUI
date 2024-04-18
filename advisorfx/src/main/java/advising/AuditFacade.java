package advising;

import java.util.ArrayList;
import java.util.List;

public class AuditFacade {
    private User user;
    private UserList userList;
    private Admin admin;
    private Student student;
    private StudentPortfolio studentPortfolio;
    private Advisor advisor;
    private static AuditFacade auditFacade; 
    
    // private RequiredCourses requiredCourses;

    public static AuditFacade getInstance(){
        if(auditFacade == null) {
            auditFacade = new AuditFacade();
        }
        return auditFacade;
    }
    private AuditFacade() {
        this.userList = UserList.getInstance(); // This line ensures userList is initialized
    }
    public AuditFacade(Advisor advisor) {
        this.advisor = advisor;
    }
    public void signUp(String userName, String password, String userType, String firstName, String lastName, String major, StudentYear studentYear) {
        userList.createAccount(userName, password, userType, firstName, lastName, major, studentYear);
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
                boolean success = UserList.getInstance().verifyLoginAdvisor(username, password);
                if (success) {
                    // Set the logged-in advisor
                    advisor = UserList.getInstance().getAdvisor(username);
                }
                return success;
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

    public void adviseStudent(String notes, String username) {
        advisor.addAdvisingNotes(notes, username);

    }


    public Student lookUpStudent(String advisorUsername, String studentUsername) {
        return advisor.lookUpStudent(studentUsername);
            
    }

    public Advisor getAdvisor() {
        return userList.getCurrentAdvisor();
    }

    public Student getStudent() {
        UserList ul = UserList.getInstance();
        return ul.getCurrentStudent();
    }
    public void addStudentToAdvisor(String studentUsername) {
        if (advisor != null) {
            advisor.addStudentToAdvisor(studentUsername, advisor.getListOfAdvisedStudents());
        } else {
            System.out.println("Advisor not logged in.");
        }
    }

    public void addAdvisee(String studentUsername) {
        Advisor advisor = userList.getCurrentAdvisor();
        advisor.addStudentToAdvisor(studentUsername, advisor.getListOfAdvisedStudents());
    }


    public Student getStudentByUsername(String username) {
        return userList.getStudentByUsername(username);
    }

    public void logoutAdvisor() {
        advisor.logout();
    }
    
    public void logoutStudent() {
        student.logout();
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

    /**
     * Generate an eight semester plan for the current student.
     */
    // public void generateEightSemesterPlan() {
    //     UserList userList = UserList.getInstance();
    //     ArrayList<Student> students = userList.getStudents();
    //     Student student = userList.getCurrentStudent();
    //     student.getPortfolio().generateEightSemesterPlan();
    //     DataWriter.saveStudents(students);
    // }


    
}

