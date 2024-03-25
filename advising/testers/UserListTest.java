package advising.testers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import advising.UserList;
import advising.Admin;
import advising.Advisor;
import advising.Student;
import advising.StudentYear;

class UserListTest {

    @Test
    void testGetInstance() {
        UserList userList1 = UserList.getInstance();
        UserList userList2 = UserList.getInstance();
        assertSame(userList1, userList2);
    }

    @Test
    void testCreateAccount() {
        UserList userList = UserList.getInstance();
        userList.createAccount("testStudent", "password", "student", "John", "Doe", "Computer Science", StudentYear.FRESHMAN);
        userList.createAccount("testAdvisor", "password", "advisor", "Jane", "Smith", null, null);
        userList.createAccount("testAdmin", "password", "admin", "Admin", "Admin", null, null);

        // Check if accounts were created successfully
        assertTrue(userList.userExists("testStudent"));
        assertTrue(userList.userExists("testAdvisor"));
        assertTrue(userList.userExists("testAdmin"));
    }

    @Test
    void testVerifyLoginStudent() {
        UserList userList = UserList.getInstance();
        userList.createAccount("testStudent", "password", "student", "John", "Doe", "Computer Science", StudentYear.FRESHMAN);
        
        // Test valid login
        assertTrue(userList.verifyLoginStudent("testStudent", "password"));

        // Test invalid login
        assertFalse(userList.verifyLoginStudent("testStudent", "wrongpassword"));
    }

    @Test
    void testVerifyLoginAdvisor() {
        UserList userList = UserList.getInstance();
        userList.createAccount("testAdvisor", "password", "advisor", "Jane", "Smith", null, null);

        // Test valid login
        assertTrue(userList.verifyLoginAdvisor("testAdvisor", "password"));

        // Test invalid login
        assertFalse(userList.verifyLoginAdvisor("testAdvisor", "wrongpassword"));
    }

    @Test
    void testVerifyLoginAdmin() {
        UserList userList = UserList.getInstance();
        userList.createAccount("testAdmin", "password", "admin", "Admin", "Admin", null, null);

        // Test valid login
        assertTrue(userList.verifyLoginAdmin("testAdmin", "password"));

        // Test invalid login
        assertFalse(userList.verifyLoginAdmin("testAdmin", "wrongpassword"));
    }

    @Test
    void testRemoveStudentFromProgram() {
        UserList userList = UserList.getInstance();
        userList.createAccount("testStudent", "password", "student", "John", "Doe", "Computer Science", StudentYear.FRESHMAN);

        // Remove student from program
        userList.removeStudentFromProgram("testStudent", "Computer Science");

        // Check if student is removed
        assertFalse(userList.userExists("testStudent"));
    }

}
