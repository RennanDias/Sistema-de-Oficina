package DAO;

import VO.OrçamentoVO;

public class OrçamentoDAO {

	public OrçamentoVO inserirOrçamento(OrçamentoVO r) { 
		//Recebe um objeto do tipo OrçamentoVO e insere ele no banco de dados na tabela Orçamento
		return r;
	}
		
	public OrçamentoVO modificarOrçamento(OrçamentoVO o) {
		//Recebe um objeto do tipo OrçamentoVO e modifica ele no banco de dados na tabela Orçamento	
		return o;
	}

	public void excluirrOrçamento(OrçamentoVO a) { 
		//Recebe um objeto do tipo OrçamentoVO e exclui ele no banco de dados na tabela Orçamento
	}
		
	public OrçamentoVO buscarOrçamento(OrçamentoVO o) { 
		//Recebe um objeto do tipo OrçamentoVO e busca ele no banco de dados na tabela Orçamento	
		return o;
	}
	
}
