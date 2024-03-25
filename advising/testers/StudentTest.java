package advising.testers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.Advisor;
import advising.Course;
import advising.CourseCode;
import advising.ElectiveCluster;
import advising.Major;
import advising.Semester;
import advising.Student;
import advising.StudentElectives;
import advising.StudentPortfolio;
import advising.StudentYear;
import advising.UserList;
import advising.DataLoader;
import advising.DataWriter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;
    private Advisor advisor;

    @BeforeEach
    public void setUp() {
        // Initialize sample student and advisor
        advisor = new Advisor("Alice", "Johnson", "alicej", "pass456", "Advisor", new ArrayList<Student>());
        student = new Student("John", "Doe", "johndoe", "password123", "Student", "Computer_Science", advisor, StudentYear.FRESHMAN, null, "Application Area", null);
        UserList userList = UserList.getInstance();
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testSetAdvisor() {
        advisor = new Advisor("Alice", "Johnson", "alicej", "pass456", "Advisor", new ArrayList<Student>());
        student.setAdvisor(advisor);
        assertEquals(advisor, student.getAdvisor());
    }

    @Test
    public void testGetAdvisingNotes() {
        // Test for no advising notes initially
        assertEquals("", student.getAdvisingNotes());

        // Test after adding advising notes
        student.addAdvisingNotes("Note 1");
        student.addAdvisingNotes("Note 2");
        assertEquals("Note 1\nNote 2\n", student.getAdvisingNotes());
    }
    @Test
    public void testGetAdvisingNotesNoNotes() {
        // Test when there are no advising notes
        assertEquals("", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotesSingleNote() {
        // Test when there is a single advising note
        student.addAdvisingNotes("Note 1");
        assertEquals("Note 1\n", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotesMultipleNotes() {
        // Test when there are multiple advising notes
        student.addAdvisingNotes("Note 1");
        student.addAdvisingNotes("Note 2");
        assertEquals("Note 1\nNote 2\n", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotesEmptyNote() {
        // Test when an empty note is added
        student.addAdvisingNotes("");
        assertEquals("\n", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotesNullNote() {
        // Test when a null note is added
        student.addAdvisingNotes(null);
        assertEquals(null, student.getAdvisingNotes());
    }
    @Test
    public void testAddAdvisingNotesMultipleStudents() {
        // Create multiple students and an advisor
        UserList userList = UserList.getInstance();
        userList.createAccount("Student1", "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        userList.createAccount("Student2", "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        userList.createAccount("Advisor", "Test", "Advisor", "Test", "Test", null, null);
        Student student1 = userList.getStudentByUsername("Student1");
        Student student2 = userList.getStudentByUsername("Student2");
        Advisor advisor = userList.getAdvisorByUsername("Advisor");

        // Add advising notes for both students
        student1.addAdvisingNotes("Note 1");
        student2.addAdvisingNotes("Note 2");

        // Check if the notes are added correctly for each student
        assertEquals("Note 1\n", student1.getAdvisingNotes());
        assertEquals("Note 2\n", student2.getAdvisingNotes());
    }
    
    @Test
    public void LogOutStudentTest() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("Test");
    student.logout();
    assertTrue(student.isLoggedIn() == false);
    }
    

}