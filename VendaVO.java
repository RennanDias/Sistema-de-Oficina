package VO;

public class VendaVO {
	//private Pe�aVO p;
	//private Servi�oVO s;
	private Or�amentoVO o;
	private String nome;
	private float valor;
	private int quantidade;
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if (quantidade >= 1) {
			this.quantidade = quantidade;
		}
		else {
			System.out.println("Quantidade n�o pode ser menor ou igual a zero!");
		}
	}
	
	/*public Servi�oVO getS() {
		return s;
	}
	
	public void setS(Servi�oVO s) {
		this.s = s;
	}
	
	public Pe�aVO getP() {
		return p;
	}
	
	public void setP(Pe�aVO p) {
		this.p = p;
	}*/

	public Or�amentoVO getO() {
		return o;
	}

	public void setO(Or�amentoVO o) {
		this.o = o;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		if (valor >= 0) {
			this.valor = valor;
		}
		else {
			System.out.println("Entrada inv�lida! Valor n�o pode ser negativo.");
		}
	}
}
