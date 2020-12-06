package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.FuncionárioDAO;
import VO.FuncionárioVO;
import VO.OrçamentoVO;

public class FuncionárioBO {
	FuncionárioDAO dao = new FuncionárioDAO();
	public FuncionárioVO cadastrarFuncionario(FuncionárioVO func) { //Cadastra um funcionário recebendo seus atributos relacionados à classe FuncionárioVO
		//e depois retorna o funcionário cadastrado
		
		try {
			boolean existe = false;
			List<FuncionárioVO> rs = dao.listar();
			while (((ResultSet) rs).next()) {
				FuncionárioVO test = (FuncionárioVO) rs;
				if (func.getCpf() == test.getCpf()){
					existe = true;
				}
			}
			if (existe != false){
				throw new SQLException("Impossível cadastrar, pois já existe funcionário com este CPF");
			}
			else {
				dao.inserir(func);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*FuncionárioVO func = new FuncionárioVO();
		
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
		func.setSenha(s.next());*/
		
		return func;
	}
	
	public boolean fazerLogin (FuncionárioVO funcionario) { //Busca, dentro do vetor de funcionários, o funcionário que possui login e senha
		//iguais aos digitados no programa e, por fim, avisa se foi ou não logado com sucesso
		//ResultSet funcrs = dao.buscar(funcionario);
		return dao.fazerLogin(funcionario);
		
		/*boolean v = false;
		
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
		}*/
	}
	
	public void gerarRelatorios(OrçamentoVO inicio, OrçamentoVO fim) { //Recebe o vetor de orçamentos, a data de início e fim
		//do período que deseja gerar relatórios e por fim, mostra todos eles com deus valores
		/*OrçamentoBO met = new OrçamentoBO();
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
		}*/	
	}
	
	public OrçamentoVO finalizarOrçamento(OrçamentoVO o) { //Vê se o orçamento está finalizado ou não. Se estiver, diz que já está
		//finalizado, se não, finaliza e emite uma nota
		
		dao.confirmarOrçamento(o);
		
		/*if (o.getFinalizado() != true) {
			o.setFinalizado(true);
			System.out.println("Orçamento finalizado!");
		}
		else {
			System.out.println("O presente orçamento já está finalizado!");
		}*/
		return o;
	}
	
}
