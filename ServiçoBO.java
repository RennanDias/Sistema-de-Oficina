package BO;

import java.util.Scanner;
import VO.ServiçoVO;

public class ServiçoBO {
	
	public ServiçoVO adicionarServiço() {
		
		ServiçoVO t = new ServiçoVO();
		
		System.out.println("ADICIONANDO SERVIÇO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do serviço: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o valor do serviço: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		
		return t;
	}
	
	public ServiçoVO alterarServiço(ServiçoVO t) {
		
		System.out.println("ALTERANDO SERVIÇO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + t.getNome());
		System.out.println("\nDigite o novo nome: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Valor antigo: " + t.getValor());
		System.out.println("\nDigite o novo valor: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		
		System.out.println("Serviço alterado.");
		
		return t;
	}

	public void deletarServiço(ServiçoVO[] t) {
	
		boolean p = false;
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
		}
		
	}

	public void mostrarServiço(ServiçoVO t) {
		System.out.println("Nome: " + t.getNome());
		System.out.println("Valor: " + t.getValor());
	}
	
	public void pesquisarServiço(ServiçoVO[] t) {
		
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
		}
		
	}
	
}
