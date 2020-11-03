package VO;

public class Orçamento {
	private Peça peças;
	private Serviço serviços;
	private float valor;
	private Automovel automoveis;
	
	public Peça getPeças() {
		return peças;
	}
	
	public void setPeças(Peça peças) {
		this.peças = peças;
	}
	
	public Serviço getServiços() {
		return serviços;
	}
	
	public void setServiços(Serviço serviços) {
		this.serviços = serviços;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		if (valor < 0) {
			System.out.println("Entrada inválida! Digite um valor positivo!");
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
