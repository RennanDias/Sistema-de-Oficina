package Controller;

import BO.ClientesBO;
import VO.AutomovelVO;
import VO.ClientesVO;
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

public class ControladorPrincipalClientes {
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaClienteNome;
	@FXML private TextField insertPesquisaClienteCPF;
	@FXML private TextField insertPesquisaClienteID;
	@FXML private Label nomeClientePesquisado;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Button botaoLogout;
	
	//Retângulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar clientes
	@FXML private ImageView retanguloAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label dadosauto;
	@FXML private Label dadospessoais;
	@FXML private Label addCliente;
	@FXML private TextField novoClienteNome;
	@FXML private TextField novoClienteCPF;
	@FXML private TextField novoClienteEnd;
	@FXML private TextField novoAutoMarca;
	@FXML private TextField novoAutoModelo;
	@FXML private TextField novoAutoPlaca;
	@FXML private TextField novoAutoCor;
	@FXML private TextField novoAutoAno;
	@FXML private TextField novoAutoKm;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;
	
	//Componentes da tela alterar clientes
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarCliente;
	@FXML private Button botaoFecharAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField novoClienteNome1;
	@FXML private TextField novoClienteCPF1;
	@FXML private TextField novoClienteEnd1;
	
	//Componentes da tela deletar clientes
	@FXML private Rectangle abaDeletar;
	@FXML private ImageView logoSairDeletar;
	@FXML private Button botaoSairDeletar;
	@FXML private Button botaoCancelarDeletar;
	@FXML private Button botaoConfirmarDeletar;
	@FXML private Label delCliente;
	@FXML private Label nomeClienteDeletado;
	@FXML private Label textDeletar;
	
	//Componentes de operação com êxito
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarClientes;
	@FXML private Label labelExit;
	
	//Elementos da tabela de automóveis
    @FXML private TableView <ClientesVO> tabelaClientes;
    @FXML private TableColumn <ClientesVO, Long> idCliente;
    @FXML private TableColumn <ClientesVO, String> nomeCliente;
    @FXML private TableColumn <ClientesVO, String> cpfCliente1;
    @FXML private TableColumn <ClientesVO, String> endereçoCliente;
	
	ClientesBO cBO = new ClientesBO();
	
	//Instancia a lista de clientes
	ObservableList<ClientesVO> clientes = FXCollections.observableArrayList(
			clientes = cBO.listar()
	);
	
