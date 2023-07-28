package com.lig4.jogo;

import java.util.Scanner;
import com.lig4.jogadores.Pessoa;
import com.lig4.base.Peca;
import com.lig4.exception.AtributoInvalidoException;

public class Start {
    private int escolha;
    private int index = 1;
    private Pessoa jogador1, jogador2;

    public Start(){
        iniciarJogo();
    }

    public void exibirMenu(){
        //Exemplo:
        System.out.println("****** MENU ******");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1. Clássico");
        System.out.println("2. LIG4 Turbo");
        System.out.println("3. LIG4 Turbo Maluco");
    }

    public void exibirQtdJogadores(){
        //Exemplo
        System.out.println("Escolha a quantidade de jogadores: ");
        System.out.println("1. Um jogador");
        System.out.println("2. Dois jogadores");
    }

    public void exibirNivelTurboMaluco(){
        System.out.println("Escolha o nível do Turbo Maluco ");
        System.out.println("1. Dor de cabeça");
        System.out.println("2. Tarja Preta");
        System.out.println("3. Hospício");
    }

    public String obterNomeJogador(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do jogador "+index+": ");
        String nomeJogador = sc.nextLine();
        index++;

        return nomeJogador;
    }
    
    public void setOpcao(int escolha) throws AtributoInvalidoException{
        if(escolha < 1 || escolha > 3){
            throw new AtributoInvalidoException("Opção inválida.");
        }
        this.escolha = escolha;
    }

    public int lerOpcao(){
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        return opcao;
    }

    public void iniciarJogo(){
        exibirQtdJogadores();
        char peca1 = 'V';
        char peca2 = 'A';

        try{
            setOpcao(lerOpcao());

            switch(this.escolha){
            case 1:
                jogador1 = new Pessoa(obterNomeJogador(), peca1);
                jogador2 = new Pessoa("Computador", peca2);
                break;
            case 2:
                jogador1 = new Pessoa(obterNomeJogador(), peca1);
                jogador2 = new Pessoa(obterNomeJogador(), peca2);
                break;
            default:
                System.err.println("Opção inválida.");
                iniciarJogo();
                break;
        }
        }catch(AtributoInvalidoException e){
            System.out.println("Erro. "+e.getMessage());
            iniciarJogo();
        }

        try {
            peca1.setCor('A');
            peca2.setCor('V');
        } catch (AtributoInvalidoException e) {
            System.out.println("Erro. "+e.getMessage());
        }

        exibirMenu();

        try{
            setOpcao(lerOpcao());
            switch(this.escolha){
                case 1:
                    new Classico(jogador1, jogador2);
                    break;
                case 2:
                    new LIG4Turbo(jogador1, jogador2);
                    break;
                case 3:
                    exibirNivelTurboMaluco();
                    try{
                        setOpcao(lerOpcao());
                        switch(this.escolha){
                        case 1:
                            new Lig4TurboMaluco(jogador1, jogador2,1);
                            break;
                        case 2:
                            new Lig4TurboMaluco(jogador1, jogador2,2);
                            break;
                        case 3:
                            new Lig4TurboMaluco(jogador1, jogador2,3);
                            break;
                        default:
                            break;
                        }
                    }catch(AtributoInvalidoException e){
                        System.out.println("Erro. "+e.getMessage());
                        iniciarJogo();
                    }
                default:
                    break;
            }
        }
        catch(AtributoInvalidoException e){
            System.out.println("Erro. "+e.getMessage());
            iniciarJogo();
        }
    }
}
