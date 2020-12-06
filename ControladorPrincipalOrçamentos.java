package Controller;

import BO.OrçamentoBO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalOrçamentos {
	
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaOrçamentoPlaca;
	@FXML private TextField insertPesquisaOrçamentoID;
	@FXML private ImageView retanguloBase;
	@FXML private ImageView logoAlterar;
	@FXML private ImageView logoDeletar;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Label r$;
	@FXML private Label valorOrçamento;
	@FXML private Label prefData;
	@FXML private Label prefPlaca;
	@FXML private Label prefStatus;
	@FXML private Label statusOrçamentoPesquisado;
	@FXML private Label placaOrçamentoPesquisado;
	@FXML private Label dataOrçamentoPesquisado;
	@FXML private Label setupAutoOrçamentoPesquisado;
		
	//Retângulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar orçamento
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label valorTotalOrçamento;
	@FXML private Label addServiço;
	@FXML private Label addPeça;
	@FXML private Label addServiço2;
	@FXML private Label addPeça2;
	@FXML private Label addOrçamento;
	@FXML private TextField novoOrçamentoPlaca;
	@FXML private TextField novoOrçamentoData;
	@FXML private TextField novoOrçamentoServiçoNome;
	@FXML private TextField novoOrçamentoServiçoValor;
	@FXML private TextField novoOrçamentoPeçaNome;
	@FXML private TextField novoOrçamentoPeçaValor;
	@FXML private TextField novoAutoAno;
	@FXML private TextField novoAutoKm;
	@FXML private Button botaoAddServiçoOrçamento;
	@FXML private Button botaoAddPeçaOrçamento;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;	
	@FXML private CheckBox checarFinalizadoAdd;
	
	//Componentes da tela alterar orçamento
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarOrçamento;
	@FXML private Label alterarPeça;
	@FXML private Label alterarServiço;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField alterarOrçamentoPeçaValor;
	@FXML private TextField alterarOrçamentoServiçoValor;
	@FXML private TextField alterarOrçamentoPeçaNome;
	@FXML private TextField alterarOrçamentoServiçoNome;
	@FXML private TextField alterarOrçamentoData;
	@FXML private TextField alterarOrçamentoPlaca;
	@FXML private CheckBox checarFinalizado;
	
	//Componentes da tela deletar orçamento
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoFecharDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delOrçamento;
	@FXML private Label idPlacaOrçamentoDel;
	@FXML private Label textDeletar;
	@FXML private Label textDeletar2;

	OrçamentoBO obo = new OrçamentoBO();
	
	public void pesquisar(ActionEvent event) {
		
	}
	
	public void adicionar(ActionEvent event) {
		
	}
	
	public void alterar(ActionEvent event) {
		
	}
	
	public void deletar(ActionEvent event) {
		
	}
	
	public void somarValor(ActionEvent event) {
		
	}
	
	public void confirmarOrçamento(ActionEvent event) {
		
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
	
	public void alterarParaClientes(ActionEvent event) {
		try {
			Telas.telaPrincipalClientes();
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
