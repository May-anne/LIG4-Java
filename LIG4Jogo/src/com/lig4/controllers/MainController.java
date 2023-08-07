package com.lig4.controllers;

import com.lig4.main.MainClass;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    protected void btIniciarAction(){
        MainClass.changeScreen("modoJogo");
    }

    @FXML
    protected void btRankingAction(){
        MainClass.changeScreen("ranking");
    }
    
    @FXML
    protected void btSairAction(){
        MainClass.changeScreen("sair");
    }
    
}
