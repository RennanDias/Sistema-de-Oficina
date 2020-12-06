package Controller;

import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ControladorPrincipalRelatorios {
	
	@FXML private TextField insertDataInicio;
	@FXML private TextField insertDataFim;
	@FXML private ImageView retanguloBase;
	@FXML private Label setupAutoOrçamentoPesquisado;
	@FXML private Label r$;
	@FXML private Label valorOrçamento;
	@FXML private Label placaOrçamentoPesquisado;
	@FXML private Label prefPlaca;
	@FXML private Label prefData;
	@FXML private Label dataOrçamentoPesquisado;
	@FXML private Label prefStatus;
	@FXML private Label statusOrçamentoPesquisado;
	@FXML private Button botaoGerarRelatorio;
	
	@FXML private Rectangle opaco;
	
	@FXML private Rectangle abaPeriodoRelatorio;
	@FXML private Label gerOrçamentoPer;
	@FXML private Label prefValorTotal;
	@FXML private Label valorTotalOrçamento;
	
	@FXML private Label prefPlaca1;
	@FXML private Label prefData1;
	@FXML private Label prefValor1;
	@FXML private Label placa1Rel;
	@FXML private Label data1Rel;
	@FXML private Label valor1Rel;
	
	@FXML private Label prefPlaca2;
	@FXML private Label prefData2;
	@FXML private Label prefValor2;
	@FXML private Label placa2Rel;
	@FXML private Label data2Rel;
	@FXML private Label valor2Rel;
	
	@FXML private Label prefPlaca3;
	@FXML private Label prefData3;
	@FXML private Label prefValor3;
	@FXML private Label placa3Rel;
	@FXML private Label data3Rel;
	@FXML private Label valor3Rel;
	
	@FXML private Label dataFimPeriodoRel;
	@FXML private Label dataInPeriodoRel;
	@FXML private Label prefFim;
	@FXML private Label prefInicio;
	@FXML private ImageView logoSairAdicionar;
	@FXML private Button botaoSairPeriodoRelatorio;
	@FXML private Button botaoConfirmarGeracao;	
	
	public void pesquisar(ActionEvent event) {
		
	}
	
	public void abrirAbaGerarRelatorio(ActionEvent event) {
		
	}
	
	public void fecharAbaRelatorio(ActionEvent event) {
		
	}
	
	public void gerarRelatorio(ActionEvent event) {
		
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
	
	public void alterarParaClientes(ActionEvent event) {
		try {
			Telas.telaPrincipalClientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
