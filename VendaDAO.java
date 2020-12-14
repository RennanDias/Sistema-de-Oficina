package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.OrçamentoVO;
import VO.VendaVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VendaDAO extends BaseDAO<VendaVO>{
	/*public VendaVO inserirPeça(VendaVO v) { 		
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados
		PeçaVO p = new PeçaVO();
		OrçamentoVO o = new OrçamentoVO();
		
		
		p = v.getP();
		o = v.getO();
		String sql = "insert into vendas (id_orcamento, nome, quantidade, preco) values (?,?,1,?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, o.getId());
			ptst.setString(2, p.getNome());
			//ptst.setInt(3, p.getQuantidade());
			ptst.setFloat(3, p.getValor());
			ptst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return v;
	}

	/*public VendaVO inserirServiço(VendaVO v) { 		
		//Recebe um objeto do tipo PeçaVO e insere ele na tabela Peças no banco de dados
		ServiçoVO s = new ServiçoVO();
		OrçamentoVO o = new OrçamentoVO();
		
		s = v.getS();
		o = v.getO();
		String sql = "insert into vendas (id_orcamento, nome, quantidade, preco) values (?,?,1,?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, o.getId());
			ptst.setString(2, s.getNome());
			//ptst.setInt(3, s.getQuantidade());
			ptst.setFloat(3, s.getValor());
			ptst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return v;
	}*/
	
	public VendaVO modificarItem(VendaVO v, VendaVO antigo) throws SQLException {
		OrçamentoVO o = new OrçamentoVO();
		o = v.getO();

		String sql = "update vendas set (nome, quantidade, preco) = (?,?,?) where (id_orcamento, nome) = (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, v.getNome());
			ptst.setInt(2, v.getQuantidade());
			ptst.setFloat(3, v.getValor());
			ptst.setLong(4, o.getId());
			ptst.setString(5, antigo.getNome());
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	public VendaVO inserir(VendaVO vo) throws SQLException {
		
		OrçamentoVO o = new OrçamentoVO();
		
		o = vo.getO();
		String sql = "insert into vendas (id_orcamento, nome, quantidade, preco) values (?,?,?,?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, o.getId());
			ptst.setString(2, vo.getNome());
			ptst.setInt(3, vo.getQuantidade());
			ptst.setFloat(4, vo.getValor());
			ptst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	public VendaVO inserirItem(VendaVO vo) throws SQLException {
		
		OrçamentoVO o = new OrçamentoVO();
		
		o = vo.getO();
		String sql = "insert into venda_nova (id_orcamento, nome, quantidade, preco) values (?,?,?,?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, o.getId());
			ptst.setString(2, vo.getNome());
			ptst.setInt(3, vo.getQuantidade());
			ptst.setFloat(4, vo.getValor());
			ptst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public VendaVO modificar(VendaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(VendaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObservableList<VendaVO> buscar(VendaVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void resetarTabela() {
		String sql = "drop table venda_nova";
		PreparedStatement st;
		
		try {
			st = getConnection().prepareStatement(sql);
			st.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "create table venda_nova (id_orcamento integer,\r\n" + 
				"  nome character varying(30),\r\n" + 
				"  quantidade integer,\r\n" + 
				"  preco double precision,\r\n" + 
				"  CONSTRAINT vendas_id_orcamento_fkey FOREIGN KEY (id_orcamento)\r\n" + 
				"      REFERENCES \"orçamentos\" (id) MATCH SIMPLE\r\n" + 
				"      ON UPDATE CASCADE ON DELETE CASCADE)";
		try {
			st = getConnection().prepareStatement(sql);
			st.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "create or replace rule venda_log as\r\n" + 
				"on insert to venda_nova\r\n" + 
				"do insert into vendas \r\n" + 
				"values (new.id_orcamento, new.nome, new.quantidade, new.preco)";
		try {
			st = getConnection().prepareStatement(sql);
			st.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public ObservableList<VendaVO> listarBusca(OrçamentoVO o){
		
		String sql = "select * from vendas where id_orcamento = ?";
		PreparedStatement st;
		ResultSet rs;
		//OrçamentoVO o = new OrçamentoVO();
		//o = vvo.getO();
		ObservableList<VendaVO> vendas = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, o.getId());
			rs = st.executeQuery();
			
			while (rs.next()) {
				VendaVO vo = new VendaVO();
				OrçamentoVO orc = new OrçamentoVO();
				
				orc.setId(rs.getLong("id_orcamento"));
				vo.setNome(rs.getString("nome"));
				vo.setQuantidade(rs.getInt("quantidade"));
				vo.setValor(rs.getFloat("preco"));
				vo.setO(orc);
				vendas.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendas;
	}
	
	public ObservableList<VendaVO> listar(){
		
		String sql = "select * from venda_nova";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<VendaVO> vendas = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery();
			
			while (rs.next()) {
				VendaVO vo = new VendaVO();
				OrçamentoVO o = new OrçamentoVO();
				
				o.setId(rs.getLong("id_orcamento"));
				vo.setNome(rs.getString("nome"));
				vo.setQuantidade(rs.getInt("quantidade"));
				vo.setValor(rs.getFloat("preco"));
				vo.setO(o);
				vendas.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendas;
	}

}
