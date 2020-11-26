package VO;

import BO.AutomovelBO;
import BO.ClientesBO;
//import BO.FuncionárioBO

public class teste3 {

	public static void main(String[] args) {
		/*AutomovelVO c1 = new AutomovelVO();
		c1.setPlaca("RIO2A18");
		System.out.println(c1.getPlaca());
		ClientesVO c2 = new ClientesVO();
		c2.setCpf("713.423.434-76");
		System.out.println(c2.getCpf());
		c2.setNome(null);
		System.out.println(c2.getNome());*/
		
		/*FuncionárioVO[] func = new FuncionárioVO[10];
		FuncionárioBO met = new FuncionárioBO();
		func[0] = met.cadastrarFuncionario();
		System.out.println(func[0].getUsuario());
		
		met.fazerLogin(func);*/
		
		ClientesVO[] c = new ClientesVO[3];
		ClientesBO cmet = new ClientesBO();
		AutomovelBO amet = new AutomovelBO();
		//c[0] = cmet.adicionarCliente(c[0]);
		//c[1] = cmet.adicionarCliente(c[1]);
		//c[2] = cmet.adicionarCliente(c[2]);
		//cmet.deletarCliente(c);
		//cmet.alterarCliente(c[0]);
		//cmet.pesquisarCliente(c);
		
		//amet.adicionarAutomovel(c);
		//amet.alterarAutomovel(c[0].getAutomoveis()); !!! Dúvida de como acessar vetor dentro de um vetor
		//amet.deletarAutomovel(c[0].getAutomoveis());
		//amet.pesquisarAutomovel(c[0].getAutomoveis());
		
	}

}
