package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.Pe�aVO;

public class Pe�aDAO extends BaseDAO<Pe�aVO> implements BaseInterDAO <Pe�aVO>{

	public Pe�aVO inserir(Pe�aVO p) { 		
		//Recebe um objeto do tipo Pe�aVO e insere ele na tabela Pe�as no banco de dados

		String sql = "insert into pe�as (nome, modelo_auto, fabricante, valor) values (?,?,?,?)";
		PreparedStatement ptst;
		
		AutomovelVO avo = new AutomovelVO();
		avo = p.getAutomoveis();
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, p.getNome());
			ptst.setString(2, avo.getModelo());
			ptst.setString(3, p.getFabricante());
			ptst.setFloat(4, p.getValor());
			ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				p.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhu id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
		
	public Pe�aVO modificar(Pe�aVO p) {
		//Recebe um objeto do tipo Pe�aVO e insere ele na tabela Pe�as no banco de dados	

		String sql = "update from pe�as set valor =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setFloat(1, p.getValor());
			ptst.setLong(2, p.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public void excluir(Pe�aVO p) {
		//Recebe um objeto do tipo Pe�aVO e exclui ele na tabela Pe�as no banco de dados	

		String sql = "delete from pe�as where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, p.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public List<Pe�aVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados

		String sql = "select * from pe�as";
		Statement st;
		ResultSet rs;
		List<Pe�aVO> pe�as = new ArrayList<Pe�aVO>();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Pe�aVO vo = new Pe�aVO();
				AutomovelVO avo = new AutomovelVO();
				vo.setNome(rs.getString("nome"));
				avo.setModelo(rs.getString("modelo_auto"));
				vo.setFabricante(rs.getString("fabricante"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				vo.setAutomoveis(avo);
				pe�as.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pe�as;
	}
	
	public Pe�aVO buscar(Pe�aVO p) { 
		//Recebe um objeto do tipo Pe�aVO e busca ele na tabela Pe�as no banco de dados	

		String sql = "select from pe�as where id = ? or nome = ? or fabricante = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setLong(1, p.getId());
			((PreparedStatement) st).setString(2, p.getNome());
			((PreparedStatement) st).setString(3, p.getFabricante());
			rs = st.executeQuery(sql);
			
			Pe�aVO vo = new Pe�aVO();
			AutomovelVO avo = new AutomovelVO();
			avo = vo.getAutomoveis();
			vo.setNome(rs.getString("nome"));
			avo.setModelo(rs.getString("modelo_auto"));
			vo.setFabricante(rs.getString("fabricante"));
			vo.setId(rs.getLong("id"));
			vo.setAutomoveis(avo);
			
			p = vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
		
}