package com.example.programmingproject.gui.controllers;

import java.io.IOException;
import java.util.Objects;

import com.example.programmingproject.gui.MainApplication;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
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

    //changing mode objects
    @FXML
    private Button btnMode;
    @FXML
    private boolean isLightMode = true;
    @FXML
    private ImageView imgMode;
    @FXML
    private AnchorPane root;
    @FXML
    private Label label;



    @FXML
    public void switchToGame(MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.newGame.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("newgame.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    public void switchToSettings(MouseEvent event) throws IOException{
        final Stage stage = (Stage)this.settings.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("settings.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
    public void switchToRules(MouseEvent event) throws IOException{
        final Stage stage = (Stage)this.rules.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("rules.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    public void switchToRanking(MouseEvent event) throws IOException {
        final Stage stage = (Stage) this.ranking.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("records.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    public void switchToMenuBack(MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.back.getScene().getWindow();
        final Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("menu.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }




    //changing modes methods
    public void changeMode(ActionEvent event){
        isLightMode = !isLightMode;
        if(isLightMode){
            setLightMode();
        } else {
            setDarkMode();
        }
    }

    private void setLightMode(){
        root.getStylesheets().remove("com/example/programmingproject/gui/styles/darkmode.css");
        root.getStylesheets().add("com/example/programmingproject/gui/styles/lightmode.css");
        Image image = new Image("com/example/programmingproject/gui/img/lightmode.png");
        imgMode.setImage(image);
    }
    private void setDarkMode(){
        root.getStylesheets().remove("com/example/programmingproject/gui/styles/lightmode.css");
        root.getStylesheets().add("com/example/programmingproject/gui/styles/darkmode.css");
        Image image = new Image("com/example/programmingproject/gui/img/darkmode.png");
        imgMode.setImage(image);
    }
}