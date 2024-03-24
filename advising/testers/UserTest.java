package advising.testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.UserList;
import advising.Student;
import advising.StudentYear;
import advising.User;

class UserTest {

    private User user;

    @BeforeEach
    public void setup() {
        user = new User("First", "Last", "username", "password", "Student") {
            @Override
            public void courseLookup(String course) {
  
            }
        };
    }

    @AfterEach
    public void tearDown() {
        user = null;
    }

    @Test
    public void loginStudentSuccessfulTest() {
        // Create a new user list instance
        UserList userList = UserList.getInstance();
    
        // Create a new student account
        userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        
        // Retrieve the student object
        Student student = userList.getStudentByUsername("Test");
    
        // Call loginStudent with valid credentials directly on the student object
        student.loginStudent(student.getUsername(), student.getPassword());
    
        // Check if the student is logged in
        assertTrue(student.isLoggedIn() == true);
    }

    @Test
    public void testLoginStudent_Failed() {
        // Mock the UserList's verifyLoginStudent method to return false
        UserList.getInstance().verifyLoginStudent("invaliduser", "invalidpassword");
        // Call loginStudent with invalid credentials
        user.loginStudent("invaliduser", "invalidpassword");
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginStudent_NullUsername() {
        // Call loginStudent with null username
        user.loginStudent(null, "password");
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginStudent_NullPassword() {
        // Call loginStudent with null password
        user.loginStudent("johndoe", null);
        assertFalse(user.isLoggedIn());
    }
}