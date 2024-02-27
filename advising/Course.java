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

  /**
   * Constructor for the Course class
   * @return The course name
   */
  public String getCourseName() {
    return courseName;
}
/**
 * Get the course code of the course
 * @return The course code of the course
 */
public CourseCode getCourseCode() {
    return courseCode;
}
/**
 * Get the credit hours of the course
 * @return The credit hours of the course
 */
public int getCreditHours() {
    return creditHours;
}
/**
 * Get the prerequisite courses of the course
 * @return The prerequisite courses of the course 
 */
public ArrayList<Course> getPrerequisiteCourses() {
    return prerequisiteCourses;
}
/**
 * Get the corequisite courses of the course
 * @return The corequisite courses of the course
 */
public ArrayList<Course> getCorequisiteCourses() {
    return corequisiteCourses;
}
/**
 * Get the semester of the course
 * @return The semester of the course
 */
public Semester getSemester() {
    return semester;
}
/**
 * Get the minimum grade of the course
 * @return The minimum grade of the course
 */
public char getMinGrade() {
    return minGrade;
}
/**
 * Get the UUID of the course
 * @return The UUID of the course
 */
public String getCourseUUID() {
    return courseUUID;
}
/**
 * Get the course ID of the course
 * @return The course ID of the course
 */
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
