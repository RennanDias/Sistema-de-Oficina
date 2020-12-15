package BO;

import javafx.collections.ObservableList;

//Classe contendo a assinatura dos m�todos comuns �s classes BO, utilizando polimorfismo param�trico
public interface BaseInterBO <VO>{
	public VO adicionar(VO a);
	public VO alterar(VO a);
	public void deletar(VO a);
	public ObservableList<VO> pesquisar(VO a);
}
