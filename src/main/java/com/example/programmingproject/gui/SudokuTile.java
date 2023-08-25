package com.example.programmingproject.gui;

import javafx.scene.control.TextField;

public class SudokuTile extends TextField {



    private final int x;
    private final int y;

    private final int value;

    public SudokuTile(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
