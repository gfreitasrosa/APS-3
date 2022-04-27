module com.example.aps {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.aps to javafx.fxml;
    exports com.example.aps;
}