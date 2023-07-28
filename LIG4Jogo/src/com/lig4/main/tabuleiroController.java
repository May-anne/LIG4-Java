package com.lig4.main;

import com.lig4.gui.TabuleiroGUI;
import com.lig4.jogadores.Pessoa;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class tabuleiroController {
    private String idBotaoClicado;
    private TabuleiroGUI tabGui;
    
    private int col;
    private int jogador1Vez = 0;
    protected Pessoa jogadorAtual, jogador1,jogador2;
    char peca1,peca2;

    @FXML
    private GridPane grid = new GridPane();

    @FXML
    protected void btColorir(MouseEvent event){
        Button botaoEntrar = (Button) event.getSource();
        botaoEntrar.setOpacity(0.48);
    }

    @FXML
    protected void btDescolorir(MouseEvent event){
        Button botaoSair = (Button) event.getSource();
        botaoSair.setOpacity(0);
    }
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

        this.jogador1 = new Pessoa(nome1, 'V');
        this.jogador2 = new Pessoa(nome2, 'A');
        System.out.println(jogador1);
        System.out.println(jogador2);

        MainClass.changeScreen("tabuleiro");
    }

    @FXML
    protected void btEscolherColuna(MouseEvent event) {
        Button botaoClicado = (Button) event.getSource();
        idBotaoClicado = botaoClicado.getId();


        tabGui = new TabuleiroGUI(this.jogador1, this.jogador2);
        
        col = obterColuna();

        if(jogador1Vez !=1)
            jogador1Vez = 1;
        else
            jogador1Vez = 2;
        
        System.out.println(jogador1);
        tabGui.alteraTabGui(grid, col, jogador1Vez);
        boolean vit = tabGui.checaVitoria(grid, jogador1);
    }

    public int obterColuna(){
        if(idBotaoClicado.equals("button1"))
            return 1;
        else if(idBotaoClicado.equals("button2"))
            return 2;
        else if(idBotaoClicado.equals("button3"))
            return 3;
        else if(idBotaoClicado.equals("button4"))
            return 4;
        else if(idBotaoClicado.equals("button5"))
            return 5;
        else if(idBotaoClicado.equals("button6"))
            return 6;
        else if(idBotaoClicado.equals("button7"))
            return 7;
        else
            return 0;
    }

    public GridPane getGrid(){
        return grid;
    }

}
