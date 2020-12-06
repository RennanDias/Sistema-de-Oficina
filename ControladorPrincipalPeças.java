package Controller;

import BO.PeçaBO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalPeças {

	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaPeçaNome;
	@FXML private TextField insertPesquisaPeçaFabricante;
	@FXML private TextField insertPesquisaPeçaID;
	@FXML private ImageView retanguloBase;
	@FXML private ImageView logoAlterar;
	@FXML private ImageView logoDeletar;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Label prefFabricante;
	@FXML private Label r$;
	@FXML private Label fabricantePeçaPesquisada;
	@FXML private Label preçoPeça;
	@FXML private Label nomePeçaPesquisada;
	
	//Retângulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar peças
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label addPeça;
	@FXML private TextField novoPeçaNome;
	@FXML private TextField novoPeçaFabricante;
	@FXML private TextField novoPeçaPreço;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;
	
	//Componentes da tela alterar peças
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarPeça;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField alterarPeçaNome;
	@FXML private TextField alterarPeçaFabricante;
	@FXML private TextField alterarPeçaPreço;
	
	//Componentes da tela deletar peças
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoSairDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delPeça;
	@FXML private Label idNomePeçaDel;
	@FXML private Label textDeletar;
	
	PeçaBO pbo = new PeçaBO();
	
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
	
	public void alterarParaServiços(ActionEvent event) {
		try {
			Telas.telaPrincipalServiços();
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
	
	public void alterarParaRelatorios(ActionEvent event) {
		try {
			Telas.telaGerarRelatorios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
