package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import VO.Funcion�rioVO;
import VO.Or�amentoVO;

public class Funcion�rioDAO extends BaseDAO {
	public Funcion�rioVO inserirFuncion�rio(Funcion�rioVO func) { 
		//Recebe um objeto do tipo Funcion�rioVO e o cadastra no banco de dados
		
		conn = getConnection();
		String sql = "insert into funcionarios (nome, cpf, endere�o) values (?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, func.getNome());
			ptst.setString(2, func.getCpf());
			ptst.setString(3, func.getEndere�o());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
