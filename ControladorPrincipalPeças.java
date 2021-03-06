package Controller;

import BO.Pe�aBO;
import VO.Pe�aVO;
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

public class ControladorPrincipalPe�as {

	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaPe�aNome;
	@FXML private TextField insertPesquisaPe�aFabricante;
	@FXML private TextField insertPesquisaPe�aID;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
	
	//Ret�ngulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar pe�as
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label addPe�a;
	@FXML private TextField novoPe�aNome;
	@FXML private TextField novoPe�aFabricante;
	@FXML private TextField novoPe�aPre�o;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;
	
	//Componentes da tela alterar pe�as
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarPe�a;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField alterarPe�aNome;
	@FXML private TextField alterarPe�aFabricante;
	@FXML private TextField alterarPe�aPre�o;
	
	//Componentes da tela deletar pe�as
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoSairDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delPe�a;
	@FXML private Label idNomePe�aDel;
	@FXML private Label textDeletar;
	
	//Componentes de opera��o com �xito
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarPe�as;
	@FXML private Label labelExit;
	
	//Elementos da tabela pe�as
	@FXML private TableView <Pe�aVO> tabelaPe�as;
	@FXML private TableColumn <Pe�aVO, Long> idPe�a;
	@FXML private TableColumn <Pe�aVO, String> nomePe�a;
	@FXML private TableColumn <Pe�aVO, String> fabricantePe�a;
	@FXML private TableColumn <Pe�aVO, Float> valorPe�a;
	
	Pe�aBO pbo = new Pe�aBO();
	
	//Instancia a lista de pe�as
	ObservableList<Pe�aVO> pe�as = FXCollections.observableArrayList(
			pe�as = pbo.listar()
	);
	
	//Inicializa a tabela com os valores presentes na lista de pe�as
	public void initialize() {
		
		idPe�a.setCellValueFactory(new PropertyValueFactory<Pe�aVO, Long>("id"));
		nomePe�a.setCellValueFactory(new PropertyValueFactory<Pe�aVO, String>("nome"));
		fabricantePe�a.setCellValueFactory(new PropertyValueFactory<Pe�aVO, String>("fabricante"));
		valorPe�a.setCellValueFactory(new PropertyValueFactory<Pe�aVO, Float>("valor"));
			
		tabelaPe�as.setItems(pe�as);
		
	}
	
	//Fun��o para pesquisar pe�as
	public void pesquisar(ActionEvent event) {
		Pe�aVO p =  new Pe�aVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaPe�aNome.getText().length() >= 1) {
			p.setNome(insertPesquisaPe�aNome.getText());
		}
		else {
			p.setNome("a");
		}
		
		if (insertPesquisaPe�aFabricante.getText().length() >= 1) {
			p.setFabricante(insertPesquisaPe�aFabricante.getText());
		}
		else {
			p.setFabricante("a");
		}
		
		if (insertPesquisaPe�aID.getText().length() >= 1) {
			p.setId(Long.parseLong(insertPesquisaPe�aID.getText()));
		}
		else {
			p.setId((long) 0);
		}
		
