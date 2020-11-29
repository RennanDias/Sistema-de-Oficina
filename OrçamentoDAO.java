package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.OrçamentoVO;

public class OrçamentoDAO extends BaseDAO implements BaseInterDAO<OrçamentoVO>{

	public OrçamentoVO inserir(OrçamentoVO r) { 
		//Recebe um objeto do tipo OrçamentoVO e insere ele no banco de dados na tabela Orçamento
		
		conn = getConnection();
		String sql = "insert into orçamentos (placa_auto, data_de_solicitacao, valor_total) values (?,?,?)";
		PreparedStatement ptst;
		AutomovelVO a = new AutomovelVO();
		//a.setOrçamento(r);
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, a.getPlaca());
			ptst.setDate(2, (Date) r.getData());
			ptst.setFloat(3, r.getValor());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
		
	public OrçamentoVO modificar(OrçamentoVO o) {
		//Recebe um objeto do tipo OrçamentoVO e modifica ele no banco de dados na tabela Orçamento	
		
		conn = getConnection();
		String sql = "update from orçamentos set valor_total =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setFloat(1, o.getValor());
			ptst.setLong(2, o.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}

	public void excluir(OrçamentoVO a) { 
		//Recebe um objeto do tipo OrçamentoVO e exclui ele no banco de dados na tabela Orçamento
		
		conn = getConnection();
		String sql = "delete from orçamentos where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<OrçamentoVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		conn = getConnection();
		String sql = "select * from orçamentos";
		Statement st;
		ResultSet rs;
		List<OrçamentoVO> orçamentos = new ArrayList<OrçamentoVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				OrçamentoVO vo = new OrçamentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setId(rs.getLong("id"));
				vo.setAutomoveis(a);
				orçamentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orçamentos;
	}
		
	public OrçamentoVO buscar(OrçamentoVO o) { 
		//Recebe um objeto do tipo OrçamentoVO e busca ele no banco de dados na tabela Orçamento	
		
		conn = getConnection();
		String sql = "select from orçamentos where id = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			((PreparedStatement) st).setLong(1, o.getId());
			rs = st.executeQuery(sql);
			
			OrçamentoVO vo = new OrçamentoVO();
			AutomovelVO a = new AutomovelVO();
			
			a.setPlaca(rs.getString("placa_auto"));
			vo.setData(rs.getDate("data_de_solicitacao"));
			vo.setValor(rs.getFloat("valor_total"));
			vo.setId(rs.getLong("id"));
			vo.setAutomoveis(a);
			
			o = vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}
	
}
