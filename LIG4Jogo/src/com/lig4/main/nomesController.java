package com.lig4.main;

import java.io.IOException;
import com.lig4.jogadores.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Node;

public class nomesController {
    private Pessoa jogador1, jogador2;
    private char peca1, peca2;
    private int modo;

    @FXML
    private TextField textfield1 = new TextField();

    @FXML
    private TextField textfield2 = new TextField();

    @FXML 
    protected void btIniciarAction(ActionEvent event) throws IOException{
        String nome1 = textfield1.getText();
        String nome2 = textfield2.getText();

        if(nome1.isEmpty() || nome2.isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Insira nomes válidos!");
            textfield1.clear();
            textfield2.clear();
            alert.showAndWait();
            return;
        }

        if(nome1.equals(nome2)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Inválido! Nomes iguais.");
            textfield1.clear();
            textfield2.clear();
            alert.showAndWait();
            return;
        }

        peca1 = 'V';
        peca2 = 'A';
//a
        jogador1 = new Pessoa(nome1, peca1);
        jogador2 = new Pessoa(nome2, peca2);

        //Passar informação para a próxima tela.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tabuleiro.fxml"));
        Parent root = loader.load();
        tabuleiroController tabController = loader.getController();
        tabController.setJogador1(jogador1);
        tabController.setJogador2(jogador2);
        tabController.mostrarNome1(jogador1.getNome());
        tabController.mostrarNome2(jogador2.getNome());
        tabController.obterModo(modo);
        tabController.mostrarModo(nomeModo(modo));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setModo(int modo){
        this.modo = modo;
    }

    public String nomeModo(int modo){
        if(modo == 1)
            return "Clássico";
        else if(modo == 2)
            return "Turbo";
        else
            return "Turbo Maluco";
    }
}
