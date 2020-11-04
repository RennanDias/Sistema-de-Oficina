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
		if (nome != null) {
			if (nome.length() == 0) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.nome = nome;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getEndere�o() {
		return endere�o;
	}
	
	public void setEndere�o(String endere�o) {
		if (endere�o != null) {
			if (endere�o.length() == 0) {
				System.out.println("Entrada inv�lida! Digite algo.");
			}
			else {
				this.endere�o = endere�o;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if (cpf != null) {
			if (cpf.length() < 14 || cpf.length() > 14 || !cpf.substring(0, 3).matches("[1-9]*") || !cpf.substring(3, 4).matches("[.]*") ||
					!cpf.substring(4, 7).matches("[1-9]*")	|| !cpf.substring(7, 8).matches("[.]*") || !cpf.substring(8, 11).matches("[1-9]*") || !cpf.substring(11, 12).matches("[-]*")
					|| !cpf.substring(12, 14).matches("[1-9]*")) {
				System.out.println("Entrada de CPF inv�lida! Use o formato xxx.xxx.xxx-xx");
			}
			else {
				this.cpf = cpf;
			}
		}
		else {
			System.out.println("Entrada inv�lida! Digite algo.");
		}
	}

	public Automovel[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel[] automoveis) {
		if (automoveis != null) {
			this.automoveis = automoveis;
		}
		else {
			System.out.println("Nada encontrado! Adicione um autom�vel a este cliente!");
		}
	}
	
		
}