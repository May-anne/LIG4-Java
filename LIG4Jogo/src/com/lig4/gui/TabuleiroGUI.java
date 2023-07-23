package com.lig4.gui;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TabuleiroGUI {
    private final int linhaMax = 6;
    private final int colunaMax = 7;

    public void alteraTabGui(GridPane gridPane, int col) {
        for (int row = linhaMax - 1; row > 0; row--) {
            Circle circuloAtual = getCirculo(gridPane, col-1, row);
            Circle circuloProximo = getCirculo(gridPane, col-1, row + 1);

            if (circuloAtual != null && circuloProximo != null && circuloProximo.getFill() != Color.WHITE) {
                System.out.println("1");
                circuloAtual.setFill(Color.RED);
                break;
            } else if (circuloAtual != null) {
                System.out.println("2");
                circuloAtual.setFill(Color.BLUE);
                break;
            } else{
                System.out.println("3");
                break;
            }
        }
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
