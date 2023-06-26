package main;

public class Tabuleiro {

	private int colunas=7, linhas=6;
	private int[][] matrizPecas=new int[this.linhas][this.colunas];
	Peça [][]tab = new Peça[linhas][colunas];
	
	public Tabuleiro() { //Construtor
		for(int x = 0; x < this.linhas; x++) {
			for(int y = 0; y < this.colunas; y++) {
				matrizPecas[x][y] = 0;
			}
		}	
	}
	
	public void exibirTab(){
		for(int linha = 0; linha < linhas; linha++){
			System.out.print("|");
			for(int coluna = 0; coluna < colunas; coluna++){
				if(tab[linha][coluna] == null){
					System.out.print("_");
				}else{
					System.out.print(tab[coluna][linha].getCor());
				}
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public void imprimeMatriz() {
		for (int i = 0; i < matrizPecas.length; i++) {
		    for (int j = 0; j < matrizPecas[i].length; j++) {
		        System.out.print(matrizPecas[i][j] + " ");
		    }
		    System.out.println();
		}
		
		System.out.println();
	}
	
	
	public int getColunas(){
		return colunas;
	}

	public int getLinhas(){
		return linhas;
	}
	
	public boolean checaMovimento(int coluna, int index) {//TODO Verifica se peças podem ou não ser colocadas
		if(coluna<1 || coluna>this.colunas) { //Se coluna escolhida não existir
			System.out.println("caso 1");
			return false;
		}
		else if(this.matrizPecas[0][coluna]!=0) {//Se Coluna estiver cheia
			System.out.println("caso 2");
			return false;
		}
	    else{
			System.out.println("caso 3");
			return true;
		}
			
		
	}
	
	public String checaVitoria(int index) { //TODO verifica se após jogada alguém ganhou
		//for(int x = 0; x<this.linhas)
		return "Vitória";
	}
	
		
	public int alteraTab(int index, int coluna) {
    // TODO Alterar situação do tabuleiro (colocando index do jogador na posição escolhida)
		for (int x = 0; x < this.linhas-1; x++) {
			if (this.matrizPecas[x + 1][coluna-1] != 0) { // Verifica se a próxima casa da coluna tem alguma peça
				this.matrizPecas[x][coluna-1] = index; // Se tiver, a peça alterada deve ser a atual
				imprimeMatriz();
				return 1;
			}
		}

		this.matrizPecas[this.linhas-1][coluna-1] = index; // Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna
		imprimeMatriz();
		return 1;
	}

}

