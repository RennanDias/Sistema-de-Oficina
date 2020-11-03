package VO;

public class Clientes {
	private String nome;
	private String endere�o;
	private String cpf;
	private Automovel automoveis[];
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() == 0 || nome == null) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.nome = nome;
		}
	}
	
	public String getEndere�o() {
		return endere�o;
	}
	
	public void setEndere�o(String endere�o) {
		if (endere�o.length() == 0 || endere�o == null) {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
		else {
			this.endere�o = endere�o;
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if (cpf.length() < 14 || cpf.length() > 14 || cpf == null) {
			System.out.println("Entrada de CPF inv�lida! Use o formato xxx.xxx.xxx-xx");
		}
		else {
			this.cpf = cpf;
		}
	}

	public Automovel[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel[] automoveis) {
		if (automoveis == null) {
			System.out.println("Nada encontrado! Adicione um autom�vel a este cliente!");
		}
		else {
			this.automoveis = automoveis;
		}
	}
	
		
}