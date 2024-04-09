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
  public static void saveCourses(ArrayList<Course> _courses) {
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
    courseObject.put(
      PREREQUISITE_COURSES,
      toPrereqCourseJSON(course.getPrerequisiteCourses())
    );
    courseObject.put(
      COREQUISITE_COURSES,
      toCoreqCourseJSON(course.getCorequisiteCourses())
    );
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
  public static void saveUsers(
    ArrayList<Student> students,
    ArrayList<Advisor> advisors
  ) {
    saveStudents(students);
    saveAdvisors(advisors);
  }

  /**
   * Saves all students to a JSON file
   */
  @SuppressWarnings("unchecked")
  public static void saveStudents(ArrayList<Student> students) {
    UserList userList = UserList.getInstance();
    ArrayList<Student> existingStudents = userList.getStudents();
    existingStudents.addAll(students);

    JSONArray jsonStudents = new JSONArray();
    JSONArray jsonStudentPortfolios = new JSONArray();
    for (Student student : students) {
      System.out.println(
        "Saving Student: " +
        student.getFirstName() +
        " " +
        student.getLastName()
      );

      // if (!existingStudents.contains(student)) {
      //   JSONObject studentElectives = createStudentElectives(student);
      //   student.setStudentElectives(studentElectives);
      // }
      jsonStudents.add(toStudentJSON(student));
      jsonStudentPortfolios.add(toPortfolioJSON(student.getPortfolio()));
    }

    System.out.println(
      "Number of students being written to JSON: " + jsonStudents.size()
    );
    writeToFile(jsonStudents, "advising/json/students.json");
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
    if (a == null) {
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

  /**
   * Converts a student's portfolio to a JSON object
   * @param portfolio Student's portfolio to convert
   * @return JSONObject of student's portfolio
   */
  @SuppressWarnings("unchecked")
  private static JSONObject toPortfolioJSON(StudentPortfolio portfolio) {
    JSONObject portfolioObject = new JSONObject();
    portfolioObject.put(PORTFOLIO_UUID, portfolio.getPortfolioUUID());
    portfolioObject.put(GPA, portfolio.getGpa());
    portfolioObject.put(FAIL_COUNT, portfolio.getFailCount());
    portfolioObject.put(
      SEMESTER_CREDIT_COUNT,
      portfolio.getSemesterCreditCount()
    );
    portfolioObject.put(
      REQUIRED_COURSES,
      toRequiredCoursesJSON(portfolio.getRequiredCourses())
    );
    portfolioObject.put(
      EIGHT_SEMESTER_PLAN,
      toEightSemesterPlanJSON(portfolio.getEightSemesterPlan())
    );
    portfolioObject.put(
      CURRENT_COURSES,
      toCurrentCourseJSON(portfolio.getCurrentCourses())
    );
    portfolioObject.put(
      NEXT_SEMESTER_COURSES,
      toCurrentCourseJSON(portfolio.getNextSemesterCourses())
    );
    portfolioObject.put(
      COMPLETED_COURSES,
      toCompletedCourseJSON(portfolio.getCompletedCourses())
    );
    portfolioObject.put(
      FAILED_COURSES,
      toFailedCoursesJSON(portfolio.getFailedCourses())
    );
    portfolioObject.put(SCHOLARSHIP, portfolio.getScholarship());
    portfolioObject.put(
      SCHOLARSHIP_CREDIT_HOURS_LEFT,
      portfolio.getScholarshipCreditHoursLeft()
    );
    portfolioObject.put(YEAR_CREDIT_HOURS, portfolio.getYearCreditCount());
    portfolioObject.put(TOTAL_CREDIT_HOURS, portfolio.getTotalCreditHours());
    portfolioObject.put(
      TOTAL_CREDIT_HOURS_FOUND_DOCU,
      portfolio.getTotalCreditHoursFoundDocu()
    );
    portfolioObject.put(
      TOTAL_CREDIT_HOURS_CC,
      portfolio.getTotalCreditHoursCC()
    );
    portfolioObject.put(
      TOTAL_CREDIT_HOURS_INTEGRATIVE_COURSE,
      portfolio.getTotalCreditHoursIntegrativeCourse()
    );
    portfolioObject.put(
      TOTAL_CREDIT_HOURS_PROGRAM_REQUIREMENTS,
      portfolio.getTotalCreditHoursProgramRequirements()
    );
    portfolioObject.put(
      TOTAL_CREDIT_HOURS_MAJOR_REQUIREMENTS,
      portfolio.getTotalCreditHoursMajorRequirements()
    );
    portfolioObject.put(STUDENT_ELECTIVES, portfolio.getPortfolioUUID());

    return portfolioObject;
  }

  /**
   * Converts a list of required courses to a JSON array
   * @param requiredCourses List of required courses to convert
   * @return  JSONArray of required courses
   */
  private static JSONArray toRequiredCoursesJSON(
    ArrayList<Course> requiredCourses
  ) {
    JSONArray requiredCoursesArray = new JSONArray();
    for (Course course : requiredCourses) {
      requiredCoursesArray.add(course.getCourseID());
    }
    return requiredCoursesArray;
  }

  /**
   * Converts a list of failed courses to a JSON object
   * @param failedCourses List of failed courses to convert
   * @return JSONObject of failed courses
   */
  private static JSONObject toFailedCoursesJSON(
    HashMap<Course, Integer> failedCourses
  ) {
    JSONObject failedCoursesObject = new JSONObject();
    for (Course course : failedCourses.keySet()) {
      failedCoursesObject.put(course.getCourseID(), failedCourses.get(course));
    }
    return failedCoursesObject;
  }

  /**
   * Converts a list of completed courses to a JSON object
   * @param completedCourses List of completed courses to convert
   * @return JSONObject of completed courses
   */
  private static JSONObject toCompletedCourseJSON(
    HashMap<Course, Double> completedCourses
  ) {
    JSONObject completedCoursesObject = new JSONObject();
    for (Course course : completedCourses.keySet()) {
      completedCoursesObject.put(
        course.getCourseID(),
        completedCourses.get(course)
      );
    }
    return completedCoursesObject;
  }

  /**
   * Converts a list of current courses to a JSON array
   * @param currentCourses List of current courses to convert
   * @return JSONArray of current courses
   */
  private static JSONArray toCurrentCourseJSON(
    ArrayList<Course> currentCourses
  ) {
    JSONArray currentCourseArray = new JSONArray();
    for (Course course : currentCourses) {
      currentCourseArray.add(course.getCourseID());
    }
    return currentCourseArray;
  }

  /**
   *  Converts a hashmap of an eight semeester plan to a JSON object
   * @param eightSemesterPlan HashMap of eight semester plan to convert
   * @return JSONObject of eight semester plan
   */
  private static JSONObject toEightSemesterPlanJSON(
    HashMap<String, ArrayList<Course>> eightSemesterPlan
  ) {
    JSONObject eightSemesterPlanObject = new JSONObject();
    for (String semester : eightSemesterPlan.keySet()) {
      JSONArray courseIdsArray = new JSONArray();
      ArrayList<Course> courses = eightSemesterPlan.get(semester);
      for (Course course : courses) {
        courseIdsArray.add(course.getCourseID()); 
      }
      eightSemesterPlanObject.put(semester, courseIdsArray);
    }
    return eightSemesterPlanObject;
  }

  ////////////////////////////////////////////
  /**
   * Saves all advisors to a JSON file
   */
  @SuppressWarnings("unchecked")
  public static void saveAdvisors(ArrayList<Advisor> advisors) {
    System.out.println("Saving advisors to JSON...");
    ArrayList<Advisor> oldAdvisors = DataLoader.getAllAdvisors();
    JSONArray jsonAdvisors = new JSONArray();

    for (Advisor advisor : advisors) {
      boolean exists = false;
      for (Advisor oldAdvisor : oldAdvisors) {
        if (oldAdvisor.getUsername().equals(advisor.getUsername())) {
          exists = true;
          break;
        }
      }
      if(!exists){
        oldAdvisors.add(advisor);
      }
      JSONObject advisorJson = getAdvisorJSON(advisor);
      jsonAdvisors.add(advisorJson);
    }
    writeToFile(jsonAdvisors, "advising/json/advisors.json");
  }

  /**
   * Helper function for saveAdvisors to convert each user to JSON format
   * @param advisor to convert to JSON object
   * @return JSONObject of advisor
   */
  @SuppressWarnings("unchecked")
  private static JSONObject getAdvisorJSON(Advisor advisor) {
    JSONObject advisorObject = new JSONObject();
    advisorObject.put(FIRST_NAME, advisor.getFirstName());
    advisorObject.put(LAST_NAME, advisor.getLastName());
    advisorObject.put(USER_NAME, advisor.getUsername());
    advisorObject.put(PASSWORD, advisor.getPassword());
    advisorObject.put(USER_TYPE, "Advisor");
    ArrayList<String> studentUsernames = new ArrayList<>();
    for (Student student : advisor.getListOfAdvisedStudents()) {
      studentUsernames.add(student.getUsername());
    }
    advisorObject.put(LIST_OF_ADVISED_STUDENTS, studentUsernames);
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
