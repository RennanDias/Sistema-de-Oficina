package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.PeçaDAO;
import VO.AutomovelVO;
import VO.ClientesVO;
import VO.PeçaVO;

public class PeçaBO implements BaseInterBO <PeçaVO>{
	PeçaDAO dao = new PeçaDAO();
	
public PeçaVO adicionar(PeçaVO p) { //Cria um objeto do tipo PeçaVO e atribui valores aos atributos e, no fim, o retorna
		
	try {
		boolean existe = false;
		List<PeçaVO> rs = dao.listar();
		while (((ResultSet) rs).next()) {
			PeçaVO test = (PeçaVO) rs;
			if (p.getNome() == test.getNome() && p.getFabricante() == test.getFabricante()){
				existe = true;
			}
		}
		if (existe != false){
			throw new SQLException("Impossível cadastrar, pois já existe peça com este nome e fabricante.");
		}
		else {
			dao.inserir(p);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	/*PeçaVO p = new PeçaVO();
		AutomovelBO met = new AutomovelBO();
		
		System.out.println("ADICIONANDO NOVA PEÇA!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome da peça: ");
		p.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o preço da peça: ");
		p.setValor(Float.parseFloat(s.nextLine()));
		
		s = new Scanner(System.in);
		System.out.println("Digite o fabricante da peça: ");
		p.setFabricante(s.nextLine());
		
		p.setAutomoveis(met.adicionarAutomovel());
		
		System.out.println("Peça adicionada.");
		*/
		return p;
	}
	
	public PeçaVO alterar(PeçaVO p) { //Recebe uma peça e altera seus atributos
		
		try {
			PeçaVO rs = dao.buscar(p);
			if (p == rs){
				throw new SQLException("Valores idênticos. Nada alterado.");
			}
			else {
				p = dao.modificar(p);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		/*System.out.println("ALTERANDO PEÇA!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + p.getNome());
		System.out.println("\nDigite o novo nome: ");
		p.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Preço antigo: " + p.getValor());
		System.out.println("\nDigite o novo preço: ");
		p.setValor(Float.parseFloat(s.nextLine()));
		
		s = new Scanner(System.in);
		System.out.println("Fabricante antigo: " + p.getFabricante());
		System.out.println("\nDigite o novo fabricante: ");
		p.setFabricante(s.nextLine());
		
		System.out.println("Peça alterada.");
		*/
		return p;
	}

	public void deletar(PeçaVO p) { //Recebe um vetor de peças, procura a peça a ser deletada pelo nome e a exclui
		
		dao.excluir(p);
		
		/*boolean t = false;
		String delete;
		
		System.out.println("DELETANDO PEÇA!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome da peça a ser deletada: ");
		delete = s.nextLine();
		
		for (int i = 0; i < p.length; i++) {
			if (delete.equals(p[i].getNome())) {
				for (int j = i; j < (p.length - 1); j++) {
					p[j] = p[j+1];
				}
				t = true;
				System.out.println("Peça deletada.");
				break;
			}
		}
		if (t != true) {
			System.out.println("Peça não encontrada!\n");
		}*/
		
	}
	
	/*public void mostrarPeça(PeçaVO p) { //Mostra os atributos de uma peça
		/*AutomovelBO met = new AutomovelBO();
		System.out.println("Nome: " + p.getNome());
		System.out.println("Preço: " + p.getValor());
		System.out.println("Fabricante: " + p.getFabricante());
		met.mostrarAutomovel(p.getAutomoveis());
	}*/
	
	public PeçaVO pesquisar(PeçaVO p) { //Recebe um vetor de peças e retorna a peça específica que tiver o nome recebido
		
		p = dao.buscar(p);
		
		
		/*boolean t = false;
		String c;
		
		System.out.println("PESQUISANDO PEÇA!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome ou fabricante da peça a ser pesquisada: ");
		c = s.nextLine();
		
		for (int i = 0; i < p.length; i++) {
			if (c.equals(p[i].getNome()) || c.equals(p[i].getFabricante())) {
				mostrarPeça(p[i]);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Peça não encontrada!\n");
		}*/
		return p;
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
