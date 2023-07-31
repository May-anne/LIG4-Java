package com.lig4.main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class modoJogoController {
    @FXML
    protected void btTurboMalucoAction() throws IOException{     
        MainClass.changeScreen("turboMaluco");
    }

    @FXML
    protected void btClassico(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/nomes.fxml"));
        Parent root = loader.load();
        nomesController modo = loader.getController();
        modo.setModo(1);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void btTurbo(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/nomes.fxml"));
        Parent root = loader.load();
        nomesController modo = loader.getController();
        modo.setModo(2);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}//aaaa
