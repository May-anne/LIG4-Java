package com.lig4.gui;

import com.lig4.jogadores.Pessoa;

import javafx.scene.layout.GridPane;

public class ClassicoGUI extends TabuleiroGUI {
    
    public ClassicoGUI(Pessoa jogador1,Pessoa jogador2){
        super(jogador1,jogador2);
    }

    @Override
    public void alteraTabuleiro(GridPane gridPane,int col,  Pessoa jogadorAtual){
        super.alteraTabGui(gridPane, col, jogadorAtual);
    }

    @Override
    public int checaVitoria(GridPane gridPane, Pessoa pessoa){
        return super.checaVitoria(gridPane, pessoa);
    }

}