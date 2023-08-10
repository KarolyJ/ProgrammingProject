// 
// Decompiled by Procyon v0.5.36
// 

package com.example.programmingproject.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.programmingproject.gui.HelloApplication;
import com.example.programmingproject.logic.Grid;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller2
{
    @FXML
    public GridPane container;
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
    void switchToEasy(final MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.easy.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("sudoku-grid.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
    
    @FXML
    void switchToMedium(final MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.medium.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("medium.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
}
