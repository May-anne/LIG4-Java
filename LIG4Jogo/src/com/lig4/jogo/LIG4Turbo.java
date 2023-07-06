package com.lig4.jogo;
import com.lig4.base.Tabuleiro;
import com.lig4.jogadores.Pessoa;

public class LIG4Turbo extends Jogo{

    private Tabuleiro tab; 
	private int linhaMax;
	private Pessoa jogador1, jogador2;

    public LIG4Turbo(Pessoa jogador1, Pessoa jogador2){ 

        super(jogador1, jogador2); 

		this.tab = super.getTabuleiro();
		this.linhaMax = this.tab.getLinhas();
		this.jogador1 = super.getJogador1();
		this.jogador2 = super.getJogador2();

		loopJogo(this.jogador1);

    }

    @Override
    public void alteraTab(char corJogador, int coluna){
        super.alteraTab(corJogador, coluna);
        int linhaAtual = tab.getLinhaAtual();

        if(coluna < tab.getColunas()){
            if(tab.getMatrizPecas(linhaAtual, coluna) != '0'){
                tab.setMatrizPecas(linhaAtual, coluna, corJogador);
                tab.imprimeMatriz();
            }
        }

        if(coluna > 1){
            if(tab.getMatrizPecas(linhaAtual, coluna-2) != '0'){
                tab.setMatrizPecas(linhaAtual, coluna-2, corJogador);
                tab.imprimeMatriz();
            }      
        }
    }
}
