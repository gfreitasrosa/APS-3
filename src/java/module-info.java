module com.example.aps {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.aps to javafx.fxml;
    opens JavaFX to javafx.fxml;
    exports entidades;
    opens entidades to javafx.fxml;
    exports interfaces;
    opens interfaces to javafx.fxml;
    exports csv;
    opens csv to javafx.fxml;
}