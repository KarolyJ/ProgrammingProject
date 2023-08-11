package com.example.programmingproject.logic;

import java.io.*;

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

        Grid game = new Grid();

        // Simulate earning and spending coins
        game.getCoinSystem().earnCoins(50);
        if (game.getCoinSystem().spendCoins(30)) {
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Not enough coins!");
        }

        // Serialize and save the game
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("savedGame.ser"));
            out.writeObject(game);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the game
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("savedGame.ser"));
            Grid loadedGame = (Grid) in.readObject();
            in.close();

            // Access coin balance in loadedGame.getCoinSystem().getBalance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Saved file location: " + new File("savedGame.ser").getAbsolutePath());
    }
}
