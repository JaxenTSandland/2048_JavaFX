module personal.sandland.jaxen.jaxens_2048javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens personal.sandland.jaxen.jaxens_2048javafx to javafx.fxml;
    exports personal.sandland.jaxen.jaxens_2048javafx;
}