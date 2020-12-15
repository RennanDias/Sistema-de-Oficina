package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.PeçaVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PeçaDAO extends BaseDAO<PeçaVO> implements BaseInterDAO <PeçaVO>{

	public PeçaVO inserir(PeçaVO p) throws SQLException { 		
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados

		String sql = "insert into peças (nome, fabricante, valor) values (?,?,?)";
		PreparedStatement ptst;
		
		try {
			//Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, p.getNome());
			ptst.setString(2, p.getFabricante());
			ptst.setFloat(3, p.getValor());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				p.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
		
	public PeçaVO modificar(PeçaVO p) throws SQLException {
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados	

		String sql = "update peças set (nome, fabricante, valor) = (?,?,?) where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
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

	public void excluir(PeçaVO p) throws SQLException {
		//Recebe um objeto do tipo PeçaVO e exclui ele na tabela Peças no banco de dados	

		String sql = "delete from peças where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst.setLong(1, p.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public ObservableList<PeçaVO> listar() throws SQLException { 
		//Pega os atributos das tuplas da tabela peças e coloca em objetos e forma uma lista

		String sql = "select * from peças";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<PeçaVO> peças = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			rs = st.executeQuery();
			
			while (rs.next()) {
				PeçaVO vo = new PeçaVO();
				vo.setNome(rs.getString("nome"));
				vo.setFabricante(rs.getString("fabricante"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				peças.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peças;
	}
	
	public ObservableList<PeçaVO> buscar(PeçaVO p) throws SQLException { 
		//Lista as peças no banco de dados e separa uma específica

		String sql = "select * from peças where nome = ? or id = ? or fabricante = ?";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<PeçaVO> peças = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			st.setString(1, p.getNome());
			st.setLong(2, p.getId());
			st.setString(3, p.getFabricante());
			rs = st.executeQuery();
			
			while (rs.next()) {
				PeçaVO vo = new PeçaVO();
				vo.setNome(rs.getString("nome"));
				vo.setFabricante(rs.getString("fabricante"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				peças.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return peças;
	}
		
}