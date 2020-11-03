package VO;

public class Clientes {
	private String nome;
	private String endereço;
	private String cpf;
	private Automovel automoveis[];
	private Orçamento orçamento[];
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
		else {
			this.nome = nome;
		}
	}
	
	public String getEndereço() {
		return endereço;
	}
	
	public void setEndereço(String endereço) {
		if (endereço.length() == 0 || endereço.length() == 0) {
			System.out.println("Entrada inválida! Digite algo.");
		}
		else {
			this.endereço = endereço;
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if (cpf.length() < 14 || cpf.length() > 14) {
			System.out.println("Entrada de CPF inválida! Use o formato xxx.xxx.xxx-xx");
		}
		else {
			this.cpf = cpf;
		}
	}

	public Automovel[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel[] automoveis) {
		this.automoveis = automoveis;
	}
	
	public Orçamento[] getOrçamento() {
		return orçamento;
	}
	
	public void setOrçamento(Orçamento[] orçamento) {
		this.orçamento = orçamento;
	}
	
		
}