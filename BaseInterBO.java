package BO;

import javafx.collections.ObservableList;

public interface BaseInterBO <VO>{
	public VO adicionar(VO a);
	public VO alterar(VO a);
	public void deletar(VO a);
	public ObservableList<VO> pesquisar(VO a);
}
