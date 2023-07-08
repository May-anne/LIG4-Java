package com.lig4.base;

import com.lig4.exception.AtributoInvalidoException;

public class Tabuleiro implements InterfaceTabuleiro{

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

	public void setLinhaAtual(int linAtual){ //Nunca vai entrar em exceção.
		this.linAtual = linAtual;
	}

	public int getLinhaAtual(){
		return linAtual;
	}

	public int getMatrizPecas(int linhas, int colunas){ //Revisar depois.
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
	public void setMatrizPecas(int linha, int coluna, char corJogador) throws AtributoInvalidoException{
		if((linha < 0 && linha > 5) || (coluna < 0 && coluna > 6)){
			throw new AtributoInvalidoException("Valor inexistente na matriz de peças.");
		}
		this.matrizPecas[linha][coluna] = corJogador;
	}
}

