package com.lig4.main;

import javafx.fxml.FXML;

public class modoJogoController {
    @FXML
    protected void btTurboMalucoAction(){
        MainClass.changeScreen("turboMaluco");
    }

    @FXML
    protected void btClassico(){
        MainClass.changeScreen("nomes");
    }

    @FXML
    protected void btTurbo(){
        MainClass.changeScreen("nomes");
    }
}
