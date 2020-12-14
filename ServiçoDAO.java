package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.Servi�oVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Servi�oDAO extends BaseDAO<Servi�oVO> implements BaseInterDAO <Servi�oVO>{

	public Servi�oVO inserir(Servi�oVO t) throws SQLException { 
		//Recebe um objeto do tipo Servi�oVO e insere ele na tabela Pe�as no banco de dados

		String sql = "insert into servi�os (nome, valor) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, t.getNome());
			ptst.setFloat(2, t.getValor());
			//ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				t.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return t;
	}
	
	public Servi�oVO modificar(Servi�oVO t) throws SQLException { 
		//Recebe um objeto do tipo Servi�oVO e modifica ele na tabela Pe�as no banco de dados

		String sql = "update servi�os set (nome, valor) =  (?,?) where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, t.getNome());
			ptst.setFloat(2, t.getValor());
			ptst.setLong(3, t.getId());
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return t;
	}

	public void excluir(Servi�oVO t) throws SQLException { 
		//Recebe um objeto do tipo Servi�oVO e exclui ele na tabela Pe�as no banco de dados

		String sql = "delete from servi�os where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, t.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public ObservableList<Servi�oVO> listar() throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados

		String sql = "select * from servi�os";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<Servi�oVO> servi�os = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery();
			
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
	

	public ObservableList<Servi�oVO> buscar(Servi�oVO t) throws SQLException { 
		//Recebe um objeto do tipo Servi�oVO e busca ele na tabela Pe�as no banco de dados

		String sql = "select * from servi�os where nome = ? or id = ?";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<Servi�oVO> servi�os = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, t.getNome());
			st.setLong(2, t.getId());
			rs = st.executeQuery();
			
			while(rs.next()) {
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
	
	
}
