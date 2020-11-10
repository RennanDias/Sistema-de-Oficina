package BO;

import java.util.Scanner;
import VO.FuncionárioVO;

public class FuncionárioBO {
	
	public FuncionárioVO cadastrarFuncionario() {
		
		FuncionárioVO func = new FuncionárioVO();
		
		System.out.println("CADASTRANDO NOVO FUNCIONÁRIO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do funcionário: ");
		func.setNome(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o endereço do funcionário: ");
		func.setEndereço(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o CPF do funcionário: ");
		func.setCpf(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite o usuário do funcionário: ");
		func.setUsuario(s.nextLine());
		
		s = new Scanner(System.in);
		System.out.println("Digite a senha do funcionário: ");
		func.setSenha(s.next());
		
		return func;
	}
	
	public void fazerLogin (FuncionárioVO[] funcionarios) {
		boolean v = false;
		
		FuncionárioVO func = new FuncionárioVO();
		System.out.println("\nFAZENDO LOGIN");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Usuário: ");
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
			System.out.println("Usuário ou senha incorreto(s)!\n");
		}
	}
	
}
