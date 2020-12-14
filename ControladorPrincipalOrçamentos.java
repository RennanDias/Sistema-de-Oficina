package Controller;

import BO.OrçamentoBO;
import DAO.VendaDAO;
import VO.AutomovelVO;
import VO.OrçamentoVO;
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

public class ControladorPrincipalOrçamentos {
	
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaOrçamentoPlaca;
	@FXML private TextField insertPesquisaOrçamentoID;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
		
	//Retângulo opaco
	@FXML private Rectangle opaco;
	
	//Tela Adicionar Orçamento
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoAtt;
	@FXML private Button botaoDefinir;
	@FXML private Button botaoAddItem;
	@FXML private Button botaoConfirmarAdicionar;
	@FXML private Label addOrçamento;
	@FXML private TextField novoOrçamentoPlaca;
	@FXML private TextField novoOrçamentoData;
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

	
	//Componentes da tela alterar orçamento
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarOrçamento;
	@FXML private Button botaoAttAlterar;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoDefinirAlterar;
	@FXML private Button botaoAlterarItem;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField nomeItemAlterar;
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
	
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarOrçamentos;
	@FXML private Label labelExit;
	
	//Componentes da tabela principal
	@FXML private TableView <OrçamentoVO> tabelaOrçamento;
	@FXML private TableColumn <OrçamentoVO, Long> idOrçamento;
	@FXML private TableColumn <OrçamentoVO, String> placaOrçamento;
	@FXML private TableColumn <OrçamentoVO, Date> dataOrçamento;
	@FXML private TableColumn <OrçamentoVO, Boolean> statusOrçamento;
	@FXML private TableColumn <OrçamentoVO, Float> valorOrçamento;

	OrçamentoBO obo = new OrçamentoBO();
	OrçamentoVO ovo = new OrçamentoVO();
	VendaDAO vdao = new VendaDAO();
	
	ObservableList<VendaVO> vendas = FXCollections.observableArrayList(
			vendas = vdao.listar()
	);
	
	ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList(
			orçamentos = obo.listar()
	);
	
