package BO;

import java.sql.SQLException;

import DAO.AutomovelDAO;
import DAO.OrçamentoDAO;
import DAO.VendaDAO;
import VO.AutomovelVO;
import VO.ClientesVO;
import VO.OrçamentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrçamentoBO implements BaseInterBO <OrçamentoVO> {
	OrçamentoDAO dao = new OrçamentoDAO();
	VendaDAO vdao = new VendaDAO();
	AutomovelDAO adao = new AutomovelDAO();
	
public OrçamentoVO adicionar(OrçamentoVO r) { //Recebe um orçamento e adiciona ele no banco de dados por meio da função inserir
	try {
		r = dao.inserir(r);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		return r;
}

	public OrçamentoVO atualizarValor(OrçamentoVO o) { //Recebe um orçamento e atualiza seus dados no banco de dados
		//Essa função serve pra atualizar o valor do orçamento quando eu adiciono um item a ele
		try {
			o = dao.atualizar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}
	
	public OrçamentoVO alterar(OrçamentoVO o) { //Recebe um orçamento e altera ele no banco de dados por meio da função modificar
		try {
			o = dao.modificar(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	public void deletar(OrçamentoVO a) { //Deleta um orçamento na tabela orçamentos no banco de dados	
		try {
			dao.excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<OrçamentoVO> listar() { //Pega os atributos de cada tupla da tabela orçamentos, coloca elas em objetos e cria uma lista
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		
		try {
			orçamentos = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orçamentos;
	}	
	
	public ObservableList<OrçamentoVO> pesquisar(OrçamentoVO a) { //Busca orçamentos a partir da placa do automovel ou ID e lista eles ou um específico
		//Essa função pega duas listas de orçamentos, a primeira, chamada orçamentos, dentro de seus objetos, possui informações relativas somente ao
		//orçamento em si, já a segunda, chamada orçamentosRetornados, possui os dados do orçamento e também do automóvel e dono para melhor manipulação
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		ObservableList<OrçamentoVO> orçamentosRetornados = FXCollections.observableArrayList();
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		AutomovelVO autovo = new AutomovelVO();
		autovo.setPlaca("ZZZ9Z99");
		a.setAutomoveis(autovo);
		try {
			orçamentos = dao.buscar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(OrçamentoVO ovo : orçamentos) {
			AutomovelVO auto = new AutomovelVO();
			ClientesVO cliente = new ClientesVO();
			auto = ovo.getAutomoveis();
			cliente.setCpf("000.000.000-00"); //Essas linhas garante que não aja disparo de exceção por entrada de valores nulos 
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
			orçamentosRetornados.add(ovo);
		}
		return orçamentosRetornados;
	}	
}
