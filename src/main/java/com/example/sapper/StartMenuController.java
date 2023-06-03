package com.example.sapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenuController {
    @FXML
    public Button StartGameButton;
    @FXML
    public void StartGameButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked");
        Parent root = FXMLLoader.load(getClass().getResource("ChooseDifficultyMenu.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public Button RulesButton;
    @FXML
    public void RulesButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("clicked");
        Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public Button ExitButton;
    @FXML
    public void CloseButtonAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}