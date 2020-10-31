package VO;

public class Clientes {
	String nome;
	String endereço;
	String cpf;
	Automovel automoveis[];
	Orçamentos orçamento[];
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public String getEndereço() {
		return endereço;
	}
	
	public void setEndereço(String endereço) {
		this.endereço = endereço;
		if (endereço.length() == 0 || endereço.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
		if (cpf.length() < 14 || cpf.length() > 14) {
			System.out.println("Entrada de CPF inválida! Use o formato xxx.xxx.xxx-xx");
		}
	}

	public Automovel[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel[] automoveis) {
		this.automoveis = automoveis;
	}
	
	
	
	/*
	
	public Orçamentos[] getOrçamento() {
		return orçamento;
	}
	
	public void setOrçamento(Orçamentos[] orçamento) {
		this.orçamento = orçamento;
	}*/
	
		
}