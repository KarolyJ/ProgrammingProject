module com.example.programmingproject {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.programmingproject.logic;
    opens com.example.programmingproject.logic to javafx.fxml;
}