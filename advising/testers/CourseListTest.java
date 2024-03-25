package advising.testers;

import advising.Course;
import advising.CourseCode;
import advising.CourseList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import advising.Semester;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseListTest {

    private CourseList courseList;

    @BeforeEach
    void setUp() {
        courseList = CourseList.getInstance();
    }

    @AfterEach
    void tearDown() {
        courseList = null;
    }

    @Test
    void testGetInstance() {
        CourseList instance1 = CourseList.getInstance();
        CourseList instance2 = CourseList.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testAddCourseAndGetCourses() {
        Course course1 = new Course("CSCE145", "Algorithmic Design I", CourseCode.CMW, 3, "A", Semester.FALL, 1);
        courseList.addCourse(course1);

        ArrayList<Course> courses = courseList.getCourses();
        assertNotNull(courses);
        assertEquals(1, courses.size());
        assertTrue(courses.contains(course1));
    }

    @Test
    void testRemoveCourse() {
        Course course1 = new Course("CSCE145", "Algorithmic Design I", CourseCode.CMW, 3, "A", Semester.FALL, 1);
        courseList.addCourse(course1);

        ArrayList<Course> coursesBeforeRemoval = courseList.getCourses();
        assertTrue(coursesBeforeRemoval.contains(course1));

        courseList.removeCourse(course1);

        ArrayList<Course> coursesAfterRemoval = courseList.getCourses();
        assertFalse(coursesAfterRemoval.contains(course1));
        assertEquals(coursesBeforeRemoval.size() - 1, coursesAfterRemoval.size());
    }

    @Test
    void testGetCourseByID() {
        Course course1 = new Course("CSCE145", "Algorithmic Design I", CourseCode.CMW, 3, "A", Semester.FALL, 1);
        courseList.addCourse(course1);

        Course retrievedCourse = courseList.getCourseByID("CSCE145");
        assertNotNull(retrievedCourse);
        assertEquals(course1, retrievedCourse);
    }
}
