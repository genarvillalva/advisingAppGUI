package advising;

import java.util.ArrayList;

public class StudentElectives {

  private String studentName;
  private ArrayList<ElectiveCluster> electives;

  public StudentElectives(
    String studentName,
    ArrayList<ElectiveCluster> electives
) {
    this.studentName = studentName;
    this.electives = electives;
  }

  public String getStudentName() {
    return studentName;
  }

  public ArrayList<ElectiveCluster> getElectives() {
    return electives;
  }
  public String toString() {
    return "studentName: "+studentName + " \nElectives:" + electives + "\n";
  }
}
