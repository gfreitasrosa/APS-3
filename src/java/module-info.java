module com.example.aps {
    requires javafx.controls;
    requires java.desktop;


    exports entidades;
    opens entidades to javafx.fxml;
    exports interfaces;
    opens interfaces to javafx.fxml;
    exports csv;
    opens csv to javafx.fxml;
}