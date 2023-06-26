package main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tabuleiro jogo = new Tabuleiro();
		Pessoa jogador1 = new Pessoa("Jogador1",1);
		Pessoa jogador2 = new Pessoa("Jogador2",2);
		
		jogador1.escolheColuna(1, jogo);
		jogador2.escolheColuna(1, jogo);


	}

}
