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
	public ClientesVO adicionar(ClientesVO c) { //Cria um cliente dentro do m�todo, cria um objeto do tipo AutomovelBO para poder usar
		//os m�todos na hora de adicionar o cliente, depois pega os valores e vai atribuindo ao meu objeto do tipo ClientesVO criado
		//ao final, retorna um objeto do tipo ClientesVO
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
	
	public ClientesVO alterar(ClientesVO c) { //Recebe um objeto do tipo ClienteVO, altera seus atributos e, ao final, retorna ele
		
		//Ao inv�s de listar, usar buscar
		
		System.out.println(c.getId());
		System.out.println(c.getNome());
		System.out.println(c.getCpf());
		System.out.println(c.getEndere�o());
		
		try {
			c = dao.modificar(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public void deletar(ClientesVO c) { //Acessa o vetor de clientes, pesquisa o cliente pelo cpf ou nome e deleta ele no vetor
		
		try {
			dao.excluir(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<ClientesVO> listar() { //Recebe o vetor de or�amentos, a data de in�cio e fim
		//do per�odo que deseja gerar relat�rios e por fim, mostra todos eles com deus valores
		ObservableList<ClientesVO> clientes = FXCollections.observableArrayList();
		try {
			clientes = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public ObservableList<ClientesVO> pesquisar(ClientesVO c) { //Pesquisa o cliente de acordo com o nome ou cpf, rodando o vetor de clientes recebido
		
	//Buscar ao inv�s de listar	
		
		/*System.out.println(c.getNome());
		System.out.println(c.getCpf());
		System.out.println(c.getId());
		
		if(c.getNome().length() < 1 || c.getNome() ==  null) {
			c.setNome("a");
		}
		
		if (c.getCpf().length() < 1 || c.getNome() ==  null) {
			c.setCpf("000.000.000-00");
		}
		
		if (c.getId() == null) {
			c.setId((long) 0);
		}
		
		System.out.println(c.getNome());
		System.out.println(c.getCpf());
		System.out.println(c.getId());*/
		
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
