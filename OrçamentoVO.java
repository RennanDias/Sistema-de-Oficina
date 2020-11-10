package VO;

public class OrçamentoVO {
	private PeçaVO peças;
	private ServiçoVO serviços;
	private float valor;
	private AutomovelVO automoveis;
	
	public PeçaVO getPeças() {
		return peças;
	}
	
	public void setPeças(PeçaVO peças) {
		this.peças = peças;
	}
	
	public ServiçoVO getServiços() {
		return serviços;
	}
	
	public void setServiços(ServiçoVO serviços) {
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
	
	public AutomovelVO getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(AutomovelVO automoveis) {
		this.automoveis = automoveis;
	}
	
}
