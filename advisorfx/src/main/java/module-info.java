module advisorfx {
  requires javafx.controls;
  requires javafx.fxml;
  requires json.simple;

  opens advisorfx to javafx.fxml;
  exports advisorfx ;

  opens advising to javafx.fxml;
  exports advising ;
}
