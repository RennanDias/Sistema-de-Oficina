package DAO;

import VO.FuncionárioVO;
import VO.OrçamentoVO;

public class FuncionárioDAO {
	public FuncionárioVO inserirFuncionário(FuncionárioVO func) { 
		//Recebe um objeto do tipo FuncionárioVO e o cadastra no banco de dados
		return func;
	}
	
	public void gerarRelatorios(OrçamentoVO[] o) {
		//Recebe um array de objetos do tipo OrçamentoVO para gerar os relatórios
	}
	
	public OrçamentoVO confirmarOrçamento(OrçamentoVO o) { 
		//Recebe um objeto do tipo OrçamentoVO e verifica se está ou não confirmado. Se não estiver, confirma o orçamento
		return o;
	}
}
