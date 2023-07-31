package com.lig4.main;

import javafx.fxml.FXML;

public class MainController {

    @FXML
    protected void btIniciarAction(){
        MainClass.changeScreen("modoJogo");
    }

    @FXML
    protected void btSairAction(){
        MainClass.changeScreen("sair");
    }
    
}
//as