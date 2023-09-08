package com.example.programmingproject.gui;

//for the better way to store tiles, so we know exactly where they are

public class Coordinates {

    private final int x;

    private final int y;



    public Coordinates(int x, int  y) {
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