	public void initialize() {
		
		idOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, Long>("id"));
		placaOrçamento.setCellValueFactory((TableColumn.CellDataFeatures<OrçamentoVO, String> param) -> new SimpleStringProperty(param.getValue().getAutomoveis().getPlaca()));
		dataOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, Date>("data"));
		statusOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, Boolean>("finalizado"));
		valorOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, Float>("valor"));
		
		tabelaOrçamento.setItems(orçamentos);
		
	}
	
	public void pesquisar(ActionEvent event) {
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		OrçamentoVO o = new OrçamentoVO();
		AutomovelVO a = new AutomovelVO();
		
		if (insertPesquisaOrçamentoPlaca.getText().length() >= 1) {
			a.setPlaca(insertPesquisaOrçamentoPlaca.getText());
		}
		else {
			a.setPlaca("ZZZ9Z99");
		}
		
		if (insertPesquisaOrçamentoID.getText().length() >= 1) {
			o.setId(Long.parseLong(insertPesquisaOrçamentoID.getText()));
		}
		else {
			o.setId((long) 0);
		}
		
		o.setAutomoveis(a);	
		ovo = o;
		orçamentos = obo.pesquisar(o);
		
		/*for(OrçamentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
		
		a = o.getAutomoveis();*/
		
		tabelaOrçamento.setItems(orçamentos);
		
		/*placaOrçamentoPesquisado.setText(a.getPlaca());
		dataOrçamentoPesquisado.setText(dateFormat.format(o.getData()));
		if(o.getFinalizado() ==  true) {
			statusOrçamentoPesquisado.setText("Finalizado");
		}
		else {
			statusOrçamentoPesquisado.setText("Não finalizado");
		}
		setupAutoOrçamentoPesquisado.setText(a.getMarca() + " " + a.getModelo() + " " + a.getAno() + " (" + a.getCor() + ")");*/
		
		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);

	}
	
	public void definir(ActionEvent event) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		OrçamentoVO o = new OrçamentoVO();
		AutomovelVO a = new AutomovelVO();
				
		a.setPlaca(novoOrçamentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(novoOrçamentoData.getText()));
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
		OrçamentoVO o = new OrçamentoVO();
		AutomovelVO a = new AutomovelVO();
		
		o.setId(Long.parseLong(insertPesquisaOrçamentoID.getText()));
		
		for(OrçamentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
				
		a.setPlaca(alterarOrçamentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(alterarOrçamentoData.getText()));
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
		
		OrçamentoVO o = new OrçamentoVO();
		
		/*a.setPlaca(novoOrçamentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(novoOrçamentoData.getText()));
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
		
		//s.setNome(novoOrçamentoServiçoNome.getText());
		//s.setValor(Float.parseFloat(novoOrçamentoServiçoValor.getText()));
		//p.setNome(novoOrçamentoPeçaNome.getText());
		//p.setValor(Float.parseFloat(novoOrçamentoPeçaValor.getText()));
		//valorTotalOrçamento.setText("Valor Total: R$" + o.getValor());
		
		obo.atualizarValor(o);
	
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarOrçamentos.setVisible(true);
	}
	
	public void alterar(ActionEvent event) {
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		OrçamentoVO o = new OrçamentoVO();
		/*o.setId(Long.parseLong(insertPesquisaOrçamentoID.getText()));
		
		/*for(OrçamentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
		
		AutomovelVO a = new AutomovelVO();
		VendaVO v = new VendaVO();
		//ServiçoVO s = new ServiçoVO();
		//PeçaVO p = new PeçaVO();
		
		a.setPlaca(alterarOrçamentoPlaca.getText());
		/*s.setNome(alterarOrçamentoServiçoNome.getText());
		s.setValor(Float.parseFloat(alterarOrçamentoServiçoValor.getText()));
		p.setNome(alterarOrçamentoPeçaNome.getText());
		p.setValor(Float.parseFloat(alterarOrçamentoPeçaValor.getText()));*/
		//o.setValor(s.getValor() + p.getValor());

		/*try {
			o.setData(dateFormat.parse(alterarOrçamentoData.getText()));
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
		botaoAlterarOrçamentos.setVisible(true);
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
		OrçamentoVO o = new OrçamentoVO();
		o.setId(Long.parseLong(insertPesquisaOrçamentoID.getText()));
		
		for(OrçamentoVO ovo : obo.pesquisar(o)) {
			o = ovo;
		}
		
		obo.deletar(o);
		
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarOrçamentos.setVisible(true);
	}
	
	public void adicionarItem(ActionEvent event) {
		/*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		OrçamentoVO o = new OrçamentoVO();
		AutomovelVO a = new AutomovelVO();
				
		a.setPlaca(novoOrçamentoPlaca.getText());
		try {
			o.setData(dateFormat.parse(novoOrçamentoData.getText()));
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
		addOrçamento.setVisible(true);
		novoOrçamentoPlaca.setVisible(true);
		novoOrçamentoData.setVisible(true);
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
		addOrçamento.setVisible(false);
		novoOrçamentoPlaca.setVisible(false);
		novoOrçamentoData.setVisible(false);
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
		alterarOrçamento.setVisible(true);
		botaoAttAlterar.setVisible(true);
		botaoDefinirAlterar.setVisible(true);
		botaoAlterarItem.setVisible(true);
		botaoSairAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		nomeItemAlterar.setVisible(true);
		alterarOrçamentoData.setVisible(true);
		alterarOrçamentoPlaca.setVisible(true);
		checarFinalizado.setVisible(true);
	}

	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		tabelaAddItem.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarOrçamento.setVisible(false);
		botaoAttAlterar.setVisible(false);
		botaoDefinirAlterar.setVisible(false);
		botaoAlterarItem.setVisible(false);
		botaoSairAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		nomeItemAlterar.setVisible(false);
		alterarOrçamentoData.setVisible(false);
		alterarOrçamentoPlaca.setVisible(false);
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
		delOrçamento.setVisible(true);
		idPlacaOrçamentoDel.setVisible(true);
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
		delOrçamento.setVisible(false);
		idPlacaOrçamentoDel.setVisible(false);
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
	
	public void alterarParaOrçamentos(ActionEvent event) {
		try {
			Telas.telaPrincipalOrçamentos();
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
