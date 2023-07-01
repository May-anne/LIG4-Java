package main;

public class Pessoa {
	
	private String nome;
	private int index;
	//private int ranking = 0; // A cada vitória, soma +1
	
	public Pessoa(String nome, int index) {	
		this.nome = nome;//futuramente colocar verificação para ver se nome já existe no ranking
		this.index = index; //identifica se é jogador 1 ou jogador 2, a cada partida index pode ser redefinido
	}
	
	public void escolheColuna(int coluna, Partida tabuleiro){
		if(tabuleiro.checaMovimento(coluna, this.index)) {
			tabuleiro.alteraTab(this.index,coluna);
			if(tabuleiro.checaVitoria(this.index)){
				System.out.println(this.nome +" ganhou.");
				//ranking++;
			}
		}else {
			System.err.print("Movimento inválido");	
		}
	}


}
