package VO;

public class Or�amentoVO {
	private Pe�aVO pe�as;
	private Servi�oVO servi�os;
	private float valor;
	private AutomovelVO automoveis;
	
	public Pe�aVO getPe�as() {
		return pe�as;
	}
	
	public void setPe�as(Pe�aVO pe�as) {
		this.pe�as = pe�as;
	}
	
	public Servi�oVO getServi�os() {
		return servi�os;
	}
	
	public void setServi�os(Servi�oVO servi�os) {
		this.servi�os = servi�os;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		if (valor < 0) {
			System.out.println("Entrada inv�lida! Digite um valor positivo!");
		}
		else {
			this.valor = valor;
		}
	}
	
	public AutomovelVO getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(AutomovelVO automoveis) {
		this.automoveis = automoveis;
	}
	
}
