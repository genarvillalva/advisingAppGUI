package advising;

import java.util.ArrayList;

public class test {

  public static void main(String[] args) {
    testGetAllStudents();
    testGetAllAdvisors();
    testGetAllCourses();
    testGetAllMajors();
    testGetAllStudentPortfolios();
    // testWriteUsers();
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
  public static void testGetAllStudentPortfolios() {
    ArrayList<StudentPortfolio> studentPortfolios = DataLoader.getAllStudentPortfolios();
    System.out.println("List of Student Portfolios:");
    for (StudentPortfolio studentPortfolio : studentPortfolios) {
      System.out.println(studentPortfolio);
    }
  }

  public static void testWriteUsers() {
    ArrayList<Student> students = DataLoader.getAllStudents();
    ArrayList<Advisor> advisors = DataLoader.getAllAdvisors();
    StudentYear studentYear = StudentYear.FRESHMAN;
    ArrayList<StudentPortfolio> StudentPortfolio = DataLoader.getAllStudentPortfolios();
    Student s = new Student(
      "James",
      "Son",
      "jamesson1",
      "password",
      "Student",
      "Computer Science",
      advisors.get(0),
      studentYear,
      StudentPortfolio.get(0),
      "Application Area"
    );
    students.add(s);
    DataWriter.saveUsers(students);
  }
}
