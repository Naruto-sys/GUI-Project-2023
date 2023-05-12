package com.example.sapper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class MediumLevelController {
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
        LevelMap = field.CreateField(Difficulty.MEDIUM);
        field.PaintLevel(LevelGridPane, Difficulty.MEDIUM, field, LevelMap);
    }
}
