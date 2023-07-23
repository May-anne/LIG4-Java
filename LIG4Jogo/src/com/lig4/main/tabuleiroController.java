package com.lig4.main;

import com.lig4.gui.TabuleiroGUI;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class tabuleiroController {
    private String idBotaoClicado;
    private TabuleiroGUI tabGui = new TabuleiroGUI();
    private int col;

    @FXML
    private GridPane grid = new GridPane();

    @FXML
    protected void btEscolherColuna(MouseEvent event) {
        Button botaoClicado = (Button) event.getSource();
        idBotaoClicado = botaoClicado.getId();
        
        col = obterColuna();
        tabGui.alteraTabGui(grid, col);
    }

    public int obterColuna(){
        if(idBotaoClicado.equals("button1"))
            return 1;
        else if(idBotaoClicado.equals("button2"))
            return 2;
        else if(idBotaoClicado.equals("button3"))
            return 3;
        else if(idBotaoClicado.equals("button4"))
            return 4;
        else if(idBotaoClicado.equals("button5"))
            return 5;
        else if(idBotaoClicado.equals("button6"))
            return 6;
        else if(idBotaoClicado.equals("button7"))
            return 7;
        else
            return 0;
    }

    public GridPane getGrid(){
        return grid;
    }

}
