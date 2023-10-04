package com.example.programmingproject.gui.controllers;

import com.example.programmingproject.gui.holders.DifficultyHolder;
import com.example.programmingproject.gui.MainApplication;
import com.example.programmingproject.gui.holders.TimerHolder;
import com.example.programmingproject.objects.Record;
import com.example.programmingproject.objects.Time;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GameWonController {

    public Button backButton;
    public Label timeLabel;

    private static File recordsFile = new File("src/main/resources/records.json");

    public void initialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        TimerHolder timerHolder = TimerHolder.getInstance();
        DifficultyHolder difficultyHolder = DifficultyHolder.getInstance();

        //stores the difficulty in text
        String difficulty = switch (difficultyHolder.getDifficulty()) {
            case 20 -> "EASY";
            case 30 -> "MEDIUM";
            default -> "HARD";
        };

        timeLabel.setText("You solved it in : " + timerHolder.getTime().getCurrentTime() + " on " + difficulty + " difficulty");
        Time bestTime = readRecordFromJson(recordsFile, difficulty);
        Time newBestTime = compareTimes(bestTime, timerHolder.getTime());

        //gets the array from the json and replaces only that object that need to be changes and then writes the new array to the json
        if(!(newBestTime.equals(bestTime))) {
            Record [] recordArray = mapper.readValue(recordsFile , Record[].class);
            for(Record r : recordArray) {
                if(r.getLevel().equals(difficulty)) {
                    r.setTime(newBestTime.getCurrentTime());
                }
            }
            mapper.writeValue(recordsFile, recordArray);
        }
    }

    @FXML
    public void switchToMenu(final MouseEvent event) throws IOException {
        final Stage stage = (Stage) this.backButton.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    //gets the time from the json based on difficulty
    private static Time readRecordFromJson (File file, String difficulty) throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        Record [] recordArray = mapper.readValue(file , Record[].class);
        for(Record r : recordArray) {
            if(r.getLevel().equals(difficulty)) {
                return new Time(r.getTime());
            }
        }
        return null;
    }


    //returns the better time from the two inputs
    public static Time compareTimes(Time oldTime, Time newTime) {
        if (!(oldTime.equals(new Time(0, 0, 0)))) {
            if (oldTime.getHour() == newTime.getHour()) {
                if (oldTime.getMinute() > newTime.getMinute()) {
                    return newTime;
                } else if (oldTime.getMinute() == newTime.getMinute()) {
                    if (oldTime.getSecond() > newTime.getSecond()) {
                        return newTime;
                    } else {
                        return oldTime;
                    }
                } else {
                    return oldTime;
                }
            } else if (oldTime.getHour() > newTime.getHour()) {
                return newTime;
            } else {
                return oldTime;
            }
        } else return newTime;
    }
}
