package advising;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Loads data from JSON to the program
 * @author Genar Villalva
 */
public class DataLoader extends DataConstants {

  private static Advisor findAdvisorByUsername(
    ArrayList<Advisor> advisors,
    String username
  ) {
    for (Advisor advisor : advisors) {
      if (advisor.getUsername().equals(username)) {
        return advisor;
      }
    }
    throw new IllegalArgumentException(
      "Advisor with username " + username + " not found"
    );
  }

  /**
   * Reads the students.json file and returns an ArrayList of Students
   * @return ArrayList<Student>
   */
  public static ArrayList<Student> getAllStudents() {
    ArrayList<Advisor> advisors = getAllAdvisors();
    ArrayList<Student> students = new ArrayList<Student>();

    try {
      FileReader reader = new FileReader("advising/json/students.json");
      JSONParser parser = new JSONParser();
      JSONArray studentsJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < studentsJSON.size(); i++) {
        JSONObject studentJSON = (JSONObject) studentsJSON.get(i);
        String advisorUsername = (String) studentJSON.get("advisor");
        Advisor advisor = findAdvisorByUsername(advisors, advisorUsername);
        Student student = new Student(
          (String) studentJSON.get(FIRST_NAME),
          (String) studentJSON.get(LAST_NAME),
          (String) studentJSON.get(USER_NAME),
          (String) studentJSON.get(PASSWORD),
          (String) studentJSON.get(TYPE),
          (String) studentJSON.get(MAJOR),
          (Advisor) studentJSON.get(advisor),
          (StudentYear) studentJSON.get(STUDENT_YEAR),
          (StudentPortfolio) studentJSON.get(PORTFOLIO_UUID),
          (String) studentJSON.get(APPLICATION_AREA)
        );
        students.add(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return students;
  }

  /**
   * Reads the advisors.json file and returns an ArrayList of Advisors
   * @return ArrayList<Advisor>
   */
  public static ArrayList<Advisor> getAllAdvisors() {
    ArrayList<Advisor> advisors = new ArrayList<Advisor>();
    try {
      FileReader reader = new FileReader("advising/json/advisors.json");
      JSONParser parser = new JSONParser();
      JSONArray advisorsJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < advisorsJSON.size(); i++) {
        JSONObject advisorJSON = (JSONObject) advisorsJSON.get(i);
        Advisor advisor = new Advisor(
          (String) advisorJSON.get(FIRST_NAME),
          (String) advisorJSON.get(LAST_NAME),
          (String) advisorJSON.get(USER_NAME),
          (String) advisorJSON.get(PASSWORD),
          (ArrayList<Student>) advisorJSON.get(LIST_OF_ADVISED_STUDENTS)
        );
        advisors.add(advisor);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return advisors;
  }

  /**
   * Reads the Course.json file and returns an ArrayList of Courses
   * @return ArrayList<Course>
   */
  public static ArrayList<Course> getAllCourses() {
    ArrayList<Course> courses = new ArrayList<Course>();
    try {
      FileReader reader = new FileReader("advising/json/Course.json");
      JSONParser parser = new JSONParser();
      JSONArray coursesJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < coursesJSON.size(); i++) {
        JSONObject courseJSON = (JSONObject) coursesJSON.get(i);
        CourseCode courseCode = CourseCode.valueOf(
          (String) courseJSON.get("courseCode")
        );
        Course course = new Course(
          (String) courseJSON.get(COURSE_ID),
          (String) courseJSON.get(TITLE),
          courseCode,
          ((Long) courseJSON.get(CREDIT_HOURS)).intValue(),
          ((String) courseJSON.get(MIN_GRADE)).charAt(0),
          (ArrayList<Semester>) courseJSON.get(SEMESTER),
          (ArrayList<Course>) courseJSON.get(PREREQUISITE_COURSES)
        );
        courses.add(course);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return courses;
  }

  /**
   * Reads the Major.json file and returns an ArrayList of Majors
   * @return
   */
  public static ArrayList<Major> getAllMajors() {
    ArrayList<Major> majors = new ArrayList<Major>();
    try {
      FileReader reader = new FileReader("advising/json/Major.json");
      JSONParser parser = new JSONParser();
      JSONArray majorsJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < majorsJSON.size(); i++) {
        JSONObject majorJSON = (JSONObject) majorsJSON.get(i);
        Major major = new Major(
          (String) majorJSON.get(MAJOR_NAME),
          (String) majorJSON.get(MAJOR_ID),
          (ArrayList<Course>) majorJSON.get(REQUIRED_COURSES),
          ((Long) majorJSON.get(REQUIRED_CREDIT_HOURS)).intValue()
        );
        majors.add(major);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return majors;
  }

  /**
   * Reads the StudentPortfolio.json file and returns an ArrayList of StudentPortfolios
   * @return ArrayList<StudentPortfolio>
   */
  public static ArrayList<StudentPortfolio> getAllStudentPortfolios() {
    ArrayList<StudentPortfolio> studentPortfolios = new ArrayList<StudentPortfolio>();
    try {
      FileReader reader = new FileReader(
        "advising/json/studentPortfolios.json"
      );
      JSONParser parser = new JSONParser();
      JSONArray studentPortfoliosJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < studentPortfoliosJSON.size(); i++) {
        JSONObject studentPortfolioJSON = (JSONObject) studentPortfoliosJSON.get(
          i
        );
        StudentPortfolio studentPortfolio = new StudentPortfolio(
          (String) studentPortfolioJSON.get(PORTFOLIO_UUID),
          (ArrayList<Course>) studentPortfolioJSON.get(REQUIRED_COURSES),
          (HashMap<String, ArrayList<Course>>) studentPortfolioJSON.get(
            EIGHT_SEMESTER_PLAN
          ),
          (ArrayList<Course>) studentPortfolioJSON.get(CURRENT_COURSES),
          (HashMap<Course, Double>) studentPortfolioJSON.get(COMPLETED_COURSES),
          (HashMap<Course, Integer>) studentPortfolioJSON.get(FAILED_COURSES),
          (String) studentPortfolioJSON.get(SCHOLARSHIP),
          (
            (Long) studentPortfolioJSON.get(
              YEARLY_SCHOLARSHIP_CREDIT_HOURS_LEFT
            )
          ).intValue(),
          ((Double) studentPortfolioJSON.get(GPA)).doubleValue(),
          ((Long) studentPortfolioJSON.get(FAIL_COUNT)).intValue(),
          ((Long) studentPortfolioJSON.get(SEMESTER_CREDIT_COUNT)).intValue(),
          ((Long) studentPortfolioJSON.get(YEAR_CREDIT_HOURS)).intValue(),
          ((Long) studentPortfolioJSON.get(TOTAL_CREDIT_HOURS)).intValue(),
          (
            (Long) studentPortfolioJSON.get(TOTAL_CREDIT_HOURS_FOUND_DOCU)
          ).intValue(),
          ((Long) studentPortfolioJSON.get(TOTAL_CREDIT_HOURS_CC)).intValue(),
          (
            (Long) studentPortfolioJSON.get(
              TOTAL_CREDIT_HOURS_INTEGRATIVE_COURSE
            )
          ).intValue(),
          (
            (Long) studentPortfolioJSON.get(
              TOTAL_CREDIT_HOURS_PROGRAM_REQUIREMENTS
            )
          ).intValue(),
          (
            (Long) studentPortfolioJSON.get(
              TOTAL_CREDIT_HOURS_MAJOR_REQUIREMENTS
            )
          ).intValue(),
          (ArrayList<ElectiveCluster>) studentPortfolioJSON.get("0")
        );
        studentPortfolios.add(studentPortfolio);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return studentPortfolios;
  }
  
}
