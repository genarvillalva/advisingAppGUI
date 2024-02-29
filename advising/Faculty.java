package advising;

    public class Faculty extends User {
        private CourseList courseList;
        private StudentPortfolio studentPortfolio;
        private UserList userList;
  
  
    public Faculty(String firstName, String lastName, String username, String password, String userType) {
        super(firstName, lastName, username, password, userType);
        this.courseList = courseList;
        this.studentPortfolio = studentPortfolio;
        this.userList = userList;
        }

    // Returns a String, which could be details of the student profile.
    public String searchStudentProfile(String username) {
       
        return "Student Profile Details for " + username;
    }
    
    // Method to access a student's profile using their username.
    public void accessStudentProfile(String username) {
        
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

    public void courseLookup(String course) {
        courseList.findCourse(course);
    }
    

}

