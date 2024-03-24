package advising.testers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.Advisor;
import advising.Student;
import advising.UserList;

import java.util.ArrayList;

class AdvisorTest {

  private Advisor advisor;
  private ArrayList<Student> listOfAdvisedStudents;

  @BeforeEach
  public void setup() {
    // Initialize the advisor and other necessary objects before each test case
    String firstName = "John";
    String lastName = "Doe";
    String username = "johndoe";
    String password = "password";
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
    Student student = new Student("Timmy", "Tim", "TimTim", "password", "student", "Computer_Science", advisor, null, null, null, null);
    UserList userList = advising.UserList.getInstance();
    student = userList.getStudentByUsername(student.getUsername());
    this.listOfAdvisedStudents.add(student);
    // Add student to advisor's list
    advisor.addToAdviseeListByUsername(student.getUsername());

    // Verify that the student is added to the list
    assertEquals(1, advisor.getListOfAdvisedStudents().size());
    assertTrue(advisor.getListOfAdvisedStudents().contains(student));
  }

  @Test
  public void testAddToAdviseeListByUsername_StudentNotFound() {
      // Creating test data
      String studentUsername = "nonexistentstudent";

      // Add student to advisor's list
      advisor.addToAdviseeListByUsername(studentUsername);

      // Verify that the advisor's list remains unchanged
      assertTrue(advisor.getListOfAdvisedStudents().isEmpty());
  }

  @Test
  public void testAddToAdviseeListByUsername_DuplicateStudent() {
      // Creating test data
      Student student = new Student("Timmy", "Tim", "TimTim", "password", "student", "Computer_Science", advisor, null, null, null, null);

      // Add the same student twice to advisor's list
      advisor.addToAdviseeListByUsername(student.getUsername());
      advisor.addToAdviseeListByUsername(student.getUsername());

      // Verify that the student is added only once to the advisor's list
      assertEquals(1, advisor.getListOfAdvisedStudents().size());
  }
  






  
}