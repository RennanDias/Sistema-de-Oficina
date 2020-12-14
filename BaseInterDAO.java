package DAO;

import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;

public interface BaseInterDAO <VO>{
	public VO inserir(VO a) throws SQLException;
	public VO modificar(VO a) throws SQLException;
	public void excluir(VO a) throws SQLException;
	public ObservableList<VO> buscar(VO a) throws SQLException;
	public List<VO> listar() throws SQLException;
}
