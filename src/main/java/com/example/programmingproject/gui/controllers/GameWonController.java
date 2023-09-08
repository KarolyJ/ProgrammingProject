package com.example.programmingproject.gui.controllers;

import com.example.programmingproject.gui.HelloApplication;
import com.example.programmingproject.gui.TimerHolder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GameWonController {

    public Button backButton;
    public Label timeLabel;

    public void initialize() {
        TimerHolder holder = TimerHolder.getInstance();
        timeLabel.setText("You solved it in : " + holder.getTime());
    }

    @FXML
    public void switchToMenu(final MouseEvent event) throws IOException {
        final Stage stage = (Stage) this.backButton.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
}
