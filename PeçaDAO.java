package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.Pe�aVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pe�aDAO extends BaseDAO<Pe�aVO> implements BaseInterDAO <Pe�aVO>{

	public Pe�aVO inserir(Pe�aVO p) throws SQLException { 		
		//Recebe um objeto do tipo Pe�aVO e insere ele na tabela Pe�as no banco de dados

		String sql = "insert into pe�as (nome, fabricante, valor) values (?,?,?)";
		PreparedStatement ptst;
		
		try {
			//Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, p.getNome());
			ptst.setString(2, p.getFabricante());
			ptst.setFloat(3, p.getValor());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				p.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
		
	public Pe�aVO modificar(Pe�aVO p) throws SQLException {
		//Recebe um objeto do tipo Pe�aVO e insere ele na tabela Pe�as no banco de dados	

		String sql = "update pe�as set (nome, fabricante, valor) = (?,?,?) where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			ptst.setString(1, p.getNome());
			ptst.setString(2, p.getFabricante());
			ptst.setFloat(3, p.getValor());
			ptst.setLong(4, p.getId());
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public void excluir(Pe�aVO p) throws SQLException {
		//Recebe um objeto do tipo Pe�aVO e exclui ele na tabela Pe�as no banco de dados	

		String sql = "delete from pe�as where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			ptst.setLong(1, p.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public ObservableList<Pe�aVO> listar() throws SQLException { 
		//Pega os atributos das tuplas da tabela pe�as e coloca em objetos e forma uma lista

		String sql = "select * from pe�as";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<Pe�aVO> pe�as = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			rs = st.executeQuery();
			
			while (rs.next()) {
				Pe�aVO vo = new Pe�aVO();
				vo.setNome(rs.getString("nome"));
				vo.setFabricante(rs.getString("fabricante"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				pe�as.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pe�as;
	}
	
	public ObservableList<Pe�aVO> buscar(Pe�aVO p) throws SQLException { 
		//Lista as pe�as no banco de dados e separa uma espec�fica

		String sql = "select * from pe�as where nome = ? or id = ? or fabricante = ?";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<Pe�aVO> pe�as = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			st.setString(1, p.getNome());
			st.setLong(2, p.getId());
			st.setString(3, p.getFabricante());
			rs = st.executeQuery();
			
			while (rs.next()) {
				Pe�aVO vo = new Pe�aVO();
				vo.setNome(rs.getString("nome"));
				vo.setFabricante(rs.getString("fabricante"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				pe�as.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pe�as;
	}
		
}