package advising;

import java.util.ArrayList;

enum CourseCode {
  FoundingDocuments,
  ProgramRequirements,
  MajorRequirements,
  IntegrativeCourse,
  CMW,
  ARP,
  SCI,
  GFL,
  GHS,
  AIU,
  CMS,
  INF,
  VSR,
  PR,
}

public class Course {

  private String courseName;
  private String courseID;
  private CourseCode courseCode;
  private int creditHours;
  private ArrayList<Course> prerequisiteCourses;
  private ArrayList<Course> corequisiteCourses;
  private Semester semester;
  private char minGrade;
  private String courseUUID;

  public Course(String courseName, CourseCode courseCode) {
    this.courseName = courseName;
    this.courseCode = courseCode;
  }

  public boolean PrereqComplete(
    ArrayList<Course> prerequistiveCourses,
    ArrayList<Course> completedCourses
  ) {
    return true;
  }
}
