package BO;

import java.sql.SQLException;
import DAO.AutomovelDAO;
import VO.AutomovelVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AutomovelBO implements BaseInterBO <AutomovelVO>{
	
	AutomovelDAO dao = new AutomovelDAO();
	
public AutomovelVO adicionar(AutomovelVO a) { //Recebe um autom�vel e delega a fun��o de adicionar ele ao banco de dados chamando a fun��o inserir
	try {
		dao.inserir(a);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return a;
	}
	
	public AutomovelVO alterar(AutomovelVO a) { //Recebe um autom�vel e delega a fun��o de alterar ele no banco de dados chamando a fun��o modificar
		
		try {
			dao.modificar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	public void deletar(AutomovelVO a) { //Recebe um autom�vel e delega a fun��o de deletar ele no banco de dados chamando a fun��o excluir
		
		try {
			dao.excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<AutomovelVO> listar() { //Pega os valores contidos nas tuplas da tabela automoveis no banco de dados e transforma em uma lista
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		
		try {
			automoveis = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return automoveis;
		
	}
	
	public ObservableList<AutomovelVO> pesquisar(AutomovelVO a) { //Pega o valor contido numa tupla espec�fica da tabela automoveis no banco de dados e transforma em uma lista
		//A inten��o de retornar uma lista � para que o automovel espec�fico possa ser exibido na tabela na interface
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		
		try {
			automoveis = dao.buscar(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return automoveis;
	}
	
}
