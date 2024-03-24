package advising.testers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.Advisor;
import advising.Course;
import advising.ElectiveCluster;
import advising.Major;
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
        assertEquals("", student.getAdvisingNotes());
    }
    @Test
    public void testDisplayMajorMap() {
        // Create a Major object with actual courses
        UserList userList = UserList.getInstance();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ArrayList requiredCourses = new ArrayList();
        requiredCourses.add("CSCE145");
        requiredCourses.add("MATH141");
        requiredCourses.add("ENGL101");
        requiredCourses.add("CSCE190");

        // Call the method and capture the output in a StringBuilder
        
        userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
        Major Computer_Science = new Major("Computer Science", "Computer_Science", requiredCourses, 120);

        StringBuilder output = new StringBuilder();
  

        student.displayMajorMap(Computer_Science);
  

    }
    

}