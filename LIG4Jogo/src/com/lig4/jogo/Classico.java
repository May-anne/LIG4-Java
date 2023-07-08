package com.lig4.jogo;
import com.lig4.base.Tabuleiro;
import com.lig4.jogadores.Pessoa;

public class Classico extends Jogo {

	private Tabuleiro tab; 
	private int linhaMax;
	private Pessoa jogador1, jogador2;
	
	public Classico(Pessoa jogador1, Pessoa jogador2){
		super(jogador1, jogador2); 

		this.tab = super.getTabuleiro();
		this.linhaMax = this.tab.getLinhas();
		this.jogador1 = super.getJogador1();
		this.jogador2 = super.getJogador2();

		super.loopJogo(this.jogador1);

	}

	
    

    
}
