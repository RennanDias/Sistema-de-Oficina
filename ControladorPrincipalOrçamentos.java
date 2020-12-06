package Controller;

import BO.Or�amentoBO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalOr�amentos {
	
	//Componentes do resultado da busca
	@FXML private TextField insertPesquisaOr�amentoPlaca;
	@FXML private TextField insertPesquisaOr�amentoID;
	@FXML private ImageView retanguloBase;
	@FXML private ImageView logoAlterar;
	@FXML private ImageView logoDeletar;
	@FXML private Button botaoAlterar;
	@FXML private Button botaoDeletar;
	@FXML private Label r$;
	@FXML private Label valorOr�amento;
	@FXML private Label prefData;
	@FXML private Label prefPlaca;
	@FXML private Label prefStatus;
	@FXML private Label statusOr�amentoPesquisado;
	@FXML private Label placaOr�amentoPesquisado;
	@FXML private Label dataOr�amentoPesquisado;
	@FXML private Label setupAutoOr�amentoPesquisado;
		
	//Ret�ngulo opaco
	@FXML private Rectangle opaco;
	
	//Componentes da tela de adicionar or�amento
	@FXML private Rectangle abaAdicionar;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Label valorTotalOr�amento;
	@FXML private Label addServi�o;
	@FXML private Label addPe�a;
	@FXML private Label addServi�o2;
	@FXML private Label addPe�a2;
	@FXML private Label addOr�amento;
	@FXML private TextField novoOr�amentoPlaca;
	@FXML private TextField novoOr�amentoData;
	@FXML private TextField novoOr�amentoServi�oNome;
	@FXML private TextField novoOr�amentoServi�oValor;
	@FXML private TextField novoOr�amentoPe�aNome;
	@FXML private TextField novoOr�amentoPe�aValor;
	@FXML private TextField novoAutoAno;
	@FXML private TextField novoAutoKm;
	@FXML private Button botaoAddServi�oOr�amento;
	@FXML private Button botaoAddPe�aOr�amento;
	@FXML private Button botaoSairAdicionar;
	@FXML private Button botaoConfirmarAdicionar;	
	@FXML private CheckBox checarFinalizadoAdd;
	
	//Componentes da tela alterar or�amento
	@FXML private Rectangle abaAlterar;
	@FXML private ImageView logoSairAlterar;
	@FXML private Label alterarOr�amento;
	@FXML private Label alterarPe�a;
	@FXML private Label alterarServi�o;
	@FXML private Button botaoSairAlterar;
	@FXML private Button botaoConfirmarAlteracao;
	@FXML private TextField alterarOr�amentoPe�aValor;
	@FXML private TextField alterarOr�amentoServi�oValor;
	@FXML private TextField alterarOr�amentoPe�aNome;
	@FXML private TextField alterarOr�amentoServi�oNome;
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

	Or�amentoBO obo = new Or�amentoBO();
	
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
	
	public void confirmarOr�amento(ActionEvent event) {
		
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
}
