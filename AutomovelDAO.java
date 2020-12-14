package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.AutomovelVO;
import VO.ClientesVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AutomovelDAO extends BaseDAO<AutomovelVO> implements BaseInterDAO <AutomovelVO>{
	public AutomovelVO inserir(AutomovelVO a) throws SQLException{ 
		//Recebe um objeto do tipo AutomovelVO e insere ele no banco de dados na tabela Automovel
		
		String sql = "insert into automoveis (cpf_cliente, placa, marca, modelo, cor, ano, quilometragem) values (?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		
		ClientesVO c = new ClientesVO();
		c = a.getDono();
		
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//ptst.setLong(1, a.getId());
			ptst.setString(1, c.getCpf());
			ptst.setString(2, a.getPlaca());
			ptst.setString(3, a.getMarca());
			ptst.setString(4, a.getModelo());
			ptst.setString(5, a.getCor());
			ptst.setInt(6, a.getAno());
			ptst.setInt(7, a.getQuilometragem());
			//ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				a.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhu id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return a;
	}

	
	public AutomovelVO modificar(AutomovelVO a) throws SQLException { 
		//Recebe um objeto do tipo AutomovelVO e altera ele no banco de dados na tabela Automovel
		
		String sql = "update automoveis set (placa, marca, modelo, cor, ano, quilometragem) =  (?,?,?,?,?,?) where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, a.getPlaca());
			ptst.setString(2, a.getMarca());
			ptst.setString(3, a.getModelo());
			ptst.setString(4, a.getCor());
			ptst.setInt(5, a.getAno());
			ptst.setInt(6, a.getQuilometragem());
			ptst.setLong(7, a.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	public void excluir(AutomovelVO a) throws SQLException { 
		//Recebe um objeto do tipo AutomovelVO e exclui ele no banco de dados na tabela Automovel
		
		String sql = "delete from automoveis where placa =  ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, a.getPlaca());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<AutomovelVO> listar() throws SQLException { 
		//Recebe um objeto do tipo ClientesVO e exclui ele da tabela Clientes no banco de dados
	
		String sql = "select * from visao_auto";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery();
			
			while (rs.next()) {
				AutomovelVO vo = new AutomovelVO();
				ClientesVO c = new ClientesVO();
				
				c.setCpf(rs.getString("cpf_cliente"));
				vo.setPlaca(rs.getString("placa"));
				vo.setMarca(rs.getString("marca"));
				vo.setModelo(rs.getString("modelo"));
				//vo.setCor(rs.getString("cor"));
				vo.setAno(rs.getInt("ano"));
				//vo.setQuilometragem(rs.getInt("quilometragem"));
				vo.setId(rs.getLong("id"));
				vo.setDono(c);
				automoveis.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return automoveis;
	}
	
	public ObservableList<AutomovelVO> buscar(AutomovelVO a)/*throws SQLException*/ { 
		//Recebe um objeto do tipo AutomovelVO e busca ele no banco de dados na tabela Automovel	
		
		String sql = "select * from visao_auto where id = ? or placa = ? or cpf_cliente = ?";
		PreparedStatement st;
		ResultSet rs;
		ClientesVO cvo = new ClientesVO();
		cvo = a.getDono();
		ObservableList<AutomovelVO> automoveis = FXCollections.observableArrayList();
		
		try {
			
			st = getConnection().prepareStatement(sql);
			st.setLong(1, a.getId());
			st.setString(2, a.getPlaca());
			st.setString(3, cvo.getCpf());
			rs = st.executeQuery();
			
			while(rs.next()) {
				AutomovelVO vo = new AutomovelVO();
				ClientesVO c = new ClientesVO();
				//c = a.getDono();
				c.setCpf(rs.getString("cpf_cliente"));
				vo.setPlaca(rs.getString("placa"));
				vo.setMarca(rs.getString("marca"));
				vo.setModelo(rs.getString("modelo"));
				//vo.setCor(rs.getString("cor"));
				vo.setAno(rs.getInt("ano"));
				//vo.setQuilometragem(rs.getInt("quilometragem"));
				vo.setId(rs.getLong("id"));
				vo.setDono(c);
				automoveis.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return automoveis;
	}

}
