package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.ServiçoVO;

public class ServiçoDAO extends BaseDAO<ServiçoVO> implements BaseInterDAO <ServiçoVO>{

	public ServiçoVO inserir(ServiçoVO t) { 
		//Recebe um objeto do tipo ServiçoVO e insere ele na tabela Peças no banco de dados

		String sql = "insert into serviços (nome, valor) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, t.getNome());
			ptst.setFloat(2, t.getValor());
			ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				t.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhu id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return t;
	}
	
	public ServiçoVO modificar(ServiçoVO t) { 
		//Recebe um objeto do tipo ServiçoVO e modifica ele na tabela Peças no banco de dados

		String sql = "update from serviços set valor =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
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

		String sql = "delete from serviços where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, t.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<ServiçoVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados

		String sql = "select * from serviços";
		Statement st;
		ResultSet rs;
		List<ServiçoVO> serviços = new ArrayList<ServiçoVO>();
		
		try {
			st = getConnection().prepareStatement(sql);
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

		String sql = "select from serviços where id = ? or nome = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setLong(1, t.getId());
			((PreparedStatement) st).setString(2, t.getNome());
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
