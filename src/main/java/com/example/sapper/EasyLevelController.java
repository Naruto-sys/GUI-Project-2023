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
    private int k = 0;
    private int k1 = 0;
    private int k2 = 0;


    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if (k < 100){
                LevelTimerLabel.setText(String.valueOf(k2) + ":" + String.valueOf(k1) + ":" + String.valueOf(k));
                k+=1;
            } else if (k == 100) {
                k1 += 1;
                if (k1 < 10) {
                    LevelTimerLabel.setText(String.valueOf(k2) + ":" + String.valueOf(k1) + ":00");
                } else if (k1 < 60) {
                    LevelTimerLabel.setText(String.valueOf(k2) + ":" + String.valueOf(k1) + ":00");
                } else {
                    k2 += 1;
                    LevelTimerLabel.setText("0" + String.valueOf(k2) + ":00:00");
                    k1 = 0;
                }
                k = 0;
            }


        }
    };


    @FXML
    public void initialize() {
        LevelMap = field.CreateField(Difficulty.EASY);
        field.PaintLevel(LevelGridPane, Difficulty.EASY, field, LevelMap, LevelFlagsLabel);
        animationTimer.start();
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
