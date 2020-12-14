package VO;

import java.util.Date;

//import javafx.collections.ObservableList;

public class OrçamentoVO {
	private ServiçoVO[] serviços;
	private float valor;
	private AutomovelVO automoveis;
	private Date data;
	private boolean finalizado;
	private Long id;
	private VendaVO venda;
	
	//public OrçamentoVO(ObservableList<OrçamentoVO> o) {
		
	//}
	
	public boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public ServiçoVO[] getServiços() {
		return serviços;
	}
	
	public void setServiços(ServiçoVO[] serviços) {
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

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
			this.data = (date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VendaVO getVenda() {
		return venda;
	}

	public void setVenda(VendaVO venda) {
		this.venda = venda;
	}	
}