	//Inicializa a tabela com os valores presentes na lista de clientes
	public void initialize() {
		
		idCliente.setCellValueFactory(new PropertyValueFactory<ClientesVO, Long>("id"));
		nomeCliente.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("nome"));
		cpfCliente1.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("cpf"));
		endereçoCliente.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("endereço"));
		
		tabelaClientes.setItems(clientes);
	}
	
	//Função para pesquisar os clientes
	public void pesquisar(ActionEvent event) {
		ClientesVO c = new ClientesVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if(insertPesquisaClienteNome.getText().length() >= 1) {
			c.setNome(insertPesquisaClienteNome.getText());
		}
		else {
			c.setNome("a");
		}
		
		if (insertPesquisaClienteCPF.getText().length() >= 1) {
			c.setCpf(insertPesquisaClienteCPF.getText());
		}
		else {
			c.setCpf("000.000.000-00");
		}
		
		if (insertPesquisaClienteID.getText().length() >= 1) {
			c.setId(Long.parseLong(insertPesquisaClienteID.getText()));
		}
		else {
			c.setId((long) 0);
		}
		
		clientes = cBO.pesquisar(c);	
		tabelaClientes.setItems(clientes);

		botaoAlterar.setVisible(true);
		botaoDeletar.setVisible(true);

	}
	
	//Mostra os elementos da aba adicionar
	public void abrirAbaAdicionar(ActionEvent event) {
		opaco.setVisible(true);
		retanguloAdicionar.setVisible(true);
		logoSairAdicionar.setVisible(true);
		dadosauto.setVisible(true);
		dadospessoais.setVisible(true);
		addCliente.setVisible(true);
		novoClienteNome.setVisible(true);
		novoClienteCPF.setVisible(true);
		novoClienteEnd.setVisible(true);
		novoAutoMarca.setVisible(true);
		novoAutoModelo.setVisible(true);
		novoAutoPlaca.setVisible(true);
		novoAutoAno.setVisible(true);
		novoAutoKm.setVisible(true);
		novoAutoCor.setVisible(true);
		botaoSairAdicionar.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
	}
	
	//Esconde os elementos da aba adicionar
	public void fecharAbaAdicionar(ActionEvent event) {
		opaco.setVisible(false);
		retanguloAdicionar.setVisible(false);
		logoSairAdicionar.setVisible(false);
		dadosauto.setVisible(false);
		dadospessoais.setVisible(false);
		addCliente.setVisible(false);
		novoClienteNome.setVisible(false);
		novoClienteCPF.setVisible(false);
		novoClienteEnd.setVisible(false);
		novoAutoMarca.setVisible(false);
		novoAutoModelo.setVisible(false);
		novoAutoPlaca.setVisible(false);
		novoAutoAno.setVisible(false);
		novoAutoKm.setVisible(false);
		novoAutoCor.setVisible(false);
		botaoSairAdicionar.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
	}

	//Mostra os elementos da aba alterar
	public void abrirAbaAlterar(ActionEvent event) {
		opaco.setVisible(true);
		abaAlterar.setVisible(true);
		logoSairAlterar.setVisible(true);
		alterarCliente.setVisible(true);
		botaoFecharAlterar.setVisible(true);
		botaoConfirmarAlteracao.setVisible(true);
		novoClienteNome1.setVisible(true);
		novoClienteCPF1.setVisible(true);
		novoClienteEnd1.setVisible(true);
	}

	//Esconde os elementos da aba alterar
	public void fecharAbaAlterar(ActionEvent event) {
		opaco.setVisible(false);
		abaAlterar.setVisible(false);
		logoSairAlterar.setVisible(false);
		alterarCliente.setVisible(false);
		botaoFecharAlterar.setVisible(false);
		botaoConfirmarAlteracao.setVisible(false);
		novoClienteNome1.setVisible(false);
		novoClienteCPF1.setVisible(false);
		novoClienteEnd1.setVisible(false);		
	}
	
	//Mostra os elementos da aba deletar
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoSairDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delCliente.setVisible(true);
		//nomeClienteDeletado.setText(insertPesquisaClienteNome.getText());
		//nomeClienteDeletado.setVisible(true);
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
		delCliente.setVisible(false);
		//nomeClienteDeletado.setVisible(false);
		textDeletar.setVisible(false);
	}
	
	
	public void adicionar(ActionEvent event) {
		ClientesVO vo = new ClientesVO();
		AutomovelVO a = new AutomovelVO();
		
		//Coloca os valores digitados na interface em um objeto para que seja adicionado
		vo.setNome(novoClienteNome.getText());
		vo.setCpf(novoClienteCPF.getText());
		vo.setEndereço(novoClienteEnd.getText());
		a.setMarca(novoAutoMarca.getText());
		a.setModelo(novoAutoModelo.getText());
		a.setCor(novoAutoCor.getText());
		a.setPlaca(novoAutoPlaca.getText());
		a.setAno(Integer.parseInt(novoAutoAno.getText()));
		a.setQuilometragem(Integer.parseInt(novoAutoKm.getText()));
		vo.setAutomoveis(a);
		
		cBO.adicionar(vo);

		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarClientes.setVisible(true);
		
	}
	
	public void alterar(ActionEvent event) {
		ClientesVO c = new ClientesVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if(insertPesquisaClienteNome.getText().length() >= 1) {
			c.setNome(insertPesquisaClienteNome.getText());
		}
		else {
			c.setNome("a");
		}
		
		if (insertPesquisaClienteCPF.getText().length() >= 1) {
			c.setCpf(insertPesquisaClienteCPF.getText());
		}
		else {
			c.setCpf("000.000.000-00");
		}
		
		if (insertPesquisaClienteID.getText().length() >= 1) {
			c.setId(Long.parseLong(insertPesquisaClienteID.getText()));
		}
		else {
			c.setId((long) 0);
		}
		
		for(ClientesVO cvo : cBO.pesquisar(c)) {
			c = cvo;
		}

		//Coloca os valores digitados na interface em um objeto para que seja adicionado
		c.setNome(novoClienteNome1.getText());
		c.setCpf(novoClienteCPF1.getText());
		c.setEndereço(novoClienteEnd1.getText());
		
		cBO.alterar(c);
		
		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarClientes.setVisible(true);
	}
	
	public void deletar(ActionEvent event) {
		ClientesVO c = new ClientesVO();
		
		//As seguintes estruturas condicionais realizam a checagem dos valores para impedir que sejam nulos
		if(insertPesquisaClienteNome.getText().length() >= 1) {
			c.setNome(insertPesquisaClienteNome.getText());
		}
		else {
			c.setNome("a");
		}
		
		if (insertPesquisaClienteCPF.getText().length() >= 1) {
			c.setCpf(insertPesquisaClienteCPF.getText());
		}
		else {
			c.setCpf("000.000.000-00");
		}
		
		if (insertPesquisaClienteID.getText().length() >= 1) {
			c.setId(Long.parseLong(insertPesquisaClienteID.getText()));
		}
		else {
			c.setId((long) 0);
		}
		
		for(ClientesVO cvo : cBO.pesquisar(c)) {
			c = cvo;
		}
		
		cBO.deletar(c);

		//Exibe a tela com mensagem de êxito
		opaco.setVisible(true);
		retanguloExit.setVisible(true);
		labelExit.setVisible(true);
		botaoAlterarClientes.setVisible(true);
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
	
	public void alterarParaClientes(ActionEvent event) {
		try {
			Telas.telaPrincipalClientes();
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
