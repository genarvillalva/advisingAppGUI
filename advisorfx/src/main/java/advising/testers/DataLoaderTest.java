package advising.testers;

import static org.junit.jupiter.api.Assertions.*;

import advising.Advisor;
import advising.Course;
import advising.DataLoader;
import advising.ElectiveCluster;
import advising.Major;
import advising.Student;
import advising.StudentPortfolio;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
public class DataLoaderTest {

  private ArrayList<Student> students = DataLoader.getAllStudents();
  private ArrayList<Advisor> advisors = DataLoader.getAllAdvisors();

  @Test
    void testGetStudentsSize() {
    assertEquals(2, students.size());
    }

    @Test
    void testGetStudentsSizeZero() {
        students.clear();
        assertEquals(0, students.size());
    }
    

    @Test
    void testGetAdvisorsSize() {
    assertEquals(1, advisors.size());
    }

    @Test
    void testGetAdvisorsSizeZero() {
        advisors.clear();
        assertEquals(0, advisors.size());
    }

    @Test 
    void testGetAdvisorsGetFirsttName(){
        assertEquals("Greg", advisors.get(0).getFirstName());
    }
    @Test
    void testGetAdvisorsListOfStudents(){
        assertEquals(2, advisors.get(0).getListOfAdvisedStudents().size());
    }

    @Test
    void testFindAdvisorByUsername(){
        assertEquals("gregtomlin24", advisors.get(0).getUsername());
    }

    @Test
    void testFindAdvisorByUsernameFail(){
        assertNotEquals("genarv", advisors.get(0).getUsername());
    }

    @Test
    void testGetAllAdvisorsWithoutAdvisees(){
      ArrayList<Advisor> advisorsWithoutAdvisees = DataLoader.getAllAdvisorsWithoutAdvisees();
        assertEquals(1, advisorsWithoutAdvisees.size());
    }

    @Test
    void testGetAllAdvisorsWithoutAdviseesRightFirstName(){
        assertEquals("Greg", DataLoader.getAllAdvisorsWithoutAdvisees().get(0).getFirstName());
    }

    @Test
    void testGetAllAdvisorsWithoutAdviseesNullAdviseeList(){
        assertEquals("", DataLoader.getAllAdvisorsWithoutAdvisees().get(0).getListOfAdvisedStudents().size());
    }

    @Test
    void testGetAllAdvisorsWithoutAdviseesSizeZero(){
        ArrayList<Advisor> advisorsWithoutAdvisees = DataLoader.getAllAdvisorsWithoutAdvisees();
        advisorsWithoutAdvisees.clear();
        assertEquals(0, advisorsWithoutAdvisees.size());
    }

    @Test 
    void testGetAllCourses(){
        assertEquals(49, DataLoader.getAllCourses().size());
    }

    @Test
    void testGetAllCoursesSizeZero(){
        ArrayList<Course> courses = DataLoader.getAllCourses();
        courses.clear();
        assertEquals(0, courses.size());
    }

    @Test
    void getAllMajors(){
        assertEquals(2, DataLoader.getAllMajors().size());
    }

    @Test
    void getAllMajorsSizeZero(){
        ArrayList<Major> majors = DataLoader.getAllMajors();
        majors.clear();
        assertEquals(0, majors.size());
    }

    @Test 
    void testGetAllStudentPortfolio(){
      ArrayList<Student> students = DataLoader.getAllStudents();
      int size = 0;
      for (Student student : students) {
        if(student.getPortfolio() != null) {
          size++;
        }
      }
      assertEquals(2, size);
    }

    @Test
    void testStudentPortfolioUUID(){
        assertEquals("bwest", DataLoader.getAllStudentPortfolios().get(0).getPortfolioUUID());
    }

    @Test
    void testStudentPortfolioUUIDFail(){
        assertNotEquals("bwest", DataLoader.getAllStudentPortfolios().get(1).getPortfolioUUID());
    }

    @Test
    void testStudentPortfolioRequiredCourses(){
        assertEquals(19, DataLoader.getAllStudentPortfolios().get(0).getRequiredCourses().size());
    }

    @Test
    void testStudentPortfolioRequiredCoursesSizeZero(){
      ArrayList<Course> requiredCourses = DataLoader.getAllStudentPortfolios().get(0).getRequiredCourses();
      requiredCourses.clear();
        assertEquals(0, requiredCourses.size());
    }

    @Test
    void testStudentPortfolioCurrentCourses(){
        assertEquals(3, DataLoader.getAllStudentPortfolios().get(0).getCurrentCourses().size());
    }

