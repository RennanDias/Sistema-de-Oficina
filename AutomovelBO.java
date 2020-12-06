package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.AutomovelDAO;
import VO.AutomovelVO;

public class AutomovelBO implements BaseInterBO <AutomovelVO>{
	//static private AutomovelBO<AutomovelVO> usuBO = new AutomovelBO<AutomovelVO>();
	AutomovelDAO dao = new AutomovelDAO();
	
public AutomovelVO adicionar(AutomovelVO a) { //Recebe vetor de clientes e retorna vetor de clientes com os automoveis adicionados
		
	try {
		boolean existe = false;
		List<AutomovelVO> rs = dao.listar();
		while (((ResultSet) rs).next()) {
			AutomovelVO test = (AutomovelVO) rs;
			if (a.getPlaca() == test.getPlaca()){
				existe = true;
			}
		}
		if (existe != false){
			throw new SQLException("Imposs�vel cadastrar, pois j� existe ve�culo com esta placa");
		}
		else {
			dao.inserir(a);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	/*AutomovelVO a = new AutomovelVO();
		
		System.out.println("ADICIONANDO NOVO AUTOM�VEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Qual � o dono do autom�vel (Nome ou CPF)? ");
		boolean t = false;
		String p;
		p = s.nextLine();
		for (int i = 0; i < c.length; i++) {
			if (p.equals(c[i].getNome()) || p.equals(c[i].getCpf())) {
				
				s = new Scanner(System.in);
				System.out.println("Digite a marca do autom�vel: ");
				a.setMarca(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite o modelo do autom�vel: ");
				a.setModelo(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite o ano do autom�vel: ");
				a.setAno(Integer.parseInt(s.nextLine()));
				
				s = new Scanner(System.in);
				System.out.println("Digite a cor do autom�vel: ");
				a.setCor(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite a placa do autom�vel: ");
				a.setPlaca(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite a quilometragem do autom�vel: ");
				a.setQuilometragem(Integer.parseInt(s.nextLine()));
				
				c[i].setAutomoveis(a);
				
				t = true;
				System.out.println("Autom�vel adicionado.");
				
				break;
			}
		}
		if (t != true) {
			System.out.println("Dono n�o encontrado!\n");
		}*/
		
		return a;
	}
	
	public AutomovelVO alterar(AutomovelVO a) { //Recebe um autom�vel e altera seus atributos
		
		try {
			AutomovelVO rs = dao.buscar(a);
			if (a == rs){
				throw new SQLException("Valores id�nticos. Nada alterado.");
			}
			else {
				a = dao.modificar(a);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		/*System.out.println("ALTERANDO AUTOM�VEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Marca antiga: " + a.getMarca());
		System.out.println("\nDigite a nova marca: ");
		a.setMarca(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Modelo antigo: " + a.getModelo());
		System.out.println("\nDigite o novo modelo: ");
		a.setModelo(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Ano antigo: " + a.getAno());
		System.out.println("\nDigite o novo ano: ");
		a.setAno(Integer.parseInt(s.nextLine()));
		
		s = new Scanner(System.in);
		System.out.println("Cor antiga: " + a.getCor());
		System.out.println("\nDigite a nova cor: ");
		a.setCor(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Placa antiga: " + a.getPlaca());
		System.out.println("\nDigite a nova placa: ");
		a.setPlaca(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Quilometragem antiga: " + a.getQuilometragem());
		System.out.println("\nDigite a nova quilometragem: ");
		a.setQuilometragem(Integer.parseInt(s.nextLine()));
		
		System.out.println("Autom�vel alterado.");*/
		
		return a;
	}

	public void deletar(AutomovelVO a) { //Recebe um vetor de autom�veis e deleta um de acordo com a placa dele
		
		try {
			dao.excluir(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public AutomovelVO pesquisar(AutomovelVO a) { //Recebe um vetor de automoveis e mostra os atributos especificos do veiculo
		
		a = dao.buscar(a);
		
		
		//que possuir a placa que � recebida
		/*boolean t = false;
		String p;
		
		System.out.println("PESQUISANDO AUTOM�VEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do autom�vel a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			if (p.equals(a[i].getPlaca())) {
				mostrarAutomovel(a);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Autom�vel n�o encontrado!\n");
		}*/
		return a;
	}
	
	/*public void mostrarAutomovel(AutomovelVO a) { //Mostra os atributos de um autom�vel 
		/*System.out.println("Marca: " + a.getMarca());
			System.out.println("Modelo: " + a.getModelo());
			System.out.println("Ano: " + a.getAno());
			System.out.println("Cor: " + a.getCor());
			System.out.println("Placa: " + a.getPlaca());
			System.out.println("Quilometragem: " + a.getQuilometragem());
			System.out.println("\n");
	}
	
	public void mostrarAutomovel(AutomovelVO[] a) { //Mostra os atributos de v�rios automoveis de um vetor (usado para mostrar
		//veiculos de um cliente, por exemplo)
		/*for (int i = 0; i < a.length; i++) {
			System.out.println("Autom�vel " + (i+1) + "\n");
			System.out.println("Marca: " + a[i].getMarca());
			System.out.println("Modelo: " + a[i].getModelo());
			System.out.println("Ano: " + a[i].getAno());
			System.out.println("Cor: " + a[i].getCor());
			System.out.println("Placa: " + a[i].getPlaca());
			System.out.println("Quilometragem: " + a[i].getQuilometragem());
			System.out.println("\n");
		}
	}*/

}
