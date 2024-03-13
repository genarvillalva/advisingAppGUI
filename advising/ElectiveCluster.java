package advising;

import java.util.HashMap;

public class ElectiveCluster {
  private HashMap<Course, Boolean> Courses;
  private int hoursRequired;
  private int hoursCompleted;



  public ElectiveCluster() {
    this.Courses = new HashMap<Course, Boolean>();
  } 

  /**
   * Calculates if the elective cluster is finished
   * @return True if user has enough hours to complete a cluster
   */
  public boolean isClusterComplete() {

    return (hoursCompleted >= hoursRequired);
  }

  /**
   * Gets credit hours from an elective cluster
   * @return Hours in a elective cluster completed
   */
  public int hoursCompleted() {

    return hoursCompleted;
  }

  
  /**
   * Gets credit hours needed to complete an elective cluster
   * @return Hours in a elective cluster required
   */
  public int hoursRequired() { 

    return hoursRequired;
  }

}
