package BO;

import java.sql.SQLException;

import DAO.PeçaDAO;
import VO.PeçaVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PeçaBO implements BaseInterBO <PeçaVO>{
	PeçaDAO dao = new PeçaDAO();
	
public PeçaVO adicionar(PeçaVO p) { //Recebe uma peça e adiciona ela ao banco de dados por meio da função inserir
		try {
			dao.inserir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
	public PeçaVO alterar(PeçaVO p) { //Recebe uma peça e altera seus atributos no banco de dados
		
		try {
			p = dao.modificar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

	public void deletar(PeçaVO p) { //Recebe uma peça e deleta ela no banco de dados a partir da função excluir
		
		try {
			dao.excluir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<PeçaVO> listar() { //Pega os atributos das tuplas da tabela peças e coloca em objetos e forma uma lista
		ObservableList<PeçaVO> peças = FXCollections.observableArrayList();
		
		try {
			peças = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return peças;
		
	}
	
	public ObservableList<PeçaVO> pesquisar(PeçaVO p) { //Lista as peças no banco de dados e separa uma específica
		ObservableList<PeçaVO> peças = FXCollections.observableArrayList();
		try {
			peças =  dao.buscar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peças;
		
	}
	
}
