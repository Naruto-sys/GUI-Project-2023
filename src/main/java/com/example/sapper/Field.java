package com.example.sapper;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
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
        return res;
    }

    List<ArrayList<Integer>> CreateField(Difficulty difficulty) {
        List<ArrayList<Integer>> LevelMap = new ArrayList<>();
        List<Integer> Params = GetFieldByDifficult(difficulty);
        int VSize = Params.get(0);
        int HSize = Params.get(1);
        int BombCount = Params.get(2);


        for (int i = 0; i < VSize; i++) { // Пустой 2-мерный массив
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < HSize; j++) {
                list.add(0);
            }
            LevelMap.add(list);
        }

        int BombAdded = 0;
        int x, y;
        while (BombAdded < BombCount) { // Генерим в случайных ячейках бомбы
            x = RandomInt(VSize - 1);
            y = RandomInt(HSize - 1);
            if (LevelMap.get(x).get(y) != -1) {
                BombAdded++;
                LevelMap.get(x).set(y, -1);
            }
        }
        return LevelMap;
    }

    public void PaintLevel(GridPane pane, Difficulty difficulty, Field field, List<ArrayList<Integer>> LevelMap) {
        LevelMap = field.CreateField(difficulty);
        Button button;
        for (int i = 0; i < LevelMap.size(); i++) {
            for (int j = 0; j < LevelMap.get(0).size(); j++) {
                button = new Button(i + " " + j);
                pane.add(button, i, j);
            }
        }

    }

    public static int RandomInt(int max) {
        return (int) (Math.random() * ++max);
    }
}
