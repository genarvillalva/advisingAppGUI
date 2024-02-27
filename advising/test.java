package advising;

import java.util.ArrayList;

public class test {

  public static void main(String[] args) {
    testGetAllStudents();
    testGetAllAdvisors();
    testGetAllCourses();
    testGetAllMajors();
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
}
