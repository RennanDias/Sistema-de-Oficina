package VO;

import BO.FuncionárioBO;

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
		
		FuncionárioVO[] func = new FuncionárioVO[10];
		FuncionárioBO met = new FuncionárioBO();
		func[0] = met.cadastrarFuncionario();
		System.out.println(func[0].getUsuario());
		
		met.fazerLogin(func);
		
	}

}
