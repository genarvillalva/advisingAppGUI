package advising;

import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    /**
     * Loads the arrayList course with all courses in a JSON
     */
    public CourseList() {
        courses = DataLoader.getAllCourses();
    }
    /**
     * Gets an instance of the CourseList singleton if it exists, otherwise creates a new instance.
     */
    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }
    /**
     * Gets the list of courses
     * @return The list of courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void findCourse(String course) {
        
    }
    public void addCourse(Course course) {
        
    }
    public void removeCourse(Course course) {

    }
    public Course getCourseByID(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }
}
