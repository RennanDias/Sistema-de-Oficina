package BO;

import java.util.Scanner;
import VO.Servi�oVO;

public class Servi�oBO implements BaseInterBO <Servi�oVO>{
	
	public Servi�oVO adicionar(Servi�oVO t) { //Cria um objeto do tipo Servi�oVO, atribui valores aos seus atributos e retorna o objeto
		
		/*Servi�oVO t = new Servi�oVO();
		
		System.out.println("ADICIONANDO SERVI�O!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do servi�o: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o valor do servi�o: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		*/
		return t;
	}
	
	public Servi�oVO alterar(Servi�oVO t) { //Recebe um servi�o e altera seus atributos
		
		/*System.out.println("ALTERANDO SERVI�O!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nome antigo: " + t.getNome());
		System.out.println("\nDigite o novo nome: ");
		t.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Valor antigo: " + t.getValor());
		System.out.println("\nDigite o novo valor: ");
		t.setValor(Float.parseFloat(s.nextLine()));
		
		System.out.println("Servi�o alterado.");*/
		
		return t;
	}

	public void deletar(Servi�oVO t) { //Recebe um vetor de servi�os e deleta um de acordo com o nome digitado
	
		/*boolean p = false;
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
		}*/
		
	}

	public void mostrarServi�o(Servi�oVO t) { //Mostra os atributos de um servi�o
		/*System.out.println("Nome: " + t.getNome());
		System.out.println("Valor: " + t.getValor());*/
	}
	
	public Servi�oVO pesquisar(Servi�oVO t) { //Recebe um vetor de servi�os e pesquisa um servi�o de acordo com o nome
		/*
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
		}*/
		return t;
	}
	
}
