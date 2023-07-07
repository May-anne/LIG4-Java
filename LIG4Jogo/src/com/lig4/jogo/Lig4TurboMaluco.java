package com.lig4.jogo;
import java.util.Random;

import com.lig4.base.Tabuleiro;
import com.lig4.jogadores.Pessoa;

public class Lig4TurboMaluco extends Jogo{
    
    private Tabuleiro tab; 
	private int linhaMax;
	private Pessoa jogador1, jogador2;

    public Lig4TurboMaluco(Pessoa jogador1, Pessoa jogador2){

        super(jogador1, jogador2); 

		this.tab = super.getTabuleiro();
		this.linhaMax = this.tab.getLinhas();
		this.jogador1 = super.getJogador1();
		this.jogador2 = super.getJogador2();

        super.loopJogo(this.jogador1);
    }
    
    @Override
    public void alteraTab(char corJogador, int coluna){
        for (int x = 0; x < this.tab.getLinhas()-1; x++) {

            if (this.tab.getMatrizPecas(x+1, coluna-1) != 0) {// Verifica se a próxima casa da coluna tem alguma peça
                  
                this.tab.setMatrizPecas(x, coluna-1, corJogador);
                 
                this.turboMalucoAltera(1, x, coluna, corJogador);
        
                this.tab.imprimeMatriz();    
                return;
            }   
        }
         
        this.tab.setMatrizPecas(this.tab.getLinhas()-1, coluna-1, corJogador);//Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna
        
        this.turboMalucoAltera(2, tab.getLinhas()-1, coluna, corJogador);
        
        this.tab.imprimeMatriz();

        System.out.println("Caso 2");
        return;
    }
    
    public void turboMalucoAltera(int tipo,int x, int coluna, char corJogador){
        Random random = new Random();
        boolean altera;
        int row, column;

        if(tipo==1){
            for(int k = 0; k < 3;k++){
                    for(int y = 0; y<3;y++){//Cliclos para percorrer todos os vizinhos
                        if(k==0){

                            row = x-1;
                            column = coluna - y;

                            altera = random.nextBoolean();//Boolean aleatório para decidir se troca ou não

                            if(altera && this.tab.getMatrizPecas(row, column) !=0){//Se o boolean for true e a peça vizinha não estiver vazia, a troca vai ocorrer
                            
                                try{

                                    this.tab.setMatrizPecas(row, column, corJogador);//Peças na linha de cima

                                }catch(IndexOutOfBoundsException e){//Verifica se a peça vizinha existe

                                    continue;

                                }

                            }else if(k==1){
                                
                                row = x;
                                column = coluna-y;

                                altera = random.nextBoolean();

                                if(altera && this.tab.getMatrizPecas(row, column)!=0){

                                    try{
                                        this.tab.setMatrizPecas(x, coluna-y, corJogador);//Peças na mesma linha
                                    }catch(IndexOutOfBoundsException e){
                                        continue;
                                    }

                                }

                            }else if(k==2){
                                
                                row = x+1;
                                column = coluna-y;

                                altera = random.nextBoolean();

                                if(altera && this.tab.getMatrizPecas(row, column)!=0){
                                    try{
                                        this.tab.setMatrizPecas(row, column, corJogador);//Peças na linha de baixo
                                    }catch(IndexOutOfBoundsException e){
                                        continue;
                                    }
                                }
                            }

                        }
                    }
                }

        }else if(tipo==2){

            for(int k = 0;k<2;k++){

                for(int y = 0;y<3;y++){//Nesse caso só há peças na mesma linha e em cima

                    if(k==0){
                        row = x;
                        column = coluna-y;
                        altera = random.nextBoolean();

                        if(altera && this.tab.getMatrizPecas(row, column)!=0){
                            try{

                                this.tab.setMatrizPecas(row, column, corJogador);//Mesma Linha

                            }catch(IndexOutOfBoundsException e){

                                continue;

                            }
                        }

                    }else{

                        row = x-1;
                        column = coluna-y;
                        altera = random.nextBoolean();

                        if(altera && this.tab.getMatrizPecas(row, column)!=0){

                            try{

                                this.tab.setMatrizPecas(row, column, corJogador);//Em cima

                            }catch(IndexOutOfBoundsException e){

                                continue;

                            }

                        }
                    }
                }

            }
        }
    }

    public void tarjaPreta(){

    }

    public void hospicio(){

    }
}


