package View;

import java.awt.Color;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Comandos extends Application{
	public static void main (String args[]) {
		launch();
	}

	public void start(Stage pS) throws Exception{
		Label msg = new Label();
		msg.setText("Famoso Hello World em JavaFX");
		Button botao = new Button("Ok");
		Image imageOk = new Image(getClass().getResourceAsStream("VE/ok.png"));
		Button botao2 = new Button("OK-Estiloso", new ImageView(imageOk));
		Button botao3 = new Button("Accept", new ImageView(imageOk));
		Font font = new Font("Cambria", 30);
		msg.setFont(font);
		//msg.setTextFill(Color.BLUE);
		
		HBox root = new HBox(); // Adiciona compontentes do root um ao lado do outro
		VBox root2 = new VBox(); // Adiciona os componentes do root um abaixo do outro
		BorderPane root3 = new BorderPane(); // Separa sua tela em regiões
		StackPane root4 = new StackPane();
		//TextFlow root5 = new TextFlow();
		AnchorPane root6 = new AnchorPane();
		TilePane root7 = new TilePane();
		GridPane root8 = new GridPane();
		FlowPane root9 = new FlowPane();
		
		root.getChildren().add(msg);
		root.getChildren().add(botao);
		root.getChildren().add(botao2);
		
		
	}
	
}
