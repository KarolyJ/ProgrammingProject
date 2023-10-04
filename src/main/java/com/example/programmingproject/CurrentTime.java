package com.example.programmingproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//to get the current time

public class CurrentTime {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:MM:SS");
    LocalDateTime now = LocalDateTime.now();

    public CurrentTime(){

    }

    public String currentTime(){
        return dtf.format(now);
    }
}
