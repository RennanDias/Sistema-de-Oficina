package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.Or�amentoVO;

public class Or�amentoDAO extends BaseDAO<Or�amentoVO> implements BaseInterDAO<Or�amentoVO>{

	public Or�amentoVO inserir(Or�amentoVO r) { 
		//Recebe um objeto do tipo Or�amentoVO e insere ele no banco de dados na tabela Or�amento

		String sql = "insert into or�amentos (placa_auto, data_de_solicitacao, valor_total) values (?,?,?)";
		PreparedStatement ptst;
		AutomovelVO a = new AutomovelVO();
		//a.setOr�amento(r);
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, a.getPlaca());
			ptst.setDate(2, (Date) r.getData());
			ptst.setFloat(3, r.getValor());
			ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				r.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhu id foi retornado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
		
	public Or�amentoVO modificar(Or�amentoVO o) {
		//Recebe um objeto do tipo Or�amentoVO e modifica ele no banco de dados na tabela Or�amento	

		String sql = "update from or�amentos set valor_total =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setFloat(1, o.getValor());
			ptst.setLong(2, o.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}

	public void excluir(Or�amentoVO a) { 
		//Recebe um objeto do tipo Or�amentoVO e exclui ele no banco de dados na tabela Or�amento

		String sql = "delete from or�amentos where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<Or�amentoVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados

		String sql = "select * from or�amentos";
		Statement st;
		ResultSet rs;
		List<Or�amentoVO> or�amentos = new ArrayList<Or�amentoVO>();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Or�amentoVO vo = new Or�amentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setId(rs.getLong("id"));
				vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setAutomoveis(a);
				or�amentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return or�amentos;
	}
		
	public Or�amentoVO buscar(Or�amentoVO o) { 
		//Recebe um objeto do tipo Or�amentoVO e busca ele no banco de dados na tabela Or�amento	

		String sql = "select from or�amentos where id = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setLong(1, o.getId());
			rs = st.executeQuery(sql);
			
			Or�amentoVO vo = new Or�amentoVO();
			AutomovelVO a = new AutomovelVO();
			
			a.setPlaca(rs.getString("placa_auto"));
			vo.setData(rs.getDate("data_de_solicitacao"));
			vo.setValor(rs.getFloat("valor_total"));
			vo.setId(rs.getLong("id"));
			vo.setFinalizado(rs.getBoolean("finalizado"));
			vo.setAutomoveis(a);
			
			o = vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}
	
}
