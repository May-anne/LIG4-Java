package com.lig4.main;

import com.lig4.jogo.Start;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainClass extends Application {	
	private static Stage stage;
	private static Scene menu, tabuleiro, modoJogo, turboMaluco, nomes;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Image logoImage = new Image(getClass().getResourceAsStream("../view/logo.png"));
        primaryStage.getIcons().add(logoImage);
		
		// TODO Auto-generated method stub
		stage.setTitle("LIG4");
       
		Parent fxmlMenu = FXMLLoader.load(getClass().getResource("../view/view.fxml"));
		menu = new Scene(fxmlMenu, 800, 550);
		
		Parent fxmlModoJogo = FXMLLoader.load(getClass().getResource("../view/modo_jogo.fxml"));
		modoJogo = new Scene(fxmlModoJogo, 800, 550);

		Parent fxmlNomes = FXMLLoader.load(getClass().getResource("../view/nomes.fxml"));
		nomes = new Scene(fxmlNomes, 800, 550);

		Parent fxmlTurboMaluco = FXMLLoader.load(getClass().getResource("../view/turbo_maluco.fxml"));
		turboMaluco = new Scene(fxmlTurboMaluco, 800, 550);

		Parent fxmlTabuleiro = FXMLLoader.load(getClass().getResource("../view/tabuleiro.fxml"));
		tabuleiro = new Scene(fxmlTabuleiro, 800, 550);
      
	
        stage.setScene(menu);
        stage.show();
	}

	public static void changeScreen(String src){
		if(src.equals("modoJogo")){
			stage.setScene(modoJogo);
		}else if(src.equals("turboMaluco")){
			stage.setScene(turboMaluco);
		}else if(src.equals("nomes")){
            stage.setScene(nomes);
		}else if(src.equals("tabuleiro")){
			stage.setScene(tabuleiro);
		}else if(src.equals("sair")){
			Platform.exit();
			System.exit(0);
		}else if(src.equals("sair")){
			stage.setScene(menu);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Start();
		launch(args);
	}

}
