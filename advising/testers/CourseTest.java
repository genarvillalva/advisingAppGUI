package advising.testers;

import advising.Course;
import advising.CourseCode;
import advising.Semester;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void testToString() {
        //  prerequisite courses
        Course prereqCourse1 = new Course("PR101", "Prerequisite Course 1", CourseCode.PR, 3, "A", Semester.FALL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 1);
        Course prereqCourse2 = new Course("PR102", "Prerequisite Course 2", CourseCode.PR, 3, "A", Semester.SPRING, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 1);
        ArrayList<Course> prerequisiteCourses = new ArrayList<>();
        prerequisiteCourses.add(prereqCourse1);
        prerequisiteCourses.add(prereqCourse2);

        //  corequisite courses
        Course coreqCourse1 = new Course("CR101", "Corequisite Course 1", CourseCode.CMS, 3, "A", Semester.FALL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 1);
        ArrayList<Course> corequisiteCourses = new ArrayList<>();
        corequisiteCourses.add(coreqCourse1);

        //  prereq-coreq courses
        Course prereqCoreqCourse1 = new Course("PCR101", "Prereq-Coreq Course 1", CourseCode.MR, 3, "A", Semester.SPRING, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 1);
        ArrayList<Course> prereqCoreqCourses = new ArrayList<>();
        prereqCoreqCourses.add(prereqCoreqCourse1);

        // Create the course to test
        Course course = new Course("CSCE145", "AlgorithmicDeisgn", CourseCode.CMW, 3, "A", Semester.FALL, prerequisiteCourses, corequisiteCourses, prereqCoreqCourses, 1);

        String expected = "CourseID: CSCE145\n" +
                "Title: AlgorithmicDeisgn\n" +
                "Course Code: CMW\n" +
                "Credit Hours: 3\n" +
                "Minimum Grade: A\n" +
                "Semester: FALL\n" +
                "Prerequisite Courses: Prerequisite Course 1, Prerequisite Course 2\n" +
                "Corequisite Courses: Corequisite Course 1\n" +
                "PrereqCoreq: Prereq-Coreq Course 1\n";

        // Test the toString method
        assertEquals(expected, course.toString());
    }
}
