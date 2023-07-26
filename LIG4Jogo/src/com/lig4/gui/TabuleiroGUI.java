package com.lig4.gui;

import com.lig4.jogadores.Pessoa;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TabuleiroGUI {
    private final int linhaMax = 6;
    private final int colunaMax = 7;
    private int row;
    private Pessoa jogadorAtual, jogador1, jogador2;

    public TabuleiroGUI(Pessoa jogador1, Pessoa jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        
    }

    public void alteraTabGui(GridPane gridPane, int col,int player) {
        Circle circuloAtual;
        if(player == 1){
            jogadorAtual = jogador1;
        }else{
            jogadorAtual = jogador2;
        }

        System.out.println(row);
        for(int i = 1; i<=6; i++){
            row = linhaMax - i;

            circuloAtual = getCirculo(gridPane, col - 1, row);

            if(circuloAtual.getFill().equals(Color.WHITE)){

                circuloAtual.setFill(player == 1 ? Color.RED : Color.YELLOW);
                break;

            } else if(!circuloAtual.getFill().equals(Color.WHITE)){
                System.out.println("Espaço preenchido, passando pro próximo de cima");
            }
        }
        
    
       
    }
    
    public boolean checaVitoria(){
        return false;
    }
    public Circle getCirculo(GridPane gridPane, int col, int row) {

        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                if (node instanceof StackPane) {
                    StackPane stackPane = (StackPane) node;
                    for (Node childNode : stackPane.getChildren()) {
                        if (childNode instanceof Circle) {
                            return (Circle) childNode;
                        }
                    }
                }
            }
        }
        return null;
    }
}
