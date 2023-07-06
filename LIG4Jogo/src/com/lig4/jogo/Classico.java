package com.lig4.jogo;
import com.lig4.base.Tabuleiro;
import com.lig4.jogadores.Pessoa;

public class Classico {
    protected Tabuleiro tab = new Tabuleiro(); //Precisa ser private
	private int linhaMax = tab.getLinhas();
	private Pessoa jogador1, jogador2;

	public Classico(Pessoa jogador1, Pessoa jogador2){
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		loopJogo(jogador1);
	}

	public void loopJogo(Pessoa jogadorAtual){ //TODO mantém o jogo em loop até que alguém vença ou dê empate.
		tab.imprimeMatriz();

		String nomeJogador = jogadorAtual.getNome();
		char corJogador = jogadorAtual.getCorPeca();
		int qtdJogadas = 0;

		int colunaEscolhida = jogadorAtual.escolheColuna();
		boolean movimentoValido = checaMovimento(colunaEscolhida);

		if(movimentoValido){
			alteraTab(corJogador, colunaEscolhida);
			boolean vitoria = checaVitoria(corJogador);
			qtdJogadas++;

			if(vitoria){
				System.out.println("O jogador "+nomeJogador +" ganhou.");
			} else if(qtdJogadas == linhaMax*tab.getColunas()){
				System.out.println("Empate.");
				//continuarJogo();
			}
			else{
				Pessoa proximoJogador = (jogadorAtual == jogador1) ? jogador2 : jogador1; //Passa a vez para o próximo jogador.
                loopJogo(proximoJogador);
			}
		}
	}
    
    public boolean checaMovimento(int coluna) {//TODO Verifica se peças podem ou não ser colocadas
    /*Se coluna escolhida não existir ou estiver cheia*/
        if(coluna-1 < 0 || coluna > tab.getColunas()+1 || tab.getMatrizPecas(0, coluna-1) != '0' ) {
            return false;
        } else {
            return true;
        }	
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
    public void alteraTab(char corJogador, int coluna) {
    // TODO Alterar situação do tabuleiro (colocando index do jogador na posição escolhida)
        for (int x = 0; x < linhaMax-1; x++) {
            if (tab.getMatrizPecas(x+1, coluna-1) != '0') { // Verifica se a próxima casa da coluna tem alguma peça
                tab.setMatrizPecas(x, coluna-1,  corJogador);
				tab.setLinhaAtual(x);
                tab.imprimeMatriz();
                return;
    	}
}
        tab.setMatrizPecas(linhaMax-1, coluna-1, corJogador);
		tab.setLinhaAtual(linhaMax-1);
        tab.imprimeMatriz(); //Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna
        return;
}
}
