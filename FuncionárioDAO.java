package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import VO.FuncionárioVO;
import VO.OrçamentoVO;

public class FuncionárioDAO extends BaseDAO {
	public FuncionárioVO inserirFuncionário(FuncionárioVO func) { 
		//Recebe um objeto do tipo FuncionárioVO e o cadastra no banco de dados
		
		conn = getConnection();
		String sql = "insert into funcionarios (nome, cpf, endereço) values (?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, func.getNome());
			ptst.setString(2, func.getCpf());
			ptst.setString(3, func.getEndereço());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
