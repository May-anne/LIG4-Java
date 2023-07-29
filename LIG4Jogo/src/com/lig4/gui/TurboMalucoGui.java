package com.lig4.gui;

import java.util.Random;


import com.lig4.jogadores.Pessoa;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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

        if(this.nivel == 3 || this.nivel == 4)
            turboMalucoAlteraGui(gridPane, jogadorAtual, col, row, this.nivel);
        else if(this.nivel == 5)
            hospicio(gridPane, jogadorAtual);
    }

    public void turboMalucoAlteraGui(GridPane gridPane,Pessoa jogadorAtual,int coluna, int linhaAtual, int nivel ){

        Circle circuloAtual;
        Random random = new Random();
        Color cor = jogadorAtual.equals(super.getJogador1()) ? Color.RED : Color.YELLOW;

        int row, column, prob;
        int min = 1;
        int max = 4;
        boolean troca = false;

        for(int addLinha = -1; addLinha <=1; addLinha++){
            row = linhaAtual + addLinha;
            for(int addColuna = -1; addColuna<=1; addColuna++){
                column = coluna + addColuna;
                if((row>=0 && row<super.getLinhas() && column>=0 && column<super.getColunas()&& Math.abs(row - linhaAtual)<=1) && (Math.abs(column - coluna) <= 1)){
                    
                    circuloAtual = super.getCirculo(gridPane, column, row);
                    prob = random.nextInt(max - min + 1) + min;

                    if(!circuloAtual.getFill().equals(cor) && !circuloAtual.getFill().equals(Color.WHITE)){
                        if((prob == 1 && nivel == 0) || (prob>1 && nivel ==1)){
                            System.out.println("Vizinho alterado");
                            super.setPeca(gridPane, addColuna, row, jogadorAtual);
                            troca = true;
                        }
                    }
                } 
            }
            if(troca)
                break;
        }
    }

    public void hospicio(GridPane gridPane,Pessoa jogadorAtual){

        Random random = new Random();
        Circle circulo;
        Color cor = jogadorAtual.equals(super.getJogador1()) ? Color.RED : Color.YELLOW;

        boolean prob;

        for(int y=0;y<super.getLinhas();y++){
            for(int x = 0; x<super.getColunas();x++){

                circulo = super.getCirculo(gridPane, x, y);

                prob = random.nextBoolean();

                if(circulo.getFill().equals(Color.WHITE) && circulo.getFill().equals(cor) && prob){

                    super.setPeca(gridPane, y, x, jogadorAtual);
            
                }
            }
        }


    }


}
