package VO;

import java.util.Date;

public class Or�amentoVO {
	private Servi�oVO[] servi�os;
	private float valor;
	private AutomovelVO automoveis;
	private Date data;
	private boolean finalizado;
	private Long id;
	
	public boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Servi�oVO[] getServi�os() {
		return servi�os;
	}
	
	public void setServi�os(Servi�oVO[] servi�os) {
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
			this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}