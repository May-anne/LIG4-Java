package main;

public class Tabuleiro {

	private int colunas=7,linhas=6;
	private int[][] matrizPecas=new int[this.linhas][this.colunas];
	
	public Tabuleiro() { //Construtor
		
		for(int x = 0;x<this.linhas;x++) {
			for(int y = 0;y<this.linhas;y++) {
				matrizPecas[x][y] = 0;
			}
		}	
	}
	
	public boolean checaMovimento(int coluna, int index) {//TODO Verifica se peças podem ou não ser colocadas
		return true; //Retorna true ou false dependendo da situação
	}
	
	public String checaVitoria(int index) { //TODO verifica se após jogada alguém ganhou
		
		return "Vitória";
	}
	
	
	public void alteraTab(int index) { //TODO Altera situacao do tabuleiro(colocando index do jogador na posição escolhida
		
		
	}
}
