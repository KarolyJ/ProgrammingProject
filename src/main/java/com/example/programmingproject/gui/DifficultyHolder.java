package com.example.programmingproject.gui;

public final class DifficultyHolder {

    //we created a singleton class to store difficulty

    private int difficulty;

    private final static DifficultyHolder INSTANCE = new DifficultyHolder();

    private DifficultyHolder() {}

    public static DifficultyHolder getInstance() {
        return INSTANCE;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
