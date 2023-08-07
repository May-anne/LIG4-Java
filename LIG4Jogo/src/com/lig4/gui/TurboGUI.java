package com.lig4.gui;

import com.lig4.jogadores.Pessoa;
import com.lig4.jogadores.Ranking;
import com.lig4.main.MainClass;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TurboGUI extends TabuleiroGUI{

    public TurboGUI(Pessoa jogador1, Pessoa jogador2) {
        super(jogador1, jogador2);
    }

    @Override
    public void alteraTabuleiro(GridPane gridPane, int col, Pessoa jogadorAtual) {
        super.alteraTabGui(gridPane, col, jogadorAtual);

        Circle circuloAtual;
        Ranking rank = new Ranking();
        int row = super.getLinhaAtual();
        Color cor = jogadorAtual.equals(super.getJogador1()) ? Color.RED : Color.YELLOW;

        if(col < 7){
            circuloAtual = getCirculo(gridPane, col, row);
            if(!circuloAtual.getFill().equals(cor) && !circuloAtual.getFill().equals(Color.WHITE)){
                super.setPeca(gridPane, col, row, jogadorAtual);
            }
        }
        if(col > 1){
            int antCol = col - 2;
            circuloAtual = getCirculo(gridPane, antCol, row);
            if(!circuloAtual.getFill().equals(cor) && !circuloAtual.getFill().equals(Color.WHITE)){
                super.setPeca(gridPane, antCol, row, jogadorAtual);
            }
        }

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
