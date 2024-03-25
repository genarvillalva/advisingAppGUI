package advising.testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.UserList;
import advising.Admin;
import advising.Advisor;
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
    public void loginStudentNormalTest() {
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        Student student = userList.getStudentByUsername("Test");
        user.loginStudent(student.getUsername(), student.getPassword());
        assertTrue(student.isLoggedIn() == true);
    }

    @Test
    public void testLoginStudentNullUsername() {
        UserList userList = UserList.getInstance();
        userList.createAccount(null, "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        Student student = userList.getStudentByUsername(null);
        user.loginStudent(student.getUsername(), student.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginStudentNullPassword() {
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", null, "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        Student student = userList.getStudentByUsername("Test");
        student.loginStudent(student.getUsername(), student.getPassword());
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoginStudentEmptyName() {
        UserList userList = UserList.getInstance();
        userList.createAccount("", "test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        Student student = userList.getStudentByUsername("");
        student.loginStudent("", student.getPassword());
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoginStudentEmptyPassword() {
        UserList userList = UserList.getInstance();
        userList.createAccount("test", "", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        Student student = userList.getStudentByUsername("test");
        student.loginStudent("", student.getPassword());
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoginStudentMismatchCapitals() {
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
        Student student = userList.getStudentByUsername("Test");
        user.loginStudent("test", student.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void loginAdvisorNormalTest() {
        user.isLoggedIn();
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", "Test", "Advisor", "Test", "Test", null, null);
        Advisor advisor = userList.getAdvisorByUsername("Test");
        user.loginAdvisor(advisor.getUsername(), advisor.getPassword());
        assertTrue(user.isLoggedIn());
    }

    @Test
    public void testLoginAdvisorNullUsername() {
        UserList userList = UserList.getInstance();
        userList.createAccount(null, "Test", "Advisor", "Test", "Test", null, null);
        Advisor advisor = userList.getAdvisorByUsername(null);
        user.loginAdvisor(advisor.getUsername(), advisor.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginAdvisorNullPassword() {
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", null, "Advisor", "Test", "Test", null, null);
        Advisor advisor = userList.getAdvisorByUsername("Test");
        user.loginAdvisor(advisor.getUsername(), null);
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoginAdvisorEmptyName() {
        UserList userList = UserList.getInstance();
        userList.createAccount("", "Test", "Advisor", "Test", "Test", null, null);
        Advisor advisor = userList.getAdvisorByUsername("");
        user.loginAdvisor(advisor.getUsername(), advisor.getPassword());
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoginAdvisorEmptyPassword() {
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", "", "Advisor", "Test", "Test", null, null);
        Advisor advisor = userList.getAdvisorByUsername("Test");
        user.loginAdvisor(advisor.getUsername(), advisor.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginAdvisorMismatchCapitals() {
        UserList userList = UserList.getInstance();
        userList.createAccount("TestingName", "Test", "Advisor", "Test", "Test", null, null);
        Advisor advisor = userList.getAdvisorByUsername("TestingName");
        user.loginAdvisor("testingname", advisor.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void loginAdminNormalTest() {
        user.isLoggedIn();
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", "Test", "Admin", "Test", "Test", null, null);
        Admin admin = userList.getAdminByUsername("Test");
        user.loginAdmin(admin.getUsername(), admin.getPassword());
        assertTrue(user.isLoggedIn());
    }

    @Test
    public void testLoginAdminNullUsername() {
        UserList userList = UserList.getInstance();
        userList.createAccount(null, "Test", "Admin", "Test", "Test", null, null);
        Admin admin = userList.getAdminByUsername(null);
        user.loginAdmin(admin.getUsername(), admin.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginAdminNullPassword() {
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", null, "Admin", "Test", "Test", null, null);
        Admin admin = userList.getAdminByUsername("Test");
        user.loginAdvisor(admin.getUsername(), null);
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoginAdminEmptyName() {
        UserList userList = UserList.getInstance();
        userList.createAccount("", "Test", "Admin", "Test", "Test", null, null);
        Admin admin = userList.getAdminByUsername("");
        user.loginAdmin(admin.getUsername(), admin.getPassword());
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoginAdminEmptyPassword() {
        UserList userList = UserList.getInstance();
        userList.createAccount("Test", "", "ADmin", "Test", "Test", null, null);
        Admin admin = userList.getAdminByUsername("Test");
        user.loginAdvisor(admin.getUsername(), admin.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginAdminMismatchCapitals() {
        UserList userList = UserList.getInstance();
        userList.createAccount("TestingName", "Test", "Admin", "Test", "Test", null, null);
        Admin admin = userList.getAdminByUsername("TestingName");
        user.loginAdmin("testingname", admin.getPassword());
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testLoginNonExistent() {
        user.loginAdmin("fakename", "fakepass");
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void LogOutStudentTest() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("Test");
    student.logout();
    assertTrue(user.isLoggedIn() == false);
    }

    @Test
    public void LogOutAdvisorTest() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Advisor", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
    Advisor advisor = userList.getAdvisorByUsername("Test");
    advisor.logout();
    assertTrue(user.isLoggedIn() == false);
    }

    @Test
    public void LogOutAdminTest() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Admin", "Test", "Test", "Computer_Science", StudentYear.FRESHMAN);
    Admin admin = userList.getAdminByUsername("Test");
    admin.logout();
    assertTrue(user.isLoggedIn() == false);
    }

}