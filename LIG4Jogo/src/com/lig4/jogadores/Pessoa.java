package com.lig4.jogadores;

import java.io.Serializable;
import com.lig4.exception.AtributoInvalidoException;

public class Pessoa implements Serializable{
	private String nome;
	private char peca;
	private int pontos=0; // A cada vitória, soma +1
	
	public Pessoa(String nome, char peca) {	
		this.nome = nome; //Futuramente colocar verificação para ver se nome já existe no ranking
		this.peca = peca; //Identifica se é jogador 1 ou jogador 2. A cada partida, a cor pode ser redefinida
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
