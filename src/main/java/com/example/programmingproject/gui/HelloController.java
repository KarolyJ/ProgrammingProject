// 
// Decompiled by Procyon v0.5.36
// 

package com.example.programmingproject.gui;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController
{
    @FXML
    private Button button1;
    
    @FXML
    void switchToMenu(final MouseEvent event) throws IOException {
        final Stage stage = (Stage)this.button1.getScene().getWindow();
        final Parent root = (Parent)FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
}
