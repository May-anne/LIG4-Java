package com.lig4.main;

import com.lig4.gui.TabuleiroGUI;
import com.lig4.jogadores.Pessoa;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class tabuleiroController {
    private String idBotaoClicado;
    private TabuleiroGUI tabGui;
    private nomesController nomes = new nomesController();
    private int col;
    private boolean jogador1Vez = true;
    private Pessoa jogadorAtual;

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
    protected void btEscolherColuna(MouseEvent event) {
        Button botaoClicado = (Button) event.getSource();
        idBotaoClicado = botaoClicado.getId();

        Pessoa jogador1 = nomes.getJogador1();
        Pessoa jogador2 = nomes.getJogador2();

        tabGui = new TabuleiroGUI(jogador1, jogador2);
        
        col = obterColuna();

        if (jogador1Vez) {
            jogadorAtual = jogador1;
        } else {
            jogadorAtual = jogador2;
        }

        tabGui.alteraTabGui(grid, col);
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
