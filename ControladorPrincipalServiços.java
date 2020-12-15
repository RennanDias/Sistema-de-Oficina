package Controller;

import BO.Servi�oBO;
import VO.Servi�oVO;
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

public class ControladorPrincipalServi�os {

	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaServi�oNome;
	@FXML private TextField insertPesquisaServi�oID;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
	
	//Ret�ngulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar servi�os
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label addServi�o;
	@FXML private TextField novoServi�oNome;
	@FXML private TextField novoServi�oPre�o;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;
	
	//Componentes da tela alterar servi�os
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarServi�o;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField alterarServi�oNome;
	@FXML private TextField alterarServi�oPre�o;
	
	//Componentes da tela deletar servi�os
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoSairDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delServi�o;
	@FXML private Label idNomeServi�oDel;
	@FXML private Label textDeletar;
	
	//Componentes de opera��o com �xito
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarServi�os;
	@FXML private Label labelExit;
	
	//Elementos da tabela servi�os
	@FXML private TableView <Servi�oVO> tabelaServi�os;
	@FXML private TableColumn <Servi�oVO, Long> idServi�o;
	@FXML private TableColumn <Servi�oVO, String> nomeServi�o;
	@FXML private TableColumn <Servi�oVO, Float> valorServi�o;
	
	Servi�oBO sbo = new Servi�oBO();
	
	//Instancia a lista de servi�os
	ObservableList<Servi�oVO> servi�os = FXCollections.observableArrayList(
			servi�os = sbo.listar()
	);
	
	//Inicializa a tabela com os valores presentes na lista de servi�os
	public void initialize() {
		
		idServi�o.setCellValueFactory(new PropertyValueFactory<Servi�oVO, Long>("id"));
		nomeServi�o.setCellValueFactory(new PropertyValueFactory<Servi�oVO, String>("nome"));
		valorServi�o.setCellValueFactory(new PropertyValueFactory<Servi�oVO, Float>("valor"));
			
		tabelaServi�os.setItems(servi�os);
		
	}
	
	//Fun��o para pesquisar servi�os
	public void pesquisar(ActionEvent event) {
		Servi�oVO s =  new Servi�oVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaServi�oNome.getText().length() >= 1) {
			s.setNome(insertPesquisaServi�oNome.getText());
		}
		else {
			s.setNome("a");
		}
		
		if (insertPesquisaServi�oID.getText().length() >= 1) {
			s.setId(Long.parseLong(insertPesquisaServi�oID.getText()));
		}
		else {
			s.setId((long) 0);
		}
		
		servi�os = sbo.pesquisar(s);		
		tabelaServi�os.setItems(servi�os);
		
		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);
		
	}
	
	//Fun��o para adicionar servi�os
	public void adicionar(ActionEvent event) {
		Servi�oVO s =  new Servi�oVO();
		
		//Coloca os valores digitados na interface em um objeto para que seja adicionado
		s.setNome(novoServi�oNome.getText());
		s.setValor(Float.parseFloat(novoServi�oPre�o.getText()));
		
		sbo.adicionar(s);
		
		//Exibe a tela com mensagem de �xito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarServi�os.setVisible(true);
	}
	
	//Fun��o que altera um servi�o
	public void alterar(ActionEvent event) {
		Servi�oVO s =  new Servi�oVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaServi�oNome.getText().length() >= 1) {
			s.setNome(insertPesquisaServi�oNome.getText());
		}
		else {
			s.setNome("a");
		}
		
		if (insertPesquisaServi�oID.getText().length() >= 1) {
			s.setId(Long.parseLong(insertPesquisaServi�oID.getText()));
		}
		else {
			s.setId((long) 0);
		}
		
		for(Servi�oVO svo : sbo.pesquisar(s)) {
			s = svo;
		}
		
		//Coloca os valores digitados na interface em um objeto para que seja alterado
		s.setNome(alterarServi�oNome.getText());
		s.setValor(Float.parseFloat(alterarServi�oPre�o.getText()));
		
		sbo.alterar(s);
		
		//Exibe a tela com mensagem de �xito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarServi�os.setVisible(true);
	}
	
	//Fun��o que deleta uma pe�a
	public void deletar(ActionEvent event) {
		Servi�oVO s =  new Servi�oVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaServi�oNome.getText().length() >= 1) {
			s.setNome(insertPesquisaServi�oNome.getText());
		}
		else {
			s.setNome("a");
		}
		
		if (insertPesquisaServi�oID.getText().length() >= 1) {
			s.setId(Long.parseLong(insertPesquisaServi�oID.getText()));
		}
		else {
			s.setId((long) 0);
		}
		
		for(Servi�oVO svo : sbo.pesquisar(s)) {
			s = svo;
		}
		
		sbo.deletar(s);
		
		//Exibe a tela com mensagem de �xito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarServi�os.setVisible(true);
	}
	
	//Mostra os elementos da aba adicionar
	public void abrirAbaAdicionar(ActionEvent event) {
		opaco.setVisible(true);
		abaAdicionar.setVisible(true);
		logoSairAdicionar.setVisible(true);
		addServi�o.setVisible(true);
		novoServi�oNome.setVisible(true);
		novoServi�oPre�o.setVisible(true);
		botaoSairAdicionar.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
	}
	
	//Esconde os elementos da aba adicionar
	public void fecharAbaAdicionar(ActionEvent event) {
		opaco.setVisible(false);
		abaAdicionar.setVisible(false);
		logoSairAdicionar.setVisible(false);
		addServi�o.setVisible(false);
		novoServi�oNome.setVisible(false);
		novoServi�oPre�o.setVisible(false);
		botaoSairAdicionar.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
	}

	//Mostra os elementos da aba alterar
	public void abrirAbaAlterar(ActionEvent event) {
		opaco.setVisible(true);
		abaAlterar.setVisible(true);
		logoSairAlterar.setVisible(true);
		alterarServi�o.setVisible(true);
		botaoSairAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		alterarServi�oNome.setVisible(true);
		alterarServi�oPre�o.setVisible(true);
	}

	//Esconde os elementos da aba alterar
	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarServi�o.setVisible(false);
		botaoSairAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		alterarServi�oNome.setVisible(false);
		alterarServi�oPre�o.setVisible(false);
	}
	
	//Mostra os elementos da aba deletar
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoSairDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delServi�o.setVisible(true);
		//idNomeServi�oDel.setText(nomeServi�oPesquisado.getText());
		//idNomeServi�oDel.setVisible(true);
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
		delServi�o.setVisible(false);
		//idNomeServi�oDel.setVisible(false);
		textDeletar.setVisible(false);
	}
	
	//As seguintes fun��es servem para alterar as telas que ficam na parte esquerda da interface
	public void alterarParaAutomoveis(ActionEvent event) {
		try {
			Telas.telaPrincipalAutomoveis();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarParaOr�amentos(ActionEvent event) {
		try {
			Telas.telaPrincipalOr�amentos();
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
	
	public void alterarParaPe�as(ActionEvent event) {
		try {
			Telas.telaPrincipalPe�as();
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
	
	public void alterarParaServi�os(ActionEvent event) {
		try {
			Telas.telaPrincipalServi�os();
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
