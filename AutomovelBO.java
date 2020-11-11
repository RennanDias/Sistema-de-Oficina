package BO;

import java.util.Scanner;

import VO.AutomovelVO;
import VO.ClientesVO;

public class AutomovelBO {

public ClientesVO[] adicionarAutomovel(ClientesVO[] c) { //Recebe vetor de clientes e retorna vetor de clientes com os automoveis adicionados
		
		AutomovelVO a = new AutomovelVO();
		
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
		}
		
		return c;
	}

public AutomovelVO adicionarAutomovel() { //Retorna um autom�vel
	
		AutomovelVO a = new AutomovelVO();
	
		System.out.println("ADICIONANDO NOVO AUTOM�VEL!\n");
	
			Scanner s = new Scanner(System.in);
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
			
			System.out.println("Autom�vel adicionado.");
			
		return a;
}
	
	public AutomovelVO alterarAutomovel(AutomovelVO a) {
		
		System.out.println("ALTERANDO AUTOM�VEL!\n");
		
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
		
		System.out.println("Autom�vel alterado.");
		
		return a;
	}

	public void deletarAutomovel(AutomovelVO[] a) {
		boolean t = false;
		String delete;
		
		System.out.println("DELETANDO AUTOM�VEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do autom�vel a ser deletado: ");
		delete = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			if (delete.equals(a[i].getPlaca())) {
				for (int j = i; j < (a.length - 1); j++) {
					a[j] = a[j+1];
				}
				t = true;
				System.out.println("O autom�vel de placa " + delete + " foi deletado.\n");
				break;
			}
		}
		if (t != true) {
			System.out.println("Autom�vel n�o encontrado!\n");
		}
		
	}
	
	public void mostrarAutomovel(AutomovelVO a) {
			System.out.println("Marca: " + a.getMarca());
			System.out.println("Modelo: " + a.getModelo());
			System.out.println("Ano: " + a.getAno());
			System.out.println("Cor: " + a.getCor());
			System.out.println("Placa: " + a.getPlaca());
			System.out.println("Quilometragem: " + a.getQuilometragem());
			System.out.println("\n");
	}
	
	public void mostrarAutomovel(AutomovelVO[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("Autom�vel " + (i+1) + "\n");
			System.out.println("Marca: " + a[i].getMarca());
			System.out.println("Modelo: " + a[i].getModelo());
			System.out.println("Ano: " + a[i].getAno());
			System.out.println("Cor: " + a[i].getCor());
			System.out.println("Placa: " + a[i].getPlaca());
			System.out.println("Quilometragem: " + a[i].getQuilometragem());
			System.out.println("\n");
		}
	}
	
	public void pesquisarAutomovel(AutomovelVO[] a) {
		boolean t = false;
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
		}
	}
	
}
