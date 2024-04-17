module advisorfx {
  requires javafx.controls;
  requires javafx.fxml;
  requires json.simple;
requires javafx.base;
requires javafx.graphics;

  opens advisorfx to javafx.fxml;
  exports advisorfx ;

  opens advising to javafx.fxml;
  exports advising ;
}
