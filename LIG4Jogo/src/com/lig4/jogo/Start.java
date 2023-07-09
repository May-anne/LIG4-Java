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

        Peca peca1 = new Peca('A');
        Peca peca2 = new Peca('V');

        try { //Meio inútil
            peca1.setCor('A');
            peca2.setCor('G');
        } catch (AtributoInvalidoException e) {
            System.out.println("Erro. "+e.getMessage());
        }

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

                exibirNiveis();
                getOpcao(lerOpcao());

                switch(this.escolha){
                case 0:
                    new Lig4TurboMaluco(jogador1, jogador2,0);
                    break;
                case 1:
                    new Lig4TurboMaluco(jogador1, jogador2,1);
                    break;
                case 2:
                    new Lig4TurboMaluco(jogador1, jogador2,2);
                    break;
                }
                break;
            default:
                System.err.println("Opção inválida.");
                break;
        }
    }

    public void exibirNiveis(){
        System.out.println("Escolha o nível de maluquice: ");
        System.out.println("0. Loucura");
        System.out.println("1. Insanidade");
        System.out.println("2. Hospício");
    }
}
