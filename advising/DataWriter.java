package advising;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
  @SuppressWarnings("unchecked")
  public static boolean saveCourses(ArrayList<Course> _courses) {
    ArrayList<Course> courses = _courses;
    ArrayList<Course> oldCourses = DataLoader.getAllCourses();
    JSONArray jsonCourses = new JSONArray();

    for (int i = 0; i < courses.size(); i++) {
      if (oldCourses.contains(courses.get(i))) {
        continue;
      }
      jsonCourses.add(toCourseJSON(courses.get(i)));
    }

    try (FileWriter file = new FileWriter("advising/json/test.json")) {
      file.write(jsonCourses.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }
  /**
   * Converts a course to a JSON object
   * @param course Course to convert
   * @return JSONObject of course
   */
  @SuppressWarnings("unchecked")
  private static JSONObject toCourseJSON(Course course) {
    JSONObject courseObject = new JSONObject();
    courseObject.put(COURSE_ID, course.getCourseID());
    courseObject.put(COURSE_TITLE, course.getCourseTitle());
    courseObject.put(COURSE_CODE, course.getCourseCode());
    courseObject.put(CREDIT_HOURS, course.getCreditHours());
    courseObject.put(MIN_GRADE, course.getMinGrade());
    courseObject.put(SEMESTER, course.getSemester().toString());
    courseObject.put(PREREQUISITE_COURSES, toPrereqCourseJSON(course.getPrerequisiteCourses()));
    courseObject.put(COREQUISITE_COURSES, toCoreqCourseJSON(course.getCorequisiteCourses()));
    courseObject.put(PREREQ_COREQ, toPrereqCoreqJSON(course.getPrereqCoreq()));
    courseObject.put(PREFERRED_SEMESTER, course.getPreferredSemester());
    return courseObject;
  }
/**
 * Converts a list of prereq courses to a JSON array
 * @param courses List of courses to convert
 * @return JSONArray of courses
 */
  @SuppressWarnings("unchecked")
  private static JSONArray toPrereqCourseJSON(ArrayList<Course> courses) {
    JSONArray courseArray = new JSONArray();
    for (int i = 0; i < courses.size(); i++) {
      courseArray.add(courses.get(i).getCourseID());
    }
    return courseArray;
  }
  /**
   * Converts a list of coreq courses to a JSON array
   * @param courses
   * @return
   */
  @SuppressWarnings("unchecked")
  private static JSONArray toCoreqCourseJSON(ArrayList<Course> courses) {
    JSONArray courseArray = new JSONArray();
    for (int i = 0; i < courses.size(); i++) {
      courseArray.add(courses.get(i).getCourseID());
    }
    return courseArray;
  }
  /**
   * Converts a list of prereq and coreq courses to a JSON array
   * @param courses List of courses to convert 
   * @return JSONArray of courses
   */
  @SuppressWarnings("unchecked")
  private static JSONArray toPrereqCoreqJSON(ArrayList<Course> courses) {
    JSONArray courseArray = new JSONArray();
    for (int i = 0; i < courses.size(); i++) {
      courseArray.add(courses.get(i).getCourseID());
    }
    return courseArray;
  }

////////////////////////////////////////////
  /**
   * Saves all users to JSON files
   */
  public static void saveUsers(ArrayList<Student> students, ArrayList<Advisor> advisors) {
    saveStudents(students);
    saveAdvisors(advisors);
  }

  /**
   * Saves all students to a JSON file
   */
  @SuppressWarnings("unchecked")
 public static void saveStudents(ArrayList<Student> students) {

       // Load existing students using DataLoader
       ArrayList<Student> existingStudents = DataLoader.getAllStudents();
    
       // Combine existing and new advisors
       existingStudents.addAll(students); 
      
    JSONArray jsonStudents = new JSONArray();
    for (Student student : students) {
        System.out.println("Saving Student: " + student.getFirstName() + " " + student.getLastName());
        jsonStudents.add(toStudentJSON(student));
    }

    System.out.println("Number of students being written to JSON: " + jsonStudents.size());
    writeToFile(jsonStudents, "advising/json/students.json");
}


  /**
   * Helper function for saveStudents to convert each user to JSON format
   *
   * @param student to convert to JSON object
   * @return JSONObject of student
   */
  @SuppressWarnings("unchecked")
  private static JSONObject toStudentJSON(Student student) {
    Advisor a = student.getAdvisor();
    String advisor = "";
    if(a == null) {
      advisor = null;
    } else {
      advisor = a.getUsername();
    }

    JSONObject studentObject = new JSONObject();
    studentObject.put(FIRST_NAME, student.getFirstName());
    studentObject.put(LAST_NAME, student.getLastName());
    studentObject.put(USER_NAME, student.getUsername());
    studentObject.put(PASSWORD, student.getPassword());
    studentObject.put(MAJOR, student.getMajor());
    studentObject.put(USER_TYPE, "Student");
    studentObject.put(ADVISOR, advisor);
    studentObject.put(STUDENT_YEAR, student.getStudentClass());
    studentObject.put(PORTFOLIO, student.getUsername());
    studentObject.put(APPLICATION_AREA, student.getApplicationArea());
    studentObject.put(ADVISING_NOTES, student.getAdvisingNotes());
    return studentObject;
    
  }



  ////////////////////////////////////////////
  /**
   * Saves all advisors to a JSON file
   */
  @SuppressWarnings("unchecked")
  public static void saveAdvisors(ArrayList<Advisor> advisors) {
    System.out.println("Saving advisors to JSON...");
     // Load existing advisors using DataLoader
     ArrayList<Advisor> existingAdvisors = DataLoader.getAllAdvisors();
    
     // Combine existing and new advisors
     existingAdvisors.addAll(advisors); 
    
    
    JSONArray jsonAdvisors = new JSONArray();

    for (Advisor advisor : advisors) {
        JSONObject advisorJson = getAdvisorJSON(advisor);
        System.out.println("Converting advisor to JSON: " + advisor.getUsername());
        jsonAdvisors.add(advisorJson);
    }

    System.out.println("Number of advisors being written to JSON: " + jsonAdvisors.size());
    writeToFile(jsonAdvisors, "advising/json/advisors.json");
}


  @SuppressWarnings("unchecked")
  private static JSONObject getAdvisorJSON(Advisor advisor) {
    JSONObject advisorObject = new JSONObject();
    advisorObject.put(FIRST_NAME, advisor.getFirstName());
    advisorObject.put(LAST_NAME, advisor.getLastName());
    advisorObject.put(USER_NAME, advisor.getUsername());
    advisorObject.put(PASSWORD, advisor.getPassword());
    advisorObject.put(USER_TYPE, "Advisor");
    advisorObject.put(
      LIST_OF_ADVISED_STUDENTS,
      advisor.getListofAdvisedStudents()
    );
    return advisorObject;
  }

////////////////////////////////////////////
  


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
