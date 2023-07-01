package main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LIG4Turbo game = new LIG4Turbo();
		Pessoa jogador1 = new Pessoa("Jogador1",1);
		Pessoa jogador2 = new Pessoa("Jogador2",2);
		
		jogador1.escolheColuna(2, game);
		jogador2.escolheColuna(3, game);
		jogador1.escolheColuna(4, game);

	}

}
