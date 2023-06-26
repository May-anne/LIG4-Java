package main;

public class Menu {
    private String modoJogo;

    public void exibirMenu(){
        //Exemplo:
        System.out.println("****** MENU ******");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1. Um jogador");
        System.out.println("2. Dois jogadores");
    }

    public String lerOpcao(){
        return modoJogo;
    }

    public boolean validarOpcao(String opcao){
        return opcao.equals("1") || opcao.equals("2");
    }

    public void iniciarJogo(){
        
    }
}
