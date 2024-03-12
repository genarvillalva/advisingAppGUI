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
/**
 * Finds the advisor by its username
 * @param advisors list of all advisors
 * @param username the username of the advisor
 * @return the advisor with the given username
 */
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
    ArrayList<StudentPortfolio> studentPortfolios = getAllStudentPortfolios();
    ArrayList<Student> students = new ArrayList<Student>();

    try {
      FileReader reader = new FileReader("advising/json/students.json");
      JSONParser parser = new JSONParser();
      JSONArray studentsJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < studentsJSON.size(); i++) {
        JSONObject studentJSON = (JSONObject) studentsJSON.get(i);
        String advisorUsername = (String) studentJSON.get("advisor");
        Advisor advisor = findAdvisorByUsername(advisors, advisorUsername);
        StudentYear studentYear = StudentYear.valueOf((String) studentJSON.get(STUDENT_YEAR));
        
        Student student = new Student(
          (String) studentJSON.get(FIRST_NAME),
          (String) studentJSON.get(LAST_NAME),
          (String) studentJSON.get(USER_NAME),
          (String) studentJSON.get(PASSWORD),
          (String) studentJSON.get(USER_TYPE),
          (String) studentJSON.get(MAJOR),
          advisor,
          studentYear,
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
          (String) advisorJSON.get(USER_TYPE),
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
          (String) courseJSON.get(COURSE_CODE)
        );
        
        Semester semester = Semester.valueOf((String) courseJSON.get(SEMESTER));
        int _preferred_semester =
          ((Long) courseJSON.get(PREFERRED_SEMESTER)).intValue();
        Course course = new Course(
          (String) courseJSON.get(COURSE_ID),
          (String) courseJSON.get(COURSE_TITLE),
          courseCode,
          ((Long) courseJSON.get(CREDIT_HOURS)).intValue(),
          ((String) courseJSON.get(MIN_GRADE)),
          semester,
          _preferred_semester
        );
        courses.add(course);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    addPrerequisiteCourses(courses);
    return courses;
  }

  private static void addPrerequisiteCourses(ArrayList<Course> courses) {
    try {
      FileReader reader = new FileReader("advising/json/Course.json");
      JSONParser parser = new JSONParser();
      JSONArray coursesJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < coursesJSON.size(); i++) {
        JSONObject courseJSON = (JSONObject) coursesJSON.get(i);
        String courseID = (String) courseJSON.get(COURSE_ID);
        Course course = getCourseByID(courses, courseID);
        if (course != null) {
          JSONArray prerequisiteCoursesJSON = (JSONArray) courseJSON.get(
            PREREQUISITE_COURSES
          );
          addCoursesToList(
            courses,
            course,
            prerequisiteCoursesJSON,
            PREREQUISITE_COURSES
          );
          JSONArray corequisiteCoursesJSON = (JSONArray) courseJSON.get(
            COREQUISITE_COURSES
          );
          addCoursesToList(
            courses,
            course,
            corequisiteCoursesJSON,
            COREQUISITE_COURSES
          );
          JSONArray prereqCoreqJSON = (JSONArray) courseJSON.get(PREREQ_COREQ);
          addCoursesToList(courses, course, prereqCoreqJSON, PREREQ_COREQ);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
/**
 * Get the course by its ID
 * @param courses list of all courses
 * @param courseID the ID of the course
 * @return the course with the given ID
 */
  public static Course getCourseByID(
    ArrayList<Course> courses,
    String courseID) {
    for (Course course : courses) {
      if (course.getCourseID().equals(courseID)) {
        return course;
      }
    }
    return null;
  }
  /**
   * Adds prereqs, coreqs, and prereqCoreqs to courses
   * @param courses list of courses
   * @param course the course to add prereqs, coreqs, and prereqCoreqs to
   * @param json the json array of prereqs, coreqs, and prereqCoreqs
   * @param req the type of requirement
   */
  private static void addCoursesToList(
    ArrayList<Course> courses,
    Course course,
    JSONArray json,
    String req
  ) {
    if (json != null) {
      for (Object obj : json) {
        String courseId = (String) obj;
        Course reqCourse = getCourseByID(courses, courseId);
        if (reqCourse != null) {
          switch (req) {
            case PREREQUISITE_COURSES:
              course.addPrereq(reqCourse);
              break;
            case COREQUISITE_COURSES:
              course.addCoreq(reqCourse);
              break;
            case PREREQ_COREQ:
              course.addPrereqCoreq(reqCourse);
              break;
            default:
              break;
          }
        }
      }
    }
  }

  /**
   * Reads the Major.json file and returns an ArrayList of Majors
   * @return ArrayList<Major>
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
    try {
      ArrayList<StudentPortfolio> studentPortfolios = new ArrayList<StudentPortfolio>();
      FileReader reader = new FileReader(
        "advising/json/studentPortfolios.json"
      );
      CourseList.getInstance();
      JSONParser parser = new JSONParser();
      JSONArray studentPortfoliosJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < studentPortfoliosJSON.size(); i++) {
        JSONObject studentPortfolioJSON = (JSONObject) studentPortfoliosJSON.get(
          i
        );
        String portfolioUUID = (String) studentPortfolioJSON.get(PORTFOLIO_UUID);
        ArrayList<Course> requiredCourses = new ArrayList();
        ArrayList<String> requiredCoursesString = (ArrayList<String>) studentPortfolioJSON.get(REQUIRED_COURSES);
        for(String s: requiredCoursesString){
          requiredCourses.add(CourseList.getCourseByID(s));
        }
        // eight semester plan 
        HashMap<String, ArrayList<Course>> eightSemesterPlan = new HashMap<>();
        JSONObject eightSemesterPlanJSON = (JSONObject) studentPortfolioJSON.get(EIGHT_SEMESTER_PLAN);
        for(Object semesterObject: eightSemesterPlanJSON.keySet()){
          String semester = (String) semesterObject;
          JSONArray coursesJSON = (JSONArray) eightSemesterPlanJSON.get(semester);
          ArrayList<Course> c = new ArrayList<>();

          for(Object courseObject: coursesJSON){
            String courseID = (String) courseObject;
            Course course = CourseList.getCourseByID(courseID);
            if(course!=null)
              c.add(course);
          }
          eightSemesterPlan.put(semester, c);
        }
        // completed courses
        HashMap<Course, Double> completedCourses = new HashMap<>();
        JSONObject completedCoursesJSON = (JSONObject) studentPortfolioJSON.get(COMPLETED_COURSES);
        for(Object courseObject: completedCoursesJSON.keySet()){
          String courseID = (String) courseObject;
          Course course = CourseList.getCourseByID(courseID);
          if(course!=null)
            completedCourses.put(course, (Double) completedCoursesJSON.get(courseID));
        }

        // current courses 
        ArrayList<Course> currentCourses = new ArrayList();
        ArrayList<String> currentCoursesString = (ArrayList<String>) studentPortfolioJSON.get(CURRENT_COURSES);
        for(String s: currentCoursesString){
          currentCourses.add(CourseList.getCourseByID(s));
        }

        //failed courses 
        HashMap<Course, Integer> failedCourses = new HashMap<>();
        JSONObject failedCoursesJSON = (JSONObject) studentPortfolioJSON.get(FAILED_COURSES);
        for(Object courseObject: failedCoursesJSON.keySet()){
          String courseID = (String) courseObject;
          Course course = CourseList.getCourseByID(courseID);
          if(course!=null)
            failedCourses.put(course, ((Long) failedCoursesJSON.get(courseID)).intValue());
        }


        // gpa 
        double gpa = ((Number) studentPortfolioJSON.get(GPA)).doubleValue();
        StudentPortfolio studentPortfolio = new StudentPortfolio(
          (String) studentPortfolioJSON.get(PORTFOLIO_UUID),
          requiredCourses,
          eightSemesterPlan,
          currentCourses,
          completedCourses,
          failedCourses,
          (String) studentPortfolioJSON.get(SCHOLARSHIP),
          (
            (Long) studentPortfolioJSON.get(
              YEARLY_SCHOLARSHIP_CREDIT_HOURS_LEFT
            )
          ).intValue(),
          gpa,
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
      return studentPortfolios;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
