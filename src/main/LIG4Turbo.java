package main;

public class LIG4Turbo extends Partida{
    Tabuleiro tab;
    public LIG4Turbo(){ 
        tab = new Tabuleiro();
    }


    @Override
    public int alteraTab(int index, int coluna){
        super.alteraTab(index, coluna);

        for(int y1 = 0, y2 = 1; y1 < tab.getColunas()-1 && y2 < tab.getColunas(); y1++, y2++){
            if(tab.getMatrizPecas(tab.getLinhas()-1, y1+1) != 0){
                System.out.println("Posterior");
                tab.setMatrizPecas(tab.getLinhas()-1, y1+1, index);
                return 1;
            }
            if(tab.getMatrizPecas(tab.getLinhas()-1, y2-1) != 0){
                System.out.println("Anterior");
                tab.setMatrizPecas(tab.getLinhas()-1, y2-1, index);
                return 1;
                
            }
        }
        System.out.println("Fim");
        return 1;

    }
}
