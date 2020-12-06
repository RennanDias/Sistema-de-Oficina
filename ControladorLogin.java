package Controller;

import BO.Funcion�rioBO;
import VO.Funcion�rioVO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorLogin {
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Label erroLogin;
	
	Funcion�rioBO funcBO = new Funcion�rioBO();
	
	public void fazerLogin(ActionEvent event) {
		Funcion�rioVO func = new Funcion�rioVO();
		func.setUsuario(login.getText());
		func.setSenha(senha.getText());
		
		if(funcBO.fazerLogin(func)) {
			try {
				Telas.telaPrincipalClientes();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			erroLogin.setText("Login e/ou Senha incorreto(s)!");
			erroLogin.setVisible(true);
		}
	}
	
}