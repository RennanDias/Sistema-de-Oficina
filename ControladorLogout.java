package Controller;

import View.Telas;
import javafx.event.ActionEvent;

public class ControladorLogout {
	//Altera para a tela de login caso o botão confirmar seja pressionado
	public void alterarParaLogin(ActionEvent event) {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Volta para a tela inicial de clientes caso o botão cancelar seja pressionado
	public void alterarParaClientes(ActionEvent event) {
		try {
			Telas.telaPrincipalClientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
