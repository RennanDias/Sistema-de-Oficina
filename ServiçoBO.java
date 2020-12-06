package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.ServiçoDAO;
import VO.ServiçoVO;

public class ServiçoBO implements BaseInterBO <ServiçoVO>{
	ServiçoDAO dao = new ServiçoDAO();
	
	public ServiçoVO adicionar(ServiçoVO t) { //Cria um objeto do tipo ServiçoVO, atribui valores aos seus atributos e retorna o objeto
		
		try {
			boolean existe = false;
			List<ServiçoVO> rs = dao.listar();
			while (((ResultSet) rs).next()) {
				ServiçoVO test = (ServiçoVO) rs;
				if (t.getNome() == test.getNome()){
					existe = true;
				}
			}
			if (existe != false){
				throw new SQLException("Impossível cadastrar, pois já existe serviço com este nome");
			}
			else {
				dao.inserir(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*ServiçoVO t = new ServiçoVO();
		
		System.out.println("ADICIONANDO SERVIÇO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do serviço: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o valor do serviço: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		*/
		return t;
	}
	
	public ServiçoVO alterar(ServiçoVO t) { //Recebe um serviço e altera seus atributos
		
		try {
			ServiçoVO rs = dao.buscar(t);
			if (t == rs){
				throw new SQLException("Valores idênticos. Nada alterado.");
			}
			else {
				t = dao.modificar(t);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		/*System.out.println("ALTERANDO SERVIÇO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + t.getNome());
		System.out.println("\nDigite o novo nome: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Valor antigo: " + t.getValor());
		System.out.println("\nDigite o novo valor: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		
		System.out.println("Serviço alterado.");*/
		
		return t;
	}

	public void deletar(ServiçoVO t) { //Recebe um vetor de serviços e deleta um de acordo com o nome digitado
	
		dao.excluir(t);
		
		/*boolean p = false;
		String delete;
		
		System.out.println("DELETANDO SERVIÇO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do serviço a ser deletado: ");
		delete = s.nextLine();
		
		for (int i = 0; i < t.length; i++) {
			if (delete.equals(t[i].getNome())) {
				for (int j = i; j < (t.length - 1); j++) {
					t[j] = t[j+1];
				}
				p = true;
				System.out.println("Serviço deletado.");
				break;
			}
		}
		if (p != true) {
			System.out.println("Serviço não encontrado!\n");
		}*/
		
	}

	/*public void mostrarServiço(ServiçoVO t) { //Mostra os atributos de um serviço
		/*System.out.println("Nome: " + t.getNome());
		System.out.println("Valor: " + t.getValor());
	}*/
	
	public ServiçoVO pesquisar(ServiçoVO t) { //Recebe um vetor de serviços e pesquisa um serviço de acordo com o nome
		
		t = dao.buscar(t);
		
		/*
		boolean v = false;
		String p;
		
		System.out.println("PESQUISANDO SERVIÇO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do serviço a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < t.length; i++) {
			if (p.equals(t[i].getNome())) {
				mostrarServiço(t[i]);
				v = true;
				break;
			}
		}
		if (v != true) {
			System.out.println("Serviço não encontrado!\n");
		}*/
		return t;
	}
	
}
