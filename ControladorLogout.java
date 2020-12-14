package Controller;

import View.Telas;
import javafx.event.ActionEvent;

public class ControladorLogout {
	public void alterarParaLogin(ActionEvent event) {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarParaClientes(ActionEvent event) {
		try {
			Telas.telaPrincipalClientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
