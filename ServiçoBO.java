package BO;

import java.sql.SQLException;

import DAO.ServiçoDAO;
import VO.ServiçoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiçoBO implements BaseInterBO <ServiçoVO>{
	ServiçoDAO dao = new ServiçoDAO();
	
	public ServiçoVO adicionar(ServiçoVO t) { //Cria um objeto do tipo ServiçoVO, atribui valores aos seus atributos e retorna o objeto
		
		try {
			dao.inserir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public ServiçoVO alterar(ServiçoVO t) { //Recebe um serviço e altera seus atributos
		try {
			t = dao.modificar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	public void deletar(ServiçoVO t) { //Recebe um vetor de serviços e deleta um de acordo com o nome digitado
	
		try {
			dao.excluir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<ServiçoVO> listar() { //Recebe um vetor de peças e retorna a peça específica que tiver o nome recebido
		ObservableList<ServiçoVO> serviços = FXCollections.observableArrayList();
		
		try {
			serviços = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serviços;
		
	}
	
	public ObservableList<ServiçoVO> pesquisar(ServiçoVO t) { //Recebe um vetor de serviços e pesquisa um serviço de acordo com o nome
		ObservableList<ServiçoVO> serviços = FXCollections.observableArrayList();
		
		try {
			serviços = dao.buscar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviços;
		
	}
	
}
