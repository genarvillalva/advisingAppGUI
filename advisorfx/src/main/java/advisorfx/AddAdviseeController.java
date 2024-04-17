package advisorfx;

import advising.AuditFacade;
import java.io.IOException;
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

public class AddAdviseeController {

 
     private AdvisorHomeController advisorHomeController;

     public void setAdvisorHomeController(AdvisorHomeController controller) {
         this.advisorHomeController = controller;
     }
 
 
 
 
 
  @FXML
    private TextField AddAdviseeTextBox;

    @FXML
    void addAdvisee(ActionEvent event) throws IOException{
      AuditFacade auditFacade = AuditFacade.getInstance();
      
      auditFacade.addAdvisee(AddAdviseeTextBox.getText());


              if (advisorHomeController != null) {
                advisorHomeController.refreshAdviseeList();
            }
    
            Stage stage = (Stage) AddAdviseeTextBox.getScene().getWindow();
            stage.close();
        }





        
    }
