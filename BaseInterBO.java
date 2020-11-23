package BO;

public interface BaseInterBO <VO>{
	public VO adicionar(VO a);
	public VO alterar(VO a);
	public void deletar(VO a);
	public VO pesquisar(VO a);
}
