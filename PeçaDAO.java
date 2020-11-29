package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.Pe�aVO;

public class Pe�aDAO extends BaseDAO implements BaseInterDAO <Pe�aVO>{

	public Pe�aVO inserir(Pe�aVO p) { 		
		//Recebe um objeto do tipo Pe�aVO e insere ele na tabela Pe�as no banco de dados
		
		conn = getConnection();
		String sql = "insert into pe�as (nome, modelo_auto, fabricante, valor) values (?,?,?,?)";
		PreparedStatement ptst;
		
		AutomovelVO avo = new AutomovelVO();
		avo = p.getAutomoveis();
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, p.getNome());
			ptst.setString(2, avo.getModelo());
			ptst.setString(3, p.getFabricante());
			ptst.setFloat(4, p.getValor());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
		
	public Pe�aVO modificar(Pe�aVO p) {
		//Recebe um objeto do tipo Pe�aVO e insere ele na tabela Pe�as no banco de dados	
		
		conn = getConnection();
		String sql = "update from pe�as set valor =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
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
		
		conn = getConnection();
		String sql = "delete from pe�as where id =  ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, p.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public List<Pe�aVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		conn = getConnection();
		String sql = "select * from pe�as";
		Statement st;
		ResultSet rs;
		List<Pe�aVO> pe�as = new ArrayList<Pe�aVO>();
		
		try {
			st = conn.createStatement();
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
		
		conn = getConnection();
		String sql = "select from pe�as where id = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			((PreparedStatement) st).setLong(1, p.getId());
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