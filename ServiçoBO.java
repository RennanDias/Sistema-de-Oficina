package BO;

import java.sql.SQLException;

import DAO.Servi�oDAO;
import VO.Servi�oVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Servi�oBO implements BaseInterBO <Servi�oVO>{
	Servi�oDAO dao = new Servi�oDAO();
	
	public Servi�oVO adicionar(Servi�oVO t) { //Recebe um servi�o e adiciona ele no banco de dados na tabela servi�os
		
		try {
			dao.inserir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public Servi�oVO alterar(Servi�oVO t) { //Recebe um servi�o e altera seus atributos no banco de dados
		try {
			t = dao.modificar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	public void deletar(Servi�oVO t) { //Recebe um servi�o e deleta ele na tabela servi�os por meio da fun��o excluir
	
		try {
			dao.excluir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<Servi�oVO> listar() { //Forma uma lista com os objetos formados com os atributos das tuplas da tabela servi�os
		ObservableList<Servi�oVO> servi�os = FXCollections.observableArrayList();
		
		try {
			servi�os = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return servi�os;
		
	}
	
	public ObservableList<Servi�oVO> pesquisar(Servi�oVO t) { //Forma uma lista com um servi�o espec�fico da tabela servi�os
		ObservableList<Servi�oVO> servi�os = FXCollections.observableArrayList();
		
		try {
			servi�os = dao.buscar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servi�os;
		
	}
	
}
