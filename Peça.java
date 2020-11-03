package VO;
public class Peça {
	private String nome;
	private float preço;
	private String fabricante;
	private Automovel automoveis[];
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome.length() == 0 || nome == null) {
			System.out.println("Entrada inválida! Digite algo.");
		}
		else {
			this.nome = nome;
		}
	}
	
	public float getPreço() {
		return preço;
	}
	
	public void setPreço(float preço) {
		if (this.preço < 0) {
			System.out.println("Entrada inválida! Digite um valor positivo!");
		}
		else {
			this.preço = preço;
		}	
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		if (fabricante.length() == 0 || fabricante == null) {
			System.out.println("Entrada inválida! Digite algo.");
		}
		else {
			this.fabricante = fabricante;
		}
	}
	
	public Automovel[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(Automovel[] automoveis) {
		if (automoveis == null) {
			System.out.println("Nada encontrado! Adicione um automóvel a este cliente!");
		}
		else {
			this.automoveis = automoveis;
		}
	}
	
	
}
