package Controller;

import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import BO.FuncionárioBO;
import BO.OrçamentoBO;
import VO.AutomovelVO;
import VO.OrçamentoVO;
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ControladorPrincipalRelatorios {
	
	//Componentes da tela principal
	@FXML private TextField insertDataInicio;
	@FXML private TextField insertDataFim;
	@FXML private Button botaoLogout;
	/*@FXML private ImageView retanguloBase;
	@FXML private Label setupAutoOrçamentoPesquisado;
	@FXML private Label r$;
	@FXML private Label valorOrçamento1;
	@FXML private Label placaOrçamentoPesquisado;
	@FXML private Label prefPlaca;
	@FXML private Label prefData;
	@FXML private Label dataOrçamentoPesquisado;
	@FXML private Label prefStatus;
	@FXML private Label statusOrçamentoPesquisado;*/
	@FXML private Button botaoGerarRelatorio;
	
	//Componentes da tabela de orçamentos
    @FXML private TableView <OrçamentoVO> tabelaOrçamentos;
    @FXML private TableColumn <OrçamentoVO, Long> idOrçamento;
    @FXML private TableColumn <OrçamentoVO, String> placaOrçamento;
    @FXML private TableColumn <OrçamentoVO, Date> dataOrçamento;
    @FXML private TableColumn <OrçamentoVO, String> statusOrçamento;
    @FXML private TableColumn <OrçamentoVO, Float> valorOrçamento;
	
    //Retangulo opaco pra dar efeito visual
	@FXML private Rectangle opaco;
	
	
	@FXML private Rectangle abaPeriodoRelatorio;
	//@FXML private Label gerOrçamentoPer;
	//@FXML private Label prefValorTotal;
	@FXML private Label valorTotalOrçamento;
	
	/*@FXML private Label prefPlaca1;
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
	@FXML private Label prefInicio;*/
	@FXML private ImageView logoSairAdicionar;
	@FXML private Button botaoSairPeriodoRelatorio;
	@FXML private Button botaoConfirmarGeracao;	
	
	//Componentes de operação com êxito
	@FXML private Rectangle retanguloExit;
	@FXML private Button botaoAlterarRelatorios;
	@FXML private Label labelExit;
	
	FuncionárioBO fbo = new FuncionárioBO();
	OrçamentoBO obo = new OrçamentoBO();
	
	//Instancia a lista de orçamentos
	ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList(
		orçamentos = obo.listar()
	);
	
	//Inicializa a tabela com os valores presentes na lista de orçamentos
	public void initialize() {

		idOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, Long>("id"));
		placaOrçamento.setCellValueFactory((TableColumn.CellDataFeatures<OrçamentoVO, String> param) -> new SimpleStringProperty(param.getValue().getAutomoveis().getPlaca()));
		dataOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, Date>("data"));
		statusOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, String>("finalizado"));
		valorOrçamento.setCellValueFactory(new PropertyValueFactory<OrçamentoVO, Float>("valor"));
			
		tabelaOrçamentos.setItems(orçamentos);
		
	}
	
	//Função para pesquisar os orçamentos dentro do período especificado
	public void pesquisar(ActionEvent event) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		OrçamentoVO ini = new OrçamentoVO();
		OrçamentoVO fim = new OrçamentoVO();
		
		
		try {
			ini.setData(dateFormat.parse(insertDataInicio.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fim.setData(dateFormat.parse(insertDataFim.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		orçamentos = fbo.gerarRelatorios(ini, fim);			
		tabelaOrçamentos.setItems(orçamentos);
		
	}
	
	//Essas duas funções são falsas
	public void abrirAbaGerarRelatorio(ActionEvent event) {

	}
		
	public void fecharAbaRelatorio(ActionEvent event) {

	}
	
	//A seguinte função serve para gerar um arquivo PDF, um relatório contendo os dados acerca dos orçamentos do período
	public void gerarRelatorio(ActionEvent event) {
		Document document = new Document();
		
		try {			
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\rdfla\\Desktop\\RelatórioPDF.pdf"));
			document.open();
			document.setPageSize(PageSize.A4);
			document.add(new Paragraph("---------- Oficina Simas Turbo ----------\n")/*.setAlignment(Paragraph.ALIGN_CENTER)*/);
			document.add(new Paragraph("-       Data       -     Placa     -   Valor\n"));
			OrçamentoVO ovo = new OrçamentoVO();
			ovo.setValor(0);
			for(OrçamentoVO o : orçamentos) { //Vai adicionando ao PDF os atributos escolhidos dos objetos
				AutomovelVO a = new AutomovelVO();
				ovo.setValor(ovo.getValor() + o.getValor());
				a = o.getAutomoveis();
				document.add(new Paragraph("- (" + o.getData() + ") - " + a.getPlaca() + " - R$" + o.getValor() + "\n"));
			}
			document.add(new Paragraph("Valor Total: R$" + ovo.getValor()));
			
		} catch(DocumentException de) {
			System.err.println(de.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
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
	
	public void alterarParaLogout(ActionEvent event) {
		try {
			Telas.telaLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
