package advising;

import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    /**
     * Loads the arrayList course with all courses in a JSON
     */
    private CourseList() {
        courses = DataLoader.getAllCourses();
    }
    /**
     * Gets an instance of the CourseList singleton if it exists, otherwise creates a new instance.
     */
    public CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    public void findCourse(String course) {
        
    }
    public void addCourse(Course course) {
        
    }
    public void removeCourse(Course course) {

    }
}
