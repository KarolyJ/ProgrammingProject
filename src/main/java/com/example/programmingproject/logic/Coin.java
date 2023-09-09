package com.example.programmingproject.logic;

import java.io.Serializable;

class Coin implements Serializable {
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
}