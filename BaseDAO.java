package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

	Connection conn = null;
	String url = "jdbc:postgresql://localhost:5432/";
	String user = "postgres";
	String senha = "060402re";
	
	public Connection getConnection() {
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
}
