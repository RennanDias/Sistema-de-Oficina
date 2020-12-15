package BO;

import java.sql.SQLException;

import DAO.AutomovelDAO;
import DAO.ClientesDAO;
import VO.AutomovelVO;
import VO.ClientesVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientesBO implements BaseInterBO <ClientesVO>{
	ClientesDAO dao = new ClientesDAO();
	AutomovelDAO adao = new AutomovelDAO();
	AutomovelVO avo = new AutomovelVO();
	public ClientesVO adicionar(ClientesVO c) { //Recebe um cliente junto a um automovel e adiciona eles ao banco de dados por meio das
		//funções inserir, tanto para clientes quanto para automoveis
		
		avo = c.getAutomoveis();
		avo.setDono(c);

		try {
			dao.inserir(c);
			adao.inserir(avo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public ClientesVO alterar(ClientesVO c) { //Recebe um objeto do tipo ClienteVO e altera seus atributos no banco de dados e, ao final, retorna ele
		
		try {
			c = dao.modificar(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public void deletar(ClientesVO c) { //Acessa o vetor de clientes, pesquisa o cliente pelo cpf, nome ou id e deleta ele
		
		try {
			dao.excluir(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<ClientesVO> listar() { //Pega os valores contidos nas tuplas da tabela clientes no banco de dados e transforma em uma lista
		ObservableList<ClientesVO> clientes = FXCollections.observableArrayList();
		try {
			clientes = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public ObservableList<ClientesVO> pesquisar(ClientesVO c) { //Pega o valor contido numa tupla específica da tabela clientes no banco de dados e transforma em uma lista
		//A intenção de retornar uma lista é para que o cliente específico possa ser exibido na tabela na interface
		ObservableList<ClientesVO> clientes = FXCollections.observableArrayList();
		try {
			clientes = dao.buscar(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}

}
