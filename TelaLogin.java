package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaLogin extends Application {

	public static void main (String args[]) {
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("VE/telaLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("Sistema de Oficina");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
}
