package com.example.sapper;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {

    private List<ArrayList<Integer>> levelMap;
    private boolean FirstTimeClicked = true;
    private int bombCount = 0;
    private List<ArrayList<Integer>> ClickedMap = new ArrayList<>();

    List<Integer> GetFieldByDifficult(Difficulty difficulty) {
        int BombCount = 0;
        int HSize = 0;
        int VSize = 0;
        List<Integer> res = new ArrayList<>();
        if (difficulty.equals(Difficulty.EASY)) {
            HSize = 8;
            VSize = 8;
            BombCount = 10;
        } else if (difficulty.equals(Difficulty.MEDIUM)) {
            HSize = 16;
            VSize = 16;
            BombCount = 20;
        } else if (difficulty.equals(Difficulty.HARD)) {
            HSize = 30;
            VSize = 16;
            BombCount = 40;
        }
        res.add(HSize);
        res.add(VSize);
        res.add(BombCount);
        bombCount = BombCount;
        return res;
    }

    List<ArrayList<Integer>> CreateField(Difficulty difficulty) {
        List<ArrayList<Integer>> LevelMap = new ArrayList<>();
        List<Integer> Params = GetFieldByDifficult(difficulty);
        int VSize = Params.get(0);
        int HSize = Params.get(1);
        ClickedMap.clear();
        for (int i = 0; i < VSize; i++) { // Пустой 2-мерный массив
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < HSize; j++) {
                list.add(0);
            }
            LevelMap.add(list);
            ClickedMap.add(list);
        }
        FirstTimeClicked = true;
        levelMap = LevelMap;
        return LevelMap;
    }

    public void FillLevelMap(int ClickedX, int ClickedY) {
        int VSize = levelMap.size();
        int HSize = levelMap.get(0).size();
        int BombAdded = 0;
        int x, y;
        while (BombAdded < bombCount) { // Генерим в случайных ячейках бомбы
            x = RandomInt(VSize - 1);
            y = RandomInt(HSize - 1);
            if (levelMap.get(x).get(y) != -1 && !(x == ClickedX && y == ClickedY)) {
                BombAdded++;
                levelMap.get(x).set(y, -1);
            }
        }
        for (int i = 0; i < VSize; i++) { // Ставим в каждой ячейке нужное число
            for (int j = 0; j < HSize; j++) {
                if (levelMap.get(i).get(j) == -1) {
                    continue;
                }
                int count = 0;
                for (int i1 = i - 1; i1 <= i + 1; i1++) {
                    for (int j1 = j - 1; j1 <= j + 1; j1++) {
                        if (0 <= i1 && i1 < VSize && 0 <= j1 && j1 < HSize && (i1 != i || j1 != j)) {
                            if (levelMap.get(i1).get(j1) == -1) {
                                count++;
                            }
                        }
                    }
                }
                levelMap.get(i).set(j, count);
            }
        }
    }

    public void PaintLevel(GridPane pane, Difficulty difficulty, Field field, List<ArrayList<Integer>> LevelMap) {
        LevelMap = field.CreateField(difficulty);
        Button button;
        for (int i = 0; i < LevelMap.size(); i++) {
            for (int j = 0; j < LevelMap.get(0).size(); j++) {
                button = new Button();
                button.setPrefSize(28, 28);
                pane.add(button, i, j);
                int finalI = i;
                int finalJ = j;
                button.setOnMouseClicked(mouseEvent -> MapButtonClicked(finalI, finalJ, pane));
            }
        }
    }

    public void MapButtonClicked(int i, int j, GridPane pane) {
        Button button = new Button();
        button.setPrefSize(28, 28);
        if (FirstTimeClicked) {
            FillLevelMap(i, j);
            FirstTimeClicked = false;
        }
        button.setText(levelMap.get(i).get(j) + "");
        if (levelMap.get(i).get(j) == -1) { // нажали на мину, надо бы проиграть
            ClickedMap.get(i).set(j, 1);
            pane.add(button, i, j);
        } else { // нажали не на мину
            ZeroClicked(i, j, pane);
            ClickedMap.get(i).set(j, 1);
            pane.add(button, i, j);
        }
    }

    public void ZeroClicked(int i, int j, GridPane pane) {
        int VSize = levelMap.size();
        int HSize = levelMap.get(0).size();
        if (i >= VSize || i < 0 || j >= HSize || j < 0) { return; }
        if (levelMap.get(i).get(j) != 0) { return; }
        if (ClickedMap.get(i).get(j) != 0) { return; }
        Button button = new Button("0");
        button.setPrefSize(28, 28);
        pane.add(button, i, j);
        ClickedMap.get(i).set(j, 1);
        ZeroClicked(i - 1, j, pane);
        ZeroClicked(i, j - 1, pane);
        ZeroClicked(i + 1, j, pane);
        ZeroClicked(i, j + 1, pane);
    }

    public static int RandomInt(int max) {
        return (int) (Math.random() * ++max);
    }
}
