package VO;

import BO.Funcion�rioBO;

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
		
		Funcion�rioVO[] func = new Funcion�rioVO[10];
		Funcion�rioBO met = new Funcion�rioBO();
		func[0] = met.cadastrarFuncionario();
		System.out.println(func[0].getUsuario());
		
		met.fazerLogin(func);
		
	}

}
