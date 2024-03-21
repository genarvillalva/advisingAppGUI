package advising.testers;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.Advisor;
import advising.CourseList;
import advising.DataWriter;
import advising.Student;
import advising.User;
import advising.UserList;


public class AdvisorTest {

  private Advisor advisor;
  private ArrayList<Student> listOfAdvisedStudents;
  private String advisingNotes;
  private CourseList courseList;

  @BeforeEach
  public void setup() {

  }

  @AfterEach
  public void tearDown() {

  }

  @Test
  public void testAdvisorConstructor() {
      String firstName = "Timmy";
      String lastName = "Tim";
      String username = "timmyTimTim";
      String password = "ymmit";
      String userType = "Timmy";
      ArrayList<Student> listOfAdvisedStudents = new ArrayList<>();

      Advisor advisor = new Advisor(firstName, lastName, username, password, userType, listOfAdvisedStudents);

      // Verify that the advisor object is not null
      Assertions.assertNotNull(advisor);

      // Verify that the fields of the advisor object are set correctly
      Assertions.assertEquals(firstName, advisor.getFirstName());
      Assertions.assertEquals(lastName, advisor.getLastName());
      Assertions.assertEquals(username, advisor.getUsername());
      Assertions.assertEquals(password, advisor.getPassword());
      Assertions.assertEquals(userType, advisor.getUserType());
      Assertions.assertEquals(listOfAdvisedStudents, advisor.getListOfAdvisedStudents());
  }
  @Test
  public void testAdvisorConstructorCapital() {
      String firstName = "Timmy";
      String lastName = "Tim";
      String username = "timmyTimTim";
      String password = "ymmit";
      String userType = "Advisor";
      ArrayList<Student> listOfAdvisedStudents = new ArrayList<>();

      Advisor advisor = new Advisor(firstName, lastName, username, password, userType, listOfAdvisedStudents);

      // Verify that the advisor object is not null
      Assertions.assertNotNull(advisor);

      // Verify that the fields of the advisor object are set correctly
      Assertions.assertEquals(firstName, advisor.getFirstName());
      Assertions.assertEquals(lastName, advisor.getLastName());
      Assertions.assertEquals(username, advisor.getUsername());
      Assertions.assertEquals(password, advisor.getPassword());
      Assertions.assertEquals(userType, advisor.getUserType());
      Assertions.assertEquals(listOfAdvisedStudents, advisor.getListOfAdvisedStudents());
  }

  @Test
  public void testAddToAdviseeListByUsername() {
    String studentUsername = "Timmy";
    UserList userList = advising.UserList.getInstance();
    Student student = userList.getStudentByUsername(studentUsername);
    this.listOfAdvisedStudents.add(student);
  }

  @Test
  public void test() {
    
  }


}
  