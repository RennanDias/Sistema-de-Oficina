package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.ClientesVO;

public class ClientesDAO extends BaseDAO<ClientesVO> implements BaseInterDAO <ClientesVO>{
	
	public ClientesVO inserir(ClientesVO c) throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e insere ele no banco de dados na tabela Clientes
		
		String sql = "insert into clientes (nome, cpf, endereço) values (?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			//ptst.setLong(1, c.getId());
			ptst.setString(1, c.getNome());
			ptst.setString(2, c.getCpf());
			ptst.setString(3, c.getEndereço());
			ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				c.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhu id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public ClientesVO modificar(ClientesVO c) throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e altera ele no banco de dados na tabela Clientes
		
		String sql = "update clientes set nome =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, c.getNome());
			ptst.setLong(2, c.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	public void excluir(ClientesVO c) throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		String sql = "delete from clientes where cpf =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, c.getCpf());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<ClientesVO> listar() throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		String sql = "select * from clientes";
		Statement st;
		ResultSet rs;
		List<ClientesVO> clientes = new ArrayList<ClientesVO>();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				ClientesVO vo = new ClientesVO();
				vo.setNome(rs.getString("nome"));
				vo.setCpf(rs.getString("cpf"));
				vo.setEndereço(rs.getString("endereço"));
				vo.setId(rs.getLong("id"));
				clientes.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	
	public ClientesVO buscar(ClientesVO c) throws SQLException{ 
		//Recebe um objeto do tipo ClientesVO e busca ele na tabela Clientes no banco de dados
		
		String sql = "select from clientes where cpf = ? or where nome = ? or where id = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setString(1, c.getCpf());
			((PreparedStatement) st).setString(2, c.getNome());
			((PreparedStatement) st).setLong(3, c.getId());
			rs = st.executeQuery(sql);
			
			ClientesVO vo = new ClientesVO();
			vo.setNome(rs.getString("nome"));
			vo.setCpf(rs.getString("cpf"));
			vo.setEndereço(rs.getString("endereço"));
			vo.setId(rs.getLong("id"));
			
			c = vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

}

