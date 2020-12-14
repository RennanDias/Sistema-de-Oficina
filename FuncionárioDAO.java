package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import VO.AutomovelVO;
import VO.FuncionárioVO;
import VO.OrçamentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionárioDAO extends BaseDAO<FuncionárioVO> {
	public FuncionárioVO inserirFuncionário(FuncionárioVO func) throws SQLException { 
		//Recebe um objeto do tipo FuncionárioVO e o cadastra no banco de dados

		String sql = "insert into funcionarios (nome, cpf, endereço, usuario, senha) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			//ptst.setLong(1, func.getId());
			ptst.setString(1, func.getNome());
			ptst.setString(2, func.getCpf());
			ptst.setString(3, func.getEndereço());
			ptst.setString(4, func.getUsuario());
			ptst.setString(5, func.getSenha());
			//ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				func.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return func;
	}
	
	public ObservableList<OrçamentoVO> gerarRelatorios(OrçamentoVO inicio, OrçamentoVO fim) throws SQLException {
		//Recebe um array de objetos do tipo OrçamentoVO para gerar os relatórios
		
		String sql = "select * from orçamentos where data_de_solicitacao between ? and ?";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			st.setDate(1, new java.sql.Date(inicio.getData().getTime()));
			st.setDate(2, new java.sql.Date(fim.getData().getTime()));
			rs = st.executeQuery();
			
			while(rs.next()) {
				OrçamentoVO vo = new OrçamentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setId(rs.getLong("id"));
				//vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setAutomoveis(a);	
				orçamentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orçamentos;
	}
	
	public boolean fazerLogin (FuncionárioVO func) throws SQLException { //Busca, dentro do vetor de funcionários, o funcionário que possui login e senha
		//iguais aos digitados no programa e, por fim, avisa se foi ou não logado com sucesso
		String sql = "select * from funcionarios where usuario = ? and senha = ?";
		PreparedStatement st;
		ResultSet rs;
		boolean logon = false;
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setString(1, func.getUsuario());
			((PreparedStatement) st).setString(2, func.getSenha());
			rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("usuario").equals(func.getUsuario()) && rs.getString("senha").equals(func.getSenha())) {
					logon = true;
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logon;
	}
	
	public OrçamentoVO confirmarOrçamento(OrçamentoVO o) throws SQLException { 
		//Recebe um objeto do tipo OrçamentoVO e verifica se está ou não confirmado. Se não estiver, confirma o orçamento
		OrçamentoDAO dao = new OrçamentoDAO();
		ObservableList<OrçamentoVO> orçamentos = FXCollections.observableArrayList();
		orçamentos = dao.buscar(o);
		for(OrçamentoVO ovo : orçamentos) {
			o = ovo;
		}
		
		String sql = "update from orçamentos set finalizado = true where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, o.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return o;
	}

	@Override
	public FuncionárioVO inserir(FuncionárioVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuncionárioVO modificar(FuncionárioVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(FuncionárioVO vo) {
		// TODO Auto-generated method stub
		
	}

	public ObservableList<FuncionárioVO> buscar(FuncionárioVO func) throws SQLException {

		String sql = "select * from funcionarios";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<FuncionárioVO> funcionarios = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("usuario").equals(func.getUsuario()) && rs.getString("senha").equals(func.getSenha())) {
					FuncionárioVO vo = new FuncionárioVO();
					vo.setId(rs.getLong("id"));
					vo.setNome(rs.getString("nome"));
					vo.setCpf(rs.getString("cpf"));
					vo.setEndereço(rs.getString("endereço"));
					vo.setUsuario(rs.getString("usuario"));
					vo.setSenha(rs.getString("senha"));
					funcionarios.add(vo);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return funcionarios;
	}

	@Override
	public List<FuncionárioVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}
