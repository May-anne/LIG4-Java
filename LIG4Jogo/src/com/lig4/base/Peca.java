package com.lig4.base;

import com.lig4.exception.AtributoInvalidoException;

public class Peca {
    private char cor;

    public Peca(char cor){
        this.cor = cor;
    }

    public char getCor(){
        return cor;
    }

    public void setCor(char cor) throws AtributoInvalidoException{
        String str = Character.toString(cor);
        if(str.length() != 1){
            throw new AtributoInvalidoException("Cor inválida.");
        }
        this.cor = cor;
    }


}
