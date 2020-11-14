package BO;

import java.util.Date;
import java.util.Scanner;

import VO.FuncionárioVO;
import VO.OrçamentoVO;

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
	
	public void gerarRelatorios(OrçamentoVO[] o, Date inicio, Date fim) {
		OrçamentoBO met = new OrçamentoBO();
		boolean t = false;
 		System.out.println("RELATÓRIOS DE " + inicio + " até " + fim + "\n");
		for (int i = 0; i < o.length; i++) {
			if (o[i].getData().after(inicio) && o[i].getData().before(fim)) {
				met.mostrarOrçamento(o[i]);
				t = true;
			}
		}
		if (t != true) {
			System.out.println("Não há orçamentos nesse período!");
		}	
	}
	
	public OrçamentoVO finalizarOrçamento(OrçamentoVO o) {
		if (o.getFinalizado() != true) {
			o.setFinalizado(true);
			System.out.println("Orçamento finalizado!");
		}
		else {
			System.out.println("O presente orçamento já está finalizado!");
		}
		return o;
	}
	
}
