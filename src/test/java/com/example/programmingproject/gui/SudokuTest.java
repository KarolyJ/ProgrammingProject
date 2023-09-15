package com.example.programmingproject.gui;

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

}
