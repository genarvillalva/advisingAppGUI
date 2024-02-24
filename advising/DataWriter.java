package advising;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

  /**
   * Writes a list of students to a JSON file.
   * @param students List of Student objects to be written to the file.
   * @param filePath The path to the JSON file.
   */
  public static void writeStudents(List<Student> students, String filePath) {
    JSONArray studentsArray = new JSONArray();
    for (Student student : students) {
      JSONObject studentObject = new JSONObject();
      studentObject.put(FIRST_NAME, student.getFirstName());
      studentObject.put(LAST_NAME, student.getLastName());
      studentObject.put(USER_NAME, student.getUserName());
      studentObject.put(PASSWORD, student.getPassword());
      studentObject.put(MAJOR, student.getMajor());
      studentObject.put(ADVISOR, student.getAdvisor().getUserName()); // Assuming advisor is represented by username
      studentObject.put(STUDENT_YEAR, student.getStudentClass().toString());
      studentObject.put(PORTFOLIO_UUID, student.getPortfolio().getUuid()); // Assuming portfolio has a UUID
      studentObject.put(APPLICATION_AREA, student.getApplicationArea());
      studentsArray.add(studentObject);
    }
    writeToFile(studentsArray, filePath);
  }

  /**
   * Writes a list of advisors to a JSON file.
   * @param advisors List of Advisor objects to be written to the file.
   * @param filePath The path to the JSON file.
   */
  public static void writeAdvisors(List<Advisor> advisors, String filePath) {
    JSONArray advisorsArray = new JSONArray();
    for (Advisor advisor : advisors) {
      JSONObject advisorObject = new JSONObject();
      advisorObject.put(FIRST_NAME, advisor.getFirstName());
      advisorObject.put(LAST_NAME, advisor.getLastName());
      advisorObject.put(USER_NAME, advisor.getUserName());
      advisorObject.put(PASSWORD, advisor.getPassword());
      // Handle advised students separately
      advisorsArray.add(advisorObject);
    }
    writeToFile(advisorsArray, filePath);
  }

  // Helper method to write JSON array to file
  private static void writeToFile(JSONArray jsonArray, String filePath) {
    try (FileWriter fileWriter = new FileWriter(filePath)) {
      fileWriter.write(jsonArray.toJSONString());
      fileWriter.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
