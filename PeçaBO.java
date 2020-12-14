package BO;

import java.sql.SQLException;

import DAO.PeçaDAO;
import VO.PeçaVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PeçaBO implements BaseInterBO <PeçaVO>{
	PeçaDAO dao = new PeçaDAO();
	
public PeçaVO adicionar(PeçaVO p) { //Cria um objeto do tipo PeçaVO e atribui valores aos atributos e, no fim, o retorna
		try {
			dao.inserir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
	public PeçaVO alterar(PeçaVO p) { //Recebe uma peça e altera seus atributos
		
		try {
			p = dao.modificar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

	public void deletar(PeçaVO p) { //Recebe um vetor de peças, procura a peça a ser deletada pelo nome e a exclui
		
		try {
			dao.excluir(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ObservableList<PeçaVO> listar() { //Recebe um vetor de peças e retorna a peça específica que tiver o nome recebido
		ObservableList<PeçaVO> peças = FXCollections.observableArrayList();
		
		try {
			peças = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return peças;
		
	}
	
	public ObservableList<PeçaVO> pesquisar(PeçaVO p) { //Recebe um vetor de peças e retorna a peça específica que tiver o nome recebido
		/*for (PeçaVO pvo : dao.buscar(p)) {
			p = pvo;
		}*/
		ObservableList<PeçaVO> peças = FXCollections.observableArrayList();
		try {
			peças =  dao.buscar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peças;
		
	}
	
	/*public void pesquisarPeça(PeçaVO p) { //Na main, pesuisar peça por cliente deve ser colocada dentro de um 'for'
	//para que eu percorra meu vetor de peças, e dentro de cada peça, passar como argumento do método o getAutomoveis pra passar
	//o vetor de automóveis
		
	boolean t = false;
		String m, c;
		
		System.out.println("PESQUISANDO PEÇA!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a marca e o modelo do carro do qual deseja procurar a peça: ");
		System.out.println("Marca: ");
		m = s.nextLine();
		System.out.println("Modelo: ");
		c = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			if (m.equals(a[i].getMarca()) && c.equals(a[i].getModelo())) {
				mostrarPeça(p);
				t = true;
				break;
			}
		}
		
		if (t != true) {
			System.out.println("Peça não encontrada!\n");
		}
	}*/
	
}
