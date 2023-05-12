package com.example.sapper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DifficultyChangeController {
    @FXML
    public void BackToStartGameButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked back");
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void EasyLevelButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked easy");
        Parent root = FXMLLoader.load(getClass().getResource("EasyLevel.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MediumLevelButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked medium");
        Parent root = FXMLLoader.load(getClass().getResource("MediumLevel.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void HardLevelButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked hard");
        Parent root = FXMLLoader.load(getClass().getResource("HardLevel.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
