package com.lig4.jogo;

public class LIG4Turbo extends Partida{
    public LIG4Turbo(){ 

    }

    @Override
    public int alteraTab(int index, int coluna){
        super.alteraTab(index, coluna);

        if(coluna < tab.getColunas()){
            if(tab.getMatrizPecas(tab.getLinhaAtual(), coluna) != 0){
                tab.setMatrizPecas(tab.getLinhaAtual(), coluna, index);
                tab.imprimeMatriz();
            }
        }

        if(coluna > 1){
            if(tab.getMatrizPecas(tab.getLinhaAtual(), coluna-2) != 0){
                tab.setMatrizPecas(tab.getLinhaAtual(), coluna-2, index);
                tab.imprimeMatriz();
            }      
        }

        return 1;
    }
}
