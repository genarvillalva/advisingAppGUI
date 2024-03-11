package advising;

import java.util.HashMap;

public class ElectiveCluster {
  private HashMap<Course, Boolean> Courses;
  private int hoursRequired;
  private int hoursCompleted;



  public ElectiveCluster() {
    this.Courses = new HashMap<Course, Boolean>();
  } 
  public boolean isClusterComplete() {

    return true;
  }

  public int hoursCompleted() {

    return hoursCompleted;
  }

  
  
  public int hoursRequired() { 

    return hoursRequired;
  }

}
