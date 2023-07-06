package com.lig4.jogadores;

import java.util.Scanner;
import com.lig4.base.Peca;

public class Pessoa {
	private String nome;
	private Peca peca;
	private int ranking; // A cada vitória, soma +1
	
	public Pessoa(String nome, Peca peca) {	
		this.nome = nome; //Futuramente colocar verificação para ver se nome já existe no ranking
		this.peca = peca; //Identifica se é jogador 1 ou jogador 2. A cada partida, a cor pode ser redefinida
	}

	public int escolheColuna(){
		Scanner sc = new Scanner(System.in);
		System.out.print(this.nome + ", escolha uma coluna de 1 a 7: ");
		int col = sc.nextInt();

		return col;
	}

	public char getCorPeca(){
		return peca.getCor();
	}

	public void setCorPeca(char cor){
		this.peca.setCor(cor);
	}

	public String getNome(){
		return nome;
	}

	public int getRanking(){
		return ranking;
	}

	public void setRanking(int ranking){
		this.ranking = ranking;
	}
}
