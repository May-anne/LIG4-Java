package main;
import java.util.Random;

public class Lig4TurboMaluco extends Partida {
      
    

    public int alteraTab(int index, int coluna){
        Random random = new Random();
        boolean altera;
        int row, column;

        for (int x = 0; x < tab.getLinhas()-1; x++) {

            if (tab.getMatrizPecas(x+1, coluna-1) != 0) { // Verifica se a próxima casa da coluna tem alguma peça
                tab.setMatrizPecas(x, coluna-1, index);

                for(int k = 0; k < 3;k++){
                    for(int y = 0; y<3;y++){//Cliclos para percorrer todos os vizinhos
                        if(k==0){

                            row = x-1;
                            column = coluna - y;

                            altera = random.nextBoolean();//Boolean aleatório para decidir se troca ou não

                            if(altera && tab.getMatrizPecas(row, column) !=0){
                            
                                try{

                                tab.setMatrizPecas(row, column , index);//Peças na linha de cima

                                }catch(IndexOutOfBoundsException e){//Verifica se a peça vizinha existe

                                continue;

                                }

                            }else if(k==1){
                                
                                row = x;
                                column = coluna-y;

                                altera = random.nextBoolean();

                                if(altera && tab.getMatrizPecas(row, column)!=0){

                                    try{
                                        tab.setMatrizPecas(x, coluna-y, index);//Peças na mesma linha
                                    }catch(IndexOutOfBoundsException e){
                                        continue;
                                    }

                                }

                            }else if(k==2){
                                
                                row = x+1;
                                column = coluna-y;

                                altera = random.nextBoolean();

                                if(altera && tab.getMatrizPecas(row, column)!=0)
                                try{
                                    tab.setMatrizPecas(row, column, index);//Peças na linha de baixo
                                }catch(IndexOutOfBoundsException e){
                                    continue;
                                }

                            }

                        }
                    }
                }

                tab.imprimeMatriz();
                    
                return 1;
            }   
    }

        tab.setMatrizPecas(tab.getLinhas()-1, coluna-1, index);//Se não tiver nenhuma peça na coluna, a peça vai ficar na última linha da coluna

        for(int k = 0;k<2;k++){

            for(int y = 0;y<3;y++){//Nesse caso só há peças na mesma linha e em cima

                if(k==0){
                    row = tab.getLinhas()-1;
                    column = coluna-y;
                    altera = random.nextBoolean();

                    if(altera && tab.getMatrizPecas(row, column)!=0){
                        try{

                            tab.setMatrizPecas(row, column, index);//Mesma Linha

                        }catch(IndexOutOfBoundsException e){

                            continue;

                    }}

                }else{
                    
                    row = tab.getLinhas()-2;
                    column = coluna-y;
                    altera = random.nextBoolean();

                    if(altera && tab.getMatrizPecas(row, column)!=0){

                    try{

                        tab.setMatrizPecas(row, column, index);//Em cima

                    }catch(IndexOutOfBoundsException e){

                        continue;

                    }

                }
            }
        }

    }

        tab.imprimeMatriz();
        System.out.println("Caso 2");
        return 1;
    
    
    }

}


