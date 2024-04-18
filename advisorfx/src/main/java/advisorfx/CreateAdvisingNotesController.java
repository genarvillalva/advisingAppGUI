package advisorfx;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class CreateAdvisingNotesController {

    @FXML
    private Pane AdvisingMenuPaneAN;

    @FXML
    private Hyperlink AdvisingNotesLabelAdviseAN;

    @FXML
    private Hyperlink HomeLabelAdviseAN;

    @FXML
    private ChoiceBox<?> LogOutBoxAdvise;

    @FXML
    private Text SENDAN;

    @FXML
    private Hyperlink TranscriptLabelAN;

    @FXML
    private TextArea WRITEAN;





    @FXML
    private void initialize() {
        HomeLabelAdviseAN.setOnMouseClicked(event -> highlightHyperlink(HomeLabelAdviseAN));
        TranscriptLabelAN.setOnMouseClicked(event -> highlightHyperlink(TranscriptLabelAN));
        AdvisingNotesLabelAdviseAN.setOnMouseClicked(event -> highlightHyperlink(AdvisingNotesLabelAdviseAN));
    }
    
    private void highlightHyperlink(Hyperlink Hyperlink) {
        HomeLabelAdviseAN.getStyleClass().remove("highlighted");
        TranscriptLabelAN.getStyleClass().remove("highlighted");
        AdvisingMenuPaneAN.getStyleClass().remove("highlighted");
    

        Hyperlink.getStyleClass().add("highlighted");
        
    }


    @FXML
    void viewTranscriptasAdvisor() throws IOException {
    }
    @FXML
    void viewAdvisingNotesAsAdvisor() throws IOException {
      App.setRoot("CreateAdvisingNotes");
    }
  
    @FXML
    void viewStudentHomeAsAdvisor() throws IOException {
      App.setRoot("AdviseeScreen");
    }
  
  





}
