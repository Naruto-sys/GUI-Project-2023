package com.example.sapper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class WinLossController {
    public void BackToStartMenuButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked back");
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
