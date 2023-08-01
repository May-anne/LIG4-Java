package com.lig4.gui;

import com.lig4.jogadores.Pessoa;
import com.lig4.jogadores.Ranking;
import com.lig4.main.MainClass;

import javafx.scene.layout.GridPane;

public class ClassicoGUI extends TabuleiroGUI {
    
    public ClassicoGUI(Pessoa jogador1,Pessoa jogador2){
        super(jogador1,jogador2);
    }

    @Override
    public void alteraTabuleiro(GridPane gridPane,int col,  Pessoa jogadorAtual){
        super.alteraTabGui(gridPane, col, jogadorAtual);
        Ranking rank = new Ranking();

        if(checaVitoria(gridPane, jogadorAtual) == 1){
            mostrarVitoria(jogadorAtual);
            jogadorAtual.setPontos(1);
            if(continuarJogando()){
                reiniciarTab(gridPane);
            }else{
                rank.carregaRanking();
                rank.addJogador(super.getJogador1());
                rank.addJogador(super.getJogador2());
                rank.salvarRanking();
                MainClass.changeScreen("menu");
            }
        }
    }

    @Override
    public int checaVitoria(GridPane gridPane, Pessoa pessoa){
        return super.checaVitoria(gridPane, pessoa);
    }

}
