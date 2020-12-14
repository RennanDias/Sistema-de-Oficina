package BO;

import java.sql.SQLException;

import DAO.Servi�oDAO;
import VO.Servi�oVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Servi�oBO implements BaseInterBO <Servi�oVO>{
	Servi�oDAO dao = new Servi�oDAO();
	
	public Servi�oVO adicionar(Servi�oVO t) { //Cria um objeto do tipo Servi�oVO, atribui valores aos seus atributos e retorna o objeto
		
		try {
			dao.inserir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public Servi�oVO alterar(Servi�oVO t) { //Recebe um servi�o e altera seus atributos
		try {
			t = dao.modificar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	public void deletar(Servi�oVO t) { //Recebe um vetor de servi�os e deleta um de acordo com o nome digitado
	
		try {
			dao.excluir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<Servi�oVO> listar() { //Recebe um vetor de pe�as e retorna a pe�a espec�fica que tiver o nome recebido
		ObservableList<Servi�oVO> servi�os = FXCollections.observableArrayList();
		
		try {
			servi�os = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return servi�os;
		
	}
	
	public ObservableList<Servi�oVO> pesquisar(Servi�oVO t) { //Recebe um vetor de servi�os e pesquisa um servi�o de acordo com o nome
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
