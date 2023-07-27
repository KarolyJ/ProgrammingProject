package com.example.programmingproject.logic;

import com.example.programmingproject.logic.Grid;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.printSudoku();
        System.out.println();
        System.out.println("////////////////");
        System.out.println();
        grid.printHiddenSudoku();
        System.out.println("////////////////");
        System.out.println(grid.checkTheAnswers());
        System.out.println("////////////////");

        System.out.println();

        Sudoku s = new Sudoku(9, 0);
        s.fillValues();
        s.printSudoku();
    }
}
