package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.Funcion�rioDAO;
import VO.Funcion�rioVO;
import VO.Or�amentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Funcion�rioBO {
	Funcion�rioDAO dao = new Funcion�rioDAO();
	public Funcion�rioVO cadastrarFuncionario(Funcion�rioVO func) { //Cadastra um funcion�rio recebendo seus atributos relacionados � classe Funcion�rioVO
		
		try {
			//Realiza o teste de exist�ncia do funcion�rio, caso ele exista, n�o se pode cadastrar outro, caso n�o exista, o funcion�rio � inserido
			boolean existe = false;
			List<Funcion�rioVO> rs = dao.listar();
			while (((ResultSet) rs).next()) {
				Funcion�rioVO test = (Funcion�rioVO) rs;
				if (func.getCpf() == test.getCpf()){
					existe = true;
				}
			}
			if (existe != false){
				throw new SQLException("Imposs�vel cadastrar, pois j� existe funcion�rio com este CPF");
			}
			else {
				dao.inserir(func);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return func;
	}
	
	public boolean fazerLogin (Funcion�rioVO funcionario) { //Busca, dentro da tabela funcionarios, o funcion�rio que possui login e senha
		//iguais aos digitados no programa e, por fim, avisa se foi ou n�o logado com sucesso
		try {
			return dao.fazerLogin(funcionario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ObservableList<Or�amentoVO> gerarRelatorios(Or�amentoVO inicio, Or�amentoVO fim) { //Recebe um or�amento com a data de in�cio
		//outro com a data de fim, seleciona na tabela or�amentos todos os or�amentos contidos nesse per�odo e, por fim, coloca-os numa lista
		ObservableList<Or�amentoVO> relatorio = FXCollections.observableArrayList();
		try {
			relatorio = dao.gerarRelatorios(inicio, fim);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relatorio;
	
	}
	
	public Or�amentoVO finalizarOr�amento(Or�amentoVO o) { //V� se o or�amento est� finalizado ou n�o. Se estiver, diz que j� est�
		//finalizado, se n�o, finaliza e emite uma nota		
		try {
			o = dao.confirmarOr�amento(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}
	
}
