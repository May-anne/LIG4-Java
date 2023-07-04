package com.lig4.main;
<<<<<<< Updated upstream

import com.lig4.jogo.Start;
=======
import com.lig4.jogo.LIG4Turbo;
import com.lig4.jogo.Lig4TurboMaluco;
import com.lig4.jogo.Pessoa;
>>>>>>> Stashed changes

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< Updated upstream
		new Start();
=======

		Lig4TurboMaluco game = new Lig4TurboMaluco();
		Pessoa jogador1 = new Pessoa("Jogador1",1);
		Pessoa jogador2 = new Pessoa("Jogador2",2);
		
		jogador1.escolheColuna(1, game);
		jogador2.escolheColuna(3, game);
		jogador1.escolheColuna(4, game);
		jogador1.escolheColuna(2, game);
		jogador2.escolheColuna(3, game);
		
		jogador1.escolheColuna(6, game);
		jogador2.escolheColuna(7, game);
>>>>>>> Stashed changes
	}

}
