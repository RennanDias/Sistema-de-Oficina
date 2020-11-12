package BO;

import java.util.Scanner;

import VO.AutomovelVO;
import VO.Pe�aVO;

public class Pe�aBO {

public Pe�aVO adicionarPe�a() {
		
		Pe�aVO p = new Pe�aVO();
		AutomovelBO met = new AutomovelBO();
		
		System.out.println("ADICIONANDO NOVA PE�A!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome da pe�a: ");
		p.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o pre�o da pe�a: ");
		p.setPre�o(Float.parseFloat(s.nextLine()));
		
		s = new Scanner(System.in);
		System.out.println("Digite o fabricante da pe�a: ");
		p.setFabricante(s.nextLine());
		
		p.setAutomoveis(met.adicionarAutomovel());
		
		System.out.println("Pe�a adicionada.");
		
		return p;
	}
	
	public Pe�aVO alterarPe�a(Pe�aVO p) {
		
		System.out.println("ALTERANDO PE�A!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + p.getNome());
		System.out.println("\nDigite o novo nome: ");
		p.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Pre�o antigo: " + p.getPre�o());
		System.out.println("\nDigite o novo pre�o: ");
		p.setPre�o(Float.parseFloat(s.nextLine()));
		
		s = new Scanner(System.in);
		System.out.println("Fabricante antigo: " + p.getFabricante());
		System.out.println("\nDigite o novo fabricante: ");
		p.setFabricante(s.nextLine());
		
		System.out.println("Pe�a alterada.");
		
		return p;
	}

	public void deletarPe�a(Pe�aVO[] p) {
		
		boolean t = false;
		String delete;
		
		System.out.println("DELETANDO PE�A!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome da pe�a a ser deletada: ");
		delete = s.nextLine();
		
		for (int i = 0; i < p.length; i++) {
			if (delete.equals(p[i].getNome())) {
				for (int j = i; j < (p.length - 1); j++) {
					p[j] = p[j+1];
				}
				t = true;
				System.out.println("Pe�a deletada.");
				break;
			}
		}
		if (t != true) {
			System.out.println("Pe�a n�o encontrada!\n");
		}
		
	}
	
	public void mostrarPe�a(Pe�aVO p) {
		AutomovelBO met = new AutomovelBO();
		System.out.println("Nome: " + p.getNome());
		System.out.println("Pre�o: " + p.getPre�o());
		System.out.println("Fabricante: " + p.getFabricante());
		met.mostrarAutomovel(p.getAutomoveis());
	}
	
	public void pesquisarPe�a(Pe�aVO[] p) {
		
		boolean t = false;
		String c;
		
		System.out.println("PESQUISANDO PE�A!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome ou fabricante da pe�a a ser pesquisada: ");
		c = s.nextLine();
		
		for (int i = 0; i < p.length; i++) {
			if (c.equals(p[i].getNome()) || c.equals(p[i].getFabricante())) {
				mostrarPe�a(p[i]);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Pe�a n�o encontrada!\n");
		}
	}
	
public void pesquisarPe�a(Pe�aVO p, AutomovelVO[] a) { //Na main, pesuisar pe�a por cliente deve ser colocada dentro de um 'for'
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
	}
	
}
