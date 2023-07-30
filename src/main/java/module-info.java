module com.example.programmingproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    exports com.example.programmingproject.logic;
    opens com.example.programmingproject.logic to javafx.fxml;
    // Open the package to tests
    opens com.example.programmingproject.test to junit;

    opens com.example.programmingproject.gui to javafx.fxml;
    exports com.example.programmingproject.gui;

}