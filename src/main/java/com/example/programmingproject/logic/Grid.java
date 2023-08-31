package com.example.programmingproject.logic;
//This suggests that the minimum number of clues to provide in a grid is 17.

import java.io.Serializable;
import java.util.Arrays;

public class Grid implements Serializable {
    private final int[][] base;
    private Coin coinSystem;
    SudokuGenerator sudoku = new SudokuGenerator(9);

    private int[][] readySudoku;

    public Grid() {
        sudoku.fillValues();
        base = sudoku.mat;
        coinSystem = new Coin();
    }

    private final int MIN_LEVEL = 20; // the amount of hidden numbers
    private final int MID_LEVEL = 30;
    private final int MAX_LEVEL = 40;
    private int levelOfTheGame; //the level of difficulty

    public int getLevelOfTheGame() {
        return levelOfTheGame;
    }

    public void setLevelOfTheGame(int levelOfTheGame) {
        this.levelOfTheGame = levelOfTheGame;
    }

    public int[][] getBase() {
        return base;
    }

    public int[][] getReadySudoku(){
        setReadySudoku();
        return readySudoku;
    }

    public Coin getCoinSystem() {
        return coinSystem;
    }

    public  void setReadySudoku(){
        // Create a deep copy of the base array for readySudoku
        readySudoku = new int[base.length][base[0].length];
        for (int i = 0; i < base.length; i++) {
            readySudoku[i] = Arrays.copyOf(base[i], base[i].length);
        }

        this.hideSudoku();
    }

    public boolean checkTheAnswers(){
        if (base.length != readySudoku.length || base[0].length != readySudoku[0].length)
            return false;

        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < base[0].length; j++) {
                if (base[i][j] != readySudoku[i][j])
                    return false;
            }
        }

        return true;
    }

    public void printSudoku(){
        for (int[] ints : getBase()) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    int randomGenerator()
    {
        return (int) Math.floor((Math.random()* 81 +1));
    }
    public void hideSudoku(){
        int count = getLevelOfTheGame();
        while (count != 0)
        {
            int cellId = randomGenerator()-1;

            // System.out.println(cellId);
            // extract coordinates i  and j
            int i = (cellId/9);
            int j = cellId%9;
            if (j != 0)
                j = j - 1;

            // System.out.println(i+" "+j);
            if (readySudoku[i][j] != 0)
            {
                count--;
                readySudoku[i][j] = 0;
            }
        }
    }
    public void printHiddenSudoku(){
        for (int[] ints : getReadySudoku()) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
