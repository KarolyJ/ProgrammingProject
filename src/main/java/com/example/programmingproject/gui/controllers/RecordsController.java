package com.example.programmingproject.gui.controllers;

import com.example.programmingproject.gui.MainApplication;
import com.example.programmingproject.objects.Record;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class RecordsController {
    public Label easyLabel;
    public Label mediumLabel;
    public Label hardLabel;
    public Button backButton;

    public void initialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        Record[] recordArray = mapper.readValue(new File("src/main/resources/records.json"), Record[].class);
        for(Record r : recordArray) {
            if(r.getLevel().equals("EASY")) {
                easyLabel.setText("Easy : " + r.getTime());
            } else if(r.getLevel().equals("MEDIUM")) {
                mediumLabel.setText("Medium : " + r.getTime());
            } else if(r.getLevel().equals("HARD")){
                hardLabel.setText("Hard : " + r.getTime());
            }
        }

    }
    @FXML
    public void switchToMenu(final MouseEvent event) throws IOException {
        final Stage stage = (Stage) this.backButton.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
}
