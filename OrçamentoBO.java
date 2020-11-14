package BO;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import VO.Pe�aVO;
import VO.Servi�oVO;
import VO.AutomovelVO;
import VO.Or�amentoVO;

public class Or�amentoBO {

public Or�amentoVO adicionarOr�amento(AutomovelVO[] a, Pe�aVO[] pe�a, Servi�oVO[] servi�o) { //Recebe o vetor total de automoveis
	//pe�as e servi�os e, com isso, vai adicionar pe�as e servi�os para o ve�culo espec�fico dito
		
		Or�amentoVO r = new Or�amentoVO();
		Servi�oVO[] o = new Servi�oVO[10];
		float soma = 0;
		int k = 0;
		AutomovelBO met = new AutomovelBO();
		boolean v = false;
		String placa;
		String nome;
	
		System.out.println("ADICIONANDO NOVO OR�AMENTO!\n");
	
			Scanner s = new Scanner(System.in);
			System.out.println("Digite a placa do autom�vel o qual deseja montar o or�amento: ");
			placa = s.nextLine();
			
			for (int i = 0; i < a.length; i++) {
				if (placa.equals(a[i].getPlaca())) {
					System.out.println("O seu or�amento ser� direcionado ao seguinte ve�culo:\n");
					met.mostrarAutomovel(a[i]);
					r.setAutomoveis(a[i]);
					v = true;
					break;
				}
			}
			if (v != true) {
				System.out.println("N�o foi poss�vel encontrar o ve�culo para cadastrar o or�amento!\n");
			}
			v = false;
			
			s = new Scanner(System.in);
			System.out.println("Adicione uma pe�a ao or�amento!\nNome: ");
			nome = s.nextLine();
			for (int i = 0; i < pe�a.length; i++) {
				if (nome.equals(pe�a[i].getNome())) {
					System.out.println("A pe�a " + nome + " foi adicionada com o valor R$" + pe�a[i].getValor());
					o[k].setNome(pe�a[i].getNome());
					o[k].setValor(pe�a[i].getValor());
					k += 1;
					v = true;
					break;
				}
			}
			if (v != true) {
				System.out.println("N�o foi poss�vel encontrar a pe�a para cadastrar no or�amento!\n");
			}
			v = false;
			
			s = new Scanner(System.in);
			System.out.println("Adicione um servi�o ao or�amento!\nNome: ");
			nome = s.nextLine();
			for (int i = 0; i < servi�o.length; i++) {
				if (nome.equals(servi�o[i].getNome())) {
					System.out.println("O servi�o " + nome + " foi adicionado com o valor R$" + servi�o[i].getValor());
					o[k].setNome(servi�o[i].getNome());
					o[k].setValor(servi�o[i].getValor());
					k =+ 1;
					v = true;
					break;
				}
			}
			if (v != true) {
				System.out.println("N�o foi poss�vel encontrar o servi�o para cadastrar no or�amento!\n");
			}
			v = false;
			
			System.out.println("Or�amento adicionado!\n");
			for (int i = 0; i <= k; i++) {
					System.out.println("Item/Servi�o: " + o[i].getNome());
					System.out.println("\nValor: " + o[i].getValor());
					System.out.println("\n");
					soma += o[i].getValor();
			}
			System.out.println("Valor total: R$" + soma);
			r.setServi�os(o);
			r.setValor(soma);
			Calendar calendar = Calendar.getInstance(); 
			r.setData(calendar.getTime());
			r.setFinalizado(false);
					
		return r;
}
	
	public Servi�oVO[] alterarOr�amento(Servi�oVO[] o) {
		
		String d;
		
		System.out.println("ALTERANDO OR�AMENTO!\n");
		
		for (int i = 0; i < o.length; i++) {
			System.out.println("Item/Servi�o: " + o[i].getNome());
			System.out.println("\nValor R$: " + o[i].getValor());
			Scanner s = new Scanner(System.in);
			System.out.println("\nDeseja alterar isto (S/N)? ");
			d = s.next();
			switch (d){
			case "S": case "s": s = new Scanner(System.in); System.out.println("Novo nome: "); o[i].setNome(s.nextLine());
								s = new Scanner(System.in); System.out.println("\nNovo valor: "); o[i].setValor(Float.parseFloat(s.nextLine()));
								break;
			case "N": case "n": System.out.println("\n"); break;
			}
		}
		
		return o;
	}

	public void deletarOr�amento(Or�amentoVO[] a) {
		boolean t = false;
		String delete;
		AutomovelVO c = new AutomovelVO();
		
		System.out.println("DELETANDO OR�AMENTO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do autom�vel com o or�amento a ser deletado: ");
		delete = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			c = a[i].getAutomoveis();
			if (delete.equals(c.getPlaca())) {
				for (int j = i; j < (a.length - 1); j++) {
					a[j] = a[j+1];
				}
				t = true;
				System.out.println("O �ltimo or�amento do " + c.getModelo() + " " + c.getCor() + " de placa " + delete + " foi deletado.\n");
				break;
			}
		}
		if (t != true) {
			System.out.println("Or�amento n�o encontrado!\n");
		}
		
	}
	
	public void mostrarOr�amento(Or�amentoVO a) {
		Servi�oVO[] r = new Servi�oVO[a.getServi�os().length];
		r = a.getServi�os();
		AutomovelBO met = new AutomovelBO();
		met.mostrarAutomovel(a.getAutomoveis());
		for (int i = 0; i < r.length; i++) {
			System.out.println("\nItem/Servi�o: " + r[i].getNome());
			System.out.println("\nValor: R$" + r[i].getValor());
		}
		System.out.println("\nVALOR TOTAL: R$" + a.getValor());
		System.out.println("\nData: " + a.getData());
		if (a.getFinalizado() == true) {
			System.out.println("\nFinalizado\n");
		}
		else {
			System.out.println("\nN�o finalizado\n");
		}
	}
	
	public void pesquisarOr�amento(Or�amentoVO[] a) {
		boolean t = false;
		String p;
		AutomovelVO r = new AutomovelVO();
		
		System.out.println("PESQUISANDO AUTOM�VEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do autom�vel a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			r = a[i].getAutomoveis();
			if (p.equals(r.getPlaca())) {
				mostrarOr�amento(a[i]);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Placa do autom�vel n�o encontrada!\n");
		}
	}
	
	public void pesquisarOr�amento(Or�amentoVO[] o, Date inicio, Date fim) {
		boolean t = false;
		for (int i = 0; i < o.length; i++) {
			if (o[i].getData().after(inicio) && o[i].getData().before(fim)) {
				mostrarOr�amento(o[i]);
				t = true;
			}
		}
		if (t != true) {
			System.out.println("N�o h� or�amentos nesse per�odo!");
		}
		
	}

	
}
