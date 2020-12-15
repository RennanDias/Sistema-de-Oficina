package BO;

import java.sql.SQLException;

import DAO.Pe�aDAO;
import VO.Pe�aVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pe�aBO implements BaseInterBO <Pe�aVO>{
	Pe�aDAO dao = new Pe�aDAO();
	
public Pe�aVO adicionar(Pe�aVO p) { //Recebe uma pe�a e adiciona ela ao banco de dados por meio da fun��o inserir
		try {
			dao.inserir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
	public Pe�aVO alterar(Pe�aVO p) { //Recebe uma pe�a e altera seus atributos no banco de dados
		
		try {
			p = dao.modificar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

	public void deletar(Pe�aVO p) { //Recebe uma pe�a e deleta ela no banco de dados a partir da fun��o excluir
		
		try {
			dao.excluir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<Pe�aVO> listar() { //Pega os atributos das tuplas da tabela pe�as e coloca em objetos e forma uma lista
		ObservableList<Pe�aVO> pe�as = FXCollections.observableArrayList();
		
		try {
			pe�as = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pe�as;
		
	}
	
	public ObservableList<Pe�aVO> pesquisar(Pe�aVO p) { //Lista as pe�as no banco de dados e separa uma espec�fica
		ObservableList<Pe�aVO> pe�as = FXCollections.observableArrayList();
		try {
			pe�as =  dao.buscar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pe�as;
		
	}
	
}