		pe�as = pbo.pesquisar(p);		
		tabelaPe�as.setItems(pe�as);

		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);
		
	}
	
	//Fun��o para adicionar pe�as
	public void adicionar(ActionEvent event) {
		Pe�aVO p =  new Pe�aVO();
		
		//Coloca os valores digitados na interface em um objeto para que seja adicionado
		p.setNome(novoPe�aNome.getText());
		p.setFabricante(novoPe�aFabricante.getText());
		p.setValor(Float.parseFloat(novoPe�aPre�o.getText()));
		
		pbo.adicionar(p);
		
		//Exibe a tela com mensagem de �xito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarPe�as.setVisible(true);
	}
	
	//Fun��o que altera uma pe�a
	public void alterar(ActionEvent event) {
		Pe�aVO p =  new Pe�aVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaPe�aNome.getText().length() >= 1) {
			p.setNome(insertPesquisaPe�aNome.getText());
		}
		else {
			p.setNome("a");
		}
		
		if (insertPesquisaPe�aFabricante.getText().length() >= 1) {
			p.setFabricante(insertPesquisaPe�aFabricante.getText());
		}
		else {
			p.setFabricante("a");
		}
		
		if (insertPesquisaPe�aID.getText().length() >= 1) {
			p.setId(Long.parseLong(insertPesquisaPe�aID.getText()));
		}
		else {
			p.setId((long) 0);
		}
		
		for(Pe�aVO pvo : pbo.pesquisar(p)) {
			p = pvo;
		}
		
		//Coloca os valores digitados na interface em um objeto para que seja alterado
		p.setNome(alterarPe�aNome.getText());
		p.setFabricante(alterarPe�aFabricante.getText());
		p.setValor(Float.parseFloat(alterarPe�aPre�o.getText()));
		
		pbo.alterar(p);
		
		//Exibe a tela com mensagem de �xito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarPe�as.setVisible(true);
	}
	
	//Fun��o que deleta uma pe�a
	public void deletar(ActionEvent event) {
		Pe�aVO p =  new Pe�aVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if (insertPesquisaPe�aNome.getText().length() >= 1) {
			p.setNome(insertPesquisaPe�aNome.getText());
		}
		else {
			p.setNome("a");
		}
		
		if (insertPesquisaPe�aFabricante.getText().length() >= 1) {
			p.setFabricante(insertPesquisaPe�aFabricante.getText());
		}
		else {
			p.setFabricante("a");
		}
		
		if (insertPesquisaPe�aID.getText().length() >= 1) {
			p.setId(Long.parseLong(insertPesquisaPe�aID.getText()));
		}
		else {
			p.setId((long) 0);
		}
		
		for(Pe�aVO pvo : pbo.pesquisar(p)) {
			p = pvo;
		}
		
		pbo.deletar(p);
		
		//Exibe a tela com mensagem de �xito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarPe�as.setVisible(true);
	}	
	
	//Mostra os elementos da aba adicionar
	public void abrirAbaAdicionar(ActionEvent event) {
		opaco.setVisible(true);
		abaAdicionar.setVisible(true);
		logoSairAdicionar.setVisible(true);
		addPe�a.setVisible(true);
		novoPe�aNome.setVisible(true);
		novoPe�aFabricante.setVisible(true);
		novoPe�aPre�o.setVisible(true);
		botaoSairAdicionar.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
	}
	
	//Esconde os elementos da aba adicionar
	public void fecharAbaAdicionar(ActionEvent event) {
		opaco.setVisible(false);
		abaAdicionar.setVisible(false);
		logoSairAdicionar.setVisible(false);
		addPe�a.setVisible(false);
		novoPe�aNome.setVisible(false);
		novoPe�aFabricante.setVisible(false);
		novoPe�aPre�o.setVisible(false);
		botaoSairAdicionar.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
	}

	//Mostra os elementos da aba alterar
	public void abrirAbaAlterar(ActionEvent event) {
		opaco.setVisible(true);
		abaAlterar.setVisible(true);
		logoSairAlterar.setVisible(true);
		alterarPe�a.setVisible(true);
		botaoSairAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		alterarPe�aNome.setVisible(true);
		alterarPe�aFabricante.setVisible(true);
		alterarPe�aPre�o.setVisible(true);
	}

	//Esconde os elementos da aba alterar
	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarPe�a.setVisible(false);
		botaoSairAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		alterarPe�aNome.setVisible(false);
		alterarPe�aFabricante.setVisible(false);
		alterarPe�aPre�o.setVisible(false);	
	}
	
	//Mostra os elementos da aba deletar
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoSairDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delPe�a.setVisible(true);
		//idNomePe�aDel.setText(nomePe�aPesquisada.getText());
		//idNomePe�aDel.setVisible(true);
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
		delPe�a.setVisible(false);
		//idNomePe�aDel.setVisible(false);
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
	
	public void alterarParaServi�os(ActionEvent event) {
		try {
			Telas.telaPrincipalServi�os();
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
	
	public void alterarParaPe�as(ActionEvent event) {
		try {
			Telas.telaPrincipalPe�as();
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
