package com.example.programmingproject.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Coin implements Serializable {
    private int balance;

    public Coin() {
        balance = 100;
    }

    public void earnCoins(int amount) {
        balance += amount;
    }

    public boolean spendCoins(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public int getBalanceSystem(){
        int balance = 0;
        // Loading
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("savedBalance.ser"))) {
            Coin loadedCoinData = (Coin) inputStream.readObject();
            balance = loadedCoinData.getBalance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return balance;
    }
}