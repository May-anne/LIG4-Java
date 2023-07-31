package com.lig4.main;

import java.util.ArrayList;
import java.util.List;

import com.lig4.jogadores.Pessoa;
import com.lig4.jogadores.Ranking;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class rankingController {
    private Ranking rank = new Ranking();

    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
    @FXML
    private Label lab3;
    @FXML
    private Label lab4;
    @FXML
    private Label lab5;
    @FXML
    private Label lab6;
    @FXML
    private Label lab7;
    @FXML
    private Label lab8;
    @FXML
    private Label lab9;
    @FXML
    private Label lab10;
    
    @FXML
    private List<Label> listaLabel = new ArrayList<>();
    

    public rankingController(){

        listaLabel.add(lab1);
        listaLabel.add(lab2);
        listaLabel.add(lab3);
        listaLabel.add(lab4);
        listaLabel.add(lab5);
        listaLabel.add(lab6);
        listaLabel.add(lab7);
        listaLabel.add(lab8);
        listaLabel.add(lab9);
        listaLabel.add(lab10);


    }

    @FXML
    public void initialize(){
        mostraRank();
    }
    public void mostraRank(){
        List<Pessoa> jogadores;
        int tam = rank.getRanking().size();
        rank.carregaRanking();
        lab1.setText(rank.getRanking().get(0).getNome());
        
        for(int x = 0; x<10;x++){
            if(x<(rank.getRanking().size())){
                //listaLabel.get(x).setText(rank.getRanking().get(x).getNome() + "------" + Integer.toString(rank.getRanking().get(x).getPontos()));
            }else{
                //listaLabel.get(x).setText("");
            }
        
         }

    }
    
    
}
