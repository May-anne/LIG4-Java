package com.lig4.base;

public class Tabuleiro {

	private int colunas = 7, linhas = 6;
	private int linAtual;
	private char[][] matrizPecas = new char[this.linhas][this.colunas];
	
	public Tabuleiro() { //Construtor
		for(int x = 0; x < this.linhas; x++) {
			for(int y = 0; y < this.colunas; y++) {
				matrizPecas[x][y] = '0';
			}
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

	public void setLinhaAtual(int linAtual){
		this.linAtual = linAtual;
	}

	public int getLinhaAtual(){
		return linAtual;
	}

	public int getMatrizPecas(int linhas, int colunas){
		try{
			return matrizPecas[linhas][colunas];
		} catch(Exception e){
			try {
				return matrizPecas[linhas][colunas-1];
			} catch (Exception k) {
				return matrizPecas[linhas][colunas+1];
			}	
	}
}
	public void setMatrizPecas(int linha, int coluna, char corJogador){
		this.matrizPecas[linha][coluna] = corJogador;
	}
}

