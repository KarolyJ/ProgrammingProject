


package com.example.programmingproject.gui;

import java.io.IOException;
import java.util.Objects;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController
{
    //start scene buttons
    @FXML
    private Button newGame;
    //menu buttons
    @FXML
    private Button easy;
    @FXML
    private Button hard;
    @FXML
    private Button medium;
    @FXML
    private Button ranking;
    @FXML
    private Button settings;
    @FXML
    private Button rules;

    @FXML
    public void switchToMenu(final MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.newGame.getScene().getWindow();
        final Parent root = (Parent)FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
    @FXML
    public void switchToEasy(MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.easy.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("sudoku-grid.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    @FXML
    public void switchToMedium(MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.medium.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("medium.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
    public void switchToHard(MouseEvent event) throws IOException{
        final Stage stage = (Stage)this.hard.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("hard.fxml")));
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
}