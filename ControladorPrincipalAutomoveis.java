package Controller;

import BO.AutomovelBO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalAutomoveis {
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaAutoPlaca;
	@FXML private TextField insertPesquisaAutoCpfDono;
	@FXML private TextField insertPesquisaAutoID;
	@FXML private ImageView retanguloBase;
	@FXML private ImageView logoAlterar;
	@FXML private ImageView logoDeletar;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Label prefAno;
	@FXML private Label prefPlaca;
	@FXML private Label anoAutoPesquisado;
	@FXML private Label placaAutoPesquisado;
	@FXML private Label marcaModeloCor;
		
	//Retângulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar automoveis
	@FXML private Rectangle retanguloAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label dadosauto;
	@FXML private Label addAuto;
	@FXML private TextField novoAutoMarca;
	@FXML private TextField novoAutoModelo;
	@FXML private TextField novoAutoPlaca;
	@FXML private TextField novoAutoCor;
	@FXML private TextField novoAutoAno;
	@FXML private TextField novoAutoKm;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;	
	
	//Componentes da tela alterar automoveis
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarAuto;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField alterarAutoMarca;
	@FXML private TextField alterarAutoModelo;
	@FXML private TextField alterarAutoPlaca;
	@FXML private TextField alterarAutoCor;
	@FXML private TextField alterarAutoAno;
	@FXML private TextField alterarAutoKm;
	
	//Componentes da tela deletar automoveis
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoSairDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delAuto;
	@FXML private Label placaAutoDeletado;
	@FXML private Label textDeletar;	
	
	AutomovelBO abo = new AutomovelBO();
	
	public void pesquisar(ActionEvent event) {
		
	}
	
	public void adicionar(ActionEvent event) {
		
	}
	
	public void alterar(ActionEvent event) {
		
	}
	
	public void deletar(ActionEvent event) {
		
	}	
	
	public void abrirAbaAdicionar(ActionEvent event) {

	}
	
	public void fecharAbaAdicionar(ActionEvent event) {

	}

	public void abrirAbaAlterar(ActionEvent event) {

	}

	public void fecharAbaAlterar(ActionEvent event) {
	
	}
	
	public void abrirAbaDeletar(ActionEvent event) {

	}

	public void fecharAbaDeletar(ActionEvent event) {

	}
	
	public void alterarParaClientes(ActionEvent event) {
		try {
			Telas.telaPrincipalClientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarParaOrçamentos(ActionEvent event) {
		try {
			Telas.telaPrincipalOrçamentos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarParaServiços(ActionEvent event) {
		try {
			Telas.telaPrincipalServiços();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarParaPeças(ActionEvent event) {
		try {
			Telas.telaPrincipalPeças();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarParaRelatorios(ActionEvent event) {
		try {
			Telas.telaGerarRelatorios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