    @Test
    void testStudentPortfolioCurrentCoursesSizeZero(){
      ArrayList<Course> currentCourses = DataLoader.getAllStudentPortfolios().get(0).getCurrentCourses();
      currentCourses.clear();
        assertEquals(0, currentCourses.size());
    }

    @Test
    void testStudentPortfolioNextSemesterCourses(){
      assertEquals(0, DataLoader.getAllStudentPortfolios().get(0).getNextSemesterCourses().size());
    }

    @Test
    void testStudentPortfolioNextSemesterCoursesSizeZero(){
      ArrayList<Course> nextSemesterCourses = DataLoader.getAllStudentPortfolios().get(0).getNextSemesterCourses();
      nextSemesterCourses.clear();
        assertEquals(0, nextSemesterCourses.size());
    }

    @Test 
    void testStudentPortfolioCompletedCourses(){
        assertEquals(0, DataLoader.getAllStudentPortfolios().get(0).getNextSemesterCourses().size());
    }

    @Test
    void testStudentPortfolioCompletedCoursesSizeZero(){
      HashMap<Course, Double> completedCourses = DataLoader.getAllStudentPortfolios().get(0).getCompletedCourses();
      completedCourses.clear();
        assertEquals(0, completedCourses.size());
    }

    @Test
    void testStudentPortfolioFailedCourses()
    {
        assertEquals(1, DataLoader.getAllStudentPortfolios().get(0).getFailedCourses().size());
    }

    @Test
    void testStudentPortfolioScholarships(){
        assertEquals("Life Scholarship", DataLoader.getAllStudentPortfolios().get(0).getScholarship());
    }

    @Test
    void testStudentPortfolioScholarshipsFail(){
        assertNotEquals("No Scholarship", DataLoader.getAllStudentPortfolios().get(0).getScholarship());
    }

    @Test
    void testStudentPortfolioScholarshipCreditHoursLeft(){
        assertEquals(19, DataLoader.getAllStudentPortfolios().get(0).getScholarshipCreditHoursLeft());
    }

    @Test
    void testStudentPortfolioGPA(){
        assertEquals(3.6, DataLoader.getAllStudentPortfolios().get(0).getGpa());
    }

    @Test
    void testStudentPortfolioFailCount(){
        assertEquals(1, DataLoader.getAllStudentPortfolios().get(0).getFailCount());
    }

    @Test
    void testGetAllStudentPortfolioSizeZero(){
        ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
        studentPortfolios.clear();
        assertEquals(0, studentPortfolios.size());
    }

    @Test
    void testStudentPortfolioYearCreditCount(){
        assertEquals(11, DataLoader.getAllStudentPortfolios().get(0).getYearCreditCount());
    }

    @Test
    void testStudentPortfolioTotalCreditCount(){
        assertEquals(65, DataLoader.getAllStudentPortfolios().get(0).getTotalCreditHours());
    }

    @Test
    void testStudentPortfolioTotalCreditHoursFoundDocuments(){
        assertEquals(0, DataLoader.getAllStudentPortfolios().get(0).getTotalCreditHoursFoundDocu());
    }

    @Test
    void testStudentPortfolioTotalCreditHoursCC(){
        assertEquals(6, DataLoader.getAllStudentPortfolios().get(0).getTotalCreditHoursCC());
    }

    @Test
    void testStudentPortfolioTotalCreditHoursIntegrativeCourses(){
        assertEquals(0, DataLoader.getAllStudentPortfolios().get(0).getTotalCreditHoursIntegrativeCourse());
    }

    @Test
    void testStudentPortfolioTotalCreditHoursProgramRequirements(){
        assertEquals(5, DataLoader.getAllStudentPortfolios().get(0).getTotalCreditHoursProgramRequirements());
    }

    @Test
    void testStudentPortfolioTotalCreditHoursMajorRequirements(){
        assertEquals(1, DataLoader.getAllStudentPortfolios().get(0).getTotalCreditHoursMajorRequirements());
    }

    @Test
    void testStudentPortfolioStudentElectives(){
        assertEquals(10, DataLoader.getAllStudentPortfolios().get(0).getStudentElectives().getElectives().size());
    }

    @Test 
    void testStudentPortfolioStudentElectivesSizeZero(){
        ArrayList<ElectiveCluster> studentElectives = DataLoader.getAllStudentPortfolios().get(0).getStudentElectives().getElectives();
        studentElectives.clear();
        assertEquals(0, studentElectives.size());
    }

    @Test
    void testStudentPortfolioStudentElectivesClusterName(){
        assertEquals("Lab Science Electives", DataLoader.getAllStudentPortfolios().get(0).getStudentElectives().getElectives().get(0).getElectiveName());
    }

  @AfterEach
  public void tearDown() {
    students.clear();
    advisors.clear();
  }
}
