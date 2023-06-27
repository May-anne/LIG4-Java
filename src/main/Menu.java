package main;

public class Menu {
    private int modoJogo;

    public void exibirMenu(){
        //Exemplo:
        System.out.println("****** MENU ******");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1. Clássico");
        System.out.println("2. LIG4 Turbo");
    }
    
    public void getOpcao(int modoJogo){
        this.modoJogo = modoJogo;
        System.out.println("Opção escolhida: "+modoJogo);
    }

    public int lerOpcao(){
        return modoJogo;
    }

    public boolean validarOpcao(String opcao){
        return opcao.equals("1") || opcao.equals("2");
    }

    public void iniciarJogo(){
        
    }
}
