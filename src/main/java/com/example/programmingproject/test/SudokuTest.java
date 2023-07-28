package com.example.programmingproject.test;

import com.example.programmingproject.logic.Grid;
import org.junit.Test;

import static org.junit.Assert.*;
public class SudokuTest {

    public static int countZeros(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            for (int num : row) {
                if (num == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    @Test
    public void testCountZeros() {
        int[][] array = {
                {1, 0, 0},
                {0, 5, 0},
                {8, 0, 2}
        };

        int expectedZeros = 5; // The expected number of zeros in the array
        int actualZeros = SudokuTest.countZeros(array);

        // Assert that the actual number of zeros matches the expected number
        assertEquals(expectedZeros, actualZeros);
    }
    @Test
    public void testRemoveKDigitsWith20() {
        Grid grid = new Grid();
        grid.setLevelOfTheGame(20);
        grid.hideSudoku();
        int[][] array = grid.getBase();
        int expectedZeros = grid.getLevelOfTheGame(); // The expected number of zeros in the array
        int actualZeros = SudokuTest.countZeros(array);

        // Assert that the actual number of zeros matches the expected number
        assertEquals(expectedZeros, actualZeros);
    }
    @Test
    public void testRemoveKDigitsWith30() {
        Grid grid = new Grid();
        grid.setLevelOfTheGame(30);
        grid.hideSudoku();
        int[][] array = grid.getBase();
        int expectedZeros = grid.getLevelOfTheGame(); // The expected number of zeros in the array
        int actualZeros = SudokuTest.countZeros(array);

        // Assert that the actual number of zeros matches the expected number
        assertEquals(expectedZeros, actualZeros);
    }
    @Test
    public void testRemoveKDigitsWith40() {
        Grid grid = new Grid();
        grid.setLevelOfTheGame(40);
        grid.hideSudoku();
        int[][] array = grid.getBase();
        int expectedZeros = grid.getLevelOfTheGame(); // The expected number of zeros in the array
        int actualZeros = SudokuTest.countZeros(array);

        // Assert that the actual number of zeros matches the expected number
        assertEquals(expectedZeros, actualZeros);
    }
}
