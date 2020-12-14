package VO;

public class VendaVO {
	//private PeçaVO p;
	//private ServiçoVO s;
	private OrçamentoVO o;
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
			System.out.println("Quantidade não pode ser menor ou igual a zero!");
		}
	}
	
	/*public ServiçoVO getS() {
		return s;
	}
	
	public void setS(ServiçoVO s) {
		this.s = s;
	}
	
	public PeçaVO getP() {
		return p;
	}
	
	public void setP(PeçaVO p) {
		this.p = p;
	}*/

	public OrçamentoVO getO() {
		return o;
	}

	public void setO(OrçamentoVO o) {
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
			System.out.println("Entrada inválida! Digite algo.");
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
			System.out.println("Entrada inválida! Valor não pode ser negativo.");
		}
	}
}
