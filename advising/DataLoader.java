package advising;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    /**
     * This method reads the students.json file and returns an ArrayList of Student objects.
     * @return ArrayList<Student>
     */
  public static ArrayList<Student> getAllStudents() {
    ArrayList<Student> students = new ArrayList<Student>();
    try {
      FileReader reader = new FileReader(
        "advising-app/advising/jsonfiles/students.json"
      );
      JSONParser parser = new JSONParser();
      JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);
      for (int i = 0; i < studentsJSON.size(); i++) {
        JSONObject studentJSON = (JSONObject) studentsJSON.get(i);

        Student student = new Student(
          (String) studentJSON.get(FIRST_NAME),
          (String) studentJSON.get(LAST_NAME),
          (String) studentJSON.get(USER_NAME),
          (String) studentJSON.get(PASSWORD),
          (String) studentJSON.get(MAJOR),
          (Advisor) studentJSON.get(ADVISOR),
          (StudentYear) studentJSON.get(STUDENT_YEAR),
          (StudentPortfolio) studentJSON.get(PORTFOLIO_UUID),
          (String) studentJSON.get(APPLICATION_AREA)
        );
        students.add(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return students;
  }
  public static ArrayList<Advisor> getAllAdvisors() {
    ArrayList<Advisor> advisors = new ArrayList<Advisor>();
    try {
      FileReader reader = new FileReader(
        "advising-app/advising/jsonfiles/advisors.json"
      );
      JSONParser parser = new JSONParser();
      JSONArray advisorsJSON = (JSONArray) new JSONParser().parse(reader);
      for (int i = 0; i < advisorsJSON.size(); i++) {
        JSONObject advisorJSON = (JSONObject) advisorsJSON.get(i);

        Advisor advisor = new Advisor(
          (String) studentJSON.get(FIRST_NAME),
          (String) studentJSON.get(LAST_NAME),
          (String) studentJSON.get(USER_NAME),
          (String) studentJSON.get(PASSWORD),
          (String) studentJSON.get(MAJOR),
          (Advisor) studentJSON.get(ADVISOR),
          (StudentYear) studentJSON.get(STUDENT_YEAR),
          (StudentPortfolio) studentJSON.get(PORTFOLIO_UUID),
          (String) studentJSON.get(APPLICATION_AREA)
        );
        advisors.add(advisor);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return advisors;
  }
}
