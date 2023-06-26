package main;

public class Tabuleiro {

	private int colunas=7,linhas=6;
	private int[][] matrizPecas=new int[this.linhas][this.colunas];

	public int getColunas(){
		return colunas;
	}

	public int getLinhas(){
		return linhas;
	}
	
	public boolean checaMovimento(int coluna, int index) {//TODO Verifica se peças podem ou não ser colocadas
		return true; //Retorna true ou false dependendo da situação
	}
	
	public String checaVitoria(int index) { //TODO verifica se após jogada alguém ganhou
		
		return "Vitória";
	}
	
	
	public void alteraTab(int index) { //TODO Altera situacao do tabuleiro(colocando index do jogador na posição escolhida
		
	}

	public Tabuleiro() { //Construtor
		for(int x = 0; x < this.linhas; x++) {
			for(int y = 0; y < this.colunas; y++) {
				matrizPecas[x][y] = 0;
			}
		}	
	}
}
