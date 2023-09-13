package com.example.programmingproject.gui.controllers;

import com.example.programmingproject.gui.holders.DifficultyHolder;
import com.example.programmingproject.gui.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class NewGameController {
    public Button backButton;
    public Button easyGameButton;
    public Button mediumGameButton;
    public Button hardGameButton;

    @FXML
    public void switchToMenu(final MouseEvent event) throws IOException {
        final Stage stage = (Stage) this.backButton.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    public void switchToEasyGame(MouseEvent event) throws IOException {
        int easy = 20;
        loadScene(event, easy);
    }

    public void switchToMediumGame(MouseEvent event) throws IOException {
        int medium = 30;
        loadScene(event, medium);
    }

    public void switchToHardGame(MouseEvent event) throws IOException {
        int hard = 40;
        loadScene(event, hard);
    }

    private void loadScene(MouseEvent event, int difficulty) throws IOException {
        DifficultyHolder holder = DifficultyHolder.getInstance();
        holder.setDifficulty(difficulty);
        Node node = (Node) event.getSource();
        final Stage stage = (Stage) node.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(HelloApplication.class.getResource("sudoku-grid.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }


}
