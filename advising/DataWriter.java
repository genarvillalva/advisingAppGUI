package advising;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    JSONArray jsonStudents = new JSONArray();
    JSONArray jsonStudentPortfolios = new JSONArray();
    for (Student student : students) {
        System.out.println("Saving Student: " + student.getFirstName() + " " + student.getLastName());
        jsonStudents.add(toStudentJSON(student));
        jsonStudentPortfolios.add(toPortfolioJSON(student.getPortfolio()));
    }

    System.out.println("Number of students being written to JSON: " + jsonStudents.size());
    writeToFile(jsonStudents, "advising/json/studenttest.json");
    writeToFile(jsonStudentPortfolios, "advising/json/portftest.json");
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

  private static JSONObject toPortfolioJSON(StudentPortfolio portfolio) {
    System.out.println(portfolio + "\n\n\n\n\n");
    JSONObject portfolioObject = new JSONObject();
    portfolioObject.put(PORTFOLIO_UUID, portfolio.getPortfolioUUID());
    portfolioObject.put(GPA, portfolio.getGpa());
    portfolioObject.put(FAIL_COUNT, portfolio.getFailCount());
    portfolioObject.put(SEMESTER_CREDIT_COUNT, portfolio.getSemesterCreditCount());
    portfolioObject.put(REQUIRED_COURSES, portfolio.getRequiredCourses());
    portfolioObject.put(EIGHT_SEMESTER_PLAN, toEightSemesterPlanJSON(portfolio.getEightSemesterPlan()));
    portfolioObject.put(CURRENT_COURSES, toCurrentCourseJSON(portfolio.getCurrentCourses()));
    portfolioObject.put(COMPLETED_COURSES, toCompletedCourseJSON(portfolio.getCompletedCourses()));
    portfolioObject.put(FAILED_COURSES, toFailedCoursesJSON(portfolio.getFailedCourses()));
    portfolioObject.put(SCHOLARSHIP, portfolio.getScholarship());
    portfolioObject.put(SCHOLARSHIP_CREDIT_HOURS_LEFT, portfolio.getScholarshipCreditHoursLeft());
    portfolioObject.put(YEAR_CREDIT_HOURS, portfolio.getYearCreditCount());
    portfolioObject.put(TOTAL_CREDIT_HOURS, portfolio.getTotalCreditHours());
    portfolioObject.put(TOTAL_CREDIT_HOURS_FOUND_DOCU, portfolio.getTotalCreditHoursFoundDocu());
    portfolioObject.put(TOTAL_CREDIT_HOURS_CC, portfolio.getTotalCreditHoursCC());
    portfolioObject.put(TOTAL_CREDIT_HOURS_INTEGRATIVE_COURSE, portfolio.getTotalCreditHoursIntegrativeCourse());
    portfolioObject.put(TOTAL_CREDIT_HOURS_PROGRAM_REQUIREMENTS, portfolio.getTotalCreditHoursProgramRequirements());
    portfolioObject.put(TOTAL_CREDIT_HOURS_MAJOR_REQUIREMENTS, portfolio.getTotalCreditHoursMajorRequirements());
    portfolioObject.put(STUDENT_ELECTIVES, portfolio.getPortfolioUUID());
    
    return portfolioObject;
  }

  private static JSONArray toFailedCoursesJSON(HashMap<Course, Integer> failedCourses) {
    JSONArray failedCourseArray = new JSONArray();
    for (Course course : failedCourses.keySet()) {
      JSONObject courseObject = new JSONObject();
      courseObject.put(course.getCourseID(), failedCourses.get(course));
      failedCourseArray.add(courseObject);
    }
    return failedCourseArray;
  }

  private static JSONArray toCompletedCourseJSON(HashMap<Course, Double> completedCourses) {
    JSONArray completedCourseArray = new JSONArray();
    for (Course course : completedCourses.keySet()) {
      JSONObject courseObject = new JSONObject();
      courseObject.put(course.getCourseID(), completedCourses.get(course));
      completedCourseArray.add(courseObject);
    }
    return completedCourseArray;
  }

  private static JSONArray toCurrentCourseJSON(ArrayList<Course> currentCourses) {
    JSONArray currentCourseArray = new JSONArray();
    for (Course course : currentCourses) {
      currentCourseArray.add(course.getCourseID());
    }
    return currentCourseArray;
  }

  private static JSONArray toEightSemesterPlanJSON(HashMap<String, ArrayList<Course>> eightSemesterPlan) {
    JSONArray eightSemesterPlanArray = new JSONArray();
    for (String semester : eightSemesterPlan.keySet()) {
      JSONObject semesterObject = new JSONObject();
      semesterObject.put(semester, eightSemesterPlan.get(semester));
      eightSemesterPlanArray.add(semesterObject);
      eightSemesterPlan.get(semester);
    }
    return eightSemesterPlanArray;
  }

  ////////////////////////////////////////////
  /**
   * Saves all advisors to a JSON file
   */
  @SuppressWarnings("unchecked")
  public static void saveAdvisors(ArrayList<Advisor> advisors) {
    UserList userList = UserList.getInstance();
    ArrayList<Advisor> oldAdvisors = userList.getAdvisors();
    JSONArray jsonAdvisors = new JSONArray();
    for (int i = 0; i < advisors.size(); i++) {
      if (oldAdvisors.contains(advisors.get(i))) {
        continue;
      }
      System.out.println(
        "Saving Advisor: " +
        advisors.get(i).getFirstName() +
        " " +
        advisors.get(i).getLastName()
      );
      jsonAdvisors.add(getAdvisorJSON(advisors.get(i)));
    }
    writeToFile(jsonAdvisors, "advising/json/advisorstest.json");
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
