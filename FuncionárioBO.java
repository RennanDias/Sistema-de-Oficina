package BO;

import java.util.Date;
import java.util.Scanner;

import VO.Funcion�rioVO;
import VO.Or�amentoVO;

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
	
	public void gerarRelatorios(Or�amentoVO[] o, Date inicio, Date fim) {
		Or�amentoBO met = new Or�amentoBO();
		boolean t = false;
 		System.out.println("RELAT�RIOS DE " + inicio + " at� " + fim + "\n");
		for (int i = 0; i < o.length; i++) {
			if (o[i].getData().after(inicio) && o[i].getData().before(fim)) {
				met.mostrarOr�amento(o[i]);
				t = true;
			}
		}
		if (t != true) {
			System.out.println("N�o h� or�amentos nesse per�odo!");
		}	
	}
	
	public Or�amentoVO finalizarOr�amento(Or�amentoVO o) {
		if (o.getFinalizado() != true) {
			o.setFinalizado(true);
			System.out.println("Or�amento finalizado!");
		}
		else {
			System.out.println("O presente or�amento j� est� finalizado!");
		}
		return o;
	}
	
}
