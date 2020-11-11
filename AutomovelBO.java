package BO;

import java.util.Scanner;

import VO.AutomovelVO;
import VO.ClientesVO;

public class AutomovelBO {

public ClientesVO[] adicionarAutomovel(ClientesVO[] c) { //Recebe vetor de clientes e retorna vetor de clientes com os automoveis adicionados
		
		AutomovelVO a = new AutomovelVO();
		
		System.out.println("ADICIONANDO NOVO AUTOMÓVEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Qual é o dono do automóvel (Nome ou CPF)? ");
		boolean t = false;
		String p;
		p = s.nextLine();
		for (int i = 0; i < c.length; i++) {
			if (p.equals(c[i].getNome()) || p.equals(c[i].getCpf())) {
				
				s = new Scanner(System.in);
				System.out.println("Digite a marca do automóvel: ");
				a.setMarca(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite o modelo do automóvel: ");
				a.setModelo(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite o ano do automóvel: ");
				a.setAno(Integer.parseInt(s.nextLine()));
				
				s = new Scanner(System.in);
				System.out.println("Digite a cor do automóvel: ");
				a.setCor(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite a placa do automóvel: ");
				a.setPlaca(s.nextLine());
				
				s = new Scanner(System.in);
				System.out.println("Digite a quilometragem do automóvel: ");
				a.setQuilometragem(Integer.parseInt(s.nextLine()));
				
				c[i].setAutomoveis(a);
				
				t = true;
				System.out.println("Automóvel adicionado.");
				
				break;
			}
		}
		if (t != true) {
			System.out.println("Dono não encontrado!\n");
		}
		
		return c;
	}

public AutomovelVO adicionarAutomovel() { //Retorna um automóvel
	
		AutomovelVO a = new AutomovelVO();
	
		System.out.println("ADICIONANDO NOVO AUTOMÓVEL!\n");
	
			Scanner s = new Scanner(System.in);
			System.out.println("Digite a marca do automóvel: ");
			a.setMarca(s.nextLine());
			
			s = new Scanner(System.in);
			System.out.println("Digite o modelo do automóvel: ");
			a.setModelo(s.nextLine());
			
			s = new Scanner(System.in);
			System.out.println("Digite o ano do automóvel: ");
			a.setAno(Integer.parseInt(s.nextLine()));
			
			s = new Scanner(System.in);
			System.out.println("Digite a cor do automóvel: ");
			a.setCor(s.nextLine());
			
			s = new Scanner(System.in);
			System.out.println("Digite a placa do automóvel: ");
			a.setPlaca(s.nextLine());
			
			s = new Scanner(System.in);
			System.out.println("Digite a quilometragem do automóvel: ");
			a.setQuilometragem(Integer.parseInt(s.nextLine()));
			
			System.out.println("Automóvel adicionado.");
			
		return a;
}
	
	public AutomovelVO alterarAutomovel(AutomovelVO a) {
		
		System.out.println("ALTERANDO AUTOMÓVEL!\n");
		
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
		
		System.out.println("Automóvel alterado.");
		
		return a;
	}

	public void deletarAutomovel(AutomovelVO[] a) {
		boolean t = false;
		String delete;
		
		System.out.println("DELETANDO AUTOMÓVEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do automóvel a ser deletado: ");
		delete = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			if (delete.equals(a[i].getPlaca())) {
				for (int j = i; j < (a.length - 1); j++) {
					a[j] = a[j+1];
				}
				t = true;
				System.out.println("O automóvel de placa " + delete + " foi deletado.\n");
				break;
			}
		}
		if (t != true) {
			System.out.println("Automóvel não encontrado!\n");
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
			System.out.println("Automóvel " + (i+1) + "\n");
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
		
		System.out.println("PESQUISANDO AUTOMÓVEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do automóvel a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			if (p.equals(a[i].getPlaca())) {
				mostrarAutomovel(a);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Automóvel não encontrado!\n");
		}
	}
	
}
