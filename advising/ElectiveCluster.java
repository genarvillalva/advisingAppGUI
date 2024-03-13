package advising;

import java.util.HashMap;

public class ElectiveCluster {
  private HashMap<Course, Boolean> coursesHash;
  private int hoursRequired;
  private int hoursCompleted;



  public ElectiveCluster(HashMap<Course, Boolean> coursesHash, int hoursRequired, int hoursCompleted) {
    this.coursesHash = coursesHash;
    this.hoursRequired = hoursRequired;
    this.hoursCompleted = hoursCompleted;
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

}
