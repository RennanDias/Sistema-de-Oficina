package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.AutomovelVO;
import VO.OrçamentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrçamentoDAO extends BaseDAO<OrçamentoVO> implements BaseInterDAO<OrçamentoVO>{

	public OrçamentoVO inserir(OrçamentoVO r) throws SQLException { 
		//Recebe um objeto do tipo OrçamentoVO e insere ele no banco de dados na tabela Orçamento

		String sql = "insert into orçamentos (placa_auto, data_de_solicitacao, finalizado, valor_total) values (?,?,?,?)";
		PreparedStatement ptst;
		AutomovelVO a = new AutomovelVO();
		a = r.getAutomoveis();
		
		try {
			//Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, a.getPlaca());
			ptst.setDate(2, new java.sql.Date(r.getData().getTime()));
			ptst.setBoolean(3, r.getFinalizado());
			ptst.setFloat(4, r.getValor());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				r.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
		
	public OrçamentoVO modificar(OrçamentoVO o) throws SQLException {
		//Recebe um objeto do tipo OrçamentoVO e modifica ele no banco de dados na tabela Orçamento	

		String sql = "update orçamentos set (placa_auto, data_de_solicitacao, finalizado, valor_total) =  (?,?,?,?) where id = ?";
		PreparedStatement ptst;
		
		AutomovelVO a = new AutomovelVO();
		a = o.getAutomoveis();
		
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
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

	public void excluir(OrçamentoVO a) throws SQLException { 
		//Recebe um objeto do tipo OrçamentoVO e exclui ele no banco de dados na tabela Orçamento

		String sql = "delete from orçamentos where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst.setLong(1, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public OrçamentoVO atualizar(OrçamentoVO a) throws SQLException { 
		//Recebe um orçamento e atualiza seus dados no banco de dados

		String sql = "update orçamentos set valor_total = ? where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			ptst.setFloat(1, a.getValor());
			ptst.setLong(2, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return a;
	}
	
	public ObservableList<OrçamentoVO> listar() throws SQLException { 
		//Pega os atributos de cada tupla da tabela orçamentos, coloca elas em objetos e cria uma lista

		String sql = "select * from orçamentos";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			rs = st.executeQuery();
			
			while (rs.next()) {
				OrçamentoVO vo = new OrçamentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setId(rs.getLong("id"));
				vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setAutomoveis(a);
				orçamentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orçamentos;
	}
		
	public ObservableList<OrçamentoVO> buscar(OrçamentoVO o) throws SQLException { 
		//Recebe um objeto do tipo OrçamentoVO e busca ele no banco de dados na tabela Orçamento	

		String sql = "select * from orçamentos where id = ? or placa_auto = ?";
		PreparedStatement st;
		ResultSet rs;
		AutomovelVO avo = new AutomovelVO();
		avo = o.getAutomoveis();
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql); //Realiza conexão com o banco de dados a partir do código da string 'sql'
			st.setLong(1, o.getId());
			st.setString(2, avo.getPlaca());
			rs = st.executeQuery();
			
			while(rs.next()){
				OrçamentoVO vo = new OrçamentoVO();
				AutomovelVO a = new AutomovelVO();

				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setId(rs.getLong("id"));
				vo.setAutomoveis(a);
				orçamentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orçamentos;
	}
	
}
