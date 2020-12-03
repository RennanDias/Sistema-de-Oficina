package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.PeçaVO;

public class PeçaDAO extends BaseDAO<PeçaVO> implements BaseInterDAO <PeçaVO>{

	public PeçaVO inserir(PeçaVO p) { 		
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados

		String sql = "insert into peças (nome, modelo_auto, fabricante, valor) values (?,?,?,?)";
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
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				p.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhu id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
		
	public PeçaVO modificar(PeçaVO p) {
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados	

		String sql = "update from peças set valor =  ? where id = ?";
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

	public void excluir(PeçaVO p) {
		//Recebe um objeto do tipo PeçaVO e exclui ele na tabela Peças no banco de dados	

		String sql = "delete from peças where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, p.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public List<PeçaVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados

		String sql = "select * from peças";
		Statement st;
		ResultSet rs;
		List<PeçaVO> peças = new ArrayList<PeçaVO>();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				PeçaVO vo = new PeçaVO();
				AutomovelVO avo = new AutomovelVO();
				vo.setNome(rs.getString("nome"));
				avo.setModelo(rs.getString("modelo_auto"));
				vo.setFabricante(rs.getString("fabricante"));
				vo.setValor(rs.getFloat("valor"));
				vo.setId(rs.getLong("id"));
				vo.setAutomoveis(avo);
				peças.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peças;
	}
	
	public PeçaVO buscar(PeçaVO p) { 
		//Recebe um objeto do tipo PeçaVO e busca ele na tabela Peças no banco de dados	

		String sql = "select from peças where id = ? or nome = ? or fabricante = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setLong(1, p.getId());
			((PreparedStatement) st).setString(2, p.getNome());
			((PreparedStatement) st).setString(3, p.getFabricante());
			rs = st.executeQuery(sql);
			
			PeçaVO vo = new PeçaVO();
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