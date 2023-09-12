package com.example.programmingproject.logic;

import java.io.*;

public class CoinManager {
    public static void saveCoinData(Coin coinData, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(coinData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Coin loadCoinData(String fileName) {
        Coin coinData = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            coinData = (Coin) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coinData;
    }

    public static void earnMoreCoins(Coin coinData, int amount) {
        coinData.earnCoins(amount);
    }
}
