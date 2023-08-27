


package com.example.programmingproject.gui.controllers;

import java.io.IOException;
import java.util.Objects;

import com.example.programmingproject.gui.HelloApplication;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController
{
    //start scene buttons
    @FXML
    private Button newGame;
    //menu buttons
    @FXML
    private Button ranking;
    @FXML
    private Button settings;
    @FXML
    private Button rules;
    @FXML
    private Button back;

    @FXML
    public void switchToGame(MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.newGame.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("newgame.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    public void switchToSettings(MouseEvent event) throws IOException{
        final Stage stage = (Stage)this.settings.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("settings.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
    public void switchToRules(MouseEvent event) throws IOException{
        final Stage stage = (Stage)this.rules.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("rules.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    public void switchToMenuBack(MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.back.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("menu.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
}