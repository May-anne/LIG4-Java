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
	
	public void checaSituacao() {//Verifica se peças podem ou não ser chamadas
		
	}
	
	public String checaVitoria() {
		
		return "Vitória";
	}
	
}
