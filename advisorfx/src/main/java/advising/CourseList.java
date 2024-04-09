package advising;

import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private static ArrayList<Course> courses;

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

    /**
     * Finds the course from course list
     * @param course
     */
    public void findCourse(String course) {
        courseList.findCourse(course);
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        }
       

   
   
    /**
     * Removes a course from the list of courses
     * @param course The course to remove
     */

     public void removeCourse(Course course) {
            if (courses != null) {
                courses.remove(course);
            }
        }

        /**
 * Get the course by its ID
 * @param courses list of all courses
 * @param courseID the ID of the course
 * @return the course with the given ID
 */
    public static Course getCourseByID(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }
}
