package com.example.programmingproject.gui.controllers;

import java.io.File;
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
    private Button back; //for rules.fxml

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

    //for rules.fxml
    public void switchToMenuBack(ActionEvent event) throws IOException {
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
        root.getStylesheets().remove(new File("C:\\Users\\39338\\ProgrammingProject\\src\\main\\resources\\com\\example\\programmingproject\\gui\\darkmode.css").toURI().toString());
        root.getStylesheets().add(new File("C:\\Users\\39338\\ProgrammingProject\\src\\main\\resources\\com\\example\\programmingproject\\gui\\lightmode.css").toURI().toString());
        Image image = new Image(new File("C:\\Users\\39338\\ProgrammingProject\\src\\main\\resources\\com\\example\\programmingproject\\gui\\lightmode.png").toURI().toString());
        imgMode.setImage(image);
    }
    private void setDarkMode(){
        root.getStylesheets().remove(new File("C:\\Users\\39338\\ProgrammingProject\\src\\main\\resources\\com\\example\\programmingproject\\gui\\lightmode.css").toURI().toString());
        root.getStylesheets().add(new File("C:\\Users\\39338\\ProgrammingProject\\src\\main\\resources\\com\\example\\programmingproject\\gui\\darkmode.css").toURI().toString());
        Image image = new Image(new File("C:\\Users\\39338\\ProgrammingProject\\src\\main\\resources\\com\\example\\programmingproject\\gui\\darkmode.jpg").toURI().toString());
        imgMode.setImage(image);
    }
}