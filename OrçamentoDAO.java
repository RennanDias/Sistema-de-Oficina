package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.AutomovelVO;
import VO.Or�amentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Or�amentoDAO extends BaseDAO<Or�amentoVO> implements BaseInterDAO<Or�amentoVO>{

	public Or�amentoVO inserir(Or�amentoVO r) throws SQLException { 
		//Recebe um objeto do tipo Or�amentoVO e insere ele no banco de dados na tabela Or�amento

		String sql = "insert into or�amentos (placa_auto, data_de_solicitacao, finalizado, valor_total) values (?,?,?,?)";
		PreparedStatement ptst;
		AutomovelVO a = new AutomovelVO();
		a = r.getAutomoveis();
		
		try {
			//Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, a.getPlaca());
			ptst.setDate(2, new java.sql.Date(r.getData().getTime()));
			ptst.setBoolean(3, r.getFinalizado());
			ptst.setFloat(4, r.getValor());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				r.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
		
	public Or�amentoVO modificar(Or�amentoVO o) throws SQLException {
		//Recebe um objeto do tipo Or�amentoVO e modifica ele no banco de dados na tabela Or�amento	

		String sql = "update or�amentos set (placa_auto, data_de_solicitacao, finalizado, valor_total) =  (?,?,?,?) where id = ?";
		PreparedStatement ptst;
		
		AutomovelVO a = new AutomovelVO();
		a = o.getAutomoveis();
		
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			ptst.setString(1, a.getPlaca());
			ptst.setDate(2, new java.sql.Date(o.getData().getTime()));
			ptst.setBoolean(3, o.getFinalizado());
			ptst.setFloat(4, o.getValor());
			ptst.setLong(5, o.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}

	public void excluir(Or�amentoVO a) throws SQLException { 
		//Recebe um objeto do tipo Or�amentoVO e exclui ele no banco de dados na tabela Or�amento

		String sql = "delete from or�amentos where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			ptst.setLong(1, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public Or�amentoVO atualizar(Or�amentoVO a) throws SQLException { 
		//Recebe um or�amento e atualiza seus dados no banco de dados

		String sql = "update or�amentos set valor_total = ? where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			ptst.setFloat(1, a.getValor());
			ptst.setLong(2, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return a;
	}
	
	public ObservableList<Or�amentoVO> listar() throws SQLException { 
		//Pega os atributos de cada tupla da tabela or�amentos, coloca elas em objetos e cria uma lista

		String sql = "select * from or�amentos";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			rs = st.executeQuery();
			
			while (rs.next()) {
				Or�amentoVO vo = new Or�amentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setFinalizado(rs.getBoolean("finalizado"));
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
		
	public ObservableList<Or�amentoVO> buscar(Or�amentoVO o) throws SQLException { 
		//Recebe um objeto do tipo Or�amentoVO e busca ele no banco de dados na tabela Or�amento	

		String sql = "select * from or�amentos where id = ? or placa_auto = ?";
		PreparedStatement st;
		ResultSet rs;
		AutomovelVO avo = new AutomovelVO();
		avo = o.getAutomoveis();
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conex�o com o banco de dados a partir do c�digo da string 'sql'
			st.setLong(1, o.getId());
			st.setString(2, avo.getPlaca());
			rs = st.executeQuery();
			
			while(rs.next()){
				Or�amentoVO vo = new Or�amentoVO();
				AutomovelVO a = new AutomovelVO();

				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setId(rs.getLong("id"));
				vo.setAutomoveis(a);
				or�amentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return or�amentos;
	}
	
}
