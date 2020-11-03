package VO;

public class Or�amento {
	private Pe�a pe�as;
	private Servi�o servi�os;
	private float valor;
	private Automovel automoveis;
	
	public Pe�a getPe�as() {
		return pe�as;
	}
	
	public void setPe�as(Pe�a pe�as) {
		this.pe�as = pe�as;
	}
	
	public Servi�o getServi�os() {
		return servi�os;
	}
	
	public void setServi�os(Servi�o servi�os) {
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
	
	public Automovel getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel automoveis) {
		this.automoveis = automoveis;
	}
	
}
