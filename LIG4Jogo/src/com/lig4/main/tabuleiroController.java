package com.lig4.main;

import com.lig4.gui.TabuleiroGUI;
import com.lig4.jogadores.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class tabuleiroController {
    private String idBotaoClicado;
    private TabuleiroGUI tabGui;
    private int col;
    protected Pessoa jogadorAtual, jogador1, jogador2;
    private char peca1, peca2;


    @FXML
    private GridPane grid = new GridPane();

    @FXML
    private Text nomeJogador1;

    @FXML
    private Text nomeJogador2;

    @FXML
    private Text vez1;

    @FXML
    private Text vez2;

    @FXML
    protected void btColorir(MouseEvent event){
        Button botaoEntrar = (Button) event.getSource();
        botaoEntrar.setOpacity(0.48);
    }

    @FXML
    protected void btDescolorir(MouseEvent event){
        Button botaoSair = (Button) event.getSource();
        botaoSair.setOpacity(0);
    }

    @FXML
    protected void btEscolherColuna(MouseEvent event) {
        Button botaoClicado = (Button) event.getSource();
        idBotaoClicado = botaoClicado.getId();

        tabGui = new TabuleiroGUI(this.jogador1, this.jogador2);
        col = obterColuna();

        if(jogadorAtual == null || jogadorAtual != jogador1){
            jogadorAtual = jogador1;
            vez1.setOpacity(0);
            vez2.setOpacity(1);
        } else {
            jogadorAtual = jogador2;
            vez1.setOpacity(1);
            vez2.setOpacity(0);  
        }
        tabGui.alteraTabGui(grid, col, jogadorAtual);
        boolean vit = tabGui.checaVitoria(grid, jogador1);
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

    public void setJogador1(Pessoa jogador1){
        this.jogador1 = jogador1;
    }

    public void setJogador2(Pessoa jogador2){
        this.jogador2 = jogador2;
    }

    public void mostrarNome1(String nome){
        nomeJogador1.setText(nome);
    }

    public void mostrarNome2(String nome){
        nomeJogador2.setText(nome);
    }

}
