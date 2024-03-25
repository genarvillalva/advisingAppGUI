package advising.testers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.Advisor;
import advising.Major;
import advising.Student;
import advising.StudentYear;
import advising.User;
import advising.UserList;

import java.util.ArrayList;

class AdvisorTest {
  
  private Advisor advisor;
  private ArrayList<Student> listOfAdvisedStudents;

  @BeforeEach
  public void setup() {
    // Initialize the advisor and other necessary objects before each test case
    String firstName = "Test";
    String lastName = "Test";
    String username = "Test";
    String password = "Test";
    String userType = "Advisor";
    listOfAdvisedStudents = new ArrayList<>();

    advisor = new Advisor(firstName, lastName, username, password, userType, listOfAdvisedStudents);
  }

  @AfterEach
  public void tearDown() {
    // Clean up any resources after each test case
    advisor = null;
    listOfAdvisedStudents = null;
  }

  @Test
  public void testAdvisorConstructorBottomCase() {
    Advisor advisor = new Advisor("", "", "", "", "", new ArrayList<>());

    assertEquals("", advisor.getFirstName());
    assertEquals("", advisor.getLastName());
    assertEquals("", advisor.getUsername());
    assertEquals("", advisor.getPassword());
    assertEquals("", advisor.getUserType());
    assertNotNull(advisor.getListOfAdvisedStudents());
    assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  @Test
  public void testAdvisorConstructorHighCase() {
    String longString = "This is a long string. This is a long string. This is a long string. This is a long string";
    Advisor advisor = new Advisor(longString, longString, longString, longString, longString, new ArrayList<>());

    assertEquals(longString, advisor.getFirstName());
    assertEquals(longString, advisor.getLastName());
    assertEquals(longString, advisor.getUsername());
    assertEquals(longString, advisor.getPassword());
    assertEquals(longString, advisor.getUserType());
    assertNotNull(advisor.getListOfAdvisedStudents());
    assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  @Test
  public void testAdvisorConstructorNormalCase() {
    assertEquals("John", advisor.getFirstName());
    assertEquals("Doe", advisor.getLastName());
    assertEquals("johndoe", advisor.getUsername());
    assertEquals("password", advisor.getPassword());
    assertEquals("Advisor", advisor.getUserType());
    assertNotNull(advisor.getListOfAdvisedStudents());
    assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  public void testAdvisorConstructorCapital() {
    String firstName = "Timmy";
    String lastName = "Tim";
    String username = "timmyTimTim";
    String password = "ymmit";
    String userType = "Advisor";
    ArrayList<Student> listOfAdvisedStudents = new ArrayList<>();
    ArrayList<Advisor> advisorList = new ArrayList();

    Advisor advisor = new Advisor(firstName, lastName, username, password, userType, listOfAdvisedStudents);

    // Verify that the advisor object is not null
    assertNotNull(advisor);

    // Verify that the fields of the advisor object are set correctly
    assertEquals(firstName, advisor.getFirstName());
    assertEquals(lastName, advisor.getLastName());
    assertEquals(username, advisor.getUsername());
    assertEquals(password, advisor.getPassword());
    assertEquals(userType, advisor.getUserType());
    assertEquals(listOfAdvisedStudents, advisor.getListOfAdvisedStudents());
}

  @Test
  public void testAddToAdviseeListByUsername() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Major Computer_Science = new Major("Computer Science", "Computer_Science", null, 120);
    Student student = userList.getStudentByUsername("Test");

    this.listOfAdvisedStudents.add(student);
    // Add student to advisor's list
    advisor.addToAdviseeListByUsername(student.getUsername());

    // Verify that the student is added to the list
    assertEquals(1, advisor.getListOfAdvisedStudents().size());
    assertTrue(advisor.getListOfAdvisedStudents().contains(student));
  }

  @Test
  public void testAddToAdviseeListByUsernameStudentNotFound() {
      UserList userList = UserList.getInstance();
      userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
      Major Computer_Science = new Major("Computer Science", "Computer_Science", null, 120);
      Student student = userList.getStudentByUsername("Test");
      // Add student to advisor's list
      advisor.addToAdviseeListByUsername(student.getUsername());

      // Verify that the advisor's list remains unchanged
      assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  @Test
  public void testAddToAdviseeListByUsername_DuplicateStudent() {
      // Creating test data
      UserList userList = UserList.getInstance();
      userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
      Student student = userList.getStudentByUsername("Test");
      // Add the same student twice to advisor's list
      advisor.addToAdviseeListByUsername(student.getUsername());
      advisor.addToAdviseeListByUsername(student.getUsername());

      // Verify that the student is added only once to the advisor's list
      assertEquals(1, advisor.getListOfAdvisedStudents().size());
  }

  @Test
  public void testAddToAdviseeListByUsernameStudentAlreadyAdvised() {
    
    
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("Test");

    advisor.getListOfAdvisedStudents().add(student); // Simulate adding student to advisor's list
    advisor.getListOfAdvisedStudents().add(student); // Try to add the student again
    advisor.addToAdviseeListByUsername(student.getUsername());
    
    assertEquals(1, advisor.getListOfAdvisedStudents().size());
  }

  @Test
  public void testAddToAdviseeListByUsernameNullStudent() {

    UserList userList = UserList.getInstance();
    userList.createAccount(null, "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername(null);
    advisor.addToAdviseeListByUsername(student.getUsername());
    assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  @Test
  public void testAddToAdviseeListByUsernameEmptyStudent() {
    // Test whether the system handles adding an empty string as a student username
    UserList userList = UserList.getInstance();
    userList.createAccount("", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("");
    advisor.addToAdviseeListByUsername(student.getUsername());
    // Verify that the advisor's list remains unchanged
    assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  @Test
  public void testAddStudentToAdvisorValidStudent() {
    // Test whether the system correctly adds the student to the advisor's list of advised students
    // with a valid username
    UserList userList = UserList.getInstance();
    userList.createAccount("test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("test");
    advisor.addStudentToAdvisor(student.getUsername(), advisor.getListOfAdvisedStudents());
    // Verify that the student is added to the advisor's list
    assertTrue(advisor.getListOfAdvisedStudents().contains(student));
  }

  @Test
  public void testAddStudentToAdvisorBlankUsername() {
    UserList userList = UserList.getInstance();
    userList.createAccount("", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("");
    advisor.addStudentToAdvisor(student.getUsername(), advisor.getListOfAdvisedStudents());
    assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  @Test
  public void testAddStudentToAdvisorNullUsername() {
    // Test whether the system handles adding a student to the advisor's list with a null username
    UserList userList = UserList.getInstance();
    userList.createAccount(null, "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername(null);
    advisor.addStudentToAdvisor(student.getUsername(), advisor.getListOfAdvisedStudents());
    // Verify that the advisor's list remains unchanged
    assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
    
  }

  @Test
  public void testAddAdvisorToStudentNormal() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Student", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    userList.createAccount("Advisor", "Test", "Advisor", "Test", "Test", null, null);
    Student student = userList.getStudentByUsername("Student");
    Advisor advisor = userList.getAdvisorByUsername("Advisor");
    student.setAdvisor(advisor);
    assertTrue(student.getAdvisor() == advisor);
  }

  @Test
  public void testAddAdvisorToStudentEmptyAdvisor() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Student", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    userList.createAccount("", "", "", "", "", null, null);
    Student student = userList.getStudentByUsername("Student");
    Advisor advisor = userList.getAdvisorByUsername("");
    student.setAdvisor(advisor);
    assertTrue(student.getAdvisor() == null);
  }
  @Test
  public void testAddAdvisorToStudentMoreThanOnce() {
    // Test to add the same student to an advisor more than once
    UserList userList = UserList.getInstance();
    userList.createAccount("Student", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    userList.createAccount("Advisor", "Test", "Advisor", "Test", "Test", null, null);
    Student student = userList.getStudentByUsername("Student");
    Advisor advisor = userList.getAdvisorByUsername("Advisor");
    student.setAdvisor(advisor);
    student.setAdvisor(advisor);
    student.setAdvisor(advisor);
    assertTrue(student.getAdvisor() == advisor);

  }


  @Test
  public void removeStudentFromProgramTest() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("Test");
    advisor.removeStudentFromProgram(student.getUsername(), student.getMajor());
  }
  @Test
  public void removeStudentFromProgramNotInProgramTest() {
    
    Student student = new Student("Test", null, null, null, null, "Computer Science", advisor, null, null, null, null);
    advisor.removeStudentFromProgram(student.getUsername(), student.getMajor());
  }
  @Test
  public void removeStudentFromProgramMultipleTimesTest() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Student", "Test", "Test", "Computer Science", StudentYear.FRESHMAN);
    Student student = userList.getStudentByUsername("Test");
    advisor.removeStudentFromProgram(student.getUsername(), student.getMajor());
    advisor.removeStudentFromProgram(student.getUsername(), student.getMajor());
    advisor.removeStudentFromProgram(student.getUsername(), student.getMajor());
  }

  @Test
  public void LogOutAdvisorTest() {
    UserList userList = UserList.getInstance();
    userList.createAccount("Test", "Test", "Advisor", "Test", "Test", null, null);
    Advisor advisor = userList.getAdvisorByUsername("Test");
    advisor.logout();
    assertTrue(advisor.isLoggedIn() == false);
  }
  




}