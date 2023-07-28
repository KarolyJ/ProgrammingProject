package com.example.programmingproject.logic;

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
    }
}
