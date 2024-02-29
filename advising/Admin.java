package advising;

import java.util.ArrayList;

public class Admin extends User {
    private CourseList courseList;

    public Admin(String firstName, String lastName, String username, String password, String userType) {
        super(firstName, lastName, username, password, userType);
        this.courseList = courseList;        
    }

    private ArrayList<Student> listOfAllStudents;

    // Method to create a course
    public void createCourse(Course course) {
        
    }

    // Method to delete a course
    public void deleteCourse(Course course) {
       
    }


    public void courseLookup(String course) {
        courseList.findCourse(course);
    }  

}

