package com.example.programmingproject.gui;

import javafx.scene.control.TextField;

public class SudokuTile extends TextField {



    private final int x;
    private final int y;

    public SudokuTile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
