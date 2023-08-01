package com.lig4.controllers;

import java.util.Optional;
import com.lig4.gui.ClassicoGUI;
import com.lig4.gui.TurboGUI;
import com.lig4.gui.TurboMalucoGui;
import com.lig4.jogadores.Pessoa;
import com.lig4.jogadores.Ranking;
import com.lig4.main.MainClass;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class tabuleiroController {
    private String idBotaoClicado;
    private int col, modo;
    protected Pessoa jogadorAtual, jogador1, jogador2;
    private Ranking rank = new Ranking();

    @FXML
    private GridPane grid = new GridPane();

    @FXML
    private Label nomeJogador1;

    @FXML
    private Label nomeJogador2;

    @FXML
    private Text vez1;

    @FXML
    private Text vez2;

    @FXML
    private Label labelModo;

    @FXML
    private Label labelPontos1;

    @FXML
    private Label labelPontos2;

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
    protected void btVoltar(){
        if(escolherVoltar()){
            
            rank.carregaRanking();
            rank.addJogador(jogador1);
            rank.addJogador(jogador2);
            rank.salvarRanking();
            MainClass.changeScreen("menu");
        }
    }

    @FXML
    protected void btEscolherColuna(MouseEvent event) {
        Button botaoClicado = (Button) event.getSource();
        idBotaoClicado = botaoClicado.getId();

        if(jogadorAtual == null)
            jogadorAtual = jogador1;

        col = obterColuna();

        if(modo == 1){
            ClassicoGUI jogo = new ClassicoGUI(this.jogador1, this.jogador2);
            jogo.alteraTabuleiro(grid, col, jogadorAtual);
            mostrarPontos(jogador1, jogador2);
        }else if(modo == 3 || modo == 4 || modo == 5){
            TurboMalucoGui jogo = new TurboMalucoGui(jogador1, jogador2, modo);
            jogo.alteraTabuleiro(grid, col, jogadorAtual);
            mostrarPontos(jogador1, jogador2);
        }else if(modo == 2){
            TurboGUI jogo = new TurboGUI(jogador1, jogador2);
            jogo.alteraTabuleiro(grid, col, jogadorAtual);
            mostrarPontos(jogador1, jogador2);
        }

        if(jogadorAtual == jogador1){
            jogadorAtual = jogador2;
            vez1.setOpacity(0);
            vez2.setOpacity(1);
        } else {
            jogadorAtual = jogador1;
            vez1.setOpacity(1);
            vez2.setOpacity(0);  
        }
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

    public void obterModo(int modo){
        this.modo = modo;
    }

    public void mostrarModo(String modo){
        labelModo.setText(modo);
    }

    public void mostrarPontos(Pessoa jogador1, Pessoa jogador2){
        labelPontos1.setText(Integer.toString(jogador1.getPontos()));
        labelPontos2.setText(Integer.toString(jogador2.getPontos()));
    }

    public boolean escolherVoltar(){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText("Deseja parar de jogar?");
        alert.setContentText("Clique Sim para sair ou Não para continuar jogando.");

        ButtonType buttonOK = new ButtonType("Sim");
        ButtonType buttonCancelar = new ButtonType("Não");

        alert.getButtonTypes().setAll(buttonOK, buttonCancelar);

        Optional<ButtonType> result = alert.showAndWait();

        return result.orElse(ButtonType.CANCEL) == buttonOK;
    }

}
