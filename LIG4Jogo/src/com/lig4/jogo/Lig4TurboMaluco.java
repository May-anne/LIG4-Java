package com.lig4.jogo;
import java.util.Random;

import com.lig4.base.Tabuleiro;
import com.lig4.jogadores.Pessoa;

public class Lig4TurboMaluco extends Jogo{
    
    private Tabuleiro tab; 
	private int linhaMax;
	private Pessoa jogador1, jogador2;
    private int nivel;
    public Lig4TurboMaluco(Pessoa jogador1, Pessoa jogador2, int nivel){

        super(jogador1, jogador2); 

		this.tab = super.getTabuleiro();
		this.linhaMax = this.tab.getLinhas();
		this.jogador1 = super.getJogador1();
		this.jogador2 = super.getJogador2();
        this.nivel=nivel;

        super.loopJogo(this.jogador1);
    }
    
    @Override
    public void alteraTab(char corJogador, int coluna){
        super.alteraTab(corJogador, coluna);
        int linhaAtual = tab.getLinhaAtual();

        if(nivel == 0)
            alteraTabMaluco(coluna,linhaAtual,corJogador,tab,0);
        else if(nivel == 1)
            alteraTabMaluco(coluna,linhaAtual,corJogador,tab,1);
        else if(nivel == 2)
            hospicio(corJogador,tab);

    }

    public void alteraTabMaluco(int coluna, int linhaAtual, char corJogador, Tabuleiro tab, int nivel) {
        Random random = new Random();
        int min = 1;
        int max = 4;
        boolean troca = false;
    
        for (int y = -1; y <= 1; y++) {
            int row = linhaAtual + y;
            for (int x = -1; x <= 1; x++) {
                int column = (coluna-1) + x;
                if (row >= 0 && row < tab.getLinhas() && column >= 0 && column < tab.getColunas() && (Math.abs(row - linhaAtual) <= 1) && (Math.abs(column - coluna) <= 1)) {
                    int item = tab.getMatrizPecas(row, column);
                    int prob = random.nextInt(max - min + 1) + min;
                    if (item != corJogador && item != '0') {
                        if ((prob == 1 && nivel == 0) || (prob > 1 && nivel == 1)) {
                            System.out.println("Mudei alguma");
                            tab.setMatrizPecas(row, column, corJogador);
                            troca = true;
                            break;
                        }
                    }
                }
            }
            if(troca)
                break;
        }


    }

    public void hospicio(char corJogador,Tabuleiro tab){//Altera todas as peças do tabuleiro 50/50 de chance, um casino completo
        Random random = new Random();
        int item;
        boolean prob;

        for(int y=0;y<tab.getLinhas();y++){
            for(int x = 0; x<tab.getColunas();x++){
                item = tab.getMatrizPecas(y,x);
                prob = random.nextBoolean();
                if(item !='0' && item != corJogador && prob){
                    tab.setMatrizPecas(y, x, corJogador);
                }
            }
        }
    }
}


