package Controller;

import BO.AutomovelBO;
import VO.AutomovelVO;
import VO.ClientesVO;
import View.Telas;
import javafx.beans.property.SimpleStringProperty;
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

public class ControladorPrincipalAutomoveis {
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaAutoPlaca;
	@FXML private TextField insertPesquisaAutoCpfDono;
	@FXML private TextField insertPesquisaAutoID;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
		
	//Retângulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar automoveis
	@FXML private Rectangle retanguloAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label dadosauto;
	@FXML private Label dadocpfcliente;
	@FXML private Label addAuto;
	@FXML private TextField cpfDono;
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
	
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarAutomoveis;
	@FXML private Label labelExit;
	
	@FXML private TableView <AutomovelVO> tabelaAutomoveis;
	@FXML private TableColumn <AutomovelVO, Long> idAutomovel;
	@FXML private TableColumn <AutomovelVO, String> cpfDonoAutomovel;
	@FXML private TableColumn <AutomovelVO, String> marcaAutomovel;
	@FXML private TableColumn <AutomovelVO, String> modeloAutomovel;
	@FXML private TableColumn <AutomovelVO, String> placaAutomovel;
	@FXML private TableColumn <AutomovelVO, Integer> anoAutomovel;
	
	AutomovelBO abo = new AutomovelBO();
	
	ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList(
			automoveis = abo.listar()
	);
	
	public void initialize() {
		
		idAutomovel.setCellValueFactory(new PropertyValueFactory<AutomovelVO, Long>("id"));
		cpfDonoAutomovel.setCellValueFactory((TableColumn.CellDataFeatures<AutomovelVO, String> param) -> new SimpleStringProperty(param.getValue().getDono().getCpf()));
		marcaAutomovel.setCellValueFactory(new PropertyValueFactory<AutomovelVO, String>("marca"));
		modeloAutomovel.setCellValueFactory(new PropertyValueFactory<AutomovelVO, String>("modelo"));
		placaAutomovel.setCellValueFactory(new PropertyValueFactory<AutomovelVO, String>("placa"));
		anoAutomovel.setCellValueFactory(new PropertyValueFactory<AutomovelVO, Integer>("ano"));
			
		tabelaAutomoveis.setItems(automoveis);
		
	}
	
	public void pesquisar(ActionEvent event) {
		AutomovelVO a = new AutomovelVO();
		ClientesVO c = new ClientesVO();
		
		if (insertPesquisaAutoPlaca.getText().length() >= 1) {
			a.setPlaca(insertPesquisaAutoPlaca.getText());
		}
		else {
			a.setPlaca("ZZZ9Z99");
		}
		
		if (insertPesquisaAutoCpfDono.getText().length() >= 1) {
			c.setCpf(insertPesquisaAutoCpfDono.getText());
		}
		else {
			c.setCpf("000.000.000-00");
		}
		
		if (insertPesquisaAutoID.getText().length() >= 1) {
			a.setId(Long.parseLong(insertPesquisaAutoID.getText()));
		}
		else {
			a.setId((long) 0);
		}
		
		/*a.setPlaca(insertPesquisaAutoPlaca.getText());
		a.setId(Long.parseLong(insertPesquisaAutoID.getText()));
		c.setCpf(insertPesquisaAutoCpfDono.getText());*/
		
		a.setDono(c);
		
		/*for(AutomovelVO avo : abo.pesquisar(a)) {
		a = avo;
		}*/
		automoveis = abo.pesquisar(a);
		tabelaAutomoveis.setItems(automoveis);
		
		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);
		
