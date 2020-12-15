package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.ClientesVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientesDAO extends BaseDAO<ClientesVO> implements BaseInterDAO <ClientesVO>{
	
	public ClientesVO inserir(ClientesVO c) throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e insere ele no banco de dados na tabela Clientes
		
		String sql = "insert into clientes (nome, cpf, endereço) values (?,?,?)";
		PreparedStatement ptst;
		
		try {
			//Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			ptst.setString(1, c.getNome());
			ptst.setString(2, c.getCpf());
			ptst.setString(3, c.getEndereço());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				c.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public ClientesVO modificar(ClientesVO c) throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e altera ele no banco de dados na tabela Clientes
		
		String sql = "update clientes set (nome,cpf,endereço) =  (?,?,?) where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst.setString(1, c.getNome());
			ptst.setString(2, c.getCpf());
			ptst.setString(3, c.getEndereço());
			ptst.setLong(4, c.getId());
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
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst.setString(1, c.getCpf());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public ObservableList<ClientesVO> listar() throws SQLException { 
		//Pega os valores contidos nas tuplas da tabela clientes no banco de dados e transforma em uma lista
	
		String sql = "select * from clientes";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<ClientesVO> clientes = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			rs = st.executeQuery();
			
			while (rs.next()) {
				ClientesVO vo = new ClientesVO();
				vo.setId(rs.getLong("id"));
				vo.setNome(rs.getString("nome"));
				vo.setCpf(rs.getString("cpf"));
				vo.setEndereço(rs.getString("endereço"));
				clientes.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	
	public ObservableList<ClientesVO> buscar(ClientesVO c) throws SQLException{ 
		//Pega o valor contido numa tupla específica da tabela clientes no banco de dados e transforma em uma lista
		
		String sql = "select * from clientes where nome = ? or cpf = ? or id = ?";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<ClientesVO> clientes = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			st.setString(1, c.getNome());
			st.setString(2, c.getCpf());
			st.setLong(3, c.getId());
			rs = st.executeQuery();
			
			while(rs.next()) {
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

}

