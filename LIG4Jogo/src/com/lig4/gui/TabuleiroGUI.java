package com.lig4.gui;

import java.util.Optional;

import com.lig4.jogadores.Pessoa;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class TabuleiroGUI {

    private final int linhaMax = 6;
    private final int colunaMax = 7;
    private int row, linhaAtual;
    private Pessoa jogador1, jogador2;

    public TabuleiroGUI(Pessoa jogador1, Pessoa jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;  
    }

    public abstract void alteraTabuleiro(GridPane gridPane,int col, Pessoa jogadorAtual);

    public void alteraTabGui(GridPane gridPane, int col, Pessoa jogadorAtual) {
        Circle circuloAtual;
        
        for(int i = 1; i<=6; i++){
            row = linhaMax - i;
            circuloAtual = getCirculo(gridPane, col - 1, row);

            if(circuloAtual.getFill().equals(Color.WHITE)){
                circuloAtual.setFill(jogadorAtual == jogador1 ? Color.RED : Color.YELLOW);
                setLinhaAtual(row);
                break;
            } else if(!circuloAtual.getFill().equals(Color.WHITE)){
                System.out.println("Espaço preenchido, passando pro próximo de cima");
                setLinhaAtual(row);
            }
        }

        if(checaVitoria(gridPane, jogadorAtual) == 1){
            mostrarVitoria(jogadorAtual);
            if(continuarJogando()){
                reiniciarTab(gridPane);
            }
        }
    }

    public void reiniciarTab(GridPane gridPane){
        Circle circuloAtual;
        for(int x = 0; x < colunaMax;x++){
            for(int y =0; y< linhaMax;y++){
                circuloAtual = getCirculo(gridPane, x, y);
                circuloAtual.setFill(Color.WHITE);
            }
        }
    }
    public boolean empate(GridPane gridPane){
        Circle circuloAtual;
        boolean cheio = true;
        for(int row = 0; row<linhaMax;row++){
            for(int col = 0; col<colunaMax;col++){
                circuloAtual = getCirculo(gridPane, col, row);
                if(circuloAtual.getFill().equals(Color.WHITE)){
                    cheio = false;
                }
            }
            if(!cheio)
                break;
        }

        if(cheio)
            return true;
        else
            return false;

    }
    public int checaVitoria(GridPane gridPane, Pessoa pessoa){
        char peca = pessoa.getCorPeca();
        Circle p1, p2, p3, p4;
        Color cor = Color.rgb(0, 0, 0);

        if(peca=='V')
           cor = Color.RED;
        else if(peca=='A')
           cor = Color.YELLOW;

        for(int row = 0; row<3;row++){//Verificação vertical
            for(int col = 0; col<=6;col++){
            
                p1 = getCirculo(gridPane, col, row);
                p2 = getCirculo(gridPane, col, row+1);
                p3 = getCirculo(gridPane, col, row+2);
                p4 = getCirculo(gridPane, col, row+3);
                
                if(p1 != null && p2 != null && p3 != null && p4 != null){
                    if(p1.getFill().equals(cor) && p2.getFill().equals(cor) && p3.getFill().equals(cor)&& p4.getFill().equals(cor)){
                        System.out.println("Alguem venceu");
                        return 1;
                    }
                }
             }
         }

          for(int row = 0; row<6;row++){//Verificação Horizontal
            for(int col = 0; col<4;col++){
                p1 = getCirculo(gridPane, col, row);
                p2 = getCirculo(gridPane, col+1, row);
                p3 = getCirculo(gridPane, col+2, row);
                p4 = getCirculo(gridPane, col+3, row);
            
                if(p1 != null && p2 != null && p3 != null && p4 != null){
                    if(p1.getFill().equals(cor) && p2.getFill().equals(cor) && p3.getFill().equals(cor)&& p4.getFill().equals(cor)){
                        System.out.println("Alguem venceu");
                        return 1;
                    }
                }
             }
         }

         for(int row = 0; row<3;row++){//Horizontal Baixo-Cima
            for(int col = 0; col<4;col++){
            
                p1 = getCirculo(gridPane, col, row);
                p2 = getCirculo(gridPane, col+1, row+1);
                p3 = getCirculo(gridPane, col+2, row+2);
                p4 = getCirculo(gridPane, col+3, row+3);
               
                if(p1 != null && p2 != null && p3 != null && p4 != null){
                    if(p1.getFill().equals(cor) && p2.getFill().equals(cor) && p3.getFill().equals(cor)&& p4.getFill().equals(cor)){
                        System.out.println("Alguem venceu");
                        return 1;
                    }
                }
             }
         }      
         for(int row = 0; row < 6;row++){//Horizontal Cima-Baixo
            for(int col = 0; col < 4;col++){
            
                 p1 = getCirculo(gridPane, col, row);
                 p2 = getCirculo(gridPane, col+1, row-1);
                 p3 = getCirculo(gridPane, col+2, row-2);
                 p4 = getCirculo(gridPane, col+3, row-3);
               
                if(p1 != null && p2 != null && p3 != null && p4 != null){
                    if(p1.getFill().equals(cor) && p2.getFill().equals(cor) && p3.getFill().equals(cor)&& p4.getFill().equals(cor)){
                        System.out.println("Alguem venceu");
                        return 1;
                    }
                }
            }
         }
        
        if(empate(gridPane)){
            mostrarEmpate();
            return 2;
        } else
            return 0;
    }

    public void setPeca(GridPane gridPane, int col, int row, Pessoa jogadorAtual){
        Circle circulo = getCirculo(gridPane, col, row);
        Color cor = jogadorAtual.equals(this.jogador1) ? Color.RED : Color.YELLOW;
        circulo.setFill(cor);
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

    public void mostrarVitoria(Pessoa vencedor){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Vitória");
        alert.setHeaderText(null);
        alert.setContentText(vencedor.getNome()+" venceu!");
        alert.showAndWait();
        return;
    }

    public void mostrarEmpate(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Empate");
        alert.setHeaderText(null);
        alert.setContentText("Houve um empate!");
        alert.showAndWait();
        return;   
    }

    public boolean continuarJogando(){
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Continuar jogando?");
    alert.setHeaderText("Deseja continuar jogando?");
    alert.setContentText("Clique OK para continuar ou Cancelar para sair.");

    ButtonType buttonOK = new ButtonType("OK");
    ButtonType buttonCancelar = new ButtonType("Cancelar");

    alert.getButtonTypes().setAll(buttonOK, buttonCancelar);

    Optional<ButtonType> result = alert.showAndWait();

    return result.orElse(ButtonType.CANCEL) == buttonOK;
    }

    public int getLinhas(){
        return this.linhaMax;
    }

    public int getColunas(){
        return this.colunaMax;
    }

    public int getLinhaAtual(){
        return linhaAtual;
    }

    public Pessoa getJogador1(){
        return this.jogador1;
    }

    public Pessoa getJogador2(){
        return this.jogador2;
    }

    public void setLinhaAtual(int linhaAtual){
        this.linhaAtual = linhaAtual;
    }

}
