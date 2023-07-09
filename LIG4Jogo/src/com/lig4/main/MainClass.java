package com.lig4.main;

import com.lig4.jogo.Start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start();
		//launch(args);
	}

	/*@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = fxmlloader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("LIG4");
        primaryStage.setScene(tela);
        primaryStage.show();
	}*/

}
