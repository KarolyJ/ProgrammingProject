package com.example.programmingproject.gui.controllers;

import com.example.programmingproject.gui.*;
import com.example.programmingproject.gui.holders.DifficultyHolder;
import com.example.programmingproject.gui.holders.TimerHolder;
import com.example.programmingproject.objects.Grid;
import com.example.programmingproject.objects.SudokuTile;
import com.example.programmingproject.objects.Time;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SudokuGridController {

    public Button backButton;
    public Pane sudoku_pane;
    public Label livesText;
    public Label balanceLabel;
    public ButtonBar buttonBar;
    public Text timer;
    Time time = new Time("00:00:00");

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                        time.oneSecondPassed();
                        timer.setText(time.getCurrentTime());
                    }));


    private final int BORDER_PADDING = 50;

    private final int BOARD_X_AND_Y = 576;

    private final Grid grid = new Grid();

    private final int[][] puzzle = grid.getReadySudoku();

    private final int[][] completePuzzle = grid.getBase();

    private int[][] outputPuzzle = new int[9][9];

    public int lives = 3;

    private int hiddenNumbers;

    private int countCorrectGuesses = 0;

    private String balance;


    //initialize to load these after the scene is loaded
    public void initialize() {

        livesText = new Label("Lives : " + lives);
        livesText.setStyle("-fx-border-color: black;" +
                "-fx-border-radius: 30; " +
                "-fx-alignment: center; ");

        //we read the balance stored in a txt file
        try {
            balance = new String(Files.readAllBytes(Paths.get("src/main/resources/balance.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        balanceLabel = new Label("Balance: " + balance);
        balanceLabel.setStyle("-fx-border-color: black;" +
                        "-fx-border-radius: 30; " +
                        "-fx-alignment: center;");


        buttonBar.getButtons().addAll(livesText, balanceLabel);

        //setting timer
        timer.setText(time.getCurrentTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        //we access the information stored  in the singleton class
        DifficultyHolder holder = DifficultyHolder.getInstance();
        grid.setLevelOfTheGame(holder.getDifficulty());
        hiddenNumbers = holder.getDifficulty();
        grid.hideSudoku();
        grid.printSudoku();
        drawGridLines(sudoku_pane);
        drawTiles(sudoku_pane);
    }

    private void drawGridLines(Pane root) {
        int xAndY = 114;
        int i = 0;
        while (i < 8) {
            int thickness;
            if (i == 2 || i == 5)
                thickness = 3;
            else thickness = 2;

            Rectangle verticalLine = getLine(
                    xAndY + 64 * i,
                    BORDER_PADDING,
                    BOARD_X_AND_Y,
                    thickness
            );

            Rectangle horizontalLine = getLine(
                    BORDER_PADDING,
                    xAndY + 64 * i,
                    thickness,
                    BOARD_X_AND_Y
            );

            root.getChildren().addAll(verticalLine, horizontalLine);
            i++;
        }
    }

    private void drawTiles(Pane root) {
        final int X_PADDING = 50;
        final int Y_PADDING = 50;
        final int TILE_X_AND_Y = 64;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int x = X_PADDING + i * TILE_X_AND_Y;
                int y = Y_PADDING + j * TILE_X_AND_Y;
                int value = completePuzzle[j][i];

                //the completed puzzle is saved as the value of the SudokuTile object, so the object contains solution
                SudokuTile tile = new SudokuTile(j, i, value);

                styleTile(tile, x, y);

                tile.addEventHandler(KeyEvent.KEY_PRESSED, checkInput());

                // strips out non-numeric characters if pasted
                tile.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*")) {
                        tile.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });

                //Allow only one letter to be typed
                tile.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
                    String newText = change.getControlNewText();
                    if (newText.length() > 1) {
                        return null ;
                    } else {
                        return change ;
                    }
                }));

                //had to change i, j to j, i
                drawNumbers(tile, j, i);

                root.getChildren().add(tile);
            }
        }
    }

    private void drawNumbers(SudokuTile tile, int x, int y) {
        if (puzzle[x][y] != 0) {
            tile.setText(String.valueOf(puzzle[x][y]));
            tile.setEditable(false);
        }
        //use outputPuzzle for testing
        outputPuzzle[x][y] = puzzle[x][y];
    }

    private void styleTile(SudokuTile tile, int x, int y) {
        tile.setPrefSize(64, 64);
        tile.setLayoutX(x);
        tile.setLayoutY(y);
        tile.setAlignment(Pos.CENTER);
        tile.setBackground(Background.EMPTY);

    }

    private Rectangle getLine(double x, double y, double height, double width) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(height);
        rectangle.setWidth(width);
        rectangle.setFill(Color.BLACK);


        return rectangle;
    }

    @FXML
    public void switchToMenu(final MouseEvent event) throws IOException {
        final Stage stage = (Stage) this.backButton.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
    private EventHandler<KeyEvent> checkInput() {

        //creating an array with the allowed keycodes, so we can control the input
        ArrayList<KeyCode> keyCodeArrayList = new ArrayList<>();
        keyCodeArrayList.add(KeyCode.DIGIT1);
        keyCodeArrayList.add(KeyCode.DIGIT2);
        keyCodeArrayList.add(KeyCode.DIGIT3);
        keyCodeArrayList.add(KeyCode.DIGIT4);
        keyCodeArrayList.add(KeyCode.DIGIT5);
        keyCodeArrayList.add(KeyCode.DIGIT6);
        keyCodeArrayList.add(KeyCode.DIGIT7);
        keyCodeArrayList.add(KeyCode.DIGIT8);
        keyCodeArrayList.add(KeyCode.DIGIT9);


        return event -> {
//                 to test inputs
            TextField eventSource = (TextField) event.getSource();
            if(keyCodeArrayList.contains(event.getCode())) {

                if (countCorrectGuesses + 1 == hiddenNumbers) {
                    TimerHolder holder = TimerHolder.getInstance();
                    holder.setTime(new Time(time.getCurrentTime()));
                    final Stage stage = (Stage) this.backButton.getScene().getWindow();
                    final Parent root;
                    try {
                        root = (Parent) FXMLLoader.load(MainApplication.class.getResource("gamewon.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage.setScene(new Scene(root));
                    stage.setTitle("The Fancy Sudoku!");
                } else {
                    if (event.getCode().getChar().equals(event.getTarget().toString())) {

                        //increase count if it reaches the numbers of hiddenNumbers the game is won
                        countCorrectGuesses++;

                        //set the text field/input a permanent part of the game if the answer is correct
                        eventSource.setText(event.getCode().getChar());
                        eventSource.setStyle(null);
                        eventSource.setEditable(false);


                        //increase balance by 5 for every good guess
                        balance = String.valueOf(Integer.parseInt(balance)+5);
                        try {
                            Files.writeString(Paths.get("balance.txt"), balance);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        balanceLabel.setText("Balance:" + balance);

                    } else {
                        //if the game is lost, change to another window
                        if (lives < 2) {
                            final Stage stage = (Stage) this.backButton.getScene().getWindow();
                            final Parent root;
                            try {
                                root = (Parent) FXMLLoader.load(MainApplication.class.getResource("gameover.fxml"));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            stage.setScene(new Scene(root));
                            stage.setTitle("The Fancy Sudoku!");
                        }
                        //lose a life if the input is wrong
                        lives--;
                        livesText.setText("Lives : " + lives);
                        eventSource.setStyle("-fx-control-inner-background: #e0827b");

                    }
                }
            }
        };
    }


    //purchase a life only if the balance is positive
    public void addLife(MouseEvent mouseEvent) {
        if(Integer.parseInt(balance) > 0) {
            if ((Integer.parseInt(balance) - 20) > 0) {
                balance = String.valueOf(Integer.parseInt(balance) - 20);
                try {
                    Files.writeString(Paths.get("balance.txt"), balance);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                balanceLabel.setText("Balance:" + balance);
                lives++;
                livesText.setText("Lives : " + lives);
            }
        }
    }
}
