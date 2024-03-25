package advising.testers;

import advising.Course;
import advising.CourseCode;
import advising.Semester;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    @Test
    public void testPrereqCompleteAllCompleted() {
        Course prereqCourse1 = new Course("CHEM111", "Prerequisite Course 1", CourseCode.SCI, 3, "C", Semester.FALL, 1);
        Course prereqCourse2 = new Course("CHEM112", "Prerequisite Course 2", CourseCode.SCI, 3, "C", Semester.SPRING, 1);
        
        // Create completed courses list
        Course completedCourse1 = new Course("CHEM111", "Completed Course 1", CourseCode.SCI, 3, "A", Semester.FALL, 1);
        Course completedCourse2 = new Course("PHYS111", "Completed Course 2", CourseCode.CMW, 3, "A", Semester.SPRING, 1);
        
        // Add prerequisite courses to completed courses list
        completedCourse1.addPrereq(prereqCourse1);
        completedCourse2.addPrereq(prereqCourse2);

        // Create a course with prerequisite courses
        Course course = new Course("CHEM333", "Course 1", CourseCode.SCI, 3, "B", Semester.FALL, 2);
        course.addPrereq(prereqCourse1);
        course.addPrereq(prereqCourse2);

        ArrayList<Course> completedCourses = new ArrayList<>(Arrays.asList(completedCourse1, completedCourse2));
        // Test PrereqComplete method
        assertTrue(course.PrereqComplete(course.getPrerequisiteCourses(), completedCourses));
    }

    @Test
    public void testPrereqCompleteNotAllCompleted() {
        // Create prerequisite courses
        Course prereqCourse1 = new Course("CHEM112", "Prerequisite Course 1", CourseCode.SCI, 3, "C", Semester.FALL, 1);
        Course prereqCourse2 = new Course("PHYS112", "Prerequisite Course 2", CourseCode.SCI, 3, "C", Semester.SPRING, 1);
        
        // Create completed courses list with only one completed course
        Course completedCourse1 = new Course("CHEM111", "Completed Course 1", CourseCode.SCI, 3, "A", Semester.FALL, 1);
        
        // Add prerequisite courses to completed courses list
        completedCourse1.addPrereq(prereqCourse1);

        // Create a course with prerequisite courses
        Course course = new Course("CHEM333", "Course 1", CourseCode.GHS, 3, "B", Semester.FALL, 2);
        course.addPrereq(prereqCourse1);
        course.addPrereq(prereqCourse2);

        ArrayList<Course> completedCourses = new ArrayList<>(Arrays.asList(completedCourse1));
        assertFalse(course.PrereqComplete(course.getPrerequisiteCourses(), completedCourses));
    }
    @Test
    public void testPrereqCompleteEmptyPrereq() {
        // Create a course with no prerequisite courses
        Course prereqCourse1 = new Course("CHEM111", "Prerequisite Course 1", CourseCode.SCI, 3, "C", Semester.FALL, 1);
        Course course = new Course("GHS", "Course 1", CourseCode.GHS, 3, "B", Semester.FALL, 2);

        // Test PrereqComplete method with empty prerequisite courses list
        ArrayList<Course> completedCourses = new ArrayList<>(Arrays.asList());
        assertTrue(course.PrereqComplete(course.getPrerequisiteCourses(), completedCourses));
    }

    @Test
    public void testPrereqCompleteNullPrereq() {
        // Create a course with null prerequisite courses
        Course course = new Course("HIST111", "Course 1", CourseCode.GHS, 3, "B", Semester.FALL, 2);
        course.addPrereq(null);

        // Test PrereqComplete method with null prerequisite course
        ArrayList<Course> completedCourses = new ArrayList<>(Arrays.asList(course));
        assertFalse(course.PrereqComplete(course.getPrerequisiteCourses(), completedCourses));
    }

    @Test
    public void testPrereqCompleteNoCompletedCourses() {
        // Create a course with prerequisite courses
        Course prereqCourse1 = new Course("VSR", "Prerequisite Course 1", CourseCode.SCI, 3, "C", Semester.FALL, 1);
        Course prereqCourse2 = new Course("PR102", "Prerequisite Course 2", CourseCode.CMW, 3, "C", Semester.SPRING, 1);

        // Create a course with prerequisite courses but no completed courses
        Course course = new Course("GHS", "Course 1", CourseCode.GHS, 3, "B", Semester.FALL, 2);
        course.addPrereq(prereqCourse1);
        course.addPrereq(prereqCourse2);

       ArrayList<Course> completedCourses = new ArrayList<>(Arrays.asList());
        assertFalse(course.PrereqComplete(course.getPrerequisiteCourses(), completedCourses));
    }
}
