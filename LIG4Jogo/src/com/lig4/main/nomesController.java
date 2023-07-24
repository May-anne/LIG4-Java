package com.lig4.main;

import com.lig4.base.Peca;
import com.lig4.jogadores.Pessoa;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class nomesController {
    private Pessoa jogador1;
    private Pessoa jogador2;
    private Peca peca1;
    private Peca peca2;

    @FXML
    private TextField textfield1 = new TextField();

    @FXML
    private TextField textfield2 = new TextField();

    @FXML 
    protected void btIniciarAction(){
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

        peca1 = new Peca('A');
        peca2 = new Peca('V');

        System.out.println("nome1 = "+nome1);
        System.out.println("nome2 = "+nome2);

        jogador1 = new Pessoa(nome1, peca1);
        jogador2 = new Pessoa(nome2, peca2);

        MainClass.changeScreen("tabuleiro");
    }
}
