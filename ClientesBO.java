package BO;

import java.util.Scanner;
import VO.ClientesVO;

public class ClientesBO {
	
	public ClientesVO adicionarCliente() {
		
		ClientesVO c = new ClientesVO();
		AutomovelBO met = new AutomovelBO();
		
		System.out.println("ADICIONANDO NOVO CLIENTE!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do cliente: ");
		c.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o endereço do cliente: ");
		c.setEndereço(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente: ");
		c.setCpf(s.nextLine());
		
		c.setAutomoveis(met.adicionarAutomovel());
		
		System.out.println("Cliente adicionado.");
		
		return c;
	}
	
	public ClientesVO alterarCliente(ClientesVO c) {
		
		System.out.println("ALTERANDO CLIENTE!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + c.getNome());
		System.out.println("\nDigite o novo nome: ");
		c.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Endereço do antigo: " + c.getEndereço());
		System.out.println("\nDigite o novo endereço: ");
		c.setEndereço(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("CPF antigo: " + c.getCpf());
		System.out.println("\nDigite o novo CPF: ");
		c.setCpf(s.nextLine());
		
		System.out.println("Cliente alterado.");
		
		return c;
	}

	public void deletarCliente(ClientesVO[] c) {
		boolean t = false;
		String delete;
		
		System.out.println("DELETANDO CLIENTE!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome ou cpf do cliente a ser deletado: ");
		delete = s.nextLine();
		
		for (int i = 0; i < c.length; i++) {
			if (delete.equals(c[i].getNome()) || delete.equals(c[i].getCpf())) {
				for (int j = i; j < (c.length - 1); j++) {
					c[j] = c[j+1];
				}
				t = true;
				System.out.println("Cliente deletado.");
				break;
			}
		}
		if (t != true) {
			System.out.println("Cliente não encontrado!\n");
		}
		
	}
	
	public void mostrarCliente(ClientesVO c) {
		AutomovelBO met = new AutomovelBO();
		System.out.println("Nome: " + c.getNome());
		System.out.println("CPF: " + c.getCpf());
		System.out.println("Endereço: " + c.getEndereço());
		met.mostrarAutomovel(c.getAutomoveis());
	}
	
	public void pesquisarCliente(ClientesVO[] c) {
		boolean t = false;
		String p;
		
		System.out.println("PESQUISANDO CLIENTE!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome ou cpf do cliente a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < c.length; i++) {
			if (p.equals(c[i].getNome()) || p.equals(c[i].getCpf())) {
				mostrarCliente(c[i]);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Cliente não encontrado!\n");
		}
	}
	
}
