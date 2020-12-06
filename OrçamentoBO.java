package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.OrçamentoDAO;
import VO.OrçamentoVO;

public class OrçamentoBO implements BaseInterBO <OrçamentoVO> {
	OrçamentoDAO dao = new OrçamentoDAO();
	
public OrçamentoVO adicionar(OrçamentoVO r) { //Recebe o vetor total de automoveis
	//peças e serviços e, com isso, vai adicionar peças e serviços para o veículo específico dito
		
	try {
		boolean existe = false;
		List<OrçamentoVO> rs = dao.listar();
		while (((ResultSet) rs).next()) {
			OrçamentoVO test = (OrçamentoVO) rs;
			if (r.getId() == test.getId()){
				existe = true;
			}
		}
		if (existe != false){
			throw new SQLException("Impossível cadastrar, pois já existe orçamento com este Id");
		}
		else {
			dao.inserir(r);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	/*OrçamentoVO r = new OrçamentoVO();
		ServiçoVO[] o = new ServiçoVO[10];
		float soma = 0;
		int k = 0;
		AutomovelBO met = new AutomovelBO();
		boolean v = false;
		String placa;
		String nome;
	
		System.out.println("ADICIONANDO NOVO ORÇAMENTO!\n");
	
			Scanner s = new Scanner(System.in);
			System.out.println("Digite a placa do automóvel o qual deseja montar o orçamento: ");
			placa = s.nextLine();
			
			for (int i = 0; i < a.length; i++) {
				if (placa.equals(a[i].getPlaca())) {
					System.out.println("O seu orçamento será direcionado ao seguinte veículo:\n");
					met.mostrarAutomovel(a[i]);
					r.setAutomoveis(a[i]);
					v = true;
					break;
				}
			}
			if (v != true) {
				System.out.println("Não foi possível encontrar o veículo para cadastrar o orçamento!\n");
			}
			v = false;
			
			s = new Scanner(System.in);
			System.out.println("Adicione uma peça ao orçamento!\nNome: ");
			nome = s.nextLine();
			for (int i = 0; i < peça.length; i++) {
				if (nome.equals(peça[i].getNome())) {
					System.out.println("A peça " + nome + " foi adicionada com o valor R$" + peça[i].getValor());
					o[k].setNome(peça[i].getNome());
					o[k].setValor(peça[i].getValor());
					k += 1;
					v = true;
					break;
				}
			}
			if (v != true) {
				System.out.println("Não foi possível encontrar a peça para cadastrar no orçamento!\n");
			}
			v = false;
			
			s = new Scanner(System.in);
			System.out.println("Adicione um serviço ao orçamento!\nNome: ");
			nome = s.nextLine();
			for (int i = 0; i < serviço.length; i++) {
				if (nome.equals(serviço[i].getNome())) {
					System.out.println("O serviço " + nome + " foi adicionado com o valor R$" + serviço[i].getValor());
					o[k].setNome(serviço[i].getNome());
					o[k].setValor(serviço[i].getValor());
					k =+ 1;
					v = true;
					break;
				}
			}
			if (v != true) {
				System.out.println("Não foi possível encontrar o serviço para cadastrar no orçamento!\n");
			}
			v = false;
			
			System.out.println("Orçamento adicionado!\n");
			for (int i = 0; i <= k; i++) {
					System.out.println("Item/Serviço: " + o[i].getNome());
					System.out.println("\nValor: " + o[i].getValor());
					System.out.println("\n");
					soma += o[i].getValor();
			}
			System.out.println("Valor total: R$" + soma);
			r.setServiços(o);
			r.setValor(soma);
			Calendar calendar = Calendar.getInstance(); 
			r.setData(calendar.getTime());
			r.setFinalizado(false);
			*/		
		return r;
}
	
	public OrçamentoVO alterar(OrçamentoVO o) { //Recebe um vetor de orçamentos, roda cada um deles para decidir qual
		
		o = dao.modificar(o);
		
		/*String d;
		
		System.out.println("ALTERANDO ORÇAMENTO!\n");
		
		for (int i = 0; i < o.length; i++) {
			System.out.println("Item/Serviço: " + o[i].getNome());
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
		*/
		return o;
	}

	public void deletar(OrçamentoVO a) { //Deleta um orçamento 
		
		dao.excluir(a);
		
		/*boolean t = false;
		String delete;
		AutomovelVO c = new AutomovelVO();
		
		System.out.println("DELETANDO ORÇAMENTO!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do automóvel com o orçamento a ser deletado: ");
		delete = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			c = a[i].getAutomoveis();
			if (delete.equals(c.getPlaca())) {
				for (int j = i; j < (a.length - 1); j++) {
					a[j] = a[j+1];
				}
				t = true;
				System.out.println("O último orçamento do " + c.getModelo() + " " + c.getCor() + " de placa " + delete + " foi deletado.\n");
				break;
			}
		}
		if (t != true) {
			System.out.println("Orçamento não encontrado!\n");
		}*/
		
	}
	
	/*public void mostrarOrçamento(OrçamentoVO a) { //Mostra um orçamento
		/*ServiçoVO[] r = new ServiçoVO[a.getServiços().length];
		r = a.getServiços();
		AutomovelBO met = new AutomovelBO();
		met.mostrarAutomovel(a.getAutomoveis());
		for (int i = 0; i < r.length; i++) {
			System.out.println("\nItem/Serviço: " + r[i].getNome());
			System.out.println("\nValor: R$" + r[i].getValor());
		}
		System.out.println("\nVALOR TOTAL: R$" + a.getValor());
		System.out.println("\nData: " + a.getData());
		if (a.getFinalizado() == true) {
			System.out.println("\nFinalizado\n");
		}
		else {
			System.out.println("\nNão finalizado\n");
		}
	}*/
	
	public OrçamentoVO pesquisar(OrçamentoVO a) { //Recebe um vetor de orçamentos, busca dentro dele os orçamentos relativos
		//à placa do veículo digitada e exibe eles
		
		a = dao.buscar(a);
		
		/*boolean t = false;
		String p;
		AutomovelVO r = new AutomovelVO();
		
		System.out.println("PESQUISANDO AUTOMÓVEL!\n");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do automóvel a ser pesquisado: ");
		p = s.nextLine();
		
		for (int i = 0; i < a.length; i++) {
			r = a[i].getAutomoveis();
			if (p.equals(r.getPlaca())) {
				mostrarOrçamento(a[i]);
				t = true;
				break;
			}
		}
		if (t != true) {
			System.out.println("Placa do automóvel não encontrada!\n");
		}*/
		
		return a;
	}

	
	/*public void pesquisarOrçamento(OrçamentoVO[] o, Date inicio, Date fim) { //Recebe um vetor de orçamentos e pesquisa um 
		//orçamento de acordo com a data de inicio e fim do periodo que deseja buscar
		/*boolean t = false;
		for (int i = 0; i < o.length; i++) {
			if (o[i].getData().after(inicio) && o[i].getData().before(fim)) {
				mostrarOrçamento(o[i]);
				t = true;
			}
		}
		if (t != true) {
			System.out.println("Não há orçamentos nesse período!");
		}
		
	}*/

	
}
