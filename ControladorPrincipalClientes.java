package Controller;

import BO.ClientesBO;
import VO.ClientesVO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalClientes {
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaClienteNome;
	@FXML private TextField insertPesquisaClienteCPF;
	@FXML private TextField insertPesquisaClienteID;
	@FXML private ImageView retanguloBase;
	@FXML private Label prefEnd;
	@FXML private Label prefCpf;
	@FXML private Label endCliente;
	@FXML private Label cpfCliente;
	@FXML private Label nomeClientePesquisado;
	
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
	@FXML private Button botaoFecharAdicionar;
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
	
	
	ClientesBO cBO = new ClientesBO();
	
	public void pesquisar(ActionEvent event) {
		ClientesVO c = new ClientesVO();
		c.setNome(insertPesquisaClienteNome.getText());
		c.setCpf(insertPesquisaClienteCPF.getText());
		if (insertPesquisaClienteID.getText().equals("")) {
			insertPesquisaClienteID.setText("0");
		}
		c.setId(Long.parseLong(insertPesquisaClienteID.getText()));
		
		if (c.getNome().equals("")) {
			c.setNome("Aleatório");
		}
		if (c.getCpf().equals("")) {
			c.setCpf("000.000.000-00");
		}
		if (c.getEndereço().equals(null)) {
			c.setEndereço("Aleatório");
		}
		
		c = cBO.pesquisar(c);
		
		nomeClientePesquisado.setText(c.getNome());
		cpfCliente.setText(c.getCpf());
		endCliente.setText(c.getEndereço());
		
		retanguloBase.setVisible(true);
		prefEnd.setVisible(true);
		prefCpf.setVisible(true);
		endCliente.setVisible(true);
		cpfCliente.setVisible(true);
		nomeClientePesquisado.setVisible(true);
		
	}
	
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
		botaoFecharAdicionar.setVisible(true);
		botaoConfirmarAdicionar.setVisible(true);
	}
	
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
		botaoFecharAdicionar.setVisible(false);
		botaoConfirmarAdicionar.setVisible(false);
	}

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
	
	public void abrirAbaDeletar(ActionEvent event) {
		opaco.setVisible(true);
		abaDeletar.setVisible(true);
		logoSairDeletar.setVisible(true);
		botaoSairDeletar.setVisible(true);
		botaoCancelarDeletar.setVisible(true);
		botaoConfirmarDeletar.setVisible(true);
		delCliente.setVisible(true);
		nomeClienteDeletado.setVisible(true);
		textDeletar.setVisible(true);
	}

	public void fecharAbaDeletar(ActionEvent event) {
		opaco.setVisible(false);
		abaDeletar.setVisible(false);
		logoSairDeletar.setVisible(false);
		botaoSairDeletar.setVisible(false);
		botaoCancelarDeletar.setVisible(false);
		botaoConfirmarDeletar.setVisible(false);
		delCliente.setVisible(false);
		nomeClienteDeletado.setVisible(false);
		textDeletar.setVisible(false);
	}
	
	public void adicionar(ActionEvent event) {
		
	}
	
	public void alterar(ActionEvent event) {
		
	}
	
	public void deletar(ActionEvent event) {
		
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
