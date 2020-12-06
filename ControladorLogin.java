package Controller;

import BO.FuncionárioBO;
import VO.FuncionárioVO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorLogin {
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Label erroLogin;
	
	FuncionárioBO funcBO = new FuncionárioBO();
	
	public void fazerLogin(ActionEvent event) {
		FuncionárioVO func = new FuncionárioVO();
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