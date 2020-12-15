package BO;

import java.sql.SQLException;

import DAO.AutomovelDAO;
import DAO.Or�amentoDAO;
import DAO.VendaDAO;
import VO.AutomovelVO;
import VO.ClientesVO;
import VO.Or�amentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Or�amentoBO implements BaseInterBO <Or�amentoVO> {
	Or�amentoDAO dao = new Or�amentoDAO();
	VendaDAO vdao = new VendaDAO();
	AutomovelDAO adao = new AutomovelDAO();
	
public Or�amentoVO adicionar(Or�amentoVO r) { //Recebe um or�amento e adiciona ele no banco de dados por meio da fun��o inserir
	try {
		r = dao.inserir(r);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		return r;
}

	public Or�amentoVO atualizarValor(Or�amentoVO o) { //Recebe um or�amento e atualiza seus dados no banco de dados
		//Essa fun��o serve pra atualizar o valor do or�amento quando eu adiciono um item a ele
		try {
			o = dao.atualizar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}
	
	public Or�amentoVO alterar(Or�amentoVO o) { //Recebe um or�amento e altera ele no banco de dados por meio da fun��o modificar
		try {
			o = dao.modificar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	public void deletar(Or�amentoVO a) { //Deleta um or�amento na tabela or�amentos no banco de dados	
		try {
			dao.excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<Or�amentoVO> listar() { //Pega os atributos de cada tupla da tabela or�amentos, coloca elas em objetos e cria uma lista
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		
		try {
			or�amentos = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return or�amentos;
	}	
	
	public ObservableList<Or�amentoVO> pesquisar(Or�amentoVO a) { //Busca or�amentos a partir da placa do automovel ou ID e lista eles ou um espec�fico
		//Essa fun��o pega duas listas de or�amentos, a primeira, chamada or�amentos, dentro de seus objetos, possui informa��es relativas somente ao
		//or�amento em si, j� a segunda, chamada or�amentosRetornados, possui os dados do or�amento e tamb�m do autom�vel e dono para melhor manipula��o
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		ObservableList<Or�amentoVO> or�amentosRetornados = FXCollections.observableArrayList();
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		AutomovelVO autovo = new AutomovelVO();
		autovo.setPlaca("ZZZ9Z99");
		a.setAutomoveis(autovo);
		try {
			or�amentos = dao.buscar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Or�amentoVO ovo : or�amentos) {
			AutomovelVO auto = new AutomovelVO();
			ClientesVO cliente = new ClientesVO();
			auto = ovo.getAutomoveis();
			cliente.setCpf("000.000.000-00"); //Essas linhas garante que n�o aja disparo de exce��o por entrada de valores nulos 
			auto.setDono(cliente);
			auto.setId((long) 0);
			try {
				automoveis = adao.buscar(auto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(AutomovelVO avo : automoveis) {
				ovo.setAutomoveis(avo);
			}
			or�amentosRetornados.add(ovo);
		}
		return or�amentosRetornados;
	}	
}
