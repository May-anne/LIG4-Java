package com.lig4.jogo;

import java.util.Scanner;
import com.lig4.jogadores.Pessoa;

public class Start {
    private int escolha;
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

    public String obterNomeJogador(int index){
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do jogador "+index+": ");
        String nomeJogador = sc.nextLine();

        return nomeJogador;
    }
    
    public void getOpcao(int escolha){
        this.escolha = escolha;
    }

    public int lerOpcao(){
        //return escolha;
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        return opcao;
    }

    public void iniciarJogo(){
        exibirQtdJogadores();
        getOpcao(lerOpcao());

        switch(this.escolha){
            case 1:
                jogador1 = new Pessoa(obterNomeJogador(1), 1);
                jogador2 = new Pessoa("Computador", 2);
                break;
            case 2:
                jogador1 = new Pessoa(obterNomeJogador(1), 1);
                jogador2 = new Pessoa(obterNomeJogador(2), 2);
                break;
            default:
                System.err.println("Número inválido.");
                break;
        }

        exibirMenu();
        getOpcao(lerOpcao());

        switch(this.escolha){
            case 1:
                new Classico(jogador1, jogador2);
                break;
            case 2:
                new LIG4Turbo(jogador1, jogador2);
                break;
            case 3:
                new Lig4TurboMaluco(jogador1, jogador2);
                break;
            default:
                System.err.println("Opção inválida.");
                break;
        }
    }
}
