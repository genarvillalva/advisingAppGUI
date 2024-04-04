module advisorfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens advisorfx to javafx.fxml;
    exports advisorfx;
}
