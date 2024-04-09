package advising;


import java.util.ArrayList;
import java.util.HashMap;

public class Faculty extends User {
    private CourseList courseList;
    private User user;
    private UserList userList;
    private Student student;
    private StudentPortfolio studentPortfolio;
    private HashMap<String, StudentPortfolio> studentPortfolios;

  
    public Faculty(String firstName, String lastName, String username, String password, String userType) {
        super(firstName, lastName, username, password, userType);
        this.courseList = courseList;
        this.studentPortfolio = studentPortfolio;
        this.userList = userList;
        this.studentPortfolios = new HashMap<>();
        }

     
    /**
    * Takes in all of the atrabutes a student has and returns a print statement with all of them 
    * @return String of student portfolio
    */

    public String searchStudentProfile(String username) {
        ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
        StringBuilder profileDetails = new StringBuilder();

        for (StudentPortfolio portfolio : studentPortfolios) {
            if (user.getUsername().equals(username)) {
                profileDetails.append("Username: ").append(user.getUsername()).append("\n");
                profileDetails.append("Portfolio UUID: ").append(studentPortfolio.getPortfolioUUID()).append("\n");
                profileDetails.append("Required Courses: ").append(portfolio.getRequiredCourses()).append("\n");
                profileDetails.append("Eight Semester Plan: ").append(portfolio.getEightSemesterPlan()).append("\n");
                profileDetails.append("Current Courses: ").append(portfolio.getCurrentCourses()).append("\n");
                profileDetails.append("Completed Courses: ").append(portfolio.getCompletedCourses()).append("\n");
                profileDetails.append("Failed Courses: ").append(portfolio.getFailedCourses()).append("\n");
                profileDetails.append("Scholarship: ").append(portfolio.getScholarship()).append("\n");
                profileDetails.append("Yearly Scholarship Credit Hours Left: ").append(studentPortfolio.getScholarshipCreditHoursLeft()).append("\n");
                profileDetails.append("GPA: ").append(portfolio.getGpa()).append("\n");
                profileDetails.append("Fail Count: ").append(portfolio.getFailCount()).append("\n");
                profileDetails.append("Semester Credit Count: ").append(portfolio.getSemesterCreditCount()).append("\n");
                profileDetails.append("Year Credit Hours: ").append(studentPortfolio.getYearCreditCount()).append("\n");
                profileDetails.append("Total Credit Hours: ").append(portfolio.getTotalCreditHours()).append("\n");
                profileDetails.append("Total Credit Hours Found Documentaries: ").append(portfolio.getTotalCreditHoursFoundDocu()).append("\n");
                profileDetails.append("Total Credit Hours CC: ").append(portfolio.getTotalCreditHoursCC()).append("\n");
                profileDetails.append("Total Credit Hours Integrative Course: ").append(portfolio.getTotalCreditHoursIntegrativeCourse()).append("\n");
                profileDetails.append("Total Credit Hours Program Requirements: ").append(portfolio.getTotalCreditHoursProgramRequirements()).append("\n");
                profileDetails.append("Total Credit Hours Major Requirements: ").append(portfolio.getTotalCreditHoursMajorRequirements()).append("\n");
                profileDetails.append("Elective Clusters: ").append(studentPortfolio.getStudentElectives()).append("\n");
            break;
            }
        }
    return profileDetails.toString();
    }
    
    // Method to access a student's profile using their username.
    public StudentPortfolio accessStudentProfile(String username) {
        return studentPortfolios.get(username);
    }
    
    // Method to input or update the grades of a student.
    public void inputStudentGrades(String username, Course course, double grade) {
        accessStudentProfile(username);
        if(studentPortfolio != null) {
            studentPortfolio.getCompletedCourses().put(course, grade);
        } else {
            System.out.println("Student profile not found for username: " + username);
        }
    }
    
    /**
     * Finds the course from course list
     * @param course
     */
    public void courseLookup(String course) {
        courseList.findCourse(course);
    }

}

