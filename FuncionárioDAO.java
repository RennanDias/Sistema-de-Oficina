package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.AutomovelVO;
import VO.Funcion�rioVO;
import VO.Or�amentoVO;

public class Funcion�rioDAO extends BaseDAO<Funcion�rioVO> {
	public Funcion�rioVO inserirFuncion�rio(Funcion�rioVO func) { 
		//Recebe um objeto do tipo Funcion�rioVO e o cadastra no banco de dados

		String sql = "insert into funcionarios (id, nome, cpf, endere�o, usuario, senha) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, func.getId());
			ptst.setString(2, func.getNome());
			ptst.setString(3, func.getCpf());
			ptst.setString(4, func.getEndere�o());
			ptst.setString(5, func.getUsuario());
			ptst.setString(6, func.getSenha());
			ptst.execute();
			
			/*int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				func.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhu id foi retornado.");
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return func;
	}
	
	public List<Or�amentoVO> gerarRelatorios(Or�amentoVO inicio, Or�amentoVO fim) {
		//Recebe um array de objetos do tipo Or�amentoVO para gerar os relat�rios
		
		String sql = "select from or�amentos where data between ? and ?";
		Statement st;
		ResultSet rs;
		List<Or�amentoVO> or�amentos = new ArrayList<Or�amentoVO>();
		
		try {
			st = getConnection().prepareStatement(sql);
			((PreparedStatement) st).setDate(1, (Date) inicio.getData());
			((PreparedStatement) st).setDate(2, (Date) fim.getData());
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Or�amentoVO vo = new Or�amentoVO();
				AutomovelVO a = new AutomovelVO();
				
				a.setPlaca(rs.getString("placa_auto"));
				vo.setData(rs.getDate("data_de_solicitacao"));
				vo.setValor(rs.getFloat("valor_total"));
				vo.setId(rs.getLong("id"));
				vo.setFinalizado(rs.getBoolean("finalizado"));
				vo.setAutomoveis(a);	
				or�amentos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return or�amentos;
	}
	
	public boolean fazerLogin (Funcion�rioVO func) { //Busca, dentro do vetor de funcion�rios, o funcion�rio que possui login e senha
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
	
	public Or�amentoVO confirmarOr�amento(Or�amentoVO o) { 
		//Recebe um objeto do tipo Or�amentoVO e verifica se est� ou n�o confirmado. Se n�o estiver, confirma o or�amento
		Or�amentoDAO dao = new Or�amentoDAO();
		o = dao.buscar(o);
		
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

	public Funcion�rioVO buscar(Funcion�rioVO func) /*throws SQLException*/ {

		String sql = "select * from funcionarios";
		PreparedStatement st;
		ResultSet rs;
		//List<Funcion�rioVO> funcionarios = new ArrayList<Funcion�rioVO>();
		
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
					func = vo;
					//else {
					//	System.out.println("Senha incorreta!");
					//}
				//}
				//else {
					//System.out.println("Login incorreto!");
				}
			}
			
			/*for(Funcion�rioVO lvo: funcionarios) {
				if(lvo.getUsuario().equals(func.getUsuario()) && lvo.getSenha().equals(func.getSenha())) {
					func = lvo;
					break;
				}				
			}*/
			//func = vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return func;
	}

	@Override
	public List<Funcion�rioVO> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}
