package com.lig4.controllers;

import java.io.IOException;
import com.lig4.main.MainClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class modoTurboMalucoController {
    @FXML
    protected void btDorDeCabeca(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/nomes.fxml"));
        Parent root = loader.load();
        nomesController modo = loader.getController();
        modo.setModo(3);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void btTarjaPreta(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/nomes.fxml"));
        Parent root = loader.load();
        nomesController modo = loader.getController();
        modo.setModo(4);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void btHospicio(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/nomes.fxml"));
        Parent root = loader.load();
        nomesController modo = loader.getController();
        modo.setModo(5);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void btVoltar(){
        MainClass.changeScreen("modoJogo");
    }
}
