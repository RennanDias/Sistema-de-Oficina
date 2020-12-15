package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.ServiçoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiçoDAO extends BaseDAO<ServiçoVO> implements BaseInterDAO <ServiçoVO>{

	public ServiçoVO inserir(ServiçoVO t) throws SQLException { 
		//Recebe um objeto do tipo ServiçoVO e insere ele na tabela Peças no banco de dados

		String sql = "insert into serviços (nome, valor) values (?,?)";
		PreparedStatement ptst;
		try {
			//Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, t.getNome());
			ptst.setFloat(2, t.getValor());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				t.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return t;
	}
	
	public ServiçoVO modificar(ServiçoVO t) throws SQLException { 
		//Recebe um objeto do tipo ServiçoVO e modifica ele na tabela Peças no banco de dados

		String sql = "update serviços set (nome, valor) =  (?,?) where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst.setString(1, t.getNome());
			ptst.setFloat(2, t.getValor());
			ptst.setLong(3, t.getId());
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return t;
	}

	public void excluir(ServiçoVO t) throws SQLException { 
		//Recebe um objeto do tipo ServiçoVO e exclui ele na tabela Peças no banco de dados

		String sql = "delete from serviços where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst.setLong(1, t.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public ObservableList<ServiçoVO> listar() throws SQLException { 
		//Forma uma lista com os objetos formados com os atributos das tuplas da tabela serviços

		String sql = "select * from serviços";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<ServiçoVO> serviços = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			rs = st.executeQuery();
			
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
	

	public ObservableList<ServiçoVO> buscar(ServiçoVO t) throws SQLException { 
		//Forma uma lista com um serviço específico da tabela serviços

		String sql = "select * from serviços where nome = ? or id = ?";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<ServiçoVO> serviços = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			st.setString(1, t.getNome());
			st.setLong(2, t.getId());
			rs = st.executeQuery();
			
			while(rs.next()) {
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
	
	
}
