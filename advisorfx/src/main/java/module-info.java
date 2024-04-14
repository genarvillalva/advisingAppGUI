module advisorfx {
  requires javafx.controls;
  requires javafx.fxml;
  requires json.simple;
requires javafx.base;

  opens advisorfx to javafx.fxml;
  exports advisorfx ;

  opens advising to javafx.fxml;
  exports advising ;
}
