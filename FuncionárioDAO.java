package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.ClientesVO;
import VO.FuncionárioVO;
import VO.OrçamentoVO;

public class FuncionárioDAO extends BaseDAO<FuncionárioVO> {
	public FuncionárioVO inserirFuncionário(FuncionárioVO func) { 
		//Recebe um objeto do tipo FuncionárioVO e o cadastra no banco de dados

		String sql = "insert into funcionarios (nome, cpf, endereço, usuario, senha) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, func.getNome());
			ptst.setString(2, func.getCpf());
			ptst.setString(3, func.getEndereço());
			ptst.setString(4, func.getUsuario());
			ptst.setString(5, func.getSenha());
			ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				func.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhu id foi retornado.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return func;
	}
	
	public List<OrçamentoVO> gerarRelatorios(OrçamentoVO inicio, OrçamentoVO fim) {
		//Recebe um array de objetos do tipo OrçamentoVO para gerar os relatórios
		
		String sql = "select from orçamentos where data between ? and ?";
		Statement st;
		ResultSet rs;
		List<OrçamentoVO> orçamentos = new ArrayList<OrçamentoVO>();
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setDate(1, (Date) inicio.getData());
			((PreparedStatement) st).setDate(2, (Date) fim.getData());
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				OrçamentoVO vo = new OrçamentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
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
	
	public boolean fazerLogin (FuncionárioVO func) { //Busca, dentro do vetor de funcionários, o funcionário que possui login e senha
		//iguais aos digitados no programa e, por fim, avisa se foi ou não logado com sucesso
		String sql = "select from funcionarios where usuario = ? and where senha = ?";
		Statement st;
		boolean logon = false;
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setString(1, func.getUsuario());
			((PreparedStatement) st).setString(2, func.getSenha());

			logon = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logon;
	}
	
	public OrçamentoVO confirmarOrçamento(OrçamentoVO o) { 
		//Recebe um objeto do tipo OrçamentoVO e verifica se está ou não confirmado. Se não estiver, confirma o orçamento
		OrçamentoDAO dao = new OrçamentoDAO();
		o = dao.buscar(o);
		
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
	public FuncionárioVO inserir(FuncionárioVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuncionárioVO modificar(FuncionárioVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(FuncionárioVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FuncionárioVO buscar(FuncionárioVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionárioVO> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
