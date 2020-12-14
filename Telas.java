package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage primaryStage;
	
	public static void main (String args[]) {
		launch();
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Oficina Simas Turbo");
		primaryStage.show();
		telaLogin();
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaLogout() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogout.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	
	public static void telaPrincipalClientes() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaClientes.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaPrincipalAutomoveis() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalAutomoveis.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaPrincipalPeças() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalPeças.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaPrincipalServiços() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalServiços.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaPrincipalOrçamentos() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaPrincipalOrçamentos.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaGerarRelatorios() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerarRelatorios.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);		
	}
	
}
