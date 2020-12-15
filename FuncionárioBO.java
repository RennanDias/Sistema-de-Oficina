package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.FuncionárioDAO;
import VO.FuncionárioVO;
import VO.OrçamentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionárioBO {
	FuncionárioDAO dao = new FuncionárioDAO();
	public FuncionárioVO cadastrarFuncionario(FuncionárioVO func) { //Cadastra um funcionário recebendo seus atributos relacionados à classe FuncionárioVO
		
		try {
			//Realiza o teste de existência do funcionário, caso ele exista, não se pode cadastrar outro, caso não exista, o funcionário é inserido
			boolean existe = false;
			List<FuncionárioVO> rs = dao.listar();
			while (((ResultSet) rs).next()) {
				FuncionárioVO test = (FuncionárioVO) rs;
				if (func.getCpf() == test.getCpf()){
					existe = true;
				}
			}
			if (existe != false){
				throw new SQLException("Impossível cadastrar, pois já existe funcionário com este CPF");
			}
			else {
				dao.inserir(func);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return func;
	}
	
	public boolean fazerLogin (FuncionárioVO funcionario) { //Busca, dentro da tabela funcionarios, o funcionário que possui login e senha
		//iguais aos digitados no programa e, por fim, avisa se foi ou não logado com sucesso
		try {
			return dao.fazerLogin(funcionario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ObservableList<OrçamentoVO> gerarRelatorios(OrçamentoVO inicio, OrçamentoVO fim) { //Recebe um orçamento com a data de início
		//outro com a data de fim, seleciona na tabela orçamentos todos os orçamentos contidos nesse período e, por fim, coloca-os numa lista
		ObservableList<OrçamentoVO> relatorio = FXCollections.observableArrayList();
		try {
			relatorio = dao.gerarRelatorios(inicio, fim);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relatorio;
	
	}
	
	public OrçamentoVO finalizarOrçamento(OrçamentoVO o) { //Vê se o orçamento está finalizado ou não. Se estiver, diz que já está
		//finalizado, se não, finaliza e emite uma nota		
		try {
			o = dao.confirmarOrçamento(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}
	
}
