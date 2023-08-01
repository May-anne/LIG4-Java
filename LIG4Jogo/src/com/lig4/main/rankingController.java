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
    
    private Label[] labels;


    public rankingController(){

    }

    @FXML
    public void initialize(){
        mostraRank();
    }

    public void mostraRank(){
        labels = new Label[]{lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab9,lab10};
        List<Pessoa> jogadores;

        rank.carregaRanking();
        jogadores = rank.getRanking();

        for(int x = 0; x<10;x++){

            if(x<jogadores.size()){
                labels[x].setText((x+1)+"º "+jogadores.get(x).getNome()+"----"+jogadores.get(x).getPontos());
            }else{
                labels[x].setText("");
            }
        }

    }

    @FXML
    protected void btVoltar(){
        MainClass.changeScreen("menu");
    }
    
    
}
