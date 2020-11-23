package DAO;

import VO.PeçaVO;

public class PeçaDAO implements BaseInterDAO <PeçaVO>{

	public PeçaVO inserir(PeçaVO p) { 		
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados
		return p;
	}
		
	public PeçaVO modificar(PeçaVO p) {
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados				
		return p;
	}

	public void excluir(PeçaVO p) {
		//Recebe um objeto do tipo PeçaVO e exclui ele na tabela Peças no banco de dados		
	}
		
	public PeçaVO buscar(PeçaVO p) { 
		//Recebe um objeto do tipo PeçaVO e busca ele na tabela Peças no banco de dados	
		return p;
	}
		
}