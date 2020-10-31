package VO;

public class Clientes {
	String nome;
	String endere�o;
	String cpf;
	Automovel automoveis[];
	Or�amentos or�amento[];
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		if (nome.length() == 0 || nome.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getEndere�o() {
		return endere�o;
	}
	
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
		if (endere�o.length() == 0 || endere�o.length() == 0) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
		if (cpf.length() < 14 || cpf.length() > 14) {
			System.out.println("Entrada de CPF inv�lida! Use o formato xxx.xxx.xxx-xx");
		}
	}

	public Automovel[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel[] automoveis) {
		this.automoveis = automoveis;
	}
	
	
	
	/*
	
	public Or�amentos[] getOr�amento() {
		return or�amento;
	}
	
	public void setOr�amento(Or�amentos[] or�amento) {
		this.or�amento = or�amento;
	}*/
	
		
}