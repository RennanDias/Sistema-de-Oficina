package DAO;

import VO.Funcion�rioVO;
import VO.Or�amentoVO;

public class Funcion�rioDAO {
	public Funcion�rioVO inserirFuncion�rio(Funcion�rioVO func) { 
		//Recebe um objeto do tipo Funcion�rioVO e o cadastra no banco de dados
		return func;
	}
	
	public void gerarRelatorios(Or�amentoVO[] o) {
		//Recebe um array de objetos do tipo Or�amentoVO para gerar os relat�rios
	}
	
	public Or�amentoVO confirmarOr�amento(Or�amentoVO o) { 
		//Recebe um objeto do tipo Or�amentoVO e verifica se est� ou n�o confirmado. Se n�o estiver, confirma o or�amento
		return o;
	}
}
