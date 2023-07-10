package com.example.programmingproject;

public class Grid {
    int[][] base = new int[][]{
            {2, 3, 9, 4, 1, 5, 7, 6, 8},
            {7, 8, 4, 2, 3, 6, 5, 1, 9},
            {1, 6, 5, 9, 8, 7, 2, 3, 4},
            {3, 1, 7, 6, 9, 4, 8, 2, 5},
            {4, 5, 8, 1, 2, 3, 6, 9, 7},
            {9, 2, 6, 7, 5, 8, 3, 4, 1},
            {8, 4, 3, 5, 6, 9, 1, 7, 2},
            {6, 7, 1, 8, 4, 2, 9, 5, 3},
            {5, 9, 2, 3, 7, 1, 4, 8, 6}};

    private int MIN_LEVEL = 20; // the amount of hidden numbers
    private int MID_LEVEL = 30;
    private int MAX_LEVEL = 40;
    private int levelOfTheGame; //the level of difficulty

    public int[][] getBase() {
        return base;
    }

    public void setBase(int[][] base) {
        this.base = base;
    }

    public void chooseTheDifficulty(){
        //TODO when the player chose the difficulty should be set the levelOfTheGame
    }

    public void checkTheAnswers(){
        //TODO create a button which check the answers
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
    public void printHiddenSudoku(){
        int count = 20; //TODO change it to the levelOfTheGame
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
            if (base[i][j] != 0)
            {
                count--;
                base[i][j] = 0;
            }
        }

        for (int[] ints : getBase()) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
