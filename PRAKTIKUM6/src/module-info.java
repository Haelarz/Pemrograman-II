module PRAKTIKUM6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Controller to javafx.fxml;
    opens model to javafx.base;

    exports application;
    exports Controller;
    exports model;
}
