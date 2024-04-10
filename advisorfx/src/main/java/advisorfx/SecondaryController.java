package advisorfx;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToLoginScreen() throws IOException {
        App.setRoot("LoginPage");
    }
}