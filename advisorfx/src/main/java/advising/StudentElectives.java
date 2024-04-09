package advising;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentElectives {

  private String studentName;
  private ArrayList<ElectiveCluster> electives;

  public StudentElectives(String studentName){
    this.studentName = studentName;
    this.electives = new ArrayList<ElectiveCluster>();
    setupElectives();
  }
/**
 * Constructor for the StudentElectives class
 * @param studentName Name of a student
 * @param electives Electives for a student
 */
  public StudentElectives(
    String studentName,
    ArrayList<ElectiveCluster> electives
) {
    this.studentName = studentName;
    this.electives = electives;
  }
/**
 * Gets the name of a student
 * @return Name of a student
 */
  public String getStudentName() {
    return studentName;
  }

  public void setupElectives() {
    electives.add(labScienceElectives);
    electives.add(csceElectives);
  }
/**
 * Gets the electives for a student
 * @return Electives for a student
 */
  public ArrayList<ElectiveCluster> getElectives() {
    return electives;
  }
  /**
   * String representation of a student's electives
   */
  public String toString() {
    return "studentName: "+studentName + " \nElectives:" + electives + "\n";
  }

  ElectiveCluster labScienceElectives = new ElectiveCluster(
            "Lab Science Electives", 
            4, 
            0, 
            createElectiveClassesForLabScience() 
        );

        ElectiveCluster csceElectives = new ElectiveCluster(
            "Computer Science and Engineering Electives", 
            9, 
            0, 
            createElectiveClassesForCSCE() 
        );
    
/**
 * Creates a hashmap of elective classes for lab science
 * @return HashMap
 */
    private static HashMap<String, Boolean> createElectiveClassesForLabScience() {
        HashMap<String, Boolean> classes = new HashMap<>();
        classes.put("ANTH161", false);
        classes.put("ASTR101", false);
        classes.put("BIOL101", false);
        classes.put("BIO101L", false);
        classes.put("CHEM111", false);
        classes.put("CHEM111L", false);
        classes.put("ENVR101", false);
        classes.put("ENVR101L", false);
        classes.put("GEOG201", false);
        classes.put("GEOG202", false);
        classes.put("GEOL101", false);
        classes.put("GEOL103", false);
        classes.put("GEOL201", false);
        classes.put("GEOL215", false);
        classes.put("GEOL215L", false);
        classes.put("GEOL302", false);
        classes.put("MSCI101", false);
        classes.put("MSCI102", false);
        classes.put("MSCI210", false);
        classes.put("MSCI210L", false);
        classes.put("MSCI215", false);
        classes.put("MSCI215L", false);
        classes.put("PHYS211", false);
        classes.put("PHYS211L", false);
        return classes;
    }
/**
 * Creates a hashmap of elective classes for CSCE
 * @return HashMap 
 */
    private static HashMap<String, Boolean> createElectiveClassesForCSCE() {
        HashMap<String, Boolean> classes = new HashMap<>();
        classes.put("CSCE500", false);
        classes.put("CSCE510", false);
        classes.put("CSCE512", false);
        classes.put("CSCE513", false);
        classes.put("CSCE515", false);
        classes.put("CSCE516", false);
        classes.put("CSCE517", false);
        classes.put("CSCE518", false);
        classes.put("CSCE520", false);
        classes.put("CSCE522", false);
        classes.put("CSCE526", false);
        classes.put("CSCE531", false);
        classes.put("CSCE546", false);
        classes.put("CSCE547", false);
        classes.put("CSCE548", false);
        classes.put("CSCE551", false);
        classes.put("CSCE552", false);
        classes.put("CSCE555", false);
        classes.put("CSCE556", false);
        classes.put("CSCE557", false);
        classes.put("CSCE561", false);
        classes.put("CSCE564", false);
        classes.put("CSCE565", false);
        classes.put("CSCE567", false);
        classes.put("CSCE569", false);
        classes.put("CSCE571", false);
        classes.put("CSCE572", false);
        classes.put("CSCE574", false);
        classes.put("CSCE578", false);
        classes.put("CSCE580", false);
        classes.put("CSCE581", false);
        classes.put("CSCE582", false);
        classes.put("CSCE585", false);
        classes.put("CSCE587", false);
        classes.put("CSCE590", false);
        classes.put("CSCE594", false);
        return classes;
    }
}
