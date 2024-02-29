package advising;

    public class Faculty extends User {
        private CourseList courseList;
  
  
    public Faculty(String firstName, String lastName, String username, String password, String userType) {
            super(firstName, lastName, username, password, userType);
            this.courseList = courseList;
        }

    // Returns a String, which could be details of the student profile.
    public String searchStudentProfile(String username) {
       
        return "Student Profile Details for " + username;
    }
    
    // Method to access a student's profile using their username.
    public void accessStudentProfile(String username) {
       
    }
    
    // Method to input or update the grades of a student.
    public void inputStudentGrades(int grade) {
        
    }

    public void courseLookup(String course) {
        courseList.findCourse(course);
    }
    

}

