package BO;

import java.sql.SQLException;

import DAO.Pe�aDAO;
import VO.Pe�aVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pe�aBO implements BaseInterBO <Pe�aVO>{
	Pe�aDAO dao = new Pe�aDAO();
	
public Pe�aVO adicionar(Pe�aVO p) { //Cria um objeto do tipo Pe�aVO e atribui valores aos atributos e, no fim, o retorna
		try {
			dao.inserir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
	public Pe�aVO alterar(Pe�aVO p) { //Recebe uma pe�a e altera seus atributos
		
		try {
			p = dao.modificar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

	public void deletar(Pe�aVO p) { //Recebe um vetor de pe�as, procura a pe�a a ser deletada pelo nome e a exclui
		
		try {
			dao.excluir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<Pe�aVO> listar() { //Recebe um vetor de pe�as e retorna a pe�a espec�fica que tiver o nome recebido
		ObservableList<Pe�aVO> pe�as = FXCollections.observableArrayList();
		
		try {
			pe�as = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pe�as;
		
	}
	
	public ObservableList<Pe�aVO> pesquisar(Pe�aVO p) { //Recebe um vetor de pe�as e retorna a pe�a espec�fica que tiver o nome recebido
		/*for (Pe�aVO pvo : dao.buscar(p)) {
			p = pvo;
		}*/
		ObservableList<Pe�aVO> pe�as = FXCollections.observableArrayList();
		try {
			pe�as =  dao.buscar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pe�as;
		
	}
	
	/*public void pesquisarPe�a(Pe�aVO p) { //Na main, pesuisar pe�a por cliente deve ser colocada dentro de um 'for'
	//para que eu percorra meu vetor de pe�as, e dentro de cada pe�a, passar como argumento do m�todo o getAutomoveis pra passar
	//o vetor de autom�veis
		
	boolean t = false;
		String m, c;
		
		System.out.println("PESQUISANDO PE�A!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a marca e o modelo do carro do qual deseja procurar a pe�a: ");
		System.out.println("Marca: ");
		m = s.nextLine();
		System.out.println("Modelo: ");
		c = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			if (m.equals(a[i].getMarca()) && c.equals(a[i].getModelo())) {
				mostrarPe�a(p);
				t = true;
				break;
			}
		}
		
		if (t != true) {
			System.out.println("Pe�a n�o encontrada!\n");
		}
	}*/
	
}
