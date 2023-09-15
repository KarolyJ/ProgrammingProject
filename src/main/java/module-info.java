module com.example.programmingproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires com.fasterxml.jackson.databind;


    exports com.example.programmingproject.logic;
    opens com.example.programmingproject.logic to javafx.fxml;
    // Open the package to tests
//    opens com.example.programmingproject.test to junit;

    opens com.example.programmingproject.gui to javafx.fxml;
    exports com.example.programmingproject.gui;
    exports com.example.programmingproject.gui.controllers;
    opens com.example.programmingproject.gui.controllers to javafx.fxml;
    exports com.example.programmingproject.gui.exceptions;
    opens com.example.programmingproject.gui.exceptions to javafx.fxml;
    exports com.example.programmingproject.gui.holders;
    opens com.example.programmingproject.gui.holders to javafx.fxml;

}