package com.example.sapper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EasyLevelController {
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
        LevelMap = field.CreateField(Difficulty.EASY);
        field.PaintLevel(LevelGridPane, Difficulty.EASY, field, LevelMap);
    }

    public void BackToDifficultyChangeMenuButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked back");
        Parent root = FXMLLoader.load(getClass().getResource("ChooseDifficultyMenu.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
