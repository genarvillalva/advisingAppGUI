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
    setupAdviseeListViewClickListener(); 

  }

  @FXML
  void switchToAddAdvisee(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAdvisee.fxml"));
    Parent root = loader.load();

    AddAdviseeController addAdviseeController = loader.getController();
    addAdviseeController.setAdvisorHomeController(this); 

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
      
      
      adviseeListView.getItems().clear();   // we then need to clear the list so we dont get duplicates 


      for (Student student : advisees) {
            // Gonna create a string that contains the students first name anddd last name andd username.
        String formattedString = student.getFirstName() + " " + student.getLastName() + " (" + student.getUsername() + ")";
        
        // this should be visible on the screen for the user to look at 
        adviseeListView.getItems().add(formattedString);
    }
      //I need to refresh the list to show the lastest updated users on the list
      adviseeListView.refresh();
      setupAdviseeListViewClickListener();

  }

  public void refreshAdviseeList() {
      System.out.println("Refreshing advisees"); 
      loadAdvisees();
  }


  private void setupAdviseeListViewClickListener() {
    adviseeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null && !newValue.isEmpty()) {
            try {
                // get only the username within the parentheses.
                String username = newValue.substring(newValue.lastIndexOf("(") + 1, newValue.lastIndexOf(")"));
                System.out.println("Selected username: " + username); // Debug output
                openAdviseeScreen(username);
            } catch (IOException e) {
                e.printStackTrace(); 
            }
        }
    });
}


  //handle the opening of the Advisee screen
  private void openAdviseeScreen(String username) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AdviseeScreen.fxml"));
    Parent root = loader.load();
    
    AdviseeScreenController controller = loader.getController();
    controller.loadAdviseeData(username); // passes the username to the new screen
    
    Stage stage = new Stage();
    stage.setTitle("Advisee Profile");
    stage.setScene(new Scene(root));
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.showAndWait();
  }

 
}

  
