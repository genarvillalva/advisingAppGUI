package advising;

public class CourseList {
    private static CourseList courseList;

    private CourseList() {

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
}
