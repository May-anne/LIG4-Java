package com.lig4.gui;

import java.util.Random;

import com.lig4.jogadores.Pessoa;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class TurboMalucoGui extends TabuleiroGUI{

    private int nivel;

    public TurboMalucoGui(Pessoa jogador1, Pessoa jogador2, int nivel){
        super(jogador1,jogador2);

        this.nivel = nivel;
    }

    @Override
    public void alteraTabuleiro(GridPane gridPane, int col, Pessoa jogadorAtual) {
        super.alteraTabGui(gridPane,col,jogadorAtual);

        int row = super.getLinhaAtual();

        switch(this.nivel){
            case 1:

        }
        

    }

    public void turboMalucoAlteraGui(GridPane gridPane,Pessoa jogadorAtual,int coluna, int linhaAtual, int nivel ){

        Circle circuloAtual;
        Random random = new Random();

        int min = 1;
        int max = 4;
        boolean troca = false;





    }
}
