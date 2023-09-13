package com.example.programmingproject.logic;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"hour", "minute", "second"})


public class Time  {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second){

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public Time(String currentTime){
        String[] time = currentTime.split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        second = Integer.parseInt(time[2]);
    }

    @JsonProperty("time")
    public String getCurrentTime(){
        return hour + ":" + minute + ":" + second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void oneSecondPassed(){
        second++;
        if (second == 60){
            minute++;
            second = 0;
            if (minute == 0){
                hour++;
                minute = 0;
                if (hour == 24){
                    hour = 0;
                    System.out.println("That's enough for today");
                }
            }
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Time otherTime = (Time) obj;
        return this.hour == otherTime.hour &&
                this.minute == otherTime.minute &&
                this.second == otherTime.second;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
