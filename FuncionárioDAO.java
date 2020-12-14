package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import VO.AutomovelVO;
import VO.Funcion�rioVO;
import VO.Or�amentoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Funcion�rioDAO extends BaseDAO<Funcion�rioVO> {
	public Funcion�rioVO inserirFuncion�rio(Funcion�rioVO func) throws SQLException { 
		//Recebe um objeto do tipo Funcion�rioVO e o cadastra no banco de dados

		String sql = "insert into funcionarios (nome, cpf, endere�o, usuario, senha) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			//ptst.setLong(1, func.getId());
			ptst.setString(1, func.getNome());
			ptst.setString(2, func.getCpf());
			ptst.setString(3, func.getEndere�o());
			ptst.setString(4, func.getUsuario());
			ptst.setString(5, func.getSenha());
			//ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				func.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhum id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return func;
	}
	
	public ObservableList<Or�amentoVO> gerarRelatorios(Or�amentoVO inicio, Or�amentoVO fim) throws SQLException {
		//Recebe um array de objetos do tipo Or�amentoVO para gerar os relat�rios
		
		String sql = "select * from or�amentos where data_de_solicitacao between ? and ?";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			st.setDate(1, new java.sql.Date(inicio.getData().getTime()));
			st.setDate(2, new java.sql.Date(fim.getData().getTime()));
			rs = st.executeQuery();
			
			while(rs.next()) {
				Or�amentoVO vo = new Or�amentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setId(rs.getLong("id"));
				//vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setAutomoveis(a);	
				or�amentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return or�amentos;
	}
	
	public boolean fazerLogin (Funcion�rioVO func) throws SQLException { //Busca, dentro do vetor de funcion�rios, o funcion�rio que possui login e senha
		//iguais aos digitados no programa e, por fim, avisa se foi ou n�o logado com sucesso
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
	
	public Or�amentoVO confirmarOr�amento(Or�amentoVO o) throws SQLException { 
		//Recebe um objeto do tipo Or�amentoVO e verifica se est� ou n�o confirmado. Se n�o estiver, confirma o or�amento
		Or�amentoDAO dao = new Or�amentoDAO();
		ObservableList<Or�amentoVO> or�amentos = FXCollections.observableArrayList();
		or�amentos = dao.buscar(o);
		for(Or�amentoVO ovo : or�amentos) {
			o = ovo;
		}
		
		String sql = "update from or�amentos set finalizado = true where id = ?";
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
	public Funcion�rioVO inserir(Funcion�rioVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcion�rioVO modificar(Funcion�rioVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Funcion�rioVO vo) {
		// TODO Auto-generated method stub
		
	}

	public ObservableList<Funcion�rioVO> buscar(Funcion�rioVO func) throws SQLException {

		String sql = "select * from funcionarios";
		PreparedStatement st;
		ResultSet rs;
		ObservableList<Funcion�rioVO> funcionarios = FXCollections.observableArrayList();
		
		try {
			st = getConnection().prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("usuario").equals(func.getUsuario()) && rs.getString("senha").equals(func.getSenha())) {
					Funcion�rioVO vo = new Funcion�rioVO();
					vo.setId(rs.getLong("id"));
					vo.setNome(rs.getString("nome"));
					vo.setCpf(rs.getString("cpf"));
					vo.setEndere�o(rs.getString("endere�o"));
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
	public List<Funcion�rioVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}
