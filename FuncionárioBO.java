package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DAO.Funcion�rioDAO;
import VO.Funcion�rioVO;
import VO.Or�amentoVO;

public class Funcion�rioBO {
	Funcion�rioDAO dao = new Funcion�rioDAO();
	public Funcion�rioVO cadastrarFuncionario(Funcion�rioVO func) { //Cadastra um funcion�rio recebendo seus atributos relacionados � classe Funcion�rioVO
		//e depois retorna o funcion�rio cadastrado
		
		try {
			boolean existe = false;
			List<Funcion�rioVO> rs = dao.listar();
			while (((ResultSet) rs).next()) {
				Funcion�rioVO test = (Funcion�rioVO) rs;
				if (func.getCpf() == test.getCpf()){
					existe = true;
				}
			}
			if (existe != false){
				throw new SQLException("Imposs�vel cadastrar, pois j� existe funcion�rio com este CPF");
			}
			else {
				dao.inserir(func);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*Funcion�rioVO func = new Funcion�rioVO();
		
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
		func.setSenha(s.next());*/
		
		return func;
	}
	
	public boolean fazerLogin (Funcion�rioVO funcionario) { //Busca, dentro do vetor de funcion�rios, o funcion�rio que possui login e senha
		//iguais aos digitados no programa e, por fim, avisa se foi ou n�o logado com sucesso
		//ResultSet funcrs = dao.buscar(funcionario);
		return dao.fazerLogin(funcionario);
		
		/*boolean v = false;
		
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
		}*/
	}
	
	public void gerarRelatorios(Or�amentoVO inicio, Or�amentoVO fim) { //Recebe o vetor de or�amentos, a data de in�cio e fim
		//do per�odo que deseja gerar relat�rios e por fim, mostra todos eles com deus valores
		/*Or�amentoBO met = new Or�amentoBO();
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
		}*/	
	}
	
	public Or�amentoVO finalizarOr�amento(Or�amentoVO o) { //V� se o or�amento est� finalizado ou n�o. Se estiver, diz que j� est�
		//finalizado, se n�o, finaliza e emite uma nota
		
		dao.confirmarOr�amento(o);
		
		/*if (o.getFinalizado() != true) {
			o.setFinalizado(true);
			System.out.println("Or�amento finalizado!");
		}
		else {
			System.out.println("O presente or�amento j� est� finalizado!");
		}*/
		return o;
	}
	
}
