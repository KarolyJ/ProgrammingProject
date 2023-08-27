package com.example.programmingproject.gui.exceptions;

import com.example.programmingproject.gui.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WonGameException extends Exception{

    public WonGameException(String s, Stage stage) throws IOException {

        final Parent root = (Parent) FXMLLoader.load(HelloApplication.class.getResource("gamewon.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
}
