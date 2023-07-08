package com.lig4.base;

import com.lig4.exception.AtributoInvalidoException;

public interface InterfaceTabuleiro {
    
    public void imprimeMatriz();

    public int getColunas();

    public int getLinhas();

    public void setLinhaAtual(int linAtual);

    public int getLinhaAtual();
		
    public int getMatrizPecas(int linhas, int colunas);

    public void setMatrizPecas(int linha, int coluna, char corJogador) throws AtributoInvalidoException;

}
