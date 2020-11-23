package DAO;

import VO.ClientesVO;

public class ClientesDAO implements BaseInterDAO <ClientesVO>{
	
	public ClientesVO inserir(ClientesVO c) { 
		//Recebe um objeto do tipo ClientesVO e insere ele no banco de dados na tabela Clientes
		return c;
	}
	
	public ClientesVO modificar(ClientesVO c) { 
		//Recebe um objeto do tipo ClientesVO e altera ele no banco de dados na tabela Clientes
		return c;
	}

	public void excluir(ClientesVO c) { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	}
	
	public ClientesVO buscar(ClientesVO c) { 
		//Recebe um objeto do tipo ClientesVO e busca ele na tabela Clientes no banco de dados
		return c;
	}

}

