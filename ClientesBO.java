package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.ClientesDAO;
import VO.ClientesVO;

public class ClientesBO implements BaseInterBO <ClientesVO>{
	ClientesDAO dao = new ClientesDAO();
	public ClientesVO adicionar(ClientesVO c) { //Cria um cliente dentro do m�todo, cria um objeto do tipo AutomovelBO para poder usar
		//os m�todos na hora de adicionar o cliente, depois pega os valores e vai atribuindo ao meu objeto do tipo ClientesVO criado
		//ao final, retorna um objeto do tipo ClientesVO
		
		try {
			boolean existe = false;
			List<ClientesVO> rs = dao.listar();
			while (((ResultSet) rs).next()) {
				ClientesVO test = (ClientesVO) rs;
				if (c.getCpf() == test.getCpf()){
					existe = true;
				}
			}
			if (existe != false){
				throw new SQLException("Imposs�vel cadastrar, pois j� existe cliente com este CPF");
			}
			else {
				c = dao.inserir(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*ClientesVO c = new ClientesVO();
		AutomovelBO met = new AutomovelBO();
		
		System.out.println("ADICIONANDO NOVO CLIENTE!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do cliente: ");
		c.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o endere�o do cliente: ");
		c.setEndere�o(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente: ");
		c.setCpf(s.nextLine());
		
		c.setAutomoveis(met.adicionarAutomovel());
		
		System.out.println("Cliente adicionado.");*/
		
		return c;
	}
	
	public ClientesVO alterar(ClientesVO c) { //Recebe um objeto do tipo ClienteVO, altera seus atributos e, ao final, retorna ele
		
		//Ao inv�s de listar, usar buscar
		
		try {
			ClientesVO rs = dao.buscar(c);
			if (c == rs){
				throw new SQLException("Valores id�nticos. Nada alterado.");
			}
			else {
				c = dao.modificar(c);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		/*System.out.println("ALTERANDO CLIENTE!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + c.getNome());
		System.out.println("\nDigite o novo nome: ");
		c.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Endere�o do antigo: " + c.getEndere�o());
		System.out.println("\nDigite o novo endere�o: ");
		c.setEndere�o(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("CPF antigo: " + c.getCpf());
		System.out.println("\nDigite o novo CPF: ");
		c.setCpf(s.nextLine());
		
		System.out.println("Cliente alterado.");*/
		
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
	
	/*public void mostrarCliente(ClientesVO c) { //Mostra um cliente
		AutomovelBO met = new AutomovelBO();
		System.out.println("Nome: " + c.getNome());
		System.out.println("CPF: " + c.getCpf());
		System.out.println("Endere�o: " + c.getEndere�o());
		met.mostrarAutomovel(c.getAutomoveis());
	}*/
	
	public ClientesVO pesquisar(ClientesVO c) { //Pesquisa o cliente de acordo com o nome ou cpf, rodando o vetor de clientes recebido
		
	//Buscar ao inv�s de listar	
		
		try {
			c = dao.buscar(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*boolean t = false;
		String p;
		
		System.out.println("PESQUISANDO CLIENTE!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome ou cpf do cliente a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < c.length; i++) {
			if (p.equals(c[i].getNome()) || p.equals(c[i].getCpf())) {
				mostrarCliente(c[i]);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Cliente n�o encontrado!\n");
		}*/
		return c;
	}

}
