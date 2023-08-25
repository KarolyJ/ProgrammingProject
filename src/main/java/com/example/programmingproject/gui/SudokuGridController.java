package com.example.programmingproject.gui;

import com.example.programmingproject.logic.Grid;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SudokuGridController {
    public Button backButton;
    public Pane sudoku_pane;

    public Label livesText;
    public ButtonBar buttonBar;

    private HashMap<Coordinates, SudokuTile> textFieldCoordinates = new HashMap<>();

    private final int BORDER_PADDING = 50;

    private final int BOARD_X_AND_Y = 576;

    private final Grid grid = new Grid();

    private final int[][] puzzle = grid.getReadySudoku();

    private final int[][] completePuzzle = grid.getBase();

    private int[][] outputPuzzle = new int[9][9];

    public int lives = 3;

    //initialize to load these after the scene is loaded
    //TODO implement a way to check answers
    //TODO implement a timer
    //TODO test the grid, if the shown numbers correspond to the puzzle array

    public void initialize() {
        drawGridLines(sudoku_pane);
        drawTiles(sudoku_pane);
        livesText = new Label("Lives : " + lives);
        buttonBar.getButtons().add(livesText);
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
                SudokuTile tile = new SudokuTile(i, j, value);

                styleTile(tile, x, y);

                tile.addEventHandler(KeyEvent.KEY_PRESSED, checkInput());

                //had to change i, j to j, i
                drawNumbers(tile, j, i);

                textFieldCoordinates.put(new Coordinates(i, j), tile);

                root.getChildren().add(tile);
            }
        }
    }

    private void drawNumbers(SudokuTile tile, int x, int y) {
        if (puzzle[x][y] != 0) {
            tile.setText(String.valueOf(puzzle[x][y]));
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
        final Parent root = (Parent) FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }

    public int[][] getOutputPuzzle() {
        return outputPuzzle;
    }

    private EventHandler<KeyEvent> checkInput() {

        return event -> {
//                to test inputs
            if(event.getCode() != KeyCode.BACK_SPACE) {
                if (event.getCode().getChar().equals(event.getTarget().toString())) {
                    System.out.println("Correct");
                } else {
                    lives--;
                    livesText.setText("Lives : " + lives);
                    System.out.println("Wrong");
                }
            }
        };
    }
}
