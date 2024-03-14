package advising;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {

  public static void main(String[] args) {
    testGetAllStudents();
    // testGetAllAdvisors();
    // testGetAllCourses();
    // testGetAllMajors();
    // testGetAllStudentPortfolios();
    // testStudentPortfolio();
    // testWriteUsers();

    // testSaveCourses();
  }

  public static void testGetAllStudents() {
    ArrayList<Student> students = DataLoader.getAllStudents();
    System.out.println("List of Students:");
    for (Student student : students) {
      System.out.println(student);
    }
  }

  public static void testGetAllAdvisors() {
    ArrayList<Advisor> advisors = DataLoader.getAllAdvisors();
    System.out.println("List of Advisors:");
    for (Advisor advisor : advisors) {
      System.out.println(advisor);
    }
  }

  ///////////////////
  public static void testGetAllCourses() {
    ArrayList<Course> courses = DataLoader.getAllCourses();
    System.out.println("List of Courses:");
    System.out.println(courses.size());
    for (Course course : courses) {
      System.out.println(course);
    }
  }

  public static void testGetAllMajors() {
    ArrayList<Major> majors = DataLoader.getAllMajors();
    System.out.println("List of Majors:");
    for (Major major : majors) {
      System.out.println(major);
    }
  }

  // public static void testStudentPortfolio() {
  //   ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
  //   for (int i = 0; i < studentPortfolios.size(); i++) {
  //     System.out.println("\nStudent UUID " + i + ":");
  //     System.out.println(studentPortfolios.get(i).getRequiredCourses().get(0));
  //   }
  // }
  public static Course getCourseByID(
    ArrayList<Course> courses,
    String courseID
  ) {
    for (Course course : courses) {
      if (course.getCourseID().equals(courseID)) {
        return course;
      }
    }
    return null;
  }

  public static void testGetAllStudentPortfolios() {
    CourseList.getInstance();
    ArrayList<Course> courses = DataLoader.getAllCourses();
    Course csce145 = CourseList.getCourseByID("CSCE190");
    ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
    System.out.println("List of Student Portfolios:");
    for (StudentPortfolio studentPortfolio : studentPortfolios) {
      System.out.println(studentPortfolio.getTotalCreditHoursMajorRequirements() + "\n\n");
    }
  }

  public static void testSaveCourses() {
    ArrayList<Course> courses = new ArrayList<>();
    CourseCode s = CourseCode.SCI;
    ArrayList<Course> req = new ArrayList<>();
    CourseList courseList = CourseList.getInstance();
    Course math141 = courseList.getCourseByID("MATH141");
    Course csce190 = CourseList.getCourseByID("CSCE190");
    req.add(math141);
    req.add(csce190);
    Course c = new Course(
      "CS101",
      "Introduction to Computer Science",
      s,
      3,
      "B",
      Semester.FALL,
      req,
      new ArrayList<Course>(),
      new ArrayList<Course>(),
      1
    );
    courses.add(c);
    DataWriter.saveCourses(courses);
  }

  public static void testWriteUsers() {
    ArrayList<Student> students = DataLoader.getAllStudents();
    ArrayList<Student> student = new ArrayList<Student>();
    student.add(students.get(0));
    ArrayList<Advisor> advisors = DataLoader.getAllAdvisors();
    StudentYear studentYear = StudentYear.FRESHMAN;





    StudentElectives ec = new StudentElectives(
      "James",
      new ArrayList<ElectiveCluster>()
    );
    
    StudentPortfolio sp = new StudentPortfolio(
      "123",
      new ArrayList<Course>(),
      new HashMap<String, ArrayList<Course>>(),
      new ArrayList<Course>(),
      new HashMap<Course, Double>(),
      new HashMap<Course, Integer>(),
      "LIFE Scholarship",
      0,
      0.0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      ec
    );
    // Student s = new Student(
    //   "James",
    //   "Son",
    //   "jamesson1",
    //   "password",
    //   "Student",
    //   "Computer Science",
    //   null,
    //   studentYear,
    //   sp,
    //   null,
    //   "Take Chem 101 next semester."
    // );
    // students.add(s);
    DataWriter.saveUsers(student, advisors);
    // System.out.println(s.getPortfolio());
  }
}
