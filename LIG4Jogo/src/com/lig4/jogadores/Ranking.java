package com.lig4.jogadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {

    private List<Pessoa> ranking;
    private static final String FILE = "ranking.txt";

    public Ranking(){
        ranking = new ArrayList<>();
    }

    public void addJogador(Pessoa jogador){
        ranking.add(jogador);
        Collections.sort(ranking, (x,y) -> Integer.compare(y.getPontos(),x.getPontos()));
        salvarRanking();
    }

    public void salvarRanking(){
         try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE))) {
            outputStream.writeObject(ranking);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregaRanking(){
        File file = new File(FILE);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                ranking = (List<Pessoa>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo do ranking está vazio ou não existe.");
        }

    }
    public List<Pessoa> getRanking(){
        return ranking;
    }

}
