package com.example.programmingproject.gui;

import com.example.programmingproject.logic.Grid;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Arrays;

public class SudokuGridController <T> {
    public GridPane container;

    //initialize to load these after the scene is loaded
    //TODO make it look better
    //TODO implement a way to check answers
    //TODO implement a timer
    public void initialize() {
        Grid grid = new Grid();
        int [][] puzzle = grid.getReadySudoku();
        //used generic type of array so both TextField and Text can be stored in one array
        Generic2DArray cells = new Generic2DArray<>(9, 9);
        //System.out.println(Arrays.deepToString(puzzle));

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(puzzle[i][j] == 0) {
                    TextField field = new TextField();
                    cells.setElement(i, j, field);
                    container.add(field, i, j);
                } else {
                    Text text = new Text(String.valueOf(puzzle[i][j]));
                    cells.setElement(i, j , text);
                    container.add(text, i, j);
                }
            }
        }
        //to see what types are stored in the generic array
//        for(int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.println(cells.getElement(i, j));
//            }
//        }


    }


}
