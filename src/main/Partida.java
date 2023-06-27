package main;

public class Partida {
    Tabuleiro tab = new Tabuleiro();

    public Partida(){

    }
    
    public boolean checaMovimento(int coluna, int index) {//TODO Verifica se peças podem ou não ser colocadas
    /*Se coluna escolhida não existir ou estiver cheia*/
        if(coluna < 1 || coluna > tab.getColunas() || tab.getMatrizPecas(0, coluna) != 0 ) {
            return false;
        } else {
            return true;
        }	
    }

    public String checaVitoria(int index) { //TODO verifica se após jogada alguém ganhou
        //for(int x = 0; x<this.linhas)
        return "Vitória";
    }

    public int alteraTab(int index, int coluna) {
    // TODO Alterar situação do tabuleiro (colocando index do jogador na posição escolhida)
        for (int x = 0; x < tab.getLinhas()-1; x++) {
            if (tab.getMatrizPecas(x+1, coluna-1) != 0) { // Verifica se a próxima casa da coluna tem alguma peça
                tab.setMatrizPecas(x, coluna-1, index);
                tab.imprimeMatriz();
                return 1;
            }
    }
        tab.setMatrizPecas(tab.getLinhas()-1, coluna-1, index);
        tab.imprimeMatriz();//Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna
        return 1;
    }
}
