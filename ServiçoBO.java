package BO;

import java.util.Scanner;
import VO.Servi�oVO;

public class Servi�oBO {
	
	public Servi�oVO adicionarServi�o() {
		
		Servi�oVO t = new Servi�oVO();
		
		System.out.println("ADICIONANDO SERVI�O!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do servi�o: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o valor do servi�o: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		
		return t;
	}
	
	public Servi�oVO alterarServi�o(Servi�oVO t) {
		
		System.out.println("ALTERANDO SERVI�O!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + t.getNome());
		System.out.println("\nDigite o novo nome: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Valor antigo: " + t.getValor());
		System.out.println("\nDigite o novo valor: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		
		System.out.println("Servi�o alterado.");
		
		return t;
	}

	public void deletarServi�o(Servi�oVO[] t) {
	
		boolean p = false;
		String delete;
		
		System.out.println("DELETANDO SERVI�O!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do servi�o a ser deletado: ");
		delete = s.nextLine();
		
		for (int i = 0; i < t.length; i++) {
			if (delete.equals(t[i].getNome())) {
				for (int j = i; j < (t.length - 1); j++) {
					t[j] = t[j+1];
				}
				p = true;
				System.out.println("Servi�o deletado.");
				break;
			}
		}
		if (p != true) {
			System.out.println("Servi�o n�o encontrado!\n");
		}
		
	}

	public void mostrarServi�o(Servi�oVO t) {
		System.out.println("Nome: " + t.getNome());
		System.out.println("Valor: " + t.getValor());
	}
	
	public void pesquisarServi�o(Servi�oVO[] t) {
		
		boolean v = false;
		String p;
		
		System.out.println("PESQUISANDO SERVI�O!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do servi�o a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < t.length; i++) {
			if (p.equals(t[i].getNome())) {
				mostrarServi�o(t[i]);
				v = true;
				break;
			}
		}
		if (v != true) {
			System.out.println("Servi�o n�o encontrado!\n");
		}
		
	}
	
}
