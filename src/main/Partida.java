package main;

public class Partida {
    Tabuleiro tab;

    public Partida(){
        tab = new Tabuleiro();
    }
    
    public boolean checaMovimento(int coluna, int index) {//TODO Verifica se peças podem ou não ser colocadas
    /*Se coluna escolhida não existir ou estiver cheia*/
        if(coluna-1 < 0 || coluna > tab.getColunas()+1 || tab.getMatrizPecas(0, coluna-1) != 0 ) {
            return false;
        } else {
            return true;
        }	
    }

    public boolean checaVitoria(int index) { //TODO verifica se após jogada alguém ganhou
		//Verificação vertical
		for(int i = 0; i < tab.getLinhas()-3;i++){
			for(int j = 0; j<tab.getColunas();j++){
				if(tab.getMatrizPecas(i, j) == index && tab.getMatrizPecas(i+1, j) == index && tab.getMatrizPecas(i+2, j) == index && tab.getMatrizPecas(i+3, j) == index )
					return true;
			}
		}
		//Verificação horizontal
		for(int i = 0; i < tab.getLinhas(); i++){
			for(int j = 0; j < tab.getColunas()-3; j++){
				if(tab.getMatrizPecas(i, j) == index && tab.getMatrizPecas(i, j+1) == index && tab.getMatrizPecas(i, j+2) == index && tab.getMatrizPecas(i, j+3) == index )
					return true;
			}
		}
		//Horizontal Cima - Baixo
		for(int i = 0; i < tab.getLinhas()-3; i++){
			for(int j = 0; j < tab.getColunas()-3; j++){
				if(tab.getMatrizPecas(i, j) == index && tab.getMatrizPecas(i+1, j+1) == index && tab.getMatrizPecas(i+2, j+2) == index && tab.getMatrizPecas(i+3, j+3) == index )
					return true;
			}
		}
		//Horizontal Baixo - Cima
		for(int i = 0; i < tab.getLinhas(); i++){
			for(int j = 0; j < tab.getColunas()-3; j++){
				if(tab.getMatrizPecas(i, j) == index && tab.getMatrizPecas(i-1, j+1) == index && tab.getMatrizPecas(i-2, j+2) == index && tab.getMatrizPecas(i-3, j+3) == index )
					return true;
			}
		}
		return false;
	}
    public int alteraTab(int index, int coluna) {
    // TODO Alterar situação do tabuleiro (colocando index do jogador na posição escolhida)
        for (int x = 0; x < tab.getLinhas()-1; x++) {
            if (tab.getMatrizPecas(x+1, coluna-1) != 0) { // Verifica se a próxima casa da coluna tem alguma peça
                tab.setMatrizPecas(x, coluna-1, index);
				tab.setLinhaAtual(x);
                tab.imprimeMatriz();
                return 1;
            }
    }
        tab.setMatrizPecas(tab.getLinhas()-1, coluna-1, index);
		tab.setLinhaAtual(tab.getLinhas()-1);

        tab.imprimeMatriz();//Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna
        return 1;
    }
}
