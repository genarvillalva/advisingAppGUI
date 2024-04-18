package advisorfx;

import java.io.IOException;
import java.util.List;

import advising.Advisor;
import advising.AuditFacade;
import advising.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AdvisorHomeController {

    @FXML
    private Label AdvisorGreetingsText;
    @FXML
    private Label AdvisorProfileNameLabel;
    @FXML
    private Button DeleteAdviseeButton;
    @FXML
    private TextField AddAdvisee;
    @FXML
    private ListView<String> adviseeListView;

    @FXML
    private void setUp() {
        AuditFacade auditFacade = AuditFacade.getInstance();
        AdvisorGreetingsText.setText("Hello, " + auditFacade.getAdvisor().getFirstName() + " " + auditFacade.getAdvisor().getLastName() + "!");
        AdvisorProfileNameLabel.setText(auditFacade.getAdvisor().getFirstName() + " " + auditFacade.getAdvisor().getLastName());
    }

    @FXML
    private void initialize() {
        System.out.println("Current Advisor during initialization: " + AuditFacade.getInstance().getAdvisor().getUsername());
        setUp();
        loadAdvisees();
        setupAdviseeTextField();
        setupAdviseeListViewClickListener();
    }

    private void loadAdvisees() {
        List<Student> advisees = AuditFacade.getInstance().getAdvisor().getListOfAdvisedStudents();
        adviseeListView.getItems().clear();
        advisees.forEach(student -> adviseeListView.getItems().add(formatStudentDisplay(student)));
        adviseeListView.refresh();
    }

    private String formatStudentDisplay(Student student) {
        return student.getFirstName() + " " + student.getLastName() + " (" + student.getUsername() + ")";
    }

    private void setupAdviseeTextField() {
        AddAdvisee.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                addAdvisee();
            }
        });
    }

private void addAdvisee() {
    String input = AddAdvisee.getText().trim();
    if (!input.isEmpty()) {
        AuditFacade auditFacade = AuditFacade.getInstance();
        Advisor currentAdvisor = auditFacade.getAdvisor();
        if (currentAdvisor == null) {
            System.out.println("No advisor logged in to add an advisee.");
            return;
        }

        try {
            // Check if the student exists and is not already an advisee
            Student newStudent = auditFacade.getStudentByUsername(input);
            if (newStudent == null) {
                System.out.println("Student with username " + input + " does not exist.");
                return;
            }
            if (currentAdvisor.getListOfAdvisedStudents().contains(newStudent)) {
                System.out.println("Student " + input + " is already an advisee of " + currentAdvisor.getUsername());
                return;
            }

            // Add student to advisor's list
            currentAdvisor.addToAdviseeList(newStudent);  // Ensure this method exists and correctly modifies the advisor's list
            adviseeListView.getItems().add(formatStudentDisplay(newStudent));
            adviseeListView.refresh();
            AddAdvisee.clear();
            System.out.println("Added student " + input + " to advisor " + currentAdvisor.getUsername() + "'s list.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    private void setupAdviseeListViewClickListener() {
        adviseeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                openAdviseeScreen(newValue.substring(newValue.lastIndexOf("(") + 1, newValue.lastIndexOf(")")));
            }
        });
    }

    private void openAdviseeScreen(String username) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdviseeScreen.fxml"));
            Parent root = loader.load();
            
            AdviseeScreenController controller = loader.getController();
            controller.loadAdviseeData(username); // Load data for the selected username
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) adviseeListView.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Advisee Profile");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logout() throws IOException {
        App.setRoot("LoginPage");
    }
}
