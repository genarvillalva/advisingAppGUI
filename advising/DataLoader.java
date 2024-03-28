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
    return null;
  }

  /**
   * Reads the students.json file and returns an ArrayList of Students
   * @return ArrayList<Student>
   */
  public static ArrayList<Student> getAllStudents() {
    ArrayList<Advisor> advisors = getAllAdvisorsWithoutAdvisees();
    ArrayList<StudentPortfolio> studentPortfolios = getAllStudentPortfolios();
    ArrayList<Student> students = new ArrayList<Student>();

    try {
      FileReader reader = new FileReader(STUDENTS_FILE);
      JSONParser parser = new JSONParser();
      JSONArray studentsJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < studentsJSON.size(); i++) {
        JSONObject studentJSON = (JSONObject) studentsJSON.get(i);
        String advisorUsername = (String) studentJSON.get("advisor");
        Advisor advisor = findAdvisorByUsername(advisors, advisorUsername);
        StudentYear studentYear = StudentYear.valueOf((String) studentJSON.get(STUDENT_YEAR));
        StudentPortfolio studentPortfolio = studentPortfolios.get(i);
        Student student = new Student(
          (String) studentJSON.get(FIRST_NAME),
          (String) studentJSON.get(LAST_NAME),
          (String) studentJSON.get(USER_NAME),
          (String) studentJSON.get(PASSWORD),
          (String) studentJSON.get(USER_TYPE),
          (String) studentJSON.get(MAJOR),
          advisor,
          studentYear,
          studentPortfolio,
          (String) studentJSON.get(APPLICATION_AREA),
          (String) studentJSON.get(ADVISING_NOTES)
        );
        students.add(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return students;
  }

  /**
   * Helper method that reads the advisors.json file and returns an ArrayList of Advisors without advisees
   * @return ArrayList<Advisor>
   */
  public static ArrayList<Advisor> getAllAdvisorsWithoutAdvisees() {
    ArrayList<Advisor> advisors = new ArrayList<Advisor>();
    try {
      FileReader reader = new FileReader(ADVISORS_FILE);
      JSONParser parser = new JSONParser();
      ArrayList<Student> emptyList = new ArrayList<Student>();
      JSONArray advisorsJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < advisorsJSON.size(); i++) {
        JSONObject advisorJSON = (JSONObject) advisorsJSON.get(i);
        Advisor advisor = new Advisor(
          (String) advisorJSON.get(FIRST_NAME),
          (String) advisorJSON.get(LAST_NAME),
          (String) advisorJSON.get(USER_NAME),
          (String) advisorJSON.get(PASSWORD),
          (String) advisorJSON.get(USER_TYPE),
          emptyList
        );
        advisors.add(advisor);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return advisors;
  }
/**
 * Gets all advisors with advisees
 * @return ArrayList of all advisors with advisees 
 */
  public static ArrayList<Advisor> getAllAdvisors() {
    ArrayList<Advisor> advisors = getAllAdvisorsWithoutAdvisees();
    advisors = addAdviseesToAdvisors(advisors);
    return advisors;
  }
/**
 * Helper method to add advisees to advisors
 * @param advisors list of all advisors
 * @return the list of advisors with their respective advisees
 */
private static ArrayList<Advisor> addAdviseesToAdvisors(ArrayList<Advisor> advisorsWithoutAdvisees) {
  ArrayList<Student> students = getAllStudents();
  ArrayList<Advisor> advisorsWithAdvisees = new ArrayList<>();

  try {
      FileReader reader = new FileReader(ADVISORS_FILE);
      JSONParser parser = new JSONParser();
      JSONArray advisorsJSON = (JSONArray) parser.parse(reader);

      for (int i = 0; i < advisorsJSON.size(); i++) {
          JSONObject advisorJSON = (JSONObject) advisorsJSON.get(i);
          String advisorUsername = (String) advisorJSON.get(USER_NAME);

          Advisor advisor = findAdvisorByUsername(advisorsWithoutAdvisees, advisorUsername);
          if (advisor != null) {
              advisor.getListOfAdvisedStudents().clear(); // Clear the existing list of advisees
              JSONArray adviseesJSON = (JSONArray) advisorJSON.get(LIST_OF_ADVISED_STUDENTS);

              if (adviseesJSON != null && !adviseesJSON.isEmpty()) {
                  for (Object adviseeObject : adviseesJSON) {
                      String adviseeUsername = (String) adviseeObject;
                      Student student = findStudentByUsername(students, adviseeUsername);
                      if (student != null) {
                          advisor.addToAdviseeList(student);
                      }
                  }
              }
              advisorsWithAdvisees.add(advisor);
          }
      }
      return advisorsWithAdvisees;
  } catch (Exception e) {
      e.printStackTrace();
  }
  return null;
}



/**
 * Finds the student by its username
 * @param students list of all students
 * @param username the username of the student
 * @return the student with the given username
 */
private static Student findStudentByUsername(
  ArrayList<Student> students,
  String username
) {
  for (Student student : students) {
    if (student.getUsername().equals(username)) {
      return student;
    }
  }
  return null;
}



//////////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * Reads the Course.json file and returns an ArrayList of Courses
   * @return ArrayList<Course>
   */
  public static ArrayList<Course> getAllCourses() {
    ArrayList<Course> courses = new ArrayList<Course>();
    try {
      FileReader reader = new FileReader(COURSES_FILE);
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
/**
 * Adds the prerequisite courses to the courses
 * @param courses list of all courses
 */
  private static void addPrerequisiteCourses(ArrayList<Course> courses) {
    try {
      FileReader reader = new FileReader(COURSES_FILE);
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
  private static Course getCourseByID(
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
///////////////////////////////////////////////////////////////////////////
  /**
   * Reads the Major.json file and returns an ArrayList of Majors
   * @return ArrayList<Major>
   */
  public static ArrayList<Major> getAllMajors() {
    ArrayList<Major> majors = new ArrayList<Major>();
    try {
      CourseList courseList = CourseList.getInstance();
      FileReader reader = new FileReader(MAJORS_FILE);
      JSONParser parser = new JSONParser();
      JSONArray majorsJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < majorsJSON.size(); i++) {
        JSONObject majorJSON = (JSONObject) majorsJSON.get(i);
        ArrayList<Course> req = new ArrayList();
        ArrayList<String> currentCoursesString = (ArrayList<String>) majorJSON.get(REQUIRED_COURSES);
        for(String s: currentCoursesString){
          req.add(courseList.getCourseByID(s));
        }
        Major major = new Major(
          (String) majorJSON.get(MAJOR_NAME),
          (String) majorJSON.get(MAJOR_ID),
          req,
          ((Long) majorJSON.get(REQUIRED_CREDIT_HOURS)).intValue()
        );
        majors.add(major);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return majors;
  }
///////////////////////////////////////////////////////////////////////////

  /**
   * Reads the StudentPortfolio.json file and returns an ArrayList of StudentPortfolios
   * @return ArrayList<StudentPortfolio>
   */
  public static ArrayList<StudentPortfolio> getAllStudentPortfolios() {
    ArrayList<StudentElectives> studentElectives = getAllStudentElectives();
    try {
      ArrayList<StudentPortfolio> studentPortfolios = new ArrayList<StudentPortfolio>();
      FileReader reader = new FileReader(
        STUDENT_PORTFOLIOS_FILE
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
        @SuppressWarnings("unchecked")
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

        // Next Semester Courses
        ArrayList<Course> nextSemesterCourses = new ArrayList();
        ArrayList<String> nextSemesterCoursesString = (ArrayList<String>) studentPortfolioJSON.get(NEXT_SEMESTER_COURSES);
        for(String s: nextSemesterCoursesString){
          if(s!=null)
            nextSemesterCourses.add(CourseList.getCourseByID(s));
        }
        // current courses 
        ArrayList<Course> currentCourses = new ArrayList();
        ArrayList<String> currentCoursesString = (ArrayList<String>) studentPortfolioJSON.get(CURRENT_COURSES);
        for(String s: currentCoursesString){
          if(s!=null)
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

        // student electives 
        StudentElectives se = studentElectives.get(i);
        StudentPortfolio studentPortfolio = new StudentPortfolio(
          (String) studentPortfolioJSON.get(PORTFOLIO_UUID),
          requiredCourses,
          eightSemesterPlan,
          currentCourses,
          nextSemesterCourses,
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
          se
        );
        studentPortfolios.add(studentPortfolio);
      }
      return studentPortfolios;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * Reads the StudentElectives.json file and returns an ArrayList of StudentElectives
   * @return ArrayList<StudentElectives>
   */
  public static ArrayList<StudentElectives> getAllStudentElectives() {
    ArrayList<StudentElectives> studentElectives = new ArrayList<StudentElectives>();
    try {
      FileReader reader = new FileReader(ELECTIVES_FILE);
      JSONParser parser = new JSONParser();
      JSONArray studentElectivesJSON = (JSONArray) parser.parse(reader);
      for (int i = 0; i < studentElectivesJSON.size(); i++) {
        JSONObject studentElectiveJSON = (JSONObject) studentElectivesJSON.get(i);
        String studentName = (String) studentElectiveJSON.get("studentName");
        ArrayList<ElectiveCluster> electives = new ArrayList<ElectiveCluster>();
        JSONArray electivesJSON = (JSONArray) studentElectiveJSON.get("electives");
        for (int j = 0; j < electivesJSON.size(); j++) {
          JSONObject electiveJSON = (JSONObject) electivesJSON.get(j);
          String electiveName = (String) electiveJSON.get("electiveName");
          int hoursRequired = ((Long) electiveJSON.get("hoursRequired")).intValue();
          int hoursCompleted = ((Long) electiveJSON.get("hoursCompleted")).intValue();
          HashMap<String, Boolean> electiveCourses = new HashMap<String, Boolean>();
          JSONObject electiveCoursesJSON = (JSONObject) electiveJSON.get("classes");
          for (Object courseCode : electiveCoursesJSON.keySet()) {
            electiveCourses.put(
              (String) courseCode,
              (Boolean) electiveCoursesJSON.get(courseCode)
            );
          }
          ElectiveCluster electiveCluster = new ElectiveCluster(
            electiveName,
            hoursRequired,
            hoursCompleted,
            electiveCourses
          );
          electives.add(electiveCluster);
        }
        StudentElectives studentElective = new StudentElectives(studentName, electives);
        studentElectives.add(studentElective);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return studentElectives;
  }
}
