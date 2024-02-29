package advising;

import java.util.HashMap;

public class ElectiveCluster {
  private HashMap<Course, Boolean> Courses;

  public ElectiveCluster() {
    this.Courses = new HashMap<Course, Boolean>();
}
  public boolean isClusterComplete() {

    return true;
  }

  public int hoursCompleted() {

    return 0;
  }

  public int hoursRequired() {

    return 0;
  }

}
