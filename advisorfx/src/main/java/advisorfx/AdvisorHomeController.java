package advisorfx;

import advising.AuditFacade;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdvisorHomeController{

  @FXML
    private Button AddAdviseeButton;

    @FXML
    private Label AdvisorGreetingsText;

    @FXML
    private Label AdvisorProfileNameLabel;

    @FXML
    private Button DeleteAdviseeButton;

    @FXML
    private TextField SearchAdviseeTextBox;

    @FXML
    private Label AdviseeListLabel;

  @FXML
  private void setUp() {
    AuditFacade auditFacade = AuditFacade.getInstance();
    AdvisorGreetingsText.setText(
      "Hello, " +
      auditFacade.getAdvisor().getFirstName() +
      " " +
      auditFacade.getAdvisor().getLastName() + "!"
    );
    AdvisorProfileNameLabel.setText(
      auditFacade.getAdvisor().getFirstName() +
      " " +
      auditFacade.getAdvisor().getLastName()
    );
  }

  @FXML
  private void initialize(){
    setUp();
  }

  @FXML 
void addAdvisee() throws IOException {
    // Load the FXML file for the new window
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAdvisee.fxml"));
    Parent root = loader.load();
    
    // Create a new stage
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.setTitle("AddAdvisee");
    
    // Set the stage modality to APPLICATION_MODAL
    stage.initModality(Modality.APPLICATION_MODAL);

    // Show the new stage
    stage.showAndWait();
}

  

  @FXML
  private void logout() throws IOException {
    App.setRoot("LoginPage");
  }
}
