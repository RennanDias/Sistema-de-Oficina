package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.ServiçoVO;

public class ServiçoDAO extends BaseDAO implements BaseInterDAO <ServiçoVO>{

	public ServiçoVO inserir(ServiçoVO t) { 
		//Recebe um objeto do tipo ServiçoVO e insere ele na tabela Peças no banco de dados
	
		conn = getConnection();
		String sql = "insert into serviços (nome, valor) values (?,?)";
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
	
	public ServiçoVO modificar(ServiçoVO t) { 
		//Recebe um objeto do tipo ServiçoVO e modifica ele na tabela Peças no banco de dados
	
		conn = getConnection();
		String sql = "update from serviços set valor =  ? where id = ?";
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

	public void excluir(ServiçoVO t) { 
		//Recebe um objeto do tipo ServiçoVO e exclui ele na tabela Peças no banco de dados
	
		conn = getConnection();
		String sql = "delete from serviços where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, t.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<ServiçoVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		conn = getConnection();
		String sql = "select * from serviços";
		Statement st;
		ResultSet rs;
		List<ServiçoVO> serviços = new ArrayList<ServiçoVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				ServiçoVO vo = new ServiçoVO();
				vo.setNome(rs.getString("nome"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				serviços.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serviços;
	}
	

	public ServiçoVO buscar(ServiçoVO t) { 
		//Recebe um objeto do tipo ServiçoVO e busca ele na tabela Peças no banco de dados
	
		conn = getConnection();
		String sql = "select from serviços where id = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			((PreparedStatement) st).setLong(1, t.getId());
			rs = st.executeQuery(sql);
			
			ServiçoVO vo = new ServiçoVO();
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
