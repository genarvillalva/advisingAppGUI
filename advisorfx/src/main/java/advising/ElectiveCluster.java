package advising;

import java.util.HashMap;
import java.util.Map;

public class ElectiveCluster {

  private int hoursRequired;
  private int hoursCompleted;
  private String electiveName;
  private HashMap<String, Boolean> electives;
/**
 * Constructor for the ElectiveCluster class
 * @param electiveClusterUUID UUID of an elective cluster
 * @param electives Electives in a cluster
 * @param hoursRequired Hours in a elective cluster required
 * @param hoursCompleted Hours in a elective cluster completed
 */
  public ElectiveCluster(
    String electiveName,
    int hoursRequired,
    int hoursCompleted, HashMap<String, Boolean> electives) 
    {
    this.hoursRequired = hoursRequired;
    this.hoursCompleted = hoursCompleted;
    this.electives = electives;
    this.electiveName = electiveName;
  }
/**
 * Gets the name of an elective cluster
 * @return Name of an elective cluster
 */
  public String getElectiveName() {
    return electiveName;
  }

  /**
   * Calculates if the elective cluster is finished
   * @return True if user has enough hours to complete a cluster
   */
  public boolean isClusterComplete() {
    return (hoursCompleted >= hoursRequired);
  }


  /**
   * Gets the electives in a cluster
   * @return Electives in a cluster
   */
  public HashMap<String, Boolean> getElectives() {
    return electives;
  }
  /**
   * Gets credit hours from an elective cluster
   * @return Hours in a elective cluster completed
   */
  public int getHoursCompleted() {
    return hoursCompleted;
  }

  /**
   * Gets credit hours needed to complete an elective cluster
   * @return Hours in a elective cluster required
   */
  public int getHoursRequired() {
    return hoursRequired;
  }
/**
 * Sets the credit hours needed to complete an elective cluster
 * @param hoursCompleted Hours in a elective cluster required
 */
  public void setHoursCompleted(int hoursCompleted) {
    this.hoursCompleted = hoursCompleted;
  }

  /**
   * Sets the credit hours needed to complete an elective cluster
   * @param courseCode Course code
   * @param completed boolean value to see if course is completed
   */
  public void updateCourseCompletion(String courseCode, boolean completed) {
    if (electives.containsKey(courseCode)) {
        electives.put(courseCode, completed);
    } else {
        System.out.println("Course not found in elective cluster");
    }
  }

  /**
   * Gets the string representation of an elective cluster
   */
  public String toString() {
      return "ElectiveCluster{" +
              "electivename='" + electiveName + '\'' +
              ", hoursRequired=" + hoursRequired +
              ", hoursCompleted=" + hoursCompleted +
              ", electives=" + electives +
              '}';
  }

}
