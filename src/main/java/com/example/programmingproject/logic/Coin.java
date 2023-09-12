package com.example.programmingproject.logic;

import java.io.*;

public class Coin implements Serializable {
    private int balance;

    public Coin() {
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


}