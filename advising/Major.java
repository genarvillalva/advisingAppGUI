package advising;

import java.util.ArrayList;

public class Major {

  private String majorName;
  private ArrayList<Course> requiredCourses;
  private int requiredCourseCount;
  private String majorID;

public Major(String majorName, String majorID, ArrayList<Course> requiredCourses, int requiredCourseCount) {
    this.majorName = majorName;
    this.requiredCourses = requiredCourses;
    this.requiredCourseCount = requiredCourseCount;
    this.majorID = majorID;
}
  /**
   * Returns the name of the major
   * @return The name of the major
   */
  public String getMajorName() {
    return majorName;
  }

  /**
   * Returns the list of required courses for the major
   * @return The list of required courses
   */
  public ArrayList<Course> getRequiredCourses() {
    return requiredCourses;
  }

  /**
   * Returns the count of required courses for the major
   * @return The count of required courses
   */
  public int getRequiredCourseCount() {
    return requiredCourseCount;
  }

  /**
   * Returns the ID of the major
   * @return ID of the major
   */
  public String getMajorID() {
    return majorID;
  }
  public String toString() {
    return "majorName: " + majorName + "\nmajorID: " + majorID + "\nrequiredCourses: " + requiredCourses + "\nrequiredCourseCount: " + requiredCourseCount;
  }
  public void displayRequiredMajorCourses() {}
}
