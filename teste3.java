package VO;

public class teste3 {

	public static void main(String[] args) {
		Automovel c1 = new Automovel();
		c1.setPlaca("RIO2A18");
		System.out.println(c1.getPlaca());
		Clientes c2 = new Clientes();
		c2.setCpf("713.423.434-76");
		System.out.println(c2.getCpf());
		c2.setNome(null);
		System.out.println(c2.getNome());
	}

}
