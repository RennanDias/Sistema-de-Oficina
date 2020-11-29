package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.Servi�oVO;

public class Servi�oDAO extends BaseDAO implements BaseInterDAO <Servi�oVO>{

	public Servi�oVO inserir(Servi�oVO t) { 
		//Recebe um objeto do tipo Servi�oVO e insere ele na tabela Pe�as no banco de dados
	
		conn = getConnection();
		String sql = "insert into servi�os (nome, valor) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, t.getNome());
			ptst.setFloat(2, t.getValor());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return t;
	}
	
	public Servi�oVO modificar(Servi�oVO t) { 
		//Recebe um objeto do tipo Servi�oVO e modifica ele na tabela Pe�as no banco de dados
	
		conn = getConnection();
		String sql = "update from servi�os set valor =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setFloat(1, t.getValor());
			ptst.setLong(2, t.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return t;
	}

	public void excluir(Servi�oVO t) { 
		//Recebe um objeto do tipo Servi�oVO e exclui ele na tabela Pe�as no banco de dados
	
		conn = getConnection();
		String sql = "delete from servi�os where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, t.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<Servi�oVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		conn = getConnection();
		String sql = "select * from servi�os";
		Statement st;
		ResultSet rs;
		List<Servi�oVO> servi�os = new ArrayList<Servi�oVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Servi�oVO vo = new Servi�oVO();
				vo.setNome(rs.getString("nome"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				servi�os.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return servi�os;
	}
	

	public Servi�oVO buscar(Servi�oVO t) { 
		//Recebe um objeto do tipo Servi�oVO e busca ele na tabela Pe�as no banco de dados
	
		conn = getConnection();
		String sql = "select from servi�os where id = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			((PreparedStatement) st).setLong(1, t.getId());
			rs = st.executeQuery(sql);
			
			Servi�oVO vo = new Servi�oVO();
			vo.setNome(rs.getString("nome"));
			vo.setValor(rs.getFloat("valor"));
			vo.setId(rs.getLong("id"));
			
			t = vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return t;
	}
	
	
}
