package Controller;

import BO.Or�amentoBO;
import DAO.VendaDAO;
import VO.AutomovelVO;
import VO.Or�amentoVO;
import VO.VendaVO;
import View.Telas;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorPrincipalOr�amentos {
	
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaOr�amentoPlaca;
	@FXML private TextField insertPesquisaOr�amentoID;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
		
	//Ret�ngulo opaco
	@FXML private Rectangle opaco;
	
	//Tela Adicionar Or�amento
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoAtt;
	@FXML private Button botaoDefinir;
	@FXML private Button botaoAddItem;
	@FXML private Button botaoConfirmarAdicionar;
	@FXML private Label addOr�amento;
	@FXML private TextField novoOr�amentoPlaca;
	@FXML private TextField novoOr�amentoData;
	@FXML private CheckBox checarFinalizadoAdd;
	
	//Tabela dos itens adicionados/alterados
	@FXML private TableView <VendaVO> tabelaAddItem;
	@FXML private TableColumn <VendaVO, Long> id_o_add;
	@FXML private TableColumn <VendaVO, String> nomeItemAdd;
	@FXML private TableColumn <VendaVO, Integer> qtdItemAdd;
	@FXML private TableColumn <VendaVO, Float> valorItemAdd;
	
	//Itens da aba de adicionar item
	@FXML private Rectangle opacoAddItem;
	@FXML private Rectangle abaAddItem;
	@FXML private Label labelAddItem;
	@FXML private Label labelAlterarItem;
	@FXML private ImageView logoSairAbaAddItem;
	@FXML private Button botaoSairAbaAddItem;
	@FXML private Button botaoConfirmarAddItem;
	@FXML private Button botaoConfirmarAlterarItem;
	@FXML private TextField nomeItemAdicionado;
	@FXML private TextField qtdItemAdicionado;
	@FXML private TextField valorItemAdicionado;

	
	//Componentes da tela alterar or�amento
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarOr�amento;
	@FXML private Button botaoAttAlterar;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoDefinirAlterar;
	@FXML private Button botaoAlterarItem;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField nomeItemAlterar;
	@FXML private TextField alterarOr�amentoData;
	@FXML private TextField alterarOr�amentoPlaca;
	@FXML private CheckBox checarFinalizado;
	
	//Componentes da tela deletar or�amento
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoFecharDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delOr�amento;
	@FXML private Label idPlacaOr�amentoDel;
	@FXML private Label textDeletar;
	@FXML private Label textDeletar2;
	
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarOr�amentos;
	@FXML private Label labelExit;
	
	//Componentes da tabela principal
	@FXML private TableView <Or�amentoVO> tabelaOr�amento;
	@FXML private TableColumn <Or�amentoVO, Long> idOr�amento;
	@FXML private TableColumn <Or�amentoVO, String> placaOr�amento;
	@FXML private TableColumn <Or�amentoVO, Date> dataOr�amento;
	@FXML private TableColumn <Or�amentoVO, Boolean> statusOr�amento;
	@FXML private TableColumn <Or�amentoVO, Float> valorOr�amento;

	Or�amentoBO obo = new Or�amentoBO();
	Or�amentoVO ovo = new Or�amentoVO();
	VendaDAO vdao = new VendaDAO();
	
	ObservableList<VendaVO> vendas = FXCollections.observableArrayList(
			vendas = vdao.listar()
	);
	
	ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList(
			or�amentos = obo.listar()
	);
	
	public void initialize() {
		
		idOr�amento.setCellValueFactory(new PropertyValueFactory<Or�amentoVO, Long>("id"));
		placaOr�amento.setCellValueFactory((TableColumn.CellDataFeatures<Or�amentoVO, String> param) -> new SimpleStringProperty(param.getValue().getAutomoveis().getPlaca()));
		dataOr�amento.setCellValueFactory(new PropertyValueFactory<Or�amentoVO, Date>("data"));
		statusOr�amento.setCellValueFactory(new PropertyValueFactory<Or�amentoVO, Boolean>("finalizado"));
		valorOr�amento.setCellValueFactory(new PropertyValueFactory<Or�amentoVO, Float>("valor"));
		
		tabelaOr�amento.setItems(or�amentos);
		
	}
	
	public void pesquisar(ActionEvent event) {
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Or�amentoVO o = new Or�amentoVO();
		AutomovelVO a = new AutomovelVO();
		
		if (insertPesquisaOr�amentoPlaca.getText().length() >= 1) {
			a.setPlaca(insertPesquisaOr�amentoPlaca.getText());
		}
		else {
			a.setPlaca("ZZZ9Z99");
		}
		
		if (insertPesquisaOr�amentoID.getText().length() >= 1) {
			o.setId(Long.parseLong(insertPesquisaOr�amentoID.getText()));
		}
		else {
			o.setId((long) 0);
		}
		
		o.setAutomoveis(a);	
		ovo = o;
		or�amentos = obo.pesquisar(o);
		
		/*for(Or�amentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
		
		a = o.getAutomoveis();*/
		
		tabelaOr�amento.setItems(or�amentos);
		
		/*placaOr�amentoPesquisado.setText(a.getPlaca());
		dataOr�amentoPesquisado.setText(dateFormat.format(o.getData()));
		if(o.getFinalizado() ==  true) {
			statusOr�amentoPesquisado.setText("Finalizado");
		}
		else {
			statusOr�amentoPesquisado.setText("N�o finalizado");
		}
		setupAutoOr�amentoPesquisado.setText(a.getMarca() + " " + a.getModelo() + " " + a.getAno() + " (" + a.getCor() + ")");*/
		
		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);

	}
	
	public void definir(ActionEvent event) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Or�amentoVO o = new Or�amentoVO();
		AutomovelVO a = new AutomovelVO();
				
		a.setPlaca(novoOr�amentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(novoOr�amentoData.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checarFinalizado.isSelected() == true) {
			o.setFinalizado(true);
		}
		else {
			o.setFinalizado(false);
		}
		o.setAutomoveis(a);
		obo.adicionar(o);
		ovo = o;
	}
	
	public void definirAlterar(ActionEvent event) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Or�amentoVO o = new Or�amentoVO();
		AutomovelVO a = new AutomovelVO();
		
		o.setId(Long.parseLong(insertPesquisaOr�amentoID.getText()));
		
		for(Or�amentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
				
		a.setPlaca(alterarOr�amentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(alterarOr�amentoData.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checarFinalizado.isSelected() == true) {
			o.setFinalizado(true);
		}
		else {
			o.setFinalizado(false);
		}
		o.setAutomoveis(a);
		obo.alterar(o);
		ovo = o;
	}
	
	public void adicionar(ActionEvent event) {
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Or�amentoVO o = new Or�amentoVO();
		
		/*a.setPlaca(novoOr�amentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(novoOr�amentoData.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checarFinalizado.isSelected() == true) {
			o.setFinalizado(true);
		}
		else {
			o.setFinalizado(false);
		}
		o.setAutomoveis(a);*/		
		o = ovo;
		o.setValor(0);
		
		ObservableList<VendaVO> venda_atual = FXCollections.observableArrayList(
				venda_atual = vdao.listar()
		);
		for(VendaVO v : venda_atual) {
			o.setValor(o.getValor() + v.getValor());
		}
		
		//s.setNome(novoOr�amentoServi�oNome.getText());
		//s.setValor(Float.parseFloat(novoOr�amentoServi�oValor.getText()));
		//p.setNome(novoOr�amentoPe�aNome.getText());
		//p.setValor(Float.parseFloat(novoOr�amentoPe�aValor.getText()));
		//valorTotalOr�amento.setText("Valor Total: R$" + o.getValor());
		
		obo.atualizarValor(o);
	
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarOr�amentos.setVisible(true);
	}
	
	public void alterar(ActionEvent event) {
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Or�amentoVO o = new Or�amentoVO();
		/*o.setId(Long.parseLong(insertPesquisaOr�amentoID.getText()));
		
		/*for(Or�amentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
		
		AutomovelVO a = new AutomovelVO();
		VendaVO v = new VendaVO();
		//Servi�oVO s = new Servi�oVO();
		//Pe�aVO p = new Pe�aVO();
		
		a.setPlaca(alterarOr�amentoPlaca.getText());
		/*s.setNome(alterarOr�amentoServi�oNome.getText());
		s.setValor(Float.parseFloat(alterarOr�amentoServi�oValor.getText()));
		p.setNome(alterarOr�amentoPe�aNome.getText());
		p.setValor(Float.parseFloat(alterarOr�amentoPe�aValor.getText()));*/
		//o.setValor(s.getValor() + p.getValor());

		/*try {
			o.setData(dateFormat.parse(alterarOr�amentoData.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checarFinalizado.isSelected() == true) {
			o.setFinalizado(true);
		}
		else {
			o.setFinalizado(false);
		}*/
		
		o = ovo;
		
		VendaVO v = new VendaVO();
		v.setNome(nomeItemAlterar.getText());
		ovo.setVenda(v);
		
		o.setValor(0);
		
		ObservableList<VendaVO> listaItens = FXCollections.observableArrayList(
				listaItens = vdao.listarBusca(ovo)
		);
		for(VendaVO vvo : listaItens) {
			o.setValor(o.getValor() + vvo.getValor());
		}
		
		 o = obo.alterar(o);
		
		//o.setAutomoveis(a);
		//v.setP(p);
		//v.setS(s);
		//v.setO(o);
		//o.setVenda(v);
		
		//obo.alterar(o);
		
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarOr�amentos.setVisible(true);
	}
	
	public void alterarItem(ActionEvent event) throws SQLException {
		VendaVO item = new VendaVO();
		VendaVO antigo = new VendaVO();
		antigo.setNome(nomeItemAlterar.getText());
		antigo.setO(ovo);
		item.setO(ovo);
		
		item.setNome(nomeItemAdicionado.getText());
		item.setQuantidade(Integer.parseInt(qtdItemAdicionado.getText()));
		item.setValor(Float.parseFloat(valorItemAdicionado.getText()));
		
		/*System.out.println(antigo.getNome());
		System.out.println(antigo.getQuantidade());
		System.out.println(antigo.getValor());
		System.out.println("\n");
		System.out.println(item.getNome());
		System.out.println(item.getQuantidade());
		System.out.println(item.getValor());*/
		
		vdao.modificarItem(item,antigo);
		
		opacoAddItem.setVisible(false);
		abaAddItem.setVisible(false);
		labelAlterarItem.setVisible(false);
		logoSairAbaAddItem.setVisible(false);
		botaoSairAbaAddItem.setVisible(false);
		botaoConfirmarAlterarItem.setVisible(false);
		nomeItemAdicionado.setVisible(false);
		qtdItemAdicionado.setVisible(false);
		valorItemAdicionado.setVisible(false);
		botaoAtt.setVisible(true);
	}
	
	public void deletar(ActionEvent event) {	
		Or�amentoVO o = new Or�amentoVO();
		o.setId(Long.parseLong(insertPesquisaOr�amentoID.getText()));
		
		for(Or�amentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
		
		obo.deletar(o);
		
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarOr�amentos.setVisible(true);
	}
	
	public void adicionarItem(ActionEvent event) {
		/*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Or�amentoVO o = new Or�amentoVO();
		AutomovelVO a = new AutomovelVO();
				
		a.setPlaca(novoOr�amentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(novoOr�amentoData.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checarFinalizado.isSelected() == true) {
			o.setFinalizado(true);
		}
		else {
			o.setFinalizado(false);
		}
		o.setAutomoveis(a);
		obo.adicionar(o);
		o = ovo;*/
		
		VendaVO item = new VendaVO();
		item.setO(ovo);
		
		item.setNome(nomeItemAdicionado.getText());
		item.setQuantidade(Integer.parseInt(qtdItemAdicionado.getText()));
		item.setValor(Float.parseFloat(valorItemAdicionado.getText()));
		
		try {
			vdao.inserirItem(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		opacoAddItem.setVisible(false);
		abaAddItem.setVisible(false);
		labelAddItem.setVisible(false);
		logoSairAbaAddItem.setVisible(false);
		botaoSairAbaAddItem.setVisible(false);
		botaoConfirmarAddItem.setVisible(false);
		nomeItemAdicionado.setVisible(false);
		qtdItemAdicionado.setVisible(false);
		valorItemAdicionado.setVisible(false);
		botaoAtt.setVisible(true);
	}
	
	public void atualizarTabela(ActionEvent event) {
		tabelaAddItem.setVisible(false);
		vendas = vdao.listar();
		tabelaAddItem.setItems(vendas);
		tabelaAddItem.setVisible(true);
	}	
	
	public void atualizarTabelaAlterar(ActionEvent event) {
		tabelaAddItem.setVisible(false);
		vendas = vdao.listarBusca(ovo);
		tabelaAddItem.setItems(vendas);
		tabelaAddItem.setVisible(true);
	}
	
	public void abrirAbaAdicionar(ActionEvent event) {
		tabelaAddItem.setVisible(false);
		vdao.resetarTabela();
		vendas = vdao.listar();
		tabelaAddItem.setItems(vendas);
		tabelaAddItem.setVisible(true);
		
		id_o_add.setCellValueFactory(new PropertyValueFactory<VendaVO, Long>("o"));
		//id_o_add.setCellValueFactory((TableColumn.CellDataFeatures<VendaVO, Long> param) -> new SimpleLongProperty(param.getValue().getO().getId()));
		nomeItemAdd.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("nome"));
		qtdItemAdd.setCellValueFactory(new PropertyValueFactory<VendaVO, Integer>("quantidade"));
		valorItemAdd.setCellValueFactory(new PropertyValueFactory<VendaVO, Float>("valor"));
			
		tabelaAddItem.setItems(vendas);
		
		opaco.setVisible(true);
		abaAdicionar.setVisible(true);
		logoSairAdicionar.setVisible(true);
		addOr�amento.setVisible(true);
		novoOr�amentoPlaca.setVisible(true);
		novoOr�amentoData.setVisible(true);
		botaoSairAdicionar.setVisible(true);
		botaoDefinir.setVisible(true);
		botaoAddItem.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
		checarFinalizadoAdd.setVisible(true);
		tabelaAddItem.setVisible(true);
		
	}
	
	public void fecharAbaAdicionar(ActionEvent event) {
		opaco.setVisible(false);
		abaAdicionar.setVisible(false);
		logoSairAdicionar.setVisible(false);
		addOr�amento.setVisible(false);
		novoOr�amentoPlaca.setVisible(false);
		novoOr�amentoData.setVisible(false);
		botaoSairAdicionar.setVisible(false);
		botaoDefinir.setVisible(false);
		botaoAddItem.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
		checarFinalizadoAdd.setVisible(false);
		tabelaAddItem.setVisible(false);
	}
	
	public void abrirAbaAddItem(ActionEvent event) {
		
		opacoAddItem.setVisible(true);
		abaAddItem.setVisible(true);
		labelAddItem.setVisible(true);
		logoSairAbaAddItem.setVisible(true);
		botaoSairAbaAddItem.setVisible(true);
		botaoConfirmarAddItem.setVisible(true);
		nomeItemAdicionado.setVisible(true);
		qtdItemAdicionado.setVisible(true);
		valorItemAdicionado.setVisible(true);
		
	}
	
	public void fecharAbaAddItem(ActionEvent event) {
		
		opacoAddItem.setVisible(false);
		abaAddItem.setVisible(false);
		labelAddItem.setVisible(false);
		logoSairAbaAddItem.setVisible(false);
		botaoSairAbaAddItem.setVisible(false);
		botaoConfirmarAddItem.setVisible(false);
		nomeItemAdicionado.setVisible(false);
		qtdItemAdicionado.setVisible(false);
		valorItemAdicionado.setVisible(false);
		
	}

	public void abrirAbaAlterar(ActionEvent event) {
		tabelaAddItem.setVisible(false);
		vdao.resetarTabela();
		vendas = vdao.listarBusca(ovo);
		tabelaAddItem.setItems(vendas);
		tabelaAddItem.setVisible(true);
		
		id_o_add.setCellValueFactory(new PropertyValueFactory<VendaVO, Long>("id"));
		//id_o_add.setCellValueFactory((TableColumn.CellDataFeatures<VendaVO, Long> param) -> new SimpleLongProperty(param.getValue().getO().getId()));
		nomeItemAdd.setCellValueFactory(new PropertyValueFactory<VendaVO, String>("nome"));
		qtdItemAdd.setCellValueFactory(new PropertyValueFactory<VendaVO, Integer>("quantidade"));
		valorItemAdd.setCellValueFactory(new PropertyValueFactory<VendaVO, Float>("valor"));
			
		tabelaAddItem.setItems(vendas);
		
		opaco.setVisible(true);
		tabelaAddItem.setVisible(true);
		abaAlterar.setVisible(true);
		logoSairAlterar.setVisible(true);
		alterarOr�amento.setVisible(true);
		botaoAttAlterar.setVisible(true);
		botaoDefinirAlterar.setVisible(true);
		botaoAlterarItem.setVisible(true);
		botaoSairAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		nomeItemAlterar.setVisible(true);
		alterarOr�amentoData.setVisible(true);
		alterarOr�amentoPlaca.setVisible(true);
		checarFinalizado.setVisible(true);
	}

	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		tabelaAddItem.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarOr�amento.setVisible(false);
		botaoAttAlterar.setVisible(false);
		botaoDefinirAlterar.setVisible(false);
		botaoAlterarItem.setVisible(false);
		botaoSairAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		nomeItemAlterar.setVisible(false);
		alterarOr�amentoData.setVisible(false);
		alterarOr�amentoPlaca.setVisible(false);
		checarFinalizado.setVisible(false);
	}
	
	public void abrirAbaAlterarItem(ActionEvent event) {
		
		opacoAddItem.setVisible(true);
		abaAddItem.setVisible(true);
		labelAlterarItem.setVisible(true);
		logoSairAbaAddItem.setVisible(true);
		botaoSairAbaAddItem.setVisible(true);
		botaoConfirmarAlterarItem.setVisible(true);
		nomeItemAdicionado.setVisible(true);
		qtdItemAdicionado.setVisible(true);
		valorItemAdicionado.setVisible(true);
		
	}
	
	public void fecharAbaAlterarItem(ActionEvent event) {
		
		opacoAddItem.setVisible(false);
		abaAddItem.setVisible(false);
		labelAlterarItem.setVisible(false);
		logoSairAbaAddItem.setVisible(false);
		botaoSairAbaAddItem.setVisible(false);
		botaoConfirmarAlterarItem.setVisible(false);
		nomeItemAdicionado.setVisible(false);
		qtdItemAdicionado.setVisible(false);
		valorItemAdicionado.setVisible(false);
		
	}
	
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoFecharDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delOr�amento.setVisible(true);
		idPlacaOr�amentoDel.setVisible(true);
		textDeletar.setVisible(true);
		textDeletar2.setVisible(true);
	}

	public void fecharAbaDeletar(ActionEvent event) {
		opaco.setVisible(false);
		abaDeletar.setVisible(false);
		logoSairDeletar.setVisible(false);
		botaoFecharDeletar.setVisible(false);
		botaoCancelarDeletar.setVisible(false);
		botaoConfirmarDeletar.setVisible(false);
		delOr�amento.setVisible(false);
		idPlacaOr�amentoDel.setVisible(false);
		textDeletar.setVisible(false);
		textDeletar2.setVisible(false);
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
	
	public void alterarParaServi�os(ActionEvent event) {
		try {
			Telas.telaPrincipalServi�os();
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
	
	public void alterarParaOr�amentos(ActionEvent event) {
		try {
			Telas.telaPrincipalOr�amentos();
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