		/*anoAutoPesquisado.setText(String.valueOf(a.getAno()));
		placaAutoPesquisado.setText(a.getPlaca());
		marcaModeloCor.setText(a.getMarca() + " " + a.getModelo() + " " + a.getCor());
		
		retanguloBase.setVisible(true);
		logoAlterar.setVisible(true);
		logoDeletar.setVisible(true);
		prefAno.setVisible(true);
		prefPlaca.setVisible(true);
		anoAutoPesquisado.setVisible(true);
		placaAutoPesquisado.setVisible(true);
		marcaModeloCor.setVisible(true);*/
	}
	
	public void adicionar(ActionEvent event) {
		AutomovelVO a = new AutomovelVO();
		ClientesVO c = new ClientesVO();
		
		c.setCpf(cpfDono.getText());
		a.setMarca(novoAutoMarca.getText());
		a.setModelo(novoAutoModelo.getText());
		a.setCor(novoAutoCor.getText());
		a.setPlaca(novoAutoPlaca.getText());
		a.setAno(Integer.parseInt(novoAutoAno.getText()));
		a.setQuilometragem(Integer.parseInt(novoAutoKm.getText()));
		a.setDono(c);
		
		abo.adicionar(a);
		
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarAutomoveis.setVisible(true);
	}
	
	public void alterar(ActionEvent event) {
		AutomovelVO a = new AutomovelVO();
		ClientesVO c = new ClientesVO();
		
		if (insertPesquisaAutoPlaca.getText().length() >= 1) {
			a.setPlaca(insertPesquisaAutoPlaca.getText());
		}
		else {
			a.setPlaca("ZZZ9Z99");
		}
		
		if (insertPesquisaAutoCpfDono.getText().length() >= 1) {
			c.setCpf(insertPesquisaAutoCpfDono.getText());
		}
		else {
			c.setCpf("000.000.000-00");
		}
		
		if (insertPesquisaAutoID.getText().length() >= 1) {
			a.setId(Long.parseLong(insertPesquisaAutoID.getText()));
		}
		else {
			a.setId((long) 0);
		}
		a.setDono(c);
		
		for(AutomovelVO avo : abo.pesquisar(a)) {
			a = avo;
		}
		
		a.setMarca(alterarAutoMarca.getText());
		a.setModelo(alterarAutoModelo.getText());
		a.setPlaca(alterarAutoPlaca.getText());
		a.setCor(alterarAutoCor.getText());
		a.setAno(Integer.parseInt(alterarAutoAno.getText()));
		a.setQuilometragem(Integer.parseInt(alterarAutoKm.getText()));
		
		abo.alterar(a);
		
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarAutomoveis.setVisible(true);
	}
	
	public void deletar(ActionEvent event) {
		AutomovelVO a = new AutomovelVO();
		ClientesVO c = new ClientesVO();
		
		if (insertPesquisaAutoPlaca.getText().length() >= 1) {
			a.setPlaca(insertPesquisaAutoPlaca.getText());
		}
		else {
			a.setPlaca("ZZZ9Z99");
		}
		
		if (insertPesquisaAutoCpfDono.getText().length() >= 1) {
			c.setCpf(insertPesquisaAutoCpfDono.getText());
		}
		else {
			c.setCpf("000.000.000-00");
		}
		
		if (insertPesquisaAutoID.getText().length() >= 1) {
			a.setId(Long.parseLong(insertPesquisaAutoID.getText()));
		}
		else {
			a.setId((long) 0);
		}
		a.setDono(c);
		
		for(AutomovelVO avo : abo.pesquisar(a)) {
			a = avo;
		}
		
		abo.deletar(a);
		
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarAutomoveis.setVisible(true);
		
	}	
	
	public void abrirAbaAdicionar(ActionEvent event) {
		opaco.setVisible(true);
		retanguloAdicionar.setVisible(true);
		logoSairAdicionar.setVisible(true);
		dadocpfcliente.setVisible(true);
		dadosauto.setVisible(true);
		addAuto.setVisible(true);
		cpfDono.setVisible(true);
		novoAutoMarca.setVisible(true);
		novoAutoModelo.setVisible(true);
		novoAutoPlaca.setVisible(true);
		novoAutoCor.setVisible(true);
		novoAutoAno.setVisible(true);
		novoAutoKm.setVisible(true);
		botaoSairAdicionar.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
	}
	
	public void fecharAbaAdicionar(ActionEvent event) {
		opaco.setVisible(false);
		retanguloAdicionar.setVisible(false);
		logoSairAdicionar.setVisible(false);
		dadocpfcliente.setVisible(false);
		dadosauto.setVisible(false);
		addAuto.setVisible(false);
		cpfDono.setVisible(false);
		novoAutoMarca.setVisible(false);
		novoAutoModelo.setVisible(false);
		novoAutoPlaca.setVisible(false);
		novoAutoCor.setVisible(false);
		novoAutoAno.setVisible(false);
		novoAutoKm.setVisible(false);
		botaoSairAdicionar.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
	}

	public void abrirAbaAlterar(ActionEvent event) {
		opaco.setVisible(true);
		abaAlterar.setVisible(true);
		logoSairAlterar.setVisible(true);
		alterarAuto.setVisible(true);
		botaoSairAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		alterarAutoMarca.setVisible(true);
		alterarAutoModelo.setVisible(true);
		alterarAutoPlaca.setVisible(true);
		alterarAutoCor.setVisible(true);
		alterarAutoAno.setVisible(true);
		alterarAutoKm.setVisible(true);
	}

	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarAuto.setVisible(false);
		botaoSairAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		alterarAutoMarca.setVisible(false);
		alterarAutoModelo.setVisible(false);
		alterarAutoPlaca.setVisible(false);
		alterarAutoCor.setVisible(false);
		alterarAutoAno.setVisible(false);
		alterarAutoKm.setVisible(false);
	}
	
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoSairDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delAuto.setVisible(true);
		//placaAutoDeletado.setText(placaAutoPesquisado.getText());
		placaAutoDeletado.setVisible(true);
		textDeletar.setVisible(true);
	}

	public void fecharAbaDeletar(ActionEvent event) {
		opaco.setVisible(false);
		abaDeletar.setVisible(false);
		logoSairDeletar.setVisible(false);
		botaoSairDeletar.setVisible(false);
		botaoCancelarDeletar.setVisible(false);
		botaoConfirmarDeletar.setVisible(false);
		delAuto.setVisible(false);
		placaAutoDeletado.setVisible(false);
		textDeletar.setVisible(false);
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
	
	public void alterarParaAutomoveis(ActionEvent event) {
		try {
			Telas.telaPrincipalAutomoveis();
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
