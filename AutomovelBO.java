package BO;

import java.sql.SQLException;
import DAO.AutomovelDAO;
import VO.AutomovelVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AutomovelBO implements BaseInterBO <AutomovelVO>{
	//static private AutomovelBO<AutomovelVO> usuBO = new AutomovelBO<AutomovelVO>();
	AutomovelDAO dao = new AutomovelDAO();
	
public AutomovelVO adicionar(AutomovelVO a) { //Recebe vetor de clientes e retorna vetor de clientes com os automoveis adicionados
	try {
		dao.inserir(a);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return a;
	}
	
	public AutomovelVO alterar(AutomovelVO a) { //Recebe um automóvel e altera seus atributos
		
		try {
			dao.modificar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	public void deletar(AutomovelVO a) { //Recebe um vetor de automóveis e deleta um de acordo com a placa dele
		
		try {
			dao.excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<AutomovelVO> listar() { //Recebe um vetor de peças e retorna a peça específica que tiver o nome recebido
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		
		try {
			automoveis = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return automoveis;
		
	}
	
	public ObservableList<AutomovelVO> pesquisar(AutomovelVO a) { //Recebe um vetor de automoveis e mostra os atributos especificos do veiculo
		
		/*for(AutomovelVO avo : dao.buscar(a)) {
			a = avo;
		}*/
		
		return dao.buscar(a);
	}
	
}
