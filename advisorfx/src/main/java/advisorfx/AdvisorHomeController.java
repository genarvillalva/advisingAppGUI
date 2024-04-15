package advisorfx;

import advising.AuditFacade;
import advising.Student;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class AdvisorHomeController {

  

  @FXML
  private Label AdvisorGreetingsText;

  @FXML
  private Label AdvisorProfileNameLabel;

  @FXML
  private Button DeleteAdviseeButton;

  @FXML
  private TextField SearchAdviseeTextBox;

  @FXML
  private ListView<String> adviseeListView;

  @FXML
  private void setUp() {
    AuditFacade auditFacade = AuditFacade.getInstance();
    AdvisorGreetingsText.setText(
      "Hello, " +
      auditFacade.getAdvisor().getFirstName() +
      " " +
      auditFacade.getAdvisor().getLastName() +
      "!"
    );
    AdvisorProfileNameLabel.setText(
      auditFacade.getAdvisor().getFirstName() +
      " " +
      auditFacade.getAdvisor().getLastName()
    );
  }

  @FXML
  private void initialize() {
    setUp();
    loadAdvisees();
  }

  @FXML
  void switchToAddAdvisee(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAdvisee.fxml"));
    Parent root = loader.load();

    AddAdviseeController addAdviseeController = loader.getController();
    addAdviseeController.setAdvisorHomeController(this); // Set the reference


    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setTitle("Add Advisee");
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.showAndWait();
    
  }

  

  @FXML
  private void logout() throws IOException {
    App.setRoot("LoginPage");
  }

  private void loadAdvisees() {
      List<Student> advisees = AuditFacade.getInstance().getAdvisor().getListOfAdvisedStudents();
      System.out.println("Advisees loaded: " + advisees.size());  // checks to see how many advisees are loaded
      for (Student student : advisees) {
        String formattedString = student.getFirstName() + " " + student.getLastName() + " (" + student.getUsername() + ")";
        adviseeListView.getItems().add(formattedString);
    }
      adviseeListView.refresh();
  }

  public void refreshAdviseeList() {
      System.out.println("Refreshing advisees"); 
      loadAdvisees();
  }



  
}
