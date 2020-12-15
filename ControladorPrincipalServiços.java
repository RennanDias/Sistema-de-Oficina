package Controller;

import BO.ServiçoBO;
import VO.ServiçoVO;
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

public class ControladorPrincipalServiços {

	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaServiçoNome;
	@FXML private TextField insertPesquisaServiçoID;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
	
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
	
	//Componentes de operação com êxito
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarServiços;
	@FXML private Label labelExit;
	
	//Elementos da tabela serviços
	@FXML private TableView <ServiçoVO> tabelaServiços;
	@FXML private TableColumn <ServiçoVO, Long> idServiço;
	@FXML private TableColumn <ServiçoVO, String> nomeServiço;
	@FXML private TableColumn <ServiçoVO, Float> valorServiço;
	
	ServiçoBO sbo = new ServiçoBO();
	
	//Instancia a lista de serviços
	ObservableList<ServiçoVO> serviços = FXCollections.observableArrayList(
			serviços = sbo.listar()
	);
	
	//Inicializa a tabela com os valores presentes na lista de serviços
	public void initialize() {
		
		idServiço.setCellValueFactory(new PropertyValueFactory<ServiçoVO, Long>("id"));
		nomeServiço.setCellValueFactory(new PropertyValueFactory<ServiçoVO, String>("nome"));
		valorServiço.setCellValueFactory(new PropertyValueFactory<ServiçoVO, Float>("valor"));
			
		tabelaServiços.setItems(serviços);
		
	}
	
	//Função para pesquisar serviços
	public void pesquisar(ActionEvent event) {
		ServiçoVO s =  new ServiçoVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaServiçoNome.getText().length() >= 1) {
			s.setNome(insertPesquisaServiçoNome.getText());
		}
		else {
			s.setNome("a");
		}
		
		if (insertPesquisaServiçoID.getText().length() >= 1) {
			s.setId(Long.parseLong(insertPesquisaServiçoID.getText()));
		}
		else {
			s.setId((long) 0);
		}
		
		serviços = sbo.pesquisar(s);		
		tabelaServiços.setItems(serviços);
		
		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);
		
	}
	
	//Função para adicionar serviços
	public void adicionar(ActionEvent event) {
		ServiçoVO s =  new ServiçoVO();
		
		//Coloca os valores digitados na interface em um objeto para que seja adicionado
		s.setNome(novoServiçoNome.getText());
		s.setValor(Float.parseFloat(novoServiçoPreço.getText()));
		
		sbo.adicionar(s);
		
		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarServiços.setVisible(true);
	}
	
	//Função que altera um serviço
	public void alterar(ActionEvent event) {
		ServiçoVO s =  new ServiçoVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaServiçoNome.getText().length() >= 1) {
			s.setNome(insertPesquisaServiçoNome.getText());
		}
		else {
			s.setNome("a");
		}
		
		if (insertPesquisaServiçoID.getText().length() >= 1) {
			s.setId(Long.parseLong(insertPesquisaServiçoID.getText()));
		}
		else {
			s.setId((long) 0);
		}
		
		for(ServiçoVO svo : sbo.pesquisar(s)) {
			s = svo;
		}
		
		//Coloca os valores digitados na interface em um objeto para que seja alterado
		s.setNome(alterarServiçoNome.getText());
		s.setValor(Float.parseFloat(alterarServiçoPreço.getText()));
		
		sbo.alterar(s);
		
		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarServiços.setVisible(true);
	}
	
	//Função que deleta uma peça
	public void deletar(ActionEvent event) {
		ServiçoVO s =  new ServiçoVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaServiçoNome.getText().length() >= 1) {
			s.setNome(insertPesquisaServiçoNome.getText());
		}
		else {
			s.setNome("a");
		}
		
		if (insertPesquisaServiçoID.getText().length() >= 1) {
			s.setId(Long.parseLong(insertPesquisaServiçoID.getText()));
		}
		else {
			s.setId((long) 0);
		}
		
		for(ServiçoVO svo : sbo.pesquisar(s)) {
			s = svo;
		}
		
		sbo.deletar(s);
		
		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarServiços.setVisible(true);
	}
	
	//Mostra os elementos da aba adicionar
	public void abrirAbaAdicionar(ActionEvent event) {
		opaco.setVisible(true);
		abaAdicionar.setVisible(true);
		logoSairAdicionar.setVisible(true);
		addServiço.setVisible(true);
		novoServiçoNome.setVisible(true);
		novoServiçoPreço.setVisible(true);
		botaoSairAdicionar.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
	}
	
	//Esconde os elementos da aba adicionar
	public void fecharAbaAdicionar(ActionEvent event) {
		opaco.setVisible(false);
		abaAdicionar.setVisible(false);
		logoSairAdicionar.setVisible(false);
		addServiço.setVisible(false);
		novoServiçoNome.setVisible(false);
		novoServiçoPreço.setVisible(false);
		botaoSairAdicionar.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
	}

	//Mostra os elementos da aba alterar
	public void abrirAbaAlterar(ActionEvent event) {
		opaco.setVisible(true);
		abaAlterar.setVisible(true);
		logoSairAlterar.setVisible(true);
		alterarServiço.setVisible(true);
		botaoSairAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		alterarServiçoNome.setVisible(true);
		alterarServiçoPreço.setVisible(true);
	}

	//Esconde os elementos da aba alterar
	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarServiço.setVisible(false);
		botaoSairAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		alterarServiçoNome.setVisible(false);
		alterarServiçoPreço.setVisible(false);
	}
	
	//Mostra os elementos da aba deletar
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoSairDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delServiço.setVisible(true);
		//idNomeServiçoDel.setText(nomeServiçoPesquisado.getText());
		//idNomeServiçoDel.setVisible(true);
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
		delServiço.setVisible(false);
		//idNomeServiçoDel.setVisible(false);
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
	
	public void alterarParaServiços(ActionEvent event) {
		try {
			Telas.telaPrincipalServiços();
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
