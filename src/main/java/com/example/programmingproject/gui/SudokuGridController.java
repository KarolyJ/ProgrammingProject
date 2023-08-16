package com.example.programmingproject.gui;

import com.example.programmingproject.logic.Grid;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SudokuGridController <T> {
    public GridPane container;
    public Button backButton;
    public Pane sudoku_pane;

    private HashMap<Coordinates, SudokuTile> textFieldCoordinates = new HashMap<>();

    private final int BORDER_PADDING = 50;

    private final int BOARD_X_AND_Y = 576;

    //initialize to load these after the scene is loaded
    //TODO make it look better
    //TODO implement a way to check answers
    //TODO implement a timer
    public void initialize() {
        Grid grid = new Grid();
        int [][] puzzle = grid.getReadySudoku();
        //used generic type of array so both TextField and Text can be stored in one array
        Generic2DArray cells = new Generic2DArray<>(9, 9);
        //System.out.println(Arrays.deepToString(puzzle));

//        for(int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if(puzzle[i][j] == 0) {
//                    TextField field = new TextField();
//                    cells.setElement(i, j, field);
//                    container.add(field, i, j);
//                } else {
//                    Text text = new Text(String.valueOf(puzzle[i][j]));
//                    cells.setElement(i, j , text);
//                    container.add(text, i, j);
//                }
//            }
//        }
        //to see what types are stored in the generic array
//        for(int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.println(cells.getElement(i, j));
//            }
//        }

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

        for(int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                int x = X_PADDING + i * TILE_X_AND_Y;
                int y = Y_PADDING + j * TILE_X_AND_Y;

                SudokuTile tile = new SudokuTile(i, j);

                styleTile(tile, x, y);

                textFieldCoordinates.put(new Coordinates(i, j), tile);

                boardNumbers(tile, i, j);

                root.getChildren().add(tile);
            }
        }
    }

    private void boardNumbers(SudokuTile tile, int x, int y){
        Grid grid = new Grid();
        int [][] puzzle = grid.getReadySudoku();
        if(puzzle[x][y] != 0) {
            System.out.println(puzzle[x][y]);
            tile.setText(String.valueOf(puzzle[x][y]));
        }


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
        final Stage stage = (Stage)this.backButton.getScene().getWindow();
        final Parent root = (Parent) FXMLLoader.load(HelloApplication.class.getResource("menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("The Fancy Sudoku!");
    }
}
