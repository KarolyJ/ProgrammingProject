package com.example.programmingproject.gui.exceptions;

import com.example.programmingproject.gui.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LostGameException extends Exception{

    public LostGameException(String s, Stage stage) throws IOException {
        super(s);
        System.out.println("ZERO LIVES");

        final Parent root = (Parent) FXMLLoader.load(HelloApplication.class.getResource("gameover.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

}
