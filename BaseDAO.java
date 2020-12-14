package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;

public abstract class BaseDAO<VO> {

	private static Connection conn = null;
	private static final String url = "jdbc:postgresql://localhost:5432/";
	private static final String user = "postgres";
	private static final String senha = "060402re";
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url,user,senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return conn;
		}
		else {
			return conn;
		}
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public abstract VO inserir(VO vo) throws SQLException;
	public abstract VO modificar(VO vo) throws SQLException;
	public abstract void excluir(VO vo) throws SQLException;
	public abstract ObservableList<VO> buscar(VO vo) throws SQLException;
	public abstract List<VO> listar() throws SQLException;
}
