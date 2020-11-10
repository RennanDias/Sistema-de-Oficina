package VO;
public class PeçaVO {
	private String nome;
	private float preço;
	private String fabricante;
	private AutomovelVO automoveis[];
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null) {
			if (nome.length() == 0) {
				System.out.println("Entrada inválida! Digite algo.");
			}
			else {
				this.nome = nome;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite algo.");
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
		if (fabricante != null) {
			if (fabricante.length() == 0) {
				System.out.println("Entrada inválida! Digite algo.");
			}
			else {
				this.fabricante = fabricante;
			}
		}
		else {
			System.out.println("Entrada inválida! Digite algo.");
		}
	}
	
	public AutomovelVO[] getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(AutomovelVO[] automoveis) {
		if (automoveis != null) {
			this.automoveis = automoveis;
		}
		else {
			System.out.println("Nada encontrado! Adicione um automóvel a este cliente!");
		}
	}
	
}
