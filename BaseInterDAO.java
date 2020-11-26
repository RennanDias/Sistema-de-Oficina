package DAO;

public interface BaseInterDAO <VO>{
	public VO inserir(VO a);
	public VO modificar(VO a);
	public void excluir(VO a);
	public VO buscar(VO a);
}
