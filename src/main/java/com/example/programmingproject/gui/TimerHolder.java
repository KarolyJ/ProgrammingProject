package com.example.programmingproject.gui;

import com.example.programmingproject.logic.Time;

public final class TimerHolder {

    private String time;

    private final static TimerHolder INSTANCE = new TimerHolder();

    private TimerHolder() {}

    public static TimerHolder getInstance() {
        return INSTANCE;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
