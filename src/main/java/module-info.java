module com.example.programmingproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.programmingproject to javafx.fxml;
    exports com.example.programmingproject;
}