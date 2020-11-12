package BO;

import java.util.Scanner;

import VO.AutomovelVO;
import VO.PeçaVO;

public class PeçaBO {

public PeçaVO adicionarPeça() {
		
		PeçaVO p = new PeçaVO();
		AutomovelBO met = new AutomovelBO();
		
		System.out.println("ADICIONANDO NOVA PEÇA!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome da peça: ");
		p.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o preço da peça: ");
		p.setPreço(Float.parseFloat(s.nextLine()));
		
		s = new Scanner(System.in);
		System.out.println("Digite o fabricante da peça: ");
		p.setFabricante(s.nextLine());
		
		p.setAutomoveis(met.adicionarAutomovel());
		
		System.out.println("Peça adicionada.");
		
		return p;
	}
	
	public PeçaVO alterarPeça(PeçaVO p) {
		
		System.out.println("ALTERANDO PEÇA!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + p.getNome());
		System.out.println("\nDigite o novo nome: ");
		p.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Preço antigo: " + p.getPreço());
		System.out.println("\nDigite o novo preço: ");
		p.setPreço(Float.parseFloat(s.nextLine()));
		
		s = new Scanner(System.in);
		System.out.println("Fabricante antigo: " + p.getFabricante());
		System.out.println("\nDigite o novo fabricante: ");
		p.setFabricante(s.nextLine());
		
		System.out.println("Peça alterada.");
		
		return p;
	}

	public void deletarPeça(PeçaVO[] p) {
		
		boolean t = false;
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
		}
		
	}
	
	public void mostrarPeça(PeçaVO p) {
		AutomovelBO met = new AutomovelBO();
		System.out.println("Nome: " + p.getNome());
		System.out.println("Preço: " + p.getPreço());
		System.out.println("Fabricante: " + p.getFabricante());
		met.mostrarAutomovel(p.getAutomoveis());
	}
	
	public void pesquisarPeça(PeçaVO[] p) {
		
		boolean t = false;
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
		}
	}
	
public void pesquisarPeça(PeçaVO p, AutomovelVO[] a) { //Na main, pesuisar peça por cliente deve ser colocada dentro de um 'for'
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
	}
	
}
