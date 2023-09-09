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

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("savedBalance.ser"))) {
            outputStream.writeObject(game.getCoinSystem());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("savedBalance.ser"))) {
            Coin loadedCoinData = (Coin) inputStream.readObject();
            int loadedBalance = loadedCoinData.getBalance();
            System.out.println("Loaded balance: " + loadedBalance);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Saved file location: " + new File("savedGame.ser").getAbsolutePath());
    }
}
