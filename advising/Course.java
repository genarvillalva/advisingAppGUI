package advising;

import java.util.ArrayList;

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

  public String getCourseID() {
    return courseID;
}

  public Course(String courseName, CourseCode courseCode) {
    this.courseName = courseName;
    this.courseCode = courseCode;
  }

   /**
    * Searches completed course for every prerequisite course
    * @return The true if all prerequisite are completed and false if not
    */
  public boolean PrereqComplete(ArrayList<Course> prerequisiteCourses, 
  ArrayList<Course> completedCourses) {
    for (Course prereqCourse : prerequisiteCourses) {
      boolean found = false;
      for (Course completedCourse : completedCourses) {
          if (prereqCourse.getCourseID().equals(completedCourse.getCourseID())) {
              found = true;
              break;
          }
      }
      if (!found) {
        return false;
      }
    }
  return true;
  }
}
