package com.example.programmingproject.gui;

public class Generic2DArray <T>{

    private Object[][] data;

    public Generic2DArray(int rows, int cols) {
        data = new Object[rows][cols];
    }

    public void setElement(int row, int col, T element) {
        data[row][col] = element;
    }

    public T getElement(int row, int col) {
        return (T) data[row][col];
    }

}
