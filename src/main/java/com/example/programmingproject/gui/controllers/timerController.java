package com.example.programmingproject.gui.controllers;

import com.example.programmingproject.objects.Time;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class timerController implements Initializable {
    Time time = new Time("00:00:00");

    private Text timer;

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
            e -> {
                time.oneSecondPassed();
                timer.setText(time.getCurrentTime());
            }));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.setText(time.getCurrentTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
