package com.example.programmingproject.logic;
//This suggests that the minimum number of clues to provide in a grid is 17.

import java.util.Arrays;

public class Grid {
    private final int[][] base = new int[][]{
            {2, 3, 9, 4, 1, 5, 7, 6, 8},
            {7, 8, 4, 2, 3, 6, 5, 1, 9},
            {1, 6, 5, 9, 8, 7, 2, 3, 4},
            {3, 1, 7, 6, 9, 4, 8, 2, 5},
            {4, 5, 8, 1, 2, 3, 6, 9, 7},
            {9, 2, 6, 7, 5, 8, 3, 4, 1},
            {8, 4, 3, 5, 6, 9, 1, 7, 2},
            {6, 7, 1, 8, 4, 2, 9, 5, 3},
            {5, 9, 2, 3, 7, 1, 4, 8, 6}};

    //TODO merge it with the class Sudoku

    private int[][] readySudoku;

    public Grid() {
        //setReadySudoku();
        setLevelOfTheGame(MIN_LEVEL); //TODO change for later
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

    public  void setReadySudoku(){
        // Create a deep copy of the base array for readySudoku
        readySudoku = new int[base.length][base[0].length];
        for (int i = 0; i < base.length; i++) {
            readySudoku[i] = Arrays.copyOf(base[i], base[i].length);
        }

        this.hideSudoku();
    }

    public boolean checkTheAnswers(){
        //TODO create a button which check the answers
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
