package main;

public class Tabuleiro {

	private int colunas=7,linhas=6;
	private int[][] matrizPecas=new int[this.linhas][this.colunas];
	
	public Tabuleiro() { //Construtor
		for(int x = 0; x < this.linhas; x++) {
			for(int y = 0; y < this.colunas; y++) {
				matrizPecas[x][y] = 0;
			}
		}	
	}
	
	
	public int getColunas(){
		return colunas;
	}

	public int getLinhas(){
		return linhas;
	}
	
	public boolean checaMovimento(int coluna, int index) {//TODO Verifica se peças podem ou não ser colocadas
		
		if(coluna<1 || coluna>this.colunas) //Se coluna escolhida não existir
			return false;
		else if(this.matrizPecas[0][coluna]!=0)//Se Coluna estiver cheia
			return false;
		else
			return true;
	}
	
	public String checaVitoria(int index) { //TODO verifica se após jogada alguém ganhou
		for(int x = 0;x<this.linhas)
		return "Vitória";
	}
	
	
	public int alteraTab(int index,int coluna) {
		
		//TODO Altera situacao do tabuleiro(colocando index do jogador na posição escolhida
		for(int x=0;x<this.linhas;x++) {
			if(this.matrizPecas[x+1][coluna]!=0)//Verifica se a próxima casa da coluna tem alguma peça, se tiver, a peça alterada deve ser a atual
				this.matrizPecas[x][coluna] = index;
				return 1;
		}
		
		this.matrizPecas[this.linhas][coluna] = index;//Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna
		return 1;
		
		
	}

	
}
