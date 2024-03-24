package advising.testers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.Advisor;
import advising.Student;
import advising.StudentPortfolio;
import advising.StudentYear;

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
    public void testGetAdvisingNotes_NoNotes() {
        // Test when there are no advising notes
        assertEquals("", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotes_SingleNote() {
        // Test when there is a single advising note
        student.addAdvisingNotes("Note 1");
        assertEquals("Note 1\n", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotes_MultipleNotes() {
        // Test when there are multiple advising notes
        student.addAdvisingNotes("Note 1");
        student.addAdvisingNotes("Note 2");
        assertEquals("Note 1\nNote 2\n", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotes_EmptyNote() {
        // Test when an empty note is added
        student.addAdvisingNotes("");
        assertEquals("\n", student.getAdvisingNotes());
    }

    @Test
    public void testGetAdvisingNotes_NullNote() {
        // Test when a null note is added
        student.addAdvisingNotes(null);
        assertEquals("", student.getAdvisingNotes());
    }
    

}