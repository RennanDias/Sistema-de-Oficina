package Controller;

import BO.ServiçoBO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalServiços {

	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaServiçoNome;
	@FXML private TextField insertPesquisaServiçoID;
	@FXML private ImageView retanguloBase;
	@FXML private ImageView logoAlterar;
	@FXML private ImageView logoDeletar;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Label r$;
	@FXML private Label preçoServiço;
	@FXML private Label nomeServiçoPesquisado;
	
	//Retângulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar serviços
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label addServiço;
	@FXML private TextField novoServiçoNome;
	@FXML private TextField novoServiçoPreço;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;
	
	//Componentes da tela alterar serviços
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarServiço;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField alterarServiçoNome;
	@FXML private TextField alterarServiçoPreço;
	
	//Componentes da tela deletar serviços
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoSairDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delServiço;
	@FXML private Label idNomeServiçoDel;
	@FXML private Label textDeletar;
	
	ServiçoBO sbo = new ServiçoBO();
	
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
	
	public void alterarParaAutomoveis(ActionEvent event) {
		try {
			Telas.telaPrincipalAutomoveis();
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
	
	public void alterarParaClientes(ActionEvent event) {
		try {
			Telas.telaPrincipalClientes();
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
