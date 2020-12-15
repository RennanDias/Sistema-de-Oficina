package BO;

import java.sql.SQLException;

import DAO.ServiçoDAO;
import VO.ServiçoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiçoBO implements BaseInterBO <ServiçoVO>{
	ServiçoDAO dao = new ServiçoDAO();
	
	public ServiçoVO adicionar(ServiçoVO t) { //Recebe um serviço e adiciona ele no banco de dados na tabela serviços
		
		try {
			dao.inserir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public ServiçoVO alterar(ServiçoVO t) { //Recebe um serviço e altera seus atributos no banco de dados
		try {
			t = dao.modificar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	public void deletar(ServiçoVO t) { //Recebe um serviço e deleta ele na tabela serviços por meio da função excluir
	
		try {
			dao.excluir(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<ServiçoVO> listar() { //Forma uma lista com os objetos formados com os atributos das tuplas da tabela serviços
		ObservableList<ServiçoVO> serviços = FXCollections.observableArrayList();
		
		try {
			serviços = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serviços;
		
	}
	
	public ObservableList<ServiçoVO> pesquisar(ServiçoVO t) { //Forma uma lista com um serviço específico da tabela serviços
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
