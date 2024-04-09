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
  private Semester semester;
  private String minGrade;
  private String courseUUID;
  private String courseTitle;
  private int preferredSemester;

  public Course (
    String courseID,
    String courseTitle,
    CourseCode courseCode,
    int creditHours,
    String minGrade,
    Semester semester,
    int preferredSemester
  ) {
    this.courseID = courseID;
    this.courseTitle = courseTitle;
    this.courseCode = courseCode;
    this.creditHours = creditHours;
    this.minGrade = minGrade;
    this.semester = semester;
    this.preferredSemester = preferredSemester;
    this.prerequisiteCourses = new ArrayList<Course>();
    this.corequisiteCourses = new ArrayList<Course>();
    this.prereqCoreq = new ArrayList<Course>();
  }
  public void addPrereq(Course course) {
    prerequisiteCourses.add(course);
  }
  public void addCoreq(Course course) {
    corequisiteCourses.add(course);
  }
  public void addPrereqCoreq(Course course) {
    prereqCoreq.add(course);
  }

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
  public String getCourseCode() {
    return courseCode+"";
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
   * Get the prereqCoreq of the course
   * @return The prereqCoreq of the course
   */
  public ArrayList<Course> getPrereqCoreq() {
    return prereqCoreq;
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
  public String getMinGrade() {
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
    String minGrade,
    Semester semester,
    ArrayList<Course> prerequisiteCourses,
    ArrayList<Course> corequisiteCourses,
    ArrayList<Course> prereqCoreq,
    int preferredSemester
  ) {
    this.courseID = courseID;
    this.courseTitle = courseTitle;
    this.courseCode = courseCode;
    this.creditHours = creditHours;
    this.minGrade = minGrade;
    this.semester = semester;
    this.prerequisiteCourses = prerequisiteCourses;
    this.corequisiteCourses = corequisiteCourses;
    this.prereqCoreq = prereqCoreq;
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
        if (completedCourse.equals(completedCourse.getCourseID())) {
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
    result += "Semester: " + semester.toString() + "\n";
    //prereq
    result += "Prerequisite Courses: ";
    if ((prerequisiteCourses != null) && (!prerequisiteCourses.isEmpty())) {
        for (Course prereq : prerequisiteCourses) {
            result += prereq.getCourseTitle() + ", ";
        }
        result = result.substring(0, result.length() - 2); 
    } else {
        result += "None";
    }
    result += "\n";
    //coreq 
    result += "Corequisite Courses: ";
    if ((corequisiteCourses != null) && (!corequisiteCourses.isEmpty())) {
        for (Course coreq : corequisiteCourses) {
            result += coreq.getCourseTitle() + ", ";
        }
        result = result.substring(0, result.length() - 2); 
    } else {
        result += "None";
    }
    result += "\n";

    //prereq coreq 
    result += "PrereqCoreq: ";
    if ((prereqCoreq != null) && (!prereqCoreq.isEmpty())) {
        for (Course prereqCoreq : prereqCoreq) {
            result += prereqCoreq.getCourseTitle() + ", ";
        }
        result = result.substring(0, result.length() - 2); 
    } else {
        result += "None";
    }
    result += "\n";
    return result;
}

}
