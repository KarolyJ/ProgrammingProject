package com.example.programmingproject.gui.controllers;

import com.example.programmingproject.gui.MainApplication;
import com.example.programmingproject.objects.Record;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class RecordsController {
    public Label easyLabel;
    public Label mediumLabel;
    public Label hardLabel;

    public Button backButton;
    @FXML
    private boolean isLightMode = true;
    @FXML
    private ImageView imgMode;
    @FXML
    private AnchorPane root;

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
    public void switchToMenu(ActionEvent event) throws IOException {
        final Stage stage = (Stage) this.backButton.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
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
