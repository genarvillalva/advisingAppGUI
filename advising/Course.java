package advising;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {

  private String courseID;
  private CourseCode courseCode;
  private int creditHours;
  private ArrayList<Course> prerequisiteCourses;
  private ArrayList<Course> corequisiteCourses;
  private ArrayList<Course> prereqCoreq;
  private ArrayList<Semester> semester;
  private char minGrade;
  private String courseUUID;
  private String courseTitle;
  private int preferredSemester;


  /**
   * Get the title of the course
   * @return The title of the course
   */
  public String getCourseTitle() {
    return courseTitle;
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
  public ArrayList<Semester> getSemester() {
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

  /**
  * Gets the preferred semester of the course
  * @return The preferred semester of the course
  */
  public int getPreferredSemester() {
    return preferredSemester;
  }

  /**
   * Get the title of the course
   * @param courseID The title of the course
   * @param title The title of the course
   * @param courseCode The course code of the course
   * @param creditHours The credit hours of the course
   * @param minGrade The minimum grade of the course
   * @param semester The semester of the course
   * @param prerequisiteCourses The prerequisite courses of the course
   */
  public Course(
    String courseID,
    String courseTitle,
    CourseCode courseCode,
    int creditHours,
    char minGrade,
    ArrayList<Semester> semester,
    ArrayList<Course> prerequisiteCourses,
    int preferredSemester
  ) {
    this.courseID = courseID;
    this.courseTitle = courseTitle;
    this.courseCode = courseCode;
    this.creditHours = creditHours;
    this.minGrade = minGrade;
    this.semester = semester;
    this.prerequisiteCourses = prerequisiteCourses;
    this.preferredSemester = preferredSemester;
  }

  /**
   * Searches completed course for every prerequisite course
   * @return The true if all prerequisite are completed and false if not
   */
  public boolean PrereqComplete(
    ArrayList<Course> prerequisiteCourses,
    ArrayList<Course> completedCourses
  ) {
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
  
  /**
   * String representation of a course
   */
  public String toString() {
        String result = "CourseID: " + courseID + "\n";
        result += "Title: " + courseTitle + "\n";
        result += "Course Code: " + courseCode + "\n";
        result += "Credit Hours: " + creditHours + "\n";
        result += "Minimum Grade: " + minGrade + "\n";
        result += "Semester: " + Arrays.toString(semester.toArray()) + "\n";
        
        // Check if prerequisiteCourses is empty
        if (!prerequisiteCourses.isEmpty()) {
            result += "Prerequisite Courses: " + Arrays.toString(prerequisiteCourses.toArray()) + "\n";
        } else {
            result += "Prerequisite Courses: None\n";
        }
        
        if(corequisiteCourses == null) {
            corequisiteCourses = new ArrayList<Course>();
        }
        if (!corequisiteCourses.isEmpty()) {
            result += "Corequisite Courses: " + Arrays.toString(corequisiteCourses.toArray()) + "\n";
        } else {
            result += "Corequisite Courses: None\n";
        }
        
        // Check if prereqCoreq is empty
        if(prereqCoreq == null) {
            prereqCoreq = new ArrayList<Course>();
        }
        if (!prereqCoreq.isEmpty()) {
            result += "PrereqCoreq: " + Arrays.toString(prereqCoreq.toArray()) + "\n";
        } else {
            result += "PrereqCoreq: None\n";
        }
        
        return result;
    }
}
