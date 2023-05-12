package com.example.sapper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class HardLevelController {
    @FXML
    public Label LevelTimerLabel;
    @FXML
    public Label LevelFlagsLabel;
    @FXML
    public GridPane LevelGridPane;
    private Field field = new Field();

    private List<ArrayList<Integer>> LevelMap;

    @FXML
    public void initialize() {
        LevelMap = field.CreateField(Difficulty.HARD);
        field.PaintLevel(LevelGridPane, Difficulty.HARD, field, LevelMap);
    }
}
