package com.example.programmingproject.gui.holders;

import com.example.programmingproject.logic.Time;

public final class TimerHolder {

    //we created a singleton class to store time


    private Time time;

    private final static TimerHolder INSTANCE = new TimerHolder();

    private TimerHolder() {}

    public static TimerHolder getInstance() {
        return INSTANCE;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }
}
