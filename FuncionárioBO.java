package BO;

import java.util.Scanner;
import VO.Funcion�rioVO;

public class Funcion�rioBO {
	
	public Funcion�rioVO cadastrarFuncionario() {
		
		Funcion�rioVO func = new Funcion�rioVO();
		
		System.out.println("CADASTRANDO NOVO FUNCION�RIO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do funcion�rio: ");
		func.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o endere�o do funcion�rio: ");
		func.setEndere�o(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o CPF do funcion�rio: ");
		func.setCpf(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o usu�rio do funcion�rio: ");
		func.setUsuario(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite a senha do funcion�rio: ");
		func.setSenha(s.next());
		
		return func;
	}
	
	public void fazerLogin (Funcion�rioVO[] funcionarios) {
		boolean v = false;
		
		Funcion�rioVO func = new Funcion�rioVO();
		System.out.println("\nFAZENDO LOGIN");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Usu�rio: ");
		func.setUsuario(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Senha: ");
		func.setSenha(s.next());
		
		for(int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i] != null) {
				if (func.getUsuario().equals(funcionarios[i].getUsuario()) && func.getSenha().equals(funcionarios[i].getSenha())) {
					v = true;
				}
			}
			else {
				break;
			}
		}
		
		if (v != false) {
			System.out.println("Logado com sucesso!\n");
		}
		else {
			System.out.println("Usu�rio ou senha incorreto(s)!\n");
		}
	}
	
}
