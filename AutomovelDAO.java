package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.ClientesVO;

public class AutomovelDAO extends BaseDAO implements BaseInterDAO <AutomovelVO>{
	public AutomovelVO inserir(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e insere ele no banco de dados na tabela Automovel
		
		conn = getConnection();
		String sql = "insert into automoveis (cpf_cliente, placa, marca, modelo, cor, ano, quilometragem) values (?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		
		ClientesVO c = new ClientesVO();
		c = a.getDono();
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, c.getCpf());
			ptst.setString(2, a.getPlaca());
			ptst.setString(3, a.getMarca());
			ptst.setString(4, a.getModelo());
			ptst.setString(5, a.getCor());
			ptst.setInt(6, a.getAno());
			ptst.setInt(7, a.getQuilometragem());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return a;
	}

	
	public AutomovelVO modificar(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e altera ele no banco de dados na tabela Automovel
		
		conn = getConnection();
		String sql = "update from automoveis set placa =  ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, a.getPlaca());
			ptst.setLong(2, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	public void excluir(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e exclui ele no banco de dados na tabela Automovel
		
		conn = getConnection();
		String sql = "delete from automoveis where placa =  ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, a.getPlaca());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<AutomovelVO> listar() { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		conn = getConnection();
		String sql = "select * from automoveis";
		Statement st;
		ResultSet rs;
		List<AutomovelVO> automoveis = new ArrayList<AutomovelVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				AutomovelVO vo = new AutomovelVO();
				ClientesVO c = new ClientesVO();
				
				c.setCpf(rs.getString("cpf_cliente"));
				vo.setPlaca(rs.getString("placa"));
				vo.setMarca(rs.getString("marca"));
				vo.setModelo(rs.getString("modelo"));
				vo.setCor(rs.getString("cor"));
				vo.setAno(rs.getInt("ano"));
				vo.setQuilometragem(rs.getInt("quilometragem"));
				vo.setId(rs.getLong("id"));
				vo.setDono(c);
				automoveis.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return automoveis;
	}
	
	public AutomovelVO buscar(AutomovelVO a) { 
		//Recebe um objeto do tipo AutomovelVO e busca ele no banco de dados na tabela Automovel	
		
		conn = getConnection();
		String sql = "select from automoveis where placa = ?";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			((PreparedStatement) st).setString(1, a.getPlaca());
			rs = st.executeQuery(sql);
			
			AutomovelVO vo = new AutomovelVO();
			ClientesVO c = new ClientesVO();
			
			c.setCpf(rs.getString("cpf_cliente"));
			vo.setPlaca(rs.getString("placa"));
			vo.setMarca(rs.getString("marca"));
			vo.setModelo(rs.getString("modelo"));
			vo.setCor(rs.getString("cor"));
			vo.setAno(rs.getInt("ano"));
			vo.setQuilometragem(rs.getInt("quilometragem"));
			vo.setId(rs.getLong("id"));
			vo.setDono(c);
			
			a = vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

}
