package com.lig4.jogo;

import java.util.Scanner;

import com.lig4.base.Tabuleiro;
import com.lig4.exception.AtributoInvalidoException;
import com.lig4.jogadores.Pessoa;

public class Jogo {
	
    private Tabuleiro tab= new Tabuleiro();
	private int linhaMax= tab.getLinhas();
	private Pessoa jogador1, jogador2;
	int escolha;

    public Jogo(Pessoa jogador1, Pessoa jogador2){
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;	
    }

    public Tabuleiro getTabuleiro(){
        return this.tab;
    }
    public Pessoa getJogador1(){
        return this.jogador1;
    }

    public Pessoa getJogador2(){
        return this.jogador2;
    }

	public void loopJogo(Pessoa jogadorAtual) {
		tab.imprimeMatriz();
	
		String nomeJogador = jogadorAtual.getNome();
		char corJogador = jogadorAtual.getCorPeca();

		int colunaEscolhida = jogadorAtual.escolheColuna();
		int qtdJogadas = 0, pontuacao = 0;
	
		try { //Checar se o movimento é válido.
			jogadorAtual.setColunaEscolhida(colunaEscolhida);

			this.alteraTab(corJogador, colunaEscolhida);
			boolean vitoria = this.checaVitoria(corJogador);
			qtdJogadas++;

			if (vitoria) {
				tab.imprimeMatriz();
				System.out.println("O jogador " + nomeJogador + " ganhou.");
				jogadorAtual.setRanking(pontuacao++);
				continuarJogo();
				try{
					setContinuarouNao(getContinuarouNao());
					if(this.escolha == 1){
						tab.limparMatriz();
						loopJogo(jogadorAtual);
					}
				} catch(AtributoInvalidoException e){
					System.out.println("Erro. "+e.getMessage());
				}
			} else if (qtdJogadas == linhaMax * tab.getColunas()) {
				System.out.println("Empate.");
				continuarJogo();
			} else {
				Pessoa proximoJogador = (jogadorAtual == jogador1) ? jogador2 : jogador1;
				loopJogo(proximoJogador);
			}
		} catch (AtributoInvalidoException e) { //Pedir (novamente) ao usuário que insira algo válido.
			System.out.println("Erro. "+e.getMessage());
			loopJogo(jogadorAtual);
		}
	}
    public void alteraTab(char corJogador, int coluna) {	
    // TODO Alterar situação do tabuleiro (colocando index do jogador na posição escolhida)
        for (int x = 0; x < linhaMax-1; x++) {
            if (tab.getMatrizPecas(x+1, coluna-1) != '0') { // Verifica se a próxima casa da coluna tem alguma peça
				try{
					tab.setMatrizPecas(x, coluna-1, corJogador);
				}catch(AtributoInvalidoException e){
					System.out.println("Erro. "+e.getMessage());
				}
				tab.setLinhaAtual(x);
                tab.imprimeMatriz();
                return;
    	    }
        }
		try{
			tab.setMatrizPecas(linhaMax-1, coluna-1, corJogador);
		}catch(AtributoInvalidoException e){
			System.out.println("Erro. "+e.getMessage());
		}
		tab.setLinhaAtual(linhaMax-1);
        tab.imprimeMatriz(); //Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna
        return;
    }

    public boolean checaVitoria(char corJogador) { //TODO verifica se após jogada alguém ganhou
		//Verificação vertical
		for(int i = 0; i < linhaMax-3;i++){
			for(int j = 0; j<tab.getColunas();j++){
				if(tab.getMatrizPecas(i, j) == corJogador && tab.getMatrizPecas(i+1, j) == corJogador && tab.getMatrizPecas(i+2, j) == corJogador && tab.getMatrizPecas(i+3, j) == corJogador )
					return true;
			}
		}
		//Verificação horizontal
		for(int i = 0; i < linhaMax; i++){
			for(int j = 0; j < tab.getColunas()-3; j++){
				if(tab.getMatrizPecas(i, j) ==  corJogador && tab.getMatrizPecas(i, j+1) == corJogador && tab.getMatrizPecas(i, j+2) == corJogador && tab.getMatrizPecas(i, j+3) == corJogador)
					return true;
			}
		}
		//Horizontal Cima - Baixo
		for(int i = 0; i < linhaMax-3; i++){
			for(int j = 0; j < tab.getColunas()-3; j++){
				if(tab.getMatrizPecas(i, j) == corJogador && tab.getMatrizPecas(i+1, j+1) == corJogador && tab.getMatrizPecas(i+2, j+2) == corJogador && tab.getMatrizPecas(i+3, j+3) == corJogador)
					return true;
			}
		}
		//Horizontal Baixo - Cima
		for(int i = 0; i < linhaMax; i++){
			for(int j = 0; j < tab.getColunas()-3; j++){
				if(tab.getMatrizPecas(i, j) == corJogador && tab.getMatrizPecas(i-1, j+1) == corJogador && tab.getMatrizPecas(i-2, j+2) == corJogador && tab.getMatrizPecas(i-3, j+3) == corJogador)
					return true;
			}
		}
		return false;
	}

	public void continuarJogo(){
        System.out.println("Deseja continuar jogando? ");
        System.out.println("1. Sim");
        System.out.println("2. Não");
    }

	public void setContinuarouNao(int escolha) throws AtributoInvalidoException{
		if(escolha < 0 || escolha > 2){
			throw new AtributoInvalidoException("Opção inválida.");
		}
		this.escolha = escolha;
	}

	public int getContinuarouNao(){
		Scanner sc = new Scanner(System.in);
		escolha = sc.nextInt();

		return escolha;
	}

}
