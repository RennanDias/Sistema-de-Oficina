package DAO;

import VO.AutomovelVO;

public class AutomovelDAO implements BaseInterDAO <AutomovelVO>{
	public AutomovelVO inserir(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e insere ele no banco de dados na tabela Automovel
		return a;
	}

	
	public AutomovelVO modificar(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e altera ele no banco de dados na tabela Automovel
		return a;
	}

	public void excluir(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e exclui ele no banco de dados na tabela Automovel	
	}
	
	public AutomovelVO buscar(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e busca ele no banco de dados na tabela Automovel	
		return a;
	}

}
