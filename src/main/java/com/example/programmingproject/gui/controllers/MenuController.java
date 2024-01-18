package com.example.programmingproject.gui.controllers;

import java.io.IOException;
import java.util.Objects;
import com.example.programmingproject.gui.MainApplication;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private Button btnLight;
    private boolean isLightMode = true; // changing mode condition
    private ImageView imageView;
    private AnchorPane anchorPane;


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
        }else{
            setDarkMode();
        }
    }

    private void setLightMode(){
       anchorPane.getStylesheets().remove("styles/darkmode.css");
       anchorPane.getStylesheets().add("styles/lightmode.css");
       Image image = new Image("img/lightmode.png");
       imageView.setImage(image);
    }
    private void setDarkMode(){
        anchorPane.getStylesheets().remove("styles/lightmode.css");
        anchorPane.getStylesheets().add("styles/darkmode.css");
        Image image = new Image("img/darkmode.png");
        imageView.setImage(image);
    }

}