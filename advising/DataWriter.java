package advising;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Writes data to JSON files
 * @author Genar Villalva
 */
public class DataWriter extends DataConstants {

  /**
   * Writes Courses and their information to a JSON file
   * @param students List of Student objects to be written to the file
   * @param filePath The path to the JSON file
   */
  public static boolean saveCourses() {
    CourseList courseList = courseList.getInstance();
    ArrayList<Course> courses = courseList.getCourses();

    // Convert arraylist to JSONArray
    JSONArray jsonCourses = new JSONArray();

    for (int i = 0; i < courses.size(); i++) {
      jsonCourses.add(getCourseJSON(courses.get(i)));
    }

    try (FileWriter file = new FileWriter(COURSES_FILE_NAME)) {
      file.write(jsonCourses.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  private static JSONObject getCourseJSON(Course course) {
    JSONObject courseObject = new JSONObject();
    courseObject.put(COURSE_ID, course.getCourseID());
    courseObject.put(COURSE_TITLE, course.getCourseTitle());
    courseObject.put(COURSE_CODE, course.getCourseCode());
    courseObject.put(CREDIT_HOURS, course.getCreditHours());
    courseObject.put(MIN_GRADE, course.getMinGrade());
    courseObject.put(SEMESTER, course.getSemester());
    courseObject.put(PREREQUISITE_COURSES, course.getPrerequisiteCourses());
    return courseObject;
  }

  /**
   * Writes a list of students to a JSON file
   * @param students List of Student objects to be written to the file
   * @param filePath The path to the JSON file
   */
  public static void saveUsers(ArrayList<Student> newStudents) {
    UserList users = UserList.getInstance();
    ArrayList<Advisor> advisors = users.getAdvisors();
    ArrayList<Student> students = users.getStudents();
    JSONArray jsonStudents = new JSONArray();
    JSONArray jsonAdvisors = new JSONArray();
    for (Student student : newStudents) {
      System.out.println(
        "Saving Student: " +
        student.getFirstName() +
        " " +
        student.getLastName()
      );
      JSONObject studentObject = new JSONObject();
      studentObject.put(FIRST_NAME, student.getFirstName());
      studentObject.put(LAST_NAME, student.getLastName());
      studentObject.put(USER_NAME, student.getUsername());
      studentObject.put(PASSWORD, student.getPassword());
      studentObject.put(MAJOR, student.getMajor());
      studentObject.put(ADVISOR, student.getAdvisor().getUsername());
      studentObject.put(STUDENT_YEAR, student.getStudentClass().toString());
      studentObject.put(APPLICATION_AREA, student.getApplicationArea());
      jsonStudents.add(studentObject);
    }
    for (Advisor advisor : advisors) {
      System.out.println(
        "Saving Advisor: " +
        advisor.getFirstName() +
        " " +
        advisor.getLastName()
      );
      JSONObject advisorObject = new JSONObject();
      advisorObject.put(FIRST_NAME, advisor.getFirstName());
      advisorObject.put(LAST_NAME, advisor.getLastName());
      advisorObject.put(USER_NAME, advisor.getUsername());
      advisorObject.put(PASSWORD, advisor.getPassword());
      advisorObject.put(ADVISOR, advisor.getListofAdvisedStudents());
      jsonAdvisors.add(advisorObject);
    }
    writeToFile(jsonStudents, "advising/json/students.json");
    writeToFile(jsonAdvisors, "advising/json/advisors.json");
  }

  public static void saveStudents() {
    UserList userList = UserList.getInstance();
    ArrayList<Student> newStudents = userList.getStudents();
    ArrayList<Student> oldStudents = DataLoader.getAllStudents();
    JSONArray jsonStudents = new JSONArray();
    for (int i = 0; i < newStudents.size(); i++) {
      if (oldStudents.contains(newStudents.get(i))) {
        continue;
      }
      System.out.println(
        "Saving Student: " +
        newStudents.get(i).getFirstName() +
        " " +
        newStudents.get(i).getLastName()
      );
      jsonStudents.add(toStudentJSON(newStudents.get(i)));
    }
    writeToFile(jsonStudents, "advising/json/students.json");
  }

  /**
   * Helper function for saveStudents to convert each user to JSON format
   *
   * @param student to convert to JSON object
   * @return JSONObject of student
   */
  private static JSONObject toStudentJSON(Student student) {
    JSONObject studentObject = new JSONObject();
    studentObject.put(FIRST_NAME, student.getFirstName());
    studentObject.put(LAST_NAME, student.getLastName());
    studentObject.put(USER_NAME, student.getUsername());
    studentObject.put(PASSWORD, student.getPassword());
    studentObject.put(MAJOR, student.getMajor());
    studentObject.put(ADVISOR, student.getAdvisor());
    studentObject.put(STUDENT_YEAR, student.getStudentClass());
    studentObject.put(PORTFOLIO, student.getPortfolio());
    studentObject.put(APPLICATION_AREA, student.getApplicationArea());
    return studentObject;
  }

  public static void saveAdvisors() {
    UserList userList = UserList.getInstance();
    ArrayList<Advisor> newAdvisors = userList.getAdvisors();
    ArrayList<Advisor> oldAdvisors = DataLoader.getAllAdvisors();
    JSONArray jsonAdvisors = new JSONArray();
    for (int i = 0; i < newAdvisors.size(); i++) {
      if (oldAdvisors.contains(newAdvisors.get(i))) {
        continue;
      }
      System.out.println(
        "Saving Advisor: " +
        newAdvisors.get(i).getFirstName() +
        " " +
        newAdvisors.get(i).getLastName()
      );
      jsonAdvisors.add(getAdvisorJSON(newAdvisors.get(i)));
    }
    writeToFile(jsonAdvisors, "advising/json/advisors.json");
  }

  private static JSONObject getAdvisorJSON(Advisor advisor) {
    JSONObject advisorObject = new JSONObject();
    advisorObject.put(FIRST_NAME, advisor.getFirstName());
    advisorObject.put(LAST_NAME, advisor.getLastName());
    advisorObject.put(USER_NAME, advisor.getUsername());
    advisorObject.put(PASSWORD, advisor.getPassword());
    advisorObject.put(
      LIST_OF_ADVISED_STUDENTS,
      advisor.getListofAdvisedStudents()
    );
    return advisorObject;
  }

  /**
   * Writes a list of courses to a JSON file
   */
  private static void writeToFile(JSONArray jsonArray, String filePath) {
    try (FileWriter fileWriter = new FileWriter(filePath)) {
      fileWriter.write(jsonArray.toJSONString());
      fileWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
