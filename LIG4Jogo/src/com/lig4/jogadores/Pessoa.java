package com.lig4.jogadores;

import java.io.Serializable;
import java.util.Scanner;
import com.lig4.base.Peca;
import com.lig4.exception.AtributoInvalidoException;
//aa
public class Pessoa implements Serializable {
	private String nome;
	private char peca;
	private int col;
	private int pontos=0; // A cada vitória, soma +1
	
	public Pessoa(String nome, char peca) {	
		this.nome = nome; //Futuramente colocar verificação para ver se nome já existe no ranking
		this.peca = peca; //Identifica se é jogador 1 ou jogador 2. A cada partida, a cor pode ser redefinida
	}

	public int escolheColuna(){
		Scanner sc = new Scanner(System.in);
		System.out.print(this.nome + ", escolha uma coluna de 1 a 7: ");
		int col = sc.nextInt();

		return col;
	}

	public void setColunaEscolhida(int col) throws AtributoInvalidoException{
		if(col < 0 || col > 7){
			throw new AtributoInvalidoException("Coluna escolhida inválida");
		}
		this.col = col;
	}

	public char getCorPeca(){
		return this.peca;
	}

	public void setCorPeca(char cor) throws AtributoInvalidoException{
		this.peca = cor;
	}

	public String getNome(){
		return nome;
	}

	public int getPontos(){
		return this.pontos;
	}

	public void setPontos(int pontos) {
		this.pontos += pontos;
	}
}
