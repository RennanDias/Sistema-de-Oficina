package Controller;

import BO.PeçaBO;
import VO.PeçaVO;
import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalPeças {

	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaPeçaNome;
	@FXML private TextField insertPesquisaPeçaFabricante;
	@FXML private TextField insertPesquisaPeçaID;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
	
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
	
	//Componentes de operação com êxito
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarPeças;
	@FXML private Label labelExit;
	
	//Elementos da tabela peças
	@FXML private TableView <PeçaVO> tabelaPeças;
	@FXML private TableColumn <PeçaVO, Long> idPeça;
	@FXML private TableColumn <PeçaVO, String> nomePeça;
	@FXML private TableColumn <PeçaVO, String> fabricantePeça;
	@FXML private TableColumn <PeçaVO, Float> valorPeça;
	
	PeçaBO pbo = new PeçaBO();
	
	//Instancia a lista de peças
	ObservableList<PeçaVO> peças = FXCollections.observableArrayList(
			peças = pbo.listar()
	);
	
	//Inicializa a tabela com os valores presentes na lista de peças
	public void initialize() {
		
		idPeça.setCellValueFactory(new PropertyValueFactory<PeçaVO, Long>("id"));
		nomePeça.setCellValueFactory(new PropertyValueFactory<PeçaVO, String>("nome"));
		fabricantePeça.setCellValueFactory(new PropertyValueFactory<PeçaVO, String>("fabricante"));
		valorPeça.setCellValueFactory(new PropertyValueFactory<PeçaVO, Float>("valor"));
			
		tabelaPeças.setItems(peças);
		
	}
	
	//Função para pesquisar peças
	public void pesquisar(ActionEvent event) {
		PeçaVO p =  new PeçaVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaPeçaNome.getText().length() >= 1) {
			p.setNome(insertPesquisaPeçaNome.getText());
		}
		else {
			p.setNome("a");
		}
		
		if (insertPesquisaPeçaFabricante.getText().length() >= 1) {
			p.setFabricante(insertPesquisaPeçaFabricante.getText());
		}
		else {
			p.setFabricante("a");
		}
		
		if (insertPesquisaPeçaID.getText().length() >= 1) {
			p.setId(Long.parseLong(insertPesquisaPeçaID.getText()));
		}
		else {
			p.setId((long) 0);
		}
		
		peças = pbo.pesquisar(p);		
		tabelaPeças.setItems(peças);

		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);
		
	}
	
	//Função para adicionar peças
	public void adicionar(ActionEvent event) {
		PeçaVO p =  new PeçaVO();
		
		//Coloca os valores digitados na interface em um objeto para que seja adicionado
		p.setNome(novoPeçaNome.getText());
		p.setFabricante(novoPeçaFabricante.getText());
		p.setValor(Float.parseFloat(novoPeçaPreço.getText()));
		
		pbo.adicionar(p);
		
		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarPeças.setVisible(true);
	}
	
	//Função que altera uma peça
	public void alterar(ActionEvent event) {
		PeçaVO p =  new PeçaVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaPeçaNome.getText().length() >= 1) {
			p.setNome(insertPesquisaPeçaNome.getText());
		}
		else {
			p.setNome("a");
		}
		
		if (insertPesquisaPeçaFabricante.getText().length() >= 1) {
			p.setFabricante(insertPesquisaPeçaFabricante.getText());
		}
		else {
			p.setFabricante("a");
		}
		
		if (insertPesquisaPeçaID.getText().length() >= 1) {
			p.setId(Long.parseLong(insertPesquisaPeçaID.getText()));
		}
		else {
			p.setId((long) 0);
		}
		
		for(PeçaVO pvo : pbo.pesquisar(p)) {
			p = pvo;
		}
		
		//Coloca os valores digitados na interface em um objeto para que seja alterado
		p.setNome(alterarPeçaNome.getText());
		p.setFabricante(alterarPeçaFabricante.getText());
		p.setValor(Float.parseFloat(alterarPeçaPreço.getText()));
		
		pbo.alterar(p);
		
		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarPeças.setVisible(true);
	}
	
	//Função que deleta uma peça
	public void deletar(ActionEvent event) {
		PeçaVO p =  new PeçaVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaPeçaNome.getText().length() >= 1) {
			p.setNome(insertPesquisaPeçaNome.getText());
		}
		else {
			p.setNome("a");
		}
		
		if (insertPesquisaPeçaFabricante.getText().length() >= 1) {
			p.setFabricante(insertPesquisaPeçaFabricante.getText());
		}
		else {
			p.setFabricante("a");
		}
		
		if (insertPesquisaPeçaID.getText().length() >= 1) {
			p.setId(Long.parseLong(insertPesquisaPeçaID.getText()));
		}
		else {
			p.setId((long) 0);
		}
		
		for(PeçaVO pvo : pbo.pesquisar(p)) {
			p = pvo;
		}
		
		pbo.deletar(p);
		
		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarPeças.setVisible(true);
	}	
	
	//Mostra os elementos da aba adicionar
	public void abrirAbaAdicionar(ActionEvent event) {
		opaco.setVisible(true);
		abaAdicionar.setVisible(true);
		logoSairAdicionar.setVisible(true);
		addPeça.setVisible(true);
		novoPeçaNome.setVisible(true);
		novoPeçaFabricante.setVisible(true);
		novoPeçaPreço.setVisible(true);
		botaoSairAdicionar.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
	}
	
	//Esconde os elementos da aba adicionar
	public void fecharAbaAdicionar(ActionEvent event) {
		opaco.setVisible(false);
		abaAdicionar.setVisible(false);
		logoSairAdicionar.setVisible(false);
		addPeça.setVisible(false);
		novoPeçaNome.setVisible(false);
		novoPeçaFabricante.setVisible(false);
		novoPeçaPreço.setVisible(false);
		botaoSairAdicionar.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
	}

	//Mostra os elementos da aba alterar
	public void abrirAbaAlterar(ActionEvent event) {
		opaco.setVisible(true);
		abaAlterar.setVisible(true);
		logoSairAlterar.setVisible(true);
		alterarPeça.setVisible(true);
		botaoSairAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		alterarPeçaNome.setVisible(true);
		alterarPeçaFabricante.setVisible(true);
		alterarPeçaPreço.setVisible(true);
	}

	//Esconde os elementos da aba alterar
	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarPeça.setVisible(false);
		botaoSairAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		alterarPeçaNome.setVisible(false);
		alterarPeçaFabricante.setVisible(false);
		alterarPeçaPreço.setVisible(false);	
	}
	
	//Mostra os elementos da aba deletar
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoSairDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delPeça.setVisible(true);
		//idNomePeçaDel.setText(nomePeçaPesquisada.getText());
		//idNomePeçaDel.setVisible(true);
		textDeletar.setVisible(true);
	}

	//Esconde os elementos da aba deletar
	public void fecharAbaDeletar(ActionEvent event) {
		opaco.setVisible(false);
		abaDeletar.setVisible(false);
		logoSairDeletar.setVisible(false);
		botaoSairDeletar.setVisible(false);
		botaoCancelarDeletar.setVisible(false);
		botaoConfirmarDeletar.setVisible(false);
		delPeça.setVisible(false);
		//idNomePeçaDel.setVisible(false);
		textDeletar.setVisible(false);
	}
	
	//As seguintes funções servem para alterar as telas que ficam na parte esquerda da interface
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
	
	public void alterarParaPeças(ActionEvent event) {
		try {
			Telas.telaPrincipalPeças();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarParaLogout(ActionEvent event) {
		try {
			Telas.telaLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
