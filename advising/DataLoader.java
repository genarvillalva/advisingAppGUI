package advising;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;
import java.io.FileReader;

public class DataLoader extends DataConstants {
    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader("advising-app/advising/jsonfiles/students.json");
            JSONParser parser = new JSONParser();
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject) studentsJSON.get(i);

                Student student = new Student(
                    (String) studentJSON.get(NAME),
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
    }
}